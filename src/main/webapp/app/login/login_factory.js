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
 * Factory for Authentication
 */


/**
authenticationModule.factory('AuthenticationRequest', ['$http', 'restURL', function ($http, restURL) {

    // REST Service URL to manage Authentication
    var authURL = restURL + '/auth';

    return {
        getAuthenticate: function (credentials) {
            return $http.post(authURL + "/officerLogin", credentials);
        }
    };

}]);
**/
authenticationModule.factory('AuthenticationRequest', ['$http', 'restURL', function ($http, restURL) {

    // REST Service URL to manage Authentication
   // var restURL = "http://localhost:8080/spring4/service";
    var authURL = restURL + '/login';

    return {
    		getAuthenticate: function (credential) {
    			//return $http.post(authURL, credential);
    			
    		return $http({
    			    method: 'POST',
    			    url: authURL,
    			    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
    			    transformRequest: function(obj) {
    			        var str = [];
    			        for(var p in obj)
    			        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
    			        return str.join("&");
    			    },
    			    data: {username: credential.username, password: credential.password}
    			})
    		}
    };

}]);