angular.module('asignacionUsuarios').factory('clasificacionRelacionadaUsuarioService', ['$http','$q' , function ($http, $q) {
	"use strict";
	
	var busquedaFuncionariosDataService = {
		getData : getData
	};
	
	function getData(urlService){
		
		var deferred = $q.defer();
		
		$http.get(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar las variables'});
				});
		return deferred.promise;
	}
	
	return busquedaFuncionariosDataService;
}]);