angular.module('asignacionUsuarios').factory('clasificacionNoRelacionadaUsuarioService', ['$http','$q' , function ($http, $q) {
	'use strict';
	
	var clasificacionNoRelacionadaDataService = {
		getData : getData,
		setClasificacionNoRelacionada : setClasificacionNoRelacionada
	};
	
	function getData(urlService){
		var deferred = $q.defer();
		
		$http.get(urlService).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar la informaci�n'});
				});
		return deferred.promise;
	}
	
	function setClasificacionNoRelacionada(urlService, _codigoCompania, _codigoClasificacion, _usuarioSesion, _usuario){
		
		var deferred = $q.defer();
		
		$http.post(urlService, {codigoCompania:_codigoCompania, codigoClasificacion:_codigoClasificacion, usuarioSesion:_usuarioSesion, usuario: _usuario}).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar las variables'});
				});
		return deferred.promise;
	}
	
	return clasificacionNoRelacionadaDataService;
}]);