package ec.com.smx.sic.cliente.common.cambioprecios.beans;

/**
 * 
 * @author dgutierrez@kruger.com.ec
 */
public class ProveedorReporteCambioPrecio {

	private String codigo;
	private String nombre;
	private String ruc;
	
	public ProveedorReporteCambioPrecio(String codigoProveedor, String nombreProveedor, String rucProveedor) {
		this.codigo = codigoProveedor;
		this.nombre = nombreProveedor;
		this.ruc = rucProveedor;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(codigo) * 31 + 2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProveedorReporteCambioPrecio) {
			return ((ProveedorReporteCambioPrecio)obj).getCodigo().equals(this.getCodigo());
		} else {
			return false;
		}
	}
	
	@Override
    public String toString() {
        return "ec.com.smx.sic.cliente.common.cambioprecios.beans.ProveedorAux[ codigo=" + codigo + " ]";
    }
}
