/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings({ "serial"})
public abstract class DatosProveedorBase implements DatosProveedor {

	private Integer codigoJDE;
	private String nombreProveedor;
	private String numeroRUC;
	private String telefono;
	private String direccion;
	
	
	/**
	 * @return the codigoJDE
	 */
	public Integer getCodigoJDE() {
		return codigoJDE;
	}
	/**
	 * @param codigoJDE the codigoJDE to set
	 */
	public void setCodigoJDE(Integer codigoJDE) {
		this.codigoJDE = codigoJDE;
	}
	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	/**
	 * @return the numeroRUC
	 */
	public String getNumeroRUC() {
		return numeroRUC;
	}
	/**
	 * @param numeroRUC the numeroRUC to set
	 */
	public void setNumeroRUC(String numeroRUC) {
		this.numeroRUC = numeroRUC;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
