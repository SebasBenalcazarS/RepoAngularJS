/**
 * 
 */
package ec.com.smx.sic.cliente.common.search.constant;

import java.lang.annotation.Annotation;

import org.apache.commons.collections.Predicate;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.framework.common.util.predicate.IsAPredicate;
import ec.com.smx.framework.common.util.predicate.IsAPredicate.RelationType;
import ec.com.smx.framework.common.util.predicate.IsNoEmptyStringPredicate;
import ec.com.smx.framework.common.util.predicate.IsNotEmptyCollectionPredicate;
import ec.com.smx.framework.common.util.predicate.IsNotEmptyPredicate;
import ec.com.smx.sic.cliente.common.search.bean.ListFilter;

/**
 * @author Mario Braganza
 * 
 * @author Luis Yacchirema
 *
 */
public final class SearchManagerConstants {
	
	private final static SearchManagerConstants INSTANCE = new SearchManagerConstants();
	
	private SearchManagerConstants(){
		//
	}
	
	public static SearchManagerConstants getInstance(){
		return INSTANCE;
	}
	
	
	public final IsNotEmptyPredicate<?>[] NOT_EMPTY_PREDICATES = new IsNotEmptyPredicate<?>[]{
		new IsNoEmptyStringPredicate(),
		new IsNotEmptyCollectionPredicate()
	};
	
	// Variables
	public static final String TYPE_METHOD_NAME = "type";
	public static final String DECLARED_FIELD_METHOD_NAME = "class.declaredFields";
	public static final Predicate[] IS_A_PREDICATES = new Predicate[]{new IsAPredicate(ListFilter.class, RelationType.CHILD)};
	public static final Class<? extends Annotation> SEARCH_ANNOTATION = ComparatorTypeField.class; 
	public static final String EXISTS_FILTERS_METHOD_NAME = "existsFilters";
	
	public static final String PUNTO = ".";
	public static final String ID = "id";
	
	// Alias
	// Proveedores
	public static final String ALIAS_PROVEEDOR_MARCA = "proveedorMarca";
	public static final String ALIAS_INTERPROVEEDOR = "proveedorcomercial";
	public static final String ALIAS_PROVEEDOR_CLASIFICACION = "proveedorClasificacion";
	
	// GestionPrecio
	//public final String ALIAS_GESTIONPRECIO = "gestionPrecio";
	//public final String PARAMETER_PATTERN_FECHA_INICIO = "fechaInicio";
	
	// INICIO PARAMETROS DE FILTROS PARA PROYECTO CONTROL DE RUTAS
	/*********************************************
	 * Parametrizacion de distancias entre locales
	 *********************************************/
	public static final String PARAMETER_PATTERN_DISTANCIA = "distancia";
	public static final String PARAMETER_PATTERN_CODIGO_ORIGEN = "codigoAreaTrabajoOrigen";
	public static final String PARAMETER_PATTERN_ORIGEN_AREA_TRABAJO = "areaTrabajoOrigenDTO"+ PUNTO +"nombreAreaTrabajo";
	public static final String PARAMETER_PATTERN_ORIGEN_CIUDAD_AREA = "areaTrabajoOrigenDTO"+ PUNTO +"codigoCiudad";
	public static final String PARAMETER_PATTERN_DESTINO_AREA_RTABAJO = "areaTrabajoDestinoDTO"+ PUNTO +"nombreAreaTrabajo";
	public static final String PARAMETER_PATTERN_DESTINO_LOZACION = "localizacionDestinoDTO"+ PUNTO +"descripcionLocalizacion";
	public static final String PARAMETER_PATTERN_DESTINO_CODIGO_AREA_RTABAJO = "codigoAreaTrabajoDestino";
	public static final String PARAMETER_PATTERN_DESTINO_CODIGO_JDE_LOZACION = "localizacionDestinoDTO"+ PUNTO +"codigoJDE";
	
