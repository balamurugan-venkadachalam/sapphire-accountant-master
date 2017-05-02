'use strict';

var authenticationModule = angular.module('myApp.pack', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/pack', {
    templateUrl: 'partials/admin/pack/pack.html',
    controller: 'PackCtrl'
  });
  
   
  
}]);


authenticationModule.controller('PackCtrl', [ 'PackRequest','$scope',  'MessageHandler', '$uibModal',
    function(PackRequest, $scope,  MessageHandler, $uibModal) {
	 $scope.packs = null;
	 
	 $scope.loadPacks = function(){
         try {
             $scope.requests = [];
             PackRequest.getAll().then(
                     function (success) {
                         $scope.packs = success.data;
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.updatePack = function(pack){
         try {
             $scope.requests = [];
             PackRequest.update(pack).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Pack Updated Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.createPack = function(pack){
         try {
             $scope.requests = [];
             PackRequest.create(pack).then(
                     function (success) {
                    	 MessageHandler.addSuccess('Pack Created Succesfuly');
                    	 $scope.loadCategories();
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
         }
	 };
	 
	 $scope.openPackForm = function(pack){
         var modalInstance = $uibModal.open({
             templateUrl: 'packForm.html',
             controller: packFormctrl,
             size: '',
             resolve: {pack: function () {
                     return pack;
                 },
                 mode: function () {
                     return {create: pack === null, update: pack !== null};
                 }}

         });
         
         modalInstance.result.then(function (result) {
             
             if (result.mode.create)
                 $scope.createPack(result.pack);
             if (result.mode.update)
                 $scope.updatePack(result.pack);
         }, function () {
         });
		 
	 };
     

	 $scope.loadPacks();
}]);


var packFormctrl= function($scope, $uibModalInstance, pack, mode) {
    if (mode.create)
    	pack = {isActive: 1};
    $scope.pack = pack;
    $scope.mode = mode;
    
    $scope.submit = function (pack) {
    	$uibModalInstance.close({pack: pack, mode: mode})
    };
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };
}