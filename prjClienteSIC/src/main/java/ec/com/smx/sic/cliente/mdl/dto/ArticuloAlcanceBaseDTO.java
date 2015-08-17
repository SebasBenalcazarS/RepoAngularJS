package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.AccessItemDto;

/**
 * Almacena el grupo de alcance para el artículo
 * @author jmontenegro
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ArticuloAlcanceBaseDTO extends SimpleAuditDTO {

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	@ComparatorTypeField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 */
	@LastModifierUserIdField
	@ComparatorTypeField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Mínimo de stock requerido para el artículo en la unidad operativa
	 */
	@Column(name = "MINIMOSTOCK")
	private java.lang.Long minimoStock;
	
	/**
	 * Maximo de stock requerido para el artículo en la unidad operativa
	 */
	@Column(name = "MAXIMOSTOCK")
	private java.lang.Long maximoStock;
	
	/**
	 * Es el usuario el cual da el alcance
	 */
	@Column(name = "USUARIOACTIVACION")
	@ComparatorTypeField
	private String idUsuarioActivacion;
	
	/**
	 * Es la fecha que se dio el alcance
	 */
	@Column(name = "FECHAACTIVACION")	
	private Date fechaActivacion;
	
	/**
	 * Es el usuario que inactivo el alcance
	 */
	@Column(name = "USUARIOINACTIVACION")
	@ComparatorTypeField
	private String idUsuarioInactivacion;
	
	/**
	 *  Es es la fecha que inactivo el alcance
	 */
	@Column(name = "FECHAINACTIVACION")
	private Date fechaInactivacion;
	
	/**
	 * es el codigo del sistema
	 */
	@Column(name = "CODIGOSISTEMA")
	@ComparatorTypeField
	private String codigoSistema;
	
	/**
	 * es el codigo de la aplicacion que activa o inactiva un alcance
	 */
	@Column(name = "CODIGOOPCION")
	@ComparatorTypeField
	private String codigoOpcion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOSISTEMA", insertable=false, updatable=false, referencedColumnName="SYSID"),
		@JoinColumn(name="CODIGOOPCION", referencedColumnName="ACCITEID", insertable=false, updatable=false)})
	private AccessItemDto opcion;
	
	/**
	 * Fecha inicial de validez del alcance
	 */
	private Date fechaInicialAlcance;
	/**
	 * Fecha final de validez del alcance
	 */
	private Date fechaFinalAlcance;
	
	/**
	 * C&oacute;digo de un sistema externo
	 */
	@ComparatorTypeField
	private String codigoReferencia;
	
	/**
	 * Estado del c&oacute;digo de referencia
	 */
	@ComparatorTypeField
	private String estadoCodigoReferencia;
	
	/**
	 * Referencia al usuario registro
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro;
	
	/**
	 * Referencia al usuario activacion
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOACTIVACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioActivacion;
	
	/**
	 * Referencia al usuario inactivacion
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOINACTIVACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioInactivacion;

	/**
	 * Estado del articulo local que se comunico al SIC
	 */
	@ComparatorTypeField
	private String estadoIntegracionAlcance;
	
	/**
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}
	
	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * @return the minimoStock
	 */
	public java.lang.Long getMinimoStock() {
		return minimoStock;
	}


	/**
	 * @param minimoStock the minimoStock to set
	 */
	public void setMinimoStock(java.lang.Long minimoStock) {
		this.minimoStock = minimoStock;
	}


	/**
	 * @return the maximoStock
	 */
	public java.lang.Long getMaximoStock() {
		return maximoStock;
	}


	/**
	 * @param maximoStock the maximoStock to set
	 */
	public void setMaximoStock(java.lang.Long maximoStock) {
		this.maximoStock = maximoStock;
	}

	/**
	 * @return the fechaInicialAlcance
	 */
	public Date getFechaInicialAlcance() {
		return fechaInicialAlcance;
	}

	/**
	 * @param fechaInicialAlcance the fechaInicialAlcance to set
	 */
	public void setFechaInicialAlcance(Date fechaInicialAlcance) {
		this.fechaInicialAlcance = fechaInicialAlcance;
	}

	/**
	 * @return the fechaFinalAlcance
	 */
	public Date getFechaFinalAlcance() {
		return fechaFinalAlcance;
	}

	/**
	 * @param fechaFinalAlcance the fechaFinalAlcance to set
	 */
	public void setFechaFinalAlcance(Date fechaFinalAlcance) {
		this.fechaFinalAlcance = fechaFinalAlcance;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the estadoCodigoReferencia
	 */
	public String getEstadoCodigoReferencia() {
		return estadoCodigoReferencia;
	}

	/**
	 * @param estadoCodigoReferencia the estadoCodigoReferencia to set
	 */
	public void setEstadoCodigoReferencia(String estadoCodigoReferencia) {
		this.estadoCodigoReferencia = estadoCodigoReferencia;
	}

	/**
	 * @return the fechaActivacion
	 */
	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	/**
	 * @param fechaActivacion the fechaActivacion to set
	 */
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	/**
	 * @return the fechaInactivacion
	 */
	public Date getFechaInactivacion() {
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion the fechaInactivacion to set
	 */
	public void setFechaInactivacion(Date fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}

	/**
	 * @return the estadoIntegracionAlcance
	 */
	public String getEstadoIntegracionAlcance() {
		return estadoIntegracionAlcance;
	}

	/**
	 * @param estadoIntegracionAlcance the estadoIntegracionAlcance to set
	 */
	public void setEstadoIntegracionAlcance(String estadoIntegracionAlcance) {
		this.estadoIntegracionAlcance = estadoIntegracionAlcance;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	/**
	 * @return the codigoOpcion
	 */
	public String getCodigoOpcion() {
		return codigoOpcion;
	}

	/**
	 * @param codigoOpcion the codigoOpcion to set
	 */
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	/**
	 * @return the opcion
	 */
	public AccessItemDto getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(AccessItemDto opcion) {
		this.opcion = opcion;
	}

	/**
	 * @return the usuarioRegistro
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * @return the idUsuarioActivacion
	 */
	public String getIdUsuarioActivacion() {
		return idUsuarioActivacion;
	}

	/**
	 * @param idUsuarioActivacion the idUsuarioActivacion to set
	 */
	public void setIdUsuarioActivacion(String idUsuarioActivacion) {
		this.idUsuarioActivacion = idUsuarioActivacion;
	}

	/**
	 * @return the idUsuarioInactivacion
	 */
	public String getIdUsuarioInactivacion() {
		return idUsuarioInactivacion;
	}

	/**
	 * @param idUsuarioInactivacion the idUsuarioInactivacion to set
	 */
	public void setIdUsuarioInactivacion(String idUsuarioInactivacion) {
		this.idUsuarioInactivacion = idUsuarioInactivacion;
	}

	/**
	 * @return the usuarioActivacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioActivacion() {
		return usuarioActivacion;
	}

	/**
	 * @param usuarioActivacion the usuarioActivacion to set
	 */
	public void setUsuarioActivacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioActivacion) {
		this.usuarioActivacion = usuarioActivacion;
	}

	/**
	 * @return the usuarioInactivacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioInactivacion() {
		return usuarioInactivacion;
	}

	/**
	 * @param usuarioInactivacion the usuarioInactivacion to set
	 */
	public void setUsuarioInactivacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioInactivacion) {
		this.usuarioInactivacion = usuarioInactivacion;
	}
	
}