	/*********************************************
	 * Administraci�n de furgones
	 *********************************************/
	public static final String PARAMETER_PATTERN_CODIGO_FURGON = "codigoInterno";
	public static final String PARAMETER_PATTERN_TIPO_FURGON_ID = "tipoFurgonDTO"+PUNTO+ID+PUNTO+"codigoTipoFurgon";
	public static final String PARAMETER_PATTERN_PREFIJO_FURGON = "secuencialPrefur";
	public static final String PARAMETER_PATTERN_PRE_FURG = "secuencialPrefur";
	public static final String PARAMETER_PATTERN_TIPO_FURGON_VALOR = "prefijoFurgonDTO.contextoValor";
	public static final String PARAMETER_PATTERN_TIPO_FURGON_TIPO_COD = "prefijoFurgonDTO.contextoCodigo";
	public static final String PARAMETER_PATTERN_CODIGO_LOCAL_FURGON = "codigoAreaTrabajoLoc";
	public static final String PARAMETER_PATTERN_USO_FURGON_VALOR = "codigoUsoValor";
	public static final String PARAMETER_PATTERN_USO_FURGON_TIPO = "codigoUsoTipo";
	public static final String PARAMETER_PATTERN_STATUS_FURGON_VALOR = "codigoEstatusValor";
	public static final String PARAMETER_PATTERN_ESTADO_REGISTRO_FURGON = "estado";
	public static final String PARAMETER_PATTERN_STATUS_FURGON_TIPO = "codigoEstatusTipo";
	public static final String PARAMETER_PATTERN_CODIGO_SECCION_FURGON = "codigoDetalleSeccion";
	public static final String PARAMETER_PATTERN_TIPO_FURGON_COMPANIA_ID = "tipoFurgonDTO"+PUNTO+ID+PUNTO+"codigoCompania";
	/*********************************************
	 * Administraci�n de transportistas
	 *********************************************/
	public static final String ALIAS_LOCALIZACION = "localizacionDTOempresaDTO";	
	public static final String PARAMETER_PATTERN_CODIGO_TRANSPORTISTA = "id" + PUNTO +"codigoTransportista";
	public static final String PARAMETER_PATTERN_NUMERODOCUMENTO = "numeroRuc";
	public static final String PARAMETER_PATTERN_NOMBRE_TRANSPORTISTA = "nombreTransportista";
	public static final String PARAMETER_PATTERN_CODIGOJDE = "codigoJDE";
	public static final String PARAMETER_PATTERN_ESTADO = "estado";
	
	public static final String PARAMETER_PATTERN_RUC_TRANSPORTISTA = ALIAS_LOCALIZACION + PUNTO +"numeroRuc";
	public static final String PARAMETER_PATTERN_CODIGO_EMP_TRANSPORTISTA = "localizacionDTO" + PUNTO +"codigoEmpresa";
	public static final String PARAMETER_PATTERN_CODIGO_JDE_TRANSPORTISTA = "localizacionDTO" + PUNTO +"codigoJDE";
	public static final String PARAMETER_PATTERN_RAZON_SOCIAL_TRANSPORTISTA = ALIAS_LOCALIZACION + PUNTO +"razonSocialEmpresa";
	/*********************************************
	 * Administraci�n de transportes (Cabezales)
	 *********************************************/
	public static final String ALIAS_TRANSPORTISTA_EMPRESA = "transportistaDTOlocalizacionDTOempresaDTO";
	public static final String ALIAS_TRANSPORTISTA_PERSONA = "transportistaDTOpersonaDTO";
	public static final String PARAMETER_PATTERN_PLACA_TRANSPORTE = "placa";
	public static final String PARAMETER_PATTERN_CODIGO_TRANSPORTE = ID + PUNTO +"codigoVehiculo";
	public static final String PARAMETER_PATTERN_TIPO_TRANSPORTE = "tipoDTO"+ PUNTO +"nombreCatalogoValor";
	public static final String PARAMETER_PATTERN_MARCA_TRANSPORTE = "marcaDTO"+ PUNTO +"nombreCatalogoValor";
	public static final String PARAMETER_PATTERN_COLOR_TRANSPORTE = "colorDTO"+ PUNTO +"nombreCatalogoValor";
	public static final String PARAMETER_PATTERN_ESTADO_REGISTRO_TRANSPORTE = "estado";
	public static final String PARAMETER_PATTERN_DOCUMENTO_TRANS_EMPRESA = ALIAS_TRANSPORTISTA_EMPRESA + PUNTO +"numeroRuc";
	public static final String PARAMETER_PATTERN_DOCUMENTO_TRANS_PERSONA_PER = ALIAS_TRANSPORTISTA_PERSONA + PUNTO +"numeroDocumento";
	public static final String PARAMETER_PATTERN_NOMBRE_TRANS_EMPRESA = ALIAS_TRANSPORTISTA_EMPRESA + PUNTO +"razonSocialEmpresa";
	public static final String PARAMETER_PATTERN_NOMBRE_TRANS_PERSONA = ALIAS_TRANSPORTISTA_PERSONA + PUNTO +"nombreCompleto";
	
