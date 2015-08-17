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
public class GastoEmbarqueID extends BaseID {
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOGASTOEMBARQUE")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SIADMSECGASEMB")
	private Long codigoGastoEmbarque;

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
	 * @return devuelve el valor de la propiedad codigoGastoEmbarque
	 */
	public Long getCodigoGastoEmbarque() {
		return codigoGastoEmbarque;
	}

	/**
	 * @param codigoGastoEmbarque establece el valor a la propiedad codigoGastoEmbarque
	 */
	public void setCodigoGastoEmbarque(Long codigoGastoEmbarque) {
		this.codigoGastoEmbarque = codigoGastoEmbarque;
	}

}
