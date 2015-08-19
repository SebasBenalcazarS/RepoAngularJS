/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.util;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.index.OCompositeKey;
import com.orientechnologies.orient.core.index.OIndex;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.framework.utilitario.nosql.common.exception.NoSQLException;
import ec.com.smx.framework.utilitario.nosql.common.util.OIndexUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloEstablecimientoFields;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * Clase para crear los indices que se necesitan para el proceso de alcance con orientDB
 * @author wcaiza
 *
 */
public final class ArticuloAlcanceIndexNoSqlUtil implements Logeable, Serializable {
	
	private ArticuloAlcanceIndexNoSqlUtil () {}
	
//	/**
//	 * Registrar todos los indices que se necesitan para la clase ArticuloLocalDTO de OrientDB
//	 * @param db
//	 * @param colODocumentArticuloLocal
//	 * @throws SICException
//	 */
//	public static void registrarIndicesODocumentArticuloLocalDTO (ODatabaseDocumentTx db, ODocument ... colODocumentArticuloLocal) throws SICException {
//		
//		try {
////			OIndex<?> indexLocalArticulo = obtenerOIndex(db, ArticuloLocalIndices.INDEX_LOCAL_ARTICULO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.LINK});
////			OIndex<?> indexArticuloLocal = obtenerOIndex(db, ArticuloLocalIndices.INDEX_ARTICULO_LOCAL, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.LINK});
//
//			OIndex<?> indexLocalArticulo = IndiceArticuloAlcanceNoSql.getInstancia().getIndiceAreaTrabajoArticulo(db);
//			OIndex<?> indexArticuloLocal = IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloAreaTrabajo(db);
//
//			OIndex<?> indexLocalArticuloAreaTrabajo = obtenerOIndex(
//					db, ArticuloLocalIndices.INDEX_LOCAL_ARTICULO_AREA_TRABAJO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.STRING, OType.LINK});
//			OIndex<?> indexArticuloLocalAreaTrabajo = obtenerOIndex(
//					db, ArticuloLocalIndices.INDEX_ARTICULO_LOCAL_AREA_TRABAJO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.STRING, OType.LINK});
//			
//			
//			
//			for (ODocument oDocumentArticuloLocal : colODocumentArticuloLocal) {
//				registarIndiceLocalArticulo(oDocumentArticuloLocal, indexLocalArticulo);
//				registarIndiceArticuloLocal(oDocumentArticuloLocal, indexArticuloLocal);
//				registarIndiceLocalArticuloAreaTrabajo(oDocumentArticuloLocal, indexLocalArticuloAreaTrabajo);
//				registarIndiceArticuloLocalAreaTrabajo(oDocumentArticuloLocal, indexArticuloLocalAreaTrabajo);
////				registrarIndiceGrupoAlcanceAreaTrabajo(oDocumentArticuloLocal, indexGrupoAlcanceAreatrabajo);
////				registrarIndiceGrupoAlcanceArticulo(oDocumentArticuloLocal, indexGrupoAlcanceArticulo);
//			}
//		} catch (SICException e) {
//			LOG_SICV2.error("Error al registrar registrarIndicesODocumentArticuloLocalDTO: {}", e.toString());
//			throw e;
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registrar registrarIndicesODocumentArticuloLocalDTO: {}", e.toString());
//			throw new SICException(e);
//		}
//		
//	}
	
	
//	private static void registrarIndiceGrupoAlcanceAreaTrabajo(ODocument oDocumentArticuloLocal, OIndex<?> index) throws SICException {
//		try {
//			OCompositeKey articuloLocalKey =  new OCompositeKey();
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//			index.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registrar el indice grupo alcance - area de trabajo: {}", e.toString());
//			throw new SICException(e);
//		}
//	}
	
//	private static void registrarIndiceGrupoAlcanceArticulo(ODocument oDocumentArticuloLocal, OIndex<?> index) throws SICException {
//		try {
//			OCompositeKey articuloLocalKey =  new OCompositeKey();
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//			articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//			index.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registrar el indice grupo alcance - articulo: {}", e.toString());
//			throw new SICException(e);
//		}
//	}
	
//	/**
//	 * Registrar el indice local art&iacute;culo (codigoCompania, codigoLocal, codigoArticulo)
//	 * @param oDocumentArticuloLocal
//	 * @param indexLocalArticulo
//	 */
//	private static void registarIndiceLocalArticulo(ODocument oDocumentArticuloLocal, OIndex<?> indexLocalArticulo){
//		
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		articuloLocalKey.reset();
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//		indexLocalArticulo.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//		
//	}
	
//	/**
//	 * Registrar el indice local art&iacute;culo (codigoCompania, codigoLocal, codigoArticulo)
//	 * @param oDocumentArticuloLocal
//	 * @param indexArticuloLocal
//	 */
//	private static void registarIndiceArticuloLocal(ODocument oDocumentArticuloLocal, OIndex<?> indexArticuloLocal) {
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		articuloLocalKey.reset();
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//		indexArticuloLocal.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//	}
	
//	/**
//	 * Registrar el indice local art&iacute;culo area trabajo (codigoCompania, codigoLocal, valor tipo area trabajo, codigoArticulo).
//	 * @param oDocumentArticuloLocal
//	 * @param indexLocalArticuloAreaTrabajo
//	 */
//	private static void registarIndiceLocalArticuloAreaTrabajo(ODocument oDocumentArticuloLocal, OIndex<?> indexLocalArticuloAreaTrabajo) {
//		
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		articuloLocalKey.reset();
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//		indexLocalArticuloAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//		articuloLocalKey = null;
//		
//	}
	
//	/**
//	 * Registrar el indice art&iacute;culo local area trabajo (codigoCompania, codigoArticulo, valor tipo area trabajo, codigoLocal).
//	 * @param oDocumentArticuloLocal
//	 * @param indexArticuloLocalAreaTrabajo
//	 */
//	private static void registarIndiceArticuloLocalAreaTrabajo(ODocument oDocumentArticuloLocal, OIndex<?> indexArticuloLocalAreaTrabajo) {
//		
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		articuloLocalKey.reset();
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_COMPANIA));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_ARTICULO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.CODIGO_LOCAL));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
//		articuloLocalKey.addKey(oDocumentArticuloLocal.getIdentity());
//		indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocal.getIdentity());
//		articuloLocalKey = null;
//	}
	
