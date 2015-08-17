/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IOrdenCompraDetalleEstadoDescuentoDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IOrdenCompraDetalleEstadoImpuestoDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IOrdenCompraEstadoImpuestoDAO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
/**
 * @author jvillacis
 *
 */
public interface IOrdenCompraEstadoGestor extends Serializable {

	/**
	 * 
	 * @param ordenCompraEstadoDTOInicio
	 * @param accion
	 * @return
	 * @throws SICException
	 */
	public OrdenCompraEstadoDTO generarNuevoEstadoOrdenCompra(
			OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial, 
			String accion) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOInicial
	 * @return
	 */
	public OrdenCompraEstadoDTO anularOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOOriginal
	 * @param ordenCompraDetalleEstadoDTOOriginal
	 * @param ordenCompraDetalleEstadoDTOActual
	 * @param diferenciaCantidadPedida
	 * @param diferenciaPesoPedido
	 * @param diferenciaCantidadEntregada
	 * @param diferenciaPesoEntregado
	 * @param actualizarCantidadesParciales
	 * @throws SICException
	 */
	public void actualizarOrdenCompraDetalleEstadoOriginal(
			OrdenCompraEstadoDTO ordenCompraEstadoDTOOriginal,
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTOOriginal,
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTOActual,
			Integer diferenciaCantidadPedida, BigDecimal diferenciaPesoPedido,
			Integer diferenciaCantidadEntregada,
			BigDecimal diferenciaPesoEntregado, Boolean actualizarCantidadesParciales) throws SICException;

	
	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 */
	public void crearHistoricoEstadoOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO)  throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @return
	 */
	public OrdenCompraEstadoDTO inactivarOrdenCompraEstado(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;
	
	/**
	 * <b> Recalcula los valores de la orden compra detalle estado en el caso de que se remplaze el articulo de un detalle; posteriormente realiza la
	 * actualizacion de los detalles y la cabecera en la base de datos . </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 15/08/2014]
	 * </p>
	 * 
	 * @param ordenCompraDetalleEstadoDTOs
	 *            son todos los detalles en los cuales se actualizara la unidad de manejo el proveedor y el articulo unidad manejo proveedor
	 * @param articuloUnidadManejoProveedorDTO
	 *            este ojeto contiene los datos para realizar el remplazo del articulo
	 * @param codigoCompania
	 * @param userId
	 */
	void recalcularValoresOrdenCompraDetalleEstado(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs,
			ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO, Integer codigoCompania, String userId, boolean calculoCostoNeto);
	
	/**
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEstadoActualOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;
	
	/**metodo que valida la fecha fin de una orden compra estado anterior
	 * recibiendo como parametro la orden compra estado actual.
	 * 
	 * @param ordenCompraEstadoActual
	 * @return
	 * @throws
	 */
	public Boolean validarFechaFinOrdenCompraEstadoAnterior(OrdenCompraEstadoDTO ordenCompraEstadoActual) throws SICException;
	
	/**
	 * @param ordenCompraEstadoDTO
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	public void actualizarCalculoOrdenCompraEstado(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, BigDecimal costoBrutoActualizado, String userId) throws SICException;
	
	/**
	* {@link IOrdenCompraDetalleEstadoDescuentoDAO#obtenerDescuentosDetalleOrdenCompra(Long, Integer, String)}
	*/ 
	List<OrdenCompraDetalleEstadoDescuentoDTO> obtenerDescuentosDetalleOrdenCompra(Long codigoOrdenCompraDetalleEstado,
			Integer codigoCompania, String estado) throws SICException;
	
	/**
	* {@link IOrdenCompraDetalleEstadoImpuestoDAO#obtenerImpuestosPorDetalle(Long, Integer, String)}
	*/ 
	List<OrdenCompraDetalleEstadoImpuestoDTO> obtenerImpuestosPorDetalle(Long codigoOrdenCompraDetalleEstado, Integer codigoCompania,
			String estado) throws SICException;
	
	/**
	 * {@link IOrdenCompraEstadoImpuestoDAO#obtenerImpuestosPorEstado(Long, Integer, String)}
	 */
	List<OrdenCompraEstadoImpuestoDTO> obtenerImpuestosPorEstado(Long codigoOrdenCompraEstado, Integer codigoCompania,
			String estado) throws SICException;
	
	/**
	 * Edita de forma masiva un listado de ordenes de compra identificadas por su ID
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 */
	public Map<String,String> modificarCabeceraOrdenes(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra, AdminOrdenCompraVO ordenCompraVO) throws SICException;
	
	/**
	 * Edita la cabecera de una orden de compra
	 * @param listadoIdsOrdenesCompra
	 * @param ordenCompraVO
	 * @return OrdenCompraEstadoDTO
	 */
	public OrdenCompraEstadoDTO modificarCabeceraOrden(OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial) throws SICException;

	/**
	 * Anula de forma masiva un listado de ordenes de compra identificadas por su ID
	 * @param listadoIdsOrdenesCompra
	 * @param userId
	 */
	public Map<String,String> anularOrdenesCompra(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra, String userId) throws SICException;

	
	
}
