/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBTARTTIPTAR")
public class TipoTareaDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla TipoTareaDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaID();
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@OneToMany(mappedBy = "tipoTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDTO> tareasCol;
	
	@OneToMany(mappedBy = "tipoTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TipoTareaPerfilDTO> tipoTareaPerfilCol;
	
	@OneToMany(mappedBy = "tipoTareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TipoTareaFuncionarioLogisticoDTO> tipoTareaFuncionarioLogisticoDTO;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
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
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

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
	
	@Column(name = "CATALOGOTIPOESTADOUSUARIO")
	private Integer catalogoTipoEstadoUsuario;
	
	@Column(name = "CATALOGOVALORESTADOUSUARIO")
	private String catalogoValorEstadoUsuario;
	
	/**
	 * Referencia con la tabla catalogo valor del estado del usuario en el tipo de tarea que se esta ejecutando
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CATALOGOTIPOESTADOUSUARIO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "CATALOGOVALORESTADOUSUARIO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO estadoUsuarioTarea;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaID id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the tareasCol
	 */
	public Collection<TareaDTO> getTareasCol() {
		return tareasCol;
	}

	/**
	 * @param tareasCol the tareasCol to set
	 */
	public void setTareasCol(Collection<TareaDTO> tareasCol) {
		this.tareasCol = tareasCol;
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
	 * @return the tipoTareaPerfilCol
	 */
	public Collection<TipoTareaPerfilDTO> getTipoTareaPerfilCol() {
		return tipoTareaPerfilCol;
	}

	/**
	 * @param tipoTareaPerfilCol the tipoTareaPerfilCol to set
	 */
	public void setTipoTareaPerfilCol(Collection<TipoTareaPerfilDTO> tipoTareaPerfilCol) {
		this.tipoTareaPerfilCol = tipoTareaPerfilCol;
	}

	/**
	 * @return the catalogoTipoEstadoUsuario
	 */
	public Integer getCatalogoTipoEstadoUsuario() {
		return catalogoTipoEstadoUsuario;
	}

	/**
	 * @param catalogoTipoEstadoUsuario the catalogoTipoEstadoUsuario to set
	 */
	public void setCatalogoTipoEstadoUsuario(Integer catalogoTipoEstadoUsuario) {
		this.catalogoTipoEstadoUsuario = catalogoTipoEstadoUsuario;
	}

	/**
	 * @return the catalogoValorEstadoUsuario
	 */
	public String getCatalogoValorEstadoUsuario() {
		return catalogoValorEstadoUsuario;
	}

	/**
	 * @param catalogoValorEstadoUsuario the catalogoValorEstadoUsuario to set
	 */
	public void setCatalogoValorEstadoUsuario(String catalogoValorEstadoUsuario) {
		this.catalogoValorEstadoUsuario = catalogoValorEstadoUsuario;
	}

	/**
	 * @return the estadoUsuarioTarea
	 */
	public CatalogoValorDTO getEstadoUsuarioTarea() {
		return estadoUsuarioTarea;
	}

	/**
	 * @param estadoUsuarioTarea the estadoUsuarioTarea to set
	 */
	public void setEstadoUsuarioTarea(CatalogoValorDTO estadoUsuarioTarea) {
		this.estadoUsuarioTarea = estadoUsuarioTarea;
	}

	/**
	 * @return the tipoTareaFuncionarioLogisticoDTO
	 */
	public Collection<TipoTareaFuncionarioLogisticoDTO> getTipoTareaFuncionarioLogisticoDTO() {
		return tipoTareaFuncionarioLogisticoDTO;
	}

	/**
	 * @param tipoTareaFuncionarioLogisticoDTO the tipoTareaFuncionarioLogisticoDTO to set
	 */
	public void setTipoTareaFuncionarioLogisticoDTO(Collection<TipoTareaFuncionarioLogisticoDTO> tipoTareaFuncionarioLogisticoDTO) {
		this.tipoTareaFuncionarioLogisticoDTO = tipoTareaFuncionarioLogisticoDTO;
	}

}
