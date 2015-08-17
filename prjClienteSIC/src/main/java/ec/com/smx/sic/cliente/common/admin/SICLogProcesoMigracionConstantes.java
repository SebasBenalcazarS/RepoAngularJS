/**
 * 
 */
package ec.com.smx.sic.cliente.common.admin;

import ec.com.smx.sic.cliente.resources.admin.SICLogProcesoMigracionMessages;

/**
 * @author aguato
 *
 */
public class SICLogProcesoMigracionConstantes {

	//Instancia unica
	private static final SICLogProcesoMigracionConstantes INSTANCIA = new SICLogProcesoMigracionConstantes();
		
	public static SICLogProcesoMigracionConstantes getInstancia(){
		return INSTANCIA;
	}
	
	// CODIGOS DE PROCESOS
	public static final Long CODIGO_PROCESO_MIGRACION_FACTURA_INTERNA = Long.valueOf(SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.proceso.migracionFacturaInterna"));
	public static final Long CODIGO_PROCESO_MIGRACION_ORDEN_COMPRA = Long.valueOf(SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.proceso.migracionOrdenCompra"));
	
	//CODIGOS DE RESULTADOS DEL PROCESO
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_GENERAL = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.general");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_FACTURA_INTERNA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.facturaInterna");
	
	//MIGRACION FACTURA INTERNA
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_NO_TOTAL_ARCHIVOS = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.noTotalArchivos");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_PROVEEDOR_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.proveedorNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_SUBBODEGA_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.subbodegaNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_BODEGA_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.bodegaNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_CD_NO_ASOCIADO_A_BODEGA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.cdNoAsociadoABodega");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_BODEGA_NO_RELACIONADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.bodegaNoRelacionada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_TIPO_FACTURA_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.tipoFacturaNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_FACTURA_YA_CREADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.facturaYaCreada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_TIPO_TRANSACCION_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.tipoTransaccionNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_IMPUESTO_NO_OBTENIDO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.impuestoNoObtenido");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_LISTADO_ENTREGAS_NO_OBTENIDO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.listadoEntregasNoObtenido");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_PARAMETRO_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.parametroNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_FACTURA_EN_SITIO_NO_OBTENIDA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.facturaEnSitioNoObtenida");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_PARAMETRO_TOLERANCIA_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.parametroToleranciaNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_HORA_ENTREGA_NO_CONFIGURADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.horaEntregaNoConfigurada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ENTREGA_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.entregaNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_CONSULTAR_FACTURA_EN_SITIO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.consultarFacturaEnSitio");
	
	public static final String CODIGO_RESULTADO_PROCESO_EXITO_FACTURA_INTERNA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.exito.facturaInterna");
	public static final String CODIGO_RESULTADO_PROCESO_EXITO_ORDEN_COMPRA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.exito.ordenCompra");
	
	
	//MIGRACION ORDEN COMPRA
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_FACTURA_INTERNA_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.facturaInternaNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ORDEN_COMPRA_NO_ENCONTRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.ordenCompraNoEncontrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ORDEN_COMPRA_YA_MIGRADA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.ordenCompraYaMigrada");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ORDEN_COMPRA_ESTADO_PLANIFICADO_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.ordenCompraEstadoPlanificadoNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_CODIGO_PEDIDO_NO_COINCIDE = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.codigoPedidoNoCoincide");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_CODIGO_ORDEN_COMPRA_NO_COINCIDE = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.codigoOrdenCompraNoCoincide");
	
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ARTICULO_CON_UNIDAD_MANEJO_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.articuloUnidadManejoNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_PARAMETRO_MONEDA_SISTEMA_NO_ENCONTRADO = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.parametroMonedaSistemaNoEncontrado");
	public static final String CODIGO_RESULTADO_PROCESO_ERROR_ENTREGA_ORDENES_COMPRA = SICLogProcesoMigracionMessages.getInstancia().getString("ec.com.smx.sic.logProcesoMigracion.resultadoProceso.error.entregaOrdenesCompra");
	
}
