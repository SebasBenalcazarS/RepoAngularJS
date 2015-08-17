
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import ec.com.smx.sic.cliente.mdl.dto.id.CategoriaDetalleSeccionID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCATDETSEC")
public class CategoriaDetalleSeccionDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleSeccion
	 *
	 */
	@EmbeddedId
	private CategoriaDetalleSeccionID id = new CategoriaDetalleSeccionID();
	
	/**
	 * Especifica el codigo de la categoria
	 *
	 */
	@Column(name="CODIGOCATEGORIA", nullable = false)
	@ComparatorTypeField
	private java.lang.Long codigoCategoria ;
	
	/**
	 * Especifica el codigo del detalle de la seccion
	 *

	 */
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	@ComparatorTypeField
	private java.lang.Long codigoDetalleSeccion ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizo la  ultima actualizacion.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Especifica la relacion con la seccion de la estructura logistica
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOCATEGORIA", referencedColumnName = "CODIGOCATEGORIA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.CategoriaDTO categoriaDTO;

	
	public CategoriaDetalleSeccionDTO() {
		
	}


	/**
	 * @return the id
	 */
	public CategoriaDetalleSeccionID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(CategoriaDetalleSeccionID id) {
		this.id = id;
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
	 * @return the categoriaDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}


	/**
	 * @param categoriaDTO the categoriaDTO to set
	 */
	public void setCategoriaDTO(ec.com.smx.sic.cliente.mdl.dto.CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
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
	 * @return the codigoCategoria
	 */
	public java.lang.Long getCodigoCategoria() {
		return codigoCategoria;
	}


	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(java.lang.Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}


	/**
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}


	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

}