//	/**
//	 * Registrar todos los indices que se necesitan para la clase ArticuloAreaTrabajoBitacoraDTO de OrientDB
//	 * @param db
//	 * @param colODocumentArticuloLocal
//	 */
//	public static void registrarIndicesODocumentArticuloLocalBitacora (ODatabaseDocumentTx db, ODocument ... colODocumentArticuloLocal) {
//		
//		OIndex<?> indexArticuloLocalBitacoraRid = obtenerOIndex(db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_RID, new OType[]{OType.LINK, OType.LINK});
////		OIndex<?> indexArticuloLocalBitacoraLocalArticulo = obtenerOIndex(
////				db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_LOCAL_ARTICULO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.LINK});
////		OIndex<?> indexArticuloLocalBitacoraArticuloLocal = obtenerOIndex(
////				db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_ARTICULO_LOCAL, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.LINK});
//		OIndex<?> indexArticuloLocalBitacoraLocalArticulo = getIndiceBitacoraAreaTrabajoArticulo(db);
//		OIndex<?> indexArticuloLocalBitacoraArticuloLocal = getIndiceBitacoraArticuloAreaTrabajo(db);
//
//		OIndex<?> indexArticuloLocalBitacoraLocalArticuloAreaTrabajo = obtenerOIndex(
//				db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_LOC_ART_ARE_TRA, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.STRING, OType.LINK});
//		OIndex<?> indexArticuloLocalBitacoraArticuloLocaloAreaTrabajo = obtenerOIndex(
//				db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_ART_LOC_ARE_TRA, new OType[]{OType.INTEGER, OType.STRING,  OType.INTEGER,OType.STRING, OType.LINK});
//		
//		for (ODocument oDocumentArticuloLocal : colODocumentArticuloLocal) {
//			
//			registarIndiceArticuloLocalBitacoraRid(oDocumentArticuloLocal, indexArticuloLocalBitacoraRid);
//			registarIndiceArticuloLocalBitacoraLocalArticulo(oDocumentArticuloLocal, indexArticuloLocalBitacoraLocalArticulo);
//			registarIndiceArticuloLocalBitacoraArticuloLocal(oDocumentArticuloLocal, indexArticuloLocalBitacoraArticuloLocal);
//			registarIndiceArticuloLocalBitacoraLocalArticuloAreaTrabajo(oDocumentArticuloLocal, indexArticuloLocalBitacoraLocalArticuloAreaTrabajo);
//			registarIndiceArticuloLocalBitacoraArticuloLocaloAreaTrabajo(oDocumentArticuloLocal, indexArticuloLocalBitacoraArticuloLocaloAreaTrabajo);
//			
//		}
//		
//	}
	
