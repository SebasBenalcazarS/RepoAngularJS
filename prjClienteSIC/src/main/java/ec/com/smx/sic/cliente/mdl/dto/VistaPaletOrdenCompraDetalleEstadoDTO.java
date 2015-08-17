package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaPaletOrdenCompraDetalleEstadoID;

@Entity
public class VistaPaletOrdenCompraDetalleEstadoDTO {
	@EmbeddedId
	VistaPaletOrdenCompraDetalleEstadoID id = new VistaPaletOrdenCompraDetalleEstadoID();
	//Este campo es el secuencial de datosTarea
	private Long codigoDatosTarea;
	//Este campo es la cantidad que se ha recibido del articulo en el palet
	private Integer cantidadPalet;
	//Este campo es el codigo de la ordencompraDetalleEstado q se encuentra en el detalle de un palet(DatosTarea)
	private Long codigoOrdenCompraDetalleEstado;
	//codigo de la tarea del recolector
	private Long codigoTareaRecolector;
	
	
	//Desde aqui se encuentran los campos correspondientes a la ordenCompraDertalleEstado	del articulo	
	private Long codigoUnidadManejo;
	private Integer cantidadPedida;
	private Integer cantidadEntregada;
	private String codigoProveedor;
		
	public VistaPaletOrdenCompraDetalleEstadoID getId() {
		return id;
	}
	public void setId(VistaPaletOrdenCompraDetalleEstadoID id) {
		this.id = id;
	}
	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}
	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidadPalet() {
		return cantidadPalet;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidadPalet(Integer cantidadPalet) {
		this.cantidadPalet = cantidadPalet;
	}
	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}
	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
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
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}
	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	/**
	 * @return the cantidadEntregada
	 */
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}
	/**
	 * @param cantidadEntregada the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}
	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the codigoTareaRecolector
	 */
	public Long getCodigoTareaRecolector() {
		return codigoTareaRecolector;
	}
	/**
	 * @param codigoTareaRecolector the codigoTareaRecolector to set
	 */
	public void setCodigoTareaRecolector(Long codigoTareaRecolector) {
		this.codigoTareaRecolector = codigoTareaRecolector;
	}
}

