package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author acaiza
 *
 */
public interface ICalculoFacturasRecepcionGestor {
	
	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaEstadoDTO> obtenerFacturasProveedor(Collection<EntregaDTO> entregasDTO, Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO) throws SICException;

	/**
	 * Este metodo obtiene todas las facturas de una recepcion y de las entregas de la recepcion seg�n los parametros que recibe ademas si la lista de recepciones no trae las entregas
	 * primero las calcula
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */	
	Collection<FacturaEstadoDTO> obtenerFacturasProveedorRecepcion(Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO, Boolean traerFacturasRecepcion, Boolean traerFacturasEntregas, Boolean traerDetallesFacturas, Boolean traerFacturaInterna) throws SICException; 
	
	/**
	 * 
	 * @param codigosBarras
	 * @param facturaEstadoDTO
	 * @param listaRecepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaEstadoDTO> obtenerFacturasPorCriterios(Collection<String> codigosBarras, FacturaEstadoDTO facturaEstadoDTO, Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO) throws SICException;
	
	/**
	 * <b> Obtiene los ids de los estados de las facturas en base a los detalles y el codigo de barras de un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 15/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            codigo de la compania para filtrar la busqueda
	 * @param estado
	 *            estado activo
	 * @param codigoBarras
	 *            codigo de barras del articulo
	 * @param codigosOrdenCompraFacturas
	 *            detalles de ordenes de compra asociado a las facturas
	 * @return ids de los estados de las factura
	 */
	List<Long> obtenerIdFacturaCodigoBarras(Integer codigoCompania, String estado, String codigoBarras,
			List<Long> codigosOrdenCompraFacturas) throws SICException;
	
}