//	/**
//	 * Registrar el indice artLocBitIndexRid (rid, link ArticuloLocal)
//	 * @param oDocumentArticuloLocalBitacora
//	 * @param indexArticuloLocalAreaTrabajo
//	 */
//	private static void registarIndiceArticuloLocalBitacoraRid(ODocument oDocumentArticuloLocalBitacora, OIndex<?> indexArticuloLocalAreaTrabajo) {
//		
//		try {
//			OCompositeKey articuloLocalKey =  new OCompositeKey();
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
//			indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
//			articuloLocalKey = null;
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registarIndiceArticuloLocalBitacoraRid para los valores: {}, {}", 
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL),
//					oDocumentArticuloLocalBitacora.getIdentity());
//			LOG_SICV2.error("Error: {}", e.toString());
//		}
//		
//	}
	
//	/**
//	 * Registrar el indice artLocBitIndexLocArt (codigoCompania, codigoLocal, codigoArticulo)
//	 * @param oDocumentArticuloLocalBitacora
//	 * @param indexArticuloLocalAreaTrabajo
//	 */
//	private static void registarIndiceArticuloLocalBitacoraLocalArticulo(ODocument oDocumentArticuloLocalBitacora, OIndex<?> indexArticuloLocalAreaTrabajo){
//		
//		try {
//			OCompositeKey articuloLocalKey =  new OCompositeKey();
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA));
//			//articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
//			indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
//			articuloLocalKey = null;
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registarIndiceArticuloLocalBitacoraLocalArticulo para los valores: {}, {}, {}, {}", 
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA),
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO),
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO),
//					oDocumentArticuloLocalBitacora.getIdentity());
//			LOG_SICV2.error("Error: {}", e.toString());
//		}
//		
//	}
	
//	/**
//	 * Registrar el indice artLocBitIndexArtLoc (codigoCompania, codigoArticulo, codigoLocal)
//	 * @param oDocumentArticuloLocalBitacora
//	 * @param indexArticuloLocalAreaTrabajo
//	 */
//	private static void registarIndiceArticuloLocalBitacoraArticuloLocal(ODocument oDocumentArticuloLocalBitacora, OIndex<?> indexArticuloLocalAreaTrabajo) {
//		
//		try {
//			OCompositeKey articuloLocalKey =  new OCompositeKey();
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA));
//			//articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
//			indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
//			articuloLocalKey = null;
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registarIndiceArticuloLocalBitacoraArticuloLocal para los valores: {}, {}, {}, {}", 
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA),
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO),
//					oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO),
//					oDocumentArticuloLocalBitacora.getIdentity());
//			LOG_SICV2.error("Error: {}", e.toString());
//		}
//		
//	}
	
