package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.RutaID;

/**
 * 
 * @author amunoz
 * @author cherrera
 * @author hgudino
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTRUTA")

public class RutaDTO implements Serializable{
	
	
	/**
	 * Clave primaria de la tabla Ruta
	 * 
	 */
	@EmbeddedId
	private RutaID id = new RutaID();
	
	/**
	 * Valor del tipo de destino para guias
	 *
	 */
	@Column(name="CODIGOAREATRABAJOINICIAL")
	private java.lang.Integer codigoAreaTrabajoInicial ;
	
	/**
	 * Valor del tipo de destino para guias
	 *
	 */
	@Column(name="CODIGOLOCALIZACIONINICIAL")
	private java.lang.Long codigoLocalizacionInicial ;
	
	/**
	 * Valor del tipo de destino para guias
	 *
	 */
	@Column(name="VALORTIPOESTADO")
	private java.lang.String valorTipoEstado ;

	/**
	 * C�digo del tipo de destino para guias
	 *
	 */
	@Column(name="CODIGOTIPOESTADO")
	private java.lang.Integer codigoTipoEstado;
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;
	
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
	 * Relacion con la tabla catalogo valor para el estado de la ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOAREATRABAJOINICIAL", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private AreaTrabajoDTO areaTrabajoDTO;
	
	/**
	 * Relacion con la tabla catalogo valor para el estado de la ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOLOCALIZACIONINICIAL", insertable=false, updatable=false, referencedColumnName="CODIGOLOCALIZACION")})
	private LocalizacionDTO localizacionDTO;
	
	/**
	 * Relacion con la tabla catalogo valor para el estado de la ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOESTADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoEstadoDTO;
	
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
	
	
	/**
	 * Relacion con la tabla ruta detalle
	 */
	@OneToMany(mappedBy = "rutaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RutaDetalleDTO> rutaDetalleDTOCols;
	
	/**
	 * Relacion con la tabla destinos
	 */
	@OneToMany(mappedBy = "rutaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DestinoDTO> destinoDTOCols;
	
	/**
	 * Referencia a la tabla Contenedor
	 * 
	 */
//	@OneToMany(mappedBy = "rutaDTO")
//	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	@Transient
	private Collection<ContenedorDTO> contenedorDTOCol;
	
	
	public RutaDTO() {		
	}

	/**
	 * @return the id
	 */
	public RutaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RutaID id) {
		this.id = id;
	}
	
	/**
	 * @return the valorTipoEstado
	 */
	public java.lang.String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(java.lang.String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public java.lang.Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(java.lang.Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
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
	 * @return the tipoEstadoDTO
	 */
	public CatalogoValorDTO getTipoEstadoDTO() {
		return tipoEstadoDTO;
	}

	/**
	 * @param tipoEstadoDTO the tipoEstadoDTO to set
	 */
	public void setTipoEstadoDTO(CatalogoValorDTO tipoEstadoDTO) {
		this.tipoEstadoDTO = tipoEstadoDTO;
	}

	/**
	 * @return the contenedorDTOCol
	 */
	public Collection<ContenedorDTO> getContenedorDTOCol() {
		return contenedorDTOCol;
	}

	/**
	 * @param contenedorDTOCol the contenedorDTOCol to set
	 */
	public void setContenedorDTOCol(Collection<ContenedorDTO> contenedorDTOCol) {
		this.contenedorDTOCol = contenedorDTOCol;
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
	 * @return the codigoAreaTrabajoInicial
	 */
	public java.lang.Integer getCodigoAreaTrabajoInicial() {
		return codigoAreaTrabajoInicial;
	}

	/**
	 * @param codigoAreaTrabajoInicial the codigoAreaTrabajoInicial to set
	 */
	public void setCodigoAreaTrabajoInicial(java.lang.Integer codigoAreaTrabajoInicial) {
		this.codigoAreaTrabajoInicial = codigoAreaTrabajoInicial;
	}

	/**
	 * @return the codigoLocalizacionInicial
	 */
	public java.lang.Long getCodigoLocalizacionInicial() {
		return codigoLocalizacionInicial;
	}

	/**
	 * @param codigoLocalizacionInicial the codigoLocalizacionInicial to set
	 */
	public void setCodigoLocalizacionInicial(java.lang.Long codigoLocalizacionInicial) {
		this.codigoLocalizacionInicial = codigoLocalizacionInicial;
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
	 * @return the rutaDetalleDTOCols
	 */
	public Collection<RutaDetalleDTO> getRutaDetalleDTOCols() {
		return rutaDetalleDTOCols;
	}

	/**
	 * @param rutaDetalleDTOCols the rutaDetalleDTOCols to set
	 */
	public void setRutaDetalleDTOCols(Collection<RutaDetalleDTO> rutaDetalleDTOCols) {
		this.rutaDetalleDTOCols = rutaDetalleDTOCols;
	}

	/**
	 * @return the destinoDTOCols
	 */
	public Collection<DestinoDTO> getDestinoDTOCols() {
		return destinoDTOCols;
	}

	/**
	 * @param destinoDTOCols the destinoDTOCols to set
	 */
	public void setDestinoDTOCols(Collection<DestinoDTO> destinoDTOCols) {
		this.destinoDTOCols = destinoDTOCols;
	}	
}
