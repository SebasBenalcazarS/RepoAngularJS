package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTPROLOGGRUNOVART")
public class ProcesoLogisticoGrupoNovedadArticuloDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla ProcesoLogisticoGrupoNovedadArticuloDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoGrupoNovedadArticuloID id = new ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoGrupoNovedadArticuloID();
		
	/**
	 * Codigo de GrupoNovedadArticulo
	 * 
	 */
	@Column(name = "CODIGOGRUPONOVEDADARTICULO")
	private Long codigoGrupoNovedadArticulo;
	
	/**
	 * Codigo del proceso logistico
	 * 
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO")
	private Long codigoProcesoLogistico;
	
	
	@Column
	@ComparatorTypeField
	private java.lang.String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;
	
	
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
	 * Referencia con la tabla ProcesoLogistico
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOPROCESOLOGISTICO", referencedColumnName = "CODIGOPROCESOLOGISTICO", insertable = false, updatable = false) })
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
	/**
	 * Referencia con la tabla recepcionProcesoLogistico
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOGRUPONOVEDADARTICULO", referencedColumnName = "CODIGOGRUPONOVEDADARTICULO", insertable = false, updatable = false) })
	private GrupoNovedadArticuloDTO grupoNovedadArticuloDTO;

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion() {
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
	public void setFechaModificacion(java.util.Date fechaModificacion1) {
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

		if (idUsuarioModificacion != null
				&& idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * 
	 * @param usuarioCreacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion(
			ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1) {
		this.usuarioCreacion = usuarioCreacion1;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;
	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoGrupoNovedadArticuloID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoGrupoNovedadArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the codigoGrupoNovedadArticulo
	 */
	public Long getCodigoGrupoNovedadArticulo() {
		return codigoGrupoNovedadArticulo;
	}

	/**
	 * @param codigoGrupoNovedadArticulo the codigoGrupoNovedadArticulo to set
	 */
	public void setCodigoGrupoNovedadArticulo(Long codigoGrupoNovedadArticulo) {
		this.codigoGrupoNovedadArticulo = codigoGrupoNovedadArticulo;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}

	/**
	 * @return the grupoNovedadArticuloDTO
	 */
	public GrupoNovedadArticuloDTO getRecepcionProcesoLogisticoDTO() {
		return grupoNovedadArticuloDTO;
	}

	/**
	 * @param grupoNovedadArticuloDTO the grupoNovedadArticuloDTO to set
	 */
	public void setGrupoNovedadArticuloDTO(GrupoNovedadArticuloDTO grupoNovedadArticuloDTO) {
		this.grupoNovedadArticuloDTO = grupoNovedadArticuloDTO;
	}
	
	
}
