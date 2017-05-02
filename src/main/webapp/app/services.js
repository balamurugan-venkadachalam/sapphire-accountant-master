'use strict';

/* Services */
//'ngResource', 'ngCookies'
var myAppServices = angular.module('myApp.services', []);

// Demonstrate how to register services
// In this case it is a simple value service.
myAppServices.value('version', '0.1');

// Base URL for REST Services on the Spring MVC webapp
myAppServices.value('restURL', 'http://localhost:8080/spring4/service');
