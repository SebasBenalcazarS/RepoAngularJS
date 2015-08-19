angular.module('asignacionUsuarios').factory('articulosNoRelacionadosService', ['$http','$q' , function ($http, $q) {
	
	
	var articulosNoRelacionadaDataService = {
		getDataNoRelacionada : getDataNoRelacionada,
		setArticulosNoRelacionados : setArticulosNoRelacionados

	};
	
	function getDataNoRelacionada(urlService){
		var deferred = $q.defer();
		"use strict";
		
		$http(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar la informacion'});
				});
		return deferred.promise;
	}
	function getSizeDataNoRelacionada(urlService){
		var deferred = $q.defer();
		"use strict";
		
		$http(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar la informacion'});
				});
		return deferred.promise;
	}
	
	function setArticulosNoRelacionados(urlService, _usuarioSesion, _codigoCompania, _codigoArticulo, _usuario){
		
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
	
	return articulosNoRelacionadaDataService;
}]);