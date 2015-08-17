package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class EstructuraComercialCuentaContableProcesoID implements Serializable{

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	/**
	 * Especifica el codigo de la factura estructura comercial
	 *
	 */
	@Column(name = "CODESTCOMCUECONPRO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSECESTCOMCUECONPRO")
	private Long codigoEstructuraComercialCuentaContableProceso;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoEstructuraComercialCuentaContableProceso() {
		return codigoEstructuraComercialCuentaContableProceso;
	}

	public void setCodigoEstructuraComercialCuentaContableProceso(Long codigoEstructuraComercialCuentaContableProceso) {
		this.codigoEstructuraComercialCuentaContableProceso = codigoEstructuraComercialCuentaContableProceso;
	}
}
