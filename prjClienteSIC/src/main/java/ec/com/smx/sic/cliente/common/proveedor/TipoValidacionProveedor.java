/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.sic.cliente.common.IValorConfiguracionBean;

/**
 * @author mbraganza
 *
 */
public class TipoValidacionProveedor implements IValorConfiguracionBean {

	private final String valorTipoValidacionProveedor;
	
	/**
	 * 
	 * @param valorTipoValidacionProveedor
	 */
	public TipoValidacionProveedor(String valorTipoValidacionProveedor){
		this.valorTipoValidacionProveedor = valorTipoValidacionProveedor;
	}
	
	
	
	
	/**
	 * @return the valorTipoValidacionProveedor
	 */
	public String getValorTipoValidacionProveedor() {
		return valorTipoValidacionProveedor;
	}



	public final static TipoValidacionProveedor DOCUMENTO = new TipoValidacionProveedor("DOC"){};
	public final static TipoValidacionProveedor CODIGO = new TipoValidacionProveedor("COD") {};
}
