package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.RecipienteTaraID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTRCITAR")
public class RecipienteTaraDTO implements Serializable {
	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private RecipienteTaraID id = new RecipienteTaraID();
	/**
	 * Relacion Articulo
	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	/**
	 * Descripcion
	 */
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	/**
	 * VALOR TARA
	 */
	
	@Column(name = "VALORTARA")
	private BigDecimal valorTara;
	
	/**
	 * Estado
	 */
	@Column(name = "ESTADO")
	private String estado;
	
	/**
	 * Estado
	 */
	@Column(name = "TIPO")
	private String tipo;
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
	 * Referencia con la tabla Articulo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloDTO articuloDTO;
	
	/**
	 * Collection ordenSalidaControlRecipienteDetalleCol
	 */
	@OneToMany(mappedBy="recipienteTaraDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetalleCol;

	public RecipienteTaraID getId() {
		return id;
	}

	public void setId(RecipienteTaraID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValorTara() {
		return valorTara;
	}

	public void setValorTara(BigDecimal valorTara) {
		this.valorTara = valorTara;
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

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public Collection<ControlRecipienteTaraDetalleDTO> getControlRecipienteTaraDetalleCol() {
		return controlRecipienteTaraDetalleCol;
	}

	public void setControlRecipienteTaraDetalleCol(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetalleCol) {
		this.controlRecipienteTaraDetalleCol = controlRecipienteTaraDetalleCol;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
