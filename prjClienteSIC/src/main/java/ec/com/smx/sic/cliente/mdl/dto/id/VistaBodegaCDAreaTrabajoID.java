package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaBodegaCDAreaTrabajoID extends BaseID {
	
	/**
	 * Codigo de la compania
	 */
	private Integer codigoCompania;
	
	/**
	 * Codigo del area de trabajo
	 */
	private Integer codigoAreaTrabajo ;
	
	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * 
	 * @param codigoCompania the codigoCompania set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

}
