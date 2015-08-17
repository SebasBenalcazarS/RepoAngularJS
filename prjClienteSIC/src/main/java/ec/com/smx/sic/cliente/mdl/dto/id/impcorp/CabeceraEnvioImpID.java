package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

@Embeddable
@SuppressWarnings("serial")
public class CabeceraEnvioImpID extends BaseID{
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
		
	@Column(name = "CODIGOENVIO")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSCABENV")
	private Long codigoEnvio;

	

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
	 * @return the codigoEnvio
	 */
	public Long getCodigoEnvio() {
		return codigoEnvio;
	}

	/**
	 * @param codigoEnvio the codigoEnvio to set
	 */
	public void setCodigoEnvio(Long codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}
	
	
}
