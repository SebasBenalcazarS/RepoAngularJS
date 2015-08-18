angular.module('asignacionUsuarios').controller("ClasificacionNoRelacionadaUsuarioController", ['creacionClasificacionRelacionadaUsuarioService','clasificacionNoRelacionadaUsuarioService','$scope','PROPIEDADES','$http', function(creacionClasificacionRelacionadaUsuarioService,clasificacionNoRelacionadaUsuarioService, $scope, PROPIEDADES, $http) {

	var clasificacionNoRelacionadaUsuarioController = this;
	clasificacionNoRelacionadaUsuarioController.txtCodigoEstructura = '';
	clasificacionNoRelacionadaUsuarioController.txtCodigoSubbodega = '';
	
	clasificacionNoRelacionadaUsuarioController.propiedadesWeb = PROPIEDADES.propiedadesWeb;
	var wsDataRelacionada = PROPIEDADES.propiedades.urlWebServiceClasificacionRelacionadaUsuario;
	clasificacionNoRelacionadaUsuarioController.hayDatos=true;
	
	$scope.$on('selectFuncionario', function(event,funcionarioSeleccionado) {
		clasificacionNoRelacionadaUsuarioController.txtCodigoEstructura = '';
		clasificacionNoRelacionadaUsuarioController.txtCodigoSubbodega = '';
		$scope.gridOptions.api.showLoading(true);
		clasificacionNoRelacionadaUsuarioController.funcionarioSeleccionado = funcionarioSeleccionado;
		$scope.$broadcast('refreshDataRelacionada', funcionarioSeleccionado);		
	});
	
	$scope.$on('dataRelacionada', function(event, dataRelacionada) {
		clasificacionNoRelacionadaUsuarioController.dataRelacionada = dataRelacionada;
		clasificacionNoRelacionadaUsuarioController.buscarClasificacionArticulos('','');
		event.stopPropagation();
	});
	
	$scope.$on('eliminarRegistroTablaClasificacionNoRelacionada', function(event,codigo) {
    	clasificacionNoRelacionadaUsuarioController.buscarFilaClasificacionesNoRelacionadas(codigo);
	});
    
    $scope.$on('agregarRegistroTablaClasificacionNoRelacionada', function(event,registroDataNoRelacionada) {
    	clasificacionNoRelacionadaUsuarioController.hayDatos= true;
    	clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.splice(0,0,{descripcion : registroDataNoRelacionada.descripcion , codigoClasificacion : registroDataNoRelacionada.codigoClasificacion});
	    $scope.gridOptions.api.setDatasource(clasificacionNoRelacionadaUsuarioController.data);
	    event.stopPropagation();
	});

    
    $scope.gridOptions = {
    	rowData: null,
    	rowSelection: 'multiple',
		rowHeight: 25,
    	enableFilter: true,
    	virtualPaging: true,
    	enableColResize: true,
 	    showSelectionCheckbox: true,
 	    //pinnedColumnCount: 1,
 	    columnDefs: [{headerName: "", width: 30, checkboxSelection: true},
			 	    {headerName: "C&oacute;digo", field: "codigoClasificacion", width: 65,headerTooltip: "Código"},
			 	    {headerName: "Descripci&oacute;n", field: "descripcion", width: 233, headerTooltip: "Descripción"}]
 	};
	
	clasificacionNoRelacionadaUsuarioController.data = {
            rowCount: null, // behave as infinite scroll
            pageSize: 100,
            overflowSize: 100,
            maxConcurrentRequests: 2,
            maxPagesInCache: 2,
            getRows: function (params) {              
            	setTimeout( function() {
            		var rowsThisPage = clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.slice(params.startRow, params.endRow);
            		var lastRow = -1;
            		if (clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.length <= params.endRow) {
            			lastRow = clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.length;
            		}
            		params.successCallback(rowsThisPage, lastRow);
            	}, 500);
            }
        };
	              
    var ws = PROPIEDADES.propiedades.urlWebServiceClasificacionNoRelacionadaUsuario;
    
    clasificacionNoRelacionadaUsuarioController.buscarClasificacionArticulos = function (codigoEstructura, codigoSubbodega){
    	clasificacionNoRelacionadaUsuarioController.hayDatos= true;
    	$scope.gridOptions.api.showLoading(true);
    	$http.get(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+ws.url+'?codigoCompania='+ws.codigoCompania+'&maxResult='+ws.maxResult+'&firstResult='+ws.firstResult+'&usuarioSesion='+
    		ws.usuarioSesion+'&codigoEstructuraComercial='+new String(codigoEstructura == undefined ? '' : codigoEstructura)+'&codigoSubbodega='+new String(codigoSubbodega == undefined ? '' : codigoSubbodega))
    	.then(function(result){
    		clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada = clasificacionNoRelacionadaUsuarioController.eliminarClasificacionesRelacionadas(result.data);
    		clasificacionNoRelacionadaUsuarioController.dataNoRelacionada = result.data;
    		var dataSource = clasificacionNoRelacionadaUsuarioController.data;
    		console.log(clasificacionNoRelacionadaUsuarioController.dataNoRelacionada.length);
    		//setTimeout( function() {						                	
    			$scope.gridOptions.api.setDatasource(dataSource);
    			$scope.gridOptions.api.onNewRows();
    		//}, 2000);	
	    		if(clasificacionNoRelacionadaUsuarioController.dataNoRelacionada.length==0){
				clasificacionNoRelacionadaUsuarioController.hayDatos= false;
				}else{
					clasificacionNoRelacionadaUsuarioController.hayDatos= true;
				}

    	});
    	
    }
    
    clasificacionNoRelacionadaUsuarioController.eliminarRegistroTablaClasificacionNoRelacionada = function(codigo){
    	for (var i = 0 ; i < clasificacionNoRelacionadaUsuarioController.dataNoRelacionada.length ; i++){    		
    		if (clasificacionNoRelacionadaUsuarioController.dataNoRelacionada[i].codigoClasificacion == codigo){
    			clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.splice(i,1);								
    			$scope.gridOptions.api.showLoading(true);    	 	
    			break;
    		}
    	}
    	$scope.gridOptions.api.setDatasource(clasificacionNoRelacionadaUsuarioController.data);
    	$scope.gridOptions.api.onNewRows();
	}
    
	clasificacionNoRelacionadaUsuarioController.eliminarClasificacionesRelacionadas = function(dataClasificacionDeArticulos){		
		for (var i = 0 ; i < (dataClasificacionDeArticulos != undefined && dataClasificacionDeArticulos.length) ; i++){
			for (var j = 0 ; j < (clasificacionNoRelacionadaUsuarioController.dataRelacionada != undefined && dataClasificacionDeArticulos[i] != undefined && clasificacionNoRelacionadaUsuarioController.dataRelacionada.length) ; j++ ){
				if (dataClasificacionDeArticulos[i].codigoClasificacion == clasificacionNoRelacionadaUsuarioController.dataRelacionada[j].codigoClasificacion){
					dataClasificacionDeArticulos.splice(i,1);
				}
			}
		}
		return dataClasificacionDeArticulos;
	}
	
	clasificacionNoRelacionadaUsuarioController.registrarClasificaciones = function(){
		var seleccionadas = angular.copy($scope.gridOptions.selectedRows);
		for (var i = 0 ; i < seleccionadas.length ; i++)
		{
			creacionClasificacionRelacionadaUsuarioService.setClasificacionFuncionario(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceCreacionClasificacionFuncionario,
				PROPIEDADES.propiedades.codigoCompania, seleccionadas[i].codigoClasificacion,
				'FRM0',clasificacionNoRelacionadaUsuarioController.funcionarioSeleccionado.userId).then(function(data){
					if (data.status == 'OK'){
					}
					else{
						console.log("status WS: FAIL");
					}
				}).catch(function(data){$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
				console.log("status WS: FAIL");
			});			
				$scope.$parent.$broadcast('agregarRegistroTablaClasificacionRelacionada', seleccionadas[i]);	
				clasificacionNoRelacionadaUsuarioController.eliminarRegistroTablaClasificacionNoRelacionada(seleccionadas[i].codigoClasificacion);
			};
			if(clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.length==0){
				clasificacionNoRelacionadaUsuarioController.hayDatos= false;
			}
	};

	clasificacionNoRelacionadaUsuarioController.agregarRegistroTablaClasificacionRelacionada = function(seleccionada){
		$scope.$emit('actualizarGridClaRelacionadas', seleccionada);
		clasificacionNoRelacionadaUsuarioController.dataClasificacionesNoRelacionada.splice(0,0,{descripcion : seleccionada.descripcion , codigoClasificacion : seleccionada.codigoClasificacion});
	    $scope.gridOptions.api.setDatasource(clasificacionNoRelacionadaUsuarioController.data);
	};
	
}]);

