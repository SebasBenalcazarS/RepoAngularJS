package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author srodriguez
 * 2014-09-10
*/

@SuppressWarnings("serial")
@Embeddable
public class VistaCampaniaPromocionID implements Serializable{
	
	private Integer codigoCompania;
	
	private Long codigoCampProm;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoCampProm
	 */
	public Long getCodigoCampProm() {
		return codigoCampProm;
	}

	/**
	 * @param codigoCampProm the codigoCampProm to set
	 */
	public void setCodigoCampProm(Long codigoCampProm) {
		this.codigoCampProm = codigoCampProm;
	}

}
