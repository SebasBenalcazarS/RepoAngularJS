/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.io.Serializable;

/**
 * @author mbraganza
 *
 */
public interface DatosProveedor extends Serializable {
	
	Integer getCodigoJDE();
	
	void setCodigoJDE(Integer codigoJDE);
	
	String getNombreProveedor();
	
	void setNombreProveedor(String nombreProveedor);
	
	String getNumeroRUC();
	
	void setNumeroRUC(String numeroRUC);
	
	String getTelefono();
	
	void setTelefono(String telefono);
	
	String getDireccion();
	
	void setDireccion(String direccion);
}
