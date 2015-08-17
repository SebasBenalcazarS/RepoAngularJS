package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorFacturaID;
@SuppressWarnings("serial")
@Table(name = "SBLOGTRECPROFAC")
public class RecepcionProveedorFacturaDTO extends SimpleAuditDTO{
	/**
	 * Clave primaria de la tabla RecepcionProveedorFacturaDTO
	 * 
	 */
	@EmbeddedId
	private RecepcionProveedorFacturaID id = new RecepcionProveedorFacturaID();

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	private String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizO la Ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Relacion con la Recepcion proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false, referencedColumnName = "CODIGORECEPCIONPROVEEDOR") })
	private RecepcionProveedorDTO recepcionProveedorDTO;
	
	
	/**
	 * Relacion con la factura
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;
	
	public RecepcionProveedorFacturaID getId() {
		return id;
	}

	public void setId(RecepcionProveedorFacturaID id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public RecepcionProveedorDTO getRecepcionProveedorDTO() {
		return recepcionProveedorDTO;
	}

	public void setRecepcionProveedorDTO(RecepcionProveedorDTO recepcionProveedorDTO) {
		this.recepcionProveedorDTO = recepcionProveedorDTO;
	}

	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}

	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}
	
	
}
