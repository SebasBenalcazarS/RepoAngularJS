/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.io.Serializable;

import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class TipoProveedor implements Serializable {
	
	private final String valorTipoProveedor;
	public final static Integer CODIGO_TIPO_PROVEEDOR = TiposCatalogoConstantes.TIPO_PROVEEDOR;
	
	public TipoProveedor(String valorTipoProveedor){
		this.valorTipoProveedor = valorTipoProveedor;
	}
	
	
	
	/**
	 * @return the valorTipoProveedor
	 */
	public String getValorTipoProveedor() {
		return valorTipoProveedor;
	}



	public final static TipoProveedor ARTICULOS = new TipoProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.proveedor.articulo")) {};
	public final static TipoProveedor SERVICIOS = new TipoProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.proveedro.servicio")) {};
	public final static TipoProveedor ARTICULOSSERVICIOS = new TipoProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.proveedro.articuloservicio")) {};

}
