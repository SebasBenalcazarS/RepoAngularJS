/**
 * 
 */
package ec.com.smx.sic.cliente.common.nosql.articulo;

import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author wcaiza
 *
 */
public final class ArticuloLocalIndices {
	
	/* ################### Indices para la clase ArticuloLocalDTO ################### */
	
	/**
	 * Nombre del indice para obtener todos los art&iacute;culos que tienen una fecha inicial alcance en una determinada fecha.
	 * key = [codigoCompania,fechaIniAlc,ridArticuloLocal]
	 */
	public final static String INDEX_FECHA_INI_ALC_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.indice.fechaIniAlc.articulo");

	/**
	 * Nombre del indice para obtener todos los art&iacute;culos que tienen una fecha final alcance en una determinada fecha.
	 * key = [codigoCompania,fechaFinAlc,ridArticuloLocal]
	 */
	public final static String INDEX_FECHA_FIN_ALC_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.indice.fechaFinAlc.articulo");

	
	/**
	 * Nombre del indice para obtener todos los art&iacute;culos que hay en un local.
	 */
	public final static String INDEX_AREATRABAJO_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.indice.local.articulo");
	
	/**
	 * Nombre del indice para obtener todos los locales donde hay un art&iacute;culo
	 */
	public final static String INDEX_ARTICULO_AREATRABAJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcances.nosql.indice.articulo.local");

	
	/* ################### Indices para la clase ArticuloAreaTrabajoBitacoraDTO ################### */
	
	/**
	 * Indice artLocBitIndexRid
	 */
	public final static String INDEX_BIT_RIDARTARETRA_RIDBITARTARETRA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.bitacora.alcances.nosql.indice.rid");
	
	/**
	 * Indice artLocBitIndexLocArt
	 */
	public final static String INDEX_BIT_AREATRABAJO_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.bitacora.alcances.nosql.indice.local.articulo");
	
	/**
	 * Indice artLocBitIndexArtLoc
	 */
	public final static String INDEX_BIT_ARTICULO_AREATRABAJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.bitacora.alcances.nosql.indice.articulo.local");
	
	
	/* ################### Indices para la clase ArticuloEstablecimientoDTO ################### */
	
	/**
	 * Indice indexArticuloEstablecimiento key = [codCom, codArt, codEst, rid]
	 */
	public final static String INDEX_ARTICULO_ESTABLECIMIENTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.indice.articulo.establecimiento");
	
	/**
	 * Indice indexEstablecimientoArticulo key = [codCom, codEst, codArt, rid]
	 */
	public final static String INDEX_ESTABLECIMIENTO_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.indice.establecimiento.articulo");

}
