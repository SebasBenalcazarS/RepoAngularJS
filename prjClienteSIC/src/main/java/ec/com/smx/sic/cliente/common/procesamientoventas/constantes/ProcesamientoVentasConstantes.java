/**
 * 
 */
package ec.com.smx.sic.cliente.common.procesamientoventas.constantes;

import java.util.Locale;

import ec.com.smx.sic.cliente.resources.procesamientoventas.SICProcesamientoVentasMessages;

/**
 * @author vjaramillo
 *
 */
public final class ProcesamientoVentasConstantes {
	
	// Generales
	public static final Locale LOCALE_ES = new Locale("es", "ES");
	
	// usuario
	public static final String USUARIO_PROCESAMIENTO = "FRM0";

	// Nombre de clases
	public static final String MIGRAR_DATOS_PROCESAMIENTO_VENTAS_DTO = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.cliente.mdl.dto.migracion.migrar.datos.procesoventa.dto");
	
	// Direcciones donde se encuentran los archivos para la migracion
	public static final String PATH_DIR_PROCESADOS_FTP_SIC = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.ftp.dir.procesados");
	public static final String PATH_DIR_CONFLICTOS_FTP_SIC = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.ftp.dir.conflictos");

	// Mensaje que se van a guardar en los archivos de procesado o conflicto
	public static final String MENSAJE_GRABAR_ARCHIVO_ARTICULO_PROCESADO = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.mensaje.grabar.archivo.procesado");
	public static final String MENSAJE_GRABAR_ARCHIVO_ARTICULO_NO_EXISTE = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.mensaje.grabar.archivo.articulo.no.existe");
	public static final String MENSAJE_GRABAR_ARCHIVO_ARTICULO_CONFLICTO  = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.mensaje.grabar.archivo.conflicto");
	public static final String MENSAJE_GRABAR_ARCHIVO_ARTICULO_ERROR  = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.mensaje.grabar.archivo.error");	
	
	// Acciones que tendran los archivos de migracion: P=Procesar o R=Reprocesar
	public static final String ACCION_ARCHIVO_PROCESAR = "P";
	public static final String ACCION_ARCHIVO_REPROCESAR = "R";
	
	// Patron de fecha procesamiento ventas
	public static final String FORMATO_FECHA_DIA_MIGRACION_PROCESAMIENTO_VENTAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.formato.fecha.dia");
	public static final String FORMATO_FECHA_DIA_HORA_MIGRACION_PROCESAMIENTO_VENTAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.formato.fecha.dia.hora");
	
	// Codigo proceso copiar archivos FTP
	public static final String CODIGO_PROCESO_COPIAR_ARCHIVOS_FTP = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.migracion.ftp.codigoProceso");
	
	public static final Integer ANIOS_RETROCEDER = SICProcesamientoVentasMessages.getInstancia().getInteger("ec.com.smx.sic.procesamiento.ventas.anios.retroceder");

	// Parámetros Listado
	public static final String NUMERO_MAXIMO_DIAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.numeromaximodias.nombreParametro");
	public static final String TIPO_CONSULTA_REPORTE = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.tipoconsulta.nombreParametro");

	public static final String MENSAJE_FECHAS_OBLIGATORIAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.mensaje.fechas");
	public static final String MENSAJE_VALIDACION_FECHAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.mensaje.validacionfechas");
	public static final String MENSAJE_NUMERO_DIAS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.mensaje.numerodias");
	public static final String MENSAJE_TABLA_SIN_REGISTROS = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.mensaje.sinregistros");
	public static final String MENSAJE_TABLA_INICIO = SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.mensaje.inicio");
}
