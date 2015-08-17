package ec.com.smx.sic.cliente.common.gestionprecios.beans;

import ec.com.smx.sic.cliente.common.tablaslickgridutil.constantes.TipoFormatosTablaSlickGridUtil;

/**
 * Caracteristicas de las columnas que se desean modificar
 * 
 * @author ivasquez
 *
 */
public class ConfiguracionColumnasTablaSlickGrid {

	private TipoFormatosTablaSlickGridUtil tiposFormatoTablaSlickGrid;
	
	private Integer ordenColumna;
	private Integer anchoColumna;
	
	private String estiloColumna;
	private String editor;
	
	private Boolean columnaEstatica;
	
	
	/*
	 * GETTERS AND SETTERS
	 */

	public Integer getOrdenColumna() {
		return ordenColumna;
	}

	public void setOrdenColumna(Integer ordenColumna) {
		this.ordenColumna = ordenColumna;
	}

	public TipoFormatosTablaSlickGridUtil getTiposFormatoTablaSlickGrid() {
		return tiposFormatoTablaSlickGrid;
	}

	public void setTiposFormatoTablaSlickGrid(TipoFormatosTablaSlickGridUtil tiposFormatoTablaSlickGrid) {
		this.tiposFormatoTablaSlickGrid = tiposFormatoTablaSlickGrid;
	}

	public Integer getAnchoColumna() {
		return anchoColumna;
	}

	public void setAnchoColumna(Integer anchoColumna) {
		this.anchoColumna = anchoColumna;
	}

	public String getEstiloColumna() {
		return estiloColumna;
	}

	public void setEstiloColumna(String estiloColumna) {
		this.estiloColumna = estiloColumna;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Boolean getColumnaEstatica() {
		return columnaEstatica;
	}

	public void setColumnaEstatica(Boolean columnaEstatica) {
		this.columnaEstatica = columnaEstatica;
	}

}
