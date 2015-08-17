/**
 * 
 */
package ec.com.smx.sic.cliente.common;



import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.loggin.resources.LogUtilMessages;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;

/**
 * @author fmunoz
 * @author Mario Braganza
 *
 */
public final class SICConstantes {
	
	private static final SICConstantes INSTANCIA = new SICConstantes();
	
	
	public static final String CODIGO_SISTEMA_MAX = SICMessages.getInstancia().getString("ec.com.smx.codigo.sistema.sic");
    
	public static final String USERTYPE_COLLECTION = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType";
	
	public static final String ESPACIO = " ";
	/**
	 * Codigo Compania
	 */
	public static final Integer CODIGO_COMPANIA = 1;
	/**
	 * Estado activo numerico
	 */
	public static final String ESTADO_ACTIVO_NUMERICO = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.activo.numerico");
	/**
	 * Estado inactivo numerico
	 */
	public static final String ESTADO_INACTIVO_NUMERICO = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.inactivo.numerico");
	/**
	 * Estado activo literal
	 */
	public static final String ESTADO_ACTIVO_LITERAL = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.activo.literal");
	/**
	 * Estado inactivo literal
	 */
	public static final String ESTADO_INACTIVO_LITERAL = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.inactivo.literal");
	//otros estados
	public static final String ESTADO_VALIDO = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.valido");
	public static final String ESTADO_INVALIDO = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.invalido");
	public static final String ESTADO_TODOS_LITERAL = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.todos.literal");

	//Etiquetas Estados.
	public static final String LABEL_ESTADO_ACTIVO = SICMessages.getInstancia().getString("ec.com.smx.sic.label.estado.activo");
	public static final String LABEL_ESTADO_INACTIVO = SICMessages.getInstancia().getString("ec.com.smx.sic.label.estado.inactivo");
	public static final String LABEL_ESTADO_TODOS = SICMessages.getInstancia().getString("ec.com.smx.sic.label.estado.todos");
	
	//eventos para las operaciones de registro de datos en la base
	public static final String EVENTO_INSERTAR = "I";
	public static final String EVENTO_ACTUALIZAR = "U";
	public static final String EVENTO_VISUALIZAR = "V";
	
	//codigos tipo reportes proveedores
	public static final String CODIGO_RPT_DATOS_GENERALES_PROVEEDOR = "RPT_DATGENPRO";
	public static final String CODIGO_RPT_CONDICIONES_COMERCIALES_PROVEEDOR = "RPT_CONCOMPRO";
	public static final String CODIGO_RPT_DATOS_PRINCIPALES_PROVEEDOR = "RPT_DATPRIPRO";
	public static final String LABEL_RPT_DATOS_GENERALES_PROVEEDOR = "Datos generales proveedor";
	public static final String LABEL_RPT_CONDICIONES_COMERCIALES_PROVEEDOR = "Condiciones comerciales proveedor";
	public static final String LABEL_RPT_DATOS_PRINCIPALES_PROVEEDOR = "Datos principales articulo proveedor";
	
	//codigo tipo reportes cambio precios
	public static final String CODIGO_RCP_ARTICULO_PRECIOS = "RCP_ARTPRE";
	public static final String CODIGO_RCP_BUSQUEDA_ARTICULO_PRECIOS = "RCP_BUSARTPRE";
	public static final String CODIGO_RCP_DATOS_GENERALES_CAMBIO_PRECIO = "RCP_DATGENCAMPRE";
	public static final String CODIGO_RCP_HISTORIAL_CAMBIO_PRECIO = "RCP_HISCAMPRE";
	public static final String LABEL_RCP_DATOS_GENERALES_CAMBIO_PRECIO = "Datos generales cambio precios";
	public static final String LABEL_RCP_HISTORIAL_CAMBIO_PRECIO = "Historial cambio precios";
	
	//codigo tipo reportes ofertas
	public static final String CODIGO_ROF_BUSQUEDA_ARTICULO = "ROF_BUSART";
	
	//numero decimales usados para los calculos
	public static final Integer CANTIDADDECIMALFINAL = 2;
	public static final Integer CANTIDADDECIMALINICIAL = 5;
	public static final Integer CANTIDADDECIMALCUATRO = 4;
	public static final Integer CANTIDADDECIMALOCHO = 8;
	//valor de los tipos de desiciones
	public static final String DESICION_SI = SICMessages.getInstancia().getString("ec.com.smx.sic.desicion.si");
	public static final String DESICION_NO = SICMessages.getInstancia().getString("ec.com.smx.sic.desicion.no");
	
