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
 * Tabla para guadar la relacion entre la recepcion y el detalle de la recepcion de la entrega(placa,preguntas,hora)
 * mercaderia del proveeedor
 * 
 * @author lguaman
 */

@SuppressWarnings("serial")
@Table(name = "SBLOGTDETRECPRO")
public class DetalleRecepcionProveedorDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleRecepcionProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionProveedorID();
	
	/**
	 *
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR", nullable = false)
	private Long codigoRecepcionProveedor ;
	
	/**
	 *
	 */
	@Column(name = "CODIGODETALLERECEPCIONENTREGA", nullable = false)
	private Long codigoDetalleRecepcionEntrega ;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	@Column
	private String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

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
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

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
	 * Referencia con la tabla RecepcionProveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", referencedColumnName = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false) })
	private RecepcionProveedorDTO recepcionProveedorDTO;
	
	/**
	 * Referencia con la tabla RecepcionFurgon
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGODETALLERECEPCIONENTREGA", referencedColumnName = "CODIGODETALLERECEPCIONENTREGA", insertable = false, updatable = false) })
	private DetalleRecepcionEntregaDTO detalleRecepcionEntrega;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionProveedorID id) {
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
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the recepcionProveedorDTO
	 */
	public RecepcionProveedorDTO getRecepcionProveedorDTO() {
		return recepcionProveedorDTO;
	}

	/**
	 * @param recepcionProveedorDTO the recepcionProveedorDTO to set
	 */
	public void setRecepcionProveedorDTO(RecepcionProveedorDTO recepcionProveedorDTO) {
		this.recepcionProveedorDTO = recepcionProveedorDTO;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	/**
	 * @return the detalleRecepcionEntrega
	 */
	public DetalleRecepcionEntregaDTO getDetalleRecepcionEntrega() {
		return detalleRecepcionEntrega;
	}

	/**
	 * @param detalleRecepcionEntrega the detalleRecepcionEntrega to set
	 */
	public void setDetalleRecepcionEntrega(DetalleRecepcionEntregaDTO detalleRecepcionEntrega) {
		this.detalleRecepcionEntrega = detalleRecepcionEntrega;
	}

	/**
	 * @return the codigoDetalleRecepcionEntrega
	 */
	public Long getCodigoDetalleRecepcionEntrega() {
		return codigoDetalleRecepcionEntrega;
	}

	/**
	 * @param codigoDetalleRecepcionEntrega the codigoDetalleRecepcionEntrega to set
	 */
	public void setCodigoDetalleRecepcionEntrega(Long codigoDetalleRecepcionEntrega) {
		this.codigoDetalleRecepcionEntrega = codigoDetalleRecepcionEntrega;
	}


}
