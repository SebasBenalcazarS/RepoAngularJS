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
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Almacena informacion calendario del proveedor
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTCALENDARIO")
public class CalendarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CalendarioProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.CalendarioID id = new ec.com.smx.sic.cliente.mdl.dto.id.CalendarioID();

	/**
	 * Código del proveedor
	 *

	 */
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor ;

	/**
	 * codigo del dia de la semana.
	 * 
	 */
	@Column
	private Integer diaSemana;
	
	/**
	 * codigo del mes.
	 * 
	 */
	@Column
	private Integer diaMes;
	
	/**
	 * codigo del dia de la semana.
	 * 
	 */
	@Column
	private Integer mes;
	
	/**
	 * codigo del dia de la semana.
	 * 
	 */
	@Column
	private Integer anio;

	/**
	 * Representa el estado.
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;
	
	/**
	 *Este campo debe estar nulo siempre que sea una planificación así sea que la planificación sea para una fecha específica la fecha del calendario debe estar nula y la fecha en que
	 *se planifique deberá estar distribuida en diaMes, mes, anio.  
	 */
	@Column
	private java.util.Date fechaCalendario;

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
	 * Referencia a la tabla CalendarioBodegaProveedor
	 * 
	 */
	@OneToMany(mappedBy = "calendarioDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<HoraCalendarioDTO> horaCalendarioDTOCol;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioActualizacion;
	
	/**
	 * Referencia con la tabla Proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ProveedorDTO proveedorDTO;
	
	/**
	 * Referencia con la vista Proveedor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor;

	public ec.com.smx.sic.cliente.mdl.dto.id.CalendarioID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.CalendarioID id) {
		this.id = id;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getDiaMes() {
		return diaMes;
	}

	public void setDiaMes(Integer diaMes) {
		this.diaMes = diaMes;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getEstado() {
		return estado;
	}

	public java.util.Date getFechaCalendario() {
		return fechaCalendario;
	}

	public void setFechaCalendario(java.util.Date fechaCalendario) {
		this.fechaCalendario = fechaCalendario;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Collection<HoraCalendarioDTO> getHoraCalendarioDTOCol() {
		return horaCalendarioDTOCol;
	}

	public void setHoraCalendarioDTOCol(Collection<HoraCalendarioDTO> horaCalendarioDTOCol) {
		this.horaCalendarioDTOCol = horaCalendarioDTOCol;
	}

	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public ec.com.smx.framework.security.dto.UserDto getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(ec.com.smx.framework.security.dto.UserDto usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	public ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	public void setVistaProveedor(ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

}