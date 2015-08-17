/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

/**
 * @author gaortiz
 *
 */
public class ValidacionOrigenProveedor {
	
	private OrigenProveedor origenProveedor;
	
	private Boolean tieneContactoB2B;
	
	private String mensaje;

	public ValidacionOrigenProveedor(OrigenProveedor origenProveedor,
			Boolean tieneContactoB2B, String mensaje) {
		this.origenProveedor = origenProveedor;
		this.tieneContactoB2B = tieneContactoB2B;
		this.mensaje = mensaje;
	}

	/**
	 * @return the origenProveedor
	 */
	public OrigenProveedor getOrigenProveedor() {
		return origenProveedor;
	}

	/**
	 * @return the tieneContactoB2B
	 */
	public Boolean getTieneContactoB2B() {
		return tieneContactoB2B;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

}
