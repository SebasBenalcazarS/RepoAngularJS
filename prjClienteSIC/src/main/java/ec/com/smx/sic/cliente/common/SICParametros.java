/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * @author Mario Braganza
 *
 */
public final class SICParametros {

	private static final SICParametros INSTANCIA = new SICParametros();
	
	private SICParametros(){
		//
	}
	
	public static SICParametros getInstancia(){
		return INSTANCIA; 
	}
	
	public static final String PARAMETRO_INTEGRACION_SIC = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.integracion.sic");
	
	public static final String LONGITUD_CODIGO_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.longitudCodigoProveedor");
	public static final String CARACTER_RELLENO_CODIGO_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.caracterRellenoCodigoProveedor");	
	public static final String TIPO_CONTACTO_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.tipo.contacto.proveedor");
	public static final String NUMERO_DIAS_CREAR_CONTROL_ROTULADO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.numeroDiasCrearControlRotulado");
	public static final String NUMERO_DIAS_EDITAR_CONTROL_ROTULADO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.numeroDiasEditarControlRotulado");
	public static final String TIPO_CONTACTO_INTEGRACION_PORTAL = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.tipo.contacto.integracion.portal");
	public static final String CODIGOS_ESTABLECIMIENTOS_DEFECTO_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.codigos.establecimientos.defecto.proveedor");
	public static final String NIVEL_INICIO_RACK = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.rack.nivel.inicio");
	public static final String NIVEL_INCREMENTO_RACK = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.rack.nivel.incremento");
	public static final String TIEMPO_ESPERA_RECEPCION_PROVEEDOR_BODEGA_ANTES = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.rango.tiempo.espera.antes.hora");
	public static final String TIEMPO_ESPERA_RECEPCION_PROVEEDOR_BODEGA_DESPUES = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.rango.tiempo.espera.despues.hora");
	public static final String RECEPCION_PROVEEDOR_ACTIVAR_ANDENES_COMPARTIDOS = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.asignacion.andenes.compartidos.activar");
	public static final String TIEMPO_ESPERA_CONFIRMACION_ASIGNACION_ANDEN = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.tiempo.espera.confirmacion.asignacion.anden");
	
	public static final String TIPOTAREA_CONTADOR_ORDEN_RECIBIDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.tipotarea.contador.orden.recibidor");
	public static final String TIPOTAREA_CONTADOR_ORDEN_RECOLECTOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.tipotarea.contador.orden.recolector");
	public static final String TIPOTAREA_CONTADOR_ORDEN_MONTACARGUISTA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.recepcion.tipotarea.contador.orden.montacarguista");
	public static final String PORCENTAJE_AUMENTO_PRECIO_AFILIADO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.porcentaje.aumento.precioAfiliado");
	public static final String CODIGO_DESCUENTO_PRECIOMAYORISTA = "50";
	
	public static final String CALCULARCOSTONETO_CONCOMISIONIMPORTACION = "MAX26";
	public static final String CLASIFICACION_RECETASESPECIALES = "11";
	public static final String ACTIVAR_VALIDACION_CLASIFICACION_TIPO_LINEA_COMERCIAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.validacion.clasificacion.tipo.linea.comercial");
	public static final String ACTIVAR_VALIDACION_FUNCIONARIO_TIPO_LINEA_COMERCIAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.validacion.funcionario.tipo.linea.comercial");
	public static final String NIVELES_LINEA_COMERCIAL = "MAX31";
	
	//Parametros orden de compra
	public static final String MENSAJE_PORDEFECTO_REPORTE_ORDENCOMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.mensajePorDefectoReporte");
	public static final String CODIGOS_CLIENTES_CORPORACION_ORDENCOMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.codigosClientesCorporacion");
	public static final String PARAMETRO_CODIGO_MONEDA_SISTEMA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.codigoMoneda.sic");
	public static final String CODIGOS_REFERENCIAS_LINEAS_COMERCIALES_NOTAPEDIDO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.lineaComercial.notaPedido");
	public static final String CODIGOS_CLIENTES_CORPORACION_PRECODIFICADOS_ORDENCOMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.codigosClientesPrecodificado");
	public static final String DIRECCIONES_EMAIL_ERROR_MIGRACION_ORDENCOMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.migracion.direccionEmailFuncionarios");
	public static final String DIRECCIONES_EMAIL_ERROR_MIGRACION_ORDENCOMPRA_PROCESOSEXTERNOS = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.migracion.direccionEmailFuncionariosSIC");
	public static final String CODIGOS_BODEGAS_CABECERA_COSTO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.costo.codigosBodega");
	public static final String TITULO_CABECERA_COSTO_BODEGA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.costo.tituloBodega");
	public static final String TITULO_CABECERA_COSTO_NORMAL = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.costo.tituloNormal");
	public static final String PERMITE_ENVIO_EMAIL = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.permite.envioMail");
	public static final String VALIDACION_RESTRICCION_ORDENCOMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.validacion.restriccion");
	public static final String VALOR_TOLERANCIA_FACTURA_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.migracion.tolerancia.facturaProveedor");
	public static final String CALCULO_FACTURA_EN_SITIO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.migracion.factuaSitio");
	public static final String PARAMETRO_DIAS_FECHA_PUBLICACION = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.dias.fechaPublicacion");
	public static final String PARAMETRO_OMITIR_PROVEEDORES_NOTAPEDIDO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.proveedor.omitir.notaPedido");
	public static final String PARAMETRO_CARACTERES_ESPECIALES = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.caracteresEspeciales");
	public static final String PARAMETRO_OMITIR_MENSAJE_INTEGRACION_ORDEN_COMPRA = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.ordenCompra.integracion.mensajesErrorOmitir");
	
