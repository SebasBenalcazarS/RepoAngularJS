/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FormatoNegocioDTO;
import ec.com.smx.corpv2.dto.LocalDTO;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
public class FormatoNegocioVO extends BaseVO<FormatoNegocioDTO>{

	private Collection<LocalDTO> locales;
	private Boolean isSelected = Boolean.FALSE;
	public Collection<LocalDTO> getLocales() {
		return locales;
	}

	public void setLocales(Collection<LocalDTO> locales) {
		this.locales = locales;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
}
