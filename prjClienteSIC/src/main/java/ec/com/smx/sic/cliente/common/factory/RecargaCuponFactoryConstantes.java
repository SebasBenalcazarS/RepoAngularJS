package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.ftp.common.factory.FTPFactoryConstantes;
import ec.com.kruger.utilitario.dao.commons.constants.DaoFactoryConstants;
import ec.com.smx.corpv2.common.factory.CorporativoFactoryConstantes;
import ec.com.smx.generadorexportacion.util.GeneradorExportacionConstantes;
import ec.com.smx.integracion.commons.factory.IntegracionFactoryConstants;

public final class RecargaCuponFactoryConstantes {
	public final static String[] CONTEXTO = new String[] {
		DaoFactoryConstants.SERVICE_CONTEXTPATH,
		//DaoFactoryConstants.TRANSACTION_MANAGER_CONTEXTPATH,
		FTPFactoryConstantes.FTP_GESTOR_CONTEXTPATH,
		SICFactoryConstantes.SESSIONFACTORY_CONTEXTPATH,
		SICFactoryConstantes.DATASOURCE_CONTEXTPATH,
		GeneradorExportacionConstantes.GENERADOR_EXPORTACION_BATCH_CONTEXTPATH,
		CorporativoFactoryConstantes.DISPOSITIVOS_MOVILES_CONTEXTPATH,
		SICFactoryConstantes.ASISTENTE_COMPRAS_BEAN_GESTOR_CONTEXTPATH,
		SICFactoryConstantes.ASISTENTE_COMPRAS_BEAN_GESTOR_BATCH_CONTEXTPATH,
		SICFactoryConstantes.ASISTENTE_COMPRAS_BEAN_SERVICIO_CONTEXTPATH,
		IntegracionFactoryConstants.PATH_XML_INTEGRACION_SERVICIO_TAREA_PROGRAMADA,
		SICFactoryConstantes.ASISTENTE_COMPRAS_BEAN_TASK_CONTEXTPATH
		};
}
