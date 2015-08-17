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
public class EmbarqueFactorID extends BaseID {
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUEFACTOR")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECEMBFCT")
	private Long codigoEmbarqueFactor;

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
	 * @return devuelve el valor de la propiedad codigoEmbarqueFactor
	 */
	public Long getCodigoEmbarqueFactor() {
		return codigoEmbarqueFactor;
	}

	/**
	 * @param codigoEmbarqueFactor establece el valor a la propiedad codigoEmbarqueFactor
	 */
	public void setCodigoEmbarqueFactor(Long codigoEmbarqueFactor) {
		this.codigoEmbarqueFactor = codigoEmbarqueFactor;
	}
	
}
