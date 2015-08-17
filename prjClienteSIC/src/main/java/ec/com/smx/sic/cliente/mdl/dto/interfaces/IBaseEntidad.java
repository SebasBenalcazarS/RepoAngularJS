/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.interfaces;

import java.io.Serializable;

import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;

/**
 * @author Mario Braganza
 *
 */
public interface IBaseEntidad extends Serializable {
	
	IBaseEntidadID getId();
	
	void setCodigoPersona(Long codigoPersona);
	
	Long getCodigoPersona();
	
	void setCodigoLocalizacionProveedor(Long codigoLocalizacionProveedor);
	
	Long getCodigoLocalizacionProveedor();
	
	void setCodigoLocalizacion(Long codigoLocalizacion);
	
	Long getCodigoLocalizacion();
	
	PersonaDTO getPersona();
	
	void setPersona(PersonaDTO persona);
	
	LocalizacionDTO getLocalizacion();
	
	void setLocalizacion(LocalizacionDTO localizacion);
	
	TipoPersonaEntidad getTipoPersonEntidad();
		
}
