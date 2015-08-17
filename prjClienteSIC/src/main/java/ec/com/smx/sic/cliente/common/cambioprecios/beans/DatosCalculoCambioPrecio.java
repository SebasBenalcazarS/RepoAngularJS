package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class DatosCalculoCambioPrecio implements Serializable {

	private Date fechaInicioCosto;
	private Date fechaFinCosto;
	private Set<String> codigosArticulosCambioPrecio;
	private Set<DatosArticuloOrdenCompra> datosArticulosEnOrdenCompra;


	/**
	 * @return the fechaInicioCosto
	 */
	public Date getFechaInicioCosto() {
		return fechaInicioCosto;
	}

	/**
	 * @param fechaInicioCosto the fechaInicioCosto to set
	 */
	public void setFechaInicioCosto(Date fechaInicioCosto) {
		this.fechaInicioCosto = fechaInicioCosto;
	}

	/**
	 * @return the fechaFinCosto
	 */
	public Date getFechaFinCosto() {
		return fechaFinCosto;
	}

	/**
	 * @param fechaFinCosto the fechaFinCosto to set
	 */
	public void setFechaFinCosto(Date fechaFinCosto) {
		this.fechaFinCosto = fechaFinCosto;
	}

	/**
	 * @return the codigosArticulosCambioPrecio
	 */
	public Set<String> getCodigosArticulosCambioPrecio() {
		return codigosArticulosCambioPrecio;
	}

	/**
	 * @param codigosArticulosCambioPrecio the codigosArticulosCambioPrecio to set
	 */
	public void setCodigosArticulosCambioPrecio(Set<String> codigosArticulosCambioPrecio) {
		this.codigosArticulosCambioPrecio = codigosArticulosCambioPrecio;
	}

	public Set<DatosArticuloOrdenCompra> getDatosArticulosEnOrdenCompra() {
		return datosArticulosEnOrdenCompra;
	}

	public void setDatosArticulosEnOrdenCompra(Set<DatosArticuloOrdenCompra> datosArticulosEnOrdenCompra) {
		this.datosArticulosEnOrdenCompra = datosArticulosEnOrdenCompra;
	}

}
