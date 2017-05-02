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
 * Factory for CategoryRequest
 */



authenticationModule.factory('CategoryRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/categories");
        },
        create: function (category) {

            return $http.post(baseUrl + "/category", category);
        },
        update: function (category) {

            return $http.put(baseUrl + "/category", category);
        }
    };
    
    return $this;

}]);
