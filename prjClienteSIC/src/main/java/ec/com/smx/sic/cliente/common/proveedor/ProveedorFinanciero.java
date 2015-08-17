/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.ppago.jde.dto.VistaProveedorJdeDTO;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class ProveedorFinanciero<T extends VistaProveedorJdeDTO> extends DatosProveedorBase {

	
	public ProveedorFinanciero(T proveedor){
		this.setCodigoJDE(Integer.valueOf(proveedor.getId().getCodigoProveedor()));
		this.setNombreProveedor(proveedor.getNombreProveedor());
		this.setNumeroRUC(proveedor.getRucProveedor());
		
		//telefono
		if (CollectionUtils.isNotEmpty(proveedor.getVistaTelefonos())){
			this.setTelefono(proveedor.getVistaTelefonos().iterator().next().getId().getTelefonoProveedor());
		}
		
		//direccion
		if (CollectionUtils.isNotEmpty(proveedor.getVistaDirecciones())){
			this.setDireccion(proveedor.getVistaDirecciones().iterator().next().getId().getDireccionProveedor());
		}
	}

}
