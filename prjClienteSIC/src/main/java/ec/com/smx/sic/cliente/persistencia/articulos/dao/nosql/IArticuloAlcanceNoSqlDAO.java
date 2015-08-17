/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.nosql;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;

/**
 * @author bymontesdeoca
 *
 */
public interface IArticuloAlcanceNoSqlDAO {
	
	
	void validateCreateIndexAlcances(ODatabaseDocumentTx db) throws SICException;
	
	/**
	 * Encuentra el alcance para un articulo en una area especifica y/o grupo alcance(prototipo)
	 * @param codigoCompania : requerido
	 * @param tipAreTra : requerido 'OFI'/'LOC'/'BOD'
	 * @param codigoArticulo : requerido
	 * @param codigoAreaTrabajo : requerido
	 * @return ODocument, Si no existe registro retorna null
	 * @throws SICException
	 */
	 ODocument findAlcanceUnique(Integer codigoCompania,String tipAreTra,String codigoArticulo,Integer codigoAreaTrabajo) throws SICException; 


	
	/**
	 * metodo q crea o actualiza el alcance en articuloLocalDTO a partir del objeto de tipo ArticuloAreaTrabajoNoSqlDTO
	 * @param codArt
	 * @param codAreTra
	 * @param artAreTraNoSql
	 * @param ridArticuloLocalDTO
	 * @throws SICException
	 */
	
	ODocument registrarAlcance(ODatabaseDocumentTx db,String codArt,Integer codAreTra,ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,ORID ridArticuloLocalDTO) throws SICException;

	/**
	 * metodo q crea o actualiza el alcance en articuloLocalDTO a partir del objeto de un ODocument
	 * @param codArt
	 * @param codAreTra
	 * @param artAreTraNoSql
	 * @param ridArticuloLocalDTO
	 * @throws SICException
	 */
	
	ODocument updateAlcance(ODatabaseDocumentTx db,String codArt,Integer codAreTra,ODocument artAreTraNoSql) throws SICException;

	
	/**
	 * metodo q registra los indices para articuloLocalDTO
	 * @param db : ODatabaseDocumentTx	
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoAreatrabajo
	 * @param tipAreTra : 'OFI'/'LOC'/'BOD'
	 * @param ridArticuloLocalDTO
	 * @throws SICException
	 */
//	void registrarIndicesArticuloAreatrabajo(ODatabaseDocumentTx db,Integer codigoCompania,String codigoArticulo,Integer codigoAreatrabajo,String tipAreTra,ORID ridArticuloLocalDTO) throws SICException;
	void registrarIndicesArticuloAreatrabajo(ODatabaseDocumentTx db,ODocument oDocArticuloLocalDTO) throws SICException;	

	
	/**
	 * metodo q crea la bitacora de alcance en articuloAreaTrabajoBitacoraDTO 
	 * @param db
	 * @param oDocArticuloLocalDTO
	 * @return
	 * @throws SICException
	 */
	ODocument registrarBitacoraAlcance(ODatabaseDocumentTx db,ODocument oDocArticuloLocalDTO,Date fecha) throws SICException;

	/**
	 * metodo q registra los indices para articuloAreaTrabajoBitacoraDTO
	 * @param db : ODatabaseDocumentTx	
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoAreatrabajo
	 * @param tipAreTra : 'OFI'/'LOC'/'BOD'
	 * @param ridBitacoraDTO
	 * @throws SICException
	 */
	//void registrarIndicesArticuloAreatrabajoBitacora(ODatabaseDocumentTx db,Integer codigoCompania,String codigoArticulo,Integer codigoAreatrabajo,String tipAreTra,ORID ridBitacoraDTO) throws SICException;
	void registrarIndicesArticuloAreatrabajoBitacora(ODatabaseDocumentTx db,ODocument articuloAreaTrabajoBitacoraDTO) throws SICException;
	
	

