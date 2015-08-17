/**
 * 
 */
package ec.com.smx.sic.cliente.common;

/**
 * @author fmunoz
 *
 */
public final class SICSecuencias {
	private static final SICSecuencias INSTANCIA = new SICSecuencias();
	/**
	 * identificador de secuencia para art�culos de peso fijos
	 */
	public static final String SEC_CODBARART1 = "SCSADSCODART1";
	/**
	 * identificador de secuencia para art�culos de peso varible por precio
	 */
	public final String SEC_CODBARART2 = "SCSADSCODART2";
	/**
	 * identificador de secuencia para art�culos de peso variable por peso
	 */
	public final String SEC_CODBARART3 = "SCSADSCODART3";
	/**
	 * identificador de secuencia para art�culos cupones electr�nicos
	 */
	public final String SEC_CODBARART4 = "SCSADSCODART4";
	/**
	 * identificador de secuencia para la migraci�n de archivos
	 */
	public final String SEC_MIGARC = "SCSADSMIGARTPRO";
	/**
	 * identificador de secuencia para la migraci�n del archivo de articulos
	 */
	public final String SEC_MIGARTGEN = "SECMIGARGE";
	/**
	 * identificador de secuencia para la migraci�n del archivo de articulos por local
	 */
	public final String SEC_MIGARTLOC = "SECMIGARLO";
	
	public final String SEC_ART_UNIDAD_MANEJO = "SCSADSARTUNIMAN";
	
	public final String SEC_AJUSTE_FACTURA_ESTADO = "SCSADSECAJUFACEST";
	
	public static final String SEC_VALIDACION_DOCUMENTO = "SCFDISECVALDOC";
	
	public static final String SEC_PERIODO_TRABAJO = "SCSADSECPERTRA";
	
	public static final String SEC_RANGO_ACCION_PERIODO = "SCSADSECRANACCPER";
	
	public static final String SEC_RESUMEN_TOTAL_DOCUMENTO = "SCFDISECRESTOTDOC";
	
	public static final String SEC_VALORES_RESUMEN_DOCUMENTO = "SCFDISECVALRESDOC";
	
	//Identificador de la tabla SCFDITFACESTDES
	public static final String SEC_FACTURA_ESTADO_DESCUENTO = "SCFDISECFACESTDES";
	
	private SICSecuencias(){
		//
	}
	
	public static SICSecuencias getInstancia(){
		return INSTANCIA; 
	}
}
