package ec.com.smx.sic.cliente.common.factory;

import ec.com.kruger.jarimbak.commons.resource.JarimbaKModelMessages;
import ec.com.kruger.utilitario.dao.resources.DaoMessagesUtil;
import ec.com.kruger.workflow.commons.factory.WorkflowContextUtil;
import ec.com.smx.bi.commons.resources.BIMessages;
import ec.com.smx.corpv2.common.factory.CorporativoFactoryConstantes;
import ec.com.smx.frameworkv2.auditoria.common.factory.AuditFactoryConstantes;
import ec.com.smx.frameworkv2.common.factory.FrameworkFactoryConstants;
import ec.com.smx.frameworkv2.resources.FrameworkMessages;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.ppago.jde.commons.factory.ProntoPagoJdeFactoryConstantes;
import ec.com.smx.sic.integracion.max.common.factory.IntegracionMaxFactoryConstantes;
import ec.com.smx.stp.commons.util.MessagesAplicacionSTP;

public final class ProveedorFactoryConstantes {

	public final static String[] CONTEXTO = new String[]{
		FrameworkFactoryConstants.SECURITY_CONTEXTPATH,
		FrameworkFactoryConstants.MULTICOMPANY_CONTEXTPATH,
		FrameworkFactoryConstants.COMMON_CONTEXTPATH,
		FrameworkFactoryConstants.PROFILES_CONTEXTPATH,
		FrameworkFactoryConstants.JARIMBA_CONTEXTPATH,
		FrameworkMessages.getString("ec.com.smx.frameworkv2.spring.config.menu"),
		CorporativoFactoryConstantes.EMPRESAS_CONTEXTPATH,
		CorporativoFactoryConstantes.PERFILES_CONTEXTPATH,
		CorporativoFactoryConstantes.PERSONAS_CONTEXTPATH,
		CorporativoFactoryConstantes.FUNCIONARIOS_CONTEXTPATH,
		CorporativoFactoryConstantes.AREAS_TRABAJO_CONTEXTPATH,
		CorporativoFactoryConstantes.DIVISIONES_GEOPOLITICAS_CONTEXTPATH,
		CorporativoFactoryConstantes.ESTABLECIMIENTO_CONTEXTPATH,
		CorporativoFactoryConstantes.DATOSCONTACTOPERLO_CONTEXTPATH,
		CorporativoFactoryConstantes.COMMON_CONTEXTPATH,
		CorporativoFactoryConstantes.CATALOGOS_CONTEXTPATH,
		BIMessages.getString("ec.com.smx.bi.commons.contextpath.spring"),
		MensajeriaMessages.getString("ec.com.smx.mensajeria.commons.contextpath"),
		JarimbaKModelMessages.getString("ec.com.kruger.jarimbak.commons.contextpath.spring"),
		MessagesAplicacionSTP.getString("ec.com.smx.stp.commons.contextpath.spring"),
		WorkflowContextUtil.PATH_XML_WORKFLOW_CONTEXT,
		SICFactoryConstantes.PROVEEDOR_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_ADMINISTRACION_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_OFICINA_EXTERIOR_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_TIPO_PROVEEDOR_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_CALCULO_DATOS_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_AUDITORIA_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_DATOS_USUARIOS_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_DATOS_CONTACTOS_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_BEAN_BUSQUEDA_PROVEEDOR_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_CLASIFICACION_BEAN_CALCULO_CONTEXPATH,
		SICFactoryConstantes.PROVEEDOR_CLASIFICACION_BEAN_ALMACENAMIENTO_CONTEXPATH,
		SICFactoryConstantes.PROVEEDOR_CLASIFICACION_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.FUNCIONARIO_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.FUNCIONARIO_BEAN_VALIDACION_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_FUNCIONARIO_RELACIONADO_BEAN_DAO_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_SERVICE_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_APLICACIONCACHEBEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_CALCULOSECUENCIABEAN_CONTEXTPATH,
		SICFactoryConstantes.ADMIN_PARAMETROBEAN_CONTEXTPATH,
		SICFactoryConstantes.MARCA_PROVEEDOR_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.MARCA_PROVEEDOR_BEAN_CALCULO_DATOS_CONTEXTPATH,
		SICFactoryConstantes.MARCA_PROVEEDOR_BEAN_ALMACENAMIENTO_CONTEXTPATH,
		SICFactoryConstantes.DATASOURCE_CONTEXTPATH,
		SICFactoryConstantes.SESSIONFACTORY_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_ASPECTOS_BEAN_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_SERVICIOS_BEAN_ADMINISTRACION_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_SERVICIOS_BEAN_DAO_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_SERVICIOS_BEAN_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_AREA_TRABAJO_SERVICIO_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_AREA_TRABAJO_BEAN_CALCULO_DATOS_CONTEXTPATH,
		SICFactoryConstantes.PROVEEDOR_AREA_TRABAJO_BEAN_ALMACENAMIENTO_DATOS_CONTEXTPATH,
		DaoMessagesUtil.getString("ec.com.kruger.utilitario.dao.commons.spring.config"),
		FrameworkFactoryConstants.SEQUENCES_CONTEXTPATH,
		ec.com.smx.framework.resources.FrameworkMessages.getString("ec.com.smx.framework.persistence.i18n.contextpath"),
		AuditFactoryConstantes.AUDIT_BEANS,
		ProntoPagoJdeFactoryConstantes.getInstancia().JDE_CONTEXT_PATH,
		ProntoPagoJdeFactoryConstantes.getInstancia().JDE_DATA_SOURCE_CONTEXT_PATH,
		IntegracionMaxFactoryConstantes.INTEGRACION_DATOS_CORPORATIVOS_PROVEEDOR_BEANS
	};
}
