/**
 * 
 */
package ec.com.smx.sic.cliente.common;

import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;

/**
 * @author Mario Braganza
 *
 */
public final class SICNombresAtributosUtil {
	
	private static final SICNombresAtributosUtil INSTANCIA = new SICNombresAtributosUtil();
	
	private SICNombresAtributosUtil(){
		//
	}
	
	public static SICNombresAtributosUtil getInstancia(){
		return INSTANCIA;
	}
	
	public static final String ID = "id";
	public static final String PUNTO = ".";
	public static final String CODIGO_PROVEEDOR = "codigoProveedor";
	public static final String ID_CODIGO_PROVEEDOR = ID + PUNTO + CODIGO_PROVEEDOR;
	public static final String VALORES_INTERPROVEEDOR = "valoresInterproveedor";
	public static final String VALORES_ORIGEN_PROVEEDOR = "valoresOrigenProveedor";
	public static final String VALORES_AUTORIZADO_PRONTOPAGO = "valoresAutorizadoProntoPago";
	public static final String VALORES_PAGA_ESPACIO_PERCHA = "valoresPagaEspacioPercha";
	
	public static final String ID_CODIGO_TIPO_CATALOGO = ID + PUNTO + "codigoCatalogoTipo";
	public static final String ID_CODIGO_VALOR_CATALOGO = ID + PUNTO + "codigoCatalogoValor";
	public static final String BASE_DTO = "baseDTO";
	
	public static final String PROVEEDOR_FINANCIERO = BASE_DTO + PUNTO + "proveedorFinanciero";
	public static final String PROVEEDOR_FINANCIERO_AUTORIZADO_PRONTO_PAGO = PROVEEDOR_FINANCIERO + PUNTO + "autorizadoProntoPago";
	public static final String PROVEEDOR_FINANCIERO_PAGA_ESPACIO_PERCHA = PROVEEDOR_FINANCIERO + PUNTO + "pagaEspacioPercha";
	public static final String PROVEEDOR_FINANCIERO_PAGA_ESPACIO_PERCHA_IGUAL_ANTERIOR = PROVEEDOR_FINANCIERO + PUNTO + "pagaEspacioPerchaIgualAnterior";
	public static final String PROVEEDOR_B2B = BASE_DTO + PUNTO + "proveedorB2B";
	public static final String PROVEEDOR_B2B_REGISTRA_PARTICIPACIONES = PROVEEDOR_B2B + PUNTO + "registraParticipaciones";
	public static final String PROVEEDOR_B2B_PROCESO_ENVIO_EMAIL = PROVEEDOR_B2B + PUNTO + "procesoEnvioEmail";
	
	public static final String CODIGO_TIPO_ASIGNACION_PROVEEDOR_OFICINA_EXTERIOR = "codigoTipoAsignacionOficinaExterior";
	public static final String VALOR_TIPO_ASIGNACION_PROVEEDOR_OFICINA_EXTERIOR = "valorTipoAsignacionOficinaExterior";
	
	public static final String ID_VALOR_CARACTERISTICA_TIPO_PROVEEDOR = ID + PUNTO + "valorTipoProveedor";
	public static final String VALOR_TIPO_ESTADO_PROVEEDOR = "valorTipoEstadoProveedor";
	
	public static final String ID_CODIGO_OFICINA_EXTERIOR = ID + PUNTO + "codigoOficinaExterior";
	
	public static final String TIPO_LOCALIZACION = "tipoLocalizacion";
	
	//ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor
	public static final String ACCESO_REPORTES = "accesoReportes";
	public static final String VISTA_USUARIO = "vistaUsuario";
	public static final String VISTA_USUARIO_CODIGO_USUARIO = VISTA_USUARIO + PUNTO + "codigoUsuario";
	public static final String FILTRADO_POR_ROL = "filtradoPorRol";
	public static final String EMAIL_INICIAL = "emailInicial";
	public static final String VISTA_USUARIO_EMAIL_USUARIO = VISTA_USUARIO + PUNTO + "emailUsuario";
	
	//ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO
	public static final String ID_SECUENCIAL_CONFIGURACION_NIVEL_PAGO = ID + PUNTO + "secuencialConfiguracionNivelPago";
	
	
	//ec.com.smx.sic.cliente.mdl.dto.BaseProveedorDTO
	public static final String NOMBRE_PROVEEDOR = "nombreProveedor";
	
	//ec.com.smx.frameworkv2.security.dto.UserDto
	public static final String USER_NAME = "userName";
	
	public static final String[] NOMBRES_ATRIBUTOS_ID_CATALOGO_VALOR = new String[] {"id.codigoCatalogoValor", "id.codigoCatalogoTipo"};
	
	public static final GetInvokerTransformer CODIGO_VALOR_TRANSFORMADOR = new GetInvokerTransformer(ID_CODIGO_VALOR_CATALOGO);
	public static final GetInvokerTransformer CODIGO_TIPO_TRANSFORMADOR = new GetInvokerTransformer(ID_CODIGO_TIPO_CATALOGO);
	public static final GetInvokerTransformer ES_VALOR_POR_DEFECTO_CATALOGO_TRANSFORMADOR = new GetInvokerTransformer("esValorPorDefecto");
	
	
	//Propiedades dinamicas
	public static final String FUNCIONARIO_EXISTENTE = "funcionarioExistente";
	
	
}
