/**
 * 
 */
package ec.com.smx.sic.cliente.common.controlRutas;

import java.io.Serializable;

import ec.com.smx.sic.cliente.resources.controlRutas.SICControlRutasMessages;

/**
 * @author Esteban Gudino
 * 
 *
 */
@SuppressWarnings("serial")
public class ControlRutasUtil implements Serializable{
	
	// Codigo de tipos de catalogos
	public final static Long CODIGO_DOCUMENTO_GUIA_REMISION = Long.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.documento.guia.remision"));
	// Area de trabajo garita
	public final static Integer CODIGO_AREA_TRABAJO_GARITA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.codigo.area.trabajo.garita"));
	// Codigo de tipos de catalogos
	public final static Integer TIPO_CATALOGO_TIPOFURGON = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.furgon"));
	public final static Integer TIPO_CATALOGO_TIPOFRIO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.frio"));
	public final static Integer TIPO_CATALOGO_TIPOUSO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.uso"));
	public final static Integer TIPO_CATALOGO_TIPOESTADO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado"));
	public final static Integer TIPO_CATALOGO_CHOFER = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.chofer"));
	public final static Integer TIPO_CATALOGO_TIPO_TRANSPORTISTA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.transportista"));
	public final static Integer TIPO_CATALOGO_MARCA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.marca"));
	public final static Integer TIPO_CATALOGO_COLOR = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.color"));
	public final static Integer TIPO_CATALOGO_TIPO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.tipo"));
	public final static Integer TIPO_CATALOGO_TIPO_AREA_TRABAJO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.area.trabajo"));
	public final static Integer TIPO_CATALOGO_ORIGEN_DATO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.origen.dato"));
	public final static Integer TIPO_CATALOGO_DOCUMENTO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.documento"));
	public final static Integer TIPO_CATALOGO_EMPRESA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.empresa"));
	public final static Integer TIPO_CATALOGO_ESTADO_EMPRESA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado.empresa"));
	public final static Integer TIPO_CATALOGO_DOCUMENTO_EMPRESA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.documento.empresa"));
	public final static Integer TIPO_CATALOGO_DESTINOS_GUIA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.destinos.guia"));
	public final static Integer TIPO_CATALOGO_MOTIVOS_TRASLADO_GUIA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.motivo.traslado.guia"));
	public final static Integer TIPO_CATALOGO_ESTADO_GENERACION = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado.generacion.guia"));
	public final static Integer TIPO_CATALOGO_SISTEMAS_FACTURAN = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.sistemas.facturan"));
	public final static Integer TIPO_CATALOGO_ESTADO_RUTA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado.monitor.ruta"));
	public final static Integer TIPO_CATALOGO_ESTADO_RUTA_GENERAL = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado.rutas.general"));
	public final static Integer TIPO_CATALOGO_ESTADO_DESTINOS = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.estado.destinos"));
	public final static Integer TIPO_CATALOGO_NOVEDADES_RUTA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.novedades.monitor.ruta"));	
	public final static Integer TIPO_CATALOGO_MOVIMIENTOS_RUTA = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.monitor.movimientos"));
	public final static Integer TIPO_CATALOGO_PARTICIPANTE_REGISTRO = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.catalogo.tipo.regitro.participante"));
	
