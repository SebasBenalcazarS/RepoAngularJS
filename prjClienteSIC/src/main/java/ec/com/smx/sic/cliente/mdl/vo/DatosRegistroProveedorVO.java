/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;

/**
 * @author Mario Braganza, Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class DatosRegistroProveedorVO extends DatosRegistroEntidadVO<ResultadoValidacionProveedor, ProveedorVO> {
	
	private Collection<UsuarioProveedor> usuariosProveedor;
	private Collection<ProveedorOficinaExteriorDTO> detalleProveedorOficinaExterior;

	/**
	 * 
	 * @param entidad
	 * @param resultadoValidacionEntidad
	 */
	public DatosRegistroProveedorVO(ProveedorVO entidad,
			ResultadoValidacionProveedor resultadoValidacionProveedor) {
		
		super(entidad, resultadoValidacionProveedor);
	}

	/**
	 * @return the detalleProveedorOficinaExterior
	 */
	public Collection<ProveedorOficinaExteriorDTO> getDetalleProveedorOficinaExterior() {
		return detalleProveedorOficinaExterior;
	}

	/**
	 * @param detalleProveedorOficinaExterior the detalleProveedorOficinaExterior to set
	 */
	public void setDetalleProveedorOficinaExterior(
			Collection<ProveedorOficinaExteriorDTO> detalleProveedorOficinaExterior) {
		this.detalleProveedorOficinaExterior = detalleProveedorOficinaExterior;
	}

	/**
	 * @return the usuariosProveedor
	 */
	public Collection<UsuarioProveedor> getUsuariosProveedor() {
		return usuariosProveedor;
	}

	/**
	 * @param usuariosProveedor the usuariosProveedor to set
	 */
	public void setUsuariosProveedor(Collection<UsuarioProveedor> usuariosProveedor) {
		this.usuariosProveedor = usuariosProveedor;
	}
}
