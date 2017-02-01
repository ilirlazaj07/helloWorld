var angular;
var helloWorldCtrls = angular.module('helloWorld.controllers', []);


helloWorldCtrls.controller('MainCtrl', ['$scope', function ($scope) {
    }]);

helloWorldCtrls.controller('ListaCtrl', ['$timeout', '$scope', '$http', '$log', 'CorsiService', 'InsertCorsoService', 'ModifyCorsoService',
    function ($timeout, $scope, $http, $log, CorsiService, InsertCorsoService, ModifyCorsoService) {

        $scope.status = "KO";

        $scope.corsoInMod = {
            id: '',
            nome: '',
            dettaglio: ''
        };

        caricaCorsi();

        function showPleaseWait() {
            $('#memberModal').modal('show');
        }
        ;
        function showPleaseWait2() {
            $('#memberModalMod').modal('show');
        }
        ;

        function hidePleaseWait() {
            $('#memberModal').modal('hide');
            $('#memberModalMod').modal('hide');
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

        $scope.inModifica = function (corso) {
            $scope.corsoInMod.id = corso.id;
            $scope.corsoInMod.nome = corso.nome;
            $scope.corsoInMod.dettaglio = corso.dettaglio;
            console.log('In modifica ' + $scope.corsoInMod.id);
            showPleaseWait2();
        };

        $scope.annulla = function (corso) {
            if (corso !== undefined) {
                corso.nome = "";
                corso.dettaglio = "";
            }
            hidePleaseWait();
        };

        $scope.inserisciCorso = function (corso) {
            InsertCorsoService.insertCorso(corso).then(function () {
                caricaCorsi();
                hidePleaseWait();
                corso.nome = "";
                corso.dettaglio = "";
            }).catch(function () {
                $log.error('');
            });
        };

        $scope.modificaCorso = function () {
            ModifyCorsoService.modificaCorso($scope.corsoInMod).then(function () {
                caricaCorsi();
                hidePleaseWait();
            }).catch(function () {
                $log.error('');
            });
        };

    }]);

;