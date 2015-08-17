/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
 * @author dalmeida
 *
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTRECPROCONLOG")
public class RecepcionProveedorControlLogisticoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorControlLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorControlLogisticoID();
	
	@Column(name = "CODIGORECEPCIONPROVEEDOR")
	private Long codigoRecepcionProveedor;
	
	@Column(name = "CODIGOCONTROLLOGISTICO")
	private Long codigoControlLogistico;
	
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
	
	/**
	 * Relacion con recepcion proveedor
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false, referencedColumnName = "CODIGORECEPCIONPROVEEDOR") })
	private RecepcionProveedorDTO recepcionProveedorDTO;
	
	/**
	 * Relacion con el control logistico
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCONTROLLOGISTICO", insertable = false, updatable = false, referencedColumnName = "CODIGOCONTROLLOGISTICO") })
	private ControlLogisticoDTO controlLogisticoDTO;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorControlLogisticoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorControlLogisticoID id) {
		this.id = id;
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
	 * @return the codigoControlLogistico
	 */
	public Long getCodigoControlLogistico() {
		return codigoControlLogistico;
	}

	/**
	 * @param codigoControlLogistico the codigoControlLogistico to set
	 */
	public void setCodigoControlLogistico(Long codigoControlLogistico) {
		this.codigoControlLogistico = codigoControlLogistico;
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
	 * @return the controlLogisticoDTO
	 */
	public ControlLogisticoDTO getControlLogisticoDTO() {
		return controlLogisticoDTO;
	}

	/**
	 * @param controlLogisticoDTO the controlLogisticoDTO to set
	 */
	public void setControlLogisticoDTO(ControlLogisticoDTO controlLogisticoDTO) {
		this.controlLogisticoDTO = controlLogisticoDTO;
	}
	
}
