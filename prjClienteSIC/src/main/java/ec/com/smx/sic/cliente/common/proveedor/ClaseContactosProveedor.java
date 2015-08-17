/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Luis Yacchirema
 * 
 */
public class ClaseContactosProveedor {

	private final Integer codigoClaseContacto;
		
	public ClaseContactosProveedor(Integer codigoClaseContacto){
		this.codigoClaseContacto = codigoClaseContacto;
	}
	
	/**
	 * @return the codigoClaseContacto
	 */
	public Integer getCodigoClaseContacto() {
		return codigoClaseContacto;
	}

	public static final ClaseContactosProveedor GRUPO_CONTACTOS_PROVEEDORES = new ClaseContactosProveedor(SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.claseContactosProveedor.proveedores.codigo")){};
	public static final ClaseContactosProveedor GRUPO_CONTACTOS_PROVEEDOR_NACIONAL = new ClaseContactosProveedor(SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.claseContactosProveedor.proveedor.nacional.codigo")){};
	public static final ClaseContactosProveedor GRUPO_CONTACTOS_PROVEEDOR_IMPORTADO = new ClaseContactosProveedor(SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.claseContactosProveedor.proveedor.importado.codigo")){};
	public static final ClaseContactosProveedor GRUPO_CONTACTOS_OFICINA_EXTERIOR = new ClaseContactosProveedor(SICProveedorMessages.getInstancia().getInteger("ec.com.smx.max.claseContactosProveedor.proveedor.oficina.exterior.codigo")){};
}