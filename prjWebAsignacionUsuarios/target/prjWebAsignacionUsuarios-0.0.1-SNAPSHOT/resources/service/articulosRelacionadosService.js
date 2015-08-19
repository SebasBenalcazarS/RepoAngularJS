angular.module('asignacionUsuarios').factory('articulosRelacionadosService', ['$http','$q' , function ($http, $q) {
	'use strict';	
	
	var ArticulosRelacionadosDataService = {
		getDataRelacionada : getDataRelacionada,
		desagregarArticulos : desagregarArticulos
		
	};
	
	function getDataRelacionada(urlService){
		var deferred = $q.defer();
		$http.get(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar la informacion'});
				});
		return deferred.promise;
	}
	
function desagregarArticulos(urlService, _usuarioSesion, _codigoCompania, _codigoArticulo, _usuario){
		
		var deferred = $q.defer();
		//"use strict";
		$http.post(urlService, {usuarioSesion:_usuarioSesion, codigoCompania:_codigoCompania, codigoArticulo:_codigoArticulo, usuario: _usuario}).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al en la llamada al ws'});
				});
		return deferred.promise;
	}
	
	return ArticulosRelacionadosDataService;
}]);