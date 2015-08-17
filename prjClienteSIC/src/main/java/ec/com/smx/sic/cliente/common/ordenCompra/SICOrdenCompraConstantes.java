/**
 * 
 */
package ec.com.smx.sic.cliente.common.ordenCompra;

import ec.com.smx.sic.cliente.resources.ordenCompra.SICOrdenCompraMessages;

/**
 * @author jvillacis
 *
 */
public class SICOrdenCompraConstantes {

	private static final SICOrdenCompraConstantes INSTANCIA = new SICOrdenCompraConstantes();
	
	public static SICOrdenCompraConstantes getInstancia(){
		return INSTANCIA;
	}
	
	//Proceso creacion orden de compra
	public static final String PROCESO_ORDENCOMPRA_CREACION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.proceso.creacion");
	//Funcionalidad administrar orden de compra
	public static final String FUNCIONALIDAD_ADMINISTRAR_ORDENES_COMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.funcionalidad.administrar");
	
	//Codigos catalogo valor del estado del pedido
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_ENVIADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.pedido.enviado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CONSULTADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.pedido.consultado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CERRADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.pedido.cerrado");

	//Codigos catalogo valor del estado de la orden de compra
	public static final String CODIGO_TIPO_ESTADO_ORDENCOMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoTipo.estado.ordenCompra");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENVIADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.enviada");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_PLANIFICADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.porEntregar");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENTREGADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.entregada");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_CERRADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.cerrada");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_CANCELADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.cancelada");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_NOTAPEDIDO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.notaPedido");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_PREORDEN = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.estado.ordenCompra.preOrden");

	//Codigos catalogo valor de la accion de la orden de compra
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_CREARORDEN = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.crearOrden");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_CREARNOTAPEDIDO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.crearNotaPedido");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_CREARPREORDEN = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.crearPreOrden");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_MODIFICARORDEN = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.modificarOrden");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_MODIFICARNOTAPEDIDO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.modificarNotaPedido");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_MODIFICARPREORDEN = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.modificarPreOrden");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_PLANIFICAR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.planificar");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_ENTREGAR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.entregar");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_ENTREGARPARCIAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.entregarParcial");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_ENTREGARRECEPCION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.entregarRecepcion");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_MODIFICARPLANIFICADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.modificarPlanificada");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_CERRAR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.cerrar");
	public static final String CODIGO_VALOR_ACCION_ORDENCOMPRA_ANULAR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.accion.ordenCompra.anular");
		
	//Codigos catalogo valor del tipo de orden compra
	public static final String CODIGO_VALOR_TIPO_ORDENCOMPRA_NORMAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.normal"); 
	public static final String CODIGO_VALOR_TIPO_ORDENCOMPRA_BONIFICACION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.bonificacion");
	public static final String CODIGO_VALOR_TIPO_ORDENCOMPRA_ESPECIAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.especial");

	//Codigos catalogo valor del tipo CREACION de orden compra
	public static final String CODIGO_VALOR_TIPOCREACION_ASISTIDA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoCreacion.asistida");
	public static final String CODIGO_VALOR_TIPOCREACION_PORARTICULO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoCreacion.porarticulo");
	public static final String CODIGO_VALOR_TIPOCREACION_PORARCHIVO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoCreacion.porarchivo");
	public static final String CODIGO_VALOR_TIPOCREACION_PORPLANTILLA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoCreacion.porplantilla");
	
	//Parametro de dias de caducidad proveedor
	public static final Integer VALOR_PROVEEDORIMPORTADO_FECHAENTREGA_DIASDISMINUIR = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.proveedorImportado.fechaEntrega.diasDisminuir");
	public static final Integer VALOR_PROVEEDORNACIONAL_FECHACADUCIDAD_DIASAUMENTAR = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.proveedorNacional.fechaCaducidad.diasAumentar");
	public static final Integer VALOR_PROVEEDORNACIONAL4242_FECHACADUCIDAD_DIASAUMENTAR = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.proveedorNacional4242.fechaCaducidad.diasAumentar");
	public static final Integer VALOR_PROVEEDORIMPORTADO_FECHACADUCIDAD_DIASAUMENTAR = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.proveedorImportado.fechaCaducidad.diasAumentar");
	public static final Integer VALOR_RECEPCION_FECHACADUCIDAD_DIASAUMENTAR = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.recepcion.fechaCaducidad.diasAumentar");

	//Numero de entregas permitidas actualmente en el SIC
	public static final Integer VALOR_NUMERO_MAXIMO_ENTREGAS_SIC = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.numero.maximo.entregas.sic");

	//Numero de registros permitidos en los detalles de la orden de compra del SIC
	public static final Integer VALOR_NUMERO_MAXIMO_DETALLES_SIC = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.numero.maximo.detalles.sic");

	//Extensiones de archivos
	public static final String VALOR_ARCHIVO_EXTENSION_TXT = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.extension.txt");
	public static final String VALOR_ARCHIVO_EXTENSION_XLS = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.extension.xls");
	public static final String VALOR_ARCHIVO_EXTENSION_PDF = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.extension.pdf");
	public static final String VALOR_SEPARADOR_CAMPOS_ARCHIVOS = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.separador.campos.archivos");

	//Prefijos de archivos
	public static final String VALOR_ARCHIVO_PREFIJO_PLANO_TEXTO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.prefijo.plano.texto");
	public static final String VALOR_ARCHIVO_PREFIJO_PLANO_EXCEL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.prefijo.plano.excel");
	public static final String VALOR_ARCHIVO_PREFIJO_PLANO_REPORTE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.prefijo.plano.reporte");

	//Tipos de archivos a almacenar
	public static final String VALOR_ARCHIVO_TIPO_TEXTO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.tipo.texto");
	public static final String VALOR_ARCHIVO_TIPO_EXCEL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.tipo.excel");
	public static final String VALOR_ARCHIVO_TIPO_REPORTE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.tipo.reporte");
	
	//Valores catalogo valor tipo archivos
	public static final String CODIGO_VALOR_TIPOARCHIVO_REPORTE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoArchivo.reporte");
	public static final String CODIGO_VALOR_TIPOARCHIVO_TEXTO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoArchivo.texto");
	public static final String CODIGO_VALOR_TIPOARCHIVO_EXCEL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoArchivo.excel");

	//Prefijo de la carpeta temporal y de error donde se almacenan los archivos de la orden de compra
	public static final String VALOR_ARCHIVO_CARPETA_TEMPORAL_PREFIJO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.carpeta.temporal.prefijo");
	public static final String VALOR_ARCHIVO_CARPETA_TEMPORAL_ERROR_PREFIJO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.carpeta.temporal.error.prefijo");
	public static final String VALOR_RUTA_LOCAL_ARCHIVOS = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.ruta.local.archivos");
	public static final String VALOR_RUTA_LOCAL_SEPARADOR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.separador");

	//Codigo Contenedor Seleccionado
	public static final Long CODIGO_CONTENEDOR_PORDEFECTO = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.codigo.contenedor.porDefecto").longValue(); 
	
	//Codigo de area de trabajo seleccionada por defecto
	public static final Integer CODIGO_AREATRABAJO_SELECCIONADA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.areaTrabajo.seleccionada");
	public static final Integer CODIGO_REFERENCIA_AREATRABAJO_SELECCIONADA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.areaTrabajo.seleccionada");
	//Acciones para el envio de ordendes de compra al SIC
	public static final Integer VALOR_ENVIO_INTEGRACION_SIC_ACCION_REGISTRO = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.envio.integracion.sic.accion.registro");
	public static final Integer VALOR_ENVIO_INTEGRACION_SIC_ACCION_ACTUALIZACION = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.envio.integracion.sic.accion.actualizacion");
	public static final Integer VALOR_ENVIO_INTEGRACION_SIC_ACCION_ANULACION = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.envio.integracion.sic.accion.anulacion");
	public static final Integer VALOR_ENVIO_INTEGRACION_SIC_ACCION_BASE_ENTREGAS = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.envio.integracion.sic.accion.baseEntregas");
	public static final Integer VALOR_ENVIO_INTEGRACION_SIC_ACCION_FINALIZADO = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.envio.integracion.sic.accion.finalizado");
	
	//Valores de las condiciones comerciales para la entrega de articulos
	public static final String CODIGO_VALOR_CONDICIONCOMERCIAL_ENTREGA_ACEPTADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.condicionComercial.entrega.aceptado");
	public static final String CODIGO_VALOR_CONDICIONCOMERCIAL_ENTREGA_RECHAZADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.condicionComercial.entrega.rechazado");

	//Constantes con los estados del registro sanitario
	public static final String VALOR_ESTADO_REGISTROSANITARIO_ENTRAMITE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.registroSanitario.enTramite");
	public static final String VALOR_ESTADO_REGISTROSANITARIO_RECHAZADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.registroSanitario.rechazado");
	public static final String VALOR_ESTADO_REGISTROSANITARIO_CADUCADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.registroSanitario.caducado");

	//Size articulos a enviar en la Integracion - Rotacion
	public static final Integer VALOR_INTEGRACION_ARTICULOS_ROTACION = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.integracion.rotacion");
	
	//Parametros para calculos en DIA/SEMANA/MES
	public static final Integer VALOR_INTEGRACION_PARAMETRODIA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.integracion.parametroDia");
	public static final Integer VALOR_INTEGRACION_PARAMETROSEMANA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.integracion.parametroSemana");
	public static final Integer VALOR_INTEGRACION_PARAMETROMES = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.integracion.parametroMes");
	
	//Codigos catalogo valor propiedades dinamicas bodega
	public static final String CODIGO_VALOR_DIASCADUCIDAD_MANUAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.diasCaducidad.manual");
	public static final String CODIGO_VALOR_ROTACION_SEMANAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.rotacion.semanal");
	public static final String CODIGO_VALOR_ROTACION_DIA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.rotacion.dia");
	public static final String CODIGO_VALOR_ROTACION_MENSUAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.rotacion.mensual");	

	//codigos para mensajes en el reporte de la orden de compra
	public static final String VALOR_REPORTEDIFERENTE_CODIGO_SUBBODEGA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.reporteDiferente.codigo.subbodega");
	public static final String CODIGO_TIPO_REPORTEDIFERENTE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.reporteDiferente.codigoCatalogoTipo");
	public static final String CODIGO_VALOR_REPORTEDIFERENTE = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.reporteDiferente.codigoCatalogoValor");
	
	//valor de cambio por defecto moneda sistema
	public static final Integer VALOR_MONEDA_CAMBIO_SISTEMA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.valorMoneda.cambio");
	
	//Codigo del estado del pedido del B2B
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_B2B_ENVIADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.pedido.b2b.enviado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_B2B_CONSULTADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.pedido.b2b.consultado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_B2B_CERRADO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.pedido.b2b.cerrado");

	//Codigo del estado de la orden de compra del B2B
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_B2B_CERRADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.ordenCompra.b2b.cerrada");
	public static final String CODIGO_VALOR_ESTADO_ORDENCOMPRA_B2B_ANULADA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.estado.ordenCompra.b2b.anulada");
	
    //Codigo clase articulo por defecto
	public static final String CODIGO_CLASEARTICULO_PORDEFECTO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.claseArticulo");
	public static final String CODIGO_CLASE_E = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.claseEArticulo");
	
	//Codigo notas de pedido GENERALES
	public static final String CODIGO_NOTAPEDIDO_GENERAL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.notaPedidoGeneral");
	
	//codigos tipos generacion de ordenes de compra
	public static final String LABEL_GRC_ORDEN_COMPRA = "Orden de compra";
	public static final String LABEL_GRC_NOTA_PEDIDO = "Nota de pedido";
	
	//valores de las cabeceras de creacion de orden de compra por archivo
	public static final String VALOR_CABECERA_ARCHIVO_PROVEEDOR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.validacion.cabecera.proveedor");
	
	//VALORES MIGRACION ORDEN DE COMPRA
	public static final String VALOR_MIGRACION_UNIDAD_ORDENCOMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.migracion.unidad");
	public static final String VALOR_MIGRACION_ORIGIN_ORDENCOMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.migracion.originOrder");
	public static final Integer CODIGO_OFICINAEXTERIOR_WRT = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.migracion.codigo.oficinaExterior.wrt");
	public static final Integer CODIGO_MIGRACION_ORDEN_COMPRA_PROCESADA = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.migracion.procesado");

	//LISTA DE CASOS PARA LA OBTENCION DE INFORMACION ADICIONAL DE ARTICULOS
	public static final String CASOS_INFORMACION_ADICIONAL_CREACION_ORDENCOMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.casos.informacionAdicional.creacion");
	
	public static final String  CASOS_INFORMACION_ADICIONAL_EDICION_ORDENCOMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.casos.informacionAdicional.edicion");
	
	//CODIGOS CLIENTES ORDENES COMPRA PARA LA RECEPCION
	public static final String CODIGO_CLIENTE_JUGUETON = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.cliente.wrt.jec");
	public static final String CODIGO_CLIENTE_GRAN_AKI = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.cliente.wrt.grk");
	public static final Integer CODIGO_CENTRO_DISTRIBUCION_AKI = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.codigo.centroDistribucion.aki");
	public static final String CODIGO_SUBBODEGA_JUGUETES = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.subbodega.juguetes");
			
	//Valores para truncamiento de caractares
	public static final Integer VALOR_TRUNCAMIENTO_DESCRIPCION=SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.valor.truncamiento.descripcion");
	public static final Integer VALOR_TRUNCAMIENTO_MATERIAL=SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.valor.truncamiento.material");
	
	//DIRECCION ENVIO EMAIL PARA NOIFICACIONES DE ERROR EN TAREAS DE MIGRACION
	public static final String TIPO_MIGRACION_B2B = SICOrdenCompraMessages.getInstancia().getString("mail.migracion.tipo.B2B");
	public static final String TIPO_MIGRACION_SIC = SICOrdenCompraMessages.getInstancia().getString("mail.migracion.tipo.SIC");
	public static final String TIPO_MIGRACION_MAX = SICOrdenCompraMessages.getInstancia().getString("mail.migracion.tipo.MAX");

	//VALORES PARA ACCIONES DE MIGRACION DE ORDENES DE COMPRA
	public static final Integer PEDIDO_MIGRACION_REGISTRO = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.registro"));
	public static final Integer PEDIDO_MIGRACION_ADMINISTRACION = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.administracion"));
	public static final Integer PEDIDO_MIGRACION_PRECODIFICAR = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.precodificar"));
	public static final Integer PEDIDO_MIGRACION_CODIFICAR = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.codificar"));
	public static final Integer PEDIDO_MIGRACION_ENTREGA_PENDIENTE = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.entregaPendiente"));
	public static final Integer PEDIDO_MIGRACION_ENTREGA_FINALIZADA = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.entregaFinalizada"));
	public static final Integer PEDIDO_MIGRACION_FINALIZADO = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.pedido.migracion.finalizado"));
	
	//VALOR PARA REGISTRO ORDEN DE COMPRA CODIFICADA
	public static final Integer CODIGO_VALOR_REGISTRO_ORDENCOMPRA_CODIFICADA = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.registro.codificada"));
	
	//SUBBODEGAS PERECIBLES
	public static final String CODIGOS_SUBBODEGAS_PERECIBLES = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.subbodegas.perecibles");
	
	//PARAMETROS PARA ENVIO EMAIL 
	//public String PERMITE_ENVIO_EMAIL = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.permite.envioMail");
	public static final Integer EMAIL_ENVIADO = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.email.enviado"));
	public static final Integer EMAIL_NO_ENVIADO = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.email.noenviado"));
	
	//VALOR POR DEFECTO PARA UNIDAD DE MANEJO EN JUGUETES
	public static final Integer VALOR_DEFECTO_UNIDAD_MANEJO_JUGUETES = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.valorUnidadManejo.recepcionJuguetes"));
	
	//CANTIDAD DE DECIMALES CON LAS QUE SE REALIZA LOS CALCULOS EN LA ORDEN DE COMPRA
	public static final Integer CANTIDAD_DECIMALES_CALCULO_ORDEN_COMPRA = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.calculos.cantidadDecimales"));
	public static final Integer CANTIDAD_DECIMALES_TOTAL_ORDEN_COMPRA = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.totales.cantidadDecimales"));
	public static final String FORMATO_FECHA_MIGRACION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.migracion.formatoFecha");
	
	//PATRON ORDENACION
	public static final String PATRON_ORDENAR_POR_CLASIFICACION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.orderBy.clasificacion");
	public static final String PATRON_ORDENAR_POR_SUBCLASIFICACION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.orderBy.subclasificacion");
	public static final String PATRON_ORDENAR_POR_DESCRIPCION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.orderBy.descripcion");
	public static final String PATRON_ORDENAR_POR_CODIGO_BARRAS = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.orderBy.codigoBarras");
	public static final String PATRON_ORDENAR_POR_CODIGO_UNICO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.orderBy.codigoUnico");
		
	//ERRORES EMBARQUE
	public static final String EMBARQUE_ERROR_COMPRADOR_USUARIO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.validacion.articulo.comprador.usuario");
	
	//VALOR INICIAL PORCENTAJE COMISION IMPORTADO
	public static final Integer VALOR_POR_DEFECTO_PORCENTAJE_COMISION_IMPORTADO = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.valorDefecto.porcentajeComisionImportado");
	
	//LABELS DE FILTROS DE ORDENAMIENTOS DE ARTICULOS
	public static final String LABEL_ORDENAR_POR_CODIGO_BARRAS = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.lable.ordenacion.codigoBarras");
	public static final String LABEL_ORDENAR_POR_DECRIPCION = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.lable.ordenacion.descripion");
	public static final String LABEL_ORDENAR_POR_CODIGO_UNICO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.lable.ordenacion.codigoUnico");
	
	// CONSTANTES PARA REPORTE ARCHIVO BATCH ORDEN COMPRA
	public static final String COLUMNAS_CABECERA_ARCHIVO_BATCH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel1")
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel2"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel3"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel4"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel5"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel6"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel7"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel8"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel9"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel10"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.cabecera.nivel11"));

	public static final String COLUMNAS_DETALLE_ARCHIVO_BATCH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.detalle");
	
	public static final String COLUMNAS_PIE_ARCHIVO_BATCH = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel1")
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel2"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel3"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel4"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel5"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel6"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel7"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel8"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel9"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel10"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel11"))
			.concat(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.archivo.columnas.txt.batch.pie.nivel12"));

	/*Envio de email*/
	public static final String ACCION_GENERAR_ORDEN_COMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.email.accion.generar");
	public static final String ACCION_EDITAR_ORDEN_COMPRA = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.email.accion.editar");
	public static final Integer NUMERO_REGISTROS_MAXIMO_CLAUSULA_IN = SICOrdenCompraMessages.getInstancia().getInteger("ec.com.smx.sic.ordenCompra.numero.maximo.registros.clausula.in");
	
	//Log de ordenes de compra y factura interna
	public static final String  PROCESADOS_EXITO = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.resultado.proceso.exito");
	public static final String  PROCESADOS_ERROR = SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.resultado.proceso.error");
	
}
