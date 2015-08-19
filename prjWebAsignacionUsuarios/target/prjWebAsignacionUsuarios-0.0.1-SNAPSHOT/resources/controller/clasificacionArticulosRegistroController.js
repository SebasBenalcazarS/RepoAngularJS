angular.module('asignacionUsuarios').controller("ClasificacionArticulosRegistroController", ['creacionClasificacionRelacionadaUsuarioService', 'clasificacionNoRelacionadaUsuarioService','$scope','PROPIEDADES','$http','$rootScope', function(creacionClasificacionRelacionadaUsuarioService,clasificacionNoRelacionadaUsuarioService, $scope, PROPIEDADES, $http, $rootScope) {

	var clasificacionArticulosRegistroController = this;
	clasificacionArticulosRegistroController.propiedadesWeb = PROPIEDADES.propiedadesWeb;
	clasificacionArticulosRegistroController.funcionarioSeleccionado;
	clasificacionArticulosRegistroController.dataRelacionada;
	clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada;
	
	$scope.$on('selectFuncionario', function(event,funcionarioSeleccionado) {
		clasificacionArticulosRegistroController.funcionarioSeleccionado = funcionarioSeleccionado;
		$scope.$broadcast('refreshDataRelacionada', funcionarioSeleccionado);
//		event.stopPropagation();
	});
	
	$scope.$on('registrarClasificaciones', function(event, dataRelacionada) {
		clasificacionArticulosRegistroController.dataRelacionada = dataRelacionada;
		clasificacionArticulosRegistroController.registrarClasificaciones();
	});
	
	clasificacionArticulosRegistroController.registrarClasificaciones = function(){
		  for (var i = 0 ; i < clasificacionArticulosRegistroController.dataRelacionada.length ; i++)
		  	{
			  creacionClasificacionRelacionadaUsuarioService.setClasificacionFuncionario(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceCreacionClasificacionFuncionario,
						PROPIEDADES.propiedades.codigoCompania, clasificacionArticulosRegistroController.dataRelacionada[i].codigoClasificacion,
						'FRM0',clasificacionArticulosRegistroController.funcionarioSeleccionado.userId).then(function(data){
							if (data.status == 'OK'){
							}
							else{
								console.log("status WS: FAIL");
							}
				}).catch(function(data){$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
					console.log("status WS: FAIL");
				});
			  
			  clasificacionArticulosRegistroController.agregarRegistroTablaClasificacionRelacionada(clasificacionArticulosRegistroController.dataRelacionada[i]);
			  clasificacionArticulosRegistroController.eliminarRegistroTablaClasificacionNoRelacionada(clasificacionArticulosRegistroController.dataRelacionada[i].codigoClasificacion);
		  	};
	};
	
	clasificacionArticulosRegistroController.borrarClasificaciones = function(){
		  for (var i = 0 ; i < clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada.length ; i++)
		  	{
			  clasificacionNoRelacionadaUsuarioService.setClasificacionNoRelacionada(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceDesactivarClasificaciones.url,
						PROPIEDADES.propiedades.codigoCompania, clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada[i].codigoClasificacion,
						'FRM0',clasificacionArticulosRegistroController.funcionarioSeleccionado.userId).then(function(data){
							if (data.status == 'OK'){
								
							}
				}).catch(function(data){$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
				});
			  
			  clasificacionArticulosRegistroController.eliminarRegistroTablaClasificacionRelacionada(clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada[i].codigoClasificacion);
			  clasificacionArticulosRegistroController.agregarRegistroTablaClasificacionNoRelacionada(clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada[i]);

		  	};
	};
	
	//**************Click flecha -->
	clasificacionArticulosRegistroController.eliminarRegistroTablaClasificacionNoRelacionada = function(codigoClasificacion){
		$scope.$parent.$broadcast('eliminarRegistroTablaClasificacionNoRelacionada', codigoClasificacion);
	}
	
	clasificacionArticulosRegistroController.agregarRegistroTablaClasificacionRelacionada = function(obj){
		$scope.$parent.$broadcast('agregarRegistroTablaClasificacionRelacionada', obj);
	};
	//**************Click fecha <--
	clasificacionArticulosRegistroController.eliminarRegistroTablaClasificacionRelacionada = function(codigoClasificacion){
		$scope.$parent.$broadcast('eliminarRegistroTablaClasificacionRelacionada', codigoClasificacion);
	}
	
	clasificacionArticulosRegistroController.agregarRegistroTablaClasificacionNoRelacionada = function(obj){
		$scope.$parent.$broadcast('agregarRegistroTablaClasificacionNoRelacionada', obj);
	};
	//
	
	clasificacionArticulosRegistroController.desactivarClasificacionesSolicitarDataSeleccionada = function (){
		clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada = angular.copy($scope.gridOptions.selectedRows);
		$scope.$parent.$broadcast('desactivarClasificaciones',clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada);
	}
	
	$scope.$on('desactivarClasificacionesListaSeleccionada', function(event,dataNoRelacionadaSeleccionada) {
		//clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada = angular.copy($scope.gridOptions.selectedRows);
		clasificacionArticulosRegistroController.dataNoRelacionadaSeleccionada = dataNoRelacionadaSeleccionada;
		clasificacionArticulosRegistroController.borrarClasificaciones();
		
	});

	
}]);