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
public class OrdenSalidaRecipienteDetalleID implements Serializable{
	/**
	  * Codigo de compania
	  */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGODETALLEORDEN", nullable = false)
	private Long codigoOrdenDetalle;
	public static final String NOMBRE_SECUENCIA = "SBLOGSECDETORDSAL";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoOrdenDetalle() {
		return codigoOrdenDetalle;
	}
	public void setCodigoOrdenDetalle(Long codigoOrdenDetalle) {
		this.codigoOrdenDetalle = codigoOrdenDetalle;
	}
	
}
