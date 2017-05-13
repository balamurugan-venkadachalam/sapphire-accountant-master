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
 * Factory for ProductRequest
 */



authenticationModule.factory('ProductRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/products");
        },
        create: function (product) {

            return $http.post(baseUrl + "/product", product);
        },
        update: function (product) {

            return $http.put(baseUrl + "/product", product);
        }
        
    };
    
    return $this;

}]);
