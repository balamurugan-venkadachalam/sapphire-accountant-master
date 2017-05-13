'use strict';

var authenticationModule = angular.module('myApp.customer', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/customer', {
    templateUrl: 'partials/admin/customer/customer.html',
    controller: 'CustomerCtrl'
  });
  
   
  
}]);


authenticationModule.controller('CustomerCtrl', [ 'CustomerRequest','$scope',  'MessageHandler', '$uibModal',
    function(CustomerRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.customers = null;
	 
	 $scope.loadCustomers = function(){
         try {
             $scope.requests = [];
             CustomerRequest.getAll().then(
                     function (success) {
                         $scope.customers = success.data;
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.updateCustomer = function(customer){
         try {
             $scope.requests = [];
             CustomerRequest.update(customer).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Customer Updated Succesfuly');
                    	 $scope.loadCustomers();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createCustomer = function(customer){
         try {
             $scope.requests = [];
             CustomerRequest.create(customer).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Customer Created Succesfuly');
                    	 $scope.loadCustomers();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.openCustomerForm = function(customer){
         var modalInstance = $uibModal.open({
             templateUrl: 'customerForm.html',
             controller: customerFormctrl,
             size: '',
             resolve: {customer: function () {
                     return customer;
                 },
                 mode: function () {
                     return {create: customer === null, update: customer !== null};
                 }}

         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createCustomer(result.customer);
             if (result.mode.update)
                 $scope.updateCustomer(result.customer);
         }, function () {
         });
		 
	 };
     

	 $scope.loadCustomers();
}]);


var customerFormctrl= function($scope, $uibModalInstance, customer, mode) {
    if (mode.create)
    	customer = {isActive: 1};
 
    $scope.customer = customer;
    $scope.mode = mode;
    
    $scope.submit = function (customer) {
    	$uibModalInstance.close({customer: customer, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
}