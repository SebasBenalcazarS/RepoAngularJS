/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class PalletJackID implements Serializable{
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo del pallet jack
	 * 
	 */
	@Column(name = "CODIGOPALLETJACK", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECPALJAC")
	private Long codigoPalletJack;

	/**
	 *  
	 * SETTERS & GETTERS
	 * 
	 */
	
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
	 * @return the codigoPalletJack
	 */
	public Long getCodigoPalletJack() {
		return codigoPalletJack;
	}

	/**
	 * @param codigoPalletJack the codigoPalletJack to set
	 */
	public void setCodigoPalletJack(Long codigoPalletJack) {
		this.codigoPalletJack = codigoPalletJack;
	}
	
	
}
