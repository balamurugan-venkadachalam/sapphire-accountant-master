'use strict';

var authenticationModule = angular.module('myApp.category', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/category', {
    templateUrl: 'partials/admin/category/category.html',
    controller: 'CategoryCtrl'
  });
  
   
  
}]);


authenticationModule.controller('CategoryCtrl', [ 'CategoryRequest','$scope',  'MessageHandler', '$uibModal',
    function(CategoryRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.categories = null;
	 
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
	 
	 $scope.updateCategory = function(category){
         try {
             $scope.requests = [];
             CategoryRequest.update(category).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Category Updated Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createCategory = function(category){
         try {
             $scope.requests = [];
             CategoryRequest.create(category).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Category Created Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.openCategoryForm = function(category){
         var modalInstance = $uibModal.open({
             templateUrl: 'categoryForm.html',
             controller: categoryFormctrl,
             size: '',
             resolve: {category: function () {
                     return category;
                 },
                 mode: function () {
                     return {create: category === null, update: category !== null};
                 }}

         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createCategory(result.category);
             if (result.mode.update)
                 $scope.updateCategory(result.category);
         }, function () {
         });
		 
	 };
     

	 $scope.loadCategories();
}]);


var categoryFormctrl= function($scope, $uibModalInstance, category, mode) {
    if (mode.create)
    	category = {isActive: 1};
 
    $scope.category = category;
    $scope.mode = mode;
    
    $scope.submit = function (category) {
    	$uibModalInstance.close({category: category, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
}