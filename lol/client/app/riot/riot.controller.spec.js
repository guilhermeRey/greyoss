'use strict';

describe('Controller: RiotCtrl', function () {

  // load the controller's module
  beforeEach(module('lolApp'));

  var RiotCtrl, scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RiotCtrl = $controller('RiotCtrl', {
      $scope: scope
    });
  }));

  it('should ...', function () {
    expect(1).toEqual(1);
  });
});
