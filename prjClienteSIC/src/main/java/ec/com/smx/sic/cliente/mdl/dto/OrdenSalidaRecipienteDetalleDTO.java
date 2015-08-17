package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaRecipienteDetalleID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETORDSAL")
public class OrdenSalidaRecipienteDetalleDTO implements Serializable {
	/**
	 * id (codigoCompania, codigoOrdenDetalle)
	 */
	@EmbeddedId
	private OrdenSalidaRecipienteDetalleID id = new OrdenSalidaRecipienteDetalleID();
	/**
	 * Codigo padre
	 * 
	 */
	@Column(name = "CODIGOORDENSALIDA", nullable = false)
	private Long codigoOrdenSalida;
	/**
	 * Relacion Codigo del recipiente
	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
		
	/**
	 * Cantidad recibida por recipiente
	 */
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	/**
	 * Estado
	 */
	@Column(name = "ESTADO")
	private String estado;
	/**
	 * Datos de auditoria
	 */
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
		/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOORDENSALIDA", referencedColumnName = "CODIGOORDENSALIDA", insertable = false, updatable = false) })
	private OrdenSalidaRecipienteDTO ordenSalidaRecipienteDTO;
	
	
	@OneToMany(mappedBy="ordenSalidaRecipienteDetalleDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<OrdenSalidaControlRecipienteDetalleDTO> ordenSalidaControlRecipienteDetalleCol;
	
	@Transient
	private String descripcionArticulo;
	@Transient
	private Integer cantidadAcumulada;

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return OrdenSalidaRecipienteDetalleID id 
	 */
	public OrdenSalidaRecipienteDetalleID getId() {
		return id;
	}


	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param id parametro de tipo OrdenSalidaRecipienteDetalleID
	 */
	public void setId(OrdenSalidaRecipienteDetalleID id) {
		this.id = id;
	}


	/* Metodo que retorna codigoOrdenSalida del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Long codigoOrdenSalida 
	 */
	public Long getCodigoOrdenSalida() {
		return codigoOrdenSalida;
	}


	/* Metodo que asigna el codigoOrdenSalida del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param codigoOrdenSalida parametro de tipo Long
	 */
	public void setCodigoOrdenSalida(Long codigoOrdenSalida) {
		this.codigoOrdenSalida = codigoOrdenSalida;
	}


	/* Metodo que retorna codigoArticulo del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return String codigoArticulo 
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}


	/* Metodo que asigna el codigoArticulo del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param codigoArticulo parametro de tipo String
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}


	/* Metodo que retorna cantidad del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Integer cantidad 
	 */
	public Integer getCantidad() {
		return cantidad;
	}


	/* Metodo que asigna el cantidad del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param cantidad parametro de tipo Integer
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return String estado 
	 */
	public String getEstado() {
		return estado;
	}


	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param estado parametro de tipo String
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return String idUsuarioRegistro 
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}


	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param idUsuarioRegistro parametro de tipo String
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Date fechaRegistro 
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param fechaRegistro parametro de tipo Date
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return String idUsuarioModificacion 
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}


	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param idUsuarioModificacion parametro de tipo String
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}


	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Date fechaModificacion 
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param fechaModificacion parametro de tipo Date
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	/* Metodo que retorna usuarioRegistroDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return UserDto usuarioRegistroDTO 
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}


	/* Metodo que asigna el usuarioRegistroDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param usuarioRegistroDTO parametro de tipo UserDto
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}


	/* Metodo que retorna usuarioModificacionDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return UserDto usuarioModificacionDTO 
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}


	/* Metodo que asigna el usuarioModificacionDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param usuarioModificacionDTO parametro de tipo UserDto
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}


	/* Metodo que retorna ordenSalidaRecipienteDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return OrdenSalidaRecipienteDTO ordenSalidaRecipienteDTO 
	 */
	public OrdenSalidaRecipienteDTO getOrdenSalidaRecipienteDTO() {
		return ordenSalidaRecipienteDTO;
	}


	/* Metodo que asigna el ordenSalidaRecipienteDTO del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param ordenSalidaRecipienteDTO parametro de tipo OrdenSalidaRecipienteDTO
	 */
	public void setOrdenSalidaRecipienteDTO(OrdenSalidaRecipienteDTO ordenSalidaRecipienteDTO) {
		this.ordenSalidaRecipienteDTO = ordenSalidaRecipienteDTO;
	}


	/* Metodo que retorna ordenSalidaControlRecipienteDetalleCol del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @return Collection<OrdenSalidaControlRecipienteDetalleDTO> ordenSalidaControlRecipienteDetalleCol 
	 */
	public Collection<OrdenSalidaControlRecipienteDetalleDTO> getOrdenSalidaControlRecipienteDetalleCol() {
		return ordenSalidaControlRecipienteDetalleCol;
	}


	/* Metodo que asigna el ordenSalidaControlRecipienteDetalleCol del objeto
	 * @author srodriguez
	 * 10/10/2014
	 * @param ordenSalidaControlRecipienteDetalleCol parametro de tipo Collection<OrdenSalidaControlRecipienteDetalleDTO>
	 */
	public void setOrdenSalidaControlRecipienteDetalleCol(Collection<OrdenSalidaControlRecipienteDetalleDTO> ordenSalidaControlRecipienteDetalleCol) {
		this.ordenSalidaControlRecipienteDetalleCol = ordenSalidaControlRecipienteDetalleCol;
	}


	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}


	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}


	public Integer getCantidadAcumulada() {
		return cantidadAcumulada;
	}


	public void setCantidadAcumulada(Integer cantidadAcumulada) {
		this.cantidadAcumulada = cantidadAcumulada;
	}
}
