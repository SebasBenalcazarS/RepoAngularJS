'use strict';
angular.module('asignacionUsuarios').directive('paginacionDirectiva',  function() {
	  return {
		  transclude: true,
		  restrict : 'A', 
		  controller: 'PaginacionController',
		  controllerAs: 'pagCtrl',
		  templateUrl: 'resources/directive/paginacion.xhtml'		    
	  };
});