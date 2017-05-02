'use strict';

var authenticationModule = angular.module('myApp.country', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/country', {
    templateUrl: 'partials/admin/country/country_origin.html',
    controller: 'CountryCtrl'
  });
  
   
  
}]);


authenticationModule.controller('CountryCtrl', [ 'CountryRequest','$scope',  'MessageHandler', '$uibModal',
    function(CountryRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.countrys = null;
	 
	 $scope.loadCountrys = function(){
         try {
             $scope.requests = [];
             CountryRequest.getAll().then(
                     function (success) {
                         $scope.countrys = success.data;
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.updateCountry = function(country){
         try {
             $scope.requests = [];
             CountryRequest.update(country).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Country Updated Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createCountry = function(country){
         try {
             $scope.requests = [];
             CountryRequest.create(country).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Country Created Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.opencountryForm = function(country){
         var modalInstance = $uibModal.open({
             templateUrl: 'countryForm.html',
             controller: countryFormctrl,
             size: '',
             resolve: {country: function () {
                     return country;
                 },
                 mode: function () {
                     return {create: country === null, update: country !== null};
                 }}

         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createCountry(result.country);
             if (result.mode.update)
                 $scope.updateCountry(result.country);
         }, function () {
         });
		 
	 };
     

	 $scope.loadCountrys();
}]);


var countryFormctrl= function($scope, $uibModalInstance, country, mode) {
    if (mode.create)
    	country = {isActive: 1};
    $scope.country = country;
    $scope.mode = mode;
    
    $scope.submit = function (country) {
    	$uibModalInstance.close({country: country, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
}