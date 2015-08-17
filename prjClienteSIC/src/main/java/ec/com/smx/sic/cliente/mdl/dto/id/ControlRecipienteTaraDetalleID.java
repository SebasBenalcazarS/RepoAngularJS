package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ControlRecipienteTaraDetalleID implements Serializable{
	 /**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
   private Integer codigoCompania;
	
	/**
	 * Secuencial ControlRecipienteDetalle
	 * 
	 */
	@Column(name = "CODIGODETCONRECTAR", nullable = false)
	private Long codigoControlRecipienteDetalleTara;
	public static final String NOMBRE_SECUENCIA = "SBLOGSECDETCONRCITAR";
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoControlRecipienteDetalleTara() {
		return codigoControlRecipienteDetalleTara;
	}
	public void setCodigoControlRecipienteDetalleTara(Long codigoControlRecipienteDetalleTara) {
		this.codigoControlRecipienteDetalleTara = codigoControlRecipienteDetalleTara;
	}
}
