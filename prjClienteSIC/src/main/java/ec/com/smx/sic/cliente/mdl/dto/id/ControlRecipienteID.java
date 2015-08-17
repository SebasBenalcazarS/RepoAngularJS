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
public class ControlRecipienteID implements Serializable{
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
	public static final String NOMBRE_SECUENCIA = "SBLOGSECCONRCI";
	
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
	
}