	/** indicador para determinar si se realiza o no la actualizacion del modelo deprecado */
	public static final String ESTADO_SINCRONIZACION_MDL = SICMessages.getInstancia().getString("ec.com.smx.sic.estado.sincronizacion.modelo");
	
	//valores por omision de los catalogos
	public static final String VALOR_NOASIGNADO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.noasignado");
	public static final Integer CODIGO_CATALOGO_OMISION = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoValorOmision");
	
	public static final String SPRING_CONTEXT_DATA_SOURCE = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.contextpath.datasource");
	
	public static final String CODIGO_SISTEMA = LogUtilMessages.getInstancia().getString("log.sistema.MAX");
	public static final String CODIGO_SISTEMA_SISPE = LogUtilMessages.getInstancia().getString("log.sistema.SISPE");
	public static final String CODIGO_SISTEMA_JARIMBA = LogUtilMessages.getInstancia().getString("log.sistema.JARIMBA");
	
	//nombre carpeta procesados
	public static final String CARPETA_PROCESADOS = "Procesados";
	
	//codigos para los niveles de la estructura comercial
	public static final String TIPCLA_DIVISION = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.division");
	public static final String TIPCLA_DEPARTAMENTO = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.departamento");
	public static final String TIPCLA_CLASIFICACION = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.clasificacion");
	public static final String TIPCLA_SUBCLA = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.subclasificacion");
	
	//valores para las acciones de control de rotulado
	public static final String CONTROL_ROTULADO_CREAR =  "CREAR";
	public static final String CONTROL_ROTULADO_EDITAR =  "EDITAR";
	
	public static final String SEPARADOR_PALABRAS = "+";	
	public static final String PREFIJO_CONSULTA = "%";
	public static final String SEPARADOR_LISTAS_POR_DEFECTO = "\\s*,\\s*";
	
	// catalogo valor Articulo Relacionada Receta
	public static final String ARTICULO_RELACIONADO_RECETA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorRelacionReceta");
	
	// catalogo valor de los tipos de ArticuloDefinicionArchivo
	public static final String IMAGEN_GENERAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorDefinicionArchivoImagen"); 
	public static final String IMAGEN_CODIGO_BARRAS = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorDefinicionArchivoImagenCodBarras");
	public static final String IMAGEN_REGISTRO_SANITARIO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorDefinicionArchivoImagenRegSan");
	public static final String DOCUMENTO_REGISTRO_SANITARIO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorDefinicionArchivoDocumentoRegSan");
	public static final Integer CODIGO_TIPO_ARCHIVOARTICULO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tiposArchivoArticulo");
	
	// Valores para datos tipo caracteristica
	public static final String CARACTERISTICA_TECNICA = SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.caracteristica.tecnica");
    public static final String CARACTERISTICA_ADICIONAL = SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.caracteristica.adicional");
    public static final String CARACTERISTICA_PREPARACION = SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.caracteristica.preparacion");
	
    //valores inciales para los ids usados en proyectos antiguos
    public static final String VALOR_INICIAL_ID = "-1";
    public static final String ESQUEMABD = SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre");
    
    // Valores para la busqueda de descuentos por asignacion
    public static final String ASIGNACION_DESCUENTO_PROVEEDOR = "PRO";
    public static final String ASIGNACION_DESCUENTO_ARTICULO = "ART";
    
    // Valores para la aplicacion de los descuentos promocion y normal
    public static final String APLICACION_DESCUENTO_PROMOCION = "PMC";
    public static final String APLICACION_DESCUENTO_NORMAL = "COM";
    
    // Estados bitacora precios
    public static final String VALOR_ESTADO_BITACORA_PRECIO_REGISTRADO = "REG";
    public static final String VALOR_ESTADO_BITACORA_PRECIO_CONFIRMADO = "CON";

    // Origen Proveedor
    public static final String ORIGEN_PROVEEDOR_NACIONAL = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional");
    public static final String ORIGEN_PROVEEDOR_NACIONAL_DESCRIPCION = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional.descripcion");
    public static final String ORIGEN_PROVEEDOR_IMPORTADO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado");
    public static final String ORIGEN_PROVEEDOR_IMPORTADO_DESCRIPCION = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado.descripcion");
    
