/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;

/**
 * @author wcaiza
 *
 */
public interface IArticuloAlcanceMigracionNoSqlGestor {
	
	/**
	 * Obtener los c&oacute;digos de los locales que se van a migrar a la base no relacional
	 * @param codigoCompania
	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
	 * @return
	 * @throws SICException
	 */
	Collection<Integer> obtenerColCodigoLocalMigrar (Integer codigoCompania, String sufijoTabla) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI 
	 * @throws SICException
	 */
	void migrarArticuloAlcanceDTONoSql (Integer codigoCompania, String sufijoTabla) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
	 * @throws SICException
	 */
	void migrarArticuloAlcanceDTONoSql (Integer codigoCompania, Integer codigoLocal, String sufijoTabla) throws SICException;
	
//	/**
//	 * 
//	 * @param codigoCompania
//	 * @param sufijoTabla Identificador de la tabla {@link ArticuloLocalDTO} BOD, LOC, OFI
//	 * @throws SICException
//	 */
//	void migrarArticuloAlcanceBitacoraDTONoSql (Integer codigoCompania, String sufijoTabla) throws SICException;
	
}
