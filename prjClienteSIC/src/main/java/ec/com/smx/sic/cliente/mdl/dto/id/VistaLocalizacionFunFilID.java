package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaLocalizacionFunFilID extends BaseID {
	
	/**
	 * Codigo compania
	 */
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	/**
	 * Codigo Localizacion
	 */
	@Column(name = "CODIGOLOCALIZACION")
	private java.lang.Long codigoLocalizacion;
	
	
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
	 * @return the codigoLocalizacion
	 */
	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	/**
	 * @param codigoLocalizacion the codigoLocalizacion to set
	 */
	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}

}
