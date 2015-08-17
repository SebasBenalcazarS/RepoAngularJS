/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RelationField;
import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.auditoria.IAuditoriaBase;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AuditoriaBaseDTO extends SimpleAuditDTO implements IAuditoriaBase {

	
	/**
	 * usuario que realizo el registro 
	 *

	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro ;

	

	/**
	 * fecha en la que se creo el registro 
	 *

	 */
	@RegisterDateField
	@Column(updatable=false)
	private Timestamp fechaRegistro ;

	

	/**
	 * usuario que realizo la ultima modificacion
	 *

	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	

	/**
	 * fecha de la ultima modificacion
	 *

	 */
	@LastModificationDateField
	private Timestamp fechaModificacion ;
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistro;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	@RelationField(joinType=JoinType.LEFT)
	private UserDto usuarioModificacion;



	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}



	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}



	/**
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}



	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}



	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}



	/**
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}



	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}



	/**
	 * @return the usuarioRegistro
	 */
	public UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}



	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}



	/**
	 * @return the usuarioModificacion
	 */
	public UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}



	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}



	
}
