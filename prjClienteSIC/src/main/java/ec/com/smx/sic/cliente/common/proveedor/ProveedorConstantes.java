/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.util.List;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.sic.cliente.common.proveedor.bean.EstadosArticuloProveedor;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Mario Braganza
 *
 */
public final class ProveedorConstantes {
	
	private static final ProveedorConstantes INSTANCIA = new ProveedorConstantes();
	
	private ProveedorConstantes(){
		//
	}
	
	public static ProveedorConstantes getInstancia(){
		return INSTANCIA;
	}
	
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String CODIGO_SISTEMA_B2B = "B2B";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String CODIGO_PROVEEDOR_SUPER_USUARIO_PRINCIPAL = "B2B19";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String ROL_ADMINISTRADOR_B2B = "B2BPROADM";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String IDENTIFICADOR_PORTAL_ADMINISTRADOR_CONTENIDOS = "B2B8";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String VALOR_PARAMETRO_B2B_ROL_PRIVADO_CMS = "B2B5";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String VALOR_PARAMETRO_B2B_NUMERO_USUARIOS_ACTIVOS = "B2B7";
	
	/**
	 * @deprecated Esta constante es temporal hasta quitar la dependencia del B2B en el MAX
	 */
	public static final String ROL_PEDIDOS_B2B = "B2BPED";
	
	public static final String CODIGO_REGISTRO_AUDITORIA_DATOS_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.auditoria.deficion.registro.datos.proveedor");
	public static final String CODIGO_CAMBIO_DATOS_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.auditoria.deficion.cambio.datos.proveedor");
	public static final String CODIGO_CAMBIO_DATOS_CONDICIONESCOMERCIALES = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.auditoria.deficion.cambio.datos.condiciones.comerciales");
	public static final String PROVEEDOR_IMPORTADO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado");
	public static final String PROVEEDOR_NACIONAL = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.nacional");
	public static final String PREFIJO_ID_USUARIO_ADMINISTRADOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.prefijo.idUsuario.administrador.b2b");
	public static final String PREFIJO_CUENTA_ADMINISTRADOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.prefijo.cuenta.administrador.b2b");
	public static final String PREFIJO_NOMBRE_ADMINISTRADOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.prefijo.nombre.administrador.b2b");
	public static final String PREFIJO_NOMBRE_ADMINISTRADOR_SERVICIOS = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.prefijo.nombre.administrador.b2b.servicios");
	public static final String PATRON_PREFIJO_CODIGO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.patron.prefijo.codigoProveedor");
	public static final String RELLENO_PREFIJO_CODIGO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.relleno.prefijo.codigoProveedor");
	public static final String PATRON_SUFIJO_CODIGO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.patron.sufijo.codigoProveedor");
	public static final String PATRON_CODIGO_PROVEEDOR = PATRON_PREFIJO_CODIGO_PROVEEDOR + PATRON_SUFIJO_CODIGO_PROVEEDOR;
	public static final String ESTADO_DEFECTO_USUARIO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.estado.usuario.defecto");
	public static final String TIPO_DEFECTO_USUARIO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipo.rol.usuario.defecto");
	public static final String PASSWORD_ENCRIPTADO_DEFECTO_USUARIO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.password.encriptado.defecto");
	public static final Integer LONGITUD_MAXIMA_NOMBRE_PROVEEDOR = 46;
	public static final Integer LONGITUD_INICIAL_PASSWORD_USUARIO_PROVEEDOR = 100000;
	public static final Integer TIPOLOG_AUDITORIAPROVEEDOR = SICProveedorMessages.getInstancia().getInteger("ec.com.smx.sic.proveedor.auditoria.proveedor.tipoLog");
	public static final String[] ESTADOS_ACTIVOS_PERSONA_PROVEEDOR = {CorporativoConstantes.ESTADO_ACTIVO };
	public static final String[] ESTADOS_ACTIVOS_LOCALIZACION_PROVEEDOR = {CorporativoConstantes.ESTADO_PENDIENTE_MIGRAR , CorporativoConstantes.ESTADO_SUSPENDIDO , CorporativoConstantes.ESTADO_CANCELADO, CorporativoConstantes.ESTADO_ACTIVO };
	public static final String REGISTRA_PARTICIPACIONES_ACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.registraParticipaciones.activo");
	public static final String REGISTRA_PARTICIPACIONES_INACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.registraParticipaciones.inactivo");
	public static final String ACCESO_PRONTOPAGO_ACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.autorizadoProntopago.activo");
	public static final String ACCESO_PRONTOPAGO_INACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.autorizadoProntopago.inactivo");
	public static final String ENVIO_EMAIL_PEDIDOS_ACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.envioEmail.activo");
	public static final String ENVIO_EMAIL_PEDIDOS_INACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.envioEmail.inactivo");
	public static final String INTERPROVEEDOR_ACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.interproveedor.activo");
	public static final String INTERPROVEEDOR_INACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.interproveedor.inactivo");
	public static final Boolean CONTINGENCIA_BASE_FINANCIERA_ACTIVA = SICProveedorMessages.getInstancia().getBoolean("ec.com.smx.sic.activar.contingencia.base.financiera");
	public static final String PROVEEDOR_IMPORTADOR_ACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importador.activo");
	public static final String PROVEEDOR_IMPORTADOR_INACTIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importador.inactivo");
	public static final List<EstadosProveedor> ESTADOS_PROVEEDOR = EstadosProveedor.getEstadosProveedor();
	public static final List<EstadosArticuloProveedor> ESTADOS_ARTICULO_PROVEEDOR = EstadosArticuloProveedor.getEstadosArticuloProveedor();
	public static final List<OrigenProveedor> ORIGEN_PROVEEDOR = OrigenProveedor.getOrigenProveedor();
	public static final List<TipoBusquedaProveedor> TIPO_BUSQUEDAS_PROVEEDOR = TipoBusquedaProveedor.getTipoBusquedasProveedor();
	public static final String VALOR_PLAZO_PAGO_DEFECTO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.clasificacion.valor.plazopago.defecto");
	public static final String CODIGO_CATALOGO_VALOR_FACTURA_EN_SITIO_SI = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.codigo.catalogoValor.facturaEnSitio.si");
	public static final String CODIGO_FACTURAR_PROMOCION_OFICINA_EXTERIOR_SI = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.codigo.catalogoValor.facturar.promocion.oficina.exterior.si");
	public static final String IMAGEN_CABECERA_CORREO_ELECTRONICO = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.proveedor.correo.electronico.imagen.cabecera");
	public static final String PROVEEDOR_SERVICIOS_DOCUMENTO = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.proveedor.servicios.migracion.documento");
	
	//PARAMETRO PARA ESTABLECER EL TAMANO MAXIMO DEL ARCHIVO CERTIFICADO PROVEEDOR
	public static final String PARAMETRO_MAXIMO_ARCHIVO_CERTIFICADO = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.parametro.maxima.capacidad.archivo");
	public static final String SECUENCIAL_CERTIFICADO_ARCHIVO = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.secuencial.certificado.proveedor.archivo");
	public static final String SECUENCIAL_MIGRACION_PROVEEDOR_SERVICIOS = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.secuencial.migracion.proveedor.servicios");
}