	/*********************************************
	 * Administraci�n de transportes (Cabezales)
	 *********************************************/
	public static final String PARAMETER_PATTERN_CODIGO_CHOFER = "id.codigoChofer";
	public static final String PARAMETER_PATTERN_CEDULA_CHOFER = "personaDTO.numeroDocumento";
	public static final String PARAMETER_PATTERN_PRIMER_APELLIDO_CHOFER = "personaDTO.primerApellido";
	public static final String PARAMETER_PATTERN_SEGUND_APELLIDO_CHOFER = "personaDTO.segundoApellido";
	public static final String PARAMETER_PATTERN_PRIMER_NOMBRE_CHOFER = "personaDTO.primerNombre";
	public static final String PARAMETER_PATTERN_SEGUND_NOMBRE_CHOFER = "personaDTO.segundoNombre";
	
	/*********************************************
	 * Administraci�n de guias de transporte
	 *********************************************/
	public static final String PARAMETER_PATTERN_NUMERO_GUIA= "codigoGuia";
	public static final String PARAMETER_PATTERN_FECHA_EMISION = "fechaGuia";
	public static final String PARAMETER_PATTERN_ORIGEN_GUIA = "codigoAreaTrabajo";
	public static final String PARAMETER_PATTERN_TIPO_DESTINO_VALOR = "valorTipoDestino";
	public static final String PARAMETER_PATTERN_TIPO_DESTINO_TIPO = "codigoTipoDestino";
	public static final String PARAMETER_PATTERN_MOTIVO_VALOR = "valorMotivoTraslado";
	public static final String PARAMETER_PATTERN_MOTIVO_TIPO = "codigoMotivoTraslado";
	public static final String PARAMETER_PATTERN_COD_FUR_INT = "furgonDTO.codigoInterno";
	public static final String PARAMETER_PATTERN_VEHICULO_PLACA = "vehiculoDTO.placa";
	public static final String PARAMETER_PATTERN_ESTADO_GUIA_REG = "estado";
	public static final String PARAMETER_PATTERN_ESTADO_GEN_VALOR = "valorEstadoGenerado";
	public static final String PARAMETER_PATTERN_ESTADO_GEN_TIPO = "codigoEstadoGenerado";
	/*********************************************
	 * Monitoreo de la ruta
	 *********************************************/
	public static final String PARAMETER_PATTERN_NUMERO_RUTAS = "id.numeroRuta";
	public static final String PARAMETER_PATTERN_ORIGEN_RUTAS = "origen";
	public static final String PARAMETER_PATTERN_CODIGO_ORIGEN_RUTAS = "codigoAreaTrabajoOrigen";
	public static final String PARAMETER_PATTERN_DESTIN_RUTAS = "destino";
	public static final String PARAMETER_PATTERN_FECHAS_RUTAS = "fechaSalida";
	public static final String PARAMETER_PATTERN_FURGON_RUTAS = "codigoFurgon";
	public static final String PARAMETER_PATTERN_VEHICU_RUTAS = "placa";
	public static final String PARAMETER_PATTERN_ESTADO_RUTA_VAL = "valorTipoEstado";
	public static final String PARAMETER_PATTERN_ESTADO_RUA_TIP = "codigoTipoEstado";
	// FIN PARAMETROS DE FILTROS PARA PROYECTO CONTROL DE RUTAS
	
	
	// Articulos
	public static final String ALIAS_MARCA_ARTICULO = "marcaArticulo";
	public static final String ALIAS_LOCAL = "local";
	public static final String ALIAS_ARTICULO_MEDIDA = "articuloMedida";

