package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author cherrera
 * 
 */

@SuppressWarnings("serial")
@Embeddable
public class ProcesoLogisticoTransaccionID  implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla transferencia
	 * 
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO", nullable = false)
    private Long codigoProcesoLogistico;
	
	/**
	 * Secuencial de la tabla transaccion
	 * 
	 */
	@Column(name = "CODIGOTRANSACCION", nullable = false)
    private Integer codigoTransaccion;

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
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoTransaccion
	 */
	public Integer getCodigoTransaccion() {
		return codigoTransaccion;
	}

	/**
	 * @param codigoTransaccion the codigoTransaccion to set
	 */
	public void setCodigoTransaccion(Integer codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}
}
