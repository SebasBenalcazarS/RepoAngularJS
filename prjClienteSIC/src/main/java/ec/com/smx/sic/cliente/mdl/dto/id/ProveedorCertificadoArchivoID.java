package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Marcelo Hidalgo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ProveedorCertificadoArchivoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALARCHIVO", nullable = false)
	private String secuencialArchivo;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getSecuencialArchivo() {
		return secuencialArchivo;
	}

	public void setSecuencialArchivo(String secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}
	
}
