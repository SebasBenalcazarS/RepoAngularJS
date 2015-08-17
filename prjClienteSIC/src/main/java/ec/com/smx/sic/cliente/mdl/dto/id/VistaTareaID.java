package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaTareaID extends BaseID {
	
	//campos de la tabla TareaDTO - SBTARTTAREA
	private Integer codigoCompania;
	private Long codigoTarea ;
	
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
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}
	
	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}	
	
}
