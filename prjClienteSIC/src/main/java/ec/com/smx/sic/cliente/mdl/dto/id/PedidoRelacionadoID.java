/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class PedidoRelacionadoID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	@Column(name = "CODIGOPEDIDO", nullable = false)
	private Long codigoPedido;
	
	@Column(name = "CODIGOPEDIDORELACIONADO", nullable = false)
	private Long codigoPedidoRelacionado;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoPedido
	 */
	public Long getCodigoPedido() {
		return codigoPedido;
	}

	/**
	 * @param codigoPedido the codigoPedido to set
	 */
	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	/**
	 * @return the codigoPedidoRelacionado
	 */
	public Long getCodigoPedidoRelacionado() {
		return codigoPedidoRelacionado;
	}

	/**
	 * @param codigoPedidoRelacionado the codigoPedidoRelacionado to set
	 */
	public void setCodigoPedidoRelacionado(Long codigoPedidoRelacionado) {
		this.codigoPedidoRelacionado = codigoPedidoRelacionado;
	}
	
}
