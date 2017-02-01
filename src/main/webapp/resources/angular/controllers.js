var angular;
var helloWorldCtrls = angular.module('helloWorld.controllers', []);


helloWorldCtrls.controller('MainCtrl', ['$scope', function ($scope) {
    }]);

helloWorldCtrls.controller('ListaCtrl', ['$timeout', '$scope', '$http', '$log', 'CorsiService', 'InsertCorsoService',
    function ($timeout, $scope, $http, $log, CorsiService, InsertCorsoService) {

        $scope.status = "KO";

        caricaCorsi();

        function showPleaseWait() {
            $('#memberModal').modal('show');
        }
        ;

        function hidePleaseWait() {
            $('#memberModal').modal('hide');
        }

        $scope.corsi = [];

        $scope.eliminaCorso = function (corso) {
            $http.delete('ws/corsi/cancella/' + corso.id);
            setTimeout(function () {
                caricaCorsi();
            }, 400);
        };

        function caricaCorsi() {
            CorsiService.getCorsi().then(function (data) {
                $scope.corsi = data;
                hidePleaseWait();
            }).catch(function () {
                $log.error('');
            });
        }
        ;

        $scope.inserisci = function () {
            showPleaseWait();
        };

        $scope.annulla = function (corso) {
            hidePleaseWait();
            corso.nome = "";
            corso.dettaglio = "";
        };

        $scope.inserisciCorso = function (corso) {
            InsertCorsoService.insertCorso(corso).then(function () {
                    caricaCorsi();
                    hidePleaseWait();
            }).catch(function () {
                $log.error('');
            });
        };

    }]);

;