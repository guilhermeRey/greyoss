'use strict';

angular.module('lolApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('riot', {
        url: '/riot',
        templateUrl: 'app/riot/riot.html',
        controller: 'RiotCtrl'
      });
  });