'use strict';

/**
 * Module for messages
 */
var messageHandler = angular.module('messageHandler.module', []);

/**
 * Factory for messages handler
 */
messageHandler.factory('MessageHandler', ['$rootScope', '$timeout', function ($rootScope, $timeout) {

        // message
        $rootScope.message = {};
        // successful messages
        $rootScope.message.successs = [];
        // Wanr messages
        $rootScope.message.warns = [];
        // error messages
        $rootScope.message.errors = [];
        // server error messages
        $rootScope.message.serverErrors = [];

        var $this = {};

        /**
         * Clean all messages
         */
        $this.cleanMessage = function () {
            $rootScope.message.successs = [];
            $rootScope.message.warns = [];
            $rootScope.message.errors = [];
            $rootScope.message.serverErrors = [];
        };

        /**
         * Add a successful message
         */
        $this.addSuccess = function (success, values) {
            $this.cleanMessage();
            var messageValues = $this.getMessageValues(values);
            $rootScope.message.successs.push({message: success, values: messageValues});
            $timeout($this.cleanMessage, 3000);
        };
        /**
         * Add a Warn message
         */
        $this.addWarn = function (warn, values) {
            $this.cleanMessage();
            var messageValues = $this.getMessageValues(values);
            $rootScope.message.warns.push({message: warn, values: messageValues});
            $timeout($this.cleanMessage, 3000);
        };

        /**
         * Add an error message
         */
        $this.addError = function (error, values) {
            $this.cleanMessage();
            var messageValues = $this.getMessageValues(values);
            $rootScope.message.errors.push({message: error, values: messageValues});
            $timeout($this.cleanMessage, 3000);
        };

        /**
         * Add a server error message (no translate)
         */
        $this.addServerError = function (serverError) {
            $rootScope.message.serverErrors.push(serverError);
        };

        /**
         * Define message values
         * @param values array
         * @return values map
         */
        $this.getMessageValues = function (values) {
            var errorValues = {};
            if (values != null) {
                if (values instanceof Array) {
                    for (var i = 0; i < values.length; i++) {
                        errorValues['a' + i] = values[i];
                    }
                } else {
                    errorValues['a0'] = values;
                }
            }
            return errorValues;
        };

        /**
         * Manage the error
         */
        $this.manageError = function (http) {
            if (http.status === 404) {
                if (http.data == null || http.data === "") {
                    $this.addError('server.not.responding', baseURL);
                } else {
                    $this.addError('Invalid URL : ', [http.config.url]);
                }
            } else if (http.status === 400) {
                if (http.data == null) {
                    $this.addError('Bad URL : ', [http.config.url]);
                } else {
                    $this.addServerError(http.data);
                }
            } else if (http.status === 401) {
//                if (http.data == null) {
//                    $this.addWarn('Invalid Session');
//                } else {
//                    $this.addWarn('Invalid Session');
//                }
            } else {
                if (http.data != null && http.data !== "") {
                    $this.addServerError(http.data);
                }
            }
            $timeout($this.cleanMessage, 3000);
        };

        /**
         * Manage the exception
         */
        $this.manageException = function (error) {
            $this.addError(error);
        };

        // Return message handler
        return $this;
    }]);
