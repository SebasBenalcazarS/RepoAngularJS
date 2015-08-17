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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ContenedorEstadoID;

/**
 * 
 * @author amunoz
 * @author cherrera
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCONEST")
public class ContenedorEstadoDTO extends SimpleAuditDTO{
	
	/**
	 * Clave primaria de la tabla Contenedor
	 * 
	 */
	@EmbeddedId
	private ContenedorEstadoID id = new ContenedorEstadoID();
	
	/**
	 * Corresponde al codigo del contenedor
	 *
	 */
	@Column(name="CODIGOCONTENEDOR")
	private Long codigoContenedor;
	
	/**
	 * Corresponde al codigo catalogo valor padre
	 *
	 */
	@Column(name="CODIGOCATALOGOVALORORIGEN")
	private String codigoCatalogoValorOrigen;
	
	/**
	 * Corresponde al codigo catalogo tipo padre
	 *
	 */
	@Column(name="CODIGOCATALOGOTIPOORIGEN")
	private Integer codigoCatalogoTipoOrigen;
	
	/**
	 * Corresponde al codigo catalogo valor relacionado
	 *
	 */
	@Column(name="CODIGOCATALOGOVALORACTUAL")
	private String codigoCatalogoValorActual;
	
	/**
	 * Corresponde al codigo catalogo tipo relacionado
	 *
	 */
	@Column(name="CODIGOCATALOGOTIPOACTUAL")
	private Integer codigoCatalogoTipoActual;
	
	/**
	 * Corresponde al estado
	 *
	 */
	@Column(name="ESTADO")
	private String estado;
	
	/**
	 * Corresponde a la fecha de inicio
	 *
	 */
	@Column(name="FECHAINICIO")
	private Date fechaInicio;
	
	/**
	 * Corresponde a la fecha de finalizacion
	 *
	 */
	@Column(name="FECHAFIN")
	private Date fechaFin;
	
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
	 * Referencia con la tabla Catalogo Valor Relacionado
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCATALOGOVALORORIGEN", referencedColumnName = "CODIGOCATALOGOVALORPADRE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOTIPOORIGEN", referencedColumnName = "CODIGOCATALOGOTIPOPADRE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOVALORACTUAL", referencedColumnName = "CODIGOCATALOGOVALORRELACIONADO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOTIPOACTUAL", referencedColumnName = "CODIGOCATALOGOTIPORELACIONADO", insertable = false, updatable = false)})
	private CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO;

//	/**
//	 * Referencia nula con la tabla de transferencias
//	 */
//	@Transient
//	private Collection<TransferenciaDTO> transferenciaDTOCol;
	
//	@Transient
//	private TransferenciaDTO transferenciaDTO;
	
	/**
	 * @return the id
	 */
	public ContenedorEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ContenedorEstadoID id) {
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
	 * @return the codigoCatalogoValorOrigen
	 */
	public String getCodigoCatalogoValorOrigen() {
		return codigoCatalogoValorOrigen;
	}

	/**
	 * @param codigoCatalogoValorOrigen the codigoCatalogoValorOrigen to set
	 */
	public void setCodigoCatalogoValorOrigen(String codigoCatalogoValorOrigen) {
		this.codigoCatalogoValorOrigen = codigoCatalogoValorOrigen;
	}

	/**
	 * @return the codigoCatalogoTipoOrigen
	 */
	public Integer getCodigoCatalogoTipoOrigen() {
		return codigoCatalogoTipoOrigen;
	}

	/**
	 * @param codigoCatalogoTipoOrigen the codigoCatalogoTipoOrigen to set
	 */
	public void setCodigoCatalogoTipoOrigen(Integer codigoCatalogoTipoOrigen) {
		this.codigoCatalogoTipoOrigen = codigoCatalogoTipoOrigen;
	}

	/**
	 * @return the codigoCatalogoValorActual
	 */
	public String getCodigoCatalogoValorActual() {
		return codigoCatalogoValorActual;
	}

	/**
	 * @param codigoCatalogoValorActual the codigoCatalogoValorActual to set
	 */
	public void setCodigoCatalogoValorActual(String codigoCatalogoValorActual) {
		this.codigoCatalogoValorActual = codigoCatalogoValorActual;
	}

	/**
	 * @return the codigoCatalogoTipoActual
	 */
	public Integer getCodigoCatalogoTipoActual() {
		return codigoCatalogoTipoActual;
	}

	/**
	 * @param codigoCatalogoTipoActual the codigoCatalogoTipoActual to set
	 */
	public void setCodigoCatalogoTipoActual(Integer codigoCatalogoTipoActual) {
		this.codigoCatalogoTipoActual = codigoCatalogoTipoActual;
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
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
	 * @return the catalogoValorRelacionadoDTO
	 */
	public CatalogoValorRelacionadoDTO getCatalogoValorRelacionadoDTO() {
		return catalogoValorRelacionadoDTO;
	}

	/**
	 * @param catalogoValorRelacionadoDTO the catalogoValorRelacionadoDTO to set
	 */
	public void setCatalogoValorRelacionadoDTO(CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO) {
		this.catalogoValorRelacionadoDTO = catalogoValorRelacionadoDTO;
	}
	
//	/**
//	 * @return the transferenciaDTOCol
//	 */
//	public Collection<TransferenciaDTO> getTransferenciaDTOCol() {
//		return transferenciaDTOCol;
//	}
//
//	/**
//	 * @param transferenciaDTOCol the transferenciaDTOCol to set
//	 */
//	public void setTransferenciaDTOCol(Collection<TransferenciaDTO> transferenciaDTOCol) {
//		this.transferenciaDTOCol = transferenciaDTOCol;
//	}
	
//	/**
//	 * @return the transferenciaDTO
//	 */
//	public TransferenciaDTO getTransferenciaDTO() {
//		return transferenciaDTO;
//	}
//
//	/**
//	 * @param transferenciaDTO the transferenciaDTO to set
//	 */
//	public void setTransferenciaDTO(TransferenciaDTO transferenciaDTO) {
//		this.transferenciaDTO = transferenciaDTO;
//	}
//	
}
