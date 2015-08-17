package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

@SuppressWarnings("serial")
@Embeddable
public class FacturaGastoEmbarqueImpID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTURAGASTO")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECFACGAS")
	private Long codigoFacturaGasto;

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
	 * @return the codigoFacturaGasto
	 */
	public Long getCodigoFacturaGasto() {
		return codigoFacturaGasto;
	}

	/**
	 * @param codigoFacturaGasto the codigoFacturaGasto to set
	 */
	public void setCodigoFacturaGasto(Long codigoFacturaGasto) {
		this.codigoFacturaGasto = codigoFacturaGasto;
	}
}