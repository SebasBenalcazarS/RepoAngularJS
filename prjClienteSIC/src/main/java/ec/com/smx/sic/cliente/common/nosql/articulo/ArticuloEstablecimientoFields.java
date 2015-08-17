/**
 * 
 */
package ec.com.smx.sic.cliente.common.nosql.articulo;


import ec.com.smx.framework.utilitario.nosql.common.constants.AuditoriaFields;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


/**
 * Atributos que se utilizan en la clase ArticuloEstablecimientoDTO de OrientDB
 * @author wcaiza
 *
 */
public class ArticuloEstablecimientoFields extends AuditoriaFields{
	
	public final static String CODIGO_COMPANIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.field.codigoCompania");
	public final static String CODIGO_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.field.codigoArticulo");
	public final static String CODIGO_ESTABLECIMIENTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.field.codigoEstablecimiento");
	public final static String ESTADO_ARTICULO_ESTABLECIMIENTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.field.estadoArticuloEstablecimiento");
	public final static String CODIGO_ARTICULO_EXTERNO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.establecimiento.nosql.field.codigoArticuloExterno");
	
}
