
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Tarea
 * 
 * @see ec.com.smx.corpv2.dto.TipoTareaPerfilDTO
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class FacturaEstadoImpuestoID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Secuencial para la factura estado
	 *
	 */
	@Column(name = "CODIGOFACTURAESTADO", nullable = false)
	private Long codigoFacturaEstado;
	
	/**
	 * Secuencial para el tipo de impuesto
	 */
	@Column(name = "CODIGOTIPOIMPUESTO", nullable = false)
	private Integer codigoTipoImpuesto;
		
	/**
	 * @return the codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado the codigoFacturaEstado to set
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

	/**
	 * @return the codigoTipoImpuesto
	 */
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	/**
	 * @param codigoTipoImpuesto the codigoTipoImpuesto to set
	 */
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}
	
}

