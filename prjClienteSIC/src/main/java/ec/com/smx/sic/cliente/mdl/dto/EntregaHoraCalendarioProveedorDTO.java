package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Almacena informacion del calendario de las entregas del proveedor
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITENTHORCALPRO")
public class EntregaHoraCalendarioProveedorDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla EntregaDetalleCalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EntregaHoraCalendarioProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.EntregaHoraCalendarioProveedorID();
	
	/**
	 * Codigo del calendario del proveedor
	 * 
	 */
	@Column(name = "CODIGOHORACALENDARIOPROVEEDOR", nullable = false)
	private java.lang.Long codigoHoraCalendarioProveedor;
	
	/**
	 * Codigo de la entrega
	 * 
	 */
	@Column(name = "CODIGOENTREGA", nullable = false)
	private java.lang.Long codigoEntrega;

	/**
	 * Representa el estado.
	 * 
	 */
	@Column(name = "ESTADO", nullable = false)
	@ComparatorTypeField
	private String estado;

	/**
	 * Fecha en la que se realiza la creacion del registro
	 * 
	 */
	@Column(nullable = false)
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */

	@Transient
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(nullable = false)
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiza la ultima actualizacion.
	 * 
	 */
	@Column
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * Referencia con la tabla HoraCalendarioProveedor 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOHORACALENDARIOPROVEEDOR", referencedColumnName = "CODIGOHORACALENDARIO", insertable = false, updatable = false)
        })
	private HoraCalendarioDTO horaCalendarioDTO;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOENTREGA", referencedColumnName = "CODIGOENTREGA", insertable = false, updatable = false) })
	private EntregaDTO entregaDTO;
	
	/**
	 * Referencia a la tabla CalendarioBodegaProveedor
	 * 
	 */
	@Transient
	@OneToMany(mappedBy = "entregaHoraCalendarioProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaDetalleCalendarioProveedorDTO> detalleEntregaHoraCalendarioProveedorDTOCol;


	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.EntregaHoraCalendarioProveedorID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.EntregaHoraCalendarioProveedorID id) {
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
	 * @return the codigoEntrega
	 */
	public java.lang.Long getCodigoEntrega() {
		return codigoEntrega;
	}


	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(java.lang.Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
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
	 * @return the codigoHoraCalendarioProveedor
	 */
	public java.lang.Long getCodigoHoraCalendarioProveedor() {
		return codigoHoraCalendarioProveedor;
	}


	/**
	 * @param codigoHoraCalendarioProveedor the codigoHoraCalendarioProveedor to set
	 */
	public void setCodigoHoraCalendarioProveedor(java.lang.Long codigoHoraCalendarioProveedor) {
		this.codigoHoraCalendarioProveedor = codigoHoraCalendarioProveedor;
	}

	public HoraCalendarioDTO getHoraCalendarioDTO() {
		return horaCalendarioDTO;
	}


	public void setHoraCalendarioDTO(HoraCalendarioDTO horaCalendarioDTO) {
		this.horaCalendarioDTO = horaCalendarioDTO;
	}


	/**
	 * @return the entregaDTO
	 */
	public EntregaDTO getEntregaDTO() {
		return entregaDTO;
	}


	/**
	 * @param entregaDTO the entregaDTO to set
	 */
	public void setEntregaDTO(EntregaDTO entregaDTO) {
		this.entregaDTO = entregaDTO;
	}


	/**
	 * @return the detalleEntregaHoraCalendarioProveedorDTOCol
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> getDetalleEntregaHoraCalendarioProveedorDTOCol() {
		return detalleEntregaHoraCalendarioProveedorDTOCol;
	}


	/**
	 * @param detalleEntregaHoraCalendarioProveedorDTOCol the detalleEntregaHoraCalendarioProveedorDTOCol to set
	 */
	public void setDetalleEntregaHoraCalendarioProveedorDTOCol(Collection<EntregaDetalleCalendarioProveedorDTO> detalleEntregaHoraCalendarioProveedorDTOCol) {
		this.detalleEntregaHoraCalendarioProveedorDTOCol = detalleEntregaHoraCalendarioProveedorDTOCol;
	}
	
}