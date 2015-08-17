/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.etiquetado;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;

/**
 * @author eharo
 * 
 */
public enum EnumTransgenicoArticulo {

	NO_APLICA_TRANSGENICO(null, SICConstantes.DESICION_NO),
	SI(TipoCatalogoArticulo.VALOR_CARACTERISTICA_TRANSGENICO, SICConstantes.DESICION_SI),
	NO(TipoCatalogoArticulo.VALOR_CARACTERISTICA_NO_TRANSGENICO, SICConstantes.DESICION_NO);

	private String codigoTransgenico;
	
	private String etiquetaValorTransgenico;

	private EnumTransgenicoArticulo(String codigoTransgenico, String etiquetaValorTransgenico) {
		this.codigoTransgenico = codigoTransgenico;
		this.etiquetaValorTransgenico = etiquetaValorTransgenico;
	}

	public static EnumTransgenicoArticulo getEnumByCode(String codigoTransgenico) {
		String codigo = codigoTransgenico;
		EnumTransgenicoArticulo enumValoresTransgenicoArticulo = null;
		if (StringUtils.isNotEmpty(codigo)) {
			for (EnumTransgenicoArticulo c : EnumTransgenicoArticulo.values()) {
				if (StringUtils.equals(codigo, c.getCodigoTransgenico())) {
					enumValoresTransgenicoArticulo = c;
				}
			}
		}else{
			enumValoresTransgenicoArticulo = EnumTransgenicoArticulo.NO_APLICA_TRANSGENICO;
		}
		return enumValoresTransgenicoArticulo;
	}

	/**
	 * @return the codigoTransgenico
	 */
	public String getCodigoTransgenico() {
		return codigoTransgenico;
	}

	/**
	 * @param codigoTransgenico
	 *            the codigoTransgenico to set
	 */
	public void setCodigoTransgenico(String codigoTransgenico) {
		this.codigoTransgenico = codigoTransgenico;
	}

	public String getEtiquetaValorTransgenico() {
		return etiquetaValorTransgenico;
	}

	public void setEtiquetaValorTransgenico(String etiquetaValorTransgenico) {
		this.etiquetaValorTransgenico = etiquetaValorTransgenico;
	}
}
