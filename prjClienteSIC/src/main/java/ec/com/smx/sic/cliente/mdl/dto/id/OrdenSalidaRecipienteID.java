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
public class OrdenSalidaRecipienteID implements Serializable{
	 /**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
   private Integer codigoCompania;
	
	/**
	 * Secuencial ControlRecipienteDetalle
	 * 
	 */
	@Column(name = "CODIGOORDENSALIDA", nullable = false)
	private Long codigoOrdenSalida;
	/**
	 * SECUENCIAL DE BASE
	 */
	public static final String NOMBRE_SECUENCIA = "SBLOGSECORDSAL";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoOrdenSalida() {
		return codigoOrdenSalida;
	}
	public void setCodigoOrdenSalida(Long codigoOrdenSalida) {
		this.codigoOrdenSalida = codigoOrdenSalida;
	}
	
}
