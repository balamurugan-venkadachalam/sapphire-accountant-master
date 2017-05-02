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
 * Factory for PackRequest
 */



authenticationModule.factory('PackRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/admin';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/packs");
        },
        create: function (pack) {

            return $http.post(baseUrl + "/pack", pack);
        },
        update: function (pack) {

            return $http.put(baseUrl + "/pack", pack);
        }
    };
    
    return $this;

}]);
