package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.RutaParticipanteRegistroNovedadID;

/**
 * 
 * @author hgudino
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRUTPARREGNOV")

public class RutaParticipanteRegistroNovedadDTO implements Serializable{
	
	/**
	 * Clave primaria de la tabla Ruta Participante Registro Novedad
	 * 
	 */
	@EmbeddedId
	private RutaParticipanteRegistroNovedadID id = new RutaParticipanteRegistroNovedadID();
	
	/**
	 * C�digo del tipo de novedad para bitacora
	 *
	 */
	@Column(name="CODIGOTIPONOVEDAD")
	private java.lang.Integer codigoTipoNovedad;
	
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")	
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioActualizacion;
	
	/**
	 * Relacion con la tabla catalogo valor para la novedad de la bitacora de la ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPONOVEDAD", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPONOVEDAD", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoNovedadDTO;
	
	/**
	 * Relacion con la tabla bitacora ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIAPARTICIPANTEREGISTRO", insertable=false, updatable=false, referencedColumnName="SECUENCIAPARTICIPANTEREGISTRO")})
	private RutaParticipanteRegistroDTO rutaParticipanteRegistroDTO;
	
	/**
	 * Relacion con la tabla usuario para registro de datos
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="USUARIOREGISTRO", referencedColumnName="USERID", insertable=false, updatable=false)})
	private UserDto usuarioRegistroDTO;
	
	/**
	 * Relacion con la tabla usuario para modificacion de datos
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="USUARIOMODIFICACION", referencedColumnName="USERID", insertable=false, updatable=false)})
	private UserDto usuarioModificacionDTO;
	
	
	public RutaParticipanteRegistroNovedadDTO() {		
	}
	
	/**
	 * @return the id
	 */
	public RutaParticipanteRegistroNovedadID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(RutaParticipanteRegistroNovedadID id) {
		this.id = id;
	}
	
	
	/**
	 * @return the codigoTipoNovedad
	 */
	public java.lang.Integer getCodigoTipoNovedad() {
		return codigoTipoNovedad;
	}

	/**
	 * @param codigoTipoNovedad the codigoTipoNovedad to set
	 */
	public void setCodigoTipoNovedad(java.lang.Integer codigoTipoNovedad) {
		this.codigoTipoNovedad = codigoTipoNovedad;
	}

	/**
	 * @return the estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(java.lang.String estado) {
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
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	

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

	/**
	 * @return the tipoNovedadDTO
	 */
	public CatalogoValorDTO getTipoNovedadDTO() {
		return tipoNovedadDTO;
	}

	/**
	 * @param tipoNovedadDTO the tipoNovedadDTO to set
	 */
	public void setTipoNovedadDTO(CatalogoValorDTO tipoNovedadDTO) {
		this.tipoNovedadDTO = tipoNovedadDTO;
	}

	/**
	 * @return the rutaParticipanteRegistroDTO
	 */
	public RutaParticipanteRegistroDTO getRutaParticipanteRegistroDTO() {
		return rutaParticipanteRegistroDTO;
	}

	/**
	 * @param rutaParticipanteRegistroDTO the rutaParticipanteRegistroDTO to set
	 */
	public void setRutaParticipanteRegistroDTO(RutaParticipanteRegistroDTO rutaParticipanteRegistroDTO) {
		this.rutaParticipanteRegistroDTO = rutaParticipanteRegistroDTO;
	}
}
