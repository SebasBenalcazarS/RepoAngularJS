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

@Embeddable
@SuppressWarnings({"serial"})
public class TramiteEmbarqueImpID extends BaseID{
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALTRAMITE")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMTSECTRAEMB")
	private Long secuencialTramite;

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

}
