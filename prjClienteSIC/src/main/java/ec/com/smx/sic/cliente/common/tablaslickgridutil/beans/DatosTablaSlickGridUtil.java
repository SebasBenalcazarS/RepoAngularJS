package ec.com.smx.sic.cliente.common.tablaslickgridutil.beans;

import ec.com.smx.sic.cliente.common.tablaslickgridutil.constantes.TipoFormatosTablaSlickGridUtil;
import ec.com.smx.sic.cliente.resources.tablaslickgridutil.SICTablaSlickGridUtilMessages;

/**
 * Columnas que iran en las tablas con sus datos por defecto
 * 
 * @author ivasquez
 *
 */
public enum DatosTablaSlickGridUtil {

	/**
	 * Campos que iran en la tabla
	 */
	REGLAS_CALCULO_PRECIOS(
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.reglasCalculoPrecios")),
	
	CODIGO_ARTICULO(
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigoArticulo")),
			
	COLUMNS_TABLA_SLICK_GRID(
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.parametros.columnasSlickGrid")),
			
	MODO_EDITAR_TABLA(
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.parametros.editar")),
	
	OBSERVACIONES_ARTICULO(24,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.observacionesArticulo.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.observacionesArticulo.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.observacionesArticulo.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.observacionesArticulo.tooltip"),
			250, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-left", false),
					
	PRECIO_SMX_NA(23,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmxNa.final"),
			128, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
	
	MARGEN_SMX(22,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenSmx.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
					
	PRECIO_SMX(21,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioSmx.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
					
	MARGEN_PVP(20,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.margenPvp.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
					
	PRECIO_VENTA_PUBLICO(19,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.precioPvp.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
					
	FECHA_FIN_VENTA(18,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinVenta.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinVenta.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinVenta.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinVenta.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
					
	FECHA_INICIO_VENTA(17,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioVenta.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioVenta.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioVenta.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioVenta.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
	
	APLICA_DESCUENTO(16,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.aplicaDescuento.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.aplicaDescuento.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.aplicaDescuento.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.aplicaDescuento.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
					
	DESCUENTO_COSTO(15,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descuentoCosto.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descuentoCosto.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descuentoCosto.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descuentoCosto.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
			
	COSTO_BRUTO(14,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoBruto.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
			
	FECHA_FIN_COSTO(13,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinCosto.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinCosto.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinCosto.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaFinCosto.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
					
	FECHA_INICIO_COSTO(12,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioCosto.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioCosto.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioCosto.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechaInicioCosto.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
			
	COSTO_NETO(11,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.tooltip"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.inicial"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.costoNeto.final"),
			106, TipoFormatosTablaSlickGridUtil.FORMATO_RANGO_NORMAL.getValue(), "align-right", false),
					
	NOMBRE_PROVEEDOR(10,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.nombreProveedor.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.nombreProveedor.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.nombreProveedor.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.nombreProveedor.tooltip"),
			100, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "align-left", false),
			
	CODIGO_JDE_PROVEEDOR(9,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigoJDEProveedor.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigoJDEProveedor.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigoJDEProveedor.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigoJDEProveedor.tooltip"),
			69, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "align-left", false),
	
	FECHAS_MULTIPLES(8,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechasMultiples.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechasMultiples.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechasMultiples.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.fechasMultiples.tooltip"),
			60, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", true),		
			
	PROVEEDORES_RELACIONADOS(7,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.proveedoresRelacionados.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.proveedoresRelacionados.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.proveedoresRelacionados.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.proveedoresRelacionados.tooltip"),
			40, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
			
	CONFLICTOS(6,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.conflictos.id"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.conflictos.label"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.conflictos.field"),
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.conflictos.tooltip"),
			40, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),		
			
	COLUMN_MEDIDA_ARTICULO(5,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.tamano.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.tamano.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.tamano.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.tamano.tooltip"),
			40, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "align-left", false),		
			
	DESCRIPCION_ARTICULO(4,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descripcionArticulo.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descripcionArticulo.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descripcionArticulo.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.descripcionArticulo.tooltip"),
			169, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "align-left", false),
					
	CODIGO_BARRAS(3,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigobarras.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigobarras.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigobarras.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.codigobarras.tooltip"),
			132, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "cell-title align-left", false),
			
	SELECCIONAR(2,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.seleccionar.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.seleccionar.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.seleccionar.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.seleccionar.tooltip"),
			30, TipoFormatosTablaSlickGridUtil.FORMATO_ESPECIAL.getValue(), "align-center", false),
					
	INDICE_TABLA(1,
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.indice.id"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.indice.label"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.indice.field"), 
			SICTablaSlickGridUtilMessages.getInstancia().getString("ec.com.smx.sic.tablaslickgrid.indice.tooltip"),
			33, TipoFormatosTablaSlickGridUtil.FORMATO_NORMAL.getValue(), "class-num-row", false);

	
	private Integer ordenColumna;
	private String id;
	private String label;
	private String toolTip;
	private String field;
	private String inicio;
	private String fin;
	private Integer anchoColumna;
	private String formatoColumna;
	private String estiloColumna;
	private Boolean columnaEstatica;
	

	/**
	 * 
	 * @param id
	 */
	private DatosTablaSlickGridUtil(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param ordenColumna
	 * @param id
	 * @param label
	 * @param field
	 * @param tooltip
	 * @param anchoColumna
	 * @param formatoColumna
	 * @param estiloColumna
	 * @param columnaEstatica
	 */
	private DatosTablaSlickGridUtil(Integer ordenColumna, String id, String label, String field, String tooltip, Integer anchoColumna, String formatoColumna, String estiloColumna,
			Boolean columnaEstatica) {
		this.ordenColumna = ordenColumna;
		this.id = id;
		this.label = label;
		this.toolTip = tooltip;
		this.field = field;
		this.anchoColumna = anchoColumna;
		this.formatoColumna = formatoColumna;
		this.estiloColumna = estiloColumna;
		this.columnaEstatica = columnaEstatica;
	}

	/**
	 * 
	 * @param ordenColumna
	 * @param id
	 * @param label
	 * @param field
	 * @param tooltip
	 * @param inicio
	 * @param fin
	 * @param anchoColumna
	 * @param formatoColumna
	 * @param estiloColumna
	 * @param columnaEstatica
	 */
	private DatosTablaSlickGridUtil(Integer ordenColumna, String id, String label, String field, String tooltip, String inicio, String fin, Integer anchoColumna, 
			String formatoColumna, String estiloColumna, Boolean columnaEstatica){
		this.ordenColumna = ordenColumna;
		this.id = id;
		this.label = label;
		this.toolTip=tooltip;
		this.field = field;
		this.inicio = inicio;
		this.fin = fin;
		this.anchoColumna = anchoColumna;
		this.formatoColumna = formatoColumna;
		this.estiloColumna = estiloColumna;
		this.columnaEstatica = columnaEstatica;
	}
	
	
	/*
	 * GETTERS AND SETTERS
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public Integer getAnchoColumna() {
		return anchoColumna;
	}

	public void setAnchoColumna(Integer anchoColumna) {
		this.anchoColumna = anchoColumna;
	}

	public String getFormatoColumna() {
		return formatoColumna;
	}

	public void setFormatoColumna(String formatoColumna) {
		this.formatoColumna = formatoColumna;
	}

	public String getEstiloColumna() {
		return estiloColumna;
	}

	public void setEstiloColumna(String estiloColumna) {
		this.estiloColumna = estiloColumna;
	}

	public Integer getOrdenColumna() {
		return ordenColumna;
	}

	public void setOrdenColumna(Integer ordenColumna) {
		this.ordenColumna = ordenColumna;
	}

	public Boolean getColumnaEstatica() {
		return columnaEstatica;
	}

	public void setColumnaEstatica(Boolean columnaEstatica) {
		this.columnaEstatica = columnaEstatica;
	}
}
