'use strict';
/**
 * Angular JS calling order
 * 1. app.config()
 * 2. app.run()
 * 3. directive's compile functions (if they are found in the dom)
 * 4. app.controller()
 * 5. directive's link functions (again, if found)
 */


// Declare app level module which depends on views, and components
// Messge handler is used to show warn, error, info message
var app = angular.module('myApp', [
    'ngRoute'
    , 'ngCookies'
    , 'myApp.login'
    , 'myApp.category'
    , 'myApp.pack'
    , 'myApp.product'
    , 'myApp.country'
    , 'myApp.supplier'
    , 'myApp.imgDet'
    , 'myApp.invoice'
    , 'myApp.customer'
    , 'messageHandler.module'
    , 'myApp.services'
    , 'ui.bootstrap'
    , 'angularCSS'
    , 'angularUtils.directives.dirPagination'
]);


// Configuration
app.config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.otherwise({redirectTo: '/login'});
        
   $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
            return {
                'request': function (config) {
                    var isRestCall = config.url.indexOf('service') == 0;
                    if (angular.isDefined($rootScope.authToken_inv)) {
                        var authToken_Ladvice = $rootScope.authToken_Ladvice;
                        if (true) {
                            config.headers['JSESSIONID'] = authToken_inv;
                        } else {
                            config.url = config.url + "?JSESSIONID=" + authToken_inv;
                        }
                    }
                    return config || $q.when(config);
                }
            };
        }
    );
        
 }]);



// Global Functions
app.run(function($rootScope, $cookieStore, $location) {
	
	
	
	 $rootScope.$on('$routeChangeStart', function (event) {
		 var user = $rootScope.user;
		/* if (user === undefined) {
		        $location.path("/login");
		        $rootScope.refPage = '#/login';
		}*/
	 });
	
	
	  
	  $rootScope.clearSession = function() {
		    console.log('clearSession');
	  }
	  
	  $rootScope.setCookiee = function(cookie) {
		    console.log('setCookiee' + cookie);
	  }
	  
	});


//Custom Directive
app.directive('pname', function(){
	return {
		restrict : "E",
		template :"Inventory Mgmt"
	};	
});

app.directive('pversion', function(){
	return {
		restrict : "E",
		template :"1.0"
	};	
});

app.directive('restrictTo', function() {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var re = RegExp(attrs.restrictTo);
            var exclude = /Backspace|Enter|Tab|Delete|Del|ArrowUp|Up|ArrowDown|Down|ArrowLeft|Left|ArrowRight|Right/;

            element[0].addEventListener('keydown', function(event) {
                if (!exclude.test(event.key) && !re.test(event.key)) {
                    event.preventDefault();
                }
            });
        }
    }
});