/**
 * Created by geethu on 06-04-2017.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

/**
 * Factory for SupplierRequest
 */



authenticationModule.factory('SupplierRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/suppliers");
        },
        create: function (supplier) {

            return $http.post(baseUrl + "/supplier", supplier);
        },
        update: function (supplier) {

            return $http.put(baseUrl + "/supplier", supplier);
        }
    };
    
    return $this;

}]);
