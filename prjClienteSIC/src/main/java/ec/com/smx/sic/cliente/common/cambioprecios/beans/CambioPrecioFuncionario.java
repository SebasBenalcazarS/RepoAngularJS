package ec.com.smx.sic.cliente.common.cambioprecios.beans;


import java.io.Serializable;
import java.util.Collection;


@SuppressWarnings("serial")
public class CambioPrecioFuncionario implements Serializable {
	
	private String codigoProveedor;
	private String codigoJDEProveedor;
	private String nombreProveedor;
	private String rucProveedor;	
	private String valorTipoEstado;
	private String codigoPlantilla;//codigo de referencia
	private String nombrePlantilla;

	private Long codigoGestionPrecio;//codigo gestion precio pero de la plantilla
	
	//Se usa para validar en la tabla y cargar la sub tabla con los usuarios y fechas vigencia
	private boolean seleccionado;
	
	private Collection<DetalleCambioPrecioFuncionario> detalleCambioPrecios;
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
		
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}
	
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public String getRucProveedor() {
		return rucProveedor;
	}
	
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
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

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	public Collection<DetalleCambioPrecioFuncionario> getDetalleCambioPrecios() {
		return detalleCambioPrecios;
	}

	public void setDetalleCambioPrecios(Collection<DetalleCambioPrecioFuncionario> detalleCambioPrecios) {
		this.detalleCambioPrecios = detalleCambioPrecios;
	}

	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}

	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}
}
