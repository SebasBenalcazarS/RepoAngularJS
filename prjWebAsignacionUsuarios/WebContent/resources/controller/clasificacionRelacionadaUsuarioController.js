angular.module('asignacionUsuarios').controller("ClasificacionRelacionadaUsuarioController", ['clasificacionNoRelacionadaUsuarioService','clasificacionRelacionadaUsuarioService', '$scope','PROPIEDADES','$http','$rootScope',
                                                          function(clasificacionNoRelacionadaUsuarioService,clasificacionRelacionadaUsuarioService, $scope, PROPIEDADES, $http,$rootScope) {

	var clasificacionRelacionadaUsuarioController = this;
	clasificacionRelacionadaUsuarioController.funcionarioSeleccionado;
	clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen;
	clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigenDetalles;
	clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino;
	clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestinoDetalles;
	clasificacionRelacionadaUsuarioController.lista;
	clasificacionRelacionadaUsuarioController.listaClasificacionOrigen;
	clasificacionRelacionadaUsuarioController.listaClasificacionDestino;
	
	clasificacionRelacionadaUsuarioController.listaCA=[];
	clasificacionRelacionadaUsuarioController.hayDatos= true;
	var ws = PROPIEDADES.propiedades.urlWebServiceClasificacionRelacionadaUsuario;
	
	$scope.$on('selectFuncionarioIntercambio', function(event,funcionarioSeleccionado) {
		if ($scope.gridOptionsOrigen.api) {
							$scope.gridOptionsOrigen.api.showLoading(true);
					                				        
			} 	
		clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen = funcionarioSeleccionado;
		clasificacionRelacionadaUsuarioController.cargarDataClasificacionRelacionada();
	});
	$scope.$on('selectFuncionarioIntercambioDestino', function(event,funcionarioSeleccionado) {
		if ($scope.gridOptionsDestino.api) {
							$scope.gridOptionsDestino.api.showLoading(true);
					                				        
			} 	
		clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino = funcionarioSeleccionado;
		clasificacionRelacionadaUsuarioController.cargarDataClasificacionRelacionada();
	});
	
	$scope.$on('refreshDataRelacionada', function(event,data) {
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.showLoading(true);
		clasificacionRelacionadaUsuarioController.funcionarioSeleccionado = data;
		clasificacionRelacionadaUsuarioController.cargarDataClasificacionRelacionada();
	});


	clasificacionRelacionadaUsuarioController.data = {
            rowCount: null, // behave as infinite scroll
            pageSize: 100,
            overflowSize: 100,
            maxConcurrentRequests: 2,
            maxPagesInCache: 2,
            getRows: function (params) {              
                setTimeout( function() {
                    var rowsThisPage = clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.slice(params.startRow, params.endRow);
                    var lastRow = -1;
                    if (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.length <= params.endRow) {
                        lastRow = clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.length;
                    }
                    params.successCallback(rowsThisPage, lastRow);
                }, 500);
            }

    };

	clasificacionRelacionadaUsuarioController.desactivarClasificacionesSolicitarDataSeleccionada = function (){
		//clasificacionRelacionadaUsuarioController.gridOptionsArt.api.showLoading(true);
		//clasificacionRelacionadaUsuarioController.listaCA=[];
		clasificacionRelacionadaUsuarioController.listaCA = angular.copy(clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows);
		clasificacionRelacionadaUsuarioController.borrarClasificaciones(clasificacionRelacionadaUsuarioController.listaCA);
	}

	clasificacionRelacionadaUsuarioController.borrarClasificaciones = function(listaSeleccionada){
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.showLoading(true);
		  for (var i = 0 ; i < listaSeleccionada.length ; i++)
		  	{
			  clasificacionNoRelacionadaUsuarioService.setClasificacionNoRelacionada(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceDesactivarClasificaciones.url,
						PROPIEDADES.propiedades.codigoCompania, listaSeleccionada[i].codigoClasificacion,
						'FRM0',clasificacionRelacionadaUsuarioController.funcionarioSeleccionado.userId).then(function(data){
							if (data.status == 'OK'){
								
							}
				}).catch(function(data){$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
				});
			  
			  clasificacionRelacionadaUsuarioController.eliminarRegistroTablaClasificacionRelacionada(listaSeleccionada[i].codigoClasificacion);
			  $scope.$emit('agregarRegistroTablaClasificacionNoRelacionada', listaSeleccionada[i]);

		  	};
		  	
	};
	
	clasificacionRelacionadaUsuarioController.eliminarRegistroTablaClasificacionRelacionada = function(codigoCla){
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.showLoading(true);
		for (var i = 0 ; i < (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada != undefined && clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.length) ; i++){
			if (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada[i].codigoClasificacion == codigoCla){
				clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.splice(i,1);
				break;
			}
		}
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.setDatasource(clasificacionRelacionadaUsuarioController.data);
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.onNewRows();
		if (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.length == 0) {
             clasificacionRelacionadaUsuarioController.hayDatos=false;
        }
	};

	$scope.$on('desactivarClasificaciones', function(event,obj) {
		clasificacionRelacionadaUsuarioController.listaCA= obj;
		$scope.$parent.$broadcast('desactivarClasificacionesListaSeleccionada',clasificacionRelacionadaUsuarioController.listaCA);
		clasificacionRelacionadaUsuarioController.lista = [];
		clasificacionRelacionadaUsuarioController.check = false;
	});
	$scope.$on('agregarRegistroTablaClasificacionRelacionada', function(event,registroDataRelacionada) {
		clasificacionRelacionadaUsuarioController.hayDatos=true;
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.showLoading(true);
		clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.splice(0,0,{descripcion: registroDataRelacionada.descripcion,codigoClasificacion:registroDataRelacionada.codigoClasificacion});
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.setDatasource(clasificacionRelacionadaUsuarioController.data);
		clasificacionRelacionadaUsuarioController.gridOptionsArt.api.onNewRows();
	});

	$scope.$on('actualizarIntercambios', function(event, estado,funcionarioOrigen, listaOrigen,funcionarioDestino,listaDestino) {
		if (!estado) {
			if ($scope.gridOptionsOrigen.api) {
				$scope.gridOptionsOrigen.rowData= undefined;
				$scope.gridOptionsOrigen.api.onNewRows();
	    		$scope.gridOptionsOrigen.api.showLoading(true);
	    	}
			if ($scope.gridOptionsDestino.api) {
				$scope.gridOptionsDestino.rowData=undefined;
				$scope.gridOptionsDestino.api.onNewRows();
	    		$scope.gridOptionsDestino.api.showLoading(true);
	    	}
		}else{
			clasificacionRelacionadaUsuarioController.actualizarValoresIntercambio(funcionarioOrigen, listaOrigen, funcionarioDestino, listaDestino);
		}			
			
	});
	$scope.$on('actualizarReemplazo', function(event, estado,funcionarioOrigen, listaOrigen,funcionarioDestino) {
		if (!estado) {
			if ($scope.gridOptionsOrigen.api) {
				$scope.gridOptionsOrigen.rowData= undefined;
				$scope.gridOptionsOrigen.api.onNewRows();
	    		$scope.gridOptionsOrigen.api.showLoading(true);
	    	}
			if ($scope.gridOptionsDestino.api) {
				$scope.gridOptionsDestino.rowData=undefined;
				$scope.gridOptionsDestino.api.onNewRows();
	    		$scope.gridOptionsDestino.api.showLoading(true);
	    	}
		}else{
			clasificacionRelacionadaUsuarioController.actualizarValoresReemplazo(funcionarioOrigen, listaOrigen, funcionarioDestino);
		}		
			
	});
	$scope.$on('actualizarAdicion', function(event, estado,funcionarioOrigen, listaOrigen,funcionarioDestino,listaDestino) {
		if (!estado) {
			if ($scope.gridOptionsOrigen.api) {
				$scope.gridOptionsOrigen.rowData= undefined;
				$scope.gridOptionsOrigen.api.onNewRows();
	    		$scope.gridOptionsOrigen.api.showLoading(true);
	    	}
			if ($scope.gridOptionsDestino.api) {
				$scope.gridOptionsDestino.rowData=undefined;
				$scope.gridOptionsDestino.api.onNewRows();
	    		$scope.gridOptionsDestino.api.showLoading(true);
	    	}
		}else{
			clasificacionRelacionadaUsuarioController.actualizarAdicion(funcionarioOrigen, listaOrigen, funcionarioDestino, listaDestino);
		}
			
	});

	
	$scope.$on('eliminarRegistroTablaClasificacionRelacionada', function(event,codigo) {
		for (var i = 0 ; i < (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada != undefined && clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.length) ; i++){
			if (clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada[i].codigoClasificacion == codigo){
				clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada.splice(i,1);
				break;
			}
		}
	});

	clasificacionRelacionadaUsuarioController.selectAllChecked = false;
    
    $scope.selectAllRows = function(){
        if (clasificacionRelacionadaUsuarioController.selectAllChecked) {
            clasificacionRelacionadaUsuarioController.gridOptionsArt.api.selectAll();
        } else {
            clasificacionRelacionadaUsuarioController.gridOptionsArt.api.deselectAll();
        }
    };


function pintarRow(param) {
    var style = {};
    if (param.colDef.field && param.colDef.field == 'codigoClasificacion') {
        style = {"text-align": "right", "margin-right": "15px;"};
    }
    else if (param.colDef.field && param.colDef.field == 'descripcion') {
        style = {"text-align": "center"};
    } else {
        style = {"text-align": "left"};
    }

    if (param.data.npNumeroAlertas > 0) {
        style = angular.extend(style, {backgroundColor: '#ffef8f'});
    }
    return style;
   }

	function headerCellRendererFunc(params) {

        var eHeader = document.createElement('input');
        eHeader.setAttribute('type', 'checkbox');
        eHeader.setAttribute('ng-model', 'checkAll');
        eHeader.addEventListener('click', function (event) {
            var element = event.target;
            if (element && element.checked) {
                var model = params.api.getModel();
                var rowCount = model.getVirtualRowCount();
                //console.log(rowCount)
                for (var i = 0; i < rowCount; i++) {
                    params.api.selectIndex(i, true, true);
                }
            } else {
                params.api.deselectAll();
            }
            //selChangeCallback();
        });
        return eHeader;
    }


    function selectionChangedFunc(row) {
        console.log('selection changed, ' +clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows.length + ' rows selected');
        var est= this.estado;
		//$scope.$root.$broadcast('rowSelected'+$scope.namePro, clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows);
    }

    function rowSelectedFunc(row) {
    	//sclasificacionRelacionadaUsuarioController.listaCA=[];
    	clasificacionRelacionadaUsuarioController.gridOptionsArt.api.deselectAll(true);
    	clasificacionRelacionadaUsuarioController.listaCA.push(row);
        //console.log('selection changed, ' +clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows.length + ' rows selected');
		//$scope.$root.$broadcast('rowSelected'+$scope.namePro, clasificacionRelacionadaUsuarioController.gridOptionsArt.selectedRows[0]);
    }

	this.gridOptionsArt={
		rowData: null,
		rowSelection: 'multiple',
		angularCompileRows: true,
		angularCompileHeaders: true,
		suppressCellSelection: true,
        suppressRowClickSelection: true,
		rowHeight: 25,
 	    virtualPaging: true,
 	    enableColResize: true,
 	    showSelectionCheckbox: true,
		columnDefs: [{headerCellRenderer: headerCellRendererFunc, width: 30, checkboxSelection: true,  cellStyle: pintarRow},
	 	             {headerName: "Código", field: "codigoClasificacion", width: 60 ,headerTooltip: "Código"},
		             {headerName: "Descripción", field: "descripcion", width: 220, headerTooltip: "Código"}]
	};
	$scope.gridOptionsOrigen={
		rowData: null,
		enableCellEdit: true,
		showSelectionCheckbox: true,
		enableSorting: true,
		rowHeight: 25,
    	enableFilter: true,
 	    virtualPaging: true,
 	    enableColResize: true,
		columnDefs: [
	 	                  {headerName: "C&oacute;digo", field: "codigoClasificacion", width: 60, headerTooltip: "Código"},
		                  {headerName: "Descripci&oacute;n", field: "descripcion", width: 220, headerTooltip: "Código"}]
	};
	$scope.gridOptionsDestino={
		rowData: null,
		angularCompileRows: true,
		enableSorting: true,
    	enableFilter: true,
 	    virtualPaging: true,
 	    enableColResize: true,
		columnDefs: [
	 	                  {headerName: "C&oacute;digo", field: "codigoClasificacion", width: 60, headerTooltip: "Código"},
		                  {headerName: "Descripci&oacute;n", field: "descripcion", width: 220, headerTooltip: "Descripcion"}]
	};


	clasificacionRelacionadaUsuarioController.actualizarValoresIntercambio= function(UsuOrigen, listaUsuarioOrigen, UsuDestino, listaUsuarioDestino){
	   	if ($scope.gridOptionsOrigen.api) {
	   		$scope.gridOptionsOrigen.api.showLoading(true);
	      	$scope.gridOptionsOrigen.rowData=listaUsuarioDestino;
			$scope.$parent.$broadcast('listaIntercambioOrigen', listaUsuarioDestino, UsuOrigen);				        
			$scope.gridOptionsOrigen.api.onNewRows();
		}
	    if ($scope.gridOptionsDestino.api) {
	    	$scope.gridOptionsDestino.api.showLoading(true);
	        $scope.gridOptionsDestino.rowData=listaUsuarioOrigen;
			$scope.$parent.$broadcast('listaIntercambioDestino', listaUsuarioOrigen, UsuDestino);
			$scope.gridOptionsDestino.api.onNewRows();					        
		} 					  					  					  					 
	}
	clasificacionRelacionadaUsuarioController.actualizarValoresReemplazo= function(UsuOrigen, listaUsuarioOrigen, UsuDestino){
	   	if ($scope.gridOptionsOrigen.api) {
	   		$scope.gridOptionsOrigen.api.showLoading(true);
	      	$scope.gridOptionsOrigen.rowData=listaUsuarioOrigen;
			$scope.$parent.$broadcast('listaIntercambioOrigen', listaUsuarioOrigen, UsuOrigen);				        
			$scope.gridOptionsOrigen.api.onNewRows();
		}
	    if ($scope.gridOptionsDestino.api) {
	    	$scope.gridOptionsDestino.api.showLoading(true);
	        $scope.gridOptionsDestino.rowData=listaUsuarioOrigen;
			$scope.$parent.$broadcast('listaIntercambioDestino', listaUsuarioOrigen, UsuDestino);
			$scope.gridOptionsDestino.api.onNewRows();					        
		} 					  					  					  					 
	}
	
	clasificacionRelacionadaUsuarioController.actualizarAdicion= function(UsuOrigen, listaUsuarioOrigen, UsuDestino, listaUsuarioDestino){
	   
	   	if ($scope.gridOptionsOrigen.api) {
	   		$scope.gridOptionsOrigen.api.showLoading(true);
	      	$scope.gridOptionsOrigen.rowData=listaUsuarioOrigen;
			$scope.$parent.$broadcast('listaIntercambioOrigen', listaUsuarioOrigen, UsuOrigen);				        
			$scope.gridOptionsOrigen.api.onNewRows();
		}
		
	    if ($scope.gridOptionsDestino.api) {
	    	$scope.gridOptionsDestino.api.showLoading(true);
	    	var listaUDestino= listaUsuarioDestino;
			for (var i = 0; i < listaUsuarioOrigen.length; i++) {
				listaUDestino.push(listaUsuarioOrigen[i]);
			};
	        $scope.gridOptionsDestino.rowData=listaUDestino;
			$scope.$parent.$broadcast('listaIntercambioDestino', listaUDestino, UsuDestino);
			$scope.gridOptionsDestino.api.onNewRows();
		} 	
		var listaUDestino=undefined;				  					  					  					 
	}

	clasificacionRelacionadaUsuarioController.cargarDataClasificacionRelacionada = function(){
		var funcionario
		clasificacionRelacionadaUsuarioController.listaClasificacionOrigen=[];
		clasificacionRelacionadaUsuarioController.listaClasificacionDestino=[];
		if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen!= undefined ){
			funcionario=clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen;
		} 
		if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionado!= undefined ){
			funcionario=clasificacionRelacionadaUsuarioController.funcionarioSeleccionado;
		} 
		if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino!= undefined ){
			funcionario=clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino;
		}


		clasificacionRelacionadaUsuarioService.getData(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+
				ws.url+"?codigoCompania="+ws.codigoCompania+"&usuarioSesion="+funcionario.userId).then(function(result){
														
					if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen!= undefined ){
						clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigenDetalles= clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen;
						clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoOrigen=undefined;
						clasificacionRelacionadaUsuarioController.listaClasificacionOrigen=result;					               
					                if ($scope.gridOptionsOrigen.api) {					                							                	
						               	 	$scope.gridOptionsOrigen.rowData = result;
				        					$scope.$parent.$broadcast('listaIntercambioOrigen', result, funcionario);
								    		console.log('clasificacionRelacionadaUsuarioController origen: '+ result);
								        	$scope.gridOptionsOrigen.api.onNewRows();							        					        
							    	} 								  					    
					} 
					if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino!= undefined ){
						clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestinoDetalles= clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino;
	        			clasificacionRelacionadaUsuarioController.funcionarioSeleccionadoDestino=undefined;
	        			clasificacionRelacionadaUsuarioController.listaClasificacionDestino=result;						
						if ($scope.gridOptionsDestino.api) {										                							           
				        					$scope.gridOptionsDestino.rowData = result;									        
									        $scope.$parent.$broadcast('listaIntercambioDestino', result, funcionario);
									   	 	console.log('clasificacionRelacionadaUsuarioController destino: '+ result);
									   	 	$scope.gridOptionsDestino.api.onNewRows();							        				        
							    	} 		        					   
					}

					if(clasificacionRelacionadaUsuarioController.funcionarioSeleccionado!=undefined){
						clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada = result;
						$scope.$emit('dataRelacionada',clasificacionRelacionadaUsuarioController.dataClasificacionRelacionada);
						if(result.length!=0){
							clasificacionRelacionadaUsuarioController.hayDatos= true;
						}else {
							clasificacionRelacionadaUsuarioController.hayDatos= false;
						}
						if (clasificacionRelacionadaUsuarioController.gridOptionsArt.api) {
							clasificacionRelacionadaUsuarioController.gridOptionsArt.api.setDatasource(clasificacionRelacionadaUsuarioController.data);
					        clasificacionRelacionadaUsuarioController.gridOptionsArt.api.onNewRows();			     
					    }	

					}									
		}).catch(function(result){
			$scope.$root.$broadcast('message:error', {title: 'Error', message:result.error});
		});
		
	};
	
}]);
