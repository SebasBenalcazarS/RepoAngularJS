/**
 * 
 */
package ec.com.smx.sic.cliente.common.ofertas.beans;

import ec.com.smx.sic.cliente.resources.ofertas.SICOfertasMessages;

/**
 * @author gnolivos
 *
 */
public enum DatosTablaOfertas {
	
	INDICE_TABLA(SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.indice.id"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.indice.label"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.indice.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.indice.tooltip")),
			
	SELECCIONAR(
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.seleccionar.id"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.seleccionar.label"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.seleccionar.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.seleccionar.tooltip")),
	
	CODIGO_BARRAS(
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.codigobarras.id"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.codigobarras.label"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.codigobarras.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.codigobarras.tooltip")),
	
	DESCRIPCION_ARTICULO(
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.descripcionArticulo.id"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.descripcionArticulo.label"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.descripcionArticulo.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.descripcionArticulo.tooltip")),
	
	PRECIO_VENTA_PUBLICO(SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.id"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.label"), 
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.tooltip"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.inicial"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.precioPvp.final")),
			
	MARGEN_PVP(SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.id"), 
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.label"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.field"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.tooltip"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.inicial"),
			SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.margenPvp.final")),
	
	STYLE_ROW_SELECCIONADO(SICOfertasMessages.getInstancia().getString("ec.com.smx.sic.ofertas.tabla.rowStyleClass"));
	
	private String id;
	private String label;
	private String toolTip;
	private String field;
	private String inicio;
	private String fin;
	
	private DatosTablaOfertas(String id){
		this.id = id;		
	}
	
	private DatosTablaOfertas(String id, String label, String field, String tooltip){
		this.id = id;
		this.label = label;
		this.toolTip=tooltip;
		this.field = field;
	}
	
	private DatosTablaOfertas(String id, String label, String field, String tooltip,String inicial,String fin){
		this.id = id;
		this.label = label;
		this.toolTip=tooltip;
		this.field = field;
		this.inicio = inicial;
		this.fin = fin;
	}

	// Getters and Setters
	
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
}
