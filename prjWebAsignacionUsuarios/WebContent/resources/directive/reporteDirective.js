'use strict';
angular.module('asignacionUsuarios').directive('reporteDirectiva',  function() {
	  return {
		  transclude: true,
		  restrict : 'A', 
		  controller: 'ReporteClasificacionesController',
		  controllerAs: 'reporteCtrl',
		  templateUrl: 'resources/directive/reporteClasificaciones.xhtml'		    
	  };
});