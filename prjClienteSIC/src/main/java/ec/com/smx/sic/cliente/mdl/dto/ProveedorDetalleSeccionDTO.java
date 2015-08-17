
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
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorDetalleSeccionID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPRODETSEC")
public class ProveedorDetalleSeccionDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla ProveedorDetalleSeccionDTO
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ProveedorDetalleSeccionID id = new ec.com.smx.sic.cliente.mdl.dto.id.ProveedorDetalleSeccionID();
	
	/**
	 * Especifica el codigo de la categoria
	 *
	 */
	@Column(name="CODIGOPROVEEDOR", nullable = false)
	@ComparatorTypeField
	private java.lang.String codigoProveedor ;
	
	/**
	 * Especifica el codigo del detalle de la seccion
	 *
	 */
	@Column(name = "CODIGODETALLESECCION", nullable = false)
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
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Obtiene la relacion DetalleSeccionDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Obtiene la relacion de proveedoresDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ProveedorDTO proveedorDTO;
	/**
	 * Constructor 
	 */
	public ProveedorDetalleSeccionDTO() {
		
	}


	/**
	 * @return the id
	 */
	public ProveedorDetalleSeccionID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ProveedorDetalleSeccionID id) {
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
	 * @return the codigoProveedor
	 */
	public java.lang.String getCodigoProveedor() {
		return codigoProveedor;
	}


	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(java.lang.String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
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


	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}


	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}


	/**
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}


	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

}