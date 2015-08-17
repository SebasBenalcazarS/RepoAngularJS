/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql;

import java.util.Collection;
import java.util.List;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;

/**
 * @author wcaiza
 *
 */
public interface IArticuloLocalODocumentDAO {
	
	/**
	 * 
	 * @param iClusterName
	 * @param colODocumentArticuloLocal
	 * @throws SICException
	 */
	void registrarArticuloLocalDocument(String iClusterName, Collection<ODocument> colODocumentArticuloLocal) throws SICException;
	
	/**
	 * 
	 * @param iClusterName
	 * @param oDocumentArticuloLocal
	 * @throws SICException
	 */
	void registrarArticuloLocalDocument(String iClusterName, ODocument oDocumentArticuloLocal) throws SICException;
	
	/**
	 * 
	 * @param indexName
	 * @param listKey 
	 * @param projections
	 * @return
	 * @throws SICException
	 */
	Collection<ODocument> obtenerIndiceLocalArticulo (String indexName, List<Object[]> listKey, String... projections) throws SICException;
	
	/**
	 * Obtener el estado del un articulo en la tabla {@link ArticuloLocalDTO}
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @param indexName
	 * @return
	 * @throws SICException
	 */
	Integer obtenerEstadoLocalArticulo (Integer codigoCompania, Integer codigoLocal, String codigoArticulo, String indexName) throws SICException;

}



///**
//* metodo q registra el indice articulo - area de trabajo, key = [codCom,codArt,codAreTra,ridArticuloLocalDTO] 
//* @param db : ODatabaseDocumentTx	
//* @param codigoCompania
//* @param codigoArticulo
//* @param codigoAreatrabajo
//* @param ridArticuloLocalDTO
//* @throws SICException
//*/
//void registrarIndiceArticuloAreatrabajo(ODatabaseDocumentTx db,Integer codigoCompania,String codigoArticulo,Integer codigoAreatrabajo,ORID ridArticuloLocalDTO) throws SICException;
//
///**
//* metodo q registra el indice area de trabajo - articulo, key = [codCom,codAreTra,codArt,ridArticuloLocalDTO] 
//* @param db : ODatabaseDocumentTx	
//* @param codigoCompania
//* @param codigoAreatrabajo
//* @param codigoArticulo
//* @param ridArticuloLocalDTO
//* @throws SICException
//*/
//void registrarIndiceAreatrabajoArticulo(ODatabaseDocumentTx db,Integer codigoCompania,Integer codigoAreatrabajo,String codigoArticulo,ORID ridArticuloLocalDTO) throws SICException;
//
///**
//* metodo q registra el indice articulo - area de trabajo - tipo area trabajo, key = [codCom,codArt,codAreTra,tipoAreTra,ridArticuloLocalDTO] 
//* @param db : ODatabaseDocumentTx	
//* @param codigoCompania
//* @param codigoArticulo
//* @param codigoAreatrabajo
//* @param tipAreTra : 'OFI'/'LOC'/'BOD'
//* @param ridArticuloLocalDTO
//* @throws SICException
//*/
//void registrarIndiceArticuloAreatrabajoTipoAreTra(ODatabaseDocumentTx db,Integer codigoCompania,String codigoArticulo,Integer codigoAreatrabajo,String tipAreTra,ORID ridArticuloLocalDTO) throws SICException;
//
///**
//* metodo q registra el indice area de trabajo - articulo - tipo area trabajo, key = [codCom,codAreTra,codArt,tipoAreTra,ridArticuloLocalDTO] 
//* @param db : ODatabaseDocumentTx	
//* @param codigoCompania
//* @param codigoAreatrabajo
//* @param codigoArticulo
//* @param tipAreTra : 'OFI'/'LOC'/'BOD'
//* @param ridArticuloLocalDTO
//* @throws SICException
//*/
//void registrarIndiceAreatrabajoArticuloTipoAreTra(ODatabaseDocumentTx db,Integer codigoCompania,Integer codigoAreatrabajo,String codigoArticulo,String tipAreTra,ORID ridArticuloLocalDTO) throws SICException;

