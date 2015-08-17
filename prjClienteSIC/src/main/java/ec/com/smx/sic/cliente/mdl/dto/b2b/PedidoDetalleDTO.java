package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.PedidoDetalleID;

/**
 * tiene el detalle de ordenes de compra de un pedido
 * 
 * @author kruger
 */

@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDetalleDTO")
@Table(name = "SSB2BTPEDIDODETALLE")
@Deprecated
public class PedidoDetalleDTO extends SimpleAuditDTO {

	/**
	 * Identificador de pedido detalle
	 */
	@EmbeddedId
	private PedidoDetalleID id = new PedidoDetalleID();

	/**
	 * Cantidad total de items solicitados en la orden de compra
	 */
	private Integer cantidadItems;

	/**
	 * Cantidad total de productos solicitados en la orden de compra
	 */
	private Integer cantidad;

	/**
	 * Estado de orden de compra
	 */
	private String estadoOrdenCompra;

	/**
	 * Propiedad no persistente de descripcion del estado de orden de compra
	 */
	@Transient
	private String descripcionEstadoOrdenCompra;

	private String nombreDepartamento;

	private String codigoDepartamento;
	/**
	 * En esta propiedad se almacena el valor 0 si no es nueva es decir es para
	 * aumentar o remplazar,1 si es nueva y 9 si la orden pertenece a un
	 * proveedor importado del departamento de Hogar
	 * 
	 */
	private String esNueva;
	
	/**
	 * En este propiedad se almacena la fecha de emisión de la orden de compra
	 */
	private Timestamp fechaEmision;

	// referencia a EstadoOrdenCompra
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTADOORDENCOMPRA", referencedColumnName = "ESTADOORDENCOMPRA", insertable = false, updatable = false)
	private EstadoOrdenCompraDTO estadoOrdenCompraDTO;
	
	// referencia a PedidoDTO
	// private PedidoDTO pedidoDTO;
	@OneToMany(mappedBy = "pedidoDetalleOriginal")
	private Set<PedidoDetalleRelacionadoDTO> relacionado;

	//@Transient
	//private Collection<DetalleArticuloOrdenCompraIDTO> npArticulos;
	
	@Transient
	private String npNoEstadoOrdenCompra;

	// Relacion con la tabla SSB2BTPEDIDO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
				   @JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false) })
	private PedidoDTO pedidoDTO;

	// Relacion con tabla SSB2BTDETORDCOM
	@OneToMany(mappedBy = "pedidoDetalleDTO")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<DetalleOrdenCompraDTO> listaDetalleOrdenCompra;

	/**
	 * @return el pedidoDTO
	 */
	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}

	/**
	 * @param pedidoDTO
	 *            el pedidoDTO a establecer
	 */
	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}

	public Set<PedidoDetalleRelacionadoDTO> getRelacionado() {
		return relacionado;
	}

	public void setRelacionado(Set<PedidoDetalleRelacionadoDTO> relacionado) {
		this.relacionado = relacionado;
	}

	/*public Collection<DetalleArticuloOrdenCompraIDTO> getNpArticulos() {
		return npArticulos;
	}

	public void setNpArticulos(Collection<DetalleArticuloOrdenCompraIDTO> npArticulos) {
		this.npArticulos = npArticulos;
	}*/

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public PedidoDetalleID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(PedidoDetalleID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>cantidadItems</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidadItems</code>
	 */
	public Integer getCantidadItems() {
		return this.cantidadItems;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadItems</code>.
	 * 
	 * @param cantidadItems1
	 *            El valor a establecer para la propiedad
	 *            <code>cantidadItems</code>.
	 */
	public void setCantidadItems(Integer cantidadItems1) {
		this.cantidadItems = cantidadItems1;

	}

	/**
	 * Retorna valor de propiedad <code>cantidad</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidad</code>
	 */
	public Integer getCantidad() {
		return this.cantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidad</code>.
	 * 
	 * @param cantidad1
	 *            El valor a establecer para la propiedad <code>cantidad</code>.
	 */
	public void setCantidad(Integer cantidad1) {
		this.cantidad = cantidad1;
	}

	/**
	 * Obtener estado de orden de compra
	 * 
	 * @return
	 */
	public String getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * Establecer estado de orden de compra
	 * 
	 * @param estadoOrdenCompra
	 */
	public void setEstadoOrdenCompra(String estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	/**
	 * Obtener descripcion estado orden compra
	 * 
	 * @return
	 */
	public String getDescripcionEstadoOrdenCompra() {
		return descripcionEstadoOrdenCompra;
	}

	/**
	 * Establecer descripcion estado de orden compra
	 * 
	 * @param descripcionEstadoOrdenCompra
	 */
	public void setDescripcionEstadoOrdenCompra(String descripcionEstadoOrdenCompra) {
		this.descripcionEstadoOrdenCompra = descripcionEstadoOrdenCompra;
	}

	/**
	 * @return el estadoOrdenCompraDTO
	 */
	public EstadoOrdenCompraDTO getEstadoOrdenCompraDTO() {
		return estadoOrdenCompraDTO;
	}

	/**
	 * @param estadoOrdenCompraDTO
	 *            el estadoOrdenCompraDTO a establecer
	 */
	public void setEstadoOrdenCompraDTO(EstadoOrdenCompraDTO estadoOrdenCompraDTO) {
		this.estadoOrdenCompraDTO = estadoOrdenCompraDTO;
	}

	/**
	 * @return el nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * @param nombreDepartamento
	 *            el nombreDepartamento a establecer
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * @return el codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * @param codigoDepartamento
	 *            el codigoDepartamento a establecer
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getEsNueva() {
		return esNueva;
	}

	public void setEsNueva(String esNueva) {
		this.esNueva = esNueva;
	}

	public Timestamp getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	/**
	 * @return the npNoEstadoOrdenCompra
	 */
	public String getNpNoEstadoOrdenCompra() {
		return npNoEstadoOrdenCompra;
	}

	/**
	 * @param npNoEstadoOrdenCompra
	 *            the npNoEstadoOrdenCompra to set
	 */
	public void setNpNoEstadoOrdenCompra(String npNoEstadoOrdenCompra) {
		this.npNoEstadoOrdenCompra = npNoEstadoOrdenCompra;
	}

	/**
	 * @return the listaDetalleOrdenCompra
	 */
	public Collection<DetalleOrdenCompraDTO> getListaDetalleOrdenCompra() {
		return listaDetalleOrdenCompra;
	}

	/**
	 * @param listaDetalleOrdenCompra
	 *            the listaDetalleOrdenCompra to set
	 */
	public void setListaDetalleOrdenCompra(Collection<DetalleOrdenCompraDTO> listaDetalleOrdenCompra) {
		this.listaDetalleOrdenCompra = listaDetalleOrdenCompra;
	}

}
