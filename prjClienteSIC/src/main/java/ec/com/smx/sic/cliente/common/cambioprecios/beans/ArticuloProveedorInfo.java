package ec.com.smx.sic.cliente.common.cambioprecios.beans;

public class ArticuloProveedorInfo {
	
	private final String codigoArticulo;
	private final String codigoProveedor;
	
	public ArticuloProveedorInfo(String codigoArticulo, String codigoProveedor) {
		this.codigoArticulo = codigoArticulo;
		this.codigoProveedor = codigoProveedor;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}
}
