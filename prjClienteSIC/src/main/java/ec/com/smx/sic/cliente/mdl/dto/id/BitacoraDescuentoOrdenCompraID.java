package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author aquingaluisa
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class BitacoraDescuentoOrdenCompraID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="CODIGOBITDESCORDCOM")
	private Long codigoBitacoraDescuentoOrdenCompra;
	
	public static final String NOMBRE_SECUENCIA = "SCCEMSECBITDESCORDCOM";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoBitacoraDescuentoOrdenCompra() {
		return codigoBitacoraDescuentoOrdenCompra;
	}
	public void setCodigoBitacoraDescuentoOrdenCompra(Long codigoBitacoraDescuentoOrdenCompra) {
		this.codigoBitacoraDescuentoOrdenCompra = codigoBitacoraDescuentoOrdenCompra;
	}
}
