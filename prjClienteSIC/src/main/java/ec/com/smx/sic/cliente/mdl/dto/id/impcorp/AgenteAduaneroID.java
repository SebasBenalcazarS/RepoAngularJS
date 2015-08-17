/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class AgenteAduaneroID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOAGENTEADUANERO")
	private String codigoAgenteAduanero;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoAgenteAduanero
	 */
	public String getCodigoAgenteAduanero() {
		return codigoAgenteAduanero;
	}

	/**
	 * @param codigoAgenteAduanero establece el valor a la propiedad codigoAgenteAduanero
	 */
	public void setCodigoAgenteAduanero(String codigoAgenteAduanero) {
		this.codigoAgenteAduanero = codigoAgenteAduanero;
	}
	
}
