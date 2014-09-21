'use strict';

angular.module('itrade').factory('alchemyResource', function ($http) {

    var entities = function(entitiesRequest) {
        return $http.post('rest/alchemy/entities', entitiesRequest);
    };

    return {
        entities: entities
    };
});
