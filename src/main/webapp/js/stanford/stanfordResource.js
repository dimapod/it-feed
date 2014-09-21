'use strict';

angular.module('itrade').factory('stanfordResource', function ($http) {

    var sentiment = function(request) {
        return $http.post('rest/stanford/sentiment', request);
    };

    return {
        sentiment: sentiment
    };
});
