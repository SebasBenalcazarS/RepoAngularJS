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
public class OrdenSalidaControlRecipienteDetalleID implements Serializable{
	 /**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
   private Integer codigoCompania;
	
	
	@Column(name = "CODDETCONRCI", nullable = false)
	private Long codigoControlRecipienteDetalle;
	
	@Column(name = "CODIGODETALLEORDEN", nullable = false)
	private Long codigoOrdenDetalle;

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

	public Long getCodigoOrdenDetalle() {
		return codigoOrdenDetalle;
	}

	public void setCodigoOrdenDetalle(Long codigoOrdenDetalle) {
		this.codigoOrdenDetalle = codigoOrdenDetalle;
	}
	
	
	
}
