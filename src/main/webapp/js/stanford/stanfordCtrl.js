'use strict';

angular.module('itrade').controller('stanfordCtrl', function ($scope, stanfordResource) {
    $scope.sentimentRequest = { text: "Another plus is the little bits of humor placed here and there, which, when done right, is always a plus. Some of the best shows/movies are ones in which one minute you are sitting on the edge of your seat biting your nails and the next you are laughing at some irony or funny statement/joke a character has said." };

    $scope.submitRequest = function() {

        stanfordResource.sentiment($scope.sentimentRequest).then(function(response) {
            if (response && response.data && response.data.message) {
                $scope.sentimentResult = response.data;
            } else {
                throw new Error('Result is null...');
            }
        });
    };

});
