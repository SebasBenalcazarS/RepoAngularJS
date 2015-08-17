package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Collection;

/**
 * Almacenamiento de establecimientos
 * 
 * @author ivasquez
 *
 */
@SuppressWarnings("serial")
public class DatosEstablecimientoArticulo implements Serializable {

	private Integer codigoEstablecimiento;
	
	private String nombreEstablecimiento;
	
	private Boolean selected;
	
	private Collection<DatosLocalCiudadArticulo> localesCiudadArticulo;

	
	/*
	 * GETTERS AND SETTERS
	 */
	
	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	/**
	 * @return the nombreEstablecimiento
	 */
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	/**
	 * @param nombreEstablecimiento the nombreEstablecimiento to set
	 */
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	/**
	 * @return the selected
	 */
	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the localesCiudadArticulo
	 */
	public Collection<DatosLocalCiudadArticulo> getLocalesCiudadArticulo() {
		return localesCiudadArticulo;
	}

	/**
	 * @param localesCiudadArticulo the localesCiudadArticulo to set
	 */
	public void setLocalesCiudadArticulo(Collection<DatosLocalCiudadArticulo> localesCiudadArticulo) {
		this.localesCiudadArticulo = localesCiudadArticulo;
	}
}
