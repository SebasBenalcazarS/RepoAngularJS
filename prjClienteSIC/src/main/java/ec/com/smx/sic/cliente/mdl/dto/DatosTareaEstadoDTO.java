package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Types;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Esta tabla sirve para guardar el historial de todas las transacciones del
 * datos tarea estado: Pendiente por definir los estados de los pallets.
 * 
 * @author kruger
 */
@SuppressWarnings({"serial"})
@Entity
@Table(name = "SBLOGTDATTAREST")
public class DatosTareaEstadoDTO extends SimpleAuditDTO {

	/**
	 * PK de la tabla
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaEstadoID();
	
	/**
	 * Representa un codigo secuencial de la tabla
	 */
	@Column(name = "SECUENCIALDATOSTAREAESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBLOGSECDATTARESTSEC" , 
								   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long secuencialDatosTareaEstado ;
	
	/**
	 * Codigo del datos tarea
	 */
	@Column(name = "CODIGODATOSTAREA", nullable = false)
	private java.lang.Long codigoDatosTarea;

	
	/**
	 * codigo padre asignado al valor del catalogo
	 */
	@Column(name="CODIGOCATALOGOVALORPADRE" , nullable = false)
	private String codigoCatalogoValorPadre;
	
	/**
	 * codigo del tipo de catalogo padre
	 */
	@Column(name="CODIGOCATALOGOTIPOPADRE" , nullable = false)
	private Integer codigoCatalogoValorTipoPadre;
	
	/**
	 * codigo relacionado al codigo del catalogo padre
	 */
	@Column(name="CODIGOCATALOGOVALORRELACIONADO" , nullable = false)
	private String codigoCatalogoValorRelacionado;
	
	/**
	 * codigo relacionado al tipo de catalogo padre
	 */
	@Column(name="CODIGOCATALOGOTIPORELACIONADO" , nullable = false)
	private Integer codigoCatalogoValorTipoRelacionado;

	/**
	 * Representa la fecha en la que se inicia el proceso.
	 * 
	 */
	@Column(name="FECHAINICIO")
	private Date fechaInicio;

	/**
	 * Representa la fecha en la que se finaliza el proceso.
	 * 
	 */
	@Column(name="FECHAFIN")
	private Date fechaFin;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private Date fechaRegistro;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private Date fechaModificacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Representa el estado del proceso, desde donde empieza hacia donde va
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCATALOGOVALORPADRE", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALORPADRE"),
		@JoinColumn(name = "CODIGOCATALOGOTIPOPADRE", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPOPADRE"),
		@JoinColumn(name = "CODIGOCATALOGOVALORRELACIONADO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALORRELACIONADO"),
		@JoinColumn(name = "CODIGOCATALOGOTIPORELACIONADO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPORELACIONADO")
	})
	private ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO;

	
	/**
	 * Representa el fk con la tabla DetalleAsignacionProceso.
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaEstadoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaEstadoID id1) {
		this.id = id1;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>
	 * .
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(Date fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

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
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>
	 * .
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

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
	 * Establece un nuevo valor para la propiedad
	 * <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * @return the datosTareaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO getDatosTareaDTO() {
		return datosTareaDTO;
	}

	/**
	 * @param datosTareaDTO the datosTareaDTO to set
	 */
	public void setDatosTareaDTO(ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO) {
		this.datosTareaDTO = datosTareaDTO;
	}

	/**
	 * @return the catalogoValorRelacionadoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO getCatalogoValorRelacionadoDTO() {
		return catalogoValorRelacionadoDTO;
	}

	/**
	 * @param catalogoValorRelacionadoDTO the catalogoValorRelacionadoDTO to set
	 */
	public void setCatalogoValorRelacionadoDTO(
			ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO) {
		this.catalogoValorRelacionadoDTO = catalogoValorRelacionadoDTO;
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
	 * @return the codigoCatalogoValorPadre
	 */
	public String getCodigoCatalogoValorPadre() {
		return codigoCatalogoValorPadre;
	}

	/**
	 * @param codigoCatalogoValorPadre the codigoCatalogoValorPadre to set
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
	 * @param codigoCatalogoValorTipoPadre the codigoCatalogoValorTipoPadre to set
	 */
	public void setCodigoCatalogoValorTipoPadre(Integer codigoCatalogoValorTipoPadre) {
		this.codigoCatalogoValorTipoPadre = codigoCatalogoValorTipoPadre;
	}

	/**
	 * @return the codigoCatalogoValorRelacionado
	 */
	public String getCodigoCatalogoValorRelacionado() {
		return codigoCatalogoValorRelacionado;
	}

	/**
	 * @param codigoCatalogoValorRelacionado the codigoCatalogoValorRelacionado to set
	 */
	public void setCodigoCatalogoValorRelacionado(
			String codigoCatalogoValorRelacionado) {
		this.codigoCatalogoValorRelacionado = codigoCatalogoValorRelacionado;
	}

	/**
	 * @return the codigoCatalogoValorTipoRelacionado
	 */
	public Integer getCodigoCatalogoValorTipoRelacionado() {
		return codigoCatalogoValorTipoRelacionado;
	}

	/**
	 * @param codigoCatalogoValorTipoRelacionado the codigoCatalogoValorTipoRelacionado to set
	 */
	public void setCodigoCatalogoValorTipoRelacionado(
			Integer codigoCatalogoValorTipoRelacionado) {
		this.codigoCatalogoValorTipoRelacionado = codigoCatalogoValorTipoRelacionado;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public java.lang.Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

	/**
	 * @return the secuencialDatosTareaEstado
	 */
	public Long getSecuencialDatosTareaEstado() {
		return secuencialDatosTareaEstado;
	}

	/**
	 * @param secuencialDatosTareaEstado the secuencialDatosTareaEstado to set
	 */
	public void setSecuencialDatosTareaEstado(Long secuencialDatosTareaEstado) {
		this.secuencialDatosTareaEstado = secuencialDatosTareaEstado;
	}

}
