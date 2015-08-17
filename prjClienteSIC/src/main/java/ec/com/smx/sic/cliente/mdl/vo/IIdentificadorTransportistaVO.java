/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;




/**
 * @author Mario Braganza
 *
 */
public interface IIdentificadorTransportistaVO extends Serializable{
	
	void setCodigoCompania(Integer codigoCompania);
	
	Integer getCodigoCompania();
	
}
