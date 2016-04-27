'use strict';

/**
 * @ngdoc function
 * @name functionalJsApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the functionalJsApp
 */
angular.module('functionalJsApp')
  .controller('MainCtrl', function () {
    this.feiticos = [
      {nome:'smite',lvl:6,use:100},
      {nome:'heal',lvl:1,use:50}
    ];

    this.spells = this.feiticos.map(function (m) { return m.nome; });
  });