	// Articulo - Proveedor
	public static final String ALIAS_ARTICULO_PROVEEDOR = "articuloProveedor";
	public static final String ALIAS_ARTICULOS_PROVEEDOR = "articulosProveedor";
	public static final String ALIAS_ARTICULO = "articulo";
	public static final String ALIAS_BITACORA_ARTICULO = "bitacorasArticulo";
	public static final String ALIAS_VISTA_PROVEEDOR = "vistaProveedor";

	// Estructura comercial
	public static final String ALIAS_CLASIFICACION = "clasificacion";
	public static final String ALIAS_CLASIFICACION_DEPARTAMENTO = "clasificacionDepartamento";
	public static final String ALIAS_CLASIFICACION_DIVISION = "clasificacionDivision";
	public static final String ALIAS_LINEA_COMERCIAL_CLASIFICACION = "lineaComercialClasificacion";
	
	// Estructura logistica
	public static final String ALIAS_BODEGA = "bodega";
	public static final String ALIAS_SUBBODEGA = "subBodega";
	public static final String ALIAS_CENTRO_DISTRIBUCION = "centroDistribucion";
	public static final String ALIAS_MACRO_BODEGA = "macroBodega";
	public static final String ALIAS_BODEGA_RELACION = "bodegaRelacion";

	// Ruta Parametros de Filtros Proveedor
	public static final String PARAMETER_PATTERN_CODIGO_PROVEEDOR = "codigoJDEProveedor";
	public static final String PARAMETER_PATTERN_NUMERO_DOCUMENTO_PROVEEDOR = "numeroDocumentoProveedor";
	public static final String PARAMETER_PATTERN_NOMBRE_COMERCIAL_PROVEEDOR = "nombreProveedor";
	public static final String PARAMETER_PATTERN_RAZON_SOCIAL_PROVEEDOR = "razonSocialProveedor";
	public static final String PARAMETER_PATTERN_VALOR_ORIGEN_PROVEEDOR = "origenProveedor"; 
	public static final String PARAMETER_PATTERN_CODIGO_ORIGEN_PROVEEDOR = "codigoOrigenProveedor"; 
	public static final String PARAMETER_PATTERN_INTERPROVEEDOR = "interproveedor";
	public static final String PARAMETER_PATTERN_CODIGOINTERPROVEEDOR = "codigoInterproveedor";
	public static final String PARAMETER_PATTERN_ESTADO_PROVEEDOR = "estadoProveedor";
	public static final String PARAMETER_PATTERN_ESTADO_ARTICULOS_PROVEEDOR = "estadoArticuloProveedor";
	
