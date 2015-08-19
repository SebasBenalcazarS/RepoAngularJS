angular.module('asignacionUsuarios').controller('PaginacionController' , ['busquedaClaseArticulosService','PROPIEDADES', '$scope', function (busquedaClaseArticulosService, PROPIEDADES, $scope) {

	'use strict';
	var paginacionController = this;
	paginacionController.numeroRegistrosANR=0;
	paginacionController.numeroTotalPaginas="...";
	paginacionController.numPagActual=1;
	paginacionController.reporte=false;


	$scope.$on('panelArticulos', function(event, obj){
		paginacionController.numeroRegistrosANR=0;
		paginacionController.numeroTotalPaginas="...";
		paginacionController.numPagActual=1;
		paginacionController.reporte=false;
	});
	$scope.$on('actualizarPaginador', function(event, obj){
		paginacionController.numeroRegistrosANR=0;
		paginacionController.numeroTotalPaginas="...";
		paginacionController.numPagActual=1;
	});


	this.paginaSiguiente= function(){
		paginacionController.numPagActual=paginacionController.numPagActual+1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual, paginacionController.reporte);
	}
	this.paginaAnterior= function(){				
		paginacionController.numPagActual=paginacionController.numPagActual-1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual, paginacionController.reporte);
	}

	this.ultimaPagina= function(){		
		paginacionController.numPagActual=paginacionController.numeroTotalPaginas;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual, paginacionController.reporte);
	}

	this.primeraPagina= function(){		
		paginacionController.numPagActual=1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual, paginacionController.reporte);
	}
	this.irAPagina= function(){		
		//paginacionController.numPagActual=1;
		$scope.$emit('numPaginaaMostrar', paginacionController.numPagActual, paginacionController.reporte);
	}

	$scope.$on('numeroRegistrosANR', function(event, num, numPorPagina){
		//metodo.run();		
		if(num%numPorPagina!=0){
			paginacionController.numeroTotalPaginas=Math.floor(num/numPorPagina)+1;
		}else{
			paginacionController.numeroTotalPaginas=num/numPorPagina;
		}
		
	});
	$scope.$on('numeroClasificaciones', function(event, num, numPorPagina){
		paginacionController.reporte=true;
		//metodo.run();		
		if(num%numPorPagina!=0){
			paginacionController.numeroTotalPaginas=Math.floor(num/numPorPagina)+1;
		}else{
			paginacionController.numeroTotalPaginas=num/numPorPagina;
		}
		
	});
}]);