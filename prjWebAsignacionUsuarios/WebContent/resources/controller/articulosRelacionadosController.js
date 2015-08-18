angular.module('asignacionUsuarios').controller("ArticulosRelacionadosController", ['articulosRelacionadosService', '$scope','PROPIEDADES','$http','$rootScope', function(articulosRelacionadosService, $scope, PROPIEDADES, $http, $rootScope) {

	
	var articulosRelacionadosController = this;
	articulosRelacionadosController.estado = false;
	var ws = PROPIEDADES.propiedades.urlWebServiceArticulosRelacionadosUsuario;
	articulosRelacionadosController.funcionarioSeleccionado = '';
	articulosRelacionadosController.isPanelArticulosActivo = false;
	articulosRelacionadosController.lista;
	articulosRelacionadosController.listaClaseArticulos;
	articulosRelacionadosController.dataArticulosRelacionados=[];
	articulosRelacionadosController.listaClaseArticulosDesag=[];
	articulosRelacionadosController.listaCA;
	articulosRelacionadosController.hayDatos=false;
	
	$scope.$on('selectFuncionario', function(event,funcionarioSeleccionado) {
		articulosRelacionadosController.gridOptionsAR.api.showLoading(true);
		articulosRelacionadosController.funcionarioSeleccionado = funcionarioSeleccionado;
	});
	
	$scope.$on('panelArticulos', function (event, data){
		articulosRelacionadosController.gridOptionsAR.api.showLoading(true);
		articulosRelacionadosController.isPanelArticulosActivo = true;
		articulosRelacionadosController.cargarTabla();		
	});
	
	$scope.$on('agregarRegistroTablaArticulosRelacionados', function (event, obj){
		articulosRelacionadosController.hayDatos=true;
		articulosRelacionadosController.gridOptionsAR.api.showLoading(true);
		
		articulosRelacionadosController.ArticulosRelacionados.splice(0,0,{ codigoArticulo : obj.codigoArticulo,descripcion : obj.descripcion ,referenciaMedida:obj.referenciaMedida, valorUnidadManejo:obj.valorUnidadManejo,	claseArticulo:obj.claseArticulo, codigoClasificacion:obj.codigoClasificacion});
		articulosRelacionadosController.gridOptionsAR.api.setDatasource(articulosRelacionadosController.data);
		articulosRelacionadosController.gridOptionsAR.api.onNewRows();
	});
	function headerCellRendererFunc(params) {
        var eHeader = document.createElement('input');
        eHeader.setAttribute('type', 'checkbox');
        eHeader.setAttribute('ng-model', 'checkAll');
        eHeader.addEventListener('click', function (event) {
            var element = event.target;
            if (element && element.checked) {
                var model = params.api.getModel();
                var rowCount = model.getVirtualRowCount();
                var vr = model.getVirtualRowCount.data;
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

	this.gridOptionsAR={
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
	 	             {headerName: "C&oacute;digo", field: "codigoArticulo", width: 80, headerTooltip: "Código"},
				    	{headerName: "Descripci&oacute;n", field: "descripcion", width: 160,headerTooltip: "Descripción"},
				    	{headerName: "T.Art", field: "referenciaMedida", width: 50, headerTooltip: "Tipo Artículo"},
				    	{headerName: "UM", field: "valorUnidadManejo", width: 50, headerTooltip: "Unidad de Medida"},
				    	{headerName: "Clase", field: "claseArticulo", width: 40, headerTooltip: "Clase"},
				    	{headerName: "Cod.Clas", field: "codigoClasificacion",width:50, headerTooltip: "Código clasificación"}]
	};

	articulosRelacionadosController.data = {
            rowCount: null, // behave as infinite scroll
            pageSize: 100,
            overflowSize: 100,
            maxConcurrentRequests: 2,
            maxPagesInCache: 2,
            getRows: function (params) {              
                setTimeout( function() {
                    var rowsThisPage = articulosRelacionadosController.ArticulosRelacionados.slice(params.startRow, params.endRow);
                    var lastRow = -1;
                    if (articulosRelacionadosController.ArticulosRelacionados.length <= params.endRow) {
                        lastRow = articulosRelacionadosController.ArticulosRelacionados.length;
                    }
                    params.successCallback(rowsThisPage, lastRow);
                }, 500);
            }

    };
    articulosRelacionadosController.desactivarArticulosAsignados = function(){
		articulosRelacionadosController.listaArticulosSeleccionados= angular.copy(articulosRelacionadosController.gridOptionsAR.selectedRows);
		articulosRelacionadosController.eliminarArticulosAsignados(articulosRelacionadosController.listaArticulosSeleccionados);
	}
	articulosRelacionadosController.cargarTabla = function(){

		articulosRelacionadosController.gridOptionsAR.api.showLoading(true);
		articulosRelacionadosService.getDataRelacionada(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+
				ws.url+"?codigoCompania="+ws.codigoCompania+"&maxResult="+ws.maxResult+"&firstResult="+ws.firstResult+"&usuario="+articulosRelacionadosController.funcionarioSeleccionado.userId).then(function(data){
					articulosRelacionadosController.ArticulosRelacionados=data;
					articulosRelacionadosController.dataArticulosRelacionados = articulosRelacionadosController.ArticulosRelacionados;
					if (data.length!=0) {
						articulosRelacionadosController.hayDatos=true;
					}else{
						articulosRelacionadosController.hayDatos=false;
					}
	        		if (articulosRelacionadosController.gridOptionsAR.api) {
	        			articulosRelacionadosController.gridOptionsAR.api.setDatasource(articulosRelacionadosController.data);
	        			articulosRelacionadosController.gridOptionsAR.api.onNewRows();	
	        		};
					for(var i=0; i<(articulosRelacionadosController.dataArticulosRelacionados != undefined && articulosRelacionadosController.dataArticulosRelacionados.length);i++){
						console.log("relacionados: " +articulosRelacionadosController.dataArticulosRelacionados[i].codigoArticulo);	
					}
					
		})
				$scope.$emit('dataArticulosRelacionada',articulosRelacionadosController.dataArticulosRelacionados);
	}
	
	$scope.$on('desagregarArticulosEvent', function (event, lista){
		articulosRelacionadosController.listaClaseArticulosDesag=lista;
		articulosRelacionadosController.desagregarArticulos(lista);
	});
	
	articulosRelacionadosController.eliminarArticulosAsignados = function(listaSeleccionados) {
		  for (var i = 0 ; i < (listaSeleccionados != undefined && listaSeleccionados.length) ; i++)
		  	{
			  articulosRelacionadosService.desagregarArticulos(PROPIEDADES.propiedades.server+PROPIEDADES.propiedades.port+PROPIEDADES.propiedades.urlWebServiceDesactivarArticulos.url,
					  'FRM0', PROPIEDADES.propiedades.codigoCompania, listaSeleccionados[i].codigoArticulo, articulosRelacionadosController.funcionarioSeleccionado.userId).then(function(data){
							if (data.status == 'OK'){
							}
							else{
								console.log("status Web Service: FAIL");
							}
				})
				.catch(function(data){
					$scope.$root.$broadcast('message:error', {title: 'Error', message:data.error});
					console.log("status WS: FAIL");
				});			  
			  articulosRelacionadosController.eliminarFila(listaSeleccionados[i].codigoArticulo);
			  console.log("elementos a eliminar:"+ listaSeleccionados[i].codigoArticulo);
			$scope.$broadcast('agregarRegistroTablaArticulosNoRelacionados', listaSeleccionados[i]);
		  	};
	}
	
	articulosRelacionadosController.eliminarFila = function(codigo) {
		for (var i = 0 ; i < (articulosRelacionadosController.ArticulosRelacionados != undefined && articulosRelacionadosController.ArticulosRelacionados.length) ; i++){
			if (articulosRelacionadosController.ArticulosRelacionados[i].codigoArticulo == codigo){
				articulosRelacionadosController.ArticulosRelacionados.splice(i,1);
				break;
			}
		}
		articulosRelacionadosController.gridOptionsAR.api.setDatasource(articulosRelacionadosController.data);
		articulosRelacionadosController.gridOptionsAR.api.onNewRows();
		if (articulosRelacionadosController.ArticulosRelacionados.length == 0) {
                        articulosRelacionadosController.hayDatos=false;
                    }
	}
	
}]);
