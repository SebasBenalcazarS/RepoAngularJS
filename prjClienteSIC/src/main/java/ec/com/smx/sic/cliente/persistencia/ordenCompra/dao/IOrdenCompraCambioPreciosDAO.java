/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraGestionDTO;

/**
 * @author vjaramillo
 *
 */
public interface IOrdenCompraCambioPreciosDAO extends Serializable {

	/**
	 * Metodo para obtener todas las ordenes de compra en conflicto con las gestiones de precios existentes.
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<OrdenCompraGestionDTO> obtenerOrdenesCompraConflictos(Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo para obtener los codigos de funcionario por los id's de usuario.
	 * @param codigoCompania
	 * @param userIds
	 * @return
	 * @throws SICException
	 */
	Map<String, FuncionarioDTO> obtenerCodigosFuncionario (Integer codigoCompania, Set<String> userIds) throws SICException;
	
	/**
	 * Metodo para eliminar las ordenes de compra que fueron anuladas y/o creadas.
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @param codigoOrdenCompraGestion
	 * @return
	 * @throws SICException
	 */
	void eliminarBitacoraOrdenCompraEnConflicto(Integer codigoCompania, Long codigoOrdenCompra, Long codigoOrdenCompraGestion) throws SICException;
}
