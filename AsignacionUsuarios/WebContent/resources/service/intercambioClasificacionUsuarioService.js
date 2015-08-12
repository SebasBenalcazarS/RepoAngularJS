angular.module('asignacionUsuarios').factory('intercambioClasificacionUsuarioService', ['$http','$q' , function ($http, $q) {
	'use strict';
	
	var intercambioClasificacionDataService = {
		setIntercambioClasificacionesFuncionario : setIntercambioClasificacionesFuncionario
	};
	
	function setIntercambioClasificacionesFuncionario(datos){
		
		var deferred = $q.defer();
		"use strict";
		$http(datos).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar las variables'});
				});
		return deferred.promise;
	}
	
	return intercambioClasificacionDataService;
}]);