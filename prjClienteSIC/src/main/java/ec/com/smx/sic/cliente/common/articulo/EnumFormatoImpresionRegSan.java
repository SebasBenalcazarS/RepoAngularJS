package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


public enum EnumFormatoImpresionRegSan {
	FORMATO_UNO (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreFormato1")),
	FORMATO_DOS (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreFormato2")),
	FORMATO_TRES (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreFormato3")),
	FORMATO_CUATRO (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreFormato4")),
	FORMATO_CINCO (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionRegistroSanitario.nombreFormato5"));
	
	private final String nombreFormato;
	
	/**
	 * Contructor del Enumerado.
	 * @author mgranda
	 * @param nombreFormato
	 */
	private EnumFormatoImpresionRegSan(final String nombreFormato) {
		this.nombreFormato = nombreFormato;
	}
	
	public String getNombreFormato(){
		return this.nombreFormato;
	}
	
	public static EnumFormatoImpresionRegSan valueOfNombre(final String nombreFormato){
		if(StringUtils.isNotEmpty(nombreFormato)){
			for(EnumFormatoImpresionRegSan enumFormatoImpresionRegSan: EnumFormatoImpresionRegSan.values()){
				if(StringUtils.equals(nombreFormato, enumFormatoImpresionRegSan.getNombreFormato())){
					return enumFormatoImpresionRegSan;
				}
			}	
		}		
		return null;
		
	}
}
