/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.interfaces;

import java.io.Serializable;

/**
 * @author Mario Braganza
 *
 */
public interface IBaseEntidadID extends Serializable {
	
	void setCodigoCompania(Integer codigoCompania);
	
	Integer getCodigoCompania();

}
