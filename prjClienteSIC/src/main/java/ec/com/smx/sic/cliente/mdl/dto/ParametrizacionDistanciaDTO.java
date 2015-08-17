
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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ParametrizacionDistanciaID;

/**
 * Entidad FurgonDTO para la tabla SBLOGTPARDIS
 * @author hgudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPARDIS")
public class ParametrizacionDistanciaDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla 
	 *
	 */
	@EmbeddedId
	private ParametrizacionDistanciaID id = new ParametrizacionDistanciaID();
	
	/**
	 * Valor del area de trabajo origen
	 *
	 */
	@Column(name="CODIGOAREATRABAJOORIGEN")
	private java.lang.Integer codigoAreaTrabajoOrigen ;
	

	/**
	 * Valor del area de trabajo destino
	 *
	 */
	@Column(name="CODIGOAREATRABAJODESTINO")
	private java.lang.Integer codigoAreaTrabajoDestino ;
	
	/**
	 * Secuencia dela localizacion destino
	 *
	 */
	@Column(name="CODIGOLOCALIZACION")
	private java.lang.Long codigoLocalizacionDestino ;
	
	/**
	 * Valor del la distancia entre destinos
	 *
	 */
	@Column(name="DISTANCIA")
	private java.lang.Double distancia ;	
	
	/**
	 * Valor del la ruta entre puntos
	 *
	 */
	@Column(name="COSTO")
	private java.lang.Double costo ;	
	
	/**
	 * Valor que indica cual es la bonificacion de la distancia
	 *
	 */
	@Column(name="BONIFICACION")
	private java.lang.Double bonificacion ;	
	
	/**
	 * Valor que indica cuantos puntos gano en distancias
	 *
	 */
	@Column(name="PUNTOS")
	private java.lang.Integer puntos ;	
			
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
	/**
	 * Relacion con la tabla area trabajo origen
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoOrigenDTO;
	
	/**
	 * Relacion con la tabla area trabajo destino
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJODESTINO", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoDestinoDTO;
	
	/**
	 * Relacion con la tabla area trabajo destino
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOLOCALIZACION", insertable=false, updatable=false, referencedColumnName="CODIGOLOCALIZACION")})
	private LocalizacionDTO localizacionDestinoDTO;
		
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
	

	
	public ParametrizacionDistanciaDTO() {
		
	}

	/**
	 * @return the id
	 */
	public ParametrizacionDistanciaID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ParametrizacionDistanciaID id) {
		this.id = id;
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
	 * @return the distancia
	 */
	public java.lang.Double getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(java.lang.Double distancia) {
		this.distancia = distancia;
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
	 * @return the costo
	 */
	public java.lang.Double getCosto() {
		return costo;
	}

	/**
	 * @param costo the costo to set
	 */
	public void setCosto(java.lang.Double costo) {
		this.costo = costo;
	}

	/**
	 * @return the bonificacion
	 */
	public java.lang.Double getBonificacion() {
		return bonificacion;
	}

	/**
	 * @param bonificacion the bonificacion to set
	 */
	public void setBonificacion(java.lang.Double bonificacion) {
		this.bonificacion = bonificacion;
	}

	/**
	 * @return the puntos
	 */
	public java.lang.Integer getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(java.lang.Integer puntos) {
		this.puntos = puntos;
	}
	
	
}