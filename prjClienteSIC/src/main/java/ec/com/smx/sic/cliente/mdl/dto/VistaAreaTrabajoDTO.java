package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaAreaTrabajoDTO extends SearchDTO{

	@Id
	private Integer codigoAreaTrabajo;
	private String nombreAreaTrabajo;
	private String tipoAreaTrabajo;
	private Integer tienePerfiles;
	
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
	/**
	 * @return the nombreAreaTrabajo
	 */
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}
	/**
	 * @param nombreAreaTrabajo the nombreAreaTrabajo to set
	 */
	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}

	/**
	 * @return the tienePerfiles
	 */
	public Integer getTienePerfiles() {
		return tienePerfiles;
	}
	/**
	 * @param tienePerfiles the tienePerfiles to set
	 */
	public void setTienePerfiles(Integer tienePerfiles) {
		this.tienePerfiles = tienePerfiles;
	}
	/**
	 * @return the tipoAreaTrabajo
	 */
	public String getTipoAreaTrabajo() {
		return tipoAreaTrabajo;
	}
	/**
	 * @param tipoAreaTrabajo the tipoAreaTrabajo to set
	 */
	public void setTipoAreaTrabajo(String tipoAreaTrabajo) {
		this.tipoAreaTrabajo = tipoAreaTrabajo;
	}
	
	
}
