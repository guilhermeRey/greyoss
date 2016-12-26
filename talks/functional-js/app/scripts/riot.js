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