	/**
	 * metodo q busca los locales en donde existe un articulo especifico y devuelve los locales como cadena de string ordenados de forma ascendente
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estadoAlcance
	 * @return String : locales encontrados separados por coma y ordenados de forma ascendente
	 * @throws SICException
	 */
	String findLocalesArticuloAsString(Integer codigoCompania,String codigoArticulo,Integer estadoAlcance) throws SICException;

	Set<String> findLocalesArticuloAsSet(Integer codigoCompania,String codigoArticulo) throws SICException;
	
	
	/**
	 * metodo que busca en que areas de trabajo se encuentra registrado alcance para un articulo.  
	 * @param codCompania
	 * @param tipAreTra : 'OFI'/'LOC'/'BOD'
	 * @param codigoArticulo
	 * @param estado : 1(activo), 0(inactivo), null (activos e inactivos) 
	 * @return List de tipo ArticuloLocalDTO
	 * @throws SICException
	 */
	List<ArticuloLocalDTO> findAlcanceArticulo(Integer codCompania,String tipAreTra,String codigoArticulo,Integer estado) throws SICException;
	
	
	/**
	 * metodo q busca todos los alcances registrados en una area de trabajo especifica
	 * @param codigoCompania
	 * @param tipAreaTrabajo
	 * @param codAreaTrabajo
	 * @param codArticulo
	 * @return
	 * @throws SICException
	 */
	List<ODocument> findAlcancesEnAreaTrabajo(Integer codigoCompania,String tipAreaTrabajo,Integer codAreaTrabajo,String codArticulo,Integer skip,Integer limit) throws SICException;

	/**
	 * retorna el numero de filas 
	 * @param codigoCompania
	 * @param tipAreaTrabajo
	 * @param codAreaTrabajo
	 * @param codArticulo
	 * @return
	 * @throws SICException
	 */
	Integer getNumRegistrosAlcanceEnAreaTrabajo(Integer codigoCompania,String tipAreaTrabajo,Integer codAreaTrabajo,String codArticulo) throws SICException;
	
	/* Metodos articulo establecimiento */
	
	/**
	 * 
	 * @param idClusterName
	 * @param colODocumentArticuloEstablecimiento
	 * @throws SICException
	 */
	Collection<ODocument> registrarArticuloEstablecimientoDocument(String idClusterName, Collection<ODocument> colODocumentArticuloEstablecimiento) throws SICException;
	
	/**
	 * 
	 * @param idClusterName
	 * @param oDocumentArticuloEstablecimiento
	 * @throws SICException
	 */
	ODocument registrarArticuloEstablecimientoDocument(String idClusterName, ODocument oDocumentArticuloEstablecimiento) throws SICException;
	
	/**
	 * 
	 * @param db
	 * @param colODocumentArticuloEstablecimiento
	 * @throws SICException
	 */
	void registrarIndicesArticuloEstablecimiento(ODatabaseDocumentTx db, ODocument ... colODocumentArticuloEstablecimiento) throws SICException;
	
	/**
	 * Encuentra el articulo establecimiento
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoEstablecimiento
	 * @return ODocument
	 * @throws SICException
	 */
	ODocument findArticuloEstablecimientoUnique(Integer codigoCompania,String codigoArticulo,Integer codigoEstablecimiento) throws SICException; 

	ODocument registrarArticuloEstablecimiento(ODatabaseDocumentTx db,String codArticulo,Integer codEstablecimiento,Integer estadoArtEst,ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,ORID ridArtEstDTO) throws SICException;
	
	void registrarIndicesArticuloEstablecimiento(ODatabaseDocumentTx db,ODocument oDocArtEstInserted) throws SICException;
	
	void borrarRegistrarIndiceFechaIniAlcRidArtLoc(ODatabaseDocumentTx db,ODocument artAreTraSaved,ODocument artAreTraUpdate) throws SICException;
	
	void borrarRegistrarIndiceFechaFinAlcRidArtLoc(ODatabaseDocumentTx db,ODocument artAreTraSaved,ODocument artAreTraUpdate) throws SICException;
}


