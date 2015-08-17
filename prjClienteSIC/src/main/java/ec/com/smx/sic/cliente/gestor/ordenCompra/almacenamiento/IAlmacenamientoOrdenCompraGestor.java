/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.InterfacePedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoArchivoInformacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.OrdenCompraContingenciaPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;

/**
 * @author jvillacis
 *
 */
public interface IAlmacenamientoOrdenCompraGestor extends Serializable{

	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompraTransaccional(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOModificacion
	 * @return
	 * @throws SICException
	 */
	public OrdenCompraEstadoDTO modificarOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTOModificacion) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTO
	 * @param ordenCompraDetalleEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public OrdenCompraDetalleEstadoDTO rechazarEntregaArticuloOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO, OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * @param pedidoDTO
	 * @throws SICException
	 */
	public void guardarArchivosCreadosOrdenCompra(PedidoDTO pedidoDTO)throws SICException;
	
	/**
	 * @param pedidosEmbarqueAlmacenados
	 * @throws SICException
	 */
	public void guardarArchivosGeneradosOrdenCompraEmbarque(Collection<PedidoDTO> pedidosEmbarqueAlmacenados) throws SICException;
	
	/**
	 * 
	 * @param pedidoArchivoInformacionDTO
	 * @throws SICException
	 */
	public void actualizarPedidoArchivoComoUtilizado(PedidoArchivoInformacionDTO pedidoArchivoInformacionDTO) throws SICException;
	
	/**
	 * 
	 * @param plantillaOrdenCompraVO
	 * @return
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdePlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param datosArchivoValidado
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> crearOrdenCompraDesdeArchivo(AdminOrdenCompraVO adminOrdenCompraVO, LinkedHashMap<String, List> datosArchivoValidado) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstado
	 * @param archivosPlanos
	 * @param archivoReporte
	 * @param archivoNotaPedido
	 * @throws SICException
	 */
	@Deprecated
	public void modificarArchivosPedido(OrdenCompraEstadoDTO ordenCompraEstado, boolean archivosPlanos, boolean archivoReporte, boolean archivoNotaPedido) throws SICException;
		
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param anularAnterior
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO,Boolean anularAnterior) throws SICException;
	
	/**
	 * @param adminOrdenCompraVO
	 * @param ordenCompraEstadoDTOInicial
	 * @param accion
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> modificarOrdenCompraNacional(AdminOrdenCompraVO adminOrdenCompraVO, OrdenCompraEstadoDTO ordenCompraEstadoDTOInicial) throws SICException;
	
	/**
	 * Metodo que actualiza un pedido
	 * @param codigoCompania
	 * @param codigoPedido
	 * @param codigoMigracion
	 * @throws SICException
	 */
	public void actualizarPedidoDto(Integer codigoCompania, Long codigoPedido, Integer codigoMigracion) throws SICException;

	/**
	 * Permite actualizar el Pedido despues del proceso de envio de email
	 * @param pedidoDTO
	 * @param procesoEnvioEmail
	 * @throws SICException
	 */
	public void actualizarPedidoEnvioEmail(PedidoDTO pedidoDTO, Integer procesoEnvioEmail) throws SICException;

	/**
	 * Busca las sumatorias para generar las ordenes de compra por pedido asistido.
	 * @param arrayList Restricciones de la busqueda.
	 * @return
	 */
	public Collection<SumatoriaUnidadManejoOrdenCompraVO> obtenerSumatoriaParaOrdenCompra(Collection<InterfacePedidoAreaTrabajoDTO> arrayList);

	/**
	 * 
	 * @param configuracion
	 * @return Lista de ordenes de compra generadas.
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompraDesdePedidoAsistido(Collection<InterfacePedidoAreaTrabajoDTO> configuracion);

	/**
	 * Genera las ordenes de compra por contigencia de pedido asistido.
	 * 
	 * @param configuracion Parametros para generar la orden de compra
	 * @return Lista de ordenes de compra generadas.
	 */
	public Collection<OrdenCompraDTO> crearOrdenCompraContingenciaPedidoAsistido(OrdenCompraContingenciaPedidoAsistidoVO configuracion);

}
