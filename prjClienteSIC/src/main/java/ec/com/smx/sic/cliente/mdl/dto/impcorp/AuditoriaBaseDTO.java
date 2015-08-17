package ec.com.smx.sic.cliente.mdl.dto.impcorp;


import ec.com.smx.framework.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.BaseID;

@SuppressWarnings("serial")
//@MappedSuperclass
public class AuditoriaBaseDTO<T extends BaseID> extends BaseDTO<T>{
	/**
	 * 
	 *
	 */
//	@ManyToOne(fetch = LAZY)
//	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;



	/**
	 * 
	 *
	 */
//	@ManyToOne(fetch = LAZY)
//	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;



	/**
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}



	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}



	/**
	 * @return the usuarioModificacionDTO
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}



	/**
	 * @param usuarioModificacionDTO the usuarioModificacionDTO to set
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}
	
	
}
