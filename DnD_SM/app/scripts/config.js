/**
 * INSPINIA - Responsive Admin Theme
 * Copyright 2014 Webapplayers.com
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written stat for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index/main");

    $stateProvider
        .state('pc', {
            url: '/pc',
            templateUrl: 'views/common/raw.html'
        })
        .state('pc.scene', {
          url: '/realtime',
          templateUrl: 'views/pcscene.html',
          controller: SceneCtrl
        })
        .state('index', {
            abstract: true,
            url: "/index",
            templateUrl: "views/common/content.html",
        })
        .state('index.main', {
            url: "/main",
            templateUrl: "views/main.html",
            data: { pageTitle: 'Example view' }
        })
        .state('index.adventure', {
            url: "/adventure?id",
            templateUrl: "views/adventure.html",
            controller: AdventureCtrl
        })
        .state('index.scene', {
          url: '/scene?id',
          templateUrl: 'views/scene.html',
          controller: SceneController
        })
}
angular
    .module('inspinia')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
