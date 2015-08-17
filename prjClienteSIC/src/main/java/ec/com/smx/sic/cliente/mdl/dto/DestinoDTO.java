
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.facturacion.dto.ClienteDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.DestinoID;

/**
 * Entidad DestinoDTO para la tabla SBLOGTDESTINO
 * @author hgudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDESTINO")
public class DestinoDTO implements Serializable{

	/**
	 * Clave primaria de la tabla DestinoDTO
	 *
	 */
	@EmbeddedId
	private DestinoID id = new DestinoID();
	
	/**
	 * Secuencial de la tabla rutas
	 * 
	 */
	@Column(name = "SECUENCIARUTA", nullable = false)
    private java.lang.Long secuenciaRuta;
	
	/**
	 * Codigo area trabajo destino
	 *
	 */
	@Column(name="CODIGOAREATRABAJO")
	private java.lang.Integer codigoAreaTrabajo;
	

	/**
	 * Codigo cliente destino
	 *
	 */
	@Column(name="CODIGOCLIENTE")
	private java.lang.Long codigoCliente;
	
	/**
	 * Codigo localizacion destino 
	 *
	 */
	@Column(name="CODIGOLOCALIZACION")
	private java.lang.Long codigoLocalizacion ;
	
	/**
	 * Numero de documento destino
	 *
	 */
	@Column(name="NUMERODOCUMENTO")
	private java.lang.String numeroDocumento ;
	
	/**
	 * Razon social destino o nombre completo
	 *
	 */
	@Column(name="RAZONSOCIAL")
	private java.lang.String razonSocial ;
		
	/**
	 * Direccion de destino
	 *
	 */
	@Column(name="DIRECCION")
	private java.lang.String direccion ;

	/**
	 * Ciudad y pais destino
	 *
	 */
	@Column(name="CIUDADPAIS")
	private java.lang.String ciudadPais;
	
	/**
	 * Indica el orden del destino
	 *
	 */
	@Column(name="ORDEN")
	private Integer orden ;
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
	/**
	 * Indica el codigo de catalogo para el estado de destino
	 *
	 */
	@Column(name="VALORTIPOESTADODESTINO")
	private String valorTipoEstadoDestino ;
	
	/**
	 * Indica el tipo de catalogo para el estado de destino
	 *
	 */
	@Column(name="CODIGOTIPOESTADODESTINO")
	private Integer codigoTipoEstadoDestino ;
	
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")	
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioActualizacion;
	
	/**
	 * Relacion con la tabla area de trabajo
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJO", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Relacion con la tabla cliente
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOCLIENTE", insertable=false, updatable=false, referencedColumnName="CODIGOCLIENTE")})
	private ClienteDTO clienteDTO;
	
	/**
	 * Relacion con la tabla localizacion
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOLOCALIZACION", insertable=false, updatable=false, referencedColumnName="CODIGOLOCALIZACION")})
	private LocalizacionDTO localizacionDTO;
	
	/**
	 * Relacion con la tabla Ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIARUTA", insertable=false, updatable=false, referencedColumnName="SECUENCIARUTA")})
	private RutaDTO rutaDTO;
	

	/**
	 * Relacion con la tabla catalogo valor para el estado del destino
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADODESTINO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOESTADODESTINO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO estadoDestinoCatalogoDTO;
	
	/**
	 * Relacion con la tabla usuario para registro de datos
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="USUARIOREGISTRO", referencedColumnName="USERID", insertable=false, updatable=false)})
	private UserDto usuarioRegistroDTO;
	
	/**
	 * Relacion con la tabla usuario para modificacion de datos
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="USUARIOMODIFICACION", referencedColumnName="USERID", insertable=false, updatable=false)})
	private UserDto usuarioModificacionDTO;
	
	public DestinoDTO() {
		
	}

	/**
	 * @return the id
	 */
	public DestinoID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(DestinoID id) {
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
	 * @return the codigoAreaTrabajo
	 */
	public java.lang.Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(java.lang.Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoCliente
	 */
	public java.lang.Long getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(java.lang.Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * @return the codigoLocalizacion
	 */
	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	/**
	 * @param codigoLocalizacion the codigoLocalizacion to set
	 */
	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}

	/**
	 * @return the numeroDocumento
	 */
	public java.lang.String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the razonSocial
	 */
	public java.lang.String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(java.lang.String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the direccion
	 */
	public java.lang.String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the ciudadPais
	 */
	public java.lang.String getCiudadPais() {
		return ciudadPais;
	}

	/**
	 * @param ciudadPais the ciudadPais to set
	 */
	public void setCiudadPais(java.lang.String ciudadPais) {
		this.ciudadPais = ciudadPais;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	/**
	 * @return the clienteDTO
	 */
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	/**
	 * @param clienteDTO the clienteDTO to set
	 */
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	/**
	 * @return the localizacionDTO
	 */
	public LocalizacionDTO getLocalizacionDTO() {
		return localizacionDTO;
	}

	/**
	 * @param localizacionDTO the localizacionDTO to set
	 */
	public void setLocalizacionDTO(LocalizacionDTO localizacionDTO) {
		this.localizacionDTO = localizacionDTO;
	}

	/**
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	/**
	 * @return the usuarioModificacionDTO
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	/**
	 * @param usuarioModificacionDTO the usuarioModificacionDTO to set
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	public java.lang.Long getSecuenciaRuta() {
		return secuenciaRuta;
	}

	public void setSecuenciaRuta(java.lang.Long secuenciaRuta) {
		this.secuenciaRuta = secuenciaRuta;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public RutaDTO getRutaDTO() {
		return rutaDTO;
	}

	public void setRutaDTO(RutaDTO rutaDTO) {
		this.rutaDTO = rutaDTO;
	}

	/**
	 * @return the valorTipoEstadoDestino
	 */
	public String getValorTipoEstadoDestino() {
		return valorTipoEstadoDestino;
	}

	/**
	 * @param valorTipoEstadoDestino the valorTipoEstadoDestino to set
	 */
	public void setValorTipoEstadoDestino(String valorTipoEstadoDestino) {
		this.valorTipoEstadoDestino = valorTipoEstadoDestino;
	}

	/**
	 * @return the codigoTipoEstadoDestino
	 */
	public Integer getCodigoTipoEstadoDestino() {
		return codigoTipoEstadoDestino;
	}

	/**
	 * @param codigoTipoEstadoDestino the codigoTipoEstadoDestino to set
	 */
	public void setCodigoTipoEstadoDestino(Integer codigoTipoEstadoDestino) {
		this.codigoTipoEstadoDestino = codigoTipoEstadoDestino;
	}

	/**
	 * @return the estadoDestinoCatalogoDTO
	 */
	public CatalogoValorDTO getEstadoDestinoCatalogoDTO() {
		return estadoDestinoCatalogoDTO;
	}

	/**
	 * @param estadoDestinoCatalogoDTO the estadoDestinoCatalogoDTO to set
	 */
	public void setEstadoDestinoCatalogoDTO(CatalogoValorDTO estadoDestinoCatalogoDTO) {
		this.estadoDestinoCatalogoDTO = estadoDestinoCatalogoDTO;
	}
}