package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorControlRecipienteID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRECPROCONRCI")
public class RecepcionProveedorControlRecipienteDTO implements Serializable {
	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private RecepcionProveedorControlRecipienteID id = new RecepcionProveedorControlRecipienteID();
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
	/**
	 * Referencia RecepcionProveedor
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", referencedColumnName = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false) 
	})
	private RecepcionProveedorDTO recepcionProveedorDTO;
	
	/**
	 * Referencia ControRecipienteDTO
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
				@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
				@JoinColumn(name = "CODIGOCONTROLRECIPIENTE", referencedColumnName = "CODIGOCONTROLRECIPIENTE", insertable = false, updatable = false)
	})
	private ControlRecipienteDTO controlRecipienteDTO;
	
	@Transient
	private Map<String,Object> dynamicProperties;

	
	public<T> void addDynamicProperty(String name,T value){
		if(this.dynamicProperties == null){
			dynamicProperties = new HashMap<String,Object>();
		}
		dynamicProperties.put(name, value);
	}
	public Map<String, Object> getDynamicProperties() {
		return dynamicProperties;
	}
	public void setDynamicProperties(Map<String, Object> dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	@SuppressWarnings("unchecked")
	public<T> T getDynamicProperty(String name,Class<T> classValue){
		if(this.dynamicProperties == null){
			return null;
		}
		return (T)dynamicProperties.get(name);
	}
	public Object getDynamicProperty(String name){
		if(this.dynamicProperties == null){
			return null;
		}
		return dynamicProperties.get(name);
	}
	public Boolean hasDynamicProperty(String name){
		if(this.dynamicProperties == null){
			return Boolean.FALSE;
		}
		return dynamicProperties.containsKey(name);
	}
	public void removeDynamicProperty(String name){
		if(this.dynamicProperties != null){
			dynamicProperties.remove(name);
		}
	}
	public RecepcionProveedorControlRecipienteID getId() {
		return id;
	}
	public void setId(RecepcionProveedorControlRecipienteID id) {
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}
	public RecepcionProveedorDTO getRecepcionProveedorDTO() {
		return recepcionProveedorDTO;
	}
	public void setRecepcionProveedorDTO(RecepcionProveedorDTO recepcionProveedorDTO) {
		this.recepcionProveedorDTO = recepcionProveedorDTO;
	}
	public ControlRecipienteDTO getControlRecipienteDTO() {
		return controlRecipienteDTO;
	}
	public void setControlRecipienteDTO(ControlRecipienteDTO controlRecipienteDTO) {
		this.controlRecipienteDTO = controlRecipienteDTO;
	}

}
