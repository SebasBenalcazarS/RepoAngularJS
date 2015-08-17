package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ContenedorID;

/**
 * 
 * @author amunoz
 * @author cherrera
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCONTENEDOR")
public class ContenedorDTO extends SimpleAuditDTO{
	
	/**
	 * Clave primaria de la tabla Contenedor
	 * 
	 */
	@EmbeddedId
	private ContenedorID id = new ContenedorID();
	
	/**
	 * Codigo del proceso logistico
	 *
	 */
	@Column(name="CODIGOPROCESOLOGISTICO")
	private Long codigoProcesoLogistico;
	
	/**
	 * Codigo del articulo
	 *
	 */
	@Column(name="CODIGOARTICULO")
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * Codigo de detalle seccion
	 *
	 */
	@Column(name="CODIGODETALLESECCION")
	private Long codigoDetalleSeccion;
	
	/**
	 * Codigo de la clasificacion
	 *
	 */
	@Column(name="CODIGOCLASIFICACION")
	private String codigoClasificacion;
	
	/**
	 * Codigo de la ruta
	 *
	 */
//	@Column(name="CODIGORUTA")
	@Transient
	private String codigoRuta;
	
	/**
	 * Numero del contenedor
	 *
	 */
	@Column(name="NUMEROCONTENEDOR")
	private String numeroContenedor;
	
	/**
	 * Estado del contenedor
	 *
	 */
	@Column(name="ESTADO")
	private String estado;
	
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
	 * Descripcion del contenedor
	 */
	@Column(name="OBSERVACION")
	private String observacion;
	
	@Transient
	private ContenedorRelacionadoDTO contenedorRelacionadoDTO;
	
	@Transient
	private ContenedorRelacionadoDTO contenedorPadreDTO;
	
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
	 * Referencia con la tabla Detalle Seccion
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Referencia con la tabla Detalle Seccion
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESOLOGISTICO", referencedColumnName = "CODIGOPROCESOLOGISTICO", insertable = false, updatable = false) })
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
//	/**
//	 * Referencia con la tabla Ruta
//	 * 
//	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
//		@JoinColumn(name = "CODIGORUTA", referencedColumnName = "CODIGORUTA", insertable = false, updatable = false) })
	@Transient
	private RutaDTO rutaDTO;
	
	/**
	 * Referencia con la tabla Articulo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloDTO articuloDTO;
	
	/**
	 * Referencia con la tabla Clasificacion
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDTO;
	
	/**
	 * Referencia a la tabla Contenedor Detalle
	 * 
	 */
	@OneToMany(mappedBy = "contenedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol;
	
	/**
	 * Referencia a la tabla Contenedor Relacionado
	 * 
	 */
	@OneToMany(mappedBy = "contenedorRelacionadoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorRelacionadoDTO> contenedorRelacionadoDTOCol;
	
	/**
	 * Referencia a la tabla Contenedor Padre
	 * 
	 */
	@OneToMany(mappedBy = "contenedorPadreDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorRelacionadoDTO> contenedorPadreDTOCol;
	
	/**
	 * Referencia a la tabla Contenedor Estado
	 * 
	 */
	@OneToMany(mappedBy = "contenedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorEstadoDTO> contenedorEstadoDTOCol;

	/**
	 * @return the contenedorPadreDTOCol
	 */
	public Collection<ContenedorRelacionadoDTO> getContenedorPadreDTOCol() {
		return contenedorPadreDTOCol;
	}

	/**
	 * @param contenedorPadreDTOCol the contenedorPadreDTOCol to set
	 */
	public void setContenedorPadreDTOCol(Collection<ContenedorRelacionadoDTO> contenedorPadreDTOCol) {
		this.contenedorPadreDTOCol = contenedorPadreDTOCol;
	}

	/**
	 * @return the id
	 */
	public ContenedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ContenedorID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the codigoRuta
	 */
	public String getCodigoRuta() {
		return codigoRuta;
	}

	/**
	 * @param codigoRuta the codigoRuta to set
	 */
	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}

	/**
	 * @return the numeroContenedor
	 */
	public String getNumeroContenedor() {
		return numeroContenedor;
	}

	/**
	 * @param numeroContenedor the numeroContenedor to set
	 */
	public void setNumeroContenedor(String numeroContenedor) {
		this.numeroContenedor = numeroContenedor;
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
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
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
	 * @return the rutaDTO
	 */
	public RutaDTO getRutaDTO() {
		return rutaDTO;
	}

	/**
	 * @param rutaDTO the rutaDTO to set
	 */
	public void setRutaDTO(RutaDTO rutaDTO) {
		this.rutaDTO = rutaDTO;
	}

	/**
	 * @return the articuloDTO
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	/**
	 * @param articuloDTO the articuloDTO to set
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	/**
	 * @return the clasificacionDTO
	 */
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	/**
	 * @param clasificacionDTO the clasificacionDTO to set
	 */
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}
	
	/**
	 * @return the contenedorDetalleDTOCol
	 */
	public Collection<ContenedorDetalleDTO> getContenedorDetalleDTOCol() {
		return contenedorDetalleDTOCol;
	}

	/**
	 * @param contenedorDetalleDTOCol the contenedorDetalleDTOCol to set
	 */
	public void setContenedorDetalleDTOCol(Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol) {
		this.contenedorDetalleDTOCol = contenedorDetalleDTOCol;
	}
	
	/**
	 * @return the contenedorRelacionadoDTOCol
	 */
	public Collection<ContenedorRelacionadoDTO> getContenedorRelacionadoDTOCol() {
		return contenedorRelacionadoDTOCol;
	}

	/**
	 * @param contenedorRelacionadoDTOCol the contenedorRelacionadoDTOCol to set
	 */
	public void setContenedorRelacionadoDTOCol(Collection<ContenedorRelacionadoDTO> contenedorRelacionadoDTOCol) {
		this.contenedorRelacionadoDTOCol = contenedorRelacionadoDTOCol;
	}
	
	/**
	 * @return the contenedorEstadoDTOCol
	 */
	public Collection<ContenedorEstadoDTO> getContenedorEstadoDTOCol() {
		return contenedorEstadoDTOCol;
	}

	/**
	 * @param contenedorEstadoDTOCol the contenedorEstadoDTOCol to set
	 */
	public void setContenedorEstadoDTOCol(Collection<ContenedorEstadoDTO> contenedorEstadoDTOCol) {
		this.contenedorEstadoDTOCol = contenedorEstadoDTOCol;
	}
	
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	/**
	 * @return contenedorRelacionadoDTO
	 */
	public ContenedorRelacionadoDTO getContenedorRelacionadoDTO(){
		if(this.contenedorRelacionadoDTO == null && SearchDTO.isLoaded(this.contenedorRelacionadoDTOCol) &&
				CollectionUtils.isNotEmpty(this.contenedorRelacionadoDTOCol)){
			this.contenedorRelacionadoDTO = this.contenedorRelacionadoDTOCol.iterator().next();
		}
		return this.contenedorRelacionadoDTO;
	}
	
	/**
	 * @param contenedorRelacionadoDTO the contenedorRelacionadoDTO to set
	 */
	public void setContenedorRelacionadoDTO(ContenedorRelacionadoDTO contenedorRelacionadoDTO) {
		this.contenedorRelacionadoDTO = contenedorRelacionadoDTO;
	}
	
	/**
	 * @return the contenedorPadreDTO
	 */
	public ContenedorRelacionadoDTO getContenedorPadreDTO() {
		if(this.contenedorPadreDTO == null && SearchDTO.isLoaded(this.contenedorPadreDTOCol) &&
				CollectionUtils.isNotEmpty(this.contenedorPadreDTOCol)){
			this.contenedorPadreDTO = this.contenedorPadreDTOCol.iterator().next();
		}
		return contenedorPadreDTO;
	}

	/**
	 * @param contenedorPadreDTO the contenedorPadreDTO to set
	 */
	public void setContenedorPadreDTO(ContenedorRelacionadoDTO contenedorPadreDTO) {
		this.contenedorPadreDTO = contenedorPadreDTO;
	}
	
	/**
	 * @return contenedor estado 
	 */
	public ContenedorEstadoDTO getContenedorEstadoDTO(){
		if(contenedorEstadoDTOCol != null && SearchDTO.isLoaded(contenedorEstadoDTOCol) && !this.contenedorEstadoDTOCol.isEmpty()){
			return this.contenedorEstadoDTOCol.iterator().next();
		}
		return null;
	}
	
	/**
	 * @return contenedor detalle 
	 */
	public ContenedorDetalleDTO getContenedorDetalleDTO(){
		if(contenedorDetalleDTOCol != null && SearchDTO.isLoaded(contenedorDetalleDTOCol) && !this.contenedorDetalleDTOCol.isEmpty()){
			return this.contenedorDetalleDTOCol.iterator().next();
		}
		return null;
	}
}
