package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.PerfilDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTNOVARTJUS")
public class NovedadArticuloJustificacionDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla NovedadArticuloDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.NovedadArticuloJustificacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.NovedadArticuloJustificacionID();
		
	/**
	 * Codigo de novedad articulo
	 * 
	 */
	@Column(name = "CODIGONOVEDADARTICULO")
	private Long codigoNovedadArticulo;
	
	/**
	 * Codigo de referencia hacia la tabla de justificaciones
	 * 
	 */
	@Column(name = "CODIGOJUSTIFICACION")
	private Long codigoJustificacion;
	
	/**
	 * Referencia hacia el funcionario que realiza la novedad
	 * 
	 */
	@Column(name = "CODIGOFUNCIONARIO")
	private String codigoFuncionario ;
	
	/**
	 * Referencia hacia el perfil del funcionario que realiza la novedad
	 * 
	 */
	@Column(name = "CODIGOPERFIL")
	private String codigoPerfil ;
	
	
	/**
	 * Cantidad que no se pudo recibir
	 */
	@Column(name = "CANTIDAD") 
	private Integer cantidad;
	
	/**
	 * Referencia del peso que no se recibio
	 * 
	 */
	@Column(name = "PESO")
	private Long peso;
				
	@Column
	@ComparatorTypeField
	private java.lang.String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;
	
	/**
	 * Codigo del area de trabajo de donde se registra la novedad
	 */
	@Transient
	private Integer codigoAreaTrabajo ;
	
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;
	
	/**
	 * Referencia con la tabla recepcion novedad novedad articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGONOVEDADARTICULO", referencedColumnName = "CODIGONOVEDADARTICULO", insertable = false, updatable = false) })
	private NovedadArticuloDTO novedadArticuloDTO;
	
	/**
	 * Referencia con la tabla justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOJUSTIFICACION", referencedColumnName = "CODIGOJUSTIFICACION", insertable = false, updatable = false) })
	private JustificacionDTO justificacionDTO;
	
	
	/**
	 * Referencia con la tabla funcionario
	 * 
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
        })
	private FuncionarioDTO funcionarioDTO;
	
	/**
	 * Referencia con la tabla perfil
	 * 
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "PROFILEID", insertable = false, updatable = false)
        })
	private PerfilDTO perfilDTO;
	
	@Transient
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
        })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	@Transient
	@OneToMany(mappedBy="novedadArticuloJustificacionDTO")
	@CollectionTypeInfo(name=SICConstantes.USERTYPE_COLLECTION)
	private Collection<NovedadArticuloJustificacionUnidadManejoDTO> novedadArticuloJustificacionUnidadManejoDTOCol;
	
	@Transient
	@OneToMany(mappedBy="novedadArticuloJustificacionDTO")
	@CollectionTypeInfo(name=SICConstantes.USERTYPE_COLLECTION)
	private Collection<NovedadArticuloJustificacionProveedorDTO> novedadArticuloJustificacionProveedorDTOCol;
	
	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion() {
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
	public void setFechaModificacion(java.util.Date fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

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

		if (idUsuarioModificacion != null
				&& idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * 
	 * @param usuarioCreacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion(
			ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1) {
		this.usuarioCreacion = usuarioCreacion1;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;
	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.NovedadArticuloJustificacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.NovedadArticuloJustificacionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoNovedadArticulo
	 */
	public Long getCodigoNovedadArticulo() {
		return codigoNovedadArticulo;
	}

	/**
	 * @param codigoNovedadArticulo the codigoNovedadArticulo to set
	 */
	public void setCodigoNovedadArticulo(Long codigoNovedadArticulo) {
		this.codigoNovedadArticulo = codigoNovedadArticulo;
	}

	/**
	 * @return the codigoJustificacion
	 */
	public Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the peso
	 */
	public Long getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Long peso) {
		this.peso = peso;
	}

	/**
	 * @return the recepcionNovedadArticuloDTO
	 */
	public NovedadArticuloDTO getNovedadArticuloDTO() {
		return novedadArticuloDTO;
	}

	/**
	 * @param recepcionNovedadArticuloDTO the recepcionNovedadArticuloDTO to set
	 */
	public void setNovedadArticuloDTO(NovedadArticuloDTO novedadArticuloDTO) {
		this.novedadArticuloDTO = novedadArticuloDTO;
	}

	/**
	 * @return the justificacionDTO
	 */
	public JustificacionDTO getJustificacionDTO() {
		return justificacionDTO;
	}

	/**
	 * @param justificacionDTO the justificacionDTO to set
	 */
	public void setJustificacionDTO(JustificacionDTO justificacionDTO) {
		this.justificacionDTO = justificacionDTO;
	}

	/**
	 * @return the funcionarioDTO
	 */
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}

	/**
	 * @param funcionarioDTO the funcionarioDTO to set
	 */
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}

	/**
	 * @return the perfilDTO
	 */
	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
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
	 * @return the novedadArticuloJustificacionUnidadManejoDTOCol
	 */
	public Collection<NovedadArticuloJustificacionUnidadManejoDTO> getNovedadArticuloJustificacionUnidadManejoDTOCol() {
		return novedadArticuloJustificacionUnidadManejoDTOCol;
	}

	/**
	 * @param novedadArticuloJustificacionUnidadManejoDTOCol the novedadArticuloJustificacionUnidadManejoDTOCol to set
	 */
	public void setNovedadArticuloJustificacionUnidadManejoDTOCol(Collection<NovedadArticuloJustificacionUnidadManejoDTO> novedadArticuloJustificacionUnidadManejoDTOCol) {
		this.novedadArticuloJustificacionUnidadManejoDTOCol = novedadArticuloJustificacionUnidadManejoDTOCol;
	}

	/**
	 * @return the novedadArticuloJustificacionProveedorDTOCol
	 */
	public Collection<NovedadArticuloJustificacionProveedorDTO> getNovedadArticuloJustificacionProveedorDTOCol() {
		return novedadArticuloJustificacionProveedorDTOCol;
	}

	/**
	 * @param novedadArticuloJustificacionProveedorDTOCol the novedadArticuloJustificacionProveedorDTOCol to set
	 */
	public void setNovedadArticuloJustificacionProveedorDTOCol(Collection<NovedadArticuloJustificacionProveedorDTO> novedadArticuloJustificacionProveedorDTOCol) {
		this.novedadArticuloJustificacionProveedorDTOCol = novedadArticuloJustificacionProveedorDTOCol;
	}	
	
	
}
