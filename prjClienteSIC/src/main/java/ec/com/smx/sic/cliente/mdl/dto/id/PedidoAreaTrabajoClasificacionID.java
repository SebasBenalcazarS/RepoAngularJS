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
public class PedidoAreaTrabajoClasificacionID implements Serializable{
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;

	@Column(name = "CODIGOPEDARETRA")
	private Long codigoPedidoAreaTrabajo;
	
	@Column(name = "CODIGOCLASIFICACION")
	private String codigoClasificacion;

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
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	
}
