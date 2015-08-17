package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class UsuarioArticuloID implements Serializable {

	/**
	 * codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	/**
	 * codigo de articulo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	/**
	 * codigo de usuario
	 */
	@Column(name = "CODIGOUSUARIO", nullable = false)
	private String codigoUsuario;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	
}
