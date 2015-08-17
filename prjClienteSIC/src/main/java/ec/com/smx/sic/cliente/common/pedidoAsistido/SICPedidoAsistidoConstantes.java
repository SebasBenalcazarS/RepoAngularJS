package ec.com.smx.sic.cliente.common.pedidoAsistido;

import ec.com.smx.sic.cliente.resources.pedidoAsistido.SICPedidoAsistidoMessages;


/**
 * 
 * @author amunoz
 *
 */
public class SICPedidoAsistidoConstantes {

	//Instancia unica
	private static final SICPedidoAsistidoConstantes INSTANCIA = new SICPedidoAsistidoConstantes();
	
	public static SICPedidoAsistidoConstantes getInstancia(){
		return INSTANCIA;
	}
	
	//Codigo de la opcion de pedido asistido
	public static final String CODIGO_OPCION_PEDIDO=SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.opcion.creacionPedido");
	
	//Codigo de la opcion de pedido asistido
	public static final String CODIGO_VALOR_INACTIVO=SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.valor.invalido");
		
 	/*CONFIGURACION PEDIDO ASISTIDO*/
	//Codigos catalogo valor del proceso de configuracion de pedido asistido
	public static final String CODIGO_VALOR_PROCESO_CONFIGURACION = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigosCatalogoValor");
	public static final String CODIGO_TIPO_PROCESO_CONFIGURACION = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigosCatalogoTipo");
	public static final Long CODIGO_PROCESO_PEDIDO_ASISTIDO = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo"));
	public static final Long CODIGO_PROCESO_HORA_MAXIMA_TRANSMISION = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.horaTransmision"));
	public static final Long CODIGO_PROCESO_DIA_DESPACHO = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.diaDespacho"));
	public static final Long CODIGO_PROCESO_DIA_RECEPCION = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.diaRecepcion"));
	public static final Long CODIGO_PROCESO_DOBLE_PEDIDO = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.doblePedido"));
	public static final Long CODIGO_PROCESO_BLOQUEO_PEDIDO = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.bloqueoPedido"));
	public static final Long CODIGO_PROCESO_ARCHIVO_INTERFACE_PEDIDO_ASISTIDO = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.proceso.codigo.archivoInterface"));
	
	//Codigos perfiles
	public static final String CODIGO_PERFIL_COMERCIAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.comercial");
	public static final String CODIGO_PERFIL_BODEGA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.bodega");
	public static final String CODIGO_PERFIL_LOCAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.local");
	public static final String CODIGO_PERFIL_SISTEMAS = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.sistemas");
	public static final String CODIGO_PERFIL_ADMINISTRADOR_LOCAL=SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.admin.local");
	
	//Nombre perfiles
	public static final String NOMBRE_PERFIL_COMERCIAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.comercial.nombre");
	public static final String NOMBRE_PERFIL_BODEGA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.bodega.nombre");
	public static final String NOMBRE_PERFIL_LOCAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.local.nombre");
	public static final String NOMBRE_PERFIL_SISTEMAS = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.sistemas.nombre");
	public static final String NOMBRE_PERFIL_ADMIN_LOCAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.perfil.admin.local.nombre");
	
	// Codigo tipo pedido asistido
	public static final Integer CODIGO_TIPO_PEDIDO_ASISTIDO = SICPedidoAsistidoMessages.getInstancia().getInteger("ec.com.smx.sic.pedidoAsistido.codigoTipoPedidoAsistido");
	//Codigos tipos de pedido asistido
	public static final String CODIGO_VALOR_TIPO_PEDIDO_ASISTIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.tipo.pedido.asistido");
	public static final String CODIGO_VALOR_TIPO_DOBLE_PEDIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.tipo.pedido.doble");
	public static final String CODIGO_VALOR_TIPO_PEDIDO_EXTRA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.tipo.pedido.extra");
	public static final String CODIGO_VALOR_TIPO_PEDIDO_APERTURA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.tipo.pedido.apertura");
	
