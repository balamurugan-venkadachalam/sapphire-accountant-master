'use strict';

var authenticationModule = angular.module('myApp.imgDet', ['myApp']);

//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/importDetail', {
    templateUrl: 'partials/admin/inventory/import_detail.html',
    controller: 'ImportDetCtrl'
  })
  
  .when('/search', {
	    templateUrl: 'partials/admin/inventory/search.html',
	    controller: 'SearchCtrl'
	  });
   
  
}]);


authenticationModule.controller('ImportDetCtrl', [ 'ImportDetailRequest','CategoryRequest','CountryRequest','ProductRequest','PackRequest', 'SupplierRequest', '$scope',  'MessageHandler', '$uibModal',
    function(ImportDetailRequest, CategoryRequest, CountryRequest, ProductRequest, PackRequest, SupplierRequest, $scope,  MessageHandler, $uibModal) {
	
	$scope.importDetail = null;
	
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

	 $scope.loadCategories();
	 
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
	 
	 $scope.loadProducts();
	 
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
	 
	 $scope.loadCountrys();
	 
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
	 
	 $scope.loadPacks();
	 
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
	 
	 $scope.loadSuppliers();
	 
	 $scope.createImportDetail = function(importDetail){
         try {
             $scope.requests = [];
             ImportDetailRequest.create(importDetail).then(
                     function (success) {
                    	 MessageHandler.addSuccess('PurchaseOrder Created Succesfuly');
                     },
                     MessageHandler.manageError);
         } catch (ex) {
             MessageHandler.manageException(ex);
             MessageHandler.addSuccess('PurchaseOrder error');
         }
	 };
	 
	 
	$scope.calUnitPrice = function(){
       	 $scope.importDetail.unitPrice =  (Number($scope.importDetail.price || 0)  / Number($scope.importDetail.packPieces || 0)).toFixed(2);
       	$scope.importDetail.unitSellingPrice = ( Number($scope.importDetail.unitPrice) + (Number($scope.importDetail.unitPrice)  * 20 /100 ) ).toFixed(2) ;
   };
   
	$scope.calUnitWeight = function(){
      	 $scope.importDetail.pieceWeight =  (Number($scope.importDetail.weight || 0)  / Number($scope.importDetail.packPieces || 0)).toFixed(2);
  };
	 
}]);



authenticationModule.controller('SearchCtrl', [ 'ImportDetailRequest','CategoryRequest','CountryRequest','ProductRequest','PackRequest','$scope',  'MessageHandler', '$uibModal',
    function(ImportDetailRequest, CategoryRequest, CountryRequest, ProductRequest, PackRequest, $scope,  MessageHandler, $uibModal) {
	$scope.today = function() {
	    $scope.dt = new Date();
	  };
	  $scope.today();

	  $scope.clear = function() {
	    $scope.dt = null;
	  };

	  $scope.inlineOptions = {
	    customClass: getDayClass,
	    minDate: new Date(),
	    showWeeks: true
	  };

	  $scope.dateOptions = {
	    dateDisabled: disabled,
	    formatYear: 'yy',
	    maxDate: new Date(2020, 5, 22),
	    minDate: new Date(),
	    startingDay: 1
	  };

	  // Disable weekend selection
	  function disabled(data) {
	    var date = data.date,
	      mode = data.mode;
	    return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	  }

	  $scope.toggleMin = function() {
	    $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
	    $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	  };

	  $scope.toggleMin();

	  $scope.open1 = function() {
	    $scope.popup1.opened = true;
	  };

	  $scope.open2 = function() {
	    $scope.popup2.opened = true;
	  };

	  $scope.setDate = function(year, month, day) {
	    $scope.dt = new Date(year, month, day);
	  };

	  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
	  $scope.format = $scope.formats[0];
	  $scope.altInputFormats = ['M!/d!/yyyy'];

	  $scope.popup1 = {
	    opened: false
	  };

	  $scope.popup2 = {
	    opened: false
	  };
	  
	  function getDayClass(data) {
		    var date = data.date,
		      mode = data.mode;
		    if (mode === 'day') {
		      var dayToCheck = new Date(date).setHours(0,0,0,0);

		      for (var i = 0; i < $scope.events.length; i++) {
		        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

		        if (dayToCheck === currentDay) {
		          return $scope.events[i].status;
		        }
		      }
		    }

		    return '';
		  }
	  
}]);
