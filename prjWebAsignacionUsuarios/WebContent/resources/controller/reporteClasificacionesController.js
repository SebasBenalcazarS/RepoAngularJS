
angular.module('asignacionUsuarios').controller('ReporteClasificacionesController' , ['$scope', 'reporteService', 'PROPIEDADES', function ($scope, reporteService, PROPIEDADES) {

	'use strict';
	var reporteController = this;
	reporteController.txtCodigoEstructura='';
	reporteController.txtUsuario='';
	reporteController.listaClasificaciones=[];
	reporteController.max=20;
	reporteController.filaInicio=0;
	var ws = PROPIEDADES.propiedades.reporteAutorizacionUsuarioClasificaciones;


	reporteController.gridOptions = {
		enableSorting: true,
        enableFilter: true,
		//rowData: null,
		//rowSelection: 'multiple',
		//rowHeight: 25,
    	virtualPaging: true,
    	overflowSize: 20,
    	rowsBuffer:20,
    	pageSize: 20,
    	enableColResize: true,
    	columnDefs: [
    	{headerName: "Usuario", field: "codigoUsuario", width: 95, headerTooltip: "Usuario", filter: 'set'},
    	{headerName: "Descripci&oacute;n usuario", field: "userCompleteName", width: 180,headerTooltip: "Descripción usuario", filter: 'set'},
    	{headerName: "Cod. Clasificaci&oacute;n", field: "codigoClasificacion", width: 110, headerTooltip: "Código clasificación"},
    	{headerName: "Descripci&oacute;n Clasificaci&oacute;n", field: "descripcionClasificacion", width: 205, headerTooltip: "Descripción clasificación"}
    	]
    };

    reporteController.data = {
            rowCount: null, // behave as infinite scroll
            pageSize: 20,
            rowsBuffer:20,
            overflowSize: 20,
           
            getRows: function (params) {              
            	setTimeout( function() {
            		var rowsThisPage = reporteController.listaClasificaciones.slice(params.startRow, params.endRow);
            		var lastRow = -1;
            		if (reporteController.listaClasificaciones.length <= params.endRow) {
            			lastRow = reporteController.listaClasificaciones.length;
            		}
            		params.successCallback(rowsThisPage, lastRow);
            	}, 500);
            }
        };

     reporteController.clickBuscarReporteClasificaciones = function(){
      	$scope.$broadcast('actualizarPaginador', true);
		reporteController.filaInicio=0;
		reporteController.numPagActual=1;
		reporteController.buscarReporteClasificaciones();
      }


	reporteController.buscarReporteClasificaciones= function(){

		reporteController.gridOptions.api.showLoading=true;
		reporteController.req = {
	       		method: 'POST',
	       		url: 'http://localhost:8080/prjWebServicesSICWeb/ws/autorizacionUsuarios/reporteAutorizacionUsuarioClasificaciones',
	       		headers: {
	       			'Content-Type': 'application/json; charset=utf-8',
	       			'dataType': 'json'
	       		},
	       		data: { codigoCompania:ws.codigoCompania,
	       			maxResult:reporteController.max,
	       			firstResult: reporteController.filaInicio,
	       			usuarioSesion:'',
	       			descripcion:reporteController.txtUsuario,
	       			codigoEstructura: reporteController.txtCodigoEstructura}
       		}

		reporteService.getReporteClasificaciones(reporteController.req).then(function(result){
			reporteController.listaClasificaciones=[];
			for (var i = 0; i <= result.coleccionClasificaciones.length-1 ; i++) {
				reporteController.listaClasificaciones.push(result.coleccionClasificaciones[i]);
			};
			reporteController.crearDataSource(reporteController.listaClasificaciones);
            		$scope.$broadcast('numeroClasificaciones', result.numeroClasificaciones, reporteController.max);
       				console.log('reporteController.listaClasificaciones: '+ reporteController.listaClasificaciones.length);
			/*
			if (reporteController.gridOptions.api) {
				reporteController.gridOptions.api.setDatasource(reporteController.data);
				reporteController.gridOptions.api.onNewRows();	
			};*/
		})
	}

	$scope.$on('numPaginaaMostrar', function(event, numPagina, estado){
		if(estado){
			reporteController.filaInicio=(numPagina*reporteController.max)- reporteController.max;	
			reporteController.buscarReporteClasificaciones();
		}
		
		//event.stopPropagation();
	});

	reporteController.crearDataSource=function(result){
				var allOfTheData = result;
            	var dataSource = {
                rowCount: -1, 
                pageSize: 20,
                overflowSize: 20,
                virtualPaging: true,
                enableSorting: true,
        		enableFilter: true,

                getRows: function (params) {
                    console.log('asking for ' + reporteController.filaInicio + ' to ' + (reporteController.filaInicio+20));
                        var rowsThisPage = allOfTheData.slice(0,reporteController.max) ;
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
            if (reporteController.gridOptions.api) {
            	reporteController.gridOptions.api.setDatasource(dataSource);
            };
	}


	
	
}]);