
angular.module('asignacionUsuarios').controller('ReporteClasificacionesController' , ['$scope', 'reporteService', 'PROPIEDADES', function ($scope, reporteService, PROPIEDADES) {

	'use strict';
	var reporteController = this;
	reporteController.txtCodigoEstructura='';
	reporteController.txtUsuario='';
	reporteController.listaClasificaciones=[];
	reporteController.max=25;
	reporteController.filaInicio=0;
	var ws = PROPIEDADES.propiedades.reporteAutorizacionUsuarioClasificaciones;


	reporteController.gridOptions = {
		//enableSorting: true,
        //enableFilter: true,
		//rowData: null,
		rowSelection: 'multiple',
		//rowHeight: 25,
    	//virtualPaging: true,
    	pageSize: 20,
    	enableColResize: true,
    	columnDefs: [
    	{headerName: "Usuario", field: "userId", width: 95, headerTooltip: "Usuario"},
    	{headerName: "Descripci&oacute;n usuario", field: "userCompleteName", width: 180,headerTooltip: "Descripción usuario"},
    	{headerName: "Cod. Clasificaci&oacute;n", field: "codigoClasificacion", width: 110, headerTooltip: "Código clasificación"},
    	{headerName: "Descripci&oacute;n Clasificaci&oacute;n", field: "descripcionClasificacion", width: 205, headerTooltip: "Descripción clasificación"}
    	]
    };

    reporteController.data = {
            rowCount: null, // behave as infinite scroll
            pageSize: 20,
            //overflowSize: 100,
           
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
			for (var i = 0; i < result.length; i++) {
				reporteController.listaClasificaciones.push(result[i]);
			};
			if (reporteController.gridOptions.api) {
				reporteController.gridOptions.api.setDatasource(reporteController.data);
				reporteController.gridOptions.api.onNewRows();	
			};
			


		})
	}


	
	
}]);