	public static final String PARAMETRO_CORRESPONDENCIA_ANDENES_CON_FURGONES = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.porcentaje.correspondencia.andenes.furgones");
	
	//parametros para la administracion de cupones
	public static final String CANTIDADARTICULOSRELACIONADOSCUPON = "MAX25";
	public static final String MAXIMO_PORCENTAJE_DESCUENTO_CUPON_IMPUESTO = "MAX14";
	public static final String MAXIMO_PORCENTAJE_DESCUENTO_CUPON_SINIMPUESTO = "MAX15";
	public static final String MAXIMO_TIEMPO_MESES_VIGENCIA_CUPON= "MAX16";
	public static final String ESTADO_PORCENTAJEDESCUENTO_CUPON= "MAX17";
	public static final String ESTADO_RELACIONVARIOSARTICULOS_CUPONVIRTUAL= "MAX18";
	public static final String CANTIDAD_REFERENCIAL_MEDICION_CONCETRACION_NUTRICIONAL= "MAX23";
	
	public static final String HORA_LLEGADA_RECEPCION_INDUSTRIA = SICMessages.getInstancia().getString("ec.com.smx.sic.recepcion.bodega.parametro.hora.llegada.industria");
	public static final String CONFIGURACION_ENTREGAS_RECEPCION = SICMessages.getInstancia().getString("ec.com.smx.sic.recepcion.bodega.parametro.configuracion.entregas.recepcion");
	
	//parametro que permite la comunicacion con el SIC
	public static final String PARAMETRO_COMUNICACION_SIC = "MAX22";
	
	// parametro que permite el proceso de migracion de ordenes de compra en Factura Digital
	public static final String PARAMETRO_MIGRACION_ORDENES_COMPRA_FACTURA_DIGITAL = "MAX36";
	public static final String PARAMETRO_HORA_MAXIMA_CONFIGURACION_ENTREGA_FACTURA_DIGITAL = "MAX37";
	public static final String PARAMETRO_HORA_MAXIMA_SOLICITUD_ANDENES_ENTREGA_FACTURA_DIGITAL = "MAX38";
	
	//parametro para CD predeterminados para dar alcance a bodegas
	public static final String PARAMETRO_CDS_PREDETERMINADOS_ALCANCE_BODEGAS = "MAX39";
	
	//parametro para realizar la validacion de que una ESTRUCTURA WRT este atada a solo una ESTRUCTURA COMERCIAL 
	public static final String PARAMETRO_VALIDACION_WRT_EC = "MAX204";
	public static final String PARAMETRO_NUMERO_MAXIMO_PERSONAS_ASIGNADAS_CLASIFICACION = "MAX223";
	
	//identificador del parametro que guarda los correos electonicos de las personas que seran notificadas cuando ocurra un error en la integracion de articulos
	public static final String CORREOS_NOTIFICACION_ERROR_INTEGRACION_ARTICULO = "MAX41";
	//identificador del parametro que guarda los correos electonicos de las personas que seran notificadas cuando ocurra un error en la migracion de articulos
	public static final String CORREOS_NOTIFICACION_ERROR_MIGRACION_ARTICULO = "MAX57";
	
	//parametros para la administracion de articulos
	public static final String PARAMETRO_MAYOREO_DIVISIONES = "MAX47";
	public static final String PARAMETRO_MAYOREO_PESO_VARIABLE_RANGO = "MAX48";	
	public static final String PARAMETRO_MAYOREO_DEPARTAMENTOS = "MAX49";		
	public static final String PARAMETRO_MAYOREO_CLASIFICACION1 = "MAX50";
	public static final String PARAMETRO_MAYOREO_CLASIFICACION2 = "MAX51";
	public static final String PARAMETRO_MAYOREO_CLASE = "MAX52";
	public static final String PARAMETRO_MAYOREO_PROVEEDOR ="MAX53";
	public static final String PARAMETRO_MAYOREO_CLASIFICACION3 = "MAX54";
	public static final String PARAMETRO_MAYOREO_SUBCLASIFICACION = "MAX55";
	public static final String PARAMETRO_MAYOREO_MARCAPROPIA = "MAX56";
	
