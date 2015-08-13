angular.module('asignacionUsuarios').controller("ArticulosNoRelacionadosController", ['articulosNoRelacionadosService','$scope','PROPIEDADES','$http', function(articulosNoRelacionadosService, $scope, PROPIEDADES, $http) {

	var articulosNoRelacionadosController = this;
	articulosNoRelacionadosController.propiedadesWeb = PROPIEDADES.propiedadesWeb;
	articulosNoRelacionadosController.funcionarioSeleccionado = '';
	articulosNoRelacionadosController.txtCodigoBarras= '';
	articulosNoRelacionadosController.txtDescripcion= '';
	articulosNoRelacionadosController.txtCodigoEstructura = '';
	articulosNoRelacionadosController.lista;//contiene lista a desagregar
	articulosNoRelacionadosController.listaCArticulos=[];
	//articulosNoRelacionadosController.listaticulosSeleccionados=[];
	articulosNoRelacionadosController.datalistaClasesArticulos;
	articulosNoRelacionadosController.datalistaArticulosRelacionados;
	articulosNoRelacionadosController.cargardata=false;
	articulosNoRelacionadosController.hayDatos=true;
	articulosNoRelacionadosController.dataArticulosNoRelacionados=[];
	articulosNoRelacionadosController.filaFin=25;
	articulosNoRelacionadosController.filaInicio=0;
	articulosNoRelacionadosController.numPagActual=1;
	       

	$scope.$on('selectFuncionario', function(event,funcionarioSeleccionado) {
		articulosNoRelacionadosController.funcionarioSeleccionado = funcionarioSeleccionado;
		articulosNoRelacionadosController.cargardata=true;
	});
	$scope.$on('dataArticulosRelacionada', function(event, dataRelacionada) {
		articulosNoRelacionadosController.datalistaArticulosRelacionados = dataRelacionada;
		event.stopPropagation();
	});
	
	//capturar lista de clases seleccionadas en una sola variable. articulosNoRelacionadosController.listaCArticulos 
	$scope.$on('checkAllClaseArti', function(event, estado, listaC) {
		articulosNoRelacionadosController.listaCArticulos=[];
		//listaCA=[];
		if (estado==true){
			for (var i = 0 ; i < (listaC != undefined && listaC.length) ; i++)
			{
				articulosNoRelacionadosController.listaCArticulos.push(angular.copy(listaC[i].codigoclasearticulo));
			}
			console.log("recibido:"+articulosNoRelacionadosController.listaCArticulos);
		}
		else{
			articulosNoRelacionadosController.listaCArticulos = [];	
			console.log("No recibido:");
		}
		event.stopPropagation();
	});
	$scope.$on('checkCArti', function(event, estado,listaC) {
		articulosNoRelacionadosController.listaCArticulos=[];
		if (estado){
			for (var i = 0 ; i < (listaC != undefined && listaC.length) ; i++)
			{
				articulosNoRelacionadosController.listaCArticulos.push(angular.copy(listaC[i].codigoclasearticulo));
			}
			console.log("recibido:"+articulosNoRelacionadosController.listaCArticulos);
		}else{
			articulosNoRelacionadosController.listaCArticulos=[];
			console.log("No recibido:");
		}
		event.stopPropagation();	
	});
	$scope.$on('borrarTabla', function(event, estado){
		if (estado) {
			articulosNoRelacionadosController.dataArticulosNoRelacionados=[];
			if (articulosNoRelacionadosController.gridOptions.api) {
            	articulosNoRelacionadosController.gridOptions.api.setDatasource(articulosNoRelacionadosController.dataArticulosNoRelacionados);
            	articulosNoRelacionadosController.gridOptions.api.onNewRows();
            };
		};
	});
	
	$scope.$on('panelArticulos', function(event, obj){
		articulosNoRelacionadosController.txtCodigoBarras= '';
		articulosNoRelacionadosController.txtDescripcion= '';
		articulosNoRelacionadosController.txtCodigoEstructura = '';
		if(articulosNoRelacionadosController.cargardata){
			if (articulosNoRelacionadosController.gridOptions.api) {
				articulosNoRelacionadosController.gridOptions.api.showLoading(true);
			}
			articulosNoRelacionadosController.buscarArticulosNoRelacionados('','','');
		}
		articulosNoRelacionadosController.cargardata=false;
	});
	
	$scope.$on('agregarRegistroTablaArticulosNoRelacionados', function(event, obj){
		console.log("scope.on agregarRegistroTablaArticulosNoRelacionados:"+articulosNoRelacionadosController.dataArticulosNoRelacionados);
		if (articulosNoRelacionadosController.dataArticulosNoRelacionados != undefined || articulosNoRelacionadosController.dataArticulosNoRelacionados.length!=0) {
				articulosNoRelacionadosController.hayDatos=true;
			};
		articulosNoRelacionadosController.dataArticulosNoRelacionados.splice(0,0,{ codigoArticulo : obj.codigoArticulo,descripcion : obj.descripcion ,referenciaMedida:obj.referenciaMedida, valorUnidadMaanejo:obj.valorUnidadManejo,	claseArticulo:obj.claseArticulo, codigoClasificacion:obj.codigoClasificacion});
		articulosNoRelacionadosController.gridOptions.api.setDatasource(articulosNoRelacionadosController.data);
		articulosNoRelacionadosController.gridOptions.api.onNewRows();
		event.stopPropagation();
	});
	
	this.gridOptions = {
		//enableSorting: true,
        //enableFilter: true,
		//rowData: null,
		rowSelection: 'multiple',
		//rowHeight: 25,
    	//virtualPaging: true,
    	enableColResize: true,
    	columnDefs: [/*{headerName: "#", width: 25, cellRenderer: function(params) {
            return params.node.id + 1;
        } },*/
    	{headerName: "", width: 30, checkboxSelection: true},
    	{headerName: "C&oacute;digo", field: "codigoArticulo", width: 80, headerTooltip: "Código"},
    	{headerName: "Descripci&oacute;n", field: "descripcion", width: 160,headerTooltip: "Descripción"},
    	{headerName: "T.Art", field: "referenciaMedida", width: 50, headerTooltip: "Tipo Artículo"},
    	{headerName: "UM", field: "valorUnidadManejo", width: 50, headerTooltip: "Unidad de Medida"},
    	{headerName: "Clase", field: "claseArticulo", width: 40, headerTooltip: "Clase"},
    	{headerName: "Cod.Clas", field: "codigoClasificacion",width:50, headerTooltip: "Código clasificación"}]
    };
    articulosNoRelacionadosController.data = {
          rowCount: null, // behave as infinite scroll
           //rowCount: null, // behave as infinite scroll
          pageSize: 25,
          overflowSize: 50,
          maxConcurrentRequests: 2,
          maxPagesInCache: 2,
           getRows: function (params) {              
           	setTimeout( function() {
           		var rowsThisPage = articulosNoRelacionadosController.dataArticulosNoRelacionados.slice(params.startRow, params.endRow);
           		var lastRow = -1;
           		if (articulosNoRelacionadosController.dataArticulosNoRelacionados.length <= params.endRow) {
           			lastRow = articulosNoRelacionadosController.dataArticulosNoRelacionados.length;
           		}
           		params.successCallback(rowsThisPage, lastRow);
           	}, 500);
           }
       };
       $scope.$on('obtenerlistaClaseArticulos', function(event, listaClaseA){
       	articulosNoRelacionadosController.datalistaClasesArticulos=angular.copy(listaClaseA);
       	console.log("lista de codigoclaseArticulos: "+articulosNoRelacionadosController.datalistaClasesArticulos.codigoclasearticulo+" recibida desde busqueda clase artiulos");
       });

       
       articulosNoRelacionadosController.first=0;
       articulosNoRelacionadosController.max=25;
       var ws = PROPIEDADES.propiedades.urlWebServiceArticulosNoRelacionadaUsuario;

    articulosNoRelacionadosController.buscarArticulosNoRelacionados = function(){
       	articulosNoRelacionadosController.hayDatos=true;
       	
       	if (articulosNoRelacionadosController.gridOptions.api) {
       			articulosNoRelacionadosController.gridOptions.api.showLoading(true);
	       }
       	articulosNoRelacionadosController.req = {
	       		method: 'POST',
	       		url: 'http://localhost:8080/prjWebServicesSICWeb/ws/autorizacionUsuarios/findAllArticulos',
	       		headers: {
	       			'Content-Type': 'application/json; charset=utf-8',
	       			'dataType': 'json'
	       		},
	       		data: { codigoCompania:ws.codigoCompania,
	       			maxResult:articulosNoRelacionadosController.max,
	       			firstResult: articulosNoRelacionadosController.filaInicio,
	       			usuarioSesion:articulosNoRelacionadosController.funcionarioSeleccionado.userId,
	       			codigoBarras:articulosNoRelacionadosController.txtCodigoBarras,
	       			descripcion:articulosNoRelacionadosController.txtDescripcion,
	       			codigoEstructura: articulosNoRelacionadosController.txtCodigoEstructura,
	       			clasesArticulos:{claseArticulo:articulosNoRelacionadosController.listaCArticulos} }
       		}

       		articulosNoRelacionadosService.getDataNoRelacionada(articulosNoRelacionadosController.req).then(function(result){
       			//var cont=50;
       			articulosNoRelacionadosController.dataArticulosNoRelacionados=[];
       			for (var i = 0; i <=result.coleccionArticulos.length-1; i++) {
       				articulosNoRelacionadosController.dataArticulosNoRelacionados.push(result.coleccionArticulos[i]);
       			};       			
       			articulosNoRelacionadosController.crearDataSource(result.coleccionArticulos, articulosNoRelacionadosController.txtCodigoBarras, articulosNoRelacionadosController.txtDescripcion, articulosNoRelacionadosController.txtCodigoEstructura);
            	$scope.$broadcast('numeroRegistrosANR', result.numeroArticulos, 25);
       			console.log('dataArticulosNoRelacionados: '+ articulosNoRelacionadosController.dataArticulosNoRelacionados.length);

            	})

	}
	$scope.$on('numPaginaaMostrar', function(event, numPagina){
		if(numPagina > articulosNoRelacionadosController.numPagActual){
		   	articulosNoRelacionadosController.filaInicio=articulosNoRelacionadosController.filaFin;
		   	articulosNoRelacionadosController.filaFin=articulosNoRelacionadosController.filaInicio+25;
		   	articulosNoRelacionadosController.numPagActual=numPagina;
		}
		if(numPagina < articulosNoRelacionadosController.numPagActual){
			articulosNoRelacionadosController.filaInicio=articulosNoRelacionadosController.filaInicio-25;
		   	articulosNoRelacionadosController.filaFin=articulosNoRelacionadosController.filaInicio+25;
		   	articulosNoRelacionadosController.numPagActual=numPagina;
		}
		articulosNoRelacionadosController.buscarArticulosNoRelacionados();
		event.stopPropagation();
	});


	var desde=0; var hasta=25;
	articulosNoRelacionadosController.crearDataSource=function(result, codigoBarras, descripcion, codigoEstructura){
				var allOfTheData = result;
            	var dataSource = {
                rowCount: -1, 
                pageSize: 25,

                getRows: function (params) {
                    console.log('asking for ' + articulosNoRelacionadosController.filaInicio + ' to ' + articulosNoRelacionadosController.filaFin);
                        var rowsThisPage = allOfTheData.slice(0,articulosNoRelacionadosController.max) ;
                        // if on or after the last page, work out the last row.
                        var lastRow = -1;
                        if (allOfTheData.length <= params.endRow) {
                            lastRow = allOfTheData.length;
                        }
                        // call the success callback
                        params.successCallback(rowsThisPage, lastRow);
                        console.log('rowsThisPage: ' + rowsThisPage+ ' lastRow: ' +lastRow);                  
                }
            };
            if (articulosNoRelacionadosController.gridOptions.api) {
            	articulosNoRelacionadosController.gridOptions.api.setDatasource(dataSource);
            };
	}

	articulosNoRelacionadosController.eliminarArticulosRelacionados = function(dataDeArticulosRelacionados){

		for (var i = 0 ; i < (dataDeArticulosRelacionados != undefined && dataDeArticulosRelacionados.length) ; i++){
			for (var j = 0 ; j < (articulosNoRelacionadosController.datalistaArticulosRelacionados != undefined && dataDeArticulosRelacionados[i] != undefined && articulosNoRelacionadosController.datalistaArticulosRelacionados.length) ; j++ ){
				if (dataDeArticulosRelacionados[i].codigoArticulo == articulosNoRelacionadosController.datalistaArticulosRelacionados[j].codigoArticulo){
					dataDeArticulosRelacionados.splice(i,1);
				}
			}
		}
		return dataDeArticulosRelacionados;
	}	
	
	articulosNoRelacionadosController.desagregar = function(){
		$scope.$broadcast('desagregarArticulosEvent', articulosNoRelacionadosController.listaArticulosSeleccionados);
		articulosNoRelacionadosController.lista = [];

	}
	
	articulosNoRelacionadosController.registrarArticulos = function(){
		var seleccionadas = angular.copy(articulosNoRelacionadosController.gridOptions.selectedRows);
		for (var i = 0 ; i < seleccionadas.length ; i++)
		{
			articulosNoRelacionadosService.setArticulosNoRelacionados(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceCreacionArticulosRelacionados,
				'FRM0', PROPIEDADES.propiedades.codigoCompania, seleccionadas[i].codigoArticulo, articulosNoRelacionadosController.funcionarioSeleccionado.userId).then(function(data){
					if (data.status == 'OK'){
					}
					else{
						console.log("status WS: FAIL");
					}
				}).catch(function(data){$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
				console.log("status WS: FAIL");
			});
				$scope.$parent.$broadcast('agregarRegistroTablaArticulosRelacionados', seleccionadas[i]);
				articulosNoRelacionadosController.eliminarFilaA(seleccionadas[i].codigoArticulo);
			};
			if (articulosNoRelacionadosController.dataArticulosNoRelacionados == undefined || articulosNoRelacionadosController.dataArticulosNoRelacionados.length==0) {
				articulosNoRelacionadosController.hayDatos=false;
			};
		};

	articulosNoRelacionadosController.eliminarFilaA = function(codigo) {
			for (var i = 0 ; i < (articulosNoRelacionadosController.dataArticulosNoRelacionados != undefined && articulosNoRelacionadosController.dataArticulosNoRelacionados.length) ; i++){
				if (articulosNoRelacionadosController.dataArticulosNoRelacionados[i].codigoArticulo == codigo){
					articulosNoRelacionadosController.dataArticulosNoRelacionados.splice(i,1);
							articulosNoRelacionadosController.gridOptions.api.showLoading(true);	
					break;
				}
			}
			articulosNoRelacionadosController.gridOptions.api.setDatasource(articulosNoRelacionadosController.data);
			articulosNoRelacionadosController.gridOptions.api.onNewRows();
	}

	}]);

