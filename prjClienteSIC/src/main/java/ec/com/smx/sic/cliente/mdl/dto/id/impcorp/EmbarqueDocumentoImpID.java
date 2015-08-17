package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * 
 * @author jcruz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class EmbarqueDocumentoImpID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUEDOCUMENTO")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSEMBDOC")
	private Long codigoEmbaqueDocumento;

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
	 * @return the codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque the codigoEmbarque to set
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return the codigoEmbaqueDocumento
	 */
	public Long getCodigoEmbaqueDocumento() {
		return codigoEmbaqueDocumento;
	}

	/**
	 * @param codigoEmbaqueDocumento the codigoEmbaqueDocumento to set
	 */
	public void setCodigoEmbaqueDocumento(Long codigoEmbaqueDocumento) {
		this.codigoEmbaqueDocumento = codigoEmbaqueDocumento;
	}
}
