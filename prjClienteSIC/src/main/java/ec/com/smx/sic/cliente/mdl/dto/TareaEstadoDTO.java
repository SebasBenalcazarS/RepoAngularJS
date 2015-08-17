package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TareaEstadoID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Almacena todos los estados de las tareas de la estructura logistica
 * 
 * @author acaiza
 */
@SuppressWarnings({ "serial" })
@Entity
@Table(name = "SBTARTTAREST")
public class TareaEstadoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla EstadoTareaDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TareaEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.TareaEstadoID();
	
	/**
	 * secuencial unico para la tabla, para optimizacion de procesos de actualizacion
	 */
	@Column(name="SECUENCIALTAREAESTADO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBTARSECTARESTSEC" , 
						   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long secuencialTareaEstado;

	/**
	 * Especifica el codigo de la tarea padre
	 * 
	 */
	@Column
	private Long codigoTarea;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Codigo padre asignado al valor del catalogo
	 */
	@Column
	private String codigoCatalogoValorPadre;

	/**
	 * Codigo del tipo de catalogo padre
	 */
	@Column
	private Integer codigoCatalogoTipoPadre;

	/**
	 * Codigo relacionado al codigo del catalogo padre
	 */
	@Column
	private String codigoCatalogoValorRelacionado;

	/**
	 * Codigo relacionado al tipo de catalogo padre
	 */
	@Column
	private Integer codigoCatalogoTipoRelacionado;

	/**
	 * Fecha del inicio de la tarea
	 */
	@Column
	private java.util.Date fechaInicio;

	/**
	 * Fecha del fin de la tarea
	 */
	@Column
	private java.util.Date fechaFin;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private java.util.Date fechaRegistro;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private java.util.Date fechaModificacion;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Especifica la relacion con la tarea
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOTAREA", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO;

	/**
	 * Relacion con los catalogos relacionados
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCATALOGOVALORPADRE", referencedColumnName = "CODIGOCATALOGOVALORPADRE", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOTIPOPADRE", referencedColumnName = "CODIGOCATALOGOTIPOPADRE", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOVALORRELACIONADO", referencedColumnName = "CODIGOCATALOGOVALORRELACIONADO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOTIPORELACIONADO", referencedColumnName = "CODIGOCATALOGOTIPORELACIONADO", insertable = false, updatable = false) })
	private CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO;
	
	/**
	 * Referencia con la tabla catalogo valor Estado de la entrega
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCATALOGOTIPORELACIONADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOCATALOGOVALORRELACIONADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO estadoTarea;

	/**
	 * @return the id
	 */
	public TareaEstadoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(TareaEstadoID id) {
		this.id = id;
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
	 * @return the codigoCatalogoValorRelacionado
	 */
	public String getCodigoCatalogoValorRelacionado() {
		return codigoCatalogoValorRelacionado;
	}

	/**
	 * @param codigoCatalogoValorRelacionado
	 *            the codigoCatalogoValorRelacionado to set
	 */
	public void setCodigoCatalogoValorRelacionado(
			String codigoCatalogoValorRelacionado) {
		this.codigoCatalogoValorRelacionado = codigoCatalogoValorRelacionado;
	}

	/**
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea
	 *            the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
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
	 * @return the catalogoValorRelacionadoDTO
	 */
	public CatalogoValorRelacionadoDTO getCatalogoValorRelacionadoDTO() {
		return catalogoValorRelacionadoDTO;
	}

	/**
	 * @param catalogoValorRelacionadoDTO
	 *            the catalogoValorRelacionadoDTO to set
	 */
	public void setCatalogoValorRelacionadoDTO(
			CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO) {
		this.catalogoValorRelacionadoDTO = catalogoValorRelacionadoDTO;
	}

	/**
	 * @return the tareaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TareaDTO getTareaDTO() {
		return tareaDTO;
	}

	/**
	 * @param tareaDTO
	 *            the tareaDTO to set
	 */
	public void setTareaDTO(ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
	}

	/**
	 * @return the codigoCatalogoTipoPadre
	 */
	public Integer getCodigoCatalogoTipoPadre() {
		return codigoCatalogoTipoPadre;
	}

	/**
	 * @param codigoCatalogoTipoPadre
	 *            the codigoCatalogoTipoPadre to set
	 */
	public void setCodigoCatalogoTipoPadre(Integer codigoCatalogoTipoPadre) {
		this.codigoCatalogoTipoPadre = codigoCatalogoTipoPadre;
	}

	/**
	 * @return the codigoCatalogoTipoRelacionado
	 */
	public Integer getCodigoCatalogoTipoRelacionado() {
		return codigoCatalogoTipoRelacionado;
	}

	/**
	 * @param codigoCatalogoTipoRelacionado
	 *            the codigoCatalogoTipoRelacionado to set
	 */
	public void setCodigoCatalogoTipoRelacionado(
			Integer codigoCatalogoTipoRelacionado) {
		this.codigoCatalogoTipoRelacionado = codigoCatalogoTipoRelacionado;
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
	 * @return the estadoTarea
	 */
	public CatalogoValorDTO getEstadoTarea() {
		return estadoTarea;
	}

	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(CatalogoValorDTO estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	/**
	 * @return the secuencialTareaEstado
	 */
	public Long getSecuencialTareaEstado() {
		return secuencialTareaEstado;
	}

	/**
	 * @param secuencialTareaEstado the secuencialTareaEstado to set
	 */
	public void setSecuencialTareaEstado(Long secuencialTareaEstado) {
		this.secuencialTareaEstado = secuencialTareaEstado;
	}

}