	// Codigo tipo estado de pedido asistido
	public static final Integer CODIGO_TIPO_ESTADOS_PEDIDO=SICPedidoAsistidoMessages.getInstancia().getInteger("ec.com.smx.sic.pedidoAsistido.codigoTipoEstadoPedido");
	//Codigos estado de pedido asistido
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_SIN_PEDIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.sinPedido");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_NO_PEDIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.noPedido");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_INGRESADO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.ingresado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CONFIRMADO_EL_INGRESO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.confirmado.el.ingreso");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CONFIRMADO_POR_ADMINISTRADOR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.confirmado.por.administrador");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CONFIRMADO_FORZADO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.confirmado.forzado");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_CORREGIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.corregido");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_ELIMINADO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.eliminado");
	public static final String CODIGO_VALOR_ESTADO_CAMBIO_HORA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.cambioHora");
	public static final String CODIGO_VALOR_ESTADO_CAMBIO_FECHA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.cambioFecha");
	public static final String CODIGO_VALOR_ESTADO_PEDIDO_INTERFACE = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.estado.interface");
	
	//Codigo tipo accion pedido asistido
	public static final Integer CODIGO_TIPO_ACCION_PEDIDO = SICPedidoAsistidoMessages.getInstancia().getInteger("ec.com.smx.sic.pedidoAsistido.accion.codigoTipo");
	//Codigos valor de las acciones del pedido asistido
	public static final String CODIGO_VALOR_ACCION_PEDIDO_CREAR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.crear");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_MODIFICAR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.modificar");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_CONFIRMAR_USUARIO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.confirmarUsuario");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_CONFIRMAR_ADMINISTRADOR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.confirmarAdministrador");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_CORREGIR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.corregir");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_ELIMINAR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.eliminar");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_NO_PEDIR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.noPedir");
	public static final String CODIGO_VALOR_ACCION_PEDIDO_PEDIR = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.pedir");
	public static final String CODIGO_VALOR_ACCION_CAMBIAR_HORA= SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.cambioHora");
	public static final String CODIGO_VALOR_ACCION_CAMBIAR_FECHA= SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.accion.codigoValor.cambioFecha");
	
	// Rango (porcentaje valido) entrega detalles vistos y los no vistos
	public static final Double RANGO_PORCENTAJE_DETALLES_REVISADOS = Double.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.rangoPorcentajeDetallesRevisados"));
	
	// Valor maximo dias configuracion
	public static final Integer VALOR_NUMERO_MAXIMO_DIAS_CONFIGURACION = SICPedidoAsistidoMessages.getInstancia().getInteger("ec.com.smx.sic.pedidoAsistido.configuracion.numero.maximo.dias");
	
	// Codigos area trabajo BODEGAS
	public static final String CODIGO_AREA_TRABAJO_BODEGA_PERECIBLES = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.areatrabajo.bodega.perecibles");
	
	// Codigo tipo autorizacion - solicitud pedido extra
	public static final Long CODIGO_TIPO_AUTORIZACION_PEDIDO_EXTRA = Long.valueOf(SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.autorizaciones.codigo.tipo.autorizacion"));
	
	// Clase temporada
	public static final String CODIGO_CLASE_TEMPORADA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.clase.temporada");
	// Clase no obsoleta no resurtibkle
	public static final String CODIGO_CLASE_NOOBS_NORES = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.clase.noObsoletaNoResurtible");
	// Clase mercancia obsoleta
	public static final String CODIGO_CLASE_OBSOLETA = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigo.clase.obsoleta");
	
	// Paginacion monitoreo
	public static final Integer VALOR_PAGINACION_MONITOREO = SICPedidoAsistidoMessages.getInstancia().getInteger("ec.com.smx.sic.pedidoAsistido.monitoreo.valor.paginacion");
	
	//Codigo catalogo valor de la caracteristica de la subbodega que SI genera orden de compra
	public static final String CODIGO_VALOR_CARACTERISTICA_ARETRA_GENORDCOM_SI = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.caracteristica.subbodega.generaoc.si");
	
	//Estados del proceso de interface de pedidos
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_REGISTRADO = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.registrado");
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_GENERANDOARCHIVO = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.generandoArchivo");
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_ARCHIVOEGENERADO = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.archivoGenerado");
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_PROCESADOSIC = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.procesado.sic");
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_GENERANDOOC = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.generandoOC");
	public static final Character CODIGO_INTERFACE_PROCESO_ESTADO_OCGENERADA = SICPedidoAsistidoMessages.getInstancia().getCharacter("ec.com.smx.sic.pedidoAsistido.interface.proceso.estado.OCGenerada");
	
	//Marca del detalle para saber si fue generado por pedido fijo
	public static final String MARCA_DETALLE_POR_PEDIDO_FIJO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.marca.detalle.por.pedidoFijo");
	
	//Codigo catalogo valor del tipo de servidor LOCAL
	public static final String CODIGO_VALOR_TIPO_SERVIDOR_LOCAL = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.codigoValor.tipoServidor.local");
	
	//Valor aplica doble pedido
	public static final String VALOR_DOBLEPEDIDO_APICA_SI = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.valor.doblePedido.aplica.si");
	public static final String VALOR_DOBLEPEDIDO_APICA_NO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.valor.doblePedido.aplica.no");
	
	// Constante para identificar metodos de pedido asistido en trabajos calendarizados
	public static final String PREFIJO_METODO_PEDIDO_ASISTIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.pedidoAsistido.prefijo.obtenerInformacionArticuloPedidoAsistido");
	
	public static final String PREFIJO_METODO_MONITOREO_PEDIDO_ASISTIDO = SICPedidoAsistidoMessages.getInstancia().getString("ec.com.smx.sic.monitoreoPedido.prefijo.obtenerMonitoreoPedidoAsistido");
}
