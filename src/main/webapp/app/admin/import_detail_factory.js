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
 * Factory for ImportDetailRequest
 */



authenticationModule.factory('ImportDetailRequest', ['$http', 'restURL', function ($http, restURL) {


	 var baseUrl = restURL + '/invMgmt';
    
    return {
        getAll: function () {
        	
            return $http.get(baseUrl + "/importDetails");
        },
        create: function (importDetail) {

            return $http.post(baseUrl + "/importDetail", importDetail);
        },
        update: function (importDetail) {

            return $http.put(baseUrl + "/importDetail", importDetail);
        },
        search: function (importDetail) {

            return $http.post(baseUrl + "/search", importDetail);
        }
    };
    
    return $this;

}]);
