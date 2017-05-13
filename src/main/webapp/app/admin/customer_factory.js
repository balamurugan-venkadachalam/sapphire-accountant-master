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
 * Factory for CustomerRequest
 */



authenticationModule.factory('CustomerRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/customers");
        },
        create: function (customer) {

            return $http.post(baseUrl + "/customer", customer);
        },
        update: function (customer) {

            return $http.put(baseUrl + "/customer", customer);
        }
    };
    
    return $this;

}]);
