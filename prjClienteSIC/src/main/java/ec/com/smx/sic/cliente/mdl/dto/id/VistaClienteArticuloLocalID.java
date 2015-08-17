
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase VistaClienteArticuloLocal
 *
 * @author mrivera
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaClienteArticuloLocalID extends BaseID {

	
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania ;
	
	@Column(name="SECUENCIALCLIENTEARTICULO")
	private Long secuencialClienteArticulo;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * 
	 * @return the secuencialClienteArticulo
	 */
	public Long getSecuencialClienteArticulo() {
		return secuencialClienteArticulo;
	}

	/**
	 * 
	 * @param secuencialClienteArticulo the secuencialClienteArticulo to set
	 */
	public void setSecuencialClienteArticulo(Long secuencialClienteArticulo) {
		this.secuencialClienteArticulo = secuencialClienteArticulo;
	}
	
}

