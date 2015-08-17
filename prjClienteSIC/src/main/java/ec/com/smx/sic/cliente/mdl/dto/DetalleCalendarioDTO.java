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
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Almacena informacion del detalle del calendario del proveedor
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTDETCAL")
public class DetalleCalendarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleCalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleCalendarioID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleCalendarioID();
	
	/**
	 * Codigo del calendario del proveedor
	 * 
	 */
	@Column(name = "CODIGOHORACALENDARIO", nullable = false)
	private java.lang.Long codigoHoraCalendario;

	/**
	 * Código del tipo de seccion de la estructura logistica en el catálogo
	 *
	 */
	@Column
	private Integer codigoTipoSeccion ;
	
	/**
	 * Código del tipo de seccion de la estructura logistica en el catálogo
	 *
	 */
	@Column
	private String valorTipoSeccion ;
	
	/**
	 * Cantidad disponible de horas
	 *
	 */
	@Column
	private Integer cantidadDisponible ;
	
	/**
	 * Representa el estado.
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Fecha en la que se realiza la creacion del registro
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
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realizó la última actualización.
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
        @JoinColumn(name = "CODIGOHORACALENDARIO", referencedColumnName = "CODIGOHORACALENDARIO", insertable = false, updatable = false)
        })
	private HoraCalendarioDTO horaCalendarioDTO;
	
	/**
	 * Referencia con la tabla EntregaDetalleCalendarioProveedor 
	 */
	@OneToMany(mappedBy = "detalleCalendarioDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOCol;


	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleCalendarioID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleCalendarioID id) {
		this.id = id;
	}


	public java.lang.Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}


	public void setCodigoHoraCalendario(java.lang.Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}


	public HoraCalendarioDTO getHoraCalendarioDTO() {
		return horaCalendarioDTO;
	}


	public void setHoraCalendarioDTO(HoraCalendarioDTO horaCalendarioDTO) {
		this.horaCalendarioDTO = horaCalendarioDTO;
	}


	/**
	 * @return the codigoTipoSeccion
	 */
	public Integer getCodigoTipoSeccion() {
		return codigoTipoSeccion;
	}


	/**
	 * @param codigoTipoSeccion the codigoTipoSeccion to set
	 */
	public void setCodigoTipoSeccion(Integer codigoTipoSeccion) {
		this.codigoTipoSeccion = codigoTipoSeccion;
	}


	/**
	 * @return the valorTipoSeccion
	 */
	public String getValorTipoSeccion() {
		return valorTipoSeccion;
	}


	/**
	 * @param valorTipoSeccion the valorTipoSeccion to set
	 */
	public void setValorTipoSeccion(String valorTipoSeccion) {
		this.valorTipoSeccion = valorTipoSeccion;
	}


	/**
	 * @return the cantidadDisponible
	 */
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}


	/**
	 * @param cantidadDisponible the cantidadDisponible to set
	 */
	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
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
	 * @return the entregaDetalleCalendarioProveedorDTOCol
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> getEntregaDetalleCalendarioProveedorDTOCol() {
		return entregaDetalleCalendarioProveedorDTOCol;
	}

	/**
	 * @param entregaDetalleCalendarioProveedorDTOCol the entregaDetalleCalendarioProveedorDTOCol to set
	 */
	public void setEntregaDetalleCalendarioProveedorDTOCol(Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOCol) {
		this.entregaDetalleCalendarioProveedorDTOCol = entregaDetalleCalendarioProveedorDTOCol;
	}

}