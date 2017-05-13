'use strict';

var productModule = angular.module('myApp.product', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

productModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/product', {
    templateUrl: 'partials/admin/product/product.html',
    controller: 'ProductCtrl'
  });
  
   
  
}]);


productModule.controller('ProductCtrl', [ 'ProductRequest', 'CategoryRequest','$scope',  'MessageHandler', '$uibModal',
    function(ProductRequest, CategoryRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.products = null; 
	 
	 $scope.loadProducts = function(){
         try {
             $scope.requests = [];
             ProductRequest.getAll().then(
                     function (success) {
                         $scope.products = success.data;
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.updateProduct = function(product){
         try {
             $scope.requests = [];
             ProductRequest.update(product).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Product Updated Succesfuly');
                    	 $scope.loadProducts();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createProduct = function(product){
         try {
             $scope.requests = [];
             ProductRequest.create(product).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Product Created Succesfuly');
                    	 $scope.loadProducts();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.openProductForm = function(product){
		 
         var modalInstance = $uibModal.open({
             templateUrl: 'productForm.html',
             controller: productFormctrl,
             size: '',
             resolve: {product: function () {
                     return product;
                 },
                 mode: function () {
                     return {create: product === null, update: product !== null};
                 }}
         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createProduct(result.product);
             if (result.mode.update)
                 $scope.updateProduct(result.product);
         }, function () {
         });
		 
	 };
     

	 $scope.loadProducts();
}]);


var productFormctrl= function($scope, $uibModalInstance, product, mode, CategoryRequest, MessageHandler) {
    if (mode.create)
    	product = {isActive: 1};
    $scope.product = product;
    $scope.mode = mode;

    
    var categories = null;
	 
	 $scope.loadCategories = function(){
	   try {
	       $scope.requests = [];
	       CategoryRequest.getAll().then(
	               function (success) {
	            	   $scope.categories = success.data;
	               },
	               MessageHandler.manageError);
	   } catch (ex) {
	       MessageHandler.manageException(ex);
	   }
	 };
	 
	 $scope.loadCategories();
       
    $scope.submit = function (product) {
    	$uibModalInstance.close({product: product, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
    
   
}