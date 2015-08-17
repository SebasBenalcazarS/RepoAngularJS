package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * 
 * @author acastillo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class TramiteArchivoImpID extends BaseID{

	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="SECUENCIALTRAMITE")
	private Long secuencialTramite;
	
	@Column(name="SECUENCIALARCHIVO")
	private Long secuencialArchivo;

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

	public Long getSecuencialArchivo() {
		return secuencialArchivo;
	}

	public void setSecuencialArchivo(Long secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}
}
