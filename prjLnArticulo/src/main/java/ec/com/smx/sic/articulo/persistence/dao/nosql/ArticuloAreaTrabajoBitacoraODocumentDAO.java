/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.nosql;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAreaTrabajoBitacoraODocumentDAO;

/**
 * @author wcaiza
 *
 */
public class ArticuloAreaTrabajoBitacoraODocumentDAO implements IArticuloAreaTrabajoBitacoraODocumentDAO, Logeable {

//	/* (non-Javadoc)
//	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAreaTrabajoBitacoraODocumentDAO#registrarArticuloLocalBitacoraDocument(java.lang.String, java.util.Collection)
//	 */
//	@Override
//	public void registrarArticuloLocalBitacoraDocument(String iClusterName, Collection<ODocument> colODocumentArticuloAreaTrabajoBitacora) throws SICException {
//		try {
//			
//			for (ODocument oDocumentArticuloArticuloAreaBitacora : colODocumentArticuloAreaTrabajoBitacora) {
//				this.registrarArticuloLocalBitacoraDocument(iClusterName, oDocumentArticuloArticuloAreaBitacora);
//			}
//			
//		} catch (SICException e) {
//			LOG_SICV2.error("Error al ejecutar registrarArticuloLocalDocument: {}", e.toString());
//			throw e;
//		}
//	}
//
//	/* (non-Javadoc)
//	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql.IArticuloAreaTrabajoBitacoraODocumentDAO#registrarArticuloLocalBitacoraDocument(java.lang.String, com.orientechnologies.orient.core.record.impl.ODocument)
//	 */
//	@Override
//	public void registrarArticuloLocalBitacoraDocument(String iClusterName, ODocument oDocumentArticuloArticuloAreaBitacora) throws SICException {
//		try {
//			oDocumentArticuloArticuloAreaBitacora.save(iClusterName);
//		} catch (Exception e) {
//			throw new SICException(e);
//		}
//	}

}
