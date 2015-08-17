package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * 
 * @author amunoz
 *
 */
public interface INotaPedidoCompraDAO {
	
	/**
	 * 
	 * @param codigoProveedor
	 * @param codigosLineaComercialClienteImportacion
	 * @return
	 */
	public boolean validarEsNotaPedido(String codigoProveedor, Collection<Long> codigosLineaComercialClienteImportacion, ParametroDTO codigoProveedoresAOmitir);

	/**
	 * 
	 * @param codigoCompania
	 * @param codigosLineaComercial
	 * @return
	 */
	public abstract LinkedHashMap<String,Long> obtenerCodigosClasificacionLineasComerciales(Integer codigoCompania,
																							  ArrayList<Long> codigosLineaComercial);
	
	/**
	 * 
	 * @param bodegasCol
	 * @return
	 */
	public abstract Integer obtenerParametroCaracteristicaBodega(Collection<BodegaDTO> bodegasCol);
	
	/**
	 * Metodo que actualiza un pedido
	 * @param codigoCompania
	 * @param codigoPedido
	 * @param codigoMigracion
	 * @throws SICException
	 */
	public void actualizarPedidoDto(Integer codigoCompania, Long codigoPedido, Integer codigoMigracion) throws SICException;

	public Collection<LineaComercialClienteImportacionDTO> obtenerLineaComercialCliente(Collection<Long> codigoLineaComercial);
}