	// Ruta Parametros de Filtros de Articulos
	public static final String PARAMETER_PATTERN_CODIGO_BARRAS = ALIAS_ARTICULO + PUNTO + "codigoBarras";
	public static final String PARAMETER_PATTERN_DESCRIPCION_ARTICULO = ALIAS_ARTICULO + PUNTO + "descripcionArticulo";
	public static final String PARAMETER_PATTERN_CODIGO_REFERENCIA_INTERNA = ALIAS_ARTICULO_PROVEEDOR + PUNTO + "codigoReferenciaInterna";
	public static final String PARAMETER_PATTERN_CODIGO_REFERENCIA_EXTERNA = ALIAS_ARTICULO_PROVEEDOR + PUNTO + "codigoReferenciaProveedor";
	public static final String PARAMETER_PATTERN_CANTIDAD_MEDIDA_ARTICULO = ALIAS_ARTICULO_MEDIDA + PUNTO + "cantidadMedida";
	// Ruta Parametros de Filtros de Marca
	public static final String PARAMETER_PATTERN_CODIGO_MARCA = ALIAS_PROVEEDOR_MARCA + PUNTO + ID + PUNTO + "secuencialMarca";
	public static final String PARAMETER_PATTERN_NOMBRE_MARCA = ALIAS_MARCA_ARTICULO + PUNTO + "nombre";
	public static final String PARAMETER_PATTERN_CODIGO_TIPO_MARCA = ALIAS_MARCA_ARTICULO + PUNTO + "codigoTipoMarca";
	public static final String PARAMETER_PATTERN_VALOR_TIPO_MARCA = ALIAS_MARCA_ARTICULO + PUNTO + "valorTipoMarca";

	// Ruta Parametros de Filtros de Bodega
	public static final String PARAMETER_PATTERN_CODIGO_BODEGA = ALIAS_BODEGA_RELACION + PUNTO + ID + PUNTO + "codigoBodega";
	public static final String PARAMETER_PATTERN_DESCRIPCION_BODEGA = ALIAS_BODEGA + PUNTO + "descripcionBodega";	
	public static final String PARAMETER_PATTERN_CODIGO_SUBBODEGA = ALIAS_SUBBODEGA + PUNTO + ID + PUNTO + "codigoBodega";
	public static final String PARAMETER_PATTERN_DESCRIPCION_SUBBODEGA = ALIAS_SUBBODEGA + PUNTO + "descripcionBodega";
	public static final String PARAMETER_PATTERN_CODIGO_CD = ALIAS_CENTRO_DISTRIBUCION + PUNTO + ID + PUNTO + "codigoBodega";
	public static final String PARAMETER_PATTERN_DESCRIPCION_CD = ALIAS_CENTRO_DISTRIBUCION + PUNTO + "descripcionBodega";
	public static final String PARAMETER_PATTERN_CODIGO_MB = ALIAS_MACRO_BODEGA + PUNTO + ID + PUNTO + "codigoBodega";
	public static final String PARAMETER_PATTERN_DESCRIPCION_MB = ALIAS_MACRO_BODEGA + PUNTO + "descripcionBodega";

	// Ruta Parametros de Filtros de Linea Comercial
	public static final String PARAMETER_PATTERN_CODIGO_CLASIFICACION_LINEA_COMERCIAL = ALIAS_LINEA_COMERCIAL_CLASIFICACION + PUNTO + "codigoClasificacion";
	public static final String PARAMETER_PATTERN_NOMBRE_CLASIFICACION_LINEA_COMERCIAL = ALIAS_CLASIFICACION + PUNTO + "descripcionClasificacion";
	
	// Ruta Parametros de Filtros Areas de trabajo
	public static final String PARAMETER_PATTERN_CODIGO_LOCAL = ID + PUNTO + "codigoLocal";
	public static final String PARAMETER_PATTERN_CODIGO_REFERENCIA =  "codigoReferencia";
	public static final String PARAMETER_PATTERN_TIPO_ASIGNACION = "valorTipoAsignacion";
	public static final String PARAMETER_PATTERN_ESTADO_ARTICULO_LOCAL = "estadoArticuloLocal";
	
	public static final String PARAMETER_PATTERN_NOMBRE_AREA_TRABAJO = "nombreAreaTrabajo";
}