//	/**
//	 * Registrar el indice artLocBitIndexLocArtAreTra (codigoCompania, codigoLocal, valorTipoAreaTrabajo, codigoArticulo).
//	 * @param oDocumentArticuloLocalBitacora
//	 * @param indexArticuloLocalAreaTrabajo
//	 */
//	private static void registarIndiceArticuloLocalBitacoraLocalArticuloAreaTrabajo(ODocument oDocumentArticuloLocalBitacora, OIndex<?> indexArticuloLocalAreaTrabajo) {
//		
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		try {
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
//			indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
//		} catch (Exception e) {
//			LOG_SICV2.error("Error al registarIndiceArticuloLocalBitacoraLocalArticuloAreaTrabajo para el key: {}", articuloLocalKey.toString());
//			LOG_SICV2.error("Error: {}", e.toString());
//		} finally {
//			articuloLocalKey = null;
//		}
//	}
	
//	/**
//	 * <p> Registrar el indice artLocBitIndexLocArtAreTra (codigoCompania, codigoArticulo, valorTipoAreaTrabajo, codigoLocal).</p>
//	 * @param db
//	 * @param colODocumentArticuloLocalBitacora
//	 * @throws SICException
//	 */
//	private static void registarIndiceArticuloLocalBitacoraArticuloLocaloAreaTrabajo(ODocument oDocumentArticuloLocalBitacora, OIndex<?> indexArticuloLocalAreaTrabajo) {
//		
//		OCompositeKey articuloLocalKey =  new OCompositeKey();
//		try {
//			articuloLocalKey.reset();
//			articuloLocalKey.addKey(Integer.valueOf(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA).toString()));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO).toString());
//			articuloLocalKey.addKey(Integer.valueOf(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO).toString()));
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO).toString());
//			articuloLocalKey.addKey(oDocumentArticuloLocalBitacora.getIdentity());
//			indexArticuloLocalAreaTrabajo.put(articuloLocalKey, oDocumentArticuloLocalBitacora.getIdentity());
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG_SICV2.error("Error al registarIndiceArticuloLocalBitacoraArticuloLocaloAreaTrabajo para el key: {}", articuloLocalKey.toString());
//			LOG_SICV2.error("Error: {}", e.toString());
//		} finally {
//			articuloLocalKey = null;
//		}
//		
//	}
	
	/**
	 * Registrar todos los indices que se necesitan para la clase ArticuloEstablecimientoDTO de OrientDB
	 * @param db
	 * @param colODocumentArticuloEstablecimiento
	 */
	public static void registrarIndicesODocumentArticuloEstablecimiento (ODatabaseDocumentTx db, ODocument ... colODocumentArticuloEstablecimiento) {
		
		OIndex<?> indexArticuloEstablecimiento = IndiceArticuloAlcanceNoSql.getInstancia().getIndiceArticuloEstablecimiento(db);
		OIndex<?> indexEstablecimientoArticulo = IndiceArticuloAlcanceNoSql.getInstancia().getIndiceEstablecimientoArticulo(db);
		
		for (ODocument oDocumentArticuloEstablecimiento : colODocumentArticuloEstablecimiento) {
			
			registarIndiceArticuloEstablecimiento(oDocumentArticuloEstablecimiento, indexArticuloEstablecimiento);
			registarIndiceEstablecimientoArticulo(oDocumentArticuloEstablecimiento, indexEstablecimientoArticulo);
			
		}
		
	}
	
	/**
	 * Obtener el index en el que se va registrar los datos, en caso de no existir se crea
	 * @param db
	 * @param indexName
	 * @param oType
	 * @return
	 */
	public static OIndex<?> obtenerOIndex(ODatabaseDocumentTx db, String indexName, OType ... dataTypesIndex) throws SICException {
		
		OIndex<?> indexArticuloLocal = db.getMetadata().getIndexManager().getIndex(indexName);
		
		if (indexArticuloLocal == null) {
			
			createIndexForClusterClass(db, indexName, dataTypesIndex);
			indexArticuloLocal = db.getMetadata().getIndexManager().getIndex(indexName);
			
		}
		return indexArticuloLocal;
	}
	
	/**
	 * Verificar si existe el indice, en caso de no existir se crea
	 * @param db
	 * @param indexName
	 * @param dataTypesIndex
	 * @throws SICException
	 */
	private static synchronized void createIndexForClusterClass(ODatabaseDocumentTx db, String indexName, OType ... dataTypesIndex) throws SICException {
		
		try {
			
			if (db == null || StringUtils.isEmpty(indexName) || dataTypesIndex == null || dataTypesIndex.length < 1) {
				
				throw new SICException("Todos los parametros son obligatorios...");
			}
			
			// Crear indice si no existe
			OIndexUtil.createIndex(db, indexName, dataTypesIndex);

		} catch (NoSQLException e) {
			LOG_SICV2.error("Error al createIndexForClusterClass: {}", e.toString());
			throw new SICException("Error al validar y crear un indice para una cluster de una clase...", e);
		}

	}
	
	// METODOS PARA REGISTRAR EN LOS INDICES DE ARTICULO ESTABLECIMIENTO
	/**
	 * Registrar el indice indexArticuloEstablecimiento key = [codCom, codArt, codEst, rid]
	 * @param oDocumentArticuloEstablecimiento
	 * @param indexArticuloEstablecimiento
	 */
	private static void registarIndiceArticuloEstablecimiento(ODocument oDocumentArticuloEstablecimiento, OIndex<?> indexArticuloEstablecimiento) {
		
		OCompositeKey articuloEstablecimientoKey =  new OCompositeKey();
		articuloEstablecimientoKey.reset();
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA));
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO));
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO));
		indexArticuloEstablecimiento.put(articuloEstablecimientoKey, oDocumentArticuloEstablecimiento.getIdentity());
		articuloEstablecimientoKey = null;
		
	}
	
	/**
	 * Registrar el indice indexEstablecimientoArticulo key = [codCom, codEst, codArt, rid]
	 * @param oDocumentArticuloEstablecimiento
	 * @param indexEstablecimientoArticulo
	 */
	private static void registarIndiceEstablecimientoArticulo(ODocument oDocumentArticuloEstablecimiento, OIndex<?> indexEstablecimientoArticulo) {
		
		OCompositeKey articuloEstablecimientoKey =  new OCompositeKey();
		articuloEstablecimientoKey.reset();
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA));
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO));
		articuloEstablecimientoKey.addKey(oDocumentArticuloEstablecimiento.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO));
		indexEstablecimientoArticulo.put(articuloEstablecimientoKey, oDocumentArticuloEstablecimiento.getIdentity());
		articuloEstablecimientoKey = null;
		
	}
	
	
	// INDICES TO CLASS ARTICULOLOCALDTO
	
