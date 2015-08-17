/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;

/**
 * @author wcaiza
 *
 */
public interface IArticuloAlcanceNoSqlServicio {
	
	/**
	 * Obtener los c&oacute;digos de los locales que se van a migrar a la base no relacional
	 * @param codigoCompania
	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
	 * @return
	 * @throws SICException
	 */
	Collection<Integer> obtenerColCodigoLocalMigrar(Integer codigoCompania, String sufijoTabla) throws SICException;
	
	/**
	 * Ejecutar el proceso spring batch para migrar los datos de un local especifico
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
	 * @throws SICException
	 */
	void migrarArticuloAlcanceDTONoSqlBatch(Integer codigoCompania, Integer codigoLocal, String sufijoTabla) throws SICException;
	
//	/**
//	 * Ejecutar el proceso spring batch para migrar los datos de la tabla SCSADTARTARETRABIT - ArticuloAreaTrabajoBitacoraDTO 
//	 * @param codigoCompania
//	 * @param codigoLocal
//	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
//	 * @throws SICException
//	 */
//	void migrarArticuloAlcanceBitacoraNoSqlBatch(Integer codigoCompania, String sufijoTabla) throws SICException;
	
	/**
	 * Verificar si existe un articulo en un local, bodega, oficina
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	String findExisteArticuloEnLocal (Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException;
	
	/**
	 * Obtener el estado de un art&iacute;culo en la clase ArticuloLocalDTO de orientDB
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return <li>1 si el estado es activo</> <li>0 si el estado es inactivo o no existe el art&iacute;culo en ese local</li>
	 * @throws SICException
	 */
	Integer obtenerEstadoArticuloLocal (Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param colCodigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacora(String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String... colCodigoArticulo) throws SICException;
	
	//void registrarArticuloLocalDTO () throws SICException;
	

	
	/*
	 * Servicios que se utilizan en el modulo de articulos
	 * 
	 * */
	
	/**
	 * Permite consultar las areas de trabajo en las que el {@link ArticuloDTO} tiene alcance
	 * @param articuloDTO
	 * @param validarEstado <code>TRUE</code> si debe obtener solo los registros en estado activo, <code>FALSE</code> no se valida el estado
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalDTO> obtenerAreasTrabajoAsignadas(ArticuloDTO articuloDTO, Boolean validarEstado) throws SICException;
	
	
	/**
	 * 
	 * @param artAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	void executeAlcanceArticulos(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;
	
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
	 * Metodo q copia alcances de un origen a un destino 
	 * @param artAreTraNoSql : aqui debe venir definido el local destino en el conjunto de areas
	 * @param codLocalOrigen 
	 * @throws SICException
	 */
	void copiarAlcances(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql,Integer codLocalOrigen) throws SICException;
	
	
	
	
	
	
	
	
	
	
	//void registrarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;
	
	/**
	 * Quita los alcances a partir del objeto de tipo ArticuloAreaTrabajoNoSqlDTO
	 * @param artAreTraNoSql
	 * @throws SICException
	 * @author bymontesdeoca
	 */
	//void quitarAlcance(ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql) throws SICException;

}
