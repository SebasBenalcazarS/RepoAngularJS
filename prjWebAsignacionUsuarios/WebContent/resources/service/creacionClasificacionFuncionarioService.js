angular.module('asignacionUsuarios').factory('creacionClasificacionRelacionadaUsuarioService', ['$http','$q' , function ($http, $q) {
	
	
	var creacionClasificacionRelacionadaDataService = {
		setClasificacionFuncionario : setClasificacionFuncionario
	};
	
	function setClasificacionFuncionario(urlService, _codigoCompania, _codigoClasificacion, _usuarioSesion, _usuario){
		
		var deferred = $q.defer();
		"use strict";
		$http.post(urlService, {codigoCompania:_codigoCompania, codigoClasificacion:_codigoClasificacion, usuarioSesion:_usuarioSesion, usuario: _usuario}).success(
				function(data, status, headers, config) {
					deferred.resolve(data);
				}).
				error(function (data, status, headers, config)	{
					deferred.reject({error: 'Error al recuperar las variables'});
				});
		return deferred.promise;
	}
	
	return creacionClasificacionRelacionadaDataService;
}]);