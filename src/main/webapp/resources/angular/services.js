var angular;
var helloWorldFakt = angular.module('helloWorld.factories', []);


helloWorldFakt.factory('CorsiService', function ($http, $q) {
    var corsi = function () {

        var defer = $q.defer();
        $http.get('ws/corsi/').then(function (response) {
            defer.resolve(response.data);
        }, function (response) {
            defer.reject(response);
        });
        return defer.promise;
    };

    return {
        getCorsi: corsi
    };

});

helloWorldFakt.factory('InsertCorsoService', function($http, $q) {
	var out = function(corso) {
		var defered = $q.defer();
		$http.post('ws/corsi/inserisci', corso).then(function(response) {
			defered.resolve(response.data);
		}, function(response) {
			defered.reject(response);
		});
		return defered.promise;
	};

	return {
		insertCorso : out
	};
});

helloWorldFakt.factory('ModifyCorsoService', function($http, $q) {
	var out = function(corso) {
		var defered = $q.defer();
		$http.put('ws/corsi/modifica', corso).then(function(response) {
			defered.resolve(response.data);
		}, function(response) {
			defered.reject(response);
		});
		return defered.promise;
	};

	return {
		modificaCorso : out
	};
});


