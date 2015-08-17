/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.autorizaciones.dto.TipoAutorizacionDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.JustificacionProcesoTipoAutorizacionID;

/**
 * @author jvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTJUSPROTIPAUT")
public class JustificacionProcesoTipoAutorizacionDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	JustificacionProcesoTipoAutorizacionID id = new JustificacionProcesoTipoAutorizacionID();
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	private String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 *
	 */
	@Column
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	/**
	 * Especifica el usuario que realiza el registro.
	 *
	 */
	@Column(name="IDUSUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro ;

	/**
	 * Fecha en la que se realiz\u00F3 la ultima actualizaci\u00F3n.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
		

	/**
	 * Id del usuario que realiz\u00F3 la  ultima actualizaci\u00F3n.
	 *
	*/
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;
	
	/**
	 * Referencia con la tabla justificacion
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOJUSTIFICACION", referencedColumnName = "CODIGOJUSTIFICACION", insertable = false, updatable = false) })
	private JustificacionDTO justificacionDTO;
	
	/**
	 * Referencia con la tabla proceso
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false) })
	private ProcesoDTO procesoDTO;
	
	/**
	 * Referencia con la tabla tipo autorizacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOTIPOAUTORIZACION", insertable = false, updatable = false, referencedColumnName = "CODIGOTIPOAUTORIZACION"),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private TipoAutorizacionDTO tipoAutorizacionDTO;
	
	
	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * @return the id
	 */
	public JustificacionProcesoTipoAutorizacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(JustificacionProcesoTipoAutorizacionID id) {
		this.id = id;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

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
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	 * @return the justificacionDTO
	 */
	public JustificacionDTO getJustificacionDTO() {
		return justificacionDTO;
	}

	/**
	 * @param justificacionDTO the justificacionDTO to set
	 */
	public void setJustificacionDTO(JustificacionDTO justificacionDTO) {
		this.justificacionDTO = justificacionDTO;
	}

	/**
	 * @return the procesoDTO
	 */
	public ProcesoDTO getProcesoDTO() {
		return procesoDTO;
	}

	/**
	 * @param procesoDTO the procesoDTO to set
	 */
	public void setProcesoDTO(ProcesoDTO procesoDTO) {
		this.procesoDTO = procesoDTO;
	}

	/**
	 * @return the tipoAutorizacionDTO
	 */
	public TipoAutorizacionDTO getTipoAutorizacionDTO() {
		return tipoAutorizacionDTO;
	}

	/**
	 * @param tipoAutorizacionDTO the tipoAutorizacionDTO to set
	 */
	public void setTipoAutorizacionDTO(TipoAutorizacionDTO tipoAutorizacionDTO) {
		this.tipoAutorizacionDTO = tipoAutorizacionDTO;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	
}
