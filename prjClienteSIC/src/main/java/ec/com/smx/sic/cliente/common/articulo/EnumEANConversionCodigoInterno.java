/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author jdvasquez
 *
 */
public enum EnumEANConversionCodigoInterno {
	IDENTIFICADOR_RANGO_PESO_VARIABLE(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.identificador.rango.peso.variable")),
	IDENTIFICADOR_RANGO_PESO_FIJO(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.identificador.rango.peso.fijo")),
	LONGITUD_RANGO_PESO_VARIABLE(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.longitud.rango.peso.variable")),
	LONGITUD_RANGO_PESO_FIJO(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.longitud.rango.peso.fijo")),
	LONGITUD_CODIGO_EAN(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.longitud.codigo.ean")),
	LONGITUD_CODIGO_EAN_SCANNER(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.conversion.codigo.barras.longitud.codigo.ean.scanner"));
	
	Integer parametro;
	
	EnumEANConversionCodigoInterno(Integer parametro){
		this.parametro = parametro;
	}

	/**
	 * @return the parametro
	 */
	public Integer getParametro() {
		return parametro;
	}
	
}
