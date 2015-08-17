package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.framework.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.DetalleOrdenCompraID;

/**
 * Entidad que permite definir los items que tiene la orden de compra.
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.DetalleOrdenCompraDTO")
@Table(name = "SSB2BTDETORDCOM")
@Deprecated
public class DetalleOrdenCompraDTO extends SimpleAuditDTO {

	@EmbeddedId
	private DetalleOrdenCompraID id = new DetalleOrdenCompraID();
	/**
	 * descripcion del articulo.
	 * 
	 */
	private String descripcionArticulo;
	
	/**
	 * tamanio del articulo
	 * 
	 */
	private String tamanio;
	
	/**
	 * unidad de manejo del aticulo.
	 * 
	 */
	private Long unidadManejo;
	
	/**
	 * peso aproximando del articulo.
	 * 
	 */
	private Double pesoAproximado;
	
	/**
	 * Cantidad de bultos por pedido
	 * 
	 */
	private Double cantidadPedido;
	
	/**
	 * cantidad de bultos recibida
	 * 
	 */
	private Double cantidadRecibida;
	
	/**
	 * costoBruto
	 * 
	 */
	private Double costoBruto;
	
	/**
	 * descuento de unidad de la compra.
	 * 
	 */
	private Double descuentoUnidadCompra;
	
	/**
	 * descuento1
	 * 
	 */
	private Double descuento1;
	
	/**
	 * descuento2
	 * 
	 */
	private Double descuento2;
	
	/**
	 * descuento3
	 * 
	 */
	private Double descuento3;
	
	/**
	 * descuento4
	 * 
	 */
	private Double descuento4;
	
	/**
	 * descuentoProducto
	 * 
	 */
	private Double descuentoProducto;
	
	/**
	 * descuentoPromocion
	 * 
	 */
	private Double descuentoPromocion;
	
	/**
	 * Indica si el art�culo aplica IVA, los valores pueden ser: - [1] SI APLICA
	 * - [0] NO APLICA
	 * 
	 */
	private Boolean aplicaIVA;
	
	/**
	 * costo Neto.
	 * 
	 */
	private Double costoNeto;
	
	/**
	 * procesado
	 */
	private String procesado;

	// Atributos no persistentes
	/**
	 * Esta seleccionada
	 * 
	 */
	@Transient
	private Boolean selected;

	@Transient
	private Double cantidadEntregados = (double) 0;

	@Transient
	private DetalleOrdenCompraDTO npDetalleOrdenCambio;

	@Transient
	private double cantidadDisponible;

	@Transient
	private Boolean mostrarCambio;
	// private Collection<DetalleEntregaOrdenCompraDTO> detallesEntrega;

	/**
	 * Id del usuario que realiza el registro
	 * 
	 */
	private String usuarioRegistro;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	private Timestamp fechaRegistro;
	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n
	 * 
	 */
	private String usuarioModificacion;
	
	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n
	 * 
	 */
	private Timestamp fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloDTO articulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto registerUser;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto lastModificationUser;

	// RELACIONES

	// Relacion con la tabla SSB2BPEDIDODETALLE
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false) })
	private PedidoDetalleDTO pedidoDetalleDTO;

	// Relacion con la tabla SSB2BDETORDCOMDES
	@Transient
	@OneToMany(mappedBy = "detalleOrdenCompraDTO")
	private Collection<DetalleOrdenCompraDescuentoDTO> listaDetalleOrdenCompraDescuento;

	@Transient
	@OneToMany(mappedBy = "detalleOrdenCompraDTO")
	private Collection<DetalleOrdenCompraDescuentoDTO> listaDescuentos;

	/**
	 * @return the listaDescuentos
	 */
	public Collection<DetalleOrdenCompraDescuentoDTO> getListaDescuentos() {
		return listaDescuentos;
	}

	/**
	 * @param listaDescuentos
	 *            the listaDescuentos to set
	 */
	public void setListaDescuentos(Collection<DetalleOrdenCompraDescuentoDTO> listaDescuentos) {
		this.listaDescuentos = listaDescuentos;
	}

	/**
	 * @return the pedidoDetalleDTO
	 */
	public PedidoDetalleDTO getPedidoDetalleDTO() {
		return pedidoDetalleDTO;
	}

	/**
	 * @param pedidoDetalleDTO
	 *            the pedidoDetalleDTO to set
	 */
	public void setPedidoDetalleDTO(PedidoDetalleDTO pedidoDetalleDTO) {
		this.pedidoDetalleDTO = pedidoDetalleDTO;
	}

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public DetalleOrdenCompraID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(DetalleOrdenCompraID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcionArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcionArticulo</code>
	 */
	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>descripcionArticulo</code>.
	 * 
	 * @param descripcionArticulo1
	 *            El valor a establecer para la propiedad
	 *            <code>descripcionArticulo</code>.
	 */
	public void setDescripcionArticulo(String descripcionArticulo1) {
		this.descripcionArticulo = descripcionArticulo1;

		if (descripcionArticulo != null && descripcionArticulo.length() > 100) {
			descripcionArticulo = descripcionArticulo.substring(0, 100);
		}

	}

	/**
	 * Retorna valor de propiedad <code>tamanio</code>
	 * 
	 * @return Retorna valor de propiedad <code>tamanio</code>
	 */
	public String getTamanio() {
		return this.tamanio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tamanio</code>.
	 * 
	 * @param tamanio1
	 *            El valor a establecer para la propiedad <code>tamanio</code>.
	 */
	public void setTamanio(String tamanio1) {
		this.tamanio = tamanio1;

		if (tamanio != null && tamanio.length() > 50) {
			tamanio = tamanio.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>unidadManejo</code>
	 * 
	 * @return Retorna valor de propiedad <code>unidadManejo</code>
	 */
	public java.lang.Long getUnidadManejo() {
		return this.unidadManejo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>unidadManejo</code>.
	 * 
	 * @param unidadManejo1
	 *            El valor a establecer para la propiedad
	 *            <code>unidadManejo</code>.
	 */
	public void setUnidadManejo(java.lang.Long unidadManejo1) {
		this.unidadManejo = unidadManejo1;

	}

	/**
	 * Retorna valor de propiedad <code>pesoAproximado</code>
	 * 
	 * @return Retorna valor de propiedad <code>pesoAproximado</code>
	 */
	public Double getPesoAproximado() {
		return this.pesoAproximado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pesoAproximado</code>.
	 * 
	 * @param pesoAproximado1
	 *            El valor a establecer para la propiedad
	 *            <code>pesoAproximado</code>.
	 */
	public void setPesoAproximado(Double pesoAproximado1) {
		this.pesoAproximado = pesoAproximado1;

	}

	/**
	 * Retorna valor de propiedad <code>cantidadPedido</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidadPedido</code>
	 */
	public Double getCantidadPedido() {
		return this.cantidadPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadPedido</code>.
	 * 
	 * @param cantidadPedido1
	 *            El valor a establecer para la propiedad
	 *            <code>cantidadPedido</code>.
	 */
	public void setCantidadPedido(Double cantidadPedido1) {
		this.cantidadPedido = cantidadPedido1;

	}

	/**
	 * Retorna valor de propiedad <code>cantidadRecibida</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidadRecibida</code>
	 */
	public Double getCantidadRecibida() {
		return this.cantidadRecibida;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadRecibida</code>.
	 * 
	 * @param cantidadRecibida1
	 *            El valor a establecer para la propiedad
	 *            <code>cantidadRecibida</code>.
	 */
	public void setCantidadRecibida(Double cantidadRecibida1) {
		this.cantidadRecibida = cantidadRecibida1;

	}

	/**
	 * Retorna valor de propiedad <code>costoBruto</code>
	 * 
	 * @return Retorna valor de propiedad <code>costoBruto</code>
	 */
	public Double getCostoBruto() {
		return this.costoBruto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>costoBruto</code>.
	 * 
	 * @param costoBruto1
	 *            El valor a establecer para la propiedad
	 *            <code>costoBruto</code>.
	 */
	public void setCostoBruto(Double costoBruto1) {
		this.costoBruto = costoBruto1;

	}

	/**
	 * Retorna valor de propiedad <code>descuentoUnidadCompra</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuentoUnidadCompra</code>
	 */
	public Double getDescuentoUnidadCompra() {
		return this.descuentoUnidadCompra;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>descuentoUnidadCompra</code>.
	 * 
	 * @param descuentoUnidadCompra1
	 *            El valor a establecer para la propiedad
	 *            <code>descuentoUnidadCompra</code>.
	 */
	public void setDescuentoUnidadCompra(Double descuentoUnidadCompra1) {
		this.descuentoUnidadCompra = descuentoUnidadCompra1;

	}

	/**
	 * Retorna valor de propiedad <code>descuento1</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuento1</code>
	 */
	public Double getDescuento1() {
		return this.descuento1;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuento1</code>.
	 * 
	 * @param descuento11
	 *            El valor a establecer para la propiedad
	 *            <code>descuento1</code>.
	 */
	public void setDescuento1(Double descuento11) {
		this.descuento1 = descuento11;

	}

	/**
	 * Retorna valor de propiedad <code>descuento2</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuento2</code>
	 */
	public Double getDescuento2() {
		return this.descuento2;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuento2</code>.
	 * 
	 * @param descuento21
	 *            El valor a establecer para la propiedad
	 *            <code>descuento2</code>.
	 */
	public void setDescuento2(Double descuento21) {
		this.descuento2 = descuento21;

	}

	/**
	 * Retorna valor de propiedad <code>descuento3</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuento3</code>
	 */
	public Double getDescuento3() {
		return this.descuento3;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuento3</code>.
	 * 
	 * @param descuento31
	 *            El valor a establecer para la propiedad
	 *            <code>descuento3</code>.
	 */
	public void setDescuento3(Double descuento31) {
		this.descuento3 = descuento31;

	}

	/**
	 * Retorna valor de propiedad <code>descuento4</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuento4</code>
	 */
	public Double getDescuento4() {
		return this.descuento4;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuento4</code>.
	 * 
	 * @param descuento41
	 *            El valor a establecer para la propiedad
	 *            <code>descuento4</code>.
	 */
	public void setDescuento4(Double descuento41) {
		this.descuento4 = descuento41;

	}

	/**
	 * Retorna valor de propiedad <code>descuentoProducto</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuentoProducto</code>
	 */
	public Double getDescuentoProducto() {
		return this.descuentoProducto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descuentoProducto</code>
	 * .
	 * 
	 * @param descuentoProducto1
	 *            El valor a establecer para la propiedad
	 *            <code>descuentoProducto</code>.
	 */
	public void setDescuentoProducto(Double descuentoProducto1) {
		this.descuentoProducto = descuentoProducto1;

	}

	/**
	 * Retorna valor de propiedad <code>descuentoPromocion</code>
	 * 
	 * @return Retorna valor de propiedad <code>descuentoPromocion</code>
	 */
	public Double getDescuentoPromocion() {
		return this.descuentoPromocion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>descuentoPromocion</code>.
	 * 
	 * @param descuentoPromocion1
	 *            El valor a establecer para la propiedad
	 *            <code>descuentoPromocion</code>.
	 */
	public void setDescuentoPromocion(Double descuentoPromocion1) {
		this.descuentoPromocion = descuentoPromocion1;

	}

	/**
	 * Retorna valor de propiedad <code>costoNeto</code>
	 * 
	 * @return Retorna valor de propiedad <code>costoNeto</code>
	 */
	public Double getCostoNeto() {
		return this.costoNeto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>costoNeto</code>.
	 * 
	 * @param costoNeto1
	 *            El valor a establecer para la propiedad <code>costoNeto</code>
	 *            .
	 */
	public void setCostoNeto(Double costoNeto1) {
		this.costoNeto = costoNeto1;

	}

	/**
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}

	/**
	 * Retorna valor de propiedad <code>registerUser</code>
	 * 
	 * @return Retorna valor de propiedad <code>registerUser</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getRegisterUser() {
		return this.registerUser;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registerUser</code>.
	 * 
	 * @param registerUser1
	 *            El valor a establecer para la propiedad
	 *            <code>registerUser</code>.
	 */
	public void setRegisterUser(ec.com.smx.framework.security.dto.UserDto registerUser1) {
		this.registerUser = registerUser1;
	}

	/**
	 * Retorna valor de propiedad <code>lastModificationUser</code>
	 * 
	 * @return Retorna valor de propiedad <code>lastModificationUser</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getLastModificationUser() {
		return this.lastModificationUser;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>lastModificationUser</code>.
	 * 
	 * @param lastModificationUser1
	 *            El valor a establecer para la propiedad
	 *            <code>lastModificationUser</code>.
	 */
	public void setLastModificationUser(ec.com.smx.framework.security.dto.UserDto lastModificationUser1) {
		this.lastModificationUser = lastModificationUser1;
	}

	/**
	 * @return the selected
	 */
	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the cantidadEntregados
	 */
	public Double getCantidadEntregados() {
		return cantidadEntregados;
	}

	/**
	 * @param cantidadEntregados
	 *            the cantidadEntregados to set
	 */
	public void setCantidadEntregados(Double cantidadEntregados) {
		this.cantidadEntregados = cantidadEntregados;
	}

	/**
	 * @return the npDetalleOrdenCambio
	 */
	public DetalleOrdenCompraDTO getNpDetalleOrdenCambio() {
		return npDetalleOrdenCambio;
	}

	/**
	 * @param npDetalleOrdenCambio
	 *            the npDetalleOrdenCambio to set
	 */
	public void setNpDetalleOrdenCambio(DetalleOrdenCompraDTO npDetalleOrdenCambio) {
		this.npDetalleOrdenCambio = npDetalleOrdenCambio;
	}

	/**
	 * @return the cantidadDisponible
	 */
	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	/**
	 * @param cantidadDisponible
	 *            the cantidadDisponible to set
	 */
	public void setCantidadDisponible(double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	/**
	 * @return the mostrarCambio
	 */
	public Boolean getMostrarCambio() {
		return mostrarCambio;
	}

	/**
	 * @param mostrarCambio
	 *            the mostrarCambio to set
	 */
	public void setMostrarCambio(Boolean mostrarCambio) {
		this.mostrarCambio = mostrarCambio;
	}

	/**
	 * @return the aplicaIVA
	 */
	public Boolean getAplicaIVA() {
		return aplicaIVA;
	}

	/**
	 * @param aplicaIVA
	 *            the aplicaIVA to set
	 */
	public void setAplicaIVA(Boolean aplicaIVA) {
		this.aplicaIVA = aplicaIVA;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioRegistro</code>
	 */
	public String getUsuarioRegistro() {
		return this.usuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistro</code>.
	 * 
	 * @param usuarioRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioRegistro</code>.
	 */
	public void setUsuarioRegistro(String usuarioRegistro1) {
		this.usuarioRegistro = usuarioRegistro1;

		if (usuarioRegistro != null && usuarioRegistro.length() > 32) {
			usuarioRegistro = usuarioRegistro.substring(0, 32);
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
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public String getUsuarioModificacion() {
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
	public void setUsuarioModificacion(String usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;

		if (usuarioModificacion != null && usuarioModificacion.length() > 32) {
			usuarioModificacion = usuarioModificacion.substring(0, 32);
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

	public Collection<DetalleOrdenCompraDescuentoDTO> getListaDetalleOrdenCompraDescuento() {
		return listaDetalleOrdenCompraDescuento;
	}

	public void setListaDetalleOrdenCompraDescuento(Collection<DetalleOrdenCompraDescuentoDTO> listaDetalleOrdenCompraDescuento) {
		this.listaDetalleOrdenCompraDescuento = listaDetalleOrdenCompraDescuento;
	}

	/**
	 * @return the procesado
	 */
	public String getProcesado() {
		return procesado;
	}

	/**
	 * @param procesado the procesado to set
	 */
	public void setProcesado(String procesado) {
		this.procesado = procesado;
	}

}
