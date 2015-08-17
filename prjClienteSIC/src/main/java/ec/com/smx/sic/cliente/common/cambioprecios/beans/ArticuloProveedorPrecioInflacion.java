package ec.com.smx.sic.cliente.common.cambioprecios.beans;

public class ArticuloProveedorPrecioInflacion {
	
	private final String codigoArticulo;
	private final String codigoProveedor;
	private Double precio;
	
	public ArticuloProveedorPrecioInflacion(String codigoArticulo, String codigoProveedor, Double precio) {
		this.codigoArticulo = codigoArticulo;
		this.codigoProveedor = codigoProveedor;
		this.precio = precio;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
