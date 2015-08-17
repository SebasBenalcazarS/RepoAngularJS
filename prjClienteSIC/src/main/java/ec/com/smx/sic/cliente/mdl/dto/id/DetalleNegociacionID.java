package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author khidalgo
 * 2015-01-12
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleNegociacionID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="CODIGODETALLENEGOCIACION")
	private Long codigoDetalleNegociacion;
	
	public static final String NOMBRE_SECUENCIA = "SCCEMSECDETNEG";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}
	public void setCodigoDetalleNegociacion(Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}
}
