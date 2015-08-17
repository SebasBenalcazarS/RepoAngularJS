package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.utilitario.dao.commons.constants.DaoFactoryConstants;
import ec.com.smx.corpv2.common.factory.CorporativoFactoryConstantes;
import ec.com.smx.corpv2.plantillas.common.factory.PlantillasFactoryConstantes;
import ec.com.smx.framework.ad.factory.ServicioDatosFactoryConstantes;
import ec.com.smx.frameworkv2.common.factory.FrameworkFactoryConstants;
import ec.com.smx.generadorexportacion.recurso.GeneradorExportacionMessages;

public final class AdministracionFactoryConstantes {
	public final static String[] CONTEXTO = new String[]{
		DaoFactoryConstants.SERVICE_CONTEXTPATH,
		DaoFactoryConstants.SEQUENCE_CONTEXTPATH,
		DaoFactoryConstants.TRANSACTION_MANAGER_CONTEXTPATH,
		SICFactoryConstantes.DATASOURCE_CONTEXTPATH,
		FrameworkFactoryConstants.SEQUENCES_CONTEXTPATH,
		SICFactoryConstantes.SESSIONFACTORY_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_SERVICE_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_SPRING_BATCH_BEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_APLICACIONCACHEBEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_CALCULOSECUENCIABEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_PARAMETROBEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_MIGRACIONBEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_CODIGO_BEAN_CONTEXTPATH,
		ServicioDatosFactoryConstantes.SERVICIO_DATOS_BEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_TRANSACCIONES_BEAN_CONTEXTPATH,
		SICFactoryConstantes.DATOS_CORPORATIVOS_BEAN_ADMINISTRACION_CONTEXTPATH,
		SICFactoryConstantes.ENVIO_MAIL_BEAN_ADMINISTRACION_CONTEXTPATH,
		PlantillasFactoryConstantes.PLANTILLAS_CONTEXTPATH,
		GeneradorExportacionMessages.getString("ec.com.smx.generadorexportacion.commons.contextpath"),
		CorporativoFactoryConstantes.PROCESOS_CONTEXTPATH,
		SICFactoryConstantes.LOG_PROCESOS_MIGRACION_CONTEXTPATH,
	};
}