    public static final String CODIGO_CARACTERISTICASDINAMICAS = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.caracteristicasDinamicas");
    
    public static final Integer TIPO_CONTROL_COSTO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoControlCosto");
    
    /** catalogo del agrupador de tipos de unidades de medida*/
    public static final Integer CODIGOCATALOGO_UNIDADESMEDIDA  = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.unidadesMedida");
    public static final String ENTIDAD_ANTERIOR = "ENTANT";
    
    /* TIPOS DE PROCESOS DEL SISTEMA */
    public static final Integer CODIGOPROCESOSMAX = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.procesosMAX");
   
    /*
     *INICIO: ASISTENTE COMPRAS
     */
    // C\u00F3digos para el manejo de tramas - POS
    public static final Integer TRAMA_TIPOMENSAJE_CONSULTA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.tipoMensaje.consulta");
    public static final Integer TRAMA_TIPOMENSAJE_ACTUALIZACION = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.tipoMensaje.actualizacion");
    public static final String TRAMA_CODIGOPROCESO = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.trama.codigo.proceso");
    public static final Integer TRAMA_TIPOPROCESO_CONSULTA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.tipoProceso.consulta");
    public static final Integer TRAMA_TIPOPROCESO_ACTUALIZACION = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.tipoProceso.actualizacion");
    public static final Integer TRAMA_TIPOLECTURA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.tipoLectura");
    public static final Integer TRAMA_CODIGOMONEDA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.moneda");
    public static final Integer TRAMA_TIPOMENSAJE_CONSULTA_RESPUESTA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.respuesta.tipoMensaje.consulta");
    public static final Integer TRAMA_TIPOMENSAJE_ACTUALIZACION_RESPUESTA = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.codigo.respuesta.tipoMensaje.actualizacion");
    public static final String TRAMA_CODIGORESPUESTA_APROBADO = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.trama.codigo.respuesta.aprobado");
    public static final Integer TRAMA_NUMERO_CUPONESPARTE1 = RecargaCuponMessages.getInstancia().getInteger("ec.com.smx.recargacupones.trama.numero.cuponesParte1");
    public static final String USERID = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.trama.userId");
    //C\u00F3digo proceso Recarga Cupon
    public static final String PROCESO_ENVIOARCHIVOS = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.archivo.cupones.codigo.proceso.envio");
    //C\u00F3digo Sistema Asistente compras
    public static final String SISTEMA_ASISTENTECOMPRAS = RecargaCuponMessages.getInstancia().getString("ec.com.smx.acompras.codigo.sistema");
    public static final String SISTEMA_ASISTENTECOMPRAS_MOVIL = RecargaCuponMessages.getInstancia().getString("ec.com.smx.acompras.codigo.sistema.movil");
    
    /*
     * FIN: ASISTENTE COMPRAS
     */
    
    public static final Integer CODIGO_ECUADOR_SIC = 786;
    //codigos de los tipos de equivalencia
    public static final Integer CODIGO_EQUIVALENCIA_PAISORIGEN = 4;
    
    //Valores para caracteristicas dinamicas del proveedor
 	public static final String CARACTERISTICA_FACTURA_EN_SITIO_SI = SICMessages.getInstancia().getString("ec.com.smx.sic.proveedor.caracteristica.factura.en.sitio.si");
 	public static final String CARACTERISTICA_FACTURA_EN_SITIO_NO = SICMessages.getInstancia().getString("ec.com.smx.sic.proveedor.caracteristica.factura.en.sitio.no");
    public static final String CARACTERISTICA_NOTA_CREDITO_FACTURA_SI = SICMessages.getInstancia().getString("ec.com.smx.sic.proveedor.caracteristica.nota.credito.factura.si");
    public static final String CARACTERISTICA_NOTA_CREDITO_FACTURA_NO = SICMessages.getInstancia().getString("ec.com.smx.sic.proveedor.caracteristica.nota.credito.factura.no");
     
    
    //Opciones de asignacion masiva de alcances
    public static final String ALCANCE_OPCION_ANADIR = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.opcion.anadir");
    public static final String ALCANCE_OPCION_QUITAR = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.opcion.quitar");
    public static final String ALCANCE_OPCION_REMPLAZAR = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.opcion.remplazar");

