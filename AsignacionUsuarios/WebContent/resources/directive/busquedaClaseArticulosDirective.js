'use strict';
angular.module('asignacionUsuarios').directive('busquedaClaseart',  function() {
	  return {
		  transclude: true,
		  restrict : 'A', 
		  controller: 'BusquedaClaseArticulosController',
		  controllerAs: 'bCArtCtrl',
		  templateUrl: 'resources/directive/busquedaClaseArticulos.xhtml'		    
	  };
});