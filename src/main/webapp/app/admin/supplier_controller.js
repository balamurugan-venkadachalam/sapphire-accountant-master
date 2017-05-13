'use strict';

var authenticationModule = angular.module('myApp.supplier', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/supplier', {
    templateUrl: 'partials/admin/supplier/supplier.html',
    controller: 'SupplierCtrl'
  });
  
   
  
}]);


authenticationModule.controller('SupplierCtrl', [ 'SupplierRequest','$scope',  'MessageHandler', '$uibModal',
    function(SupplierRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.suppliers = null;
	 
	 $scope.loadSuppliers = function(){
         try {
             $scope.requests = [];
             SupplierRequest.getAll().then(
                     function (success) {
                         $scope.suppliers = success.data;
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.updateSupplier = function(supplier){
         try {
             $scope.requests = [];
             SupplierRequest.update(supplier).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Supplier Updated Succesfuly');
                    	 $scope.loadSuppliers();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createSupplier = function(supplier){
         try {
             $scope.requests = [];
             SupplierRequest.create(supplier).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Supplier Created Succesfuly');
                    	 $scope.loadSuppliers();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.openSupplierForm = function(supplier){
         var modalInstance = $uibModal.open({
             templateUrl: 'supplierForm.html',
             controller: supplierFormctrl,
             size: '',
             resolve: {supplier: function () {
                     return supplier;
                 },
                 mode: function () {
                     return {create: supplier === null, update: supplier !== null};
                 }}

         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createSupplier(result.supplier);
             if (result.mode.update)
                 $scope.updateSupplier(result.supplier);
         }, function () {
         });
		 
	 };
     

	 $scope.loadSuppliers();
}]);


var supplierFormctrl= function($scope, $uibModalInstance, supplier, mode) {
    if (mode.create)
    	supplier = {isActive: 1};
 
    $scope.supplier = supplier;
    $scope.mode = mode;
    
    $scope.submit = function (supplier) {
    	$uibModalInstance.close({supplier: supplier, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
}