    //Nombres tablas de articulo local o bodega
    public static final String NOMBRE_TABLA_ARTICULO_LOCAL = SICMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.articulo.local");
    public static final String NOMBRE_TABLA_ARTICULO_BODEGA = SICMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.articulo.bodega");
    public static final String NOMBRE_TABLA_ARTICULO_OFICINA = SICMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.articulo.oficina");
    public static final String NOMBRE_TABLA_AREA_SUB_LUGAR_TRABAJO = SICMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.area.sub.lugar.trabajo");
    public static final String SECUENCE_TABLA_ARTICULO_LOCAL_BODEGA = SICMessages.getInstancia().getString("ec.com.smx.sic.nombre.secuence.tabla.articulo.local.bodega");
    public static final String CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE = "T1";
    public static final String CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE = "2";
    public static final String CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE = "1";
    public static final String CODIGO_ESTADO_SIC_LOCAL_NO_EXISTE = "2";
    public static final String CODIGO_ESTADO_SIC_PROTOTIPO_NO_EXISTE = "3";
    public static final String CODIGO_ESTADO_SIC_ARTICULO_NO_EXISTE = "4";
    public static final String VALOR_TAREA_RECEPCION_ANDEN = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorTareaRecepcionAnden");
    
    
    //Opciones de conflictos de alcances
    public static final String ALCANCE_CONFLICTO_AMPLIAR_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.ampliar.fecha.alcance");
    public static final String ALCANCE_CONFLICTO_AMPLIAR_DESDE_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.ampliar.desde.fecha.alcance");
    public static final String ALCANCE_CONFLICTO_AMPLIAR_HASTA_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.ampliar.hasta.fecha.alcance");
    public static final String ALCANCE_CONFLICTO_AMPLIAR_DESDE_HASTA_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.ampliar.desde.hasta.fecha.alcance");
    public static final String ALCANCE_CONFLICTO_REMPLAZAR_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.remplazar.fecha.alcance");
    public static final String ALCANCE_CONFLICTO_RESPETE_FECHA = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.conflicto.respete.fecha.alcance");
    
    //catalogos de tipo bitacora de alcances
    public static final Integer ALCANCE_CATALOGO_CODIGO_TIPO_ASIGNACION = SICMessages.getInstancia().getInteger("codigo.tipo.articulo.alcance.asignacion");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_PROTOTIPO = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_ESPECIFICOS = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_COPIA = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_OFICINAS_ESPECIFICAS = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_OFICINAS_COPIA = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_BODEGA_ESPECIFICA = SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega");
    
    //catalogo de opcion desde la que se da el alcance
    public static final Integer ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA = SICMessages.getInstancia().getInteger("codigo.tipo.articulo.alcance.bitacora");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_ERROR = SICMessages.getInstancia().getString("valor.tipo.articulo.alcance.bitacora.error");
    public static final String ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_NORMAL = SICMessages.getInstancia().getString("valor.tipo.articulo.alcance.bitacora.normal");
    
    //Valores para filtros de articulos en alcanes
    public static final String ESTADO_ARTICULO_CODIFICADO = SICMessages.getInstancia().getString("ec.com.smx.sic.alcance.estado.articulo.codificado");
    
    
    public static final String ARTICULO_ALCANCE_SERVICIO_BEAN = "sicArticuloAlcanceServicio";
    
    public static final Long CODIGO_PROCESO_AREA_TRABAJO = Long.valueOf(58);
    
    //Tipos de linea comercial
    public static final String TIPO_LINEA_COMERCIAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.linea.comercial");
    public static final String VALOR_LINEA_COMERCIAL_COMERCIAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.linea.comercial.com");
    public static final String VALOR_LINEA_COMERCIAL_LOGISTICA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valor.tipo.linea.comercial.log");
    
    public static final Integer TIPO_CATALOGO_LUGARES_TRANSACCION = 259;
  	public static final String VALOR_CATALOGO_LUGAR_TRANSACCION_FERIA = "1";
  	public static final String VALOR_CATALOGO_LUGAR_TRANSACCION_AGENDA = "2";
  	
  	//id para consulta la plantilla xsl de prototipos alcance para el envio del mail
  	public static final String CODIGO_EVENTOID_MAIL_ALCANCE_ARTICULOS = "SIC_ARLC"; 
  	//id para consulta la plantilla xsl de integracion sic para envio de mail
  	public static final String CODIGO_EVENTOID_MAIL_INTEGRACION_SIC ="ISICF_AL";
  	//id del evento para la edicion masiva de articulos
  	public static final String CODIGO_EVENTOID_MAIL_EDICION_MASIVA_ARTICULOS = "EDMAART";
    //id del evento para creacion de articulos por archivo
  	public static final String CODIGO_EVENTOID_MAIL_CREACION_ARTICULOS_POR_ARCHIVO = "CRARART";
  //id del evento para creacion de articulos por archivo
  	public static final String CODIGO_EVENTOID_MAIL_EDICION_ARTICULOS_POR_ARCHIVO = "EDARART"; 
  	//id del evento para enviar mail en envio de entregas planificadas
  	public static final String CODIGO_EVENTOID_MAIL_ENVIO_PLANIFICACION_ENTREGAS = "MAXEAPE";
  //id del evento para recibir mail en entregas planificadas
  	public static final String CODIGO_EVENTOID_MAIL_RECIBE_PLANIFICACION_ENTREGAS = "MAXRAPE";
  	//id evento para enviar mail a proveedores compracion precios.
  	public static final String CODIGO_EVENTOID_MAIL_ENVIO_COMPARACION_PRECIOS = "MAX_CP";
  	//evento de asignacion masiva de articulos
  	public static final String EVENTO_ASIGNACION = "A";
  	
  	//permite establecer una fecha menor con los dias restados
  	public static final String INACTIVACION_FECHA_INICIAL = "CURRENT_DATE - 3 DAYS";
  	public static final String INACTIVACION_FECHA_FINAL = "CURRENT_DATE - 2 DAYS";
  	
  	//REPORTE ARTICULO LOCAL
  	//Nombres de los estilos
  	public static final String ARTICULO_ALCANCE_ACTIVO = SICMessages.getInstancia().getString("reporte.articulo.alcance.activo");
  	public static final String ARTICULO_PROGRAMACION_ALCANCE = SICMessages.getInstancia().getString("reporte.articulo.programacion.alcance");
  	public static final String ARTICULO_ALCANCE_INACTIVO = SICMessages.getInstancia().getString("reporte.articulo.alcance.inactivo");
  	public static final String ARTICULO_ALCANCE_ERROR_ACTIVACION = SICMessages.getInstancia().getString("reporte.articulo.error.activacion");
  	public static final String ARTICULO_ALCANCE_ERROR_INACTIVACION = SICMessages.getInstancia().getString("reporte.articulo.error.inactivacion");
  	
  	public static final String VALOR_ACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE = "3";
  	public static final String VALOR_INACTIVO_INTEGRACION_ALCANCE_EMERGENTE_SISPE = "2";
  	
  	public static final String VALOR_USUARIO_SISPE_INTEGRACION = "SISPE";
  	
  	//Codigos tipos de reporte articulos
  	public static final String CODIGO_RPT_ARTICULO = "RPT_ART";
  	public static final String CODIGO_RPT_ARTICULO_ALCANCE = "RPT_ART_ALC";
  	public static final String CODIGO_RPT_ARTICULO_BODEGA_ALCANCE = "RPT_ART_BOD_ALC";
  	public static final String CODIGO_RPT_ARTICULO_OFICINA_ALCANCE = "RPT_ART_OFI_ALC";
  	public static final String CODIGO_RPT_ARTICULO_REGISTRO_SANITARIO = "RPT_ART_REG_SAN";
  	
  	// Sufijos para concatenar a la tabla SCSADTART
  	public static final String SUFIJO_TIPO_AREA_TRABAJO_LOCAL = "LOC";
  	public static final String SUFIJO_TIPO_AREA_TRABAJO_BODEGA = "BOD";
  	public static final String SUFIJO_TIPO_AREA_TRABAJO_OFICINA = "OFI";
  	
  	public static final Integer CODIGO_PROCESO_PERFIL_LINEA_COMERCIAL = 52;
  	
  	//Constantes despachos
  	public static final String PREFIJO_GRUPO_TRABAJO_TIPO_PRIORIDAD = SICMessages.getInstancia().getString("ec.com.smx.sic.bodega.despachos.grupotrabajo.tipo.prioridad");
  	public static final String PROPIEDAD_DINAMICA_ESTILO_NOMBRE = SICMessages.getInstancia().getString("ec.com.smx.sic.bodega.despachos.estilo.nuevolocal.variable");
  	public static final String PROPIEDAD_DINAMICA_ESTILO_VALOR = SICMessages.getInstancia().getString("ec.com.smx.sic.bodega.despachos.estilo.nuevolocal.valor");
  	
