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
import ec.com.smx.sic.cliente.mdl.dto.id.NovedadArticuloJustificacionDetalleRecipienteID;

/**
 * @author aecaiza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTNOVARTJUSDETREC")
public class NovedadArticuloJustificacionDetalleRecipienteDTO extends SimpleAuditDTO{
	@EmbeddedId
	private NovedadArticuloJustificacionDetalleRecipienteID id = new NovedadArticuloJustificacionDetalleRecipienteID();
	
	/**
	 * Codigo de la NovedadArticuloJustificacion
	 * 
	 */
	@Column
	private Long codigoNovedadArticuloJustificacion;
	
	/**
	 * Codigo del ControlRecipienteDetalleTara
	 * 
	 */
	@Column(name="CODIGODETCONRECTAR")
	private Long codigoControlRecipienteDetalleTara;
	
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
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String usuarioRegistro ;

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
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;
	
	/**
	 * Relacion con la justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGONOVEDADARTICULOJUSTIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGONOVEDADARTICULOJUSTIFICACION") })
	private NovedadArticuloJustificacionDTO novedadArticuloJustificacionDTO;
	
	/**
	 * Relacion con la justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETCONRECTAR", insertable = false, updatable = false, referencedColumnName = "CODIGODETCONRECTAR") })
	private ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO;
	
	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * @return the id
	 */
	public NovedadArticuloJustificacionDetalleRecipienteID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(NovedadArticuloJustificacionDetalleRecipienteID id) {
		this.id = id;
	}

	/**
	 * @return the codigoNovedadArticuloJustificacion
	 */
	public Long getCodigoNovedadArticuloJustificacion() {
		return codigoNovedadArticuloJustificacion;
	}

	/**
	 * @param codigoNovedadArticuloJustificacion the codigoNovedadArticuloJustificacion to set
	 */
	public void setCodigoNovedadArticuloJustificacion(Long codigoNovedadArticuloJustificacion) {
		this.codigoNovedadArticuloJustificacion = codigoNovedadArticuloJustificacion;
	}

	/**
	 * @return the codigoControlRecipienteDetalleTara
	 */
	public Long getCodigoControlRecipienteDetalleTara() {
		return codigoControlRecipienteDetalleTara;
	}

	/**
	 * @param codigoControlRecipienteDetalleTara the codigoControlRecipienteDetalleTara to set
	 */
	public void setCodigoControlRecipienteDetalleTara(Long codigoControlRecipienteDetalleTara) {
		this.codigoControlRecipienteDetalleTara = codigoControlRecipienteDetalleTara;
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
	 * @return the usuarioRegistro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
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
	 * @return the novedadArticuloJustificacionDTO
	 */
	public NovedadArticuloJustificacionDTO getNovedadArticuloJustificacionDTO() {
		return novedadArticuloJustificacionDTO;
	}

	/**
	 * @param novedadArticuloJustificacionDTO the novedadArticuloJustificacionDTO to set
	 */
	public void setNovedadArticuloJustificacionDTO(NovedadArticuloJustificacionDTO novedadArticuloJustificacionDTO) {
		this.novedadArticuloJustificacionDTO = novedadArticuloJustificacionDTO;
	}

	/**
	 * @return the controlRecipienteTaraDetalleDTO
	 */
	public ControlRecipienteTaraDetalleDTO getControlRecipienteTaraDetalleDTO() {
		return controlRecipienteTaraDetalleDTO;
	}

	/**
	 * @param controlRecipienteTaraDetalleDTO the controlRecipienteTaraDetalleDTO to set
	 */
	public void setControlRecipienteTaraDetalleDTO(ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO) {
		this.controlRecipienteTaraDetalleDTO = controlRecipienteTaraDetalleDTO;
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
