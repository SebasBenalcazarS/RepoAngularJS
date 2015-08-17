package ec.com.smx.sic.cliente.common.articulo;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


public enum EnumFormatoImpresionEtiquetaMercancias {
	FORMATO_UNO (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercancias.nombreFormato1")),
	FORMATO_DOS (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercancias.nombreFormato2")),
	FORMATO_TRES (SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.impresionEtiquetaMercancias.nombreFormato3"));
	
	private final String nombreFormato;
	
	/**
	 * Contructor del Enumerado.
	 * @author aquingaluisa
	 * @param nombreFormato
	 */
	private EnumFormatoImpresionEtiquetaMercancias(final String nombreFormato) {
		this.nombreFormato = nombreFormato;
	}
	
	public String getNombreFormato(){
		return this.nombreFormato;
	}
	
	public static EnumFormatoImpresionEtiquetaMercancias valueOfNombre(final String nombreFormato){
		if(StringUtils.isNotEmpty(nombreFormato)){
			for(EnumFormatoImpresionEtiquetaMercancias enumFormatoImpresionEtiquetaMercancias: EnumFormatoImpresionEtiquetaMercancias.values()){
				if(StringUtils.equals(nombreFormato, enumFormatoImpresionEtiquetaMercancias.getNombreFormato())){
					return enumFormatoImpresionEtiquetaMercancias;
				}
			}	
		}		
		return null;
	}
}
