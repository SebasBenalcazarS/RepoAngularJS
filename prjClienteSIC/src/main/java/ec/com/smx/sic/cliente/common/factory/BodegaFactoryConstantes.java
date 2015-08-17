package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.resources.DaoMessagesUtil;
import ec.com.smx.autorizaciones.common.factory.AutorizacionesFactoryConstantes;
import ec.com.smx.corpv2.common.factory.CorporativoFactoryConstantes;
import ec.com.smx.interfaz.jde.commons.util.InterfazConstantes;

public final class BodegaFactoryConstantes {
	public final static String[] CONTEXTO = new String[]{
		//Archivos para cargar los bean de bodega para la administracion
		SICFactoryConstantes.BODEGA_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_CALCULO_DATOS_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_DAO_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_SECCION_DAO_CONTEXTPATH,
		SICFactoryConstantes.ESTRUCTURA_LOGISTICA_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.ESTRUCTURA_LOGISTICA_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.ESTRUCTURA_LOGISTICA_BEAN_DAO_CONTEXTPATH,
		SICFactoryConstantes.ESTRUCTURA_LOGISTICA_BEAN_ARCHIVO_BATCH_CONTEXTPATH,
		
		//Archivos para cargar los bean de bodega para la recepcion
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_DAO_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_CALCULO_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_OPERADOR_LOGISTICO_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_CALCULO_ASIGNACION_TAREAS_CONTEXTPATH,
		SICFactoryConstantes.RECEPCION_BODEGA_BEAN_BATCH_CONTEXTPATH,
		
		//Archivos para cargar los bean de bodega para tareas
		SICFactoryConstantes.TAREAS_BODEGA_BEAN_CALCULO_CONTEXTPATH,
		SICFactoryConstantes.TAREAS_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.TAREAS_BODEGA_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.TAREAS_BODEGA_BEAN_SERVICIO_CONTEXTPATH,
		
		//Archivos para cargar los beans de integracion de la bodega
		SICFactoryConstantes.BODEGA_BEAN_ACCION_DAO_CONTEXTPATH,
		SICFactoryConstantes.BODEGA_BEAN_ACCION_GESTOR_CONTEXTPATH,
		
		//Archivos para la lista de proveedores de recepcion
		SICFactoryConstantes.BODEGA_RECEPCION_BEAN_LISTA_PROVEEDORES,
		
		//Autorizaciones por clave
		SICFactoryConstantes.BODEGA_AUTORIZACIONES_BEAN_GESTOR,
		SICFactoryConstantes.BODEGA_AUTORIZACIONES_BEAN_SERVICIO,
		
		//Aspectos bodega
		SICFactoryConstantes.BODEGA_ASPECTOS_BEAN_CONTEXTPATH,
		
		//Archivos para cargar los bean de bodega para los despachos
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_CALCULO_CONTEXTPATH,
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_CONFIGURACION_SECCIONES_TRABAJO_CONTEXTPATH,
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_PARAMETROS_DESPACHO_CONTEXTPATH,
		SICFactoryConstantes.DESPACHO_BODEGA_BEAN_DAO_CONTEXTPATH,
		
		//Archivo para la migracion ordenes de compra
		SICFactoryConstantes.BODEGA_MIGRACION_ORDENES_COMPRA_CONTEXTPATH,
		
		CorporativoFactoryConstantes.PERFILES_CONTEXTPATH,
		CorporativoFactoryConstantes.CARACTERISTICA_PROCESO_AREA_TRABAJO,
		CorporativoFactoryConstantes.FUNCIONARIO_LOGISTICO_CONTEXTPATH,
		
		"/ec/com/smx/sic/bodega/spring/config/administracion/SICMigracionOrdenCompraBatch.xml",
		
		//Data gestor del Utilitario DAO
		DaoMessagesUtil.getString("ec.com.kruger.utilitario.dao.commons.spring.config"),
		AutorizacionesFactoryConstantes.ADMINISTRACION_CONTEXTPATH,
		AutorizacionesFactoryConstantes.AUTORIZACIONES_CLAVE_CONTEXTPATH,
		
		//Interfaz JDE
		InterfazConstantes.CONTEXT_INTERFAZ_GESTOR_BEANS,
		InterfazConstantes.CONTEXT_INTERFAZ_DAO_BEANS
	};
}
