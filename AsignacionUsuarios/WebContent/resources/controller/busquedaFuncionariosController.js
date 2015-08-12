angular.module('asignacionUsuarios').controller('BusquedaFuncionariosController' , ['busquedaFuncionariosDataService','PROPIEDADES', '$scope', function (busquedaFuncionariosDataService, PROPIEDADES, $scope) {

	'use strict';
	var busquedaFuncionariosController = this;
	busquedaFuncionariosController.verClasificaciones=false;
	
	busquedaFuncionariosController.propiedadesWeb = PROPIEDADES.propiedadesWeb;
	
	busquedaFuncionariosController.setFuncionarioSeleccionado = function(funcionarioSeleccionado){
		$scope.$broadcast('selectFuncionario', funcionarioSeleccionado);
	};
	busquedaFuncionariosController.setFuncionarioSeleccionadoIntercambio = function(funcionarioSeleccionado){
		$scope.$broadcast('selectFuncionarioIntercambio', funcionarioSeleccionado);
	};
	busquedaFuncionariosController.setFuncionarioSeleccionadoIntercambioDestino = function(funcionarioSeleccionado){
		$scope.$broadcast('selectFuncionarioIntercambioDestino', funcionarioSeleccionado);
	};
	
	busquedaFuncionariosDataService.getFuncionarios(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceFuncionarios)
		.then(function(result){
				busquedaFuncionariosController.funcionarios = result;
		}).catch(function(data){
			$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
		});
		
}]);