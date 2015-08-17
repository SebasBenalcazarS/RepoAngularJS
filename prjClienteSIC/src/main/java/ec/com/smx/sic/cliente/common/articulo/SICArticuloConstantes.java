/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;

/**
 * @author fmunoz
 *
 */
public final class SICArticuloConstantes {

	private static final SICArticuloConstantes INSTANCIA = new SICArticuloConstantes();
	
	//codigos para los tipos de articulo
	public static final String CODIGO_TIPOARTICULO_PRODUCTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.producto");
	public static final String CODIGO_TIPOARTICULO_SERVICIO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.servicio");
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente");
	public static final String CODIGO_TIPOARTICULO_CUPON = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.cupon");
	//Tipos nuevos creados para la administracion de recipientes (Tienen como padre el tipo de articulo 07)		
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE_JABA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.jaba");
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE_PALLET = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.pallet");
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE_PROCONA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.procona");
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE_BIN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.bin");
	public static final String CODIGO_TIPOARTICULO_RECIPIENTE_GAVETA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.gaveta");
	public static final String CODIGO_TIPOARTICULO_REFRIGERADOR_DE_CONGELADOS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.tipoArticulo.recipiente.refrigerado");
	
	//codigos para los tipos de precio
	public static final String TIPO_PRECIO_BASE = "BAS";
	public static final String TIPO_PRECIO_PVP = "PVP";
	public static final String TIPO_PRECIO_CAJA = "CAJ";
	public static final String TIPO_PRECIO_MAYORISTA = "MAY";
	public static final String TIPO_PRECIO_INTPRO = "INT";
	public static final String TIPO_PRECIO_COSTO_BRUTO = "CSB";
	public static final String TIPO_PRECIO_COSTO_NETO = "CSN";
	public static final String TIPO_PRECIO_MARGEN_PVP = "MPP";
	public static final String TIPO_PRECIO_MARGEN_BASE = "MPB";
	public static final String TIPO_PRECIO_FAC_IMP_COSTO_BRUTO = "FCB";
	public static final String TIPO_PRECIO_FAC_IMP_PVP = "FPP";
	public static final String TIPO_PRECIO_FAC_IMP_SMX = "FPS";
	public static final String TIPO_PRECIO_BASE_DESCUENTO_DIARIO = "PDD";
	public static final String TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_DIARIO = "PRD";
	public static final String TIPO_PRECIO_BASE_DESCUENTO_ACUMULADO = "PDA";
	public static final String TIPO_PRECIO_BASE_COBRO_RECUPERACION_DESCUENTO_ACUMULADO = "PRA";

	//codigos para los tipos de codigo de barras en el MAX
	public static final String TIPO_CODBAR_EAN = "EAN";
	public static final String TIPO_CODBAR_EAN14 = "EAN14";
	public static final String TIPO_CODBAR_EAN128 = "EAN128";
	public static final String TIPO_CODBAR_INTERNO = "INT";
	//codigos para los tipos de codigo de barras en el SIC
	public static final String TIPO_CODBAR_INTERNO_SIC = "1";
	public static final String TIPO_CODBAR_ORIGEN_SIC = "2";

	//valores para las unidades de medida
	public static final String TIPOMEDIDA_UNIDAD = "u";
	public static final String TIPOMEDIDA_NOAPLICA_SIC = "x";
	
	/**
	 * c&oacute;digo del tipo de cat&aacute;logo para las secuencias internas
	 */
	public static final Integer TIPOCATALOGO_SECUENCIAINTERNA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoSecuenciaInterna");
	/**
	 * tipo de secuencia para los articulos que son abarrotes en general(Mercancia)
	 */
	public static final String TIPSECART_PESOFIJO = "1";
	/**
	 * tipo de secuencia para los articulos de pesos por precio (peso variable)
	 */
	public static final String TIPSECART_PESOPRECIO = "2";
	/**
	 * tipo de secuencia para los articulos de tipo cupones electronicos de promici&oacute;n
	 */
	public static final String TIPSECART_CUPONELECTRONICO = "3";
	/**
	 * tipo de secuencia para los articulos de tipo cupones especiales
	 */
	public static final String TIPSECART_CUPONESPECIAL= "5";
	
	/**
	 * tipo de secuencia para los articulos de tipo AUTOLIQUIDABLE
	 */
	public static final String TIPSECART_AUTOLIQUIDABLE= "6";
	
	/**
	 * tipo de secuencia para los articulos de tipo MAXICOMBO
	 */
	public static final String TIPSECART_MAXICOMBO= "7";
	
	public static final String LEYENDA_CADA_KILO = "Cada Kilo";
	
	//tipos de control de costo
	public static final String TIPCONCOS_PIEPES = SICArticuloMessages.getInstancia().getString("catalogo.valor.tipoControlPrecio.pieza-peso");
	public static final String TIPCONCOS_PIEPIE = SICArticuloMessages.getInstancia().getString("catalogo.valor.tipoControlPrecio.pieza-pieza");
	public static final String TIPCONCOS_PESPES = SICArticuloMessages.getInstancia().getString("catalogo.valor.tipoControlPrecio.peso-peso");
	public static final String TIPCONCOS_PIEPESUM = SICArticuloMessages.getInstancia().getString("catalogo.valor.tipoControlPrecio.pieza-peso-uniman");
	
	public static final String PRECIOCANTIDAD = "Precio x Cantidad";
	public static final String PRECIOCANTIDADPESO = "Precio x Cantidad x Peso";
	public static final String PRECIOPESOTOTAL = "Precio x Peso";

