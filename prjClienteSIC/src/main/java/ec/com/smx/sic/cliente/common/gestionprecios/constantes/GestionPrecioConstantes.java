/**
 * 
 */
package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import java.util.List;

import ec.com.smx.sic.cliente.common.cambioprecios.constantes.TipoBusquedaCambioPrecios;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;
import ec.com.smx.sic.cliente.resources.convenios.SICConvenioMessages;


/**
 * @author Luis Yacchirema
 *
 */
public final class GestionPrecioConstantes {
	
	private static final GestionPrecioConstantes INSTANCIA = new GestionPrecioConstantes();
	
	private GestionPrecioConstantes() { }
	
	public static GestionPrecioConstantes getInstancia(){
		return INSTANCIA;
	}
	
	// Estado generico gestion precio
	public final String VALOR_ESTADO_GESTION_PRECIO_NO_APLICA = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.gestionprecio.valor.estado.no.aplica");

	// Valores secuenciales
	public final String SECUENCIA_GESTION_PRECIO = "SCPRESECGESPRE";
	public final String SECUENCIA_GRUPO_AFECTACION_PRECIO = "SCPRESECGRUAFEPRE";
	public final String SECUENCIA_VALOR_AFECTACION_PRECIO = "SCPRESECVALAFEPRE";
	
	// Valor tipo gestion precios
    public final String VALOR_TIPO_GESTION_PRECIO_PROMOCION = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.promocion");
    public final String VALOR_TIPO_GESTION_PRECIO_CAMBIO_PRECIOS = "CPR";
    public final String VALOR_TIPO_GESTION_PRECIO_OFERTA = "OFE";
    public final String VALOR_TIPO_GESTION_PLANTILLA = "PLT";
    public final String VALOR_TIPO_GESTION_CAMPANIA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.campania");
    public final String VALOR_TIPO_GESTION_PRECIO_PARTICIPANTE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.participante");
    
