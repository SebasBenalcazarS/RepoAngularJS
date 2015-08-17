package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class CategoriaErrorID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
	
	@Column(name = "CODIGOCATERR", nullable = false)
	private String codigoCategoriaError;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoCategoriaError() {
		return codigoCategoriaError;
	}

	public void setCodigoCategoriaError(String codigoCategoriaError) {
		this.codigoCategoriaError = codigoCategoriaError;
	}
}
