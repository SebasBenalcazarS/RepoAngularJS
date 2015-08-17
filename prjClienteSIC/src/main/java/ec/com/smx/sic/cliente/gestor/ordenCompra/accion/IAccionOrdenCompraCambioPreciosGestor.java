/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ordenCompra.accion;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraGestionDTO;

/**
 * @author vjaramillo
 *
 */
public interface IAccionOrdenCompraCambioPreciosGestor {
	
	/**
	 * Metodo para sincronizar las ordenes de compra con los cambios de precios existentes en conflictos.
	 * @param codigoCompania
	 * @throws SICException
	 */
	void sincronizarOrdenesCompraCambioPrecios(Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo que procesara la orden de compra segun la configuracion de cambio de precios.
	 * @param ordenCompraGestionActual
	 * @param ordenCompraEstado
	 * @param codigoCompania
	 * @param funcionario
	 * @param userId
	 * @throws SICException
	 */
	void procesarOrdenCompraCambioPrecios(OrdenCompraGestionDTO ordenCompraGestionActual, OrdenCompraEstadoDTO ordenCompraEstado,
			Integer codigoCompania, FuncionarioDTO funcionario, String userId, Boolean parametroIntegracion) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenesCompraPorCodigos(Integer codigoCompania, Set<String> codigosOrdenCompra) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraGestionDTO> obtenerOrdenesCompraConflictos(Integer codigoCompania) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userIds
	 * @return
	 * @throws SICException
	 */
	public Map<String, FuncionarioDTO> obtenerCodigosFuncionario(Integer codigoCompania, Set<String> userIds) throws SICException;
}
