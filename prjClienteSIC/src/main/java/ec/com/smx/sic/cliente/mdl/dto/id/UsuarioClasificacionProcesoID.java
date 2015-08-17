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
public class UsuarioClasificacionProcesoID implements Serializable{

	/**
	 * codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	/**
	 * codigo de clasificacion
	 */
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;
	
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

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	
}
