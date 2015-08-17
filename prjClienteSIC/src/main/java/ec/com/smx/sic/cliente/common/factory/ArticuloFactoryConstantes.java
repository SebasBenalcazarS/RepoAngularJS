package ec.com.smx.sic.cliente.common.factory;

import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ACCION_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ADMINBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_AGRUPADOR_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCES_ARCHIVO_ARTICULO_BATCH_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCES_ARCHIVO_BATCH_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCES_BATCH_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCE_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCE_NOSQL_BATCH_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ALCANCE_NOSQL_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ARCHIVO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_AUDITORIA_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_CLASIFICACION_DAO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_FUNCIONARIOAREATRABAJO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_MASIVO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_MERCANCIAS_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_PROCESO_LOGISTICO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_SOLICITUDIMPRESION_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_USUARIO_AUTORIZACION_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_CALSEC_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_CATALOGOBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ESTCOMBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_LINCOMBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_NOVEDAD_CUPON_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_PROMOCION_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_PROVACC_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_PROVEEDOR_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_PROVEEDOR_IMPORTACION_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_REGSANBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_RELACIONADO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_ROTULADOBEAN_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_SERVICE_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_TAREAPROGRAMADA_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_UNIDADMANEJO_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ASISTENTE_COMPRAS_BEAN_GESTOR_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.DATASOURCE_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.PROVEEDOR_CLASIFICACION_BEAN_ALMACENAMIENTO_CONTEXPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.SESSIONFACTORY_CONTEXTPATH;
import static ec.com.smx.sic.cliente.common.factory.SICFactoryConstantes.ARTICULO_BEAN_VALIDACION_DATOS_CONTEXTPATH;
import ec.com.kruger.utilitario.dao.resources.DaoMessagesUtil;
import ec.com.smx.corpv2.etiquetado.commons.factory.EtiquetadoFactoryConstants;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;

public final class ArticuloFactoryConstantes {
	public final static String[] CONTEXTO = new String[]{
		DaoMessagesUtil.getString("ec.com.kruger.utilitario.dao.commons.spring.config"),
		SESSIONFACTORY_CONTEXTPATH,
		DATASOURCE_CONTEXTPATH,
		ARTICULO_SERVICE_CONTEXTPATH,
		ARTICULO_ADMINBEAN_CONTEXTPATH,
		ARTICULO_UNIDADMANEJO_CONTEXTPATH,
		ARTICULO_REGSANBEAN_CONTEXTPATH,
		ARTICULO_ROTULADOBEAN_CONTEXTPATH,
		ARTICULO_CATALOGOBEAN_CONTEXTPATH,
		ARTICULO_ESTCOMBEAN_CONTEXTPATH,
		ARTICULO_ALCANCE_CONTEXTPATH,
		ARTICULO_ALCANCE_NOSQL_CONTEXTPATH,
		ARTICULO_LINCOMBEAN_CONTEXTPATH,
		ARTICULO_PROVEEDOR_CONTEXTPATH,
		ARTICULO_PROVACC_CONTEXTPATH,
		ARTICULO_ARCHIVO_CONTEXTPATH,
		ARTICULO_ACCION_CONTEXTPATH,
		ARTICULO_CALSEC_CONTEXTPATH,
		PROVEEDOR_CLASIFICACION_BEAN_ALMACENAMIENTO_CONTEXPATH,
		ARTICULO_PROMOCION_CONTEXTPATH,
		ARTICULO_RELACIONADO_CONTEXTPATH,
		ARTICULO_ALCANCES_BATCH_CONTEXTPATH,
		ARTICULO_ALCANCES_ARCHIVO_BATCH_CONTEXTPATH,
		ARTICULO_ALCANCES_ARCHIVO_ARTICULO_BATCH_CONTEXTPATH,
		ARTICULO_ALCANCE_NOSQL_BATCH_CONTEXTPATH,
		ARTICULO_AGRUPADOR_CONTEXTPATH,
		ARTICULO_TAREAPROGRAMADA_CONTEXTPATH,
		ASISTENTE_COMPRAS_BEAN_GESTOR_CONTEXTPATH,
		ARTICULO_PROVEEDOR_IMPORTACION_CONTEXTPATH,
		ARTICULO_NOVEDAD_CUPON_CONTEXTPATH,
		ARTICULO_BEAN_AUDITORIA_CONTEXTPATH,
		ARTICULO_BEAN_SOLICITUDIMPRESION_CONTEXTPATH,
		ARTICULO_BEAN_MERCANCIAS_CONTEXTPATH,
		ARTICULO_BEAN_MASIVO_CONTEXTPATH,
		ARTICULO_BEAN_PROCESO_LOGISTICO_CONTEXTPATH,
		ARTICULO_BEAN_USUARIO_AUTORIZACION_CONTEXTPATH,
		ARTICULO_BEAN_CLASIFICACION_DAO_CONTEXTPATH,
		ARTICULO_BEAN_FUNCIONARIOAREATRABAJO_CONTEXTPATH,
		EtiquetadoFactoryConstants.ETIQUETADO_SOLICITUDIMPRESION_CONTEXTPATH,
		MensajeriaMessages.getString("ec.com.smx.mensajeria.commons.contextpath"),ARTICULO_BEAN_VALIDACION_DATOS_CONTEXTPATH
	};
}
