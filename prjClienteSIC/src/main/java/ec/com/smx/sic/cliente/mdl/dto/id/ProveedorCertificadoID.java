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
public class ProveedorCertificadoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "SECUENCIALCERTIFICADO", nullable = false)
	private String secuencialCertificado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getSecuencialCertificado() {
		return secuencialCertificado;
	}

	public void setSecuencialCertificado(String secuencialCertificado) {
		this.secuencialCertificado = secuencialCertificado;
	}

}
