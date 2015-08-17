/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;




/**
 * @author Mario Braganza
 *
 */
public interface IIdentificadorProveedorVO extends Serializable{
	
	void setCodigoCompania(Integer codigoCompania);
	
	Integer getCodigoCompania();
	
	TipoValidacionProveedor getTipoValidacionProveedor();
	
	/**
	 * Obtiene el tipo de proveedor enviados en la implementacion
	 * 
	 * @author ivasquez
	 */
	String getTipoProveedor();	
}
