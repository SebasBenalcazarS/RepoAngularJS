angular.module('asignacionUsuarios').factory('obtenerUsuarioSesionService', ['$http','$q' , function ($http, $q) {
	
	var obtenerUsuarioSesionService = {
		getUsuarioSesion : getUsuarioSesion
	};
	
	function getUsuarioSesion(urlService){
		
		var deferred = $q.defer();
		"use strict";
		$http.get(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar las variables'});
				});
		return deferred.promise;
	}
	
	return obtenerUsuarioSesionService;
}]);