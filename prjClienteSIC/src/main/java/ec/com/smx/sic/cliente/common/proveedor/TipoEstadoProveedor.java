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
public class TipoEstadoProveedor implements Serializable{
	
	private final String valorTipoEstadoProveedor;
	public final static Integer CODIGO_TIPO_ESTADO_PROVEEDOR = TiposCatalogoConstantes.TIPO_ESTADO_PROVEEDOR;
	
	public TipoEstadoProveedor(String valorTipoEstadoProveedor){
		this.valorTipoEstadoProveedor = valorTipoEstadoProveedor;
	}
	
	

	/**
	 * @return the valorTipoEstadoProveedor
	 */
	public String getValorTipoEstadoProveedor() {
		return valorTipoEstadoProveedor;
	}



	public static final TipoEstadoProveedor DEFINITIVO = new TipoEstadoProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.estado.proveedor.definitivo")) {};
	public static final TipoEstadoProveedor PROVISIONAL = new TipoEstadoProveedor(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.estado.proveedro.provisional")) {};
}
