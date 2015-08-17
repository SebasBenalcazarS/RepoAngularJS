/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * @author jvillacis
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class FleteNacionalID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFLETENACIONAL")
	@SequenceDataBaseValue(name = "SIADMSECFLENAC", descriptorClass = ImpcorpDescriptorSecuencias.class)
	private Long codigoFleteNacional;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFleteNacional
	 */
	public Long getCodigoFleteNacional() {
		return codigoFleteNacional;
	}

	/**
	 * @param codigoFleteNacional establece el valor a la propiedad codigoFleteNacional
	 */
	public void setCodigoFleteNacional(Long codigoFleteNacional) {
		this.codigoFleteNacional = codigoFleteNacional;
	}
	
}
