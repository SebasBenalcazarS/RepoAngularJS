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
public class ControlRecipienteDetalleID implements Serializable{
	 /**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial ControlRecipienteDetalle
	 * 
	 */
	@Column(name = "CODDETCONRCI", nullable = false)
	private Long codigoControlRecipienteDetalle;
	
	
	public static final String NOMBRE_SECUENCIA = "SBLOGSECDETCONRCI";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoControlRecipienteDetalle() {
		return codigoControlRecipienteDetalle;
	}
	public void setCodigoControlRecipienteDetalle(Long codigoControlRecipienteDetalle) {
		this.codigoControlRecipienteDetalle = codigoControlRecipienteDetalle;
	}
}
