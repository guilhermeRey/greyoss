'use strict';

var LocalStorageDb = function () {
  this.context = '';
  this.seq = 1;

  this.key = function (keyname) {
    return [this.context, keyname || this.seq++].join('.');
  };
};

LocalStorageDb.prototype.save = function (keyName, obj) {
  localStorage.setItem(this.key(keyName), obj);
  return this;
};

LocalStorageDb.prototype.dbcontext = function (contextName) {
  this.context = contextName;
  return this;
};

LocalStorageDb.prototype.select = function (keyName) {
  return localStorage.getItem(this.key(keyName));
}

var App = {
  DB: {
    _instance: null,
    instance: function () {
       if (App.DB._instance === null) {
         App.DB._instance = new LocalStorageDb();
       }

       return App.DB._instance;
    }
  }
};

var Riot = {
  Api: function (config) {
    var me = this;
    this.url = 'https://br.api.pvp.net/api/lol/';
    this.globalUrl = 'https://global.api.pvp.net/api/lol/';
    this.config = {
      key: config.key,
      version : config.version || 'v1.2',
      region: config.region || 'br'
    };

    this.build = function (path, params, context) {
      var _url = (context && context == 'global' ? this.globalUrl : this.url) + path
                         .replace('{region}',  this.config.region)
                         .replace('{version}', this.config.version)
                         .replace('{path}', path);

      params = params || {};
      params['api_key'] = this.config.key;

      var request_params = [];
      for (var name in params) {
        request_params.push(name + '=' + params[name]);
      }

      return _url + '?' + request_params.join('&');
    };

    this.summoner = {
      byName: function (params) {
        return me.build('{region}/v1.4/summoner/by-name/' + params.names)
      },
      recent: function (id) {
        return me.build('{region}/v1.3/game/by-summoner/' + id + '/recent');
      },
      stats: function (id) {
        return me.build('{region}/v1.3/stats/by-summoner/' + id + '/summary');
      }
    };

    this.champion = function (params) {
      var auxParams = {};
      if (params && params.id) {
        for (var paramName in params) {
          if (paramName != 'id')
            auxParams[paramName] = params[paramName];
        }

        return this.build('static-data/{region}/{version}/champion/' + params.id, auxParams, 'global')
      }

      return this.build('{region}/{version}/champion', params, 'normal');
    };
  }

};

angular.module('lolApp')
  .controller('RiotCtrl', function ($scope, $http, $q) {
    var api = new Riot.Api({
      key: '9bb95c2c-6d74-4b3b-911b-9fda01efc0db',
      region: 'br'
    });

    $scope.DB = App.DB.instance();
    $scope.DB.dbcontext('Riot.LoL');
    $scope.searchFreeToPlay = false;
    $scope.summonerByName = 'yarquen';

    $scope.searchSummoners = function () {
      $scope.candidataSummoners = [];
      $http.get(api.summoner.byName({
        names: $scope.summonerByName
      }))
      .success(function (data) {
          $scope.candidateSummoners = data;
      });
    };

    $scope.selectSummoner = function (summoner) {
      $scope.summoner = summoner;
      $http.get(api.summoner.recent(summoner.id))
           .success(function (data) {
             $scope.summoner.recent = data;
           });

      $http.get(api.summoner.stats(summoner.id))
           .success(function (data) {
             $scope.summoner.stats = data;
           });
    };

    $scope.init = function () {
      $scope.loadChampions();
    };

    $scope.filteredChampions = function (champs) {
      var champions = [];
      for (var id in champs) {
        if (!$scope.searchFreeToPlay || ($scope.searchFreeToPlay && champs[id].freeToPlay))
          champions.push(champs[id]);
      }
      return champions;
    };

    $scope.loadChampions = function () {
      $scope.champions = [];

      var localStorageChampions = $scope.DB.select('champions');
      if (localStorageChampions) {
        console.log('loaded from local storage');
        $scope.champions = JSON.parse(localStorageChampions);
        return;
      }

      var championsRequests = [];
      $http.get(api.champion()).success(function (data) {
          $scope.champions = {};

          for (var i = 0; i < data.champions.length; i++) {
            var paramsId = {
              id: data.champions[i].id,
              champData: 'all'
            };
            $scope.champions[data.champions[i].id] =  data.champions[i];
            championsRequests.push(api.champion(paramsId));
          }

          $q.all(championsRequests.map(function (request) {
            return $http.get(request);
          }))
          .then(function (champions) {
            for (var i = 0; i < champions.length; i++) {
              $scope.champions[champions[i].data.id].data = champions[i].data;
            }
            $scope.DB.save('champions', JSON.stringify($scope.champions));
          });
        });
    };
});
