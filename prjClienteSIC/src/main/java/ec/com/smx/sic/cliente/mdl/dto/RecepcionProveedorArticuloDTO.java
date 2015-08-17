package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.sql.Types;
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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Permite configurar los articulos de la recepcion de un proveedor con un
 * resumen a nivel de articulo unidad manejo
 * 
 * @author acaiza
 * @author guvidia
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTRECPROART")
public class RecepcionProveedorArticuloDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla RecepcionProveedorArticulo
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorArticuloID id = new ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorArticuloID();

	/**
	 * Campo para optimizar los procesos de actualizacion de registros
	 */
	@Column(name = "SECUENCIALRECEPCIONPROVEEDORARTICULO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECRECPROARTSEC", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Long secuencialRecepcionProveedorArticulo;

	/**
	 * Codigo de la recepcion del proveedor
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR")
	private Long codigoRecepcionProveedor;

	/**
	 * Codigo de articulo de la unidad de manejo
	 */
	@ComparatorTypeField
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Codigo de la unidad de manejo del articulo
	 */
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;

	/**
	 * Se ingrega el catalogo valor RIE, FUR, PAL Valor del tipo balanza peso CV
	 */
	@ComparatorTypeField
	@Column(name = "VALORTIPOBALANZAPESO")
	private String valorTipoBalanzaPeso;

	/**
	 * Se ingresa el catalogo tipo 9122 Valor del tipo balanza peso CV
	 */
	@Column(name = "CODIGOTIPOBALANZAPESO")
	private Integer codigoTipoBalanzaPeso;

	/**
	 * Cantidad pedida del articulo
	 */
	@Column(name = "CANTIDADPEDIDA", nullable = false)
	private Integer cantidadPedida;

	/**
	 * Peso pedido del articulo
	 */
	@Column(name = "PESOPEDIDO")
	private BigDecimal pesoPedido;
	
	/**
	 * Cantidad entregada del articulo en recepciones previas
	 */
	@Column(name = "CANTIDADANTERIOR", nullable = false)
	private Integer cantidadAnterior;

	/**
	 * Peso entregado del articulo en recepciones previas
	 */
	@Column(name = "PESOANTERIOR")
	private BigDecimal pesoAnterior;

	/**
	 * Cantidad planificada del articulo
	 */
	@Column(name = "CANTIDADPLANIFICADA", nullable = false)
	private Integer cantidadPlanificada;

	/**
	 * Peso planificado del articulo
	 */
	@Column(name = "PESOPLANIFICADO")
	private BigDecimal pesoPlanificado;

	/**
	 * Cantidad entregada del articulo
	 */
	@Column(name = "CANTIDADENTREGADA", nullable = false)
	private Integer cantidadEntregada;

	/**
	 * Peso entregado del articulo
	 */
	@Column(name = "PESOENTREGADO")
	private BigDecimal pesoEntregado;
	
	/**
	 * Estado el articulo en la orden compra
	 */
	@Column(name = "VALORTIPOESTADOORDENCOMPRA", nullable = false)
	@ComparatorTypeField
	private String valorTipoEstadoOrdenCompra;

	@Column(name = "CODIGOTIPOESTADOORDENCOMPRA", nullable = false)
	private Integer codigoTipoEstadoOrdenCompra;
	
	/**
	 * Especifica si la recepcion permite escaneo manual
	 * 
	 */
	@Column(name = "SOLICITUDCAJA")
	private Boolean solicitudCaja;

	/**
	 * Especifica la relacion con RecepcionProveedor
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGORECEPCIONPROVEEDOR", insertable = false, updatable = false, referencedColumnName = "CODIGORECEPCIONPROVEEDOR") 
	})
	private RecepcionProveedorDTO recepcionProveedorDTO;

	/**
	 * Especifica la relacion con ArticuloUnidadManejo
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"), 
		@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) 
	})
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;

	/**
	 * Especifica la relacion con CatalogoValor
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "VALORTIPOBALANZAPESO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOTIPOBALANZAPESO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") 
	})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoBalanzaPeso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "VALORTIPOESTADOORDENCOMPRA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOTIPOESTADOORDENCOMPRA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) 
	})
	private CatalogoValorDTO estadoOrdenCompra;

	/**
	 * Referencia a la tabla DatosTarea
	 */
	@OneToMany(mappedBy = "recepcionProveedorArticuloDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaDTO> datosTareaDTOCol;

	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	@ComparatorTypeField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	/**
	 * Referencia con la tabla User
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	@Column(name = "ESTADO")
	private String estado;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorArticuloID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the secuencialRecepcionProveedorArticulo
	 */
	public Long getSecuencialRecepcionProveedorArticulo() {
		return secuencialRecepcionProveedorArticulo;
	}

	/**
	 * @param secuencialRecepcionProveedorArticulo
	 *            the secuencialRecepcionProveedorArticulo to set
	 */
	public void setSecuencialRecepcionProveedorArticulo(Long secuencialRecepcionProveedorArticulo) {
		this.secuencialRecepcionProveedorArticulo = secuencialRecepcionProveedorArticulo;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor
	 *            the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo
	 *            the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo
	 *            the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the valorTipoBalanzaPeso
	 */
	public String getValorTipoBalanzaPeso() {
		return valorTipoBalanzaPeso;
	}

	/**
	 * @param valorTipoBalanzaPeso
	 *            the valorTipoBalanzaPeso to set
	 */
	public void setValorTipoBalanzaPeso(String valorTipoBalanzaPeso) {
		this.valorTipoBalanzaPeso = valorTipoBalanzaPeso;
	}

	/**
	 * @return the codigoTipoBalanzaPeso
	 */
	public Integer getCodigoTipoBalanzaPeso() {
		return codigoTipoBalanzaPeso;
	}

	/**
	 * @param codigoTipoBalanzaPeso
	 *            the codigoTipoBalanzaPeso to set
	 */
	public void setCodigoTipoBalanzaPeso(Integer codigoTipoBalanzaPeso) {
		this.codigoTipoBalanzaPeso = codigoTipoBalanzaPeso;
	}

	/**
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida
	 *            the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	/**
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}

	/**
	 * @param pesoPedido
	 *            the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}

	/**
	 * @return the cantidadPlanificada
	 */
	public Integer getCantidadPlanificada() {
		return cantidadPlanificada;
	}

	/**
	 * @param cantidadPlanificada
	 *            the cantidadPlanificada to set
	 */
	public void setCantidadPlanificada(Integer cantidadPlanificada) {
		this.cantidadPlanificada = cantidadPlanificada;
	}

	/**
	 * @return the pesoPlanificado
	 */
	public BigDecimal getPesoPlanificado() {
		return pesoPlanificado;
	}

	/**
	 * @param pesoPlanificado
	 *            the pesoPlanificado to set
	 */
	public void setPesoPlanificado(BigDecimal pesoPlanificado) {
		this.pesoPlanificado = pesoPlanificado;
	}

	/**
	 * @return the cantidadEntregada
	 */
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * @param cantidadEntregada
	 *            the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * @return the pesoEntregado
	 */
	public BigDecimal getPesoEntregado() {
		return pesoEntregado;
	}

	/**
	 * @param pesoEntregado
	 *            the pesoEntregado to set
	 */
	public void setPesoEntregado(BigDecimal pesoEntregado) {
		this.pesoEntregado = pesoEntregado;
	}

	/**
	 * @return the recepcionProveedorDTO
	 */
	public RecepcionProveedorDTO getRecepcionProveedorDTO() {
		return recepcionProveedorDTO;
	}

	/**
	 * @param recepcionProveedorDTO
	 *            the recepcionProveedorDTO to set
	 */
	public void setRecepcionProveedorDTO(RecepcionProveedorDTO recepcionProveedorDTO) {
		this.recepcionProveedorDTO = recepcionProveedorDTO;
	}

	/**
	 * @return the articuloUnidadManejoDTO
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	/**
	 * @param articuloUnidadManejoDTO
	 *            the articuloUnidadManejoDTO to set
	 */
	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	/**
	 * @return the tipoBalanzaPeso
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoBalanzaPeso() {
		return tipoBalanzaPeso;
	}

	/**
	 * @param tipoBalanzaPeso
	 *            the tipoBalanzaPeso to set
	 */
	public void setTipoBalanzaPeso(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoBalanzaPeso) {
		this.tipoBalanzaPeso = tipoBalanzaPeso;
	}

	/**
	 * @return the datosTareaDTOCol
	 */
	public Collection<DatosTareaDTO> getDatosTareaDTOCol() {
		return datosTareaDTOCol;
	}

	/**
	 * @param datosTareaDTOCol
	 *            the datosTareaDTOCol to set
	 */
	public void setDatosTareaDTOCol(Collection<DatosTareaDTO> datosTareaDTOCol) {
		this.datosTareaDTOCol = datosTareaDTOCol;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro
	 *            the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion
	 *            the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion
	 *            the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion
	 *            the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getClaveArticuloUnidadManejoProveedor() {

		final char sepadador = '-';
		return new StringBuilder().append(this.codigoArticulo).append(sepadador).append(this.codigoUnidadManejo).append(sepadador).append(this.codigoRecepcionProveedor).toString();

	}

	/**
	 * @return the valorTipoEstadoOrdenCompra
	 */
	public String getValorTipoEstadoOrdenCompra() {
		return valorTipoEstadoOrdenCompra;
	}

	/**
	 * @param valorTipoEstadoOrdenCompra the valorTipoEstadoOrdenCompra to set
	 */
	public void setValorTipoEstadoOrdenCompra(String valorTipoEstadoOrdenCompra) {
		this.valorTipoEstadoOrdenCompra = valorTipoEstadoOrdenCompra;
	}

	/**
	 * @return the codigoTipoEstadoOrdenCompra
	 */
	public Integer getCodigoTipoEstadoOrdenCompra() {
		return codigoTipoEstadoOrdenCompra;
	}

	/**
	 * @param codigoTipoEstadoOrdenCompra the codigoTipoEstadoOrdenCompra to set
	 */
	public void setCodigoTipoEstadoOrdenCompra(Integer codigoTipoEstadoOrdenCompra) {
		this.codigoTipoEstadoOrdenCompra = codigoTipoEstadoOrdenCompra;
	}

	/**
	 * @return the estadoOrdenCompra
	 */
	public CatalogoValorDTO getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * @param estadoOrdenCompra the estadoOrdenCompra to set
	 */
	public void setEstadoOrdenCompra(CatalogoValorDTO estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	/**
	 * @return the solicitudCaja
	 */
	public Boolean getSolicitudCaja() {
		return solicitudCaja;
	}

	/**
	 * @param solicitudCaja the solicitudCaja to set
	 */
	public void setSolicitudCaja(Boolean solicitudCaja) {
		this.solicitudCaja = solicitudCaja;
	}

	/**
	 * @return the cantidadAnterior
	 */
	public Integer getCantidadAnterior() {
		return cantidadAnterior;
	}

	/**
	 * @param cantidadAnterior the cantidadAnterior to set
	 */
	public void setCantidadAnterior(Integer cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}

	/**
	 * @return the pesoAnterior
	 */
	public BigDecimal getPesoAnterior() {
		return pesoAnterior;
	}

	/**
	 * @param pesoAnterior the pesoAnterior to set
	 */
	public void setPesoAnterior(BigDecimal pesoAnterior) {
		this.pesoAnterior = pesoAnterior;
	}

	// /* (non-Javadoc)
	// * @see java.lang.Object#hashCode()
	// */
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = super.hashCode();
	// result = prime * result + ((codigoArticulo == null) ? 0 :
	// codigoArticulo.hashCode());
	// result = prime * result + ((codigoRecepcionProveedor == null) ? 0 :
	// codigoRecepcionProveedor.hashCode());
	// result = prime * result + ((codigoUnidadManejo == null) ? 0 :
	// codigoUnidadManejo.hashCode());
	// return result;
	// }
	//
	// /* (non-Javadoc)
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (!super.equals(obj))
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// RecepcionProveedorArticuloDTO other = (RecepcionProveedorArticuloDTO)
	// obj;
	// if (codigoArticulo == null) {
	// if (other.codigoArticulo != null)
	// return false;
	// } else if (!codigoArticulo.equals(other.codigoArticulo))
	// return false;
	// if (codigoRecepcionProveedor == null) {
	// if (other.codigoRecepcionProveedor != null)
	// return false;
	// } else if
	// (!codigoRecepcionProveedor.equals(other.codigoRecepcionProveedor))
	// return false;
	// if (codigoUnidadManejo == null) {
	// if (other.codigoUnidadManejo != null)
	// return false;
	// } else if (!codigoUnidadManejo.equals(other.codigoUnidadManejo))
	// return false;
	// return true;
	// }

}