    // VALOR TIPO NEGOCIACION COBRO
    public final String VALOR_TIPO_NEGOCIACION_COBRO_PENDIENTE = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.pendiente");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_CONFIGURADA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.configurada");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_EN_CURSO = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.en.curso");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_FINALIZADA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.finalizada");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_COBRADA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.cobrada");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_VENCIDA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.vencida");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_CANCELADA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.cancelada");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_PLANIFICADA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.planificada");
    public final String VALOR_TIPO_NEGOCIACION_COBRO_SUSPENDIDA = SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.suspendida");
    public final String VALOR_ESTADO_COBRO_PENDIENTE = "PENDIENTE";
    
    
    // Estados gestion precios
    public final String VALOR_ESTADO_GESTION_PRECIO_PENDIENTE = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.pendiente");
    public final String VALOR_ESTADO_GESTION_PRECIO_CONFIRMADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.confirmado");
    public final String VALOR_ESTADO_GESTION_PRECIO_AUTORIZADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.autorizado");
    public final String VALOR_ESTADO_GESTION_PRECIO_DESAUTORIZADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.desautorizado");
    public final String VALOR_ESTADO_GESTION_PRECIO_ANULADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.anulado");
    public final String VALOR_ESTADO_GESTION_PRECIO_POR_FINALIZAR = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.estado.por.finalizar");
    
    // Unidades variacion precios
    public final String VALOR_UNIDAD_VARIACION_PRECIO_PORCENTAJE = "PCJ";
    public final String VALOR_UNIDAD_VARIACION_PRECIO_MONEDA = "MDA";
    
    // Signos variacion precios
    public final String VALOR_SIGNO_VARIACION_PRECIO_SUMA = "SUM";
    public final String VALOR_SIGNO_VARIACION_PRECIO_RESTA = "RES";
    public final String VALOR_SIGNO_VARIACION_PRECIO_IGUAL = "IGU";
    
    // Estado ejecucion gestion precio
    public final String VALOR_ESTADO_EJECUCION_GESTION_PRECIO_PENDIENTE = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.gestionprecio.valor.estado.ejecucion.pendiente");
    public final String VALOR_ESTADO_EJECUCION_GESTION_PRECIO_PROCESADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.gestionprecio.valor.estado.ejecucion.procesado");
    public final String VALOR_ESTADO_EJECUCION_GESTION_PRECIO_FINALIZADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.gestionprecio.valor.estado.ejecucion.finalizado");    
    
    // Tipos de busqueda de cambios de precios
    public final List<TipoBusquedaCambioPrecios> TIPO_BUSQUEDAS_CAMBIO_PRECIO = TipoBusquedaCambioPrecios.getTipoBusquedasCambioPrecio();
	
	/**
	 * ********************************
	 * CONSTANTES DE CAMBIO DE PRECIOS
	 * ********************************
	 */
	public final String CODIGO_REFERENCIA_VARIACION_VALOR = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.referencia.variacion.valor");
	public final String CODIGO_REFERENCIA_VARIACION_AFECTACION = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.codigo.referencia.variacion.afectacion");

	// Datos tabla cambio precios
	public final String COLUMN_ID = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.columna.id");
	public final String COLUMN_NIVEL = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.columna.nivel");
	public final String COLUMN_PADRE = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.tabla.columna.padre");
	
	//Datos para validar el calculo en cambio de precios por costo bruto segun parametro
	public final String VALOR_PARAMETRO_COSTO_BRUTO_ACTUAL = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametro.usar.costo.bruto.actual");
	public final String VALOR_PARAMETRO_COSTO_BRUTO_PROVEEDOR = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametro.usar.costo.bruto.proveedor");
	
	//Datos para validar el ingreso de la fecha de vigencia en cambios de precios
	public final String CANTIDAD_MESES_FECHA_VIGENCIA_COSTO_CAMBIO_PRECIOS = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.fecha.vigencia.maxima.costo.meses");
	public final String CANTIDAD_MESES_FECHA_VIGENCIA_VENTA_CAMBIO_PRECIOS = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.fecha.vigencia.maxima.venta.meses");
	public final String CANTIDAD_DIAS_FECHA_RETORNO_COSTO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.fecha.vigencia.maxima.dias.retorno.costo");
	public final String CANTIDAD_DIAS_FECHA_RETORNO_VENTA = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.fecha.vigencia.maxima.dias.retorno.venta");
	public final String CANTIDAD_MESES_FECHAS_VIGENCIA_UNIFICADAS = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.fecha.vigencia.unificada.maxima.meses");
	
	//Nombres tabla bitacora valor costo
	public final String NOMBRE_TABLA_BITACORA_VALOR_COSTO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.bitacora.valor.costo");
	public final String NOMBRE_TABLA_BITACORA_ARTICULO_GESTION_PRECIO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.bitacora.articulo.gestio.precio");
	public final String NOMBRE_TABLA_ARTICULO_GESTION_PRECIO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.articulo.gestio.precio");
	public final String NOMBRE_TABLA_VALOR_COSTO_GESTION = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.nombre.tabla.valor.costo.gestion");

	//PARAMETRO PARA ESTABLECER EL TAMANO MAXIMO DEL ARCHIVO DE CAMBIO DE PRECIOS
	public final String PARAMETRO_MAXIMO_ARCHIVO_CAMBIO_PRECIOS = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.parametro.maxima.capacidad.archivo");
	
	// PARAMETRO PARA OBTENER LA IP DE LOS SERVICIOS WEB LOYALTY (PROMOCIONES)
	public final String IP_WEBSERVICE_LOYALTY = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.promociones.webservice.ip");
	
	// Cantidad para la consulta maxima de los selects con in
	public final Integer CANTIDAD_DATOS_CONSULTA_DINAMICA = SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cantidad.maximo.consultas.dinamicas");
	public final Integer CANTIDAD_DATOS_CONSULTA_PAGINADA = SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cantidad.maximo.consultas.paginadas");
	
	// Cantidad para envio maximo de articulos a integracion
	public final Integer CANTIDAD_DATOS_ENVIO_INTEGRACION_CAMBIO_PRECIOS = SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cantidad.maximo.envio.integracion.cambio.precios");
		
	//Parametro codigo del proceso para anular ordenes de compra por defecto y su catalogo valor
	public final String PROCESO_ANULAR_ORDEN_COMPRA_POR_DEFECTO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.proceso.anular.ordenes.compra.por.defecto");  
	public final String CATALOGO_VALOR_ANULAR_ORDEN_COMPRA_POR_DEFECTO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.gestionprecio.catalogo.valor.anular.orden.compra.por.defecto");
	
	//Estados conflictos precios diferenciados
	public final String ESTADO_PRECIO_DIFERENCIADO_NUEVO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.nuevo");
	public final String ESTADO_PRECIO_DIFERENCIADO_MODIFICADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.modificado");
	public final String ESTADO_PRECIO_DIFERENCIADO_ELIMINADO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.eliminado");
	public final String ESTADO_PRECIO_DIFERENCIADO_NINGUNO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.ninguno");
	
	// Posibles diferencias entre precios diferenciados
	public final String PROPIEDAD_PRECIO_SMX_NUEVO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.precio.nuevo");
	public final String PROPIEDAD_PORCENTAJE_NUEVO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.porcentaje.nuevo");
	public final String PROPIEDAD_MARGEN_NUEVO = SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.precio.diferenciado.margen.nuevo");
	
	// Estructura comercial precios
    public final String DESCRIPCION_DIVISION = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.descripcion.division");
    public final String DESCRIPCION_DEPARTAMENTO= SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.descripcion.departamento");
    public final String DESCRIPCION_CLASIFICACION= SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.descripcion.clasificacion");
    public final String CODIGO_DIVISION = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.division");
    public final String CODIGO_DEPARTAMENTO = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.departamento");
    public final String CODIGO_CLASIFICACION = SICMessages.getInstancia().getString("ec.com.smx.sic.estructuraComercial.clasificacion");
}
