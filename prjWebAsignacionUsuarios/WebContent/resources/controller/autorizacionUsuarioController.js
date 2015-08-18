angular.module('asignacionUsuarios').controller('AutorizacionUsuarioController' , ['$scope', 'PROPIEDADES',  function ($scope, PROPIEDADES) {

	var autorizacionUsuarioController = this;
	"use strict";
	autorizacionUsuarioController.isSelectClas=false;
	autorizacionUsuarioController.isPanelClasifActivo = false;
	autorizacionUsuarioController.propiedadesWeb = PROPIEDADES.propiedadesWeb;
	autorizacionUsuarioController.funcionarioSeleccionado;
	
	$scope.$on('selectFuncionario', function(event,funcionarioSeleccionado) {
		autorizacionUsuarioController.funcionarioSeleccionado = funcionarioSeleccionado;
		if($scope.$$childHead.tabs){
			$scope.$$childHead.tabs[0].active = true;
		}
	});

	autorizacionUsuarioController.update = function(row, funcionario){
		autorizacionUsuarioController.setSelected(row, funcionario);
	};
	autorizacionUsuarioController.SelectClasif=function(){
		autorizacionUsuarioController.isSelectClas
		autorizacionUsuarioController.isPanelClasifActivo = true;
	};
	autorizacionUsuarioController.setSelected = function(row, funcionario) {
		//Objecto funcionario seleccionado
		autorizacionUsuarioController.funcionarioSeleccionado = funcionario;
		//Indice de la lista que se seleccion, para cambiar el estilo de la fila seleccionada 
		autorizacionUsuarioController.selectedRow = row;
	};	
	
	autorizacionUsuarioController.clickArticulos = function(){
		$scope.$broadcast('panelArticulos',true);
	}
	autorizacionUsuarioController.clickIntercambios = function(){
		$scope.$broadcast('panelIntercambio',true);
	}
	autorizacionUsuarioController.desactivarClasificacionesSolicitarDataSeleccionada = function (){
	//if($scope.gridOptions.api){
		//$scope.gridOptions.datasource=clasificacionRelacionadaUsuarioController.data;
		//clasificacionRelacionadaUsuarioController.listaCA = angular.copy(clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows);
		$scope.$parent.$broadcast('desactivarClasificacionesListaSeleccionada',true);
	//}
		
		//$scope.$parent.$broadcast('desactivarClasificaciones',clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada);
	}
}]);