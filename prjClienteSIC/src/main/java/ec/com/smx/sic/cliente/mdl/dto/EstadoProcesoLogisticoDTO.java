package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Tabla para guadar la fecha y hora de llegada para realizar la recepcion de la
 * mercaderia del proveeedor
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTESTPROLOG")
public class EstadoProcesoLogisticoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla AsignacionProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EstadoProcesoLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.EstadoProcesoLogisticoID();
	
	/**
	 * Secuencial de la tabla ProcesoLogistico
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO", nullable = false)
	private Long codigoProcesoLogistico ;
	
	/**
	 * Representa el codigo del CatalogoValor para saber si es recepcion o
	 * despacho.
	 * 
	 */
	@Column
	private java.lang.Integer codigoTipoEstadoProcesoLogistico;

	/**
	 * Representa el valor del CatalogoValor para saber si es recepcion o
	 * despacho.
	 * 
	 */
	@Column
	private java.lang.String valorTipoEstadoProcesoLogistico;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
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
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;

	/**
	 * Relacion con el catalogo valor saber el tipo de proceso:
	 * recepcion/despacho
	 * 
	 */

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOPROCESOLOGISTICO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOPROCESOLOGISTICO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoProcesoLogistico;

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
	 * Referencia a la tabla SBTARTTAREA
	 * 
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDTO> tareaCol;
	
	/**
	 * Referencia a la tabla SBLOGTRECPRO
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol;
	
	/**
	 * 
	 */
	@Transient
	private RecepcionProveedorDTO recepcionProveedorActivo;
	
	
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
	 * @return the tipoProcesoLogistico
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoProcesoLogistico() {
		return tipoProcesoLogistico;
	}

	/**
	 * @param tipoProcesoLogistico the tipoProcesoLogistico to set
	 */
	public void setTipoProcesoLogistico(
			ec.com.smx.corpv2.dto.CatalogoValorDTO tipoProcesoLogistico) {
		this.tipoProcesoLogistico = tipoProcesoLogistico;
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
	public ec.com.smx.sic.cliente.mdl.dto.id.EstadoProcesoLogisticoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.EstadoProcesoLogisticoID id) {
		this.id = id;
	}

	/**
	 * @return the tareaCol
	 */
	public Collection<TareaDTO> getTareaCol() {
		return tareaCol;
	}

	/**
	 * @param tareaCol the tareaCol to set
	 */
	public void setTareaCol(Collection<TareaDTO> tareaCol) {
		this.tareaCol = tareaCol;
	}

	/**
	 * @return the recepcionProveedorDTOCol
	 */
	public Collection<RecepcionProveedorDTO> getRecepcionProveedorDTOCol() {
		return recepcionProveedorDTOCol;
	}

	/**
	 * @param recepcionProveedorDTOCol the recepcionProveedorDTOCol to set
	 */
	public void setRecepcionProveedorDTOCol(
			Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol) {
		this.recepcionProveedorDTOCol = recepcionProveedorDTOCol;
	}

	/**
	 * @return the recepcionProveedorDTO
	 */
	public RecepcionProveedorDTO getRecepcionProveedorActivo() {
		recepcionProveedorActivo = null;
		if (CollectionUtils.isNotEmpty(recepcionProveedorDTOCol)) {
			recepcionProveedorActivo = this.recepcionProveedorDTOCol.iterator().next();
		}
		return recepcionProveedorActivo;
	}
	
	/**
	 * Valida si existe asignadas las recepciones del proveedor
	 * @return
	 */
	public Boolean getTieneRecepcionProveedorDTO() {
		return isLoaded(this.recepcionProveedorDTOCol) && !this.recepcionProveedorDTOCol.isEmpty();
	}
	
	/**
	 * Valida si existe asignadas las tareas de recepcion
	 * @return
	 */
	public Boolean getTieneTarea() {
		return isLoaded(this.tareaCol) && !this.tareaCol.isEmpty();
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
	 * @return the codigoTipoEstadoProcesoLogistico
	 */
	public java.lang.Integer getCodigoTipoEstadoProcesoLogistico() {
		return codigoTipoEstadoProcesoLogistico;
	}

	/**
	 * @param codigoTipoEstadoProcesoLogistico the codigoTipoEstadoProcesoLogistico to set
	 */
	public void setCodigoTipoEstadoProcesoLogistico(java.lang.Integer codigoTipoEstadoProcesoLogistico) {
		this.codigoTipoEstadoProcesoLogistico = codigoTipoEstadoProcesoLogistico;
	}

	/**
	 * @return the valorTipoEstadoProcesoLogistico
	 */
	public java.lang.String getValorTipoEstadoProcesoLogistico() {
		return valorTipoEstadoProcesoLogistico;
	}

	/**
	 * @param valorTipoEstadoProcesoLogistico the valorTipoEstadoProcesoLogistico to set
	 */
	public void setValorTipoEstadoProcesoLogistico(java.lang.String valorTipoEstadoProcesoLogistico) {
		this.valorTipoEstadoProcesoLogistico = valorTipoEstadoProcesoLogistico;
	}

	
}
