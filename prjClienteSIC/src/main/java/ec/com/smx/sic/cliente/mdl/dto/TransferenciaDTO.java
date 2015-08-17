package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.TransferenciaID;

/**
 * 
 * @author amunoz
 * @author cherrera
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTTRANSFERENCIA")
public class TransferenciaDTO  extends SimpleAuditDTO{
	
	/**
	 * Clave primaria de la tabla Transferencia
	 * 
	 */
	@EmbeddedId
	private TransferenciaID id = new TransferenciaID();
	
	/**
	 * Corresponde al estado 
	 *
	 */
	@Column(name="ESTADO")
	private String estado;
	
	/**
	 * Corresponde al codigo del area de trabajo de origen
	 *
	 */
	@Column(name="CODIGOAREATRABAJOORIGEN")
	private Integer codigoAreaTrabajoOrigen;
	
	/**
	 * Corresponde al codigo del area de trabajo de destino
	 *
	 */
	@Column(name="CODIGOAREATRABAJODESTINO")
	private Integer codigoAreaTrabajoDestino;
	
	/**
	 * Corresponde al numero de transferencia
	 *
	 */
	@Column(name="NUMEROTRANSFERENCIA")
	private String numeroTransferencia;
	
	/**
	 * Fecha de registro del contenedor
	 *
	 */
	@RegisterDateField
	@Column(name = "FECHAREGISTRO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	/**
	 * Fecha de modificacion del contenedor
	 *
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;
	
	/**
	 * Referencia con la tabla Area Trabajo Origen
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJOORIGEN", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)})
	private AreaTrabajoDTO areaTrabajoOrigenDTO;
	
	/**
	 * Referencia con la tabla Area Trabajo Destino
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJODESTINO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)})
	private AreaTrabajoDTO areaTrabajoDestinoDTO;

	/**
	 * Referencia con la tabla Proceso Logistico
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROCESOLOGISTICO", referencedColumnName="CODIGOPROCESOLOGISTICO", insertable=false, updatable=false)})
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
	/**
	 * @return the id
	 */
	public TransferenciaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TransferenciaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajoOrigen
	 */
	public Integer getCodigoAreaTrabajoOrigen() {
		return codigoAreaTrabajoOrigen;
	}

	/**
	 * @param codigoAreaTrabajoOrigen the codigoAreaTrabajoOrigen to set
	 */
	public void setCodigoAreaTrabajoOrigen(Integer codigoAreaTrabajoOrigen) {
		this.codigoAreaTrabajoOrigen = codigoAreaTrabajoOrigen;
	}

	/**
	 * @return the codigoAreaTrabajoDestino
	 */
	public Integer getCodigoAreaTrabajoDestino() {
		return codigoAreaTrabajoDestino;
	}

	/**
	 * @param codigoAreaTrabajoDestino the codigoAreaTrabajoDestino to set
	 */
	public void setCodigoAreaTrabajoDestino(Integer codigoAreaTrabajoDestino) {
		this.codigoAreaTrabajoDestino = codigoAreaTrabajoDestino;
	}

	/**
	 * @return the numeroTransferencia
	 */
	public String getNumeroTransferencia() {
		return numeroTransferencia;
	}

	/**
	 * @param numeroTransferencia the numeroTransferencia to set
	 */
	public void setNumeroTransferencia(String numeroTransferencia) {
		this.numeroTransferencia = numeroTransferencia;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
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
}
