package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.resources.DaoMessagesUtil;
import ec.com.smx.corpv2.common.factory.CorporativoFactoryConstantes;

public final class SICOficinaExteriorFactoryConstantes {

	public final static String[] CONTEXTO = new String[]{
		SICFactoryConstantes.OFICINA_EXTERIOR_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.OFICINA_EXTERIOR_BEAN_CALCULO_DATOS_CONTEXTPATH,
		SICFactoryConstantes.OFICINA_EXTERIOR_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.OFICINA_EXTERIOR_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.DATASOURCE_CONTEXTPATH,
		SICFactoryConstantes.SESSIONFACTORY_CONTEXTPATH,

		//Beans del corporativo
		CorporativoFactoryConstantes.DATOSCONTACTOPERLO_CONTEXTPATH,
		DaoMessagesUtil.getString("ec.com.kruger.utilitario.dao.commons.spring.config")
	};
}
