/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author osaransig
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class DatosArticuloID extends BaseID implements Serializable {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
