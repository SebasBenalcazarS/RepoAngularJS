angular.module('asignacionUsuarios').factory('reporteService', ['$http','$q' , function ($http, $q) {
	
	
	var reporteDataService = {
		getReporteClasificaciones : getReporteClasificaciones,
		};
	
	function getReporteClasificaciones(urlService){
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
	
	return reporteDataService;
}]);