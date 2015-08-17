package ec.com.smx.sic.cliente.common.convenio;

import java.math.RoundingMode;

import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.sic.cliente.resources.convenios.SICConvenioMessages;

/**
 * @author srodriguez
 * 2014-09-10
*/

public class ConveniosConstantes {
	
	private static final ConveniosConstantes INSTANCIA = new ConveniosConstantes();
		
	/**
	 * @return the iNSTANCIA
	 */
	public static ConveniosConstantes getInstancia() {
		return INSTANCIA;
	}

	public static final String PARAMETRO_BUSQUEDA_CARACTER_LIKE=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.parametro.busqueda.caracter.like");
	/**VALORES TIPO CATALOGO **/
	public static final Integer CODIGO_TIPO_ESTADO_PROCESO_PROMOCION = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.estado.proceso.promocion");
	public static final Integer CODIGO_TIPO_FORMA_COBRO_PROMOCION = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.forma.cobro.promocion");
	public static final Integer CODIGO_TIPO_PERIODICIDAD_COBRO_PROMOCION = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.periocidad.cobro.promocion");
	public static final Integer CODIGO_TIPO_PLAZO_COBRO_PROMOCION = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.plazo.cobro.promocion");
	public static final Integer CODIGO_TIPO_CONDICION_COBRO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.condicion.cobro");
	public static final Integer CODIGO_TIPO_INICIO_COBRO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.inicio.cobro");
	public static final Integer CODIGO_TIPO_APLICACION_DESCUENTOS = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.aplicacion.descuentos");
	public static final Integer CODIGO_TIPO_INICIO_COBRO_CAMPANIA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.inicio.cobro.campania");
	public static final Integer ESTADO_CADUCIDAD_CAMPANIA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.estado.caducidad.campania");
	public static final Integer CODIGO_TIPO_PERIODICIDAD_COBRO_PROMOCION_VENTA_COSTO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.cobro.promocion.venta.costo");
	public static final Integer CODIGO_TIPO_FORMA_VENTA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.forma.venta");
	public static final Integer POSICION_UNICA_ARREGLO_CAMPANIAS=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.mercadeo.posicion.unica.arreglo.coleccion.campanias");
	public static final Integer TIPO_CATALOGO_CENTROS_COSTO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.centro.costo");
	public static final Integer TIPO_ESTADO_REGISTRO_COBRO_PROVEEDOR = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.estasdos.registro.proveedores");
	public static final Integer TIPO_CATALOGO_NEGOCIACION_COSTO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.forma.cobro.costo");
	
	/** CATALOGOS TIPOS DE COBROS NEGOCIACION AL COSTO**/
	public static final String CATALOGO_VALOR_COSTO_AUTOLIQUIDABLE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.cobro.proveedor.valor.catalogo.costo.autoliquidable");
	public static final String CATALOGO_VALOR_COSTO_MAXICOMBO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.cobro.proveedor.valor.catalogo.costo.maxicombos");
	
	public static final String ESTADO_ACTIVO_CAMPANIA_WS_LOYALTY=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.activo.campania.ws.loyalty");
	public static final String ESTADO_VENCIDA_CAMPANIA_WS_LOYALTY=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.vencida.campania.ws.loyalty");
	public static final String ESTADO_PLANIFICADA_CAMPANIA_WS_LOYALTY=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.planificada.campania.ws.loyalty");
	public static final String ESTADO_CANCELADA_CAMPANIA_WS_LOYALTY=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.cancelada.campania.ws.loyalty");
	public static final String ESTADO_SUSPENDIDA_CAMPANIA_WS_LOYALTY=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.suspendida.campania.ws.loyalty");
	public static final String ESTADO_SIN_COBRO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.estado.sinCobro.campania.ws.loyalty");
	
	/**PERIORICIDADES CORTE**/
	public static final String SEMANAL=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.peridiocidad.corte.semanal");
	public static final String QUINCENAL =SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.peridiocidad.corte.quincenal");;
	public static final String MENSUAL=SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.peridiocidad.corte.mensual");;
		
