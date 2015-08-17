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
public class PedidoAreaTrabajoAutorizacionID implements Serializable {
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;

	@Column(name = "CODIGOPEDARETRA")
	private Long codigoPedidoAreaTrabajo;
	
	@Column(name = "CODIGOAUTORIZACION")
	private Long codigoAutorizacion;
	
	@Column(name = "CODIGOSISTEMA")
	private String codigoSistema;

	
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
	 * @return the codigoPedidoAreaTrabajo
	 */
	public Long getCodigoPedidoAreaTrabajo() {
		return codigoPedidoAreaTrabajo;
	}

	/**
	 * @param codigoPedidoAreaTrabajo the codigoPedidoAreaTrabajo to set
	 */
	public void setCodigoPedidoAreaTrabajo(Long codigoPedidoAreaTrabajo) {
		this.codigoPedidoAreaTrabajo = codigoPedidoAreaTrabajo;
	}

	/**
	 * @return the codigoAutorizacion
	 */
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	/**
	 * @param codigoAutorizacion the codigoAutorizacion to set
	 */
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
}
