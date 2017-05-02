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
 * Factory for CountryRequest
 */



authenticationModule.factory('CountryRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/countrys");
        },
        create: function (country) {

            return $http.post(baseUrl + "/country", country);
        },
        update: function (country) {

            return $http.put(baseUrl + "/country", country);
        }
    };
    
    return $this;

}]);