	/**TIPO FORMA COBRO**/
	public static final String MONTO_FIJO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.monto.fijo");
	public static final String PORCENTAJE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.porcentaje");
	public static final String COSTO_POR_ARTICULO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.costo.articulo");
	public static final String COSTO_POR_ORDEN_COMPRA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.costo.ordencompra");
		
	/**FORMAS DE COBRO**/
	public static final String FACTURA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.factura");
	public static final String ORDEN_COMPRA =SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.ordencompra");
	public static final String COSTO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.costo");
	public static final String TIPO_FORMA_VENTA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.venta") ;
	public static final String TIPO_FORMA_COSTO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.costo") ;
	public static final String TIPO_FORMA_PARTICIPANTE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.participacion") ;
//	public static final Integer TIPO_FORMA_ORDEN_COMPRA =SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.comercial.codigo.tipo.forma.cobro");
	public static final String TIPO_FORMA_ORDEN_COMPRA =SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.ordencompra");
	public static final String TIPO_FORMA_ARTICULO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.forma.cobro.articulo");
	
	/**TIPO APLICACION DESCUENTOS**/
	public static final String DESCUENTO_ARTICULO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.costo.articulo");
	public static final String DESCUENTO_ORDEN_COMPRA =SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipoFormaCobro.costo.ordencompra");
		
	/** (NEGOCIACION) VALORES TIPO INICIO COBRO **/
	public static final String VALOR_TIPO_INICIO_COBRO_INICIO_PROMOCION = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.fecha.inicio.cobro");
	public static final String VALOR_TIPO_INICIO_COBRO_FIN_PROMOCION = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.fecha.fin.cobro");
	public static final String VALOR_TIPO_INICIO_COBRO_FECHA_ESPECIFICA_PROMOCION = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.valor.tipo.fecha.especifico.cobro");
	
	/**ESTADO DE CADUCIDAD DE LA CAMPANIA**/
	public static final Integer ESTADO_WARNING_CADUCIDAD_CAMPANIA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.comercial.valor.caducidad.campania.warning");
	public static final Integer ESTADO_ERROR_CADUCIDAD_CAMPANIA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.comercial.valor.caducidad.campania.error");;
	
	/** ESATDOS DE REGISTROS DE COBRO **/
	public static final String VALOR_TIPO_ESTADO_COBRO_PENDIENTE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.catalogo.valor.estado.cobro.pendiente");
	public static final String VALOR_TIPO_ESTADO_COBRO_PREFACTURADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.catalogo.valor.estado.cobro.prefacturado");
	public static final String VALOR_TIPO_ESTADO_COBRO_RECHAZADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.catalogo.valor.estado.cobro.rechazado");
	//public static final String VALOR_TIPO_ESTADO_COBRO_PENDIENTE_PREFACTURADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.catalogo.valor.estado.cobro.pendiente.prefacturado");
	/** GRUPO TIPO IMPUESTOS **/
	public static final String GRUPO_TIPO_IMPUESTO_IVA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.procesamiento.informacaion.grupo.tipo.impuesto");
	public static final Integer TIPO_IMPUESTO_IVA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.valor.tipo.impuestos.coniva");
	public static final Integer TIPO_IMPUESTO_SIN_IVA = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.valor.tipo.impuestos.siniva");
	
		
	/**CONFIGURACION DATOS CONSULTA PARAMETROS LOYALTY**/
	public static final Integer PARAMETRO_LOYALTY_LOG_VALIDED=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.loyalty.log.valided");
	public static final Integer PARAMETRO_LOYALTY_LOG_LCATEGORY=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.loyalty.log.lcategory");
	public static final Integer CODIGO_CUENTA_CONTABLE_MERCADEO= SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.cuetasContables.mercadeo");
	public static final Integer CODIGO_CUENTA_CONTABLE_COMERCIAL= SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.cuetasContables.comercial");	
	  	
