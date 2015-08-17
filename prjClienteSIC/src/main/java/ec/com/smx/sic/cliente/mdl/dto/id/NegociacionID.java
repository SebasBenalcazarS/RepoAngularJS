package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author cbarahona
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class NegociacionID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	@Column(name="CODIGONEGOCIACION")
	private Long codigoNegociacion;
	public static final String NOMBRE_SECUENCIA = "SCCEMSECNEGOCIACION";
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoNegociacion() {
		return codigoNegociacion;
	}
	public void setCodigoNegociacion(Long codigoNegociacion) {
		this.codigoNegociacion = codigoNegociacion;
	}
}
