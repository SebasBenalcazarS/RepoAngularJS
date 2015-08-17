/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.interfaces.auditoria;

import java.sql.Timestamp;

import ec.com.smx.frameworkv2.security.dto.UserDto;

/**
 * @author Mario Braganza
 *
 */
public interface IAuditoriaBase {

	String getIdUsuarioRegistro();
	
	void setIdUsuarioRegistro(String idUsuarioRegistro);
	
	Timestamp getFechaRegistro();
	
	void setFechaRegistro(Timestamp fechaRegistro);
	
	String getIdUsuarioModificacion();
	
	void setIdUsuarioModificacion(String idUsuarioModificacion);
	
	Timestamp getFechaModificacion();
	
	void setFechaModificacion(Timestamp fechaModificacion);
	
	UserDto getUsuarioRegistro();
	
	void setUsuarioRegistro(UserDto usuarioRegistro);
	
	UserDto getUsuarioModificacion();
	
	void setUsuarioModificacion(UserDto usuarioModificacion);
	
}
