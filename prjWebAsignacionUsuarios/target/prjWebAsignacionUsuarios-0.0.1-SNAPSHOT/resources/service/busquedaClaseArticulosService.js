angular.module('asignacionUsuarios').factory('busquedaClaseArticulosService', ['$http','$q' , function ($http, $q) {
	'use strict';
	
	var busquedaClaseArticulosService = {
		getClaseArticulos : getClaseArticulos
	};
	
	function getClaseArticulos(urlService){
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
	
	return busquedaClaseArticulosService;
}]);