/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql;

import java.util.Collection;

import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author wcaiza
 *
 */
public interface IArticuloAreaTrabajoBitacoraODocumentDAO {
	
	/**
	 * 
	 * @param iClusterName
	 * @param colODocumentArticuloLocal
	 * @throws SICException
	 */
	void registrarArticuloLocalBitacoraDocument(String iClusterName, Collection<ODocument> colODocumentArticuloAreaTrabajoBitacora) throws SICException;
	
	/**
	 * 
	 * @param iClusterName
	 * @param oDocumentArticuloLocal
	 * @throws SICException
	 */
	void registrarArticuloLocalBitacoraDocument(String iClusterName, ODocument oDocumentArticuloAreaTrabajoBitacora) throws SICException;
	

}
