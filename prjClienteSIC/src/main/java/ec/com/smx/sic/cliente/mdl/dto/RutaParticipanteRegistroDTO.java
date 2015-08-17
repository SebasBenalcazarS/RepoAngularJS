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
import ec.com.smx.corpv2.dto.VehiculoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.RutaParticipanteRegistroID;

/**
 * 
 * @author hgudino
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRUTPARREG")

public class RutaParticipanteRegistroDTO implements Serializable{
	
	/**
	 * Clave primaria de la tabla Ruta Bitacora
	 * 
	 */
	@EmbeddedId
	private RutaParticipanteRegistroID id = new RutaParticipanteRegistroID();
	
	/**
	 * Codigo de area de trabajo origen
	 *
	 */
	@Column(name="CODIGOAREATRABAJOORIGEN")
	private java.lang.Integer codigoAreaTrabajoOrigen;
	
	/**
	 * Codigo de area de trabajo destino
	 *
	 */
	@Column(name="CODIGOAREATRABAJODESTINO")
	private java.lang.Integer codigoAreaTrabajoDestino;
	
	/**
	 * Codigo de localizacion origen
	 *
	 */
	@Column(name="CODIGOLOCALIZACIONORIGEN")
	private java.lang.Long codigoLocalizacionOrigen;
	
	/**
	 * Codigo de localizacion origen
	 *
	 */
	@Column(name="CODIGOLOCALIZACIONDESTINO")
	private java.lang.Long codigoLocalizacionDestino;
	

	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;
	
	/**
	 * Observacion de salida
	 *
	 */
	@Column(name="OBSERVACION")
	private java.lang.String observacion;
	
	/**
	 * Fecha y hora de transaccion
	 */
	@Column(name = "FECHAHORA")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaHora;
	
	
	/**
	 * Codigo ubicacion de salida (Relacion con la tabla detalle seccion)
	 *
	 */
	@Column(name="UBICACION")
	private java.lang.String ubicacion;
	
	
	
	/**
	 * Codigo vehiculo llega a destino
	 *
	 */
	@Column(name="CODIGOVEHICULO")
	private java.lang.Long codigoVehiculo;
	
	/**
	 * Codigo furgon llega a destino
	 *
	 */
	@Column(name="CODIGOFURGON")
	private java.lang.Integer codigoFurgon;
	
	/**
	 * Sello 1 de llegada 
	 *
	 */
	@Column(name="SELLO1")
	private java.lang.String sello1;
	
	/**
	 * Sello 2 de llegada 
	 *
	 */
	@Column(name="SELLO2")
	private java.lang.String sello2;
	
	/**
	 * Sello 3 de llegada 
	 *
	 */
	@Column(name="SELLO3")
	private java.lang.String sello3;
	
	/**
	 * Horometro de llegada 
	 *
	 */
	@Column(name="HOROMETRO")
	private java.lang.String horometro;
		
	/**
	 * Valor del tipo de movimineto para ruta
	 *
	 */
	@Column(name="VALORTIPOMOVIMIENTO")
	private java.lang.String valorTipoMovimiento ;
	
	/**
	 * C�digo del tipo de movimiento para ruta
	 *
	 */
	@Column(name="CODIGOTIPOMOVIMIENTO")
	private java.lang.Integer codigoTipoMovimiento;
		
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
	 * Relacion con la tabla area de trabajo para el Origen
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoOrigenDTO;
	
	/**
	 * Relacion con la tabla area de trabajo para el destino
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJODESTINO", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoDestinoDTO;
	
	/**
	 * Relacion con la tabla localizacion para el origen
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOLOCALIZACIONORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGOLOCALIZACION")})
	private LocalizacionDTO localizacionOrigenDTO;
	
	/**
	 * Relacion con la tabla localizacion para el destino
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOLOCALIZACIONDESTINO", insertable=false, updatable=false, referencedColumnName="CODIGOLOCALIZACION")})
	private LocalizacionDTO localizacionDestinoDTO;
	
	
	/**
	 * Relacion con la tabla vehiculos
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOVEHICULO", insertable=false, updatable=false, referencedColumnName="CODIGOVEHICULO")})
	private VehiculoDTO vehiculoDTO;
	
	/**
	 * Relacion con la tabla furgon
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOFURGON", insertable=false, updatable=false, referencedColumnName="CODIGOFURGON")})
	private FurgonDTO furgonDTO;
	
	
	/**
	 * Relacion con la tabla catalogo valor para el tipo de movimiento de la ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOMOVIMIENTO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOMOVIMIENTO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoMovimientoDTO;
	

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
	
	
	public RutaParticipanteRegistroDTO() {		
	}
	
	/**
	 * @return the id
	 */
	public RutaParticipanteRegistroID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(RutaParticipanteRegistroID id) {
		this.id = id;
	}
	
	/**
	 * @return the estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}
	
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(java.lang.String estado) {
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

	/**
	 * @return the codigoAreaTrabajoOrigen
	 */
	public java.lang.Integer getCodigoAreaTrabajoOrigen() {
		return codigoAreaTrabajoOrigen;
	}

	/**
	 * @param codigoAreaTrabajoOrigen the codigoAreaTrabajoOrigen to set
	 */
	public void setCodigoAreaTrabajoOrigen(java.lang.Integer codigoAreaTrabajoOrigen) {
		this.codigoAreaTrabajoOrigen = codigoAreaTrabajoOrigen;
	}

	/**
	 * @return the codigoAreaTrabajoDestino
	 */
	public java.lang.Integer getCodigoAreaTrabajoDestino() {
		return codigoAreaTrabajoDestino;
	}

	/**
	 * @param codigoAreaTrabajoDestino the codigoAreaTrabajoDestino to set
	 */
	public void setCodigoAreaTrabajoDestino(java.lang.Integer codigoAreaTrabajoDestino) {
		this.codigoAreaTrabajoDestino = codigoAreaTrabajoDestino;
	}

	/**
	 * @return the codigoLocalizacionOrigen
	 */
	public java.lang.Long getCodigoLocalizacionOrigen() {
		return codigoLocalizacionOrigen;
	}

	/**
	 * @param codigoLocalizacionOrigen the codigoLocalizacionOrigen to set
	 */
	public void setCodigoLocalizacionOrigen(java.lang.Long codigoLocalizacionOrigen) {
		this.codigoLocalizacionOrigen = codigoLocalizacionOrigen;
	}

	/**
	 * @return the codigoLocalizacionDestino
	 */
	public java.lang.Long getCodigoLocalizacionDestino() {
		return codigoLocalizacionDestino;
	}

	/**
	 * @param codigoLocalizacionDestino the codigoLocalizacionDestino to set
	 */
	public void setCodigoLocalizacionDestino(java.lang.Long codigoLocalizacionDestino) {
		this.codigoLocalizacionDestino = codigoLocalizacionDestino;
	}

	

	


	/**
	 * @return the areaTrabajoOrigenDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoOrigenDTO() {
		return areaTrabajoOrigenDTO;
	}

	/**
	 * @param areaTrabajoOrigenDTO the areaTrabajoOrigenDTO to set
	 */
	public void setAreaTrabajoOrigenDTO(AreaTrabajoDTO areaTrabajoOrigenDTO) {
		this.areaTrabajoOrigenDTO = areaTrabajoOrigenDTO;
	}

	/**
	 * @return the areaTrabajoDestinoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDestinoDTO() {
		return areaTrabajoDestinoDTO;
	}

	/**
	 * @param areaTrabajoDestinoDTO the areaTrabajoDestinoDTO to set
	 */
	public void setAreaTrabajoDestinoDTO(AreaTrabajoDTO areaTrabajoDestinoDTO) {
		this.areaTrabajoDestinoDTO = areaTrabajoDestinoDTO;
	}

	/**
	 * @return the localizacionOrigenDTO
	 */
	public LocalizacionDTO getLocalizacionOrigenDTO() {
		return localizacionOrigenDTO;
	}

	/**
	 * @param localizacionOrigenDTO the localizacionOrigenDTO to set
	 */
	public void setLocalizacionOrigenDTO(LocalizacionDTO localizacionOrigenDTO) {
		this.localizacionOrigenDTO = localizacionOrigenDTO;
	}

	/**
	 * @return the localizacionDestinoDTO
	 */
	public LocalizacionDTO getLocalizacionDestinoDTO() {
		return localizacionDestinoDTO;
	}

	/**
	 * @param localizacionDestinoDTO the localizacionDestinoDTO to set
	 */
	public void setLocalizacionDestinoDTO(LocalizacionDTO localizacionDestinoDTO) {
		this.localizacionDestinoDTO = localizacionDestinoDTO;
	}




	

	/**
	 * @return the valorTipoMovimiento
	 */
	public java.lang.String getValorTipoMovimiento() {
		return valorTipoMovimiento;
	}

	/**
	 * @param valorTipoMovimiento the valorTipoMovimiento to set
	 */
	public void setValorTipoMovimiento(java.lang.String valorTipoMovimiento) {
		this.valorTipoMovimiento = valorTipoMovimiento;
	}

	/**
	 * @return the codigoTipoMovimiento
	 */
	public java.lang.Integer getCodigoTipoMovimiento() {
		return codigoTipoMovimiento;
	}

	/**
	 * @param codigoTipoMovimiento the codigoTipoMovimiento to set
	 */
	public void setCodigoTipoMovimiento(java.lang.Integer codigoTipoMovimiento) {
		this.codigoTipoMovimiento = codigoTipoMovimiento;
	}

	/**
	 * @return the tipoMovimientoDTO
	 */
	public CatalogoValorDTO getTipoMovimientoDTO() {
		return tipoMovimientoDTO;
	}

	/**
	 * @param tipoMovimientoDTO the tipoMovimientoDTO to set
	 */
	public void setTipoMovimientoDTO(CatalogoValorDTO tipoMovimientoDTO) {
		this.tipoMovimientoDTO = tipoMovimientoDTO;
	}

	/**
	 * @return the observacion
	 */
	public java.lang.String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(java.lang.String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the fechaHora
	 */
	public java.util.Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the ubicacion
	 */
	public java.lang.String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(java.lang.String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the codigoVehiculo
	 */
	public java.lang.Long getCodigoVehiculo() {
		return codigoVehiculo;
	}

	/**
	 * @param codigoVehiculo the codigoVehiculo to set
	 */
	public void setCodigoVehiculo(java.lang.Long codigoVehiculo) {
		this.codigoVehiculo = codigoVehiculo;
	}

	/**
	 * @return the codigoFurgon
	 */
	public java.lang.Integer getCodigoFurgon() {
		return codigoFurgon;
	}

	/**
	 * @param codigoFurgon the codigoFurgon to set
	 */
	public void setCodigoFurgon(java.lang.Integer codigoFurgon) {
		this.codigoFurgon = codigoFurgon;
	}

	/**
	 * @return the sello1
	 */
	public java.lang.String getSello1() {
		return sello1;
	}

	/**
	 * @param sello1 the sello1 to set
	 */
	public void setSello1(java.lang.String sello1) {
		this.sello1 = sello1;
	}

	/**
	 * @return the sello2
	 */
	public java.lang.String getSello2() {
		return sello2;
	}

	/**
	 * @param sello2 the sello2 to set
	 */
	public void setSello2(java.lang.String sello2) {
		this.sello2 = sello2;
	}

	/**
	 * @return the sello3
	 */
	public java.lang.String getSello3() {
		return sello3;
	}

	/**
	 * @param sello3 the sello3 to set
	 */
	public void setSello3(java.lang.String sello3) {
		this.sello3 = sello3;
	}

	/**
	 * @return the horometro
	 */
	public java.lang.String getHorometro() {
		return horometro;
	}

	/**
	 * @param horometro the horometro to set
	 */
	public void setHorometro(java.lang.String horometro) {
		this.horometro = horometro;
	}

	/**
	 * @return the vehiculoDTO
	 */
	public VehiculoDTO getVehiculoDTO() {
		return vehiculoDTO;
	}

	/**
	 * @param vehiculoDTO the vehiculoDTO to set
	 */
	public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
		this.vehiculoDTO = vehiculoDTO;
	}

	/**
	 * @return the furgonDTO
	 */
	public FurgonDTO getFurgonDTO() {
		return furgonDTO;
	}

	/**
	 * @param furgonDTO the furgonDTO to set
	 */
	public void setFurgonDTO(FurgonDTO furgonDTO) {
		this.furgonDTO = furgonDTO;
	}	
}
