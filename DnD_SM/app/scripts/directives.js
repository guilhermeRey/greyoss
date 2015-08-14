/**
 * INSPINIA - Responsive Admin Theme
 * Copyright 2015 Webapplayers.com
 *
 */


/**
 * pageTitle - Directive for set Page title - mata title
 */
function pageTitle($rootScope, $timeout) {
    return {
        link: function(scope, element) {
            var listener = function(event, toState, toParams, fromState, fromParams) {
                // Default title - load on Dashboard 1
                var title = 'D&D DM Shield';
                // Create your own title pattern
                if (toState.data && toState.data.pageTitle) title = 'INSPINIA | ' + toState.data.pageTitle;
                $timeout(function() {
                    element.text(title);
                });
            };
            $rootScope.$on('$stateChangeStart', listener);
        }
    }
};

/**
 * sideNavigation - Directive for run metsiMenu on sidebar navigation
 */
function sideNavigation($timeout) {
    return {
        restrict: 'A',
        link: function(scope, element) {
            // Call the metsiMenu plugin and plug it to sidebar navigation
            $timeout(function(){
                element.metisMenu();
            });
        }
    };
};

/**
 * iboxTools - Directive for iBox tools elements in right corner of ibox
 */
function iboxTools($timeout) {
    return {
        restrict: 'A',
        scope: true,
        templateUrl: 'views/common/ibox_tools.html',
        controller: function ($scope, $element) {
            // Function for collapse ibox
            $scope.showhide = function () {
                var ibox = $element.closest('div.ibox');
                var icon = $element.find('i:first');
                var content = ibox.find('div.ibox-content');
                content.slideToggle(200);
                // Toggle icon from up to down
                icon.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
                ibox.toggleClass('').toggleClass('border-bottom');
                $timeout(function () {
                    ibox.resize();
                    ibox.find('[id^=map-]').resize();
                }, 50);
            },
                // Function for close ibox
                $scope.closebox = function () {
                    var ibox = $element.closest('div.ibox');
                    ibox.remove();
                }
        }
    };
};

/**
 * minimalizaSidebar - Directive for minimalize sidebar
 */
function minimalizaSidebar($timeout) {
    return {
        restrict: 'A',
        template: '<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="" ng-click="minimalize()"><i class="fa fa-bars"></i></a>',
        controller: function ($scope, $element) {
            $scope.minimalize = function () {
                $("body").toggleClass("mini-navbar");
                if (!$('body').hasClass('mini-navbar') || $('body').hasClass('body-small')) {
                    // Hide menu in order to smoothly turn on when maximize menu
                    $('#side-menu').hide();
                    // For smoothly turn on menu
                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(500);
                        }, 100);
                } else if ($('body').hasClass('fixed-sidebar')){
                    $('#side-menu').hide();
                    setTimeout(
                        function () {
                            $('#side-menu').fadeIn(500);
                        }, 300);
                } else {
                    // Remove all inline style from jquery fadeIn function to reset menu state
                    $('#side-menu').removeAttr('style');
                }
            }
        }
    };
};

function watchPosition($timeout) {
    return {
        link: function(scope, element) {
            scope.$watch(function() {
                return {
                  top: element.css('top'),
                  left: element.css('left')
                }
            },
            function(newValue) {
              console.log(newValue);
              scope.scene.current.grid = {
                 top: element.css('top')
               }
            });
        }
    };
};



/**
 *
 * Pass all functions into module
 */
angular
    .module('inspinia')
    .factory('uuid', function() {
        var svc = {
            new: function() {
                function _p8(s) {
                    var p = (Math.random().toString(16)+"000000000").substr(2,8);
                    return s ? "-" + p.substr(0,4) + "-" + p.substr(4,4) : p ;
                }
                return _p8() + _p8(true) + _p8(true) + _p8();
            },

            empty: function() {
              return '00000000-0000-0000-0000-000000000000';
            }
        };

        return svc;
    })
    .directive('pageTitle', pageTitle)
    .directive('sideNavigation', sideNavigation)
    .directive('iboxTools', iboxTools)
    .directive('minimalizaSidebar', minimalizaSidebar)
    .directive('lvlDraggable', ['$rootScope', 'uuid', function($rootScope, uuid) {
        return {
            restrict: 'A',
            link: function(scope, el, attrs, controller) {
                console.log("linking draggable element");

                angular.element(el).attr("draggable", "true");
                var id = attrs.id;
                if (!attrs.id) {
                    id = uuid.new()
                    angular.element(el).attr("id", id);
                }

                el.bind("dragstart", function(e) {
                    e.dataTransfer.setData('text', id);

                    $rootScope.$emit("LVL-DRAG-START");
                });

                el.bind("dragend", function(e) {
                    $rootScope.$emit("LVL-DRAG-END");
                });
            }
        }
    }])
    .directive('lvlDropTarget', ['$rootScope', 'uuid', function($rootScope, uuid) {
        return {
            restrict: 'A',
            scope: {
                onDrop: '&'
            },
            link: function(scope, el, attrs, controller) {
                var id = attrs.id;
                if (!attrs.id) {
                    id = uuid.new()
                    angular.element(el).attr("id", id);
                }

                el.bind("dragover", function(e) {
                  if (e.preventDefault) {
                    e.preventDefault(); // Necessary. Allows us to drop.
                  }

                  e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.
                  return false;
                });

                el.bind("dragenter", function(e) {
                  // this / e.target is the current hover target.
                  angular.element(e.target).addClass('lvl-over');
                });

                el.bind("dragleave", function(e) {
                  angular.element(e.target).removeClass('lvl-over');  // this / e.target is previous target element.
                });

                el.bind("drop", function(e) {

                  if (e.preventDefault) {
                    e.preventDefault(); // Necessary. Allows us to drop.
                  }

                  if (e.stopPropogation) {
                    e.stopPropogation(); // Necessary. Allows us to drop.
                  }
                  var data = e.dataTransfer.getData("text");
                  var dest = document.getElementById(id);
                  var src = document.getElementById(data);

                  scope.onDrop({ dragEl: data, dropEl: id });
                });

                $rootScope.$on("LVL-DRAG-START", function() {
                    var el = document.getElementById(id);
                    angular.element(el).addClass("lvl-target");
                });

                $rootScope.$on("LVL-DRAG-END", function() {
                    var el = document.getElementById(id);
                    angular.element(el).removeClass("lvl-target");
                    angular.element(el).removeClass("lvl-over");
                });
            }
        }
    }])
