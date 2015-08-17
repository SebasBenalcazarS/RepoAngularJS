package ec.com.smx.sic.cliente.common.cambioprecios.beans;

public class ArticuloPrecioInflacion {
	
	private final String codigoArticulo;
	private Double precio;
	
	public ArticuloPrecioInflacion(String codigoArticulo, Double precio) {
		this.codigoArticulo = codigoArticulo;
		this.precio = precio;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
