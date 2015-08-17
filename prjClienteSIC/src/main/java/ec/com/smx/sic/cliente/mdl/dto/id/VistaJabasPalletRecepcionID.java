/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class VistaJabasPalletRecepcionID extends BaseID{
	
	private Integer codigoCompania;
	private Long codigoControlRecipienteDetalleTara;
	
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
	 * @return the codigoControlRecipienteDetalleTara
	 */
	public Long getCodigoControlRecipienteDetalleTara() {
		return codigoControlRecipienteDetalleTara;
	}

	/**
	 * @param codigoControlRecipienteDetalleTara the codigoControlRecipienteDetalleTara to set
	 */
	public void setCodigoControlRecipienteDetalleTara(Long codigoControlRecipienteDetalleTara) {
		this.codigoControlRecipienteDetalleTara = codigoControlRecipienteDetalleTara;
	}
	
}
