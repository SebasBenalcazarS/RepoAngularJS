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
public class PedidoArchivoInformacionID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	@Column(name = "CODIGOPEDIDO")
	private Long codigoPedido;
	
	@Column(name = "CODIGOARCHIVO", nullable = false)
	private Long codigoArchivo;

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
	 * @return the codigoArchivo
	 */
	public Long getCodigoArchivo() {
		return codigoArchivo;
	}

	/**
	 * @param codigoArchivo the codigoArchivo to set
	 */
	public void setCodigoArchivo(Long codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}
	
}