	/**CONFIGURACION DE RECUPERACION DE VENTAS*/
	public static final Integer NUMERO_DECIMALES_MONEDA= SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.numero.decimales.moneda");
	public static final RoundingMode METODO_REDONDEO = RoundingMode.HALF_UP;
	public static final Integer RECUPERACION_VENTAS_NUMERO_ELEMENTOS_SELECCION_UNO=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.numero.elementos.seleccion.uno");
	public static final Integer RECUPERACION_VENTAS_NUMERO_ELEMENTOS_SELECCION_DIEZ=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.numero.elementos.seleccion.diez");
	public static final Integer RECUPERACION_VENTAS_NUMERO_ELEMENTOS_SELECCION_CIEN=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.numero.elementos.seleccion.cien");
	public static final Integer RECUPERACION_VENTAS_NUMERO_ELEMENTOS_SELECCION_MIL=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.parametro.numero.elementos.seleccion.mil");
	public static final Integer RECUPERACION_VENTAS_NUMERO_PASO_DIAS=SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.recuperacion.ventas.numero.paso.dias");
	
	// Identificadores auditoria cambios en pantalla
	public static final String ACCESITEMID_CONFIGURACION_COBRO_PROVEEDORES = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.accesitemid");
	public static final String IDENTIFICADOR_AUDITORIA_COBRO_PROVEEDORES = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.identificador.auditoria");
	/**PROCESAMIENTO DE COBRO A LOS PARTICIPANTES**/
	public static final Integer NUMERO_INICIO_AUMENTO_CUOTA=SICConvenioMessages.getInstancia().getInteger("smx.configuracion.cobro.proveedores.cobro.negociacion.numero.cuota");

	/** TIPO PROMOCION **/
    public static final Integer CODIGO_TIPO_PROMOCION_CUPON = SICConvenioMessages.getInstancia().getInteger("smx.configuracion.cobro.proveedores.codigo.tipo.promocion.cupon");
    public static final String VALOR_TIPO_PROMOCION_CUPON = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.valor.promocion.cupon");
    public static final String VALOR_DESENCADENANTE_CUPON = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.valor.desencadenante.cupon");
    public static final Integer CODIGO_COMPANIA = 1;
    //public static final Integer CODIGO_PROCESO_CONVENIO_COBRO_PROVEEDORES = SICConvenioMessages.getInstancia().getInteger("smx.configuracion.cobro.proveedores.codigo.proceso");
    public static final String CODIGO_PROCESO_CONVENIO_COBRO_PROVEEDORES = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.proceso");
    public static final String CODIGO_PARAMETRO_NUMERO_MAXIMO_CUOTAS_NEGOCIACION = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.negociacion.codigo.parametro.numero.maximo.cuotas");
    
    /**
     * Errores al momento de facturar
     */
    public static final String VALOR_ERROR_CLIENTE_NO_ENCONTRADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.cliente.error.valor");
    public static final String VALOR_ERROR_CLIENTE_OFICINAEXTERIOR_NO_ENCONTRADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.clienteExterior.error.valor");
    public static final Integer TIPO_ERROR_CLIENTE_NO_ENCONTRADO = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.cliente.error.tipo");
    public static final String DESCRIPCION_ERROR_CLIENTE_NO_ENCONTRADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.cliente.error.valor.descripcion");
    public static final String DESCRIPCION_ERROR_CLIENTE_OFICINAEXTERIOR_NO_ENCONTRADO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.clienteExterior.error.descripcion");
    
    /**
     * Validaciones
     */
    public static final Integer NUMERO_MAXIMO_CUOTAS = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.negociacion.numero.maximo.cuotas");
	
	// CONSTANTES ENVIO DE MAIL
	public static final String ENVIO_MAIL_PARA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.recuperacion.ventas.destinatarios");
	//public static final String ENVIO_MAIL_LOGO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.recuperacion.ventas.envio.mail.logo");
	public static final String ENVIO_MAIL_LOGO  = MensajeriaMessages.getString("ec.com.smx.mensajeria.DIRECTORIO_IMAGENES").concat(MensajeriaMessages.getString("ec.com.smx.mensajeria.SEPARADOR")).concat(MensajeriaMessages.getString("ec.com.smx.mensajeria.SEPARADOR")).concat("LOGO.gif");
	public static final String ENVIO_MAIL_EVENTO = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.codigoevento");
	public static final String ENVIO_MAIL_EVENTO_RECUPERACION = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.codigorecupe");
	public static final String ENVIO_MAIL_ASUNTO = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntocorreo");
	public static final String ENVIO_MAIL_ASUNTO_PROCESAMIENTO_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntosatisf");
	public static final String ENVIO_MAIL_DESCRIPCION_PROCESAMIENTO_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.descripcion.procesamiento.satisfactorio");
	public static final String ENVIO_MAIL_ASUNTO_RECUPERACION = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntorecupe");
	public static final String ENVIO_MAIL_ASUNTO_RECUPERACION_ERROR = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntoserror");
	public static final String ENVIO_MAIL_ASUNTO_REPROCESAMIENTO = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntoreproc");
	public static final String ENVIO_MAIL_ASUNTO_RECUPERACION_ARTICULOS_NO_EXISTENTES = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.asuntosartic");
	public static final String ENVIO_MAIL_DESCRIPCION = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.notificaion.mail.detalecorreo");
	
