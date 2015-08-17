package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.PedidoHistoricoID;

/****
 * Almacena los cambios historicos de los pedidos 
 * solicitados por los compradores
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoHistoricoDTO")
@Table(name = "SSB2BTPEDIDOHIS")
@Deprecated
public class PedidoHistoricoDTO extends SimpleAuditDTO
{
	
	/**
	 * Campo identificador
	 */
	@EmbeddedId
	private PedidoHistoricoID id  = new PedidoHistoricoID();

	
	/**
	 * fecha de elaboracion de la orden de compra
	 *
	 */
	private java.util.Date fechaElaboracion ;

	
	/**
	 * fecha asignada para la entrega de la orden de compra
	 *
	 */
	private java.util.Date fechaEntrega ;


	/**
	 * fecha de vencimiento/caducidad del pedido
	 *
	 */
	private java.util.Date fechaCaducidad ;
	
	/**
	 * Estado que indica si ha sido consultado un pedido
     * 0: no consultado
     * 1: si consultado
	 *
	 */
	private String estadoConsultado ;

	/**
	 * estado de pedido
	 */
	private String estadoPedido ;	
	
	/**
	 * tipo del pedido
	 */
	private String tipoPedido;
	
	/**
	 * Flag para indicar si el pedido tiene o no ordenes
	 * canceladas
	 * 0 No tiene ordenes canceladas
	 * 1 Tiene al menos una orden cancelada
	 */
	private String tieneCancelacionOrden;
	
	/**
	 * fecha Desde se maneja el historico
	 *
	 */
	private java.util.Date fechaDesde ;

	/**
	 * fecha Hasta se maneja el historico
	 *
	 */
	private java.util.Date fechaHasta ;
	
	/**
	 * Relacion con entidad pedido 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false)
	})
	private PedidoDTO pedido;
	
	/**
	 * Constructor
	 */
	public PedidoHistoricoDTO()
	{
		this.id = new PedidoHistoricoID();
	}
	
	public PedidoDTO getPedido() 
	{
		return pedido;
	}


	public void setPedido(PedidoDTO pedido) 
	{
		this.pedido = pedido;
	}
	
	
	public PedidoHistoricoID getId() 
	{
		return id;
	}

	public void setId(PedidoHistoricoID id) 
	{
		this.id = id;
	}


	public String getEstadoConsultado() 
	{
		return estadoConsultado;
	}


	public void setEstadoConsultado(String estadoConsultado) 
	{
		this.estadoConsultado = estadoConsultado;
	}


	public String getEstadoPedido() 
	{
		return estadoPedido;
	}


	public void setEstadoPedido(String estadoPedido) 
	{
		this.estadoPedido = estadoPedido;
	}


	public java.util.Date getFechaCaducidad() 
	{
		return fechaCaducidad;
	}


	public void setFechaCaducidad(java.util.Date fechaCaducidad) 
	{
		this.fechaCaducidad = fechaCaducidad;
	}


	public java.util.Date getFechaElaboracion() 
	{
		return fechaElaboracion;
	}


	public void setFechaElaboracion(java.util.Date fechaElaboracion) 
	{
		this.fechaElaboracion = fechaElaboracion;
	}


	public java.util.Date getFechaEntrega() 
	{
		return fechaEntrega;
	}


	public void setFechaEntrega(java.util.Date fechaEntrega) 
	{
		this.fechaEntrega = fechaEntrega;
	}


	public java.util.Date getFechaDesde() 
	{
		return fechaDesde;
	}


	public void setFechaDesde(java.util.Date fechaDesde) 
	{
		this.fechaDesde = fechaDesde;
	}


	public java.util.Date getFechaHasta() 
	{
		return fechaHasta;
	}


	public void setFechaHasta(java.util.Date fechaHasta) 
	{
		this.fechaHasta = fechaHasta;
	}

	public String getTipoPedido() 
	{
		return tipoPedido;
	}

	/**
	 * 
	 * @param tipoPedido El tipo de Pedido a establecer
	 */
	public void setTipoPedido(String tipoPedido) 
	{
		this.tipoPedido = tipoPedido;
	}

	public String getTieneCancelacionOrden() 
	{
		return tieneCancelacionOrden;
	}

	public void setTieneCancelacionOrden(String tieneCancelacionOrden) 
	{
		this.tieneCancelacionOrden = tieneCancelacionOrden;
	}
	
}
