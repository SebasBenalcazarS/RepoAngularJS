package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * 
 * @author acastillo
 *
 */
@SuppressWarnings({"serial"})
@Embeddable
public class BitacoraTramiteEmbarqueImpID extends BaseID{

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALTRAMITE")
	private Long secuencialTramite;
	
	@Column(name = "SECUENCIALBITACORATRAEMB")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMTSECBITTRAEMB")
	private Long secuencialBitTraEmb;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getSecuencialTramite() {
		return secuencialTramite;
	}

	public void setSecuencialTramite(Long secuencialTramite) {
		this.secuencialTramite = secuencialTramite;
	}

	public Long getSecuencialBitTraEmb() {
		return secuencialBitTraEmb;
	}

	public void setSecuencialBitTraEmb(Long secuencialBitTraEmb) {
		this.secuencialBitTraEmb = secuencialBitTraEmb;
	}
}
