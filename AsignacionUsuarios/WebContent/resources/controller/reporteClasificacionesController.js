
angular.module('asignacionUsuarios').controller('ReporteClasificacionesController' , ['$scope', function ($scope) {

	'use strict';
	var reporteController = this;

	this.gridOptions = {
		//enableSorting: true,
        //enableFilter: true,
		//rowData: null,
		rowSelection: 'multiple',
		//rowHeight: 25,
    	//virtualPaging: true,
    	enableColResize: true,
    	columnDefs: [
    	{headerName: "Usuario", field: "codigoArticulo", width: 90, headerTooltip: "Usuario"},
    	{headerName: "Descripci&oacute;n usuario", field: "descripcion", width: 180,headerTooltip: "Descripción usuario"},
    	{headerName: "Cod. Clasificaci&oacute;n", field: "referenciaMedida", width: 110, headerTooltip: "Código clasificación"},
    	{headerName: "Descripci&oacute;n Clasificaci&oacute;n", field: "valorUnidadManejo", width: 200, headerTooltip: "Descripción clasificación"}
    	]
    };
	
}]);