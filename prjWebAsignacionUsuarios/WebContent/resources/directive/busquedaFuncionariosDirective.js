'use strict';
angular.module('asignacionUsuarios').directive('busquedaFuncionarios',  function() {
	  return {
		  transclude: true,
		  restrict : 'A', 
		  controller: 'BusquedaFuncionariosController',
		  controllerAs: 'bfCtrl',
		  templateUrl: 'resources/directive/busquedaFuncionario.xhtml'		    
	  };
});