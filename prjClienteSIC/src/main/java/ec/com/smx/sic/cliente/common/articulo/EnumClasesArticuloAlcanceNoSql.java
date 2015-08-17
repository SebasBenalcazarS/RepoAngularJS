/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


/**
 * Enum con las clases noSql que se usa en el proceso de alcance de art&iacute;culos 
 * @author wcaiza
 *
 */
public enum EnumClasesArticuloAlcanceNoSql {
	
	ArticuloLocalDTO(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.className.artloc")),
	ArticuloAreaTrabajoBitacoraDTO(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.bitacora.alcances.nosql.className.artaretrabit")),
	ArticuloEstablecimientoDTO(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.className.artest")),
	;
	
	private String name;
	
	private EnumClasesArticuloAlcanceNoSql(String name) {
		this.name = name;
	}
	
	/**
	 * Nombre de la clase
	 * @return
	 */
	public String getName() {
		return this.name;
	}

}
