package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class RecepcionProveedorControlRecipienteID implements Serializable{
	/**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
   private Integer codigoCompania;
	
	/**
	 * Secuencial ControlRecipiente
	 * 
	 */
	@Column(name = "CODIGOCONTROLRECIPIENTE", nullable = false)
	private Long codigoControlRecipiente;
	
	/**
	 * Secuencial de la tabla AsignacionProceso
	 *
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR", nullable = false)
	private Long codigoRecepcionProveedor ;
	
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoControlRecipiente() {
		return codigoControlRecipiente;
	}
	public void setCodigoControlRecipiente(Long codigoControlRecipiente) {
		this.codigoControlRecipiente = codigoControlRecipiente;
	}
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}
	
}
