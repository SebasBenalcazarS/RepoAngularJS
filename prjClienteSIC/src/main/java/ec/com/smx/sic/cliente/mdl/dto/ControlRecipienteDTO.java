package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCONRCI")
public class ControlRecipienteDTO implements Serializable {
	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private ControlRecipienteID id = new ControlRecipienteID();
	
	/**
	 * Relacion no obligatoria
	 */
	@Column(name = "CODIGOFACTURA", nullable = true)
	private Long codigoFactura;
	
	/**
	 * Numero de documento
	 */
	@Column(name = "NUMERODOCUMENTO")
	private String numeroDocumento;
	/**
	 * Especifica el codigo de la tarea padre
	 */
	@Column
	private Long codigoTarea;

	/*@Column(name = "CODIGODATOSTAREA", nullable = false)
	private java.lang.Long codigoDatosTarea;*/
	/**
	 * Estados 
	 */
	@Column(name = "VALORTIPOESTADO")
	private String valorTipoEstado;

	@Column(name = "CODIGOTIPOESTADO")
	private Integer codigoTipoEstado;

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
	 * Calculos de la pantalla
	 */
	@Transient
	private Integer totalRecibido;
	
	@Transient
	private Integer totalEntregado;
	
	@Transient
	private Integer totalAjuste;
	
	@Transient
	private Integer totalGeneral;

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
	 * Referencia CatalogoValorDTO ESTADOS
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOESTADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOESTADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO estadoDTO;
	/**
	 * Collection ordenSalidaControlRecipienteDetalleCol
	 */
	@OneToMany(mappedBy="controlRecipienteDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<ControlRecipienteDetalleDTO> controlRecipienteDetalleCol;
	
	/**
	 * Collection ordenSalidaControlRecipienteDetalleCol
	 */
	@OneToMany(mappedBy="controlRecipienteDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<RecepcionProveedorControlRecipienteDTO> recepcionProveedorControlRecipienteCol;
	
	
	/**
	 * Especifica la relacion con la tarea
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOTAREA", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO;

	
	/**
	 * Referencia con la tabla datos tarea
	 *
	 *//*
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaDTO;*/
	
	@Transient
	private Map<String,Object> dynamicProperties;

	public ControlRecipienteID getId() {
		return id;
	}
	public void setId(ControlRecipienteID id) {
		this.id = id;
	}
	
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}
	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}
	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
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
		
	public CatalogoValorDTO getEstadoDTO() {
		return estadoDTO;
	}
	public void setEstadoDTO(CatalogoValorDTO estadoDTO) {
		this.estadoDTO = estadoDTO;
	}
	public Collection<ControlRecipienteDetalleDTO> getControlRecipienteDetalleCol() {
		return controlRecipienteDetalleCol;
	}
	public void setControlRecipienteDetalleCol(Collection<ControlRecipienteDetalleDTO> controlRecipienteDetalleCol) {
		this.controlRecipienteDetalleCol = controlRecipienteDetalleCol;
	}
	public Integer getTotalRecibido() {
		return totalRecibido;
	}
	public void setTotalRecibido(Integer totalRecibido) {
		this.totalRecibido = totalRecibido;
	}
	public Integer getTotalEntregado() {
		return totalEntregado;
	}
	public void setTotalEntregado(Integer totalEntregado) {
		this.totalEntregado = totalEntregado;
	}
	public Integer getTotalAjuste() {
		return totalAjuste;
	}
	public void setTotalAjuste(Integer totalAjuste) {
		this.totalAjuste = totalAjuste;
	}
	public Integer getTotalGeneral() {
		return totalGeneral;
	}
	public void setTotalGeneral(Integer totalGeneral) {
		this.totalGeneral = totalGeneral;
	}
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
	public Collection<RecepcionProveedorControlRecipienteDTO> getRecepcionProveedorControlRecipienteCol() {
		return recepcionProveedorControlRecipienteCol;
	}
	public void setRecepcionProveedorControlRecipienteCol(Collection<RecepcionProveedorControlRecipienteDTO> recepcionProveedorControlRecipienteCol) {
		this.recepcionProveedorControlRecipienteCol = recepcionProveedorControlRecipienteCol;
	}
	public Long getCodigoTarea() {
		return codigoTarea;
	}
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}
	public ec.com.smx.sic.cliente.mdl.dto.TareaDTO getTareaDTO() {
		return tareaDTO;
	}
	public void setTareaDTO(ec.com.smx.sic.cliente.mdl.dto.TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
	}
	/*public java.lang.Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}*/
	
}
