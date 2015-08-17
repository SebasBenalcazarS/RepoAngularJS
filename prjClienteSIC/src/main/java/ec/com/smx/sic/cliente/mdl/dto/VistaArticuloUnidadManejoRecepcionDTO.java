package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloUnidadManejoRecepcionID;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

@Entity
public class VistaArticuloUnidadManejoRecepcionDTO extends SimpleAuditDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	VistaArticuloUnidadManejoRecepcionID id = new VistaArticuloUnidadManejoRecepcionID();
	
	//Indica la cifra para la unidad de manejo
	private Integer valorUnidadManejo;
	
	//Este campo es el pk de la ordencompradetalleestado de la entrega configurada (Orden en estado PEN)
	private Long codigoOrdenCompraDetalleEstadoPorEntregar;
	
	//Este campo es el secuencial de la ordencompradetallestado del pedido original (Orden en estado ENV)
	private Long secuencialOrdenCompraDetalleEstadoOriginal;
	
	//Este campo es el secuencial de la ordencompradetalleestado de la entrega configurada (Orden en estado PEN)
	private Long secuencialOrdenCompraDetalleEstadoPorEntregar;
	
	//Este campo es la cantidad planificada en la entrega configurada
	private Integer cantidadPorEntregarPedida;
	
	//Este campo es la cantidad entregada en la entrega planificada
	private Integer cantidadPorEntregarEntregada;
	
	//Este campo es la cantidad pedida en el pedido original
	private Integer cantidadOriginalPedida;
	
	//Este campo es la cantidad entregada en el pedido original
	private Integer cantidadOriginalEntregada;
	
	//Este campo es la peso configurado en el pedido original
	private BigDecimal pesoOriginalPedido;
	
	//Este campo es la peso entregado en el pedido original
	private BigDecimal pesoOriginalEntregado;
	
	//Este campo es la peso planificado en la entrega configurada
	private BigDecimal pesoPorEntregarPedido;
	
	//Este campo es la peso entregado en la entrega planificado
	private BigDecimal pesoPorEntregarEntregado;
	
	//Este campo contiene la fecha de elaboracion del pedido original
	private Date fechaElaboracionPedido;
	
	//Este campo es la fecha de la entrega configurada
	private java.util.Date fechaEntrega;
	
	//Este campo contiene el costo neto del articulo pedidoOriginalmente
	private BigDecimal costoNeto;
	
	//Este campo se llena unicamente en la consulta de edicion del pallet, y representa la cantidad recibida en el palet actual por cada uno de los detalles de orden de compra
	private Integer cantidadRecibidaPalet;
	
	//Este campo se llena unicamente en la consulta de edicion del pallet, y representa la peso recibido en el palet actual
	private BigDecimal pesoRecibidoPalet;
	
	//Este campo contiene la un date con la fecha y la hora de la entrega
	@Transient
	private Date fechaHoraEntrega;
	
	//Este campo calcula la hora inicio de la entrega para seleccionar las ordenes de compra por hora al momento de realizar la recepcion del articulo
	@Transient
	private Time horaInicio;
	
	//Este campo es para respaldar la cantidad pedida en el pedido original
	@Transient
	private Integer cantidadOriginalPedidaTEMP;
	
	//Este campo es para respaldar el peso configurado en el pedido original
	@Transient
	private BigDecimal pesoOriginalPedidoTEMP;
	
	@Transient
	private Collection<VistaArticuloUnidadManejoRecepcionDTO> vistasIgualesConHoraDiferente;
	
	public VistaArticuloUnidadManejoRecepcionID getId() {
		return id;
	}
	
	public void setId(VistaArticuloUnidadManejoRecepcionID id) {
		this.id = id;
	}

	public Integer getCantidadPorEntregarPedida() {
		if(cantidadPorEntregarPedida == null){
			return 0;
		}
		return cantidadPorEntregarPedida;
	}
	
	public void setCantidadPorEntregarPedida(Integer cantidadPorEntregarPedida) {
		this.cantidadPorEntregarPedida = cantidadPorEntregarPedida;
	}
	
	public Integer getCantidadPorEntregarEntregada() {
		if(cantidadPorEntregarEntregada == null){
			return 0;
		}
		return cantidadPorEntregarEntregada;
	}
	
	public void setCantidadPorEntregarEntregada(Integer cantidadPorEntregarEntregada) {
		this.cantidadPorEntregarEntregada = cantidadPorEntregarEntregada;
	}
	
	public Integer getCantidadOriginalPedida() {
		return cantidadOriginalPedida;
	}
	
	public void setCantidadOriginalPedida(Integer cantidadOriginalPedida) {
		this.cantidadOriginalPedida = cantidadOriginalPedida;
	}
	
	public Integer getCantidadOriginalEntregada() {
		return cantidadOriginalEntregada;
	}
	
	public void setCantidadOriginalEntregada(Integer cantidadOriginalEntregada) {
		this.cantidadOriginalEntregada = cantidadOriginalEntregada;
	}
	
	public Date getFechaElaboracionPedido() {
		return fechaElaboracionPedido;
	}
	
	public void setFechaElaboracionPedido(Date fechaElaboracionPedido) {
		this.fechaElaboracionPedido = fechaElaboracionPedido;
	}
	
	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}
	
	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}
	
	public Integer getCantidadRecibidaPalet() {
		return cantidadRecibidaPalet;
	}
	
	public void setCantidadRecibidaPalet(Integer cantidadRecibidaPalet) {
		this.cantidadRecibidaPalet = cantidadRecibidaPalet;
	}
	
	public Long getCodigoOrdenCompraDetalleEstadoPorEntregar() {
		return codigoOrdenCompraDetalleEstadoPorEntregar;
	}
	
	public void setCodigoOrdenCompraDetalleEstadoPorEntregar(Long codigoOrdenCompraDetalleEstadoPorEntregar) {
		this.codigoOrdenCompraDetalleEstadoPorEntregar = codigoOrdenCompraDetalleEstadoPorEntregar;
	}
	
	public Date getFechaHoraEntrega() {
		return fechaHoraEntrega;
	}
	
 	public void setFechaHoraEntrega(Date fechaHoraEntrega) {
		this.fechaHoraEntrega = fechaHoraEntrega;
	}
 	
 	/**
	 * @return the horaInicio
	 */
	public Time getHoraInicio() {
		if (this.getId().getHoraInicio() == null || Long.valueOf(0).equals(this.getId().getHoraInicio())) {
			horaInicio = null;
		} else {
			Long horaJava = new Long(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.hora.definida.java"));
			Long tiempoReal = horaJava + this.getId().getHoraInicio();
			horaInicio = new Time(tiempoReal);
		}
		return horaInicio;
	}
	
	public Collection<VistaArticuloUnidadManejoRecepcionDTO> getVistasIgualesConHoraDiferente() {
		return vistasIgualesConHoraDiferente;
	}
	
	public void setVistasIgualesConHoraDiferente(Collection<VistaArticuloUnidadManejoRecepcionDTO> vistasIgualesConHoraDiferente) {
		this.vistasIgualesConHoraDiferente = vistasIgualesConHoraDiferente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/**
	 * @return the pesoOriginalPedido
	 */
	public BigDecimal getPesoOriginalPedido() {
		return pesoOriginalPedido;
	}

	/**
	 * @param pesoOriginalPedido the pesoOriginalPedido to set
	 */
	public void setPesoOriginalPedido(BigDecimal pesoOriginalPedido) {
		this.pesoOriginalPedido = pesoOriginalPedido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VistaArticuloUnidadManejoRecepcionDTO other = (VistaArticuloUnidadManejoRecepcionDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the pesoOriginalEntregado
	 */
	public BigDecimal getPesoOriginalEntregado() {
		return pesoOriginalEntregado;
	}

	/**
	 * @param pesoOriginalEntregado the pesoOriginalEntregado to set
	 */
	public void setPesoOriginalEntregado(BigDecimal pesoOriginalEntregado) {
		this.pesoOriginalEntregado = pesoOriginalEntregado;
	}

	/**
	 * @return the pesoPorEntregarPedido
	 */
	public BigDecimal getPesoPorEntregarPedido() {
		return pesoPorEntregarPedido;
	}

	/**
	 * @param pesoPorEntregarPedido the pesoPorEntregarPedido to set
	 */
	public void setPesoPorEntregarPedido(BigDecimal pesoPorEntregarPedido) {
		this.pesoPorEntregarPedido = pesoPorEntregarPedido;
	}

	/**
	 * @return the pesoPorEntregarEntregado
	 */
	public BigDecimal getPesoPorEntregarEntregado() {
		return pesoPorEntregarEntregado;
	}

	/**
	 * @param pesoPorEntregarEntregado the pesoPorEntregarEntregado to set
	 */
	public void setPesoPorEntregarEntregado(BigDecimal pesoPorEntregarEntregado) {
		this.pesoPorEntregarEntregado = pesoPorEntregarEntregado;
	}

	/**
	 * @return the pesoRecibidoPalet
	 */
	public BigDecimal getPesoRecibidoPalet() {
		return pesoRecibidoPalet;
	}

	/**
	 * @param pesoRecibidoPalet the pesoRecibidoPalet to set
	 */
	public void setPesoRecibidoPalet(BigDecimal pesoRecibidoPalet) {
		this.pesoRecibidoPalet = pesoRecibidoPalet;
	}

	/**
	 * @return the secuencialOrdenCompraDetalleEstadoOriginal
	 */
	public Long getSecuencialOrdenCompraDetalleEstadoOriginal() {
		return secuencialOrdenCompraDetalleEstadoOriginal;
	}

	/**
	 * @param secuencialOrdenCompraDetalleEstadoOriginal the secuencialOrdenCompraDetalleEstadoOriginal to set
	 */
	public void setSecuencialOrdenCompraDetalleEstadoOriginal(Long secuencialOrdenCompraDetalleEstadoOriginal) {
		this.secuencialOrdenCompraDetalleEstadoOriginal = secuencialOrdenCompraDetalleEstadoOriginal;
	}

	/**
	 * @return the secuencialOrdenCompraDetalleEstadoPorEntregar
	 */
	public Long getSecuencialOrdenCompraDetalleEstadoPorEntregar() {
		return secuencialOrdenCompraDetalleEstadoPorEntregar;
	}

	/**
	 * @param secuencialOrdenCompraDetalleEstadoPorEntregar the secuencialOrdenCompraDetalleEstadoPorEntregar to set
	 */
	public void setSecuencialOrdenCompraDetalleEstadoPorEntregar(Long secuencialOrdenCompraDetalleEstadoPorEntregar) {
		this.secuencialOrdenCompraDetalleEstadoPorEntregar = secuencialOrdenCompraDetalleEstadoPorEntregar;
	}

	/**
	 * @return the cantidadOriginalPedidaTEMP
	 */
	public Integer getCantidadOriginalPedidaTEMP() {
		return cantidadOriginalPedidaTEMP;
	}

	/**
	 * @param cantidadOriginalPedidaTEMP the cantidadOriginalPedidaTEMP to set
	 */
	public void setCantidadOriginalPedidaTEMP(Integer cantidadOriginalPedidaTEMP) {
		this.cantidadOriginalPedidaTEMP = cantidadOriginalPedidaTEMP;
	}

	/**
	 * @return the pesoOriginalPedidoTEMP
	 */
	public BigDecimal getPesoOriginalPedidoTEMP() {
		return pesoOriginalPedidoTEMP;
	}

	/**
	 * @param pesoOriginalPedidoTEMP the pesoOriginalPedidoTEMP to set
	 */
	public void setPesoOriginalPedidoTEMP(BigDecimal pesoOriginalPedidoTEMP) {
		this.pesoOriginalPedidoTEMP = pesoOriginalPedidoTEMP;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	
}

