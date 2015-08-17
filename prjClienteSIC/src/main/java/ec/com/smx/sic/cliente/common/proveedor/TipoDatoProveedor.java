/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.sic.cliente.common.IValorConfiguracionBean;

/**
 * @author mbraganza
 *
 */
public class TipoDatoProveedor implements IValorConfiguracionBean {
	
	private final String nombreTipoDatoProveedor;
	
	public TipoDatoProveedor(String nombreTipoDatoProveedor){
		this.nombreTipoDatoProveedor = nombreTipoDatoProveedor;
	}
	
	
	
	/**
	 * @return the nombreTipoDatoProveedor
	 */
	public String getNombreTipoDatoProveedor() {
		return nombreTipoDatoProveedor;
	}
	
	



	public static final TipoDatoProveedor DATOS_GENERALES = new TipoDatoProveedor("SIC_DATOS_GENERALES"){};
	public static final TipoDatoProveedor DATOS_COMERCIALES = new TipoDatoProveedor("SIC_DATOS_COMERCIALES"){};
	public static final TipoDatoProveedor DATOS_FINANCIEROS = new TipoDatoProveedor("SIC_DATOS_FINANCIEROS"){};
	public static final TipoDatoProveedor DATOS_IMPORTACIONES = new TipoDatoProveedor("SIC_DATOS_IMPORTACIONES"){};
	public static final TipoDatoProveedor DATOS_SISTEMA_B2B = new TipoDatoProveedor("SIC_DATOS_SISTEMA_B2B"){};
	public static final TipoDatoProveedor DATOS_CARACTERISTICAS_PROVEEDOR = new TipoDatoProveedor("SIC_DATOS_CARACTERISTICAS_PROVEEDOR") {};

}