//	/**
//	 * metodo q devuelve el indice Articulo-AreaTrabajo, key = [codCom,tipAreTra,codArt,codAreTra,ridArticuloLocalDTO]
//	 * @param db
//	 * @return
//	 */
//	public static OIndex<?> getIndiceArticuloAreaTrabajo(ODatabaseDocumentTx db){
//		return obtenerOIndex(db, ArticuloLocalIndices.INDEX_ARTICULO_LOCAL, new OType[]{OType.INTEGER, OType.STRING, OType.STRING, OType.INTEGER,OType.LINK});
//		//return obtenerOIndex(db, ArticuloLocalIndices.INDEX_ARTICULO_LOCAL, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER,OType.LINK});
//	}
//
//	/**
//	 * metodo q devuelve el indice AreaTrabajo-Articulo, key = [codCom,tipAreTra,codAreTra,codArt,ridArticuloLocalDTO] 
//	 * @param db
//	 * @return
//	 */
//	public static OIndex<?> getIndiceAreaTrabajoArticulo(ODatabaseDocumentTx db){
//		return obtenerOIndex(db, ArticuloLocalIndices.INDEX_LOCAL_ARTICULO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.STRING, OType.LINK});
//		//return obtenerOIndex(db, ArticuloLocalIndices.INDEX_LOCAL_ARTICULO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.LINK});
//	}

	
//	// INDICES ARTICULO AREATRABAJO BITACORA DTO
//	
//	/**
//	 * metodo q devuelve el indice Articulo-AreaTrabajo, key = [codCom,tipAreTra,codArt,codAreTra,ridBitacoraDTO]
//	 * @param db
//	 * @return
//	 */
//	public static OIndex<?> getIndiceBitacoraArticuloAreaTrabajo(ODatabaseDocumentTx db){
//		//return obtenerOIndex(db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_ARTICULO_LOCAL, new OType[]{OType.INTEGER, OType.STRING, OType.STRING, OType.INTEGER,OType.LINK});
//		return obtenerOIndex(db, ArticuloLocalIndices.INDEX_BIT_ARTICULO_AREATRABAJO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER,OType.LINK});
//	}
//
//	/**
//	 * metodo q devuelve el indice AreaTrabajo-Articulo, key = [codCom,tipAreTra,codAreTra,codArt,ridBitacoraDTO] 
//	 * @param db
//	 * @return
//	 */
//	public static OIndex<?> getIndiceBitacoraAreaTrabajoArticulo(ODatabaseDocumentTx db){
//		//return obtenerOIndex(db, ArticuloLocalIndices.ART_LOC_BIT_INDEX_LOCAL_ARTICULO, new OType[]{OType.INTEGER, OType.STRING, OType.INTEGER, OType.STRING, OType.LINK});
//		return obtenerOIndex(db, ArticuloLocalIndices.INDEX_BIT_AREATRABAJO_ARTICULO, new OType[]{OType.INTEGER, OType.INTEGER, OType.STRING, OType.LINK});
//	}
	

	
}