	// PARAMETROS PARA EL ENVIO DE EMAILS
	public static final String PARAMETRO_ENVIO_MAIL_SATISFACTORIO_RECUPERACION_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.notificaion.mail.recuperacion.correcto");
	public static final String PARAMETRO_ENVIO_MAIL_ERROR_RECUPERACION_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.notificaion.mail.recuperacion.erroneos");
	public static final String PARAMETRO_ENVIO_MAIL_SATISFACTORIO_PROCESAMIENTO_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.notificaion.mail.procesamiento.correcto");
	public static final String PARAMETRO_ENVIO_MAIL_ERROR_PROCESAMIENTO_VENTAS = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.notificaion.mail.procesamiento.erroneos");
	
	public static final String CODIGO_PARAMETRO_TIPO_VALIDACION_ASIGNAR_PARTICIAPANTES = SICConvenioMessages.getInstancia().getString("smx.configuracion.campania.codigo.parametros.tipoValidacion");
	public static final String TIPO_ERROR_INFO = SICConvenioMessages.getInstancia().getString("smx.configuracion.campania.tipoError.info");
	public static final String TIPO_ERROR_ERROR = SICConvenioMessages.getInstancia().getString("smx.configuracion.campania.tipoError.error");
	
	
	public static final Integer CODIGO_TIPO_GENERAR_FECHAS_NEGOCIACION = SICConvenioMessages.getInstancia().getInteger("smx.configuracion.cobro.proveedores.codigo.tipo.estado.generar.fechas");
	public static final String CODIGO_VALOR_GENERAR_FECHAS = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.valor.estado.generar.fechas.generar");
	public static final String CODIGO_VALOR_NO_GENERAR_FECHAS = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.valor.estado.generar.fechas.noGenerar");
	
	public static final String CODIGO_PARAMETRO_ACTUALIZAR_MARGEN_REAL = SICConvenioMessages.getInstancia().getString("ec.com.smx.max.codigo.parametro.actualizar.margen.real.por.articulo");
	
	public static final Integer CODIGO_TIPO_ARTICULO_CUPON = SICConvenioMessages.getInstancia().getInteger("smx.configuracion.cobro.proveedores.codigo.tipo.articulo.cupon");
	public static final String CODIGO_VALOR_ARTICULO_CUPON_FISICO = SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.valor.articulo.cupon.fisico");
	public static final String CODIGO_VALOR_ARTICULO_CUPON_VIRTUAL= SICConvenioMessages.getInstancia().getString("smx.configuracion.cobro.proveedores.codigo.valor.articulo.cupon.virtual");
	
	public static final String CODIGO_PARAMETRO_ARTICULO_CUPON_FISICO= SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.prefijo.cupo.fisico");
	public static final String CODIGO_PARAMETRO_ARTICULO_CUPON_VIRTUAL= SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.prefijo.cupo.virtual");
	
	public static final String CODIGO_ARTICULO_PRUEBAS_LOYALTY = SICConvenioMessages.getInstancia().getString("smx.convenios.proveedores.parametro.codigo.local.pruebas.loyalty");
	public static final Integer NUMERO_HILOS_EJECUTADOS = SICConvenioMessages.getInstancia().getInteger("smx.convenios.proveedores.parametro.numero.hilos.recuperacion.ventas.loyalty");
}
