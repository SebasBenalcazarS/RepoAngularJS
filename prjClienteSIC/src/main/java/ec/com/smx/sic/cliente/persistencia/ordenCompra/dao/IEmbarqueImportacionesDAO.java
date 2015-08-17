/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

/**
 * @author aguato
 *
 */
public interface IEmbarqueImportacionesDAO extends Serializable {

	/**
	 * @param embarqueEstadoImpDTO
	 * @param codigosClientes
	 * @param validarEmbarque
	 * @param codigoBarrasValidados
	 * @param almacenarEmbarque
	 * @param codigosLineaComercialUsuario
	 * @return
	 */
	public Collection<FacturaEstadoImpDTO> obtenerFacturasEmbarque(EmbarqueEstadoImpDTO embarqueEstadoImpDTO, Collection<String> codigosClientes, Boolean validarEmbarque, String[] codigoBarrasValidados, Boolean almacenarEmbarque, HashSet<String> codigosLineaComercialUsuario) throws SICException;
	
	/**
	 * Obtiene el numero de embarque
	 * para envio al SIC
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public String obtenerNumeroEmbarqueFacturaOrdenCompra(Integer codigoCompania, Long codigoOrdenCompra) throws SICException;
	
	/**
	 * Verifica que todas las facturas
	 * del embarque hayan generado
	 * ordenes de compra 
	 * 
	 * @param codigoEmbarque
	 * @return
	 * @throws SICException
	 */
	public Boolean consultarFacturasOrdenCompraGeneradas(Long codigoEmbarque) throws SICException;
	
	/**
	 * Inhabilita el embarque de importaciones cuando
	 * todas las facturas del mismo ya han generado
	 * ordenes de compra
	 * @param codigoEmbarque
	 * @throws SICException
	 */
	public void cerrarEmbarqueImportaciones(Long codigoEmbarque) throws SICException;
		
}
