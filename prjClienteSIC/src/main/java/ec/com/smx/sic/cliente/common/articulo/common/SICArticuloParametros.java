package ec.com.smx.sic.cliente.common.articulo.common;

import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * Singleton que representa los parametros usados en articulos
 * @author mgranda
 *
 */
public final class SICArticuloParametros {

	private static volatile SICArticuloParametros instance;

	public static final String MAXIMO_PORCENTAJE_DESCUENTO_CUPON_IMPUESTO = "MAX14";
	public static final String MAXIMO_PORCENTAJE_DESCUENTO_CUPON_SINIMPUESTO = "MAX15";
	public static final String MAXIMO_TIEMPO_MESES_VIGENCIA_CUPON = "MAX16";
	public static final String ESTADO_PORCENTAJEDESCUENTO_CUPON = "MAX17";
	public static final String ESTADO_RELACIONVARIOSARTICULOS_CUPONVIRTUAL = "MAX18";
	public static final String CANTIDAD_REFERENCIAL_MEDICION_CONCETRACION_NUTRICIONAL = "MAX23";	
	
	// parametros para la administracion de cupones
	public static final String CANTIDADARTICULOSRELACIONADOSCUPON = "MAX25";
	public static final String CALCULARCOSTONETO_CONCOMISIONIMPORTACION = "MAX26";

	// identificador del parametro que guarda los correos electonicos de las personas que seran notificadas cuando ocurra un error en la integracion
	// de articulos
	public static final String CORREOS_NOTIFICACION_ERROR_INTEGRACION_ARTICULO = "MAX41";	
	public static final String CODIGO_DIVISIONES_VALIDADAS_COSTO_PRECIO = "MAX45";
	public static final String CAMPO_IMPORTADO_POR = "MAX46";
	
	// parametros para la administracion de articulos
	public static final String PARAMETRO_MAYOREO_DIVISIONES = "MAX47";
	public static final String PARAMETRO_MAYOREO_PESO_VARIABLE_RANGO = "MAX48";
	public static final String PARAMETRO_MAYOREO_DEPARTAMENTOS = "MAX49";
	public static final String PARAMETRO_MAYOREO_CLASIFICACION1 = "MAX50";
	public static final String PARAMETRO_MAYOREO_CLASIFICACION2 = "MAX51";
	public static final String PARAMETRO_MAYOREO_CLASE = "MAX52";
	public static final String PARAMETRO_MAYOREO_PROVEEDOR = "MAX53";
	public static final String PARAMETRO_MAYOREO_CLASIFICACION3 = "MAX54";
	public static final String PARAMETRO_MAYOREO_SUBCLASIFICACION = "MAX55";
	public static final String PARAMETRO_MAYOREO_MARCAPROPIA = "MAX56";
	
	// identificador del parametro que guarda los correos electonicos de las personas que seran notificadas cuando ocurra un error en la migracion de
	// articulos
	public static final String CORREOS_NOTIFICACION_ERROR_MIGRACION_ARTICULO = "MAX57";

	//MAX61
	public static final String PARAMETRO_NUMERO_MAXIMO_BUSQUEDA_EDICIONMASIVA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.busqueda.articulos.edicion");
			
	public static final String PARAMETRO_CODIGO_BODEGA_NO_APLICA_ALCANCE = "MAX63";
	
	public static final String PARAMETRO_CODIGO_LOCALES_PRECIO_CAJA = "MAX72";
	public static final String PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_MAYOREO = "MAX89";
	public static final String PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_CAJA = "MAX90";
	public static final String PARAMETRO_CODIGO_LOCALES_PRECIO_MAYOREO = "49";
	
	//MAX74
	public static final String PARAMETRO_FECHA_LEY_MERCADO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.fecha.limite.poderMercado");
	
	//MAX75
	public static final String PARAMETRO_NUMERO_MAXIMO_ARTICULOS_INTEGRACION = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.cantidad.maxima.articulos.integracion");
		
	//Parametro con la informacion de los mails notificar novedades de inconsistencias con articulos relacionados a cupones que no tengan estructura comercial cliente
	public static final String PARAMETRO_NOTIFICACION_MAILS_NOVEDADES_CUPONES = "MAX88";
	
	//MAX91 parametro edicion de articulos - validar visualizacion datos de mercancias
	public static final String PARAMETRO_VISUALIZACION_DATOS_MERCANCIAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.validacion.articulos.edicion");
	
	//MAX214
	public static final String PARAMETRO_INGRESO_VALORES_DE_CELDAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.parametro.ingreso.datos.filas"); 
	//MAX215
	public static final String PARAMETRO_MAXIMO_FILAS_CREACION_POR_ARCHIVO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.parametro.maximo.filas"); 
  	
	//MAX220
	public static final String  EDICION_ARTICULO_EXCE_PARAMETRO_MAX_FILAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.edicion.excel.codigo.parametro.maximo.filas");
	
	public static final String PARAMETRO_CODIGO_PROTOTIPOS_A_IGNORAR = "MAX230";

	private SICArticuloParametros() {
	}

	public static SICArticuloParametros getInstance() {
		synchronized (SICArticuloParametros.class) {
			// Double check
			if (instance == null) {
				instance = new SICArticuloParametros();
			}
		}
		return instance;
	}
}