	// parametro para aceptar una tolerancia entre los totales de factura digital MAX y Proveedor
	public static final String PARAMETRO_FACTURA_DIGITAL_PERMITIR_DIFERENCIA = "MAX43";
	// parametro con el valor de tolerancia entre los totales de factura digital MAX y Proveedor
	public static final String PARAMETRO_FACTURA_DIGITAL_VALOR_DIFERENCIA = "MAX44";
	
	// parametro para validar la fecha de inicion de operacion del proveedor
	public static final String PARAMETRO_VALIDACION_FECHA_INICIO_OPERACION_PROVEEDOR = "MAX65";
	
	
	//PARAMETRO PARA ESTABLECER EL RANGO DE REGISTROS QUE INTEGRARAN ALCANCES DE APERTURA EN LA TAREA PROGRAMADA
	public static final String PARAMETRO_PAGINADO_ALCANCES_APERTURA = "MAX205";
	//PARAMETRO PARA ESTABLECER EL RANGO DE REGISTROS QUE INTEGRARAN ALCANCES EN LA TAREA PROGRAMADA
	public static final String PARAMETRO_PAGINADO_ALCANCES = "MAX206";
	
	/**
paramAlcanceTP.getId().setCodigoParametro("MAX212");
				paramAlcanceIntTod.getId().setCodigoParametro("MAX210");
	 */
	
	
//	public final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_APERTURA_OFICINA = "MAX216";
//	public final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_APERTURA_BODEGA = "MAX217";
//	public final String PARAMETRO_INTEGRAR_TODO_APERTURA_OFICINA = "MAX218";
//	public final String PARAMETRO_INTEGRAR_TODO_APERTURA_BODEGA = "MAX219";

	
	public static final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_APERTURA_LOCAL = "MAX213";
	public static final String PARAMETRO_INTEGRAR_TODO_APERTURA_LOCAL = "MAX211";
	
	public static final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_LOCAL = "MAX212";
	public static final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_BODEGA = "MAX216";
	public static final String PARAMETRO_TAREAPROGRAMADA_EJECUCION_ALCANCE_OFICINA = "MAX217";
	
	
	public static final String PARAMETRO_INTEGRAR_TODO_ALCANCE_LOCAL = "MAX210";
	public static final String PARAMETRO_INTEGRAR_TODO_ALCANCE_BODEGA = "MAX218";
	public static final String PARAMETRO_INTEGRAR_TODO_ALCANCE_OFICINA = "MAX219";
	
	//PARAMETRO PARA CODIGOS DE REFERENCIAS DE BODEGAS
	public static final String PARAMETRO_CODIGO_BODEGA_ABASTOS = "MAX58";
	public static final String PARAMETRO_CODIGO_BODEGA_MERCANCIAS = "MAX59";
	public static final String PARAMETRO_CODIGO_BODEGA_PERECIBLES = "MAX60";
	public static final String PARAMETRO_CODIGO_BODEGA_NO_APLICA_ALCANCE = "MAX63";
	//public static final String PARAMETRO_CODIGO_BODEGA_OBLIGATORIO_ALCANCE = "MAX83";
	public static final String PARAMETRO_CODIGO_BODEGA_OBLIGATORIO_CD = "MAX84";
	
	public static final String PARAMETRO_CODIGO_PROTOTIPOS_A_IGNORAR = "MAX230";
	
	public static final String PARAMETRO_CODIGO_LOCALES_PRECIO_MAYOREO = "49";
	public static final String PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_MAYOREO = "MAX89";
	public static final String PARAMETRO_CODIGO_LOCALES_PRECIO_CAJA = "MAX72";
	public static final String PARAMETRO_CODIGO_ESTABLECIMIENTO_PRECIO_CAJA = "MAX90";
	
	
	//PARAMETRO PARA MANTENER SINCRONIZADO EL DESCUENTO DE NOTA DE CREDITO EN EL SIC
	public static final String PARAMETRO_MANTENER_SINCRONIZADO_NOTA_CREDITO_ARTICULO_VS_PROVEEDOR = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.nota.credito.sincronizado");
	
	//Parametro con la informacion de los mails notificar novedades de inconsistencias con articulos relacionados a cupones que no tengan estructura comercial cliente
	public static final String PARAMETRO_NOTIFICACION_MAILS_NOVEDADES_CUPONES = "MAX88";
	
	//PARAMETRO HORA ELIMINAR ENTREGAS CONFIRMADAS
	public static final String PARAMETRO_HORA_ELIMINAR_ENTREGAS_CONFIRMADAS_CADUCADAS = "MAX231";
	
	//Parametro para determinar a que descuento de la orden de compra se le aplica el porcentaje de convenio a proveedores
	public static final String PARAMETRO_DESCUENTO_CONVENIOS_PROVEEDORES_ORDEN_COMPRA = "MAX94";
	public static final String PARAMETRO_CONSULTA_DESCUENTO_CONVENIOS_PROVEEDORES_ORDEN_COMPRA = "MAX93";
	
	//Parametro para verificar los caracteres especiales en la descripcion del articulo
	public static final String PARAMETRO_CARACTERES_ESPECIALES_DESCRIPCION_ARTICULO = "ART7";
}
