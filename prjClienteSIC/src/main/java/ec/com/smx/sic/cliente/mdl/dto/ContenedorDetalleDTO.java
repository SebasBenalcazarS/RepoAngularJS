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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ContenedorDetalleID;

/**
 * 
 * @author amunoz
 *@author cherrera
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCONDET")
public class ContenedorDetalleDTO extends SimpleAuditDTO{
	
	/**
	 * Clave primaria de la tabla Contenedor Detalle
	 * 
	 */
	@EmbeddedId
	private ContenedorDetalleID id = new ContenedorDetalleID();
	
	/**
	 * Codigo del contenedor
	 *
	 */
	@Column(name="CODIGOCONTENEDOR")
	private Long codigoContenedor;
	
	/**
	 * Codigo de la unidad de manejo
	 *
	 */
	@Column(name="CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	/**
	 * Codigo del articulo
	 *
	 */
	@Column(name="CODIGOARTICULO")
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * Corresponde a la cantidad
	 *
	 */
	@Column(name="CANTIDAD")
	private Integer cantidad;

	/**
	 * Corresponde al estado 
	 *
	 */
	@Column(name="ESTADO")
	private String estado;
	
	/**
	 * Corresponde al codigo valor causal
	 *
	 */
	@Column(name="CODIGOCAUSALVALOR")
	private String codigoCausalValor;
	
	/**
	 * Corresponde al codigo tipo causal
	 *
	 */
	@Column(name="CODIGOCAUSALTIPO")
	private Integer codigoCausalTipo;
	
	/**
	 * Corresponde al motivo detallado
	 *
	 */
	@Column(name="MOTIVODETALLADO")
	private String motivoDetallado;
	
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
	 * Id del usuario que realiza la ultima actualizacion.
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
	 * Referencia con la tabla Contenedor
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONTENEDOR", referencedColumnName = "CODIGOCONTENEDOR", insertable = false, updatable = false) })
	private ContenedorDTO contenedorDTO;
	
	/**
	 * Referencia con la tabla Articulo Unidad Manejo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false)})
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
	
	/**
	 * Referencia con la tabla Articulo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloDTO articuloDTO;

	/**
	 * Referencia con la tabla transaccion causal
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCAUSALVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCAUSALTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoValorDTO;
	
	/**
	 * @return the id
	 */
	public ContenedorDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ContenedorDetalleID id) {
		this.id = id;
	}

	/**
	 * @return the codigoContenedor
	 */
	public Long getCodigoContenedor() {
		return codigoContenedor;
	}

	/**
	 * @param codigoContenedor the codigoContenedor to set
	 */
	public void setCodigoContenedor(Long codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
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
	 * @return the motivoDetallado
	 */
	public String getMotivoDetallado() {
		return motivoDetallado;
	}

	/**
	 * @param motivoDetallado the motivoDetallado to set
	 */
	public void setMotivoDetallado(String motivoDetallado) {
		this.motivoDetallado = motivoDetallado;
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
	 * @return the contenedorDTO
	 */
	public ContenedorDTO getContenedorDTO() {
		return contenedorDTO;
	}

	/**
	 * @param contenedorDTO the contenedorDTO to set
	 */
	public void setContenedorDTO(ContenedorDTO contenedorDTO) {
		this.contenedorDTO = contenedorDTO;
	}

	/**
	 * @return the articuloUnidadManejoDTO
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	/**
	 * @param articuloUnidadManejoDTO the articuloUnidadManejoDTO to set
	 */
	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
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
	 * @return the codigoCausalValor
	 */
	public String getCodigoCausalValor() {
		return codigoCausalValor;
	}

	/**
	 * @param codigoCausalValor the codigoCausalValor to set
	 */
	public void setCodigoCausalValor(String codigoCausalValor) {
		this.codigoCausalValor = codigoCausalValor;
	}

	/**
	 * @return the codigoCausalTipo
	 */
	public Integer getCodigoCausalTipo() {
		return codigoCausalTipo;
	}

	/**
	 * @param codigoCausalTipo the codigoCausalTipo to set
	 */
	public void setCodigoCausalTipo(Integer codigoCausalTipo) {
		this.codigoCausalTipo = codigoCausalTipo;
	}

	/**
	 * @return the catalogoValorDTO
	 */
	public CatalogoValorDTO getCatalogoValorDTO() {
		return catalogoValorDTO;
	}

	/**
	 * @param catalogoValorDTO the catalogoValorDTO to set
	 */
	public void setCatalogoValorDTO(CatalogoValorDTO catalogoValorDTO) {
		this.catalogoValorDTO = catalogoValorDTO;
	}
	
}
