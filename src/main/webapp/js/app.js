'use strict';

angular.module('itrade', [
    'ui.router',
    'notifications',
    'ecom.exceptionHandler',
    'ecom.httpRequestTracker'
])

    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/alchemy");
        $stateProvider
            .state('alchemy', {
                url: "/alchemy",
                templateUrl: "js/alchemy/entities.tpl.html"
            })

            .state('stanford', {
                url: "/stanford",
                templateUrl: "js/stanford/stanford.tpl.html"
            });

    });



