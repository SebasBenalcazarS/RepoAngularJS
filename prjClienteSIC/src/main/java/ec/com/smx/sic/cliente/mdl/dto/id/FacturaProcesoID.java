package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * FacturaProceso
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.FacturaProcesoDTO
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Embeddable
public class FacturaProcesoID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	
	/**
	 * Especifica la secuencia de la Factura
	 * 
	 */
	@Column(name = "CODIGOFACTURA", nullable = false)
	private java.lang.Long codigoFactura;
	
	
	/**
	 * Secuencial de la tabla Entrega
	 *
	 */
	@Column(name = "CODIGOASIGNACIONPROCESO", nullable = false)
	private Long codigoAsignacionProceso ;


	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * @return the codigoFacturaProceso
	 */
	public java.lang.Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFacturaProceso the codigoFacturaProceso to set
	 */
	public void setCodigoFactura(java.lang.Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return the codigoAsignacionProceso
	 */
	public Long getCodigoAsignacionProceso() {
		return codigoAsignacionProceso;
	}

	/**
	 * @param codigoAsignacionProceso the codigoAsignacionProceso to set
	 */
	public void setCodigoAsignacionProceso(Long codigoAsignacionProceso) {
		this.codigoAsignacionProceso = codigoAsignacionProceso;
	}

}
