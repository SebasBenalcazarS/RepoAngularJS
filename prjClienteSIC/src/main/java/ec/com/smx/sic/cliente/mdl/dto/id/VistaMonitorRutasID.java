package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaMonitorRutasID extends BaseID {
	
	/**
	 * Codigo compania
	 */
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	/**
	 * Codigo Localizacion
	 */
	@Column(name = "NUMERORUTA")
	private java.lang.Long numeroRuta;
	
	
	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	
	/**
	 * 
	 * @param codigoCompania
	 *            the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	/**
	 * @return the numeroRuta
	 */
	public java.lang.Long getNumeroRuta() {
		return numeroRuta;
	}
	
	/**
	 * @param numeroRuta the numeroRuta to set
	 */
	public void setNumeroRuta(java.lang.Long numeroRuta) {
		this.numeroRuta = numeroRuta;
	}
}