	// Codigos valores de catalogos
	public final static Integer CODIGO_AREA_TRABAJO_CENTRO_DISTRIBUCION = Integer.valueOf(SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.numerico.area.trabajo.centro.distribucion")); 
	public final static String CODIGO_CATALOGO_VALOR_UNO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.catalogo.uno");
	public final static String CODIGO_CATALOGO_VALOR_DOS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.catalogo.dos");
	public final static String CODIGO_CATALOGO_VALOR_CABEZAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.catalogo.cabezal");
	public final static String CODIGO_CATALOGO_VALOR_AREA_TRABAJO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.area.trabajo");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_AREA_TRABAJO_AGENCIA= SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.area.trabajo.agencia");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_AREA_TRABAJO_CDT = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.area.trabajo.cdt");
	public final static String CODIGO_CATALOGO_VALOR_ORIGEN_DATO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.orige.dato");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_EMPRESA_PUBLICA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.empresa.publica");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_LOCALIZACION = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.localizacion.matriz");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_EMPRESA_PRIVADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.empresa.privada");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_EMPRESA_NATURAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.empresa.natural");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_EMPRESA_INTERNACIONAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.empresa.internacional");
	public final static String CODIGO_CATALOGO_VALOR_DOCUMENTO_EMPRESA_NACIONAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.documento.empresa.nacional");
	public final static String CODIGO_CATALOGO_VALOR_DOCUMENTO_EMPRESA_INTERNACIONAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.documento.empresa.internacional");
	public final static String CODIGO_CATALOGO_VALOR_CHOFER_PRINCIPAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.chofer.principal");
	public final static String CODIGO_CATALOGO_VALOR_CHOFER_AYUDANTES = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.chofer.ayudantes");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_GENERACION_GUIA_PENDIENTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.guia.estado.pendiente");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_GENERACION_GUIA_GENERADAS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.guia.estado.generados");
	public final static String CODIGO_CATALOGO_VALOR_TRASLADO_ENTRE_ESTABLECIMIENTOS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.catalogo.traslado.establecimientos");
	public final static String CODIGO_CATALOGO_VALOR_TIPO_DESTINO_AREA_TRABAJO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.tipo.destino.area.trabajo");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_TERMINADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.terminan");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_INICIADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.iniciada");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_RUTA_ABIERTA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.gen.abierta");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_RUTA_COMPLETADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.gen.complet");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_RUTA_CANCELADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.gen.cancela");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_DESTINO_PENDIENTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.guia.estado.pendiente");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_DESTINO_TERMINADO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.ruta.terminan");
	public final static String CODIGO_CATALOGO_VALOR_ESTADO_DESTINO_ENCAMINO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.monitor.estado.destino.encamino");
	
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_CLI = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.cliente");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_PRO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.proveed");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_BEN = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.benefic");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_ATR = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.areatra");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_OCA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.ocacion");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_FIL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.filials");
	public final static String CODIGO_CATALOGO_VALOR_DESTINO_FUN = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.destino.fundaci");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_BG = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.bod.gar");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_GL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.gar.loc");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_LL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.loc.loc");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_LG = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.loc.gar");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_GP = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.gar.pro");
	public final static String CODIGO_CATALOGO_VALOR_MOVIMIENTO_GC = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.movimiento.gar.cli");
	public final static String CODIGO_CATALOGO_VALOR_PARTICIPANTE_REGISTRO_SALIDA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.participante.registro.salida");
	public final static String CODIGO_CATALOGO_VALOR_PARTICIPANTE_REGISTRO_LLEGADA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.valor.catalogo.tipo.participante.registro.llegasa");

	// Codigo de estado
	public final static String ESTADO_VALOR_ACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.activo");
	public final static String ESTADO_VALOR_INACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.inactivo");
	public final static String LABEL_ESTADO_ACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.label.activo");
	public final static String LABEL_ESTADO_INACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.label.inactivo");
	public final static String ESTADO_VALOR_NUM_ACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.numerico.activo");
	public final static String ESTADO_VALOR_NUM_INACTIVO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.estado.valor.numerico.inactivo");
	
	// Tipo reportes transportistas (Persona o Empresa)
	public final static String TIPO_REPORTE_PERSONA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.reporte.persona");
	public final static String TIPO_REPORTE_EMPRESA = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.reporte.empresa");
	public final static String TIPO_ACTIVIDAD_EMPRESA_TRANSPORTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.transportista.actividad.transporte");
	
	// Tipo contacto principal
	public final static String TIPO_CONTACTO_PRINCIPAL = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.contacto.principal");
	
	// Tipo reportes
	public final static String REPORTE_TIPO_TRANSPORTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.tipo.reporte.transporte");
	public final static String REPORTE_MARCA_TRANSPORTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.marca.reporte.transporte");
	public final static String REPORTE_COLOR_TRANSPORTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.color.reporte.transporte");
	
	// Nombres de secuencial
	public final static String NOMBRE_SECUENCIA_GUIA_TRANSPORTE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.guia.transporte");
	public final static String NOMBRE_SECUENCIA_GUIA_DESTINOS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.guia.transporte.documento");
	public final static String NOMBRE_SECUENCIA_GUIA_DOCUMENTOS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.guia.transporte.destinos");
	public final static String NOMBRE_SECUENCIA_TABLA_PARTICIPANTE_REGISTRO = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.tabla.participante.registro");
	public final static String NOMBRE_SECUENCIA_TABLA_RUTA_DESTINOS = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.tabla.ruta.destinos");
	public final static String NOMBRE_SECUENCIA_TABLA_VEHICULO_FURGON = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.tabla.vehiculo.chofer");
	public final static String NOMBRE_SECUENCIA_TABLA_CHOFER = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.tabla.chofer");
	public final static String NOMBRE_SECUENCIA_TABLA_RUTA_DETALLE = SICControlRutasMessages.getInstancia().getString("ec.com.smx.sic.control.rutas.nombres.secuencia.tabla.ruta.detalle");
	
}
