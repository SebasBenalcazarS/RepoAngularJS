package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

public interface IBusquedaEmbarqueImportacionesGestor extends Serializable{

	/**
	 * Consulta el numero de embarque asociado
	 * a las facturas de las ordenes de compra
	 * de un pedido especifico
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public String obtenerNumeroEmbarqueFacturaOrdenCompra(Integer codigoCompania, Long codigoOrdenCompra) throws SICException;
	
	/**
	 * @param embarqueEstadoImpDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaEstadoImpDTO> obtenerFacturasEmbarque(EmbarqueEstadoImpDTO embarqueEstadoImpDTO, Boolean validarEmbarque, String[] codigoBarrasValidado, Boolean almacenarEmbarque, HashSet<String> codigosLineaComercialUsuario) throws SICException;
	
	/**
	 * @param facturaEstadoImpDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<FacturaEstadoImpDTO> obtenerFacturasEmbarqueNoGeneradas(Collection<FacturaEstadoImpDTO> facturaEstadoImpDTOs) throws SICException;
}
