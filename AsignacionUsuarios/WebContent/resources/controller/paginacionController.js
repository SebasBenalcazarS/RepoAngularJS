angular.module('asignacionUsuarios').controller('PaginacionController' , ['busquedaClaseArticulosService','PROPIEDADES', '$scope', function (busquedaClaseArticulosService, PROPIEDADES, $scope) {

	'use strict';
	var paginacionController = this;
	paginacionController.numeroRegistrosANR=0;
	paginacionController.numeroTotalPaginas="...";
	paginacionController.numPagActual=1;


	$scope.$on('panelArticulos', function(event, obj){
		paginacionController.numeroRegistrosANR=0;
		paginacionController.numeroTotalPaginas="...";
		paginacionController.numPagActual=1;
	});
	$scope.$on('actualizarPaginador', function(event, obj){
		paginacionController.numeroRegistrosANR=0;
		paginacionController.numeroTotalPaginas="...";
		paginacionController.numPagActual=1;
	});

	this.paginaSiguiente= function(){
		paginacionController.numPagActual=paginacionController.numPagActual+1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual);
	}
	this.paginaAnterior= function(){				
		paginacionController.numPagActual=paginacionController.numPagActual-1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual);
	}

	this.ultimaPagina= function(){		
		paginacionController.numPagActual=paginacionController.numeroTotalPaginas;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual);
	}

	this.primeraPagina= function(){		
		paginacionController.numPagActual=1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual);
	}

	$scope.$on('numeroRegistrosANR', function(event, num, numPorPagina){
		//metodo.run();		
		if(num%numPorPagina!=0){
			paginacionController.numeroTotalPaginas=Math.floor(num/numPorPagina)+1;
		}else{
			paginacionController.numeroTotalPaginas=num/numPorPagina;
		}
		
	});
}]);