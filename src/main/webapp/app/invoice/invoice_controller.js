'use strict';

var authenticationModule = angular.module('myApp.invoice', ['myApp']);



//angular.module('myApp.login', ['ngRoute'])

authenticationModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/invoice', {
    templateUrl: 'partials/admin/invoice/invoice.html',
    controller: 'InvoiceCtrl'
  })
    .when('/invoicep', {
    templateUrl: 'partials/public/invoice/invoice.html',
    controller: 'InvoiceCtrl'
  });
  
  
   
  
}]);


authenticationModule.controller('InvoiceCtrl', [ '$scope',  'MessageHandler', '$uibModal',
    function( $scope,  MessageHandler, $uibModal) {
	
	//var items = [{sno:1, category:"", hscode:"", description:"", coo:"", boe:"", weight:"", pack:"", qty:0, cost:0, total:0 }];	
	var items = []; 
	
	 $scope.currencySymbol = 'AED';
	 
	 $scope.invoice = {};	 
	 var customer = {};
	 var company = {};
	 
	 $scope.invoice.items = items;
	 
	 $scope.invoice.invoiceNo = 10;
	 
	 customer.name ="Dummy Customer Name";
	 customer.address1 ="Dummy address one";
	 customer.address2 ="Dummy address Two";
	 customer.address3 ="Dummy address Three";
	 $scope.invoice.customer = customer;
	 
	 company.name ="Company NameS";
	 company.address1 ="Dummy address one";
	 company.address2 ="Dummy address two";
	 company.address3 ="Dummy address three";
	 $scope.invoice.company = company;
	 
	  // Adds an item to the invoice's items
//	  $scope.addItem = function() {
	  //qty:0, cost:0, description:""
//	    $scope.invoice.items.push({ sno:1, category:"", hscode:"", description:"", coo:"", boe:"", weight:"", pack:"", qty:0, cost:0, total:0 });
//	  }
	  
	  // Adds an item to the invoice's items
	  $scope.addItem = function(porder) {
	  //qty:0, cost:0, description:""
	    $scope.invoice.items.push({ sno:1, category:porder.category.categoryName, hscode:porder.grnCode, description:porder.product.productName, 
	    	coo:porder.country.cntryCode, boe:"", weight:porder.weight, pack:porder.pack.packName, qty:1, cost:porder.unitPrice, total:0 });
	  }
	  
	  
	  // Remotes an item from the invoice
	  $scope.removeItem = function(item) {
	    $scope.invoice.items.splice($scope.invoice.items.indexOf(item), 1);
	  };

	  
	  // Calculates the sub total of the invoice
	  $scope.invoiceSubTotal = function() {
	    var total = 0.00;
	    angular.forEach($scope.invoice.items, function(item, key){
	      total += (item.qty * item.cost);
	    });
	    return total;
	  };
	  
	  // Calculates the tax of the invoice
	  $scope.calculateTax = function() {
	    return (($scope.invoice.tax * $scope.invoiceSubTotal())/100);
	  };
	  
	  // Calculates the grand total of the invoice
	  $scope.calculateGrandTotal = function() {

	    return $scope.calculateTax() + $scope.invoiceSubTotal();
	  };
	  
	  // Adds an item to the invoice's items
	  $scope.addItemForm = function(){
	         var modalInstance = $uibModal.open({
	             templateUrl: 'invoiceForm.html',
	             controller: invoiceFormctrl,
	             size: ''
	         });
	         
	         modalInstance.result.then(function (result) {
	        	 console.log("porder " + result.porder);
	        	 $scope.addItem(result.porder);
	
	         }, function () {
	         });
			 
		 };

	 
}]);


var invoiceFormctrl= function($scope, $uibModalInstance, ImportDetailRequest, MessageHandler) {

    $scope.grnCode = 'A100';
    $scope.importDetail = {};
    
    $scope.search = function () {   
	    	try {
	    		
	    		$scope.purchaseOrders = {};
	    		
		    	console.log("grnCode " + $scope.grnCode);
		    	$scope.importDetail.grnCode = $scope.grnCode;
		    	
		    	ImportDetailRequest.search($scope.importDetail).then(
	                    function (success) {
	                    	$scope.purchaseOrders =  success.data;	
	                    	console.log("data  " + success.data);
			                },
			                MessageHandler.manageError);
			    } catch (ex) {
			    	console.log("manageException  " + ex);
			        MessageHandler.manageException(ex);
			    }
    };
    
    $scope.submit = function (porder) {
    	console.log("submit");
    	$uibModalInstance.close({porder: porder})
    };
    
    
    $scope.cancle = function () {
        $uibModalInstance.dismiss('cancel');
    };

}