	//constantes para el tipo de marca comercial
	public static final String PAISORIGEN_OMISION = "ECU";
	public static final String MARCAPROPIA="PRO";
	public static final String MARCAPROVEEDOR="PRV";
	//codigos para los tipos de impuesto
	public static final Integer TIPOIMPUESTO_OMISION_IVA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.ValorAgregado.omision");
	public static final Integer TIPOIMPUESTO_OMISION_IVA_0 = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.iva0");
	public static final Integer TIPOIMPUESTO_OMISION_ICE = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.consumoEspecial.omision");
	public static final Integer TIPOIMPUESTO_OMISION_IVE = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.impuestoVerde.omision");
	public static final Integer TIPOIMPUESTO_OMISION_IDN = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.impuestoDisney.omision");
	public static final Integer TIPOIMPUESTO_OMISION_SIN_IVA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.tipoImpuesto.sinIva");
	////codigos de referencia para los tipos de impuesto
	public static final String TIPO_IMPUESTO_REFERENCIA_IVA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.iva");
	public static final String TIPO_IMPUESTO_REFERENCIA_IVA_0 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.iva0");
	public static final String TIPO_IMPUESTO_REFERENCIA_IVE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.ive");
	public static final String TIPO_IMPUESTO_REFERENCIA_ICE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.ice");
	public static final String TIPO_IMPUESTO_REFERENCIA_IDN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.idn");
	public static final String TIPO_IMPUESTO_REFERENCIA_SINIVA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoImpuesto.codigo.referencia.sinIva");
	//codigos para los grupos de impuesto
	public static final String GRUPOIMPUESTO_IVA = "IVA";
	public static final String GRUPOIMPUESTO_ICE = "ICE";
	public static final String GRUPOIMPUESTO_VERDE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.grupoImpuesto.impuestoVerde");
	public static final String GRUPOIMPUESTO_DISNEY = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.grupoImpuesto.impuestoDisney");
	
	//codigos para los tipos de calculo en los pedidos del SISPE
	public static final String TIPOCALCULOPRECIOCANTIDAD = "0";
	public static final String TIPOCALCULOPRECIOCANTIDADPESO = "1";
	public static final String TIPOCALCULOPRECIOPESO = "2";
	public static final String TIPOCALCULOPRECIO_CANPESUNIMAN = "3";
	//valores para los tipos de archivo del registro sanitarioec.com.smx.sic.definicionArchivo.tipoArchivo.imgRegSan
	public static final String TIPOARCHIVO_IMGREGSAN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoarchivo.imgRegSan");
	public static final String TIPOARCHIVO_DOCREGSAN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoarchivo.docRegSan");
	public static final String TIPOARCHIVO_IMGGENERAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoArchivo.imgGeneral");
	public static final String TIPOARCHIVO_IMAGEN_MOVIL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoArchivo.imgMovil");
	public static final String TIPOARCHIVO_IMAGEN_CODBAR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoarchivo.imgCodBar");
	public static final String TIPOARCHIVO_IMAGEN_ORGANICA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoArchivo.imgOrg"); 
	/** tipo de archivo para la justificaci&oacute;n de un art&iacute;culo no transg&eacute;nico */
	public static final String TIPOARCHIVO_DOCJUSNOTRA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.definicionArchivo.tipoArchivo.docJusNoTra");
	
	//catalogo para el tipo de material personalizado
	public static final String VALOR_TIPOMATERIAL_OTRO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorTipoMaterialOtro");
	public static final Integer CODIGOTIPOMATERIAL = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoMaterialArticulo");
	
	//catalogo para las unidades de empaque
	public static final String VALOREMPAQUEUNIDAD = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorEmpaqueUnidad");
	public static final String VALOREMPAQUECAJA =  SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorEmpaqueCaja");
	public static final String VALOREMPAQUEJABA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorEmpaqueJaba");
	public static final String TIPOEMPAQUE_MAYORISTA = "MAY";
	public static final String TIPOEMPAQUE_PIEZA = "PIE";
	public static final String TIPOEMPAQUE_BULTO = "BUL";
	public static final String TIPOEMPAQUE_PALLET = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorEmpaquePalet");
	public static final String TIPOEMPAQUE_PIEZA_SIC = "07";
	public static final Integer CODIGOTIPOEMPAQUE = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tiposUnidadesManejo");
	
	public static final String CODIGOBARRASNOEXISTENTE = "NA";
	public static final String NOMBRE_SECUENCIA_ARTICULO = "SCSADSART";
	
	//catalogo para el tipo de uso de la unidad de manejo
	public static final Integer CODIGOTIPOUSOUNIMAN = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUsoUnidadManejo");
	public static final String VALORUSOUNIMANCOMPRA = "COM";
	public static final String VALORUSOUNIMANDESPACHO = "DES";
	public static final String VALORUSOUNIMANVENTA = "VEN";
	public static final Integer NUMEROMAXIMOUNIDADESMANEJO = 4;
	
	//codigos de los descuentos para la compra
	public static final String TIPODESCUENTO1 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.descuento1");
	public static final String TIPODESCUENTO2 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.descuento2");
	public static final String TIPODESCUENTO3 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.descuento3");
	public static final String TIPODESCUENTO4 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.descuento4");
	public static final String TIPODESCUENTO_PORCENTAJEPRODUCTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.porcentaje.productos");
	public static final String TIPODESCUENTO_DOCENASDE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.docenasDe");
	public static final String TIPODESCUENTONOTACREDITO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.nota.credito");
	public static final String TIPODESCUENTO_INTERPROVEEDORVENTA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.interproveedor");
	public static final String TIPODESCUENTO_CUPON = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.cupon.especial");
	public static final String TIPODESCUENTO_PROMOCIONCOSTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipoDescuento.promocion.costo");
	
	//catalogo para el tipo de relaciones de un articulo
	public static final Integer CODIGOTIPOARTICULORELACION = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoRelacionArticulo");
	public static final String VALORARTICULORELACIONRZ = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloRelacionRZ");
	public static final String VALORARTICULORELACIONCUPON = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloRelacionCupon");
	public static final String VALORARTICULORELACIONRECIPIENTE = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorRelacionRecipiente");
	public static final String VALORARTICULORELACIONRECETA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorRelacionReceta");
	
	//nombre para los descuentos
	public static final String NOMBREDESCUENTODOCENASDE="DOCDE";
	
