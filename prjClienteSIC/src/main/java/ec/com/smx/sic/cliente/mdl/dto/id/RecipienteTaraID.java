package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class RecipienteTaraID implements Serializable{
	/**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
  private Integer codigoCompania;
	
	/**
	 * Secuencial ControlRecipiente
	 * 
	 */
	@Column(name = "SECUECIALRECIPIENTETARA", nullable = false)
	private Long secuencialRecipienteTara;
	public static final String NOMBRE_SECUENCIA = "SBLOGSECRCITAR";
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getSecuencialRecipienteTara() {
		return secuencialRecipienteTara;
	}
	public void setSecuencialRecipienteTara(Long secuencialRecipienteTara) {
		this.secuencialRecipienteTara = secuencialRecipienteTara;
	}
}
