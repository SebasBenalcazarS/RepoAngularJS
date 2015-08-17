/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

/**
 * @author jvillacis
 *
 */
public class InterfacePedidoAreaTrabajoEST {
	
	private Integer nivel;
	private Integer codigoLocal;
	private Long codigoBarras;
	private Integer valorUnidadManejo;
	private Integer cantidadPedida;
	private Integer cantidadReservada;


	/**
	 * @return the nivel
	 */
	public Integer getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	/**
	 * @return the codigoBarras
	 */
	public Long getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
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
	 * @return the cantidadReservada
	 */
	public Integer getCantidadReservada() {
		return cantidadReservada;
	}
	/**
	 * @param cantidadReservada the cantidadReservada to set
	 */
	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	
}