	//constantes que almacenan la longitud del codigo de cada nivel de la estructura comercial
	//SIC
	public static final Integer LONGITUD_CODIGODIVISION_SIC = 1;
	public static final Integer LONGITUD_CODIGODEPARTAMENTO_SIC = 2;
	public static final Integer LONGITUD_CODIGOCLASIFICACION_SIC = 4;
	//MAX
	public static final Integer LONGITUD_CODIGODIVISION_MAX = 2;
	public static final Integer LONGITUD_CODIGODEPARTAMENTO_MAX = 5;
	public static final Integer LONGITUD_CODIGOCLASIFICACION_MAX = 8;
	//USO PARA LAS BUSQUEDAS POR CODIGO DE ESTRUCTURA COMERCIAL
	public static final Integer LONGITUD_CODIGODIVISION = LONGITUD_CODIGODIVISION_SIC;
	public static final Integer LONGITUD_CODIGODEPARTAMENTO = LONGITUD_CODIGODEPARTAMENTO_SIC;
	public static final Integer LONGITUD_CODIGOCLASIFICACION = LONGITUD_CODIGOCLASIFICACION_SIC;

	//limites del precio base para calcular el precio de mayorista
	public static final Double LIMITE_PRECIOBASE_SINIMPUESTO_CALCULOMAYORISTA = 999D;
	public static final Double LIMITE_PRECIOBASE_CONIMPUESTO_CALCULOMAYORISTA = 892D;
	
	/** catalogo para el tipo de conservacion de un articulo */
	public static final Integer CODIGOCATALOGOTIPOCONSERVACION = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoConservacion");
	@Deprecated
	public static final String VALORARTICULOCONSERVACIONNORMAL = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloConservacionNormal");
	public static final String VALORARTICULOCONSERVACIONCONGELADO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloConservacionCongelado");
	public static final String VALORARTICULOCONSERVACIONREFRIGERADO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloConservacionRefrigerado");
	public static final String VALORARTICULOCONSERVACIONLOCAL= SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorArticuloConservacionLocal");
	
	/** c&oacute;digo del tipo de cat&aacute;logo para las &aacute;reas de bodega para conservar un articulo */
	public static final Integer CODIGOCATALOGOTIPOAREASBODEGA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.areasConservacionBodega");
	
	/** catalogo para los pasos incluidos en el proceso de creacion de un articulo */
	public static final Integer CODIGOCATALOGOPASOSCREACIONARTICULO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.pasosCreacionArticulo");
	public static final String VALORPASOCEROCODIFICACION = "0";
	public static final String VALORPRIMERPASOCODIFICACION = "1";
	public static final String VALORSEGUNDOPASOCODIFICACION = "2";
	public static final String VALORTERCERPASOCODIFICACION = "3";
	public static final String VALORCUARTOPASOCODIFICACION = "4";
	public static final String VALORQUINTOPASOCODIFICACION = "5";
	public static final String VALORSEXTOPASOCODIFICACION = "6";
	public static final String VALORSEPTIMOPASOCODIFICACION = "7";
	public static final String VALOROCTAVOOPASOCODIFICACION = "8";
	
	//valores de los catalogos para los tipos de descuento
	public static final String VALORTIPODESCUENTOCONVENIOVENTA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorUsoDescuentoMargenVenta");
	
	public static final String ESTADOARTICULO_PRECODIFICADO=SICArticuloMessages.getInstancia().getString("estado.creacionArticulo.precodificado");
	public static final String ESTADOARTICULO_CODIFICADO=SICArticuloMessages.getInstancia().getString("estado.creacionArticulo.codificado");
	public static final String ESTADOARTICULO_VIGENTE=SICArticuloMessages.getInstancia().getString("estado.creacionArticulo.vigente");
	public static final String ESTADOARTICULO_NOVIGENTE=SICArticuloMessages.getInstancia().getString("estado.creacionArticulo.novigente");
	
    //identificador de tipos de uso para conceptos
    public static final Integer CATALOGO_TIPO_USO_CONCEPTO = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUsoConcepto");
    
