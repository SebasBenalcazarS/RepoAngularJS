/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class ParametrosProveedorVO implements Serializable {
	
	private ParametroDTO cantidadUsuariosProveedorPorDefecto;

	/**
	 * @return the cantidadUsuariosProveedorPorDefecto
	 */
	public ParametroDTO getCantidadUsuariosProveedorPorDefecto() {
		return cantidadUsuariosProveedorPorDefecto;
	}

	/**
	 * @param cantidadUsuariosProveedorPorDefecto the cantidadUsuariosProveedorPorDefecto to set
	 */
	public void setCantidadUsuariosProveedorPorDefecto(
			ParametroDTO cantidadUsuariosProveedorPorDefecto) {
		this.cantidadUsuariosProveedorPorDefecto = cantidadUsuariosProveedorPorDefecto;
	}
	
	

}
