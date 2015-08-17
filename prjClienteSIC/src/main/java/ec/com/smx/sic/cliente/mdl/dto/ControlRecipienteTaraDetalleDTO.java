package ec.com.smx.sic.cliente.mdl.dto;

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

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteTaraDetalleID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETCONRCITAR")
public class ControlRecipienteTaraDetalleDTO implements Serializable {

	/**
	 * Clave primaria
	 */
	@EmbeddedId
	private ControlRecipienteTaraDetalleID id = new ControlRecipienteTaraDetalleID();
	/**
	 * Codigos padre
	 * 
	 */
	@Column(name = "SECUECIALRECIPIENTETARA", nullable = true)
	private Long secuencialRecipienteTara;
	
//	@Column(name = "CODIGODATOSTAREA", nullable = false	)
//	private Long codigoDatosTarea;
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
	 * Cantidad
	 */
	
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
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
	 * Referencia recipienteTaraDTO
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "SECUECIALRECIPIENTETARA", referencedColumnName = "SECUECIALRECIPIENTETARA", insertable = false, updatable = false) })
	private RecipienteTaraDTO recipienteTaraDTO;
	/**
	 * Referencia con la tabla Articulo
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloDTO articuloDTO;
	
	@OneToMany(mappedBy = "controlRecipienteTaraDetalleDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaDetalleRecipienteDTO> datosTareaDetalleRecipienteCol;
//	/**
//	 * Referencia datosTareaDTO
//	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false) })
//	private DatosTareaDTO datosTareaDTO;
	public ControlRecipienteTaraDetalleID getId() {
		return id;
	}
	public void setId(ControlRecipienteTaraDetalleID id) {
		this.id = id;
	}
	public Long getSecuencialRecipienteTara() {
		return secuencialRecipienteTara;
	}
	public void setSecuencialRecipienteTara(Long secuencialRecipienteTara) {
		this.secuencialRecipienteTara = secuencialRecipienteTara;
	}
//	public Long getCodigoDatosTarea() {
//		return codigoDatosTarea;
//	}
//	public void setCodigoDatosTarea(Long codigoDatosTarea) {
//		this.codigoDatosTarea = codigoDatosTarea;
//	}
	
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
	public RecipienteTaraDTO getRecipienteTaraDTO() {
		return recipienteTaraDTO;
	}
	public void setRecipienteTaraDTO(RecipienteTaraDTO recipienteTaraDTO) {
		this.recipienteTaraDTO = recipienteTaraDTO;
	}
//	public DatosTareaDTO getDatosTareaDTO() {
//		return datosTareaDTO;
//	}
//	public void setDatosTareaDTO(DatosTareaDTO datosTareaDTO) {
//		this.datosTareaDTO = datosTareaDTO;
//	}
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the datosTareaDetalleRecipienteCol
	 */
	public Collection<DatosTareaDetalleRecipienteDTO> getDatosTareaDetalleRecipienteCol() {
		return datosTareaDetalleRecipienteCol;
	}
	/**
	 * @param datosTareaDetalleRecipienteCol the datosTareaDetalleRecipienteCol to set
	 */
	public void setDatosTareaDetalleRecipienteCol(Collection<DatosTareaDetalleRecipienteDTO> datosTareaDetalleRecipienteCol) {
		this.datosTareaDetalleRecipienteCol = datosTareaDetalleRecipienteCol;
	}
	
	
}
