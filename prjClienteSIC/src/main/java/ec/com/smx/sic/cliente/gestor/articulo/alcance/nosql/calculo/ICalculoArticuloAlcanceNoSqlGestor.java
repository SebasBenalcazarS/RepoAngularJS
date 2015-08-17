/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;

/**
 * @author wcaiza
 *
 */
public interface ICalculoArticuloAlcanceNoSqlGestor {
	
	/**
	 * 
	 * @param sufijoTabla
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param colCodigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacora(String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String... colCodigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	String verificarExisteArticuloEnLocal (Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Integer verificarHayArticuloEnLocal (Integer codigoCompania, Integer codigoLocal, String codigoArticulo) throws SICException;
	
	/**
	 * Permite consultar las areas de trabajo en las que el {@link ArticuloDTO} tiene alcance
	 * @param articuloDTO
	 * @param validarEstado <code>TRUE</code> si debe obtener solo los registros en estado activo, <code>FALSE</code> no se valida el estado
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalDTO> obtenerAreasTrabajoAsignadas(ArticuloDTO articuloDTO, Boolean validarEstado) throws SICException;

}
