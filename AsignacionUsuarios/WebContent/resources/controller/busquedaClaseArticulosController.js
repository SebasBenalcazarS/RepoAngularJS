angular.module('asignacionUsuarios').controller('BusquedaClaseArticulosController' , ['busquedaClaseArticulosService','PROPIEDADES', '$scope', function (busquedaClaseArticulosService, PROPIEDADES, $scope) {

	'use strict';
	var busquedaClaseArticulosController = this;
	busquedaClaseArticulosController.listaDataClaseArticulos=[];
	busquedaClaseArticulosController.lista;
	busquedaClaseArticulosController.listaCA;
	busquedaClaseArticulosController.estado = false;
	//busquedaClaseArticulosController.check=false;
	
	busquedaClaseArticulosController.propiedadesWeb = PROPIEDADES.propiedadesWeb;

	busquedaClaseArticulosService.getClaseArticulos(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceObtenerClasesArticulos)
		.then(function(result){
			busquedaClaseArticulosController.claseArticulos = result;
			busquedaClaseArticulosController.listaDataClaseArticulos=busquedaClaseArticulosController.claseArticulos;
			$scope.$parent.$broadcast('listaDataClaseArticulos', busquedaClaseArticulosController.listaDataClaseArticulos);
		}).catch(function(data){
			$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
		});
	
	busquedaClaseArticulosController.checkAll = function(){
		busquedaClaseArticulosController.listaCA=[];
		if(busquedaClaseArticulosController.estado){
			this.estado=true;
			busquedaClaseArticulosController.listaCA= angular.copy(busquedaClaseArticulosController.listaDataClaseArticulos);
			$scope.$emit('checkAllClaseArti', this.estado, busquedaClaseArticulosController.listaCA);
		}else{
			this.estado=false;
			$scope.$emit('checkAllClaseArti', this.estado, busquedaClaseArticulosController.listaCA);
		}
	}
	busquedaClaseArticulosController.borrarTabla= function(){
		$scope.$emit('borrarTabla', true);
	}
	
	busquedaClaseArticulosController.check = function(){
		//comprueba si estan seleccionados todos para checkall como false y poder des-seleccionar solo uno
		if(busquedaClaseArticulosController.listaCA.length!=0){
			//busquedaClaseArticulosController.listaCA=[];
			this.estado=false;
			$scope.$emit('checkAllClaseArti', this.estado, busquedaClaseArticulosController.listaCA);
		}
		var listCA =  angular.copy(busquedaClaseArticulosController.listaCA); 
		var estado=false;
		if(listCA.length!=0){
			estado=true;
		}
		 $scope.$emit('checkCArti', estado, busquedaClaseArticulosController.listaCA);
	}
		
}]);