  	public static final String FACTURA_RECIBIDO_NO_FACTURADO_GUARDAR_EXITO = "exitoGuardar";
  	public static final String FACTURA_RECIBIDO_NO_FACTURADO_GUARDAR_ERROR = "errorGuardar";
  	public static final String FACTURA_RECIBIDO_NO_FACTURADO_GUARDAR_ALERTA = "alertaGuardar";
  	public static final String FACTURA_RECIBIDO_NO_FACTURADO_NUMERO_FACTURA = "numeroFactura";
  	
  	//Constantes impresion masiva
  	public static final Integer PAGINADOR_MASIVA_RANGO = 16;
  	public static final Integer CANTIDAD_IMPRESION_MAXIMA = 1000;
  	public static final String  SELECCION_SI = "SI";
    public static final String  SELECCION_NO = "NO";
    public static final String  SELECCION_TODOS = "T";
    
  //Paginacion
    public static final Integer NUMERO_REGISTROS_MAXIMO_POR_PAGINA_OC = SICMessages.getInstancia().getInteger("parametro.tamanio.paginaOC");
  	
    
    //Constantes Articulo - etiqueta
    public static final String  ARTICULO_RECIPIENTE = "07";
    
    //Combianciones de teclas
	public static final String COMBINACION_TECLA_GUARDAR = "alt+G";
  	public static final String COMBINACION_TECLA_BUSCAR = "alt+B";
  	public static final String COMBINACION_TECLA_EDITAR = "alt+E";
  	public static final String COMBINACION_TECLA_REGRESAR = "alt+R";
  	public static final String COMBINACION_TECLA_NUEVO = "alt+N";
  	public static final String COMBINACION_TECLA_ESCAPE = "ESC";
  	public static final String COMBINACION_TECLA_ELIMINAR = "alt+L";
  	public static final String COMBINACION_TECLA_ACEPTAR = "alt+A";
  	public static final String COMBINACION_TECLA_CANELAR = "alt+C";
  	public static final String COMBINACION_TECLA_IMPRIMIR = "alt+I";
  	public static final String COMBINACION_TECLA_ANULAR = "alt+U";
  	
  	public static final Integer TIPO_CARACTERISTICA_PERFIL_ORIGEN_PROVEEDOR_SERVICIOS = 9190;
  	
	private SICConstantes(){}
	
	/**
	 * @return the iNSTANCIA
	 */
	public static SICConstantes getInstancia() {
		return INSTANCIA;
	}
	
	/**
	 * 
	 * @param estadoActivoNumerico
	 * @return
	 */
	public Boolean verificarEstadoActivoNumerico(String estadoActivoNumerico){
		return verificarEstadoActivo(estadoActivoNumerico, this.ESTADO_ACTIVO_NUMERICO, this.ESTADO_INACTIVO_NUMERICO);
	}
	
	/**
	 * 
	 * @param estadoActivoLiteral
	 * @return
	 */
	public Boolean verificarEstadoActivoLiteral(String estadoActivoLiteral){
		return verificarEstadoActivo(estadoActivoLiteral.toUpperCase(), this.ESTADO_ACTIVO_LITERAL, this.ESTADO_INACTIVO_LITERAL);
	}
	
	/**
	 * 
	 * @param valorEstado
	 * @param estadoActivo
	 * @param estadoInactivo
	 * @return
	 */
	private Boolean verificarEstadoActivo(String valorEstado, String estadoActivo, String estadoInactivo){
		try {
			return BooleanUtils.toBoolean(valorEstado, estadoActivo, estadoInactivo);
		} catch (Exception e){
			return Boolean.FALSE;
		}
	}
	
	
	/**
	 * 
	 * @param valorEstado
	 * @return
	 */
	
	public Boolean esActivo(String valorEstado){
		return StringUtils.isNotEmpty(valorEstado) && (this.verificarEstadoActivoNumerico(valorEstado) || this.verificarEstadoActivoLiteral(valorEstado));
	}
	
	/**
	 * 
	 * @param valorEstado
	 * @return
	 */
	public Boolean esInactivo(String valorEstado){
		return !this.esActivo(valorEstado);
	}
	
}

