/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class FiltroCambioPrecioPorResolver implements Serializable{
	
	// Por Proveedor
	private String codigoProveedor;
	private String rucProveedor;
	private String nombreProveedor;
	
	// Por Plantilla
	private String codigoPlantilla;
	private String nombrePlantilla;
	
	private EstadoGestionPrecio estadoGestionPrecio;
	
	public FiltroCambioPrecioPorResolver(EstadoGestionPrecio estadoGestionPrecio) {
		this.estadoGestionPrecio = estadoGestionPrecio;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	public String getRucProveedor() {
		return rucProveedor;
	}
	
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getCodigoPlantilla() {
		return codigoPlantilla;
	}

	public void setCodigoPlantilla(String codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}

	public String getNombrePlantilla() {
		return nombrePlantilla;
	}

	public void setNombrePlantilla(String nombrePlantilla) {
		this.nombrePlantilla = nombrePlantilla;
	}

	public EstadoGestionPrecio getEstadoGestionPrecio() {
		return estadoGestionPrecio;
	}

	public void setEstadoGestionPrecio(EstadoGestionPrecio estadoGestionPrecio) {
		this.estadoGestionPrecio = estadoGestionPrecio;
	}

}
