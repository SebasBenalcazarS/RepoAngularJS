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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
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
@Table(name = "SCFDITENTDETCALPRO")
public class EntregaDetalleCalendarioProveedorDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DetalleEntregaHoraCalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.EntregaDetalleCalendarioProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.EntregaDetalleCalendarioProveedorID();
	
	/**
	 * Codigo del calendario del proveedor
	 * 
	 */
	@Column(name = "CODIGODETALLECALENDARIO", nullable = true)
	private java.lang.Long codigoDetalleCalendario;
	
	/**
	 * Codigo de la entrega del proveedor
	 * 
	 */
	@Column(name = "CODIGOENTREGA", nullable = true)
	private java.lang.Long codigoEntrega;
	
	/**
	 * Codigo del tipo de seccion de la estructura logistica en el catalogo
	 *
	 */
	@Column(nullable=false)
	private Integer codigoTipoSeccion ;
	
	/**
	 * Codigo del tipo de seccion de la estructura logistica en el catalogo
	 *
	 */
	@Column(nullable=false)
	private String valorTipoSeccion ;
	
	/**
	 * Codigo del tipo de estado de autorizacion
	 *
	 */
	@Column(nullable=false)
	private Integer tipoEstadoAutorizacion;

	
	/**
	 * valor del tipo de estado de autorizacion
	 *
	 */
	@Column(nullable=false)
	private String valorEstadoAutorizacion;	
	
	/**
	 * Representa el estado.
	 * 
	 */
	@Column(name = "ESTADO", nullable = false)
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Cantidad de andenes utilizados
	 *
	 */
	@Column
	private Integer cantidadUtilizada ;
	
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
	@LastModificationDateField
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
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;
	
	/**
	 * Referencia con la tabla EntregaHoraCalendarioProveedor
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLECALENDARIO", referencedColumnName = "CODIGODETALLECALENDARIO", insertable = false, updatable = false) })
	private DetalleCalendarioDTO detalleCalendarioDTO;
	
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
	 * Obtiene la relacion con los detalles de la tarea
	 */
	@OneToMany(mappedBy = "entregaDetalleCalendarioProveedor", fetch = LAZY)
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRecepcionEntregaDTO> detalleRecepcionEntregaDTOCol;


	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.EntregaDetalleCalendarioProveedorID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.EntregaDetalleCalendarioProveedorID id) {
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
	 * @return the codigoDetalleCalendarioProveedor
	 */
	public java.lang.Long getCodigoDetalleCalendario() {
		return codigoDetalleCalendario;
	}


	/**
	 * @param codigoDetalleCalendarioProveedor the codigoDetalleCalendarioProveedor to set
	 */
	public void setCodigoDetalleCalendarioProveedor(java.lang.Long codigoDetalleCalendario) {
		this.codigoDetalleCalendario = codigoDetalleCalendario;
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
	 * @return the tipoEstadoAutorizacion
	 */
	public Integer getTipoEstadoAutorizacion() {
		return tipoEstadoAutorizacion;
	}


	/**
	 * @param tipoEstadoAutorizacion the tipoEstadoAutorizacion to set
	 */
	public void setTipoEstadoAutorizacion(Integer tipoEstadoAutorizacion) {
		this.tipoEstadoAutorizacion = tipoEstadoAutorizacion;
	}
	
	/**
	 * @return the codigoTipoSeccion
	 */
	public String getValorEstadoAutorizacion() {
		return valorEstadoAutorizacion;
	}


	/**
	 * @param codigoTipoSeccion the codigoTipoSeccion to set
	 */
	public void setValorEstadoAutorizacion(String valorEstadoAutorizacion) {
		this.valorEstadoAutorizacion = valorEstadoAutorizacion;
	}	
	/**
	 * @return the detalleCalendarioProveedorDTO
	 */
	public DetalleCalendarioDTO getDetalleCalendarioDTO() {
		return detalleCalendarioDTO;
	}


	/**
	 * @param detalleCalendarioProveedorDTO the detalleCalendarioProveedorDTO to set
	 */
	public void setDetalleCalendarioDTO(DetalleCalendarioDTO detalleCalendarioDTO) {
		this.detalleCalendarioDTO = detalleCalendarioDTO;
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
	 * @param codigoDetalleCalendario the codigoDetalleCalendario to set
	 */
	public void setCodigoDetalleCalendario(java.lang.Long codigoDetalleCalendario) {
		this.codigoDetalleCalendario = codigoDetalleCalendario;
	}


	/**
	 * @return the cantidadUtilizada
	 */
	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}


	/**
	 * @param cantidadUtilizada the cantidadUtilizada to set
	 */
	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}


	/**
	 * @return the detalleRecepcionEntregaDTOCol
	 */
	public Collection<DetalleRecepcionEntregaDTO> getDetalleRecepcionEntregaDTOCol() {
		return detalleRecepcionEntregaDTOCol;
	}


	/**
	 * @param detalleRecepcionEntregaDTOCol the detalleRecepcionEntregaDTOCol to set
	 */
	public void setDetalleRecepcionEntregaDTOCol(Collection<DetalleRecepcionEntregaDTO> detalleRecepcionEntregaDTOCol) {
		this.detalleRecepcionEntregaDTOCol = detalleRecepcionEntregaDTOCol;
	}
	
	/**
	 * @return the tieneDetalleRecepcionEntregaDTOCol
	 */
	public Boolean getTieneDetalleRecepcionEntregaDTOCol() {
		return isLoaded(this.detalleRecepcionEntregaDTOCol) && !this.detalleRecepcionEntregaDTOCol.isEmpty();
	}


	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}


	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
}