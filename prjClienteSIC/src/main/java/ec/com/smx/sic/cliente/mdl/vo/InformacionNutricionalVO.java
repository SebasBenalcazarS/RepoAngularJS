package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloInformacionNutricionalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ComponenteNutricionalDTO;

@SuppressWarnings("serial")
public class InformacionNutricionalVO implements Serializable{
	
	/**
	 * componente nutricional
	 */
	private ComponenteNutricionalDTO articuloComponenteNutricionalDTO;
	
	/**
	 * informacion nutricional
	 */
	private ArticuloInformacionNutricionalDTO articuloInformacionNutricionalDTO;

	/**
	 * @return the articuloComponenteNutricionalDTO
	 */
	public ComponenteNutricionalDTO getArticuloComponenteNutricionalDTO() {
		return articuloComponenteNutricionalDTO;
	}

	/**
	 * @param articuloComponenteNutricionalDTO the articuloComponenteNutricionalDTO to set
	 */
	public void setArticuloComponenteNutricionalDTO(ComponenteNutricionalDTO articuloComponenteNutricionalDTO) {
		this.articuloComponenteNutricionalDTO = articuloComponenteNutricionalDTO;
	}

	/**
	 * @return the articuloInformacionNutricionalDTO
	 */
	public ArticuloInformacionNutricionalDTO getArticuloInformacionNutricionalDTO() {
		return articuloInformacionNutricionalDTO;
	}

	/**
	 * @param articuloInformacionNutricionalDTO the articuloInformacionNutricionalDTO to set
	 */
	public void setArticuloInformacionNutricionalDTO(ArticuloInformacionNutricionalDTO articuloInformacionNutricionalDTO) {
		this.articuloInformacionNutricionalDTO = articuloInformacionNutricionalDTO;
	}
	
}
