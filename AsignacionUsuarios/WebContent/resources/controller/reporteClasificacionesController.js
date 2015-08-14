
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
	
}]);