/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.common.bodega.CabeceraCalendarioDia;

/**
 * <b> VO para el manejo de informacion que se muestra en el SlickGrid. </b>
 * 
 * @author mchiliquinga, Date: 24/03/2014
 * 
 */
public class SlickGridVO implements Serializable {
	/**
	* 
	*/ 
	private static final long serialVersionUID = -5060687650251496110L;

	private String cabeceraGrid;

	private String datosGrid;

	private Collection<Map<String, Object>> datosGridCollection;

	private CabeceraCalendarioDia cabeceraLabelGrid;

	private Collection<String> mensajesError;

	private Collection<String> mensajesInformacion;

	public String getCabeceraGrid() {
		return cabeceraGrid;
	}

	public void setCabeceraGrid(String cabeceraGrid) {
		this.cabeceraGrid = cabeceraGrid;
	}

	public String getDatosGrid() {
		return datosGrid;
	}

	public void setDatosGrid(String datosGrid) {
		this.datosGrid = datosGrid;
	}

	public Collection<Map<String, Object>> getDatosGridCollection() {
		return datosGridCollection;
	}

	public void setDatosGridCollection(Collection<Map<String, Object>> datosGridCollection) {
		this.datosGridCollection = datosGridCollection;
	}

	public CabeceraCalendarioDia getCabeceraLabelGrid() {
		return cabeceraLabelGrid;
	}

	public void setCabeceraLabelGrid(CabeceraCalendarioDia cabeceraLabelGrid) {
		this.cabeceraLabelGrid = cabeceraLabelGrid;
	}

	public Collection<String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(Collection<String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public Collection<String> getMensajesInformacion() {
		return mensajesInformacion;
	}

	public void setMensajesInformacion(Collection<String> mensajesInformacion) {
		this.mensajesInformacion = mensajesInformacion;
	}

}
