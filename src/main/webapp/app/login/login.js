'use strict';

var authenticationModule = angular.module('myApp.login', ['myApp']);



//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/login', {
    templateUrl: 'partials/public/login/login.html',
    controller: 'LoginCtrl'
  })
  .when('/adminHome', {
	    templateUrl: 'partials/admin/home.html',
	    controller: 'LoginCtrl'
	  });
  
  
  
  
}]);



//
authenticationModule.controller('LoginCtrl', [ 'AuthenticationRequest','$scope', '$rootScope', '$routeParams', '$location', '$cookieStore', 'MessageHandler', '$timeout',
      function(AuthenticationRequest, $scope, $rootScope, $routeParams, $location, $cookieStore, MessageHandler,  $timeout) {

        $scope.authenticate = function (cred) {
          try {
            AuthenticationRequest.getAuthenticate(cred).then(function (success) {
              $rootScope.authToken_inv = success.data.token;
              $rootScope.user= success.data;
              $cookieStore.put('authToken_inv', success.data.token);
              $location.path('/adminHome');
            //  window.location.reload();
            }, function (http) {
              if (http.status === 401) {
                if (http.data == null) {
                  MessageHandler.addWarn('Invalid Session');
                  console.log('Invalid Session');
                 // $location.path('/');
                } else {
                	
                  MessageHandler.addWarn('login.invalid');
                  console.log('login.invalid');
                 // $location.path('/home');
                }
              }
            });

          } catch (ex) {
                console.log(ex);
            MessageHandler.manageException(ex);
          }

        };

}]);