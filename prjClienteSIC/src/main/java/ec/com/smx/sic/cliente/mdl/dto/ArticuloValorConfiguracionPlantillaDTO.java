package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;

/**
 * Entidad que almacena el resultado del control de rotulado un articulo para ciertos procesos
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTARTVALCONPLA")
public class ArticuloValorConfiguracionPlantillaDTO extends SimpleAuditDTO {

	/**
	 * id
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID();
	
	/**
	 * Id. del proveedor
	 * 
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor ;
	
	@Column(name = "NOVEDAD")
	private String novedadAuditoria;
	
	@Column(name = "CODIGOPADRE", nullable = false)
	private Integer codigoPadre;
	
	@Transient
	private String novedadRegistro;
	
	@Transient
	private Boolean mostrarRegistrosNo = Boolean.TRUE;
	
	@Transient
	private Boolean mostrarRegistrosNA= Boolean.TRUE;
	


	public Boolean getMostrarRegistrosNo() {
		return mostrarRegistrosNo;
	}

	public void setMostrarRegistrosNo(Boolean mostrarRegistrosNo) {
		this.mostrarRegistrosNo = mostrarRegistrosNo;
	}

	public Boolean getMostrarRegistrosNA() {
		return mostrarRegistrosNA;
	}

	public void setMostrarRegistrosNA(Boolean mostrarRegistrosNA) {
		this.mostrarRegistrosNA = mostrarRegistrosNA;
	}

	/**
	 * Id. del usuario de registro
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	//@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	//@RegisterUserIdField
	private String idUsuarioAuditoria;
	//@RegisterDateField
	private java.sql.Timestamp fechaAuditoria;
	
	@Column(name = "ESTADOARTVALCONPLA")
	private String estado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOVALORCONFIGURACIONPLANTILLA", referencedColumnName = "CODIGOVALORCONFIGURACIONPLANTILLA", insertable = false, updatable = false) })
	private ValorConfiguracionPlantillaDTO valorConfiguracionPlantilla;
	
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch=FetchType.LAZY)    
	private UserDto usuarioRegistro;
    
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private UserDto usuarioModificacion;
	
	@JoinColumn(name = "IDUSUARIOAUDITORIA", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private UserDto usuarioAuditoria;

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>
	 * .
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>
	 * .
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;
	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID id) {
		this.id = id;
	}

	/**
	 * @return the articulo
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo
	 *            the articulo to set
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the valorConfiguracionPlantilla
	 */
	public ValorConfiguracionPlantillaDTO getValorConfiguracionPlantilla() {
		return valorConfiguracionPlantilla;
	}

	/**
	 * @param valorConfiguracionPlantilla
	 *            the valorConfiguracionPlantilla to set
	 */
	public void setValorConfiguracionPlantilla(ValorConfiguracionPlantillaDTO valorConfiguracionPlantilla) {
		this.valorConfiguracionPlantilla = valorConfiguracionPlantilla;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor) {
		this.proveedor = proveedor;
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
	 * @return the usuarioRegistro
	 */
	public UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the novedadAuditoria
	 */
	public String getNovedadAuditoria() {
		return novedadAuditoria;
	}

	/**
	 * @param novedadAuditoria the novedadAuditoria to set
	 */
	public void setNovedadAuditoria(String novedadAuditoria) {
		this.novedadAuditoria = novedadAuditoria;
	}

	/**
	 * @return the novedadRegistro
	 */
	public String getNovedadRegistro() {
		return novedadRegistro;
	}

	/**
	 * @param novedadRegistro the novedadRegistro to set
	 */
	public void setNovedadRegistro(String novedadRegistro) {
		this.novedadRegistro = novedadRegistro;
	}

	/**
	 * @return the idUsuarioAuditoria
	 */
	public String getIdUsuarioAuditoria() {
		return idUsuarioAuditoria;
	}

	/**
	 * @param idUsuarioAuditoria the idUsuarioAuditoria to set
	 */
	public void setIdUsuarioAuditoria(String idUsuarioAuditoria) {
		this.idUsuarioAuditoria = idUsuarioAuditoria;
	}

	/**
	 * @return the fechaAuditoria
	 */
	public java.sql.Timestamp getFechaAuditoria() {
		return fechaAuditoria;
	}

	/**
	 * @param fechaAuditoria the fechaAuditoria to set
	 */
	public void setFechaAuditoria(java.sql.Timestamp fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	/**
	 * @return the usuarioAuditoria
	 */
	public UserDto getUsuarioAuditoria() {
		return usuarioAuditoria;
	}

	/**
	 * @param usuarioAuditoria the usuarioAuditoria to set
	 */
	public void setUsuarioAuditoria(UserDto usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}

	/**
	 * @return the codigoPadre
	 */
	public Integer getCodigoPadre() {
		return codigoPadre;
	}

	/**
	 * @param codigoPadre the codigoPadre to set
	 */
	public void setCodigoPadre(Integer codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

}
