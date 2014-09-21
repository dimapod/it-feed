'use strict';

angular.module('itrade').controller('entitiesCtrl', function ($scope, alchemyResource) {
    $scope.entitiesRequest = { text: "Roy Thomas Fielding (born 1965) is an American computer scientist, one of the principal authors of the HTTP specification, an authority on computer network architecture and co-founder of the Apache HTTP Server project." };

    $scope.submitEntitiesRequest = function() {

        alchemyResource.entities($scope.entitiesRequest).then(function(response) {
            if (response && response.data && response.data.message) {
                $scope.entitiesResult = response.data.message;
            } else {
                throw new Error('Result is null...');
            }
        });
    };

});
