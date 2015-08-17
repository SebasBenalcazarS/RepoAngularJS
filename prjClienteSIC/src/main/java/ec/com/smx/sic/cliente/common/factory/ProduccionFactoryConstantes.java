package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.resources.DaoMessagesUtil;
import ec.com.smx.autorizaciones.common.factory.AutorizacionesFactoryConstantes;

public final class ProduccionFactoryConstantes {
	public final static String[] CONTEXTO = new String[]{
		//beans produccion
		SICFactoryConstantes.PRODUCCION_BEAN_LINEAS_EMPAQUE_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.PRODUCCION_BEAN_LINEAS_EMPAQUE_GESTOR_CONTEXTPATH,
		SICFactoryConstantes.PRODUCCION_BEANS_LINEAS_EMPAQUE_DAO_CONTEXTPATH,
		
		//beans externos produccion
		DaoMessagesUtil.getString("ec.com.kruger.utilitario.dao.commons.spring.config"),
		AutorizacionesFactoryConstantes.ADMINISTRACION_CONTEXTPATH
	};
}
