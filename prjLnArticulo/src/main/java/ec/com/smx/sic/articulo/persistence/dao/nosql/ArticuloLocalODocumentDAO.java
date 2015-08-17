/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.nosql;

import static ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalFields.ESTADO_ARTICULO_LOCAL;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.bodega.CentroDistribucionUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO;

/**
 * @author wcaiza
 *
 */
public class ArticuloLocalODocumentDAO implements IArticuloLocalODocumentDAO, Logeable {

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO#registrarArticuloLocalDocument(java.lang.String, java.util.Collection)
	 */
	@Override
	public void registrarArticuloLocalDocument(String iClusterName, Collection<ODocument> colODocumentArticuloLocal) throws SICException {
		try {
			
			for (ODocument oDocumentArticuloLocal : colODocumentArticuloLocal) {
				this.registrarArticuloLocalDocument(iClusterName, oDocumentArticuloLocal);
			}
			
		} catch (SICException e) {
			LOG_SICV2.error("Error al ejecutar registrarArticuloLocalDocument: {}", e.toString());
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO#registrarArticuloLocalDocument(java.lang.String, com.orientechnologies.orient.core.record.impl.ODocument)
	 */
	@Override
	public void registrarArticuloLocalDocument(String iClusterName, ODocument oDocumentArticuloLocal) throws SICException {
		try {
			oDocumentArticuloLocal.save(iClusterName);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<ODocument> obtenerIndiceLocalArticulo (String indexName, List<Object[]> listKey, String... projections) throws SICException {
		
		OSQLSynchQuery<ODocument> query = null;
		Collection<ODocument> colODocument = null;
		
		try {
			
//			sql = CentroDistribucionUtil.getInstancia().appendObject("select from index:", indexName, " where key = [?, ?, ?]");
			//String sql = OIndexUtil.createSelectIndex(indexName, listKey, projections);
			if (!CollectionUtils.isEmpty(listKey)){
				StringBuilder sql = new StringBuilder();
				sql.append("select rid from index:").append(indexName)
				.append(" where key = [").append(listKey.get(0)[0])
				.append(",'").append(listKey.get(0)[1]).append("'")
				.append(",").append(listKey.get(0)[2])
				.append(",'").append(listKey.get(0)[3]).append("']");
				
				query = new OSQLSynchQuery<>(sql.toString());
				colODocument = query.run();
				sql = null;
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al ejecutar obtenerIndiceLocalArticulo: {}", e.toString());
			throw new SICException(e);
		} finally {
			query = null; 
		}
		return colODocument;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloLocalODocumentDAO#obtenerEstadoLocalArticulo(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer obtenerEstadoLocalArticulo(Integer codigoCompania, Integer codigoLocal, String codigoArticulo, String indexName) throws SICException {
		
		OSQLSynchQuery<ODocument> query = null;
		Integer estadoArticulo = 0;
		StringBuilder sql = null;
		
		try {
			
			sql = CentroDistribucionUtil.getInstancia().appendObject(
					"select rid.", ESTADO_ARTICULO_LOCAL, " as ", ESTADO_ARTICULO_LOCAL, 
					" from index:", indexName, " where key = [?, ?, ?]");
			
			query = new OSQLSynchQuery<>(sql.toString());
			
			ODocument oDocument = query.runFirst(codigoCompania, codigoLocal, codigoArticulo);
			
			if (oDocument != null) {
				
				estadoArticulo = Integer.valueOf(oDocument.field(ESTADO_ARTICULO_LOCAL).toString());
			}
			
		} catch (Exception e) {
			LOG_SICV2.error("Error al ejecutar obtenerIndiceLocalArticulo: {}", e.toString());
			throw new SICException(e);
		} finally {
			query = null; sql = null;
		}
		return estadoArticulo;
	}

}
