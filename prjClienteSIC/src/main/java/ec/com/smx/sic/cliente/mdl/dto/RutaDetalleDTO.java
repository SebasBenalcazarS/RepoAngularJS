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
import ec.com.smx.sic.cliente.mdl.dto.id.RutaDetalleID;

/**
 * 
 * @author hgudino
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRUTDET")

public class RutaDetalleDTO implements Serializable{
	
	/**
	 * Clave primaria de la tabla Ruta detalle
	 * 
	 */
	@EmbeddedId
	private RutaDetalleID id = new RutaDetalleID();
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column(name="CONTROLRUTA")
	private java.lang.String controlRuta ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column(name="SEREGSALIDA")
	private java.lang.Boolean seRegistroSalida ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column(name="SEREGLLEGADA")
	private java.lang.Boolean seRegistroLlegada ;
	
	/**
	 * Secuencial de la tabla ruta
	 * 
	 */
	@Column(name = "SECUENCIARUTA")
    private java.lang.Long secuenciaRuta;
	
	/**
	 * Indica el valor del catalogo del estado
	 *
	 */
	@Column(name="VALORTIPOESTADO")
	private java.lang.String valorTipoEstado ;
	
	/**
	 * Indica el codigo tipo del estado
	 *
	 */
	@Column(name="CODIGOTIPOESTADO")
	private java.lang.Integer codigoTipoEstado ;
	
	/**
	 * Secuencial de la tabla participante registro llegada
	 * 
	 */
	@Column(name = "SECPARREGLLE")
	private java.lang.Long secuenciaParticipanteRegistroLlegada;
	
	/**
	 * Secuencial de la tabla participante registro Salida
	 * 
	 */
	@Column(name = "SECPARREGSAL")
	private java.lang.Long secuenciaParticipanteRegistroSalida;
	

	
	
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
	 * Relacion con la tabla ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIARUTA", insertable=false, updatable=false, referencedColumnName="SECUENCIARUTA")})
	private RutaDTO rutaDTO;
		
	/**
	 * Relacion con la tabla catalogo valor para el estado
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOESTADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO estadoCatalogoDTO;
	
	/**
	 * Relacion con la tabla bitacora ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECPARREGLLE", insertable=false, updatable=false, referencedColumnName="SECUENCIAPARTICIPANTEREGISTRO")})
	private RutaParticipanteRegistroDTO rutaParticipanteRegistroLlegadaDTO;
	
	/**
	 * Relacion con la tabla bitacora ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECPARREGSAL", insertable=false, updatable=false, referencedColumnName="SECUENCIAPARTICIPANTEREGISTRO")})
	private RutaParticipanteRegistroDTO rutaParticipanteRegistroSalidaDTO;
	
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
	
	
	public RutaDetalleDTO() {		
	}

	/**
	 * @return the id
	 */
	public RutaDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RutaDetalleID id) {
		this.id = id;
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
	 * @return the rutaDTO
	 */
	public RutaDTO getRutaDTO() {
		return rutaDTO;
	}

	/**
	 * @param rutaDTO the rutaDTO to set
	 */
	public void setRutaDTO(RutaDTO rutaDTO) {
		this.rutaDTO = rutaDTO;
	}

	/**
	 * @return the secuenciaRuta
	 */
	public java.lang.Long getSecuenciaRuta() {
		return secuenciaRuta;
	}

	/**
	 * @param secuenciaRuta the secuenciaRuta to set
	 */
	public void setSecuenciaRuta(java.lang.Long secuenciaRuta) {
		this.secuenciaRuta = secuenciaRuta;
	}

	/**
	 * @return the valorTipoEstado
	 */
	public java.lang.String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(java.lang.String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public java.lang.Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(java.lang.Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	/**
	 * @return the secuenciaParticipanteRegistroLlegada
	 */
	public java.lang.Long getSecuenciaParticipanteRegistroLlegada() {
		return secuenciaParticipanteRegistroLlegada;
	}

	/**
	 * @param secuenciaParticipanteRegistroLlegada the secuenciaParticipanteRegistroLlegada to set
	 */
	public void setSecuenciaParticipanteRegistroLlegada(java.lang.Long secuenciaParticipanteRegistroLlegada) {
		this.secuenciaParticipanteRegistroLlegada = secuenciaParticipanteRegistroLlegada;
	}

	/**
	 * @return the secuenciaParticipanteRegistroSalida
	 */
	public java.lang.Long getSecuenciaParticipanteRegistroSalida() {
		return secuenciaParticipanteRegistroSalida;
	}

	/**
	 * @param secuenciaParticipanteRegistroSalida the secuenciaParticipanteRegistroSalida to set
	 */
	public void setSecuenciaParticipanteRegistroSalida(java.lang.Long secuenciaParticipanteRegistroSalida) {
		this.secuenciaParticipanteRegistroSalida = secuenciaParticipanteRegistroSalida;
	}

	/**
	 * @return the estadoCatalogoDTO
	 */
	public CatalogoValorDTO getEstadoCatalogoDTO() {
		return estadoCatalogoDTO;
	}

	/**
	 * @param estadoCatalogoDTO the estadoCatalogoDTO to set
	 */
	public void setEstadoCatalogoDTO(CatalogoValorDTO estadoCatalogoDTO) {
		this.estadoCatalogoDTO = estadoCatalogoDTO;
	}

	/**
	 * @return the rutaParticipanteRegistroLlegadaDTO
	 */
	public RutaParticipanteRegistroDTO getRutaParticipanteRegistroLlegadaDTO() {
		return rutaParticipanteRegistroLlegadaDTO;
	}

	/**
	 * @param rutaParticipanteRegistroLlegadaDTO the rutaParticipanteRegistroLlegadaDTO to set
	 */
	public void setRutaParticipanteRegistroLlegadaDTO(RutaParticipanteRegistroDTO rutaParticipanteRegistroLlegadaDTO) {
		this.rutaParticipanteRegistroLlegadaDTO = rutaParticipanteRegistroLlegadaDTO;
	}

	/**
	 * @return the rutaParticipanteRegistroSalidaDTO
	 */
	public RutaParticipanteRegistroDTO getRutaParticipanteRegistroSalidaDTO() {
		return rutaParticipanteRegistroSalidaDTO;
	}

	/**
	 * @param rutaParticipanteRegistroSalidaDTO the rutaParticipanteRegistroSalidaDTO to set
	 */
	public void setRutaParticipanteRegistroSalidaDTO(RutaParticipanteRegistroDTO rutaParticipanteRegistroSalidaDTO) {
		this.rutaParticipanteRegistroSalidaDTO = rutaParticipanteRegistroSalidaDTO;
	}

	/**
	 * @return the controlRuta
	 */
	public java.lang.String getControlRuta() {
		return controlRuta;
	}

	/**
	 * @param controlRuta the controlRuta to set
	 */
	public void setControlRuta(java.lang.String controlRuta) {
		this.controlRuta = controlRuta;
	}

	/**
	 * @return the seRegistroSalida
	 */
	public java.lang.Boolean getSeRegistroSalida() {
		return seRegistroSalida;
	}

	/**
	 * @param seRegistroSalida the seRegistroSalida to set
	 */
	public void setSeRegistroSalida(java.lang.Boolean seRegistroSalida) {
		this.seRegistroSalida = seRegistroSalida;
	}

	/**
	 * @return the seRegistroLlegada
	 */
	public java.lang.Boolean getSeRegistroLlegada() {
		return seRegistroLlegada;
	}

	/**
	 * @param seRegistroLlegada the seRegistroLlegada to set
	 */
	public void setSeRegistroLlegada(java.lang.Boolean seRegistroLlegada) {
		this.seRegistroLlegada = seRegistroLlegada;
	}
}
