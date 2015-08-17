/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author wcaiza
 *
 */
public interface IAlmacenamientoArticuloAlcanceNoSqlGestor {
	
	/*
	 * INICIO Metodos para la migracion de datos desde DB2 a orientDB
	 */
	
	/**
	 * Migrar {@link ArticuloLocalDTO} a OrientDB 
	 * @param codigoCompania
	 * @param colVistaMigrarArticuloLocalDTO Colecci&oacute;n de {@link ArticuloLocalDTO} a migrar
	 * @param sufijoTabla Sufijo de la tabla de donde se va consultar los datos OFI, LOC, BOD
	 * @throws SICException
	 */
	void migrarArticuloLocal (Integer codigoCompania, Collection<VistaArticuloLocalNoSqlDTO> colVistaMigrarArticuloLocalDTO, String sufijoTabla) throws SICException;
	
	/**
	 * Migrar {@link ArticuloAreaTrabajoBitacoraDTO} a OrientDB 
	 * @param codigoCompania
	 * @param colArticuloAreaTrabajoBitacoraDTO Colecci&oacute;n de {@link ArticuloAreaTrabajoBitacoraDTO} a migrar
	 * @param sufijoTabla Sufijo de la tabla de donde se va consultar los datos OFI, LOC, BOD
	 * @throws SICException
	 */
	void migrarArticuloLocalBitacora (Integer codigoCompania, Collection<ArticuloAreaTrabajoBitacoraDTO> colArticuloAreaTrabajoBitacoraDTO, String sufijoTabla) throws SICException;
	
	/**
	 * Migrar {@link ArticuloEstablecimientoDTO} a orientDB
	 * @param codigoCompania
	 * @param colArticuloEstablecimientoDTO Colecci&oacute;n de {@link ArticuloEstablecimientoDTO} a migrar
	 * @param sufijoTabla Sufijo de la tabla de donde se va consultar los datos OFI, LOC, BOD
	 * @throws SICException
	 */
	void migrarArticuloEstablecimiento (Integer codigoCompania, Collection<ArticuloEstablecimientoDTO> colArticuloEstablecimientoDTO, String sufijoTabla) throws SICException;
	
	/*
	 * FIN Metodos para la migracion de datos desde DB2 a orientDB
	 */
	
	/*
	 * Metodos q se ocupan desde el modulo de articulos
	 * 
	 * */
	
	/**
	 * Permite registrar el alcance a las bodegas padres de una subbodega espec&iacute;fica
	 * @param articuloVO
	 * @param codigosAreaTrabajo
	 * @param opcionTipoAsignacionAlcance
	 * @throws SICException
	 */
	void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO, Collection<Integer> codigosAreaTrabajo, String opcionTipoAsignacionAlcance) throws SICException;
	
	/**
	 * Permite insertar la bit&aacute;cora de activaci&oacute;n o desactivaci&oacute;n de alcances
	 * @param oDocumentArticuloLocal
	 * @throws SICException
	 */
	void insertarBitacoraArticuloAreaTrabajo(ODocument oDocumentArticuloLocal, Date fechaAplicacion, String opcionTipoAsignacionAlcance) throws SICException;

	
	/**
	 * Registra, quita y actualiza alcances  
	 * @param artAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	void executeAlcanceArticulos(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;
	
	/**
	 * Registra, quita y actualiza alcances
	 * @param colArtAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	void executeAlcanceArticulos(Collection<ArticuloAreaTrabajoNoSqlDTO> colArtAreTraNoSql) throws SICException;

	
	/**
	 * registra los alcances a partir del objeto de tipo ArticuloAreaTrabajoNoSqlDTO
	 * @param artAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	void registrarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;
	
	/**
	 * Quita los alcances a partir del objeto de tipo ArticuloAreaTrabajoNoSqlDTO
	 * @param artAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	void quitarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;
	
	
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
	
	Set<String> getArticulosPruebaAlcance() throws SICException;
	
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
	
	/**
	 * Metodo q copia alcances de un origen a un destino 
	 * @param artAreTraNoSql : aqui debe venir definido el local destino en el conjunto de areas
	 * @param codLocalOrigen 
	 * @throws SICException
	 */
	void copiarAlcances(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,Integer codLocalOrigen) throws SICException;	
}
