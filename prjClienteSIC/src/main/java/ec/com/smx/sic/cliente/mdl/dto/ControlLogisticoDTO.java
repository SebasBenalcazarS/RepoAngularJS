package ec.com.smx.sic.cliente.mdl.dto;

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
 * Registra los problemas para el control logistico
 * 
 * @author dalmeida
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTCONLOG")
public class ControlLogisticoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ControlLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ControlLogisticoID();
	
	/**
	 * El codigo de la subbodega asignada
	 */
	@Column(name="CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;

	/**
	 * Catalogo valor para el tipo de control logistico.
	 */
	@Column(name="VALORTIPOCONTROLLOGISTICO")
	@ComparatorTypeField
	private String valorTipoControlLogistico;

	/**
	 * Catalogo valor para el tipo de control logistico.
	 */
	@Column(name="CODIGOTIPOCONTROLLOGISTICO")
	private Integer codigoTipoControlLogistico;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 */
	@Column(name="ESTADO")
	@ComparatorTypeField
	private String estado;

	/**
	 * Especifica el usuario que crea el registro.
	 */
	@RegisterUserIdField
	@ComparatorTypeField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se crea el registro
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;
	
	@Transient
	private Boolean seleccionado = Boolean.FALSE;
	
	/**
	 * Referencia con la tabla catalogo valor Tipo de control logistico.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOTIPOCONTROLLOGISTICO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORTIPOCONTROLLOGISTICO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO tipoControlLogistico;
	
	/**
	 * Obtiene la relacion con los datos de la tabla Recepcion Proveedor Control LogisticoDTO
	 */
	@OneToMany(mappedBy = "controlLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorControlLogisticoDTO> recepcionProveedorControlLogisticoCol;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ControlLogisticoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ControlLogisticoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the valorTipoControlLogistico
	 */
	public String getValorTipoControlLogistico() {
		return valorTipoControlLogistico;
	}

	/**
	 * @param valorTipoControlLogistico the valorTipoControlLogistico to set
	 */
	public void setValorTipoControlLogistico(String valorTipoControlLogistico) {
		this.valorTipoControlLogistico = valorTipoControlLogistico;
	}

	/**
	 * @return the codigoTipoControlLogistico
	 */
	public Integer getCodigoTipoControlLogistico() {
		return codigoTipoControlLogistico;
	}

	/**
	 * @param codigoTipoControlLogistico the codigoTipoControlLogistico to set
	 */
	public void setCodigoTipoControlLogistico(Integer codigoTipoControlLogistico) {
		this.codigoTipoControlLogistico = codigoTipoControlLogistico;
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
	 * @return the tipoControlLogistico
	 */
	public CatalogoValorDTO getTipoControlLogistico() {
		return tipoControlLogistico;
	}

	/**
	 * @param tipoControlLogistico the tipoControlLogistico to set
	 */
	public void setTipoControlLogistico(CatalogoValorDTO tipoControlLogistico) {
		this.tipoControlLogistico = tipoControlLogistico;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the recepcionProveedorControlLogisticoCol
	 */
	public Collection<RecepcionProveedorControlLogisticoDTO> getRecepcionProveedorControlLogisticoCol() {
		return recepcionProveedorControlLogisticoCol;
	}

	/**
	 * @param recepcionProveedorControlLogisticoCol the recepcionProveedorControlLogisticoCol to set
	 */
	public void setRecepcionProveedorControlLogisticoCol(Collection<RecepcionProveedorControlLogisticoDTO> recepcionProveedorControlLogisticoCol) {
		this.recepcionProveedorControlLogisticoCol = recepcionProveedorControlLogisticoCol;
	}

}
