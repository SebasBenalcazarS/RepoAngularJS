package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

@Embeddable
@SuppressWarnings("serial")
public class CabeceraEnvioDetalleImpID extends BaseID{
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
		
	@Column(name = "SECUENCIALCABENVDET")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSCABENVDET")
	private Long codigoCabeceraEnvioDetalle;
	
	@Column(name = "CODIGOENVIO")
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

	/**
	 * @return the codigoCabeceraEnvioDetalle
	 */
	public Long getCodigoCabeceraEnvioDetalle() {
		return codigoCabeceraEnvioDetalle;
	}

	/**
	 * @param codigoCabeceraEnvioDetalle the codigoCabeceraEnvioDetalle to set
	 */
	public void setCodigoCabeceraEnvioDetalle(Long codigoCabeceraEnvioDetalle) {
		this.codigoCabeceraEnvioDetalle = codigoCabeceraEnvioDetalle;
	}
	
	
}
