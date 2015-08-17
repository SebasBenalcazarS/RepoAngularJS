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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;

/**
 * Almacena informacion referente a la entrega estado
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITENTEST")
public class EntregaEstadoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Entrega
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EntregaEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.EntregaEstadoID();

	/**
	 * Codigo de la entrega
	 */
	@Column(name = "CODIGOENTREGA", nullable = false)
	private java.lang.Long codigoEntrega;
	
	/**
	 * Catalogo valor para el tipo de documento.
	 * 
	 */
	@Column(name = "CODIGOCATALOGOTIPORELACIONADO", nullable = false)
	@ComparatorTypeField
	private Integer codigoTipoEntregaEstado;

	/**
	 * Catalogo valor para el tipo de documento.
	 * 
	 */
	@Column(name = "CODIGOCATALOGOVALORRELACIONADO", nullable = false)
	@ComparatorTypeField
	private String valorTipoEntregaEstado;
	
	/**
	 * codigo padre asignado al valor del catalogo
	 */

	@Column(name = "CODIGOCATALOGOVALORPADRE", nullable = false)
	private String codigoCatalogoValorPadre;

	/**
	 * codigo del tipo de catalogo padre
	 */
	@Column(name = "CODIGOCATALOGOTIPOPADRE", nullable = false)
	private Integer codigoCatalogoValorTipoPadre;

	/**
	 * Representa el estado.
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Fecha inicio de la entrega
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaInicio;

	/**
	 * Fecha inicio de la entrega
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaFin;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name = "USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@Column(name = "USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;

	/**
	 * Referencia con la tabla Entrega
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"), 
		@JoinColumn(name = "CODIGOENTREGA", referencedColumnName = "CODIGOENTREGA", insertable = false, updatable = false) })
	private EntregaDTO entregaDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla catalogo valor Estado de la entrega
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCATALOGOTIPORELACIONADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOCATALOGOVALORRELACIONADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO estadoEntrega;
	
	/**
	 * Referencia con la tabla catalogo valor Estado de la entrega
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCATALOGOTIPOPADRE", referencedColumnName = "CODIGOCATALOGOTIPOPADRE", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOCATALOGOVALORPADRE", referencedColumnName = "CODIGOCATALOGOVALORPADRE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOTIPORELACIONADO", referencedColumnName = "CODIGOCATALOGOTIPORELACIONADO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOVALORRELACIONADO", referencedColumnName = "CODIGOCATALOGOVALORRELACIONADO", insertable = false, updatable = false)
		})
	private CatalogoValorRelacionadoDTO estadoEntregaCatValRel;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.EntregaEstadoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.EntregaEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoEntrega
	 */
	public java.lang.Long getCodigoEntrega() {
		return codigoEntrega;
	}

	/**
	 * @param codigoEntrega
	 *            the codigoEntrega to set
	 */
	public void setCodigoEntrega(java.lang.Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	/**
	 * @return the valorTipoEntregaEstado
	 */
	public String getValorTipoEntregaEstado() {
		return valorTipoEntregaEstado;
	}

	/**
	 * @param valorTipoEntregaEstado
	 *            the valorTipoEntregaEstado to set
	 */
	public void setValorTipoEntregaEstado(String valorTipoEntregaEstado) {
		this.valorTipoEntregaEstado = valorTipoEntregaEstado;
	}

	/**
	 * @return the codigoTipoEntregaEstado
	 */
	public Integer getCodigoTipoEntregaEstado() {
		return codigoTipoEntregaEstado;
	}

	/**
	 * @param codigoTipoEntregaEstado
	 *            the codigoTipoEntregaEstado to set
	 */
	public void setCodigoTipoEntregaEstado(Integer codigoTipoEntregaEstado) {
		this.codigoTipoEntregaEstado = codigoTipoEntregaEstado;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin
	 *            the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro
	 *            the fechaRegistro to set
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
	 * @param idUsuarioRegistro
	 *            the idUsuarioRegistro to set
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
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion
	 *            the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the entregaDTO
	 */
	public EntregaDTO getEntregaDTO() {
		return entregaDTO;
	}

	/**
	 * @param entregaDTO
	 *            the entregaDTO to set
	 */
	public void setEntregaDTO(EntregaDTO entregaDTO) {
		this.entregaDTO = entregaDTO;
	}

	/**
	 * @return the estadoEntrega
	 */
	public CatalogoValorDTO getEstadoEntrega() {
		return estadoEntrega;
	}

	/**
	 * @param estadoEntrega
	 *            the estadoEntrega to set
	 */
	public void setEstadoEntrega(CatalogoValorDTO estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}

	/**
	 * @return the codigoCatalogoValorPadre
	 */
	public String getCodigoCatalogoValorPadre() {
		return codigoCatalogoValorPadre;
	}

	/**
	 * @param codigoCatalogoValorPadre
	 *            the codigoCatalogoValorPadre to set
	 */
	public void setCodigoCatalogoValorPadre(String codigoCatalogoValorPadre) {
		this.codigoCatalogoValorPadre = codigoCatalogoValorPadre;
	}

	/**
	 * @return the codigoCatalogoValorTipoPadre
	 */
	public Integer getCodigoCatalogoValorTipoPadre() {
		return codigoCatalogoValorTipoPadre;
	}

	/**
	 * @param codigoCatalogoValorTipoPadre
	 *            the codigoCatalogoValorTipoPadre to set
	 */
	public void setCodigoCatalogoValorTipoPadre(Integer codigoCatalogoValorTipoPadre) {
		this.codigoCatalogoValorTipoPadre = codigoCatalogoValorTipoPadre;
	}

	/**
	 * @return the estadoEntregaCatValRel
	 */
	public CatalogoValorRelacionadoDTO getEstadoEntregaCatValRel() {
		return estadoEntregaCatValRel;
	}

	/**
	 * @param estadoEntregaCatValRel the estadoEntregaCatValRel to set
	 */
	public void setEstadoEntregaCatValRel(CatalogoValorRelacionadoDTO estadoEntregaCatValRel) {
		this.estadoEntregaCatValRel = estadoEntregaCatValRel;
	}

}