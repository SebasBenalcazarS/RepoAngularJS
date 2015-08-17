/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class UsuarioEntidadProveedorID implements Serializable {

	private String idUsuario;
	
	/**
	 * @return el idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario el idUsuario a establecer
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