    /** catalogo del tipo de distribucion*/
    public static final Integer CODIGOCATALOGO_TIPODISTRIBUCION  = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoDistribucionArticulo");
    public static final Long CODIGOPROTOTIPOPERSONALIZADO = Long.valueOf(SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.prototipoAlcance.personalizado"));
    
    //codigos de opciones de menu
  	public static final String CODIGO_OPCION_ALCANCES_TEMPORALES_MAX = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.opcion.alcance.temporal.max");
  	//opcion edicion masiva (interna)
  	public static final String CODIGO_OPCION_EDICION_MASIVA_INTERNA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.opcion.edicion.masiva.interna");
    //opcion edicion asistida (masiva)
  	public static final String CODIGO_OPCION_EDICION_MASIVA_ASISTIDA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.opcion.edicion.masiva.asistida");
  	//opcion creacion por archivo
  	public static final String CODIGO_OPCION_CREACION_ARCHIVO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.opcion.creacion.archivo");
  	//opcion actualizacion por archivo
  	public static final String CODIGO_OPCION_ACTUALIZACION_ARCHIVO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.opcion.actualizacion.archivo");
    
  	public static final String CODIGO_OPCION_EDICION_MASIVA = SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.edicionMasiva");
  	
  	public static final Long CODIGO_PROCESO_EDICION_MASIVA = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.proceso.edicion.masiva"));
  	/**
     * Total de articulos tipo cupon electronico validos permitidos por establecimiento en un rango de fechas
     */
    public static final Integer MAXIMO_CUPONES_VALIDOS_POR_LOCAL = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.local.maximo.cupones.validos.permitidos");
    
    /* PROCESOS */
    public static final Integer CODIGOPROCESO_CODIFICACIONARTICULO = SICArticuloMessages.getInstancia().getInteger("catalogo.proceso.codificacionArticulo");
    public static final Integer CODIGOPROCESO_REGISTROSANITARIO = SICArticuloMessages.getInstancia().getInteger("catalogo.proceso.registrosanitario");
    public static final Integer CODIGOPROCESO_INFORMACIONNUTRICIONAL = SICArticuloMessages.getInstancia().getInteger("catalogo.proceso.informacionNutricional");
    
    public static final Integer INDICADORPROPIETARIOGENERAL = 0;
    public static final Integer INDICADORPROPIETARIOGENERAL_AKI = 7;
    
    //catalogos para los tipos de agrupadores del articulo
    public static final Integer CATALOGOTIPO_AGRUPADOR = SICArticuloMessages.getInstancia().getInteger("catalogo.tipo.agrupador");
    public static final Integer CATALOGOVALOR_AGRUPADOR_NATURALEZA = SICArticuloMessages.getInstancia().getInteger("catalogo.valor.agrupador.naturaleza");
    public static final Integer CATALOGOVALOR_AGRUPADOR_MATERIAL = SICArticuloMessages.getInstancia().getInteger("catalogo.valor.agrupador.material");
    public static final String CATALOGOVALOR_AGRUPADOR_VIRTUAL = SICArticuloMessages.getInstancia().getString("catalogo.valor.naturaleza.cupon.virtual");
    public static final String CATALOGOVALOR_AGRUPADOR_PAPEL = SICArticuloMessages.getInstancia().getString("catalogo.valor.naturaleza.cupon.papel");
    
    public static final Integer LONGITUD_CODIGOPOS = 12;
    
    //catalogo para los tipos de participacion en las relaciones entre articulos
    public static final Integer CATALOGOTIPO_PARTICIPACIONRELACION = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.participacionArticuloRelacion");
    //tipos de catalogo para las caracteristicas de los cupones
    public static final Integer CATALOGOTIPO_CARACTERISTICASCUPON = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.caracteristicasCupon");
    public static final Integer CATALOGOTIPO_GRUPOCLIENTECUPON = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.grupoClientesCupon");
    public static final Integer CATALOGOTIPO_PUBLICACIONCUPON = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.medioPublicacion");
    public static final Integer CATALOGOTIPO_USOCUPON = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.usoCupon");
    
    //catalogo para los tipos de orientaciones en las etiquetas
    public static final Integer CATALOGOTIPO_ORIENTACIONETIQUETA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoOrientacionEtiqueta");
    public static final String CATALOGO_ORIENTACION_VERTICAL_ETIQUETA = "V";
    public static final String CATALOGO_ORIENTACION_HORIZONTAL_ETIQUETA = "H";
    
    //valores del catalogo para los grupos de clientes de cupones
    public static final String CATALOGOVALOR_GRUPOCLIENTE_GENERAL = "GEN";
    public static final String CATALOGOVALOR_GRUPOCLIENTE_ESPECIAL = "ESP";
    public static final String CATALOGOVALOR_GRUPOCLIENTE_ESPECIAL_MEJOR_AHORRO = "EMA";//especial mejor ahorro
    public static final String CATALOGOVALOR_GRUPOCLIENTE_ESPECIAL_RECOMENDADO_GENERAL = "ERG";//especial recomendado general
    public static final String CATALOGOVALOR_GRUPOCLIENTE_CUPON_POPULAR = "POP";//cupon popular
    
    //valores del catalogo para los usos del cupon
    public static final String CATALOGOVALOR_USOCUPON_UNICO = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorUsoCuponUnico");
    
    // Codigo de estado para cupones recomendados en la tabla cliente articulo.
    public static final String ESTADO_CUPONRECOMENDADO = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.codigo.estadoRecomendado");
    
    //catalogo para el tipo de deducible
    public static final Integer CATALOGOTIPO_DEDUCIBLES = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoDeducible");
    /**
     * Cantidad m&aacute;xima de cupones activos permitidos en un local
     */
    public static final Integer CANTIDAD_MAXIMA_CUPONES_ACTIVOS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.local.maximo.cupones.validos.permitidos");
    //cantidad de items en los mensajes de integracion
    public static final Integer CANTIDAD_MAXIMA_ITEMS_INTEGRACION_ARTICULO = 100;
    public static final Integer CANTIDAD_MAXIMA_ITEMS_INTEGRACION_PROVEEDOR = 90;
    
    //Catalagos de valores de la distribucion de la clasificacion
    public static final String CATALOGO_VALOR_DISTRIBUCION_DIRECTA = SICMessages.getInstancia().getString("ec.com.smx.sic.catalogo.valorDistribucionDirecta");
    
    //Valores del estado del registro sanitario
    public static final String ESTADO_ARTICULO_REGISTROSANITARIO_VIGENTE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registroSanitario.estado.vigente");
    public static final String ESTADO_ARTICULO_REGISTROSANITARIO_CADUCADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registroSanitario.estado.caducado");
    public static final String ESTADO_ARTICULO_REGISTROSANITARIO_TRAMITE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registroSanitario.estado.tramite");
    public static final String ESTADO_ARTICULO_REGISTROSANITARIO_RECHAZADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registroSanitario.estado.rechazado");
    
    //estados alternos para los segmentos del articulo
    public static final String ESTADO_SEGMENTO_ADVERTENCIA = "2";
    public static final String ESTADO_SEGMENTO_ERROR = "3";
    //tipos de codigos de barra para el SIC
    public static final String TIPOCODIGOBARRASSIC_INTERNO = "1";
    public static final String TIPOCODIGOBARRASSIC_EXTERNO = "2";
    
    //--------- PROPIEDADES DINAMICAS ----------
    public static final String MARGENFIJADO = "PRECIO.MARGENFIJO";
	//Constantes dinamicas para unidades de manejo
	public static final String UNIDAD_MANEJO_USO_VENTA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.unidadmanejo.uso.venta");
	public static final String UNIDAD_MANEJO_USO_DESPACHO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.unidadmanejo.uso.despacho");
	public static final String UNIDAD_MANEJO_USO_RECEPCION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.unidadmanejo.uso.recepcion");
    //-------------------------------------------
	
	public static final String CODDIVEXCLUSIONCUPON = "0008";
	
	public static final Integer MAXIMO_ARTICULOS_BUSQUEDA = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.busqueda.maximo.registros");
	public static final Integer MAXIMO_ARTICULOS_BUSQUEDA_ALCANCES = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.alcances.busqueda.maximo.registros");
	public static final Integer MAXIMO_TAMANO_JUSTIFICATIVO_TRANSGENICO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.maximoTamano.justificativo.transgenico");
	
	public static final Integer ANIOS_AGREGADOS_FECHAFINALALCANCE = 25;
	public static final Long CODIGO_LUGAR_COMPRA_ECUADOR = 0l;
	
	public static final int DIAS_AGREGADOS_FECHA = 1;
	
	public static final Double PROPORCION_CALORIAS_KS = Double.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registroSanitario.proporcion.calorias.ks"));
	
	public static final Long ETIQUETA_SEMAFORO = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.registroSanitario.semaforo"));
	public static final Long ETIQUETA_ART_15  = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.registroSanitario.art15"));
	
	public static final Long ETIQUETA_PRINCIPAL = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.registroSanitario.principal"));

	//-------------------TIPOS ASIGNACION DE ALCANCES -------------------------
	public static final String ETIQUETA_TIPO_ASIGNACION_NORMAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.tipo.asignacion.normal");
	public static final String ETIQUETA_TIPO_ASIGNACION_EMERGENTE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.tipo.asignacion.emergente");
	public static final String ETIQUETA_TIPO_ASIGNACION_LOCALES = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.asignacion.locales");
	public static final String ETIQUETA_TIPO_ASIGNACION_OFICINAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.asignacion.oficinas");
	public static final String ETIQUETA_TIPO_ASIGNACION_BODEGAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.alcance.asignacion.bodegas");
	
	// IDENTIFICADORES EDICION ARTICULO
	public static final String ACCITE_EDICION_ARTICULO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.editar.articulo.accesitem");
	public static final String IDENTIFICADOR_AUDITORIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.auditoria.definicion");
	public static final String IDENTIFICADOR_AUDITORIA_REG = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.auditoria.registro.definicion"); 
	public static final Integer TIPOLOG_AUDITORIAARTICULO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.auditoria.registro.tipoLog");
	public static final String IDENTIFICADOR_AUDITORIA_NOT = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.auditoria.notificacion.definicion");
	public static final Integer TIPOLOG_AUDITORIA_NOTIFICACION = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.auditoria.notificacion.tipoLog");
	
	//VALOR MAXIMO DE LOS ARCHIVOS QUE SE PUEDE SUBIR
	public static final Integer TAMANIO_MAXIMO_ARCHIVO = 4170605;
	
	//VALOR PREDETERMINADO PRECIOS
	public static final Double VALOR_PREDETERMINADO_PRECIO = Double.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.predeterminado.precio"));
	public static final Double VALOR_PREDETERMINADO_PRECIO_PVP = Double.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.predeterminado.precio.pvp"));
	
	//VALOR PREDETERMINADO COSTO	
	public static final Double VALOR_PREDETERMINADO_COSTO = Double.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.predeterminado.costo"));
	
	
	
	public static final String MARCA_PARTICIPACIONES_PREDETERMINADA = "X";
	
	//VALOR PUERTO FTP
	public static final Integer VALOR_PUERTO_FTP = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.valor.puerto.ftp");
	
	public static final Long PROTOTIPO_ALCANCE_PREDETERMINADO_JUGUETES = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.prototipo.alcance.juguetes"));
	
	public static final Long PROTOTIPO_ALCANCE_PREDETERMINADO_JUGUETES_AKI = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.prototipo.alcance.juguetes.aki"));
	
	public static final Double CANTIDAD_MEDIDA_PREDETERMINADO_JUGUETES = 1D;
	
	public static final Integer CODIGO_CATALOGO_UNIDAD_MEDIDA = SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUnidadEspecial");
	
	public static final Long CODIGO_MARCA_PENDIENTE = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.marca.pendiente"));
	
//	public final String DEPARTAMENTO_JUGUETES = "0050";
	
	public static final String CODIGO_SUBBODEGA_JUGUETES = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.codigo.subbodega.juguetes");
	public static final String CODIGO_PROVEEDOR_OMISION_IVA_JUGUETES = "65336";
	
	public static final String CODIGO_DIVISIONES_VALIDADAS_COSTO_PRECIO = "MAX45";
	public static final String CAMPO_IMPORTADO_POR = "MAX46";
//	public static final String CODIGO_PRIORIDAD_PRECIO_POR_UNIDAD_MINIMA = "MAX47"; 
	
	public static final Long VALOR_MONEDA_DOLAR = Long.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.valor.moneda.dolar"));
	
	public static final Double VALOR_MINIMO_MARGEN = Double.valueOf(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.valor.minimo.margen"));
 	
  	//color etiqueta
  	public static final String COLOR_ETIQUETA_GRIS = "GRIS";
  	public static final String COLOR_ETIQUETA_BLANCO = "BLANCO";
  	
  	//articulo prototipo alcance
  	public static final String SIN_PROTOTIPO_ALCANCE_CODIGO = "N/D";
  	public static final String SIN_PROTOTIPO_ALCANCE_DESCRIPCION = "SIN PROTOTIPO";
  	
  	//Creacion Articulo por Archivo INICIO
  	public static final String VALOR_CABECERA_CODIGO_PROVEEDOR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.proveedor");
  	public static final String VALOR_CABECERA_CODIGO_CLASIFICACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.clasifiacion");
  	public static final String VALOR_CABECERA_CODIGO_SUBCLASIFICACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.subclasificacion");
  	public static final String VALOR_CABECERA_CODIGO_BARRAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.barras");
  	public static final String VALOR_CABECERA_DESCRIPCION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.descripcion");
  	public static final String VALOR_CABECERA_CLASE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.clase");
  	public static final String VALOR_CABECERA_FECHA_INICIO_TEMPORADA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.fecha.inicio.temporada");
  	public static final String VALOR_CABECERA_FECHA_FIN_TEMPORADA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.fecha.fin.temporada");
  	public static final String VALOR_CABECERA_UNIDAD_MANEJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.unidad.manejo");
  	public static final String VALOR_CABECERA_EAN14 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.ean14");
  	public static final String VALOR_CABECERA_COSTO_MONEDA_ORIGEN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.costo.moneda.origen");
  	public static final String VALOR_CABECERA_TAMANIO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.tamanio");
  	public static final String VALOR_CABECERA_MARCA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.marca");
  	public static final String VALOR_CABECERA_MARCA_PARTICIPACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.marca.participacion");
  	public static final String VALOR_CABECERA_GARANTIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.garantia");
  	public static final String VALOR_CABECERA_REFERENCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.referencia");
  	public static final String VALOR_CABECERA_REFERENCIA_INTERNA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.referencia.interna");
  	public static final String VALOR_CABECERA_ALCANCE_PROTOTIPO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.alcance.prototipo");
  	public static final String VALOR_CABECERA_AGRUPADOR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.codigo.agrupador");
  	public static final String VALOR_CABECERA_COSTO_BRUTO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.costo.sin.iva");
  	public static final String VALOR_CABECERA_DES1 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.des1");
  	public static final String VALOR_CABECERA_DES2 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.des2");
  	public static final String VALOR_CABECERA_DES3 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.des3");
  	public static final String VALOR_CABECERA_DES4 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.des4");
  	public static final String VALOR_CABECERA_PRECIO_VENTA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.precio.venta");
  	public static final String VALOR_CABECERA_PRECIO_SUPERMAXI = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.precio.supermaxi");
  	public static final String VALOR_CABECERA_UNIDAD_MEDIDA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.unidad.medida");
  	public static final String VALOR_CABECERA_CANTIDAD_MEDIDA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.cantidad.medida");
  	public static final String VALOR_CABECERA_EMPAQUE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.empaque");
  	public static final String VALOR_CABECERA_VENTA_PRECIO_AFILIADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.venta.precio.afiliado");
  	public static final String VALOR_CABECERA_PLAZO_PAGO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.plazo.pago");
  	public static final String VALOR_CABECERA_IMPORTANCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.importancia");
  	
	public static final String VALOR_CABECERA_TIPO_SECUENCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.tipo.secuencia");
  	public static final String VALOR_CABECERA_PRESENTACION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.presentacion");
  	public static final String VALOR_CABECERA_CONTROL_PRECIOS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.control.precios");
  	public static final String VALOR_CABECERA_PESO_APROX_VENTA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.peso.aproximado.venta");
  	public static final String VALOR_CABECERA_PESO_APROX_RECEPCION = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.peso.aproximado.recepcion");
  	public static final String VALOR_CABECERA_PAIS_ORIGEN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.pais.origen");
  	public static final String VALOR_CABECERA_LUGAR_COMPRA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.lugar.compra");
  	public static final String VALOR_CABECERA_USOS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.usos");
  	public static final String VALOR_CABECERA_DURACION_CONS_LOCAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.duracion.conservacion.local");
  	public static final String VALOR_CABECERA_DURACION_CONS_REFRIGERADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.duracion.conservacion.refrigerado");
  	public static final String VALOR_CABECERA_DURACION_CONS_CONGELADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.duracion.conservacion.congelado");
  	public static final String VALOR_CABECERA_TRANSGENICO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.transgenico");
  	public static final String VALOR_CABECERA_REGISTRO_SANITARIO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.registro.sanitario");
  	public static final String VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.fecha.caducidad.reg.san");
  	public static final String VALOR_CABECERA_CAUSAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.causal.cambio.clase");
  	public static final String CABECERA_IMPUESTOS_POSFIJO_COMPRA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cabecera.impuestos.posfijo.compra");
  	public static final String CABECERA_IMPUESTOS_POSFIJO_VENTA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cabecera.impuestos.posfijo.venta");

  	public static final Integer VALOR_CABECERAS_CATALOGO_TIPO_MERCANCIAS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.cabeceras.catalogo.tipo.mercancias");
  	public static final Integer VALOR_CABECERAS_CATALOGO_TIPO_ABASTOS_PERECIBLES = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.cabeceras.catalogo.tipo.abastos.perecibles");
  	public static final Integer VALOR_CABECERAS_CATALOGOT_TIPO_PADRE = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.cabeceras.catalogo.tipo.padre");
  	
  	public static final String VALOR_ID_ARCHIVO_AYUDA_CREACION_EXCEL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.archivo.ayuda.creacion.excel");
  	
  	public static final String VALOR_CABECERA_IMPUESTO_VENTA = "CIV";
	public static final String VALOR_CABECERA_IMPUESTO_COMPRA = "CIC";
  	
  	public static final Integer VALOR_PRESENTACION_ARTICULO_MEDIDA = 1;
  	public static final String ASIGNACION_TIPO_GRUPO_TRABAJO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.asignacion.tipo.grupo.trabajo");
//  	public Integer ASIGNACION_CODIGO_TIPO_MEDIDA_UNIDAD = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.asignacion.codigo.tipo.medida.unidad");
  	
  	public static final String PARAMETRO_MAXIMO_FILAS_CREACION_POR_ARCHIVO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.parametro.maximo.filas");
  	public static final String VALOR_CABECERA_OCULTA_INTERPROVEEDOR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.cabecera.oculta.interproveedor");
  	public static final String PARAMETRO_INGRESO_VALORES_DE_CELDAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.codigo.parametro.ingreso.datos.filas");
  	
  	
  	//Creacion articulo por archivo FIN
  	
  	public static final String PARAMETRO_NUMERO_MAXIMO_BUSQUEDA_EDICIONMASIVA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.busqueda.articulos.edicion");
  	// parametro edicion de articulos - validar visualizacion datos de mercancias
  	public static final String PARAMETRO_VISUALIZACION_DATOS_MERCANCIAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.valor.validacion.articulos.edicion");
  	
  	public static final Integer CODIGO_CATALOGO_CAMPOS_EDICION = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.codigo.catalogotipo.campos.edicion");
  	//clase de articulos
  	public static final String CODIGO_CLASE_ARTICULO_T = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada");
  	public static final String CODIGO_CLASE_ARTICULO_E = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.noObsoletoNoResurtible");
  	public static final String CODIGO_CLASE_ARTICULO_O = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.obsoleto");
  	public static final String CODIGO_CLASE_ARTICULO_I = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.especiales");
  	public static final String CODIGO_CLASE_ARTICULO_R = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.resurtible");
	public static final String CODIGO_CLASE_ARTICULO_Z = "Z";
  	
  	//catalogos de formas de creacion de un articulo
  	public static final String CATALOGO_VALOR_CREACION_ASISTIDA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.catalogo.valor.creacion.asistida");
  	public static final String CATALOGO_VALOR_CREACION_POR_ARCHIVO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.catalogo.valor.creacion.archivo");
  	//catalogos de los campos de la edicion
  	
  	public static final String CODIGO_CAMPO_DESCRIPCION = "descripcion";
  	public static final String CODIGO_CAMPO_CLASE= "clase";
  	public static final String CODIGO_CAMPO_FECHAINICIO = "fechaInicioTemporada";
	public static final String CODIGO_CAMPO_FECHAFIN = "fechaFinTemporada";
	public static final String CODIGO_CAMPO_CLASIFICACION = "clasificacion";
	public static final String CODIGO_CAMPO_SUBCLASIFICACION = "subClasificacion";
  	public static final String CODIGO_CAMPO_MARCA_COMERCIAL= "marcaComercial";
  	public static final String CODIGO_CAMPO_MARCA_PARTICIPACION = "marcaParticipacion";
  	public static final String CODIGO_CAMPO_PAIS_ORIGEN = "paisOrigen";
  	public static final String CODIGO_CAMPO_VERFECCAD = "verificaFechaCaducidad";
  	public static final String CODIGO_CAMPO_TIPCONPRE= "tipoControlPrecio";
  	public static final String CODIGO_CAMPO_TAMANIO = "tamanio";
  	public static final String CODIGO_CAMPO_REF_INTERNA = "referenciaInterna";
  	public static final String CODIGO_CAMPO_REFEXTERNA = "referenciaExterna";
  	public static final String CODIGO_CAMPO_COSMONORI = "costoMonedaOrigen";
  	public static final String CODIGO_CAMPO_PORCOM= "porcentajeComision";
  	public static final String CODIGO_CAMPO_AGRUPADOR = "agrupador";
  	public static final String CODIGO_CAMPO_TIEMPO_VIDAUTIL= "tiempoVidaUtil";
  	public static final String CODIGO_CAMPO_ARTICULOMATERIAL = "material";
  	public static final String CODIGO_CAMPO_TIEMPO_REFRIGERACION = "tiempoRefrigeracion";
  	public static final String CODIGO_CAMPO_TIEMPO_CONGELACION = "tiempoCongelacion";
  	public static final String CODIGO_CAMPO_PROTOTIPO_ALCANCE = "prototipoAlcance";
  	public static final String CODIGO_CAMPO_LUGARCOMPRA = "lugarCompra";
  	public static final String CODIGO_CAMPO_CAUSAL = "causal";
  	public static final String CODIGO_CAMPO_MARCAS_ESPECIALES = "marcasEspeciales";
  	
 	// Codigos de establecimientos
  	public static final Integer CODIGO_ESTABLECIMIENTO_AKI = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.codigo.establecimiento.aki");
  	public static final Integer CODIGO_ESTABLECIMIENTO_GRAN_AKI = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.codigo.establecimiento.granaki");
  	public static final Integer CODIGO_ESTABLECIMIENTO_SUPER_AKI = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.codigo.establecimiento.superaki");
  	
  	// Unidades Energia
  	public static final String ENERGIA_UNIDAD_CAL = "cal";
  	public static final String ENERGIA_UNIDAD_KJ = "kJ";
  	
  	//codigos para Transgenico
  	public static final String NOMBRE_TRANSGENICO_NO_APLICA = "No Aplica";
  	
  	//RegistroMasivoArticulos
  	/**
  	 * constante usada para el registro masivo de articulos : 1 para el registro mediante hilo, 0 para el registro en linea
  	 */
  	public static final String REGISTROMASIVOARTICULOS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.registro.masivamente");
  	
  	/*EDICION POR ARCHIVO EXCEL eharo*/
  	public static final Integer EDICION_ARTICULO_EXCEL_CATALOGO_TIPO_CABECERAS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.edicion.excel.catalogo.tipo.cabeceras");
  	public static final String  EDICION_ARTICULO_EXCE_PARAMETRO_MAX_FILAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.edicion.excel.codigo.parametro.maximo.filas");
  	public static final String VALOR_ID_ARCHIVO_AYUDA_ACTUALIZACION_EXCEL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.edicion.excel.codigo.archivo.ayuda.actualizacion.excel");
  	public static final String VALOR_ID_PARAMETRO_PATERN_ETIQUETA_MERCANCIA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.mercancia.patern.reemplazar");
  	public static final String VALOR_ID_PARAMETRO_PATERN_ETIQUETA_REGSAN = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.regsan.patern.reemplazar");
  	
	public static final String VALIDAR_ALCANCE_LOCALES = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.alcance.locales");
	
	/*OBSERVACIONES EN SEGMENTO CREACION ARTICULO - SE USA PARA IDENTIFICAR EL ERROR*/
	public static final String CAMBIO_PROVEEDOR = "1=Cambio_Proveedor";
	public static final String CAMBIO_TIPO_CODIGO = "2=Cambio_TipoCodigo";
	
  	public static final String PARAMETRO_FECHA_LEY_MERCADO = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.fecha.limite.poderMercado");
  	public static final String PARAMETRO_NUMERO_MAXIMO_ARTICULOS_INTEGRACION = SICMessages.getInstancia().getString("ec.com.smx.sic.codigo.parametro.cantidad.maxima.articulos.integracion");
  	
  	//VALOR AGRUPADOR VACIO
  	public static final String VALOR_AGRUPADOR_VACIO = "Ninguno";
	
	/*PROTOTIPO ALCANCE*/
	public static final Integer CODIGO_PROTOTIPO_ALCANCE_PERSONALIZADO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.prototipoalcance.personalizado");
  	public static final Integer CANTIDAD_DEFAULT_RELACION_ARTICULO= 1;
  	
	//Codigos para los tipos de descuentos
	public static final String TIPO_DESCUENTO_DES1 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.descuento1");
	public static final String TIPO_DESCUENTO_DES2 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.descuento2");
	public static final String TIPO_DESCUENTO_DES3 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.descuento3");
	public static final String TIPO_DESCUENTO_DES4 = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.descuento4");
	public static final String TIPO_DESCUENTO_DOCDE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.docenas");
	public static final String TIPO_DESCUENTO_PPRO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.promocion");
	public static final String TIPO_DESCUENTO_PCO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.especial");
	//public static final String TIPO_DESCUENTO_DPRO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.tipo.descuento.promo");
	
	//rutas y prefijos para almacenamiento de archivos de alcances
	public static final String VALOR_RUTA_LOCAL_ARCHIVOS_ALCANCES = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.alcances.ruta.archivos");
	public static final String VALOR_ARCHIVO_ALCANCE_EXTENSION_TXT = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.alcances.archivo.extension.txt");
	public static final String VALOR_ARCHIVO_ALCANCE_CARPETA_ERROR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.alcances.archivo.carpeta.error");
	public static final String VALOR_ARCHIVO_ALCANCE_SEPARADOR = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.alcances.separador");
	
	public static final String VALOR_PARAMETRO_DESCRIPCION_ARTICULO_NOVALIDO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.descripcion.articulo.novalido");
	public static final String VALOR_PARAMETRO_PROVEEDOR_ARTICULO_NOVALIDO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.proveedor.articulo.novalido");
	
	//ArticuloNovedadesCupon
	//Estados
  	public static final String ESTADO_PROCESADO_NOVEDAD_CUPON = "2";
  	//Eventos
  	public static final String CODIGO_EVENTO_NOVEDAD_CUPON = "ENOVCUP";
  	
  	//Numero de usos que se pueden registrar en el SIC
  	public static final Integer TOTAL_USOS_SIC = 2;

  	//Limite de proveedores al paginar en búsqueda de artículos
  	public static final Integer LIMITE_PROVEEDORES_PAGINATE= 20;
  	
  	//No se puede puede registrar la medida debido a que el articulo no posee la caracteristica dinamica PRESENTACION
  	public static final String MENSAJE_REGISTRO_CARDIN_ARTICULOMEDIDA = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.cardin.medida");
  	public static final String MENSAJE_REGISTRO_CARDIN_VIDAUTIL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.cardin.vidautil.local");
  	public static final String MENSAJE_REGISTRO_CARDIN_CONGELADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.cardin.vidautil.conngelado");
  	public static final String MENSAJE_REGISTRO_CARDIN_REFRIGERADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.cardin.vidautil.refrigerado");
  	public static final String MENSAJE_REGISTRO_PROVEEDORIMPORTADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.proveedor.importado");
  	public static final String MENSAJE_REGISTRO_MARCACOMERCIAL = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.marca.comercial");
  	public static final String MENSAJE_REGISTRO_TIPOCONTROLPRECIO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.mensaje.registro.tipocontroprecio");
  	
  	/***********************************************************************************************************************************************************/
  	/*************IMPRESION*MASIVA*ETIQUETAS*CARACTERISTICAS*INICIO*********************************************************************************************/
  	public static final Integer CODIGO_SEC_PRO_SER_IMP_CAR_MAS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.etiqueta.masiva.caracteristica.codigo.proceso.servidor.impresion.ftp");
  	public static final Integer CODIGO_SEC_PRO_SER_PROCESAR_ARC_CAR_MAS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.etiqueta.masiva.caracteristica.codigo.proceso.servidor.procesar.archivo");
  	/*************IMPRESION*MASIVA*ETIQUETAS*CARACTERISTICAS*FIN************************************************************************************************/
  	/***********************************************************************************************************************************************************/
	// parametro MINMAX para el margen de los precios
  	public static final String PARAMETRO_MINMAX_MARGEN_PRECIO_DIFERENCIADO = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.parametro.minmax.margen.pdiferenciado");
  	
  	//PRIORIDADES UNIDADES DE MANEJO
  	public static final Integer ARTICULOUNIDADMANEJO_PRIODIDAD_UNO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.unidad.manejo.prioridad.uno");
  	public static final Integer ARTICULOUNIDADMANEJO_PRIODIDAD_DOS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.unidad.manejo.prioridad.dos");
  	public static final Integer ARTICULOUNIDADMANEJO_PRIODIDAD_TRES = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.unidad.manejo.prioridad.tres");
  	public static final Integer ARTICULOUNIDADMANEJO_PRIODIDAD_CUATRO = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.unidad.manejo.prioridad.cuatro");
  	
  	//secuencial descuento articulo proveedor 
  	public static final String SECUENCIAL_DESCUENTO_ARTICULO_PROVEEDOR = "SCSADSECDESARTPRO";
  	public static final String SECUENCIAL_DESCUENTO_ARTICULO_PROVEEDOR_CLASIFICACION = "SCSADSECDESPROCLA";
  	
  	public static final Integer MAX_PRIORIDAD_ARTICULOUNIDADMANEJO = 1000;
  	
  	//parametros para el registro articulo etiqueta mercancias
  	public static final Integer ARTICULO_ETIQUETA_MERCANCIAS_NORMASTECNICAS = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.etiqueta.mercancias.normasTecnicas");
  	public static final String ARTICULO_ETIQUETA_MERCANCIAS_NORMASTECNICAS_NORMASTECNICASECUATORIANAS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.mercancias.normasTecnicas.normasTecnicasEcuatorianas");
  	public static final String ARTICULO_ETIQUETA_MERCANCIAS_NORMASTECNICAS_REGLAMENTOSTECNICOSECUATORIANOS = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.mercancias.normasTecnicas.reglamentosTecnicosEcuatorianos");
  	public static final Integer ARTICULO_ETIQUETA_MERCANCIAS_LOTESERIE = SICArticuloMessages.getInstancia().getInteger("ec.com.smx.sic.articulo.etiqueta.mercancias.loteSerie");
  	public static final String ARTICULO_ETIQUETA_MERCANCIAS_LOTESERIE_LOTE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.mercancias.loteSerie.lote");
  	public static final String ARTICULO_ETIQUETA_MERCANCIAS_LOTESERIE_SERIE = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.etiqueta.mercancias.loteSerie.serie");
  	
  	private SICArticuloConstantes(){}
	
	/**
	 * @return the iNSTANCIA
	 */
	public static SICArticuloConstantes getInstancia() {
		return INSTANCIA;
	}
}