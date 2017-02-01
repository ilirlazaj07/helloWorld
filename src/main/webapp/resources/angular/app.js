angular.module('helloWorld', ['ngResource', 'ngAnimate', 'ngMdIcons', 'ui.bootstrap', 'ui.router', 'helloWorld.factories', 'helloWorld.controllers'])
        .config(['$urlRouterProvider', '$stateProvider', '$provide',
            function ($urlRouterProvider, $stateProvider, $provide) {
                $urlRouterProvider.otherwise('/');
                $stateProvider.state('home', {
                    abstract: true,
                    template: '<div ui-view></div>'
                }).state('home.lista', {
                    url: '/',
                    templateUrl: 'resources/temp/lista_flussi.html',
                    params: {
                        data: undefined,
                        correlationObj: {
                            prima: undefined,
                            dopo: undefined,
                            filtro: undefined,
                            nrPaginazione: undefined,
                            mode: undefined
                        }
                    }
                });

             

                $provide.decorator('$log', ['$delegate', function $logDecorator($delegate) {
                        var erroreOriginale = $delegate.error;
                        $delegate.error = function decoratedError(msg) {
                            var adesso = new Date();
                            msg = 'Connessione al API non riuscita | Data:  ' + adesso + ' . ' + msg;
                            erroreOriginale.apply($delegate, arguments);
                        };
                        return $delegate;
                    }]);

            }]);