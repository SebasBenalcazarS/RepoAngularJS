package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;

/**
 * Almacenamiento de locales con sus ciudades
 * 
 * @author ivasquez
 *
 */
@SuppressWarnings("serial")
public class DatosLocalCiudadArticulo implements Serializable {

	private Integer codigoLocal;
	
	private String nombreLocal;
	private String ciudadLocal;
	
	private Boolean selected;
	
	private Collection<ArticuloLocalGestionPrecioDTO> fechasPlanificadas;
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	
	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	
	/**
	 * @return the nombreLocal
	 */
	public String getNombreLocal() {
		return nombreLocal;
	}
	
	/**
	 * @param nombreLocal the nombreLocal to set
	 */
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	
	/**
	 * @return the ciudadLocal
	 */
	public String getCiudadLocal() {
		return ciudadLocal;
	}
	
	/**
	 * @param ciudadLocal the ciudadLocal to set
	 */
	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = ciudadLocal;
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
	 * @return the fechasPlanificadas
	 */
	public Collection<ArticuloLocalGestionPrecioDTO> getFechasPlanificadas() {
		return fechasPlanificadas;
	}

	/**
	 * @param fechasPlanificadas the fechasPlanificadas to set
	 */
	public void setFechasPlanificadas(Collection<ArticuloLocalGestionPrecioDTO> fechasPlanificadas) {
		this.fechasPlanificadas = fechasPlanificadas;
	}
}
