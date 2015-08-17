package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteDetalleID;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETCONRCI")
public class ControlRecipienteDetalleDTO implements Serializable {
	/**
	 * id (codigoCompania, codigoControlRecipienteDetalle)
	 */
	@EmbeddedId
	private ControlRecipienteDetalleID id = new ControlRecipienteDetalleID();
	/**
	 * Codigo padre
	 * 
	 */ 
	@Column(name = "CODIGOCONTROLRECIPIENTE", nullable = false)
	private Long codigoControlRecipiente;
	/**
	 * Cantidad recibida por recipiente
	 */
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	/**
	 * Ajuste que realiza el proveedor
	 */
	@Column(name = "CANTIDADAJUSTE")
	private Integer cantidadAjuste;
	
	/**
	 * Ajuste que realiza el proveedor
	 */
	@Column(name = "CANTIDADENTREGADA")
	private Integer cantidadEntregada;
	
	/**
	 * Concepto del ajuste
	 */
	@Column(name = "VALORTIPOAJUSTE")
	private String valorTipoAjuste;
	
	@Column(name = "CODIGOTIPOAJUSTE")
	private Integer codigoTipoAjuste;
	/**
	 * Operacion en mas o en menos
	 */
	@Column(name = "VALOROPERACIONCAUSAL")
	private String valorOperacionCausal;
	
	@Column(name = "CODIGOOPERACIONCAUSAL")
	private Integer codigoOperacionCausal;
	/**
	 * Relacion Codigo del recipiente
	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
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
	 * Referencia ControRecipienteDTO
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
				@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
				@JoinColumn(name = "CODIGOCONTROLRECIPIENTE", referencedColumnName = "CODIGOCONTROLRECIPIENTE", insertable = false, updatable = false)
	})
	private ControlRecipienteDTO controlRecipienteDTO;
	/**
	 * Referencia CatalogoValorDTO por concepto de ajuste
	 */
	@ManyToOne(fetch = LAZY)
    @JoinColumns({
    	@JoinColumn(name = "VALORTIPOAJUSTE", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOAJUSTE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO ajusteDTO;

	/**
	 * Referencia CatalogoValorDTO por concepto de operacion
	 */
	@ManyToOne(fetch = LAZY)
    @JoinColumns({
    	@JoinColumn(name = "VALOROPERACIONCAUSAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOOPERACIONCAUSAL", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO operacionDTO;
	/**
	 * Collection ordenSalidaControlRecipienteDetalleCol
	 */
	@OneToMany(mappedBy="controlRecipienteDetalleDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<OrdenSalidaControlRecipienteDetalleDTO> ordenSalidaControlRecipienteDetalleCol;
	
	/**
	 * Referencia con la tabla Articulo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloDTO articuloDTO;
	
	public ControlRecipienteDetalleID getId() {
		return id;
	}
	public void setId(ControlRecipienteDetalleID id) {
		this.id = id;
	}
	public Long getCodigoControlRecipiente() {
		return codigoControlRecipiente;
	}
	public void setCodigoControlRecipiente(Long codigoControlRecipiente) {
		this.codigoControlRecipiente = codigoControlRecipiente;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getCantidadAjuste() {
		return cantidadAjuste;
	}
	public void setCantidadAjuste(Integer cantidadAjuste) {
		this.cantidadAjuste = cantidadAjuste;
	}
	public String getValorTipoAjuste() {
		return valorTipoAjuste;
	}
	public void setValorTipoAjuste(String valorTipoAjuste) {
		this.valorTipoAjuste = valorTipoAjuste;
	}
	public Integer getCodigoTipoAjuste() {
		return codigoTipoAjuste;
	}
	public void setCodigoTipoAjuste(Integer codigoTipoAjuste) {
		this.codigoTipoAjuste = codigoTipoAjuste;
	}
	public String getValorOperacionCausal() {
		return valorOperacionCausal;
	}
	public void setValorOperacionCausal(String valorOperacionCausal) {
		this.valorOperacionCausal = valorOperacionCausal;
	}
	public Integer getCodigoOperacionCausal() {
		return codigoOperacionCausal;
	}
	public void setCodigoOperacionCausal(Integer codigoOperacionCausal) {
		this.codigoOperacionCausal = codigoOperacionCausal;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
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
	public ControlRecipienteDTO getControlRecipienteDTO() {
		return controlRecipienteDTO;
	}
	public void setControlRecipienteDTO(ControlRecipienteDTO controlRecipienteDTO) {
		this.controlRecipienteDTO = controlRecipienteDTO;
	}
	public CatalogoValorDTO getAjusteDTO() {
		return ajusteDTO;
	}
	public void setAjusteDTO(CatalogoValorDTO ajusteDTO) {
		this.ajusteDTO = ajusteDTO;
	}
	public CatalogoValorDTO getOperacionDTO() {
		return operacionDTO;
	}
	public void setOperacionDTO(CatalogoValorDTO operacionDTO) {
		this.operacionDTO = operacionDTO;
	}
	public Collection<OrdenSalidaControlRecipienteDetalleDTO> getOrdenSalidaControlRecipienteDetalleCol() {
		return ordenSalidaControlRecipienteDetalleCol;
	}
	public void setOrdenSalidaControlRecipienteDetalleCol(Collection<OrdenSalidaControlRecipienteDetalleDTO> ordenSalidaControlRecipienteDetalleCol) {
		this.ordenSalidaControlRecipienteDetalleCol = ordenSalidaControlRecipienteDetalleCol;
	}
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}
}
