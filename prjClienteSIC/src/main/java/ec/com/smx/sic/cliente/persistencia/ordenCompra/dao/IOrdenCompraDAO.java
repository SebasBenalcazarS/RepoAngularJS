package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorB2BDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * @author aguato
 *
 */
public interface IOrdenCompraDAO {

	/**
	 * Permite obtener el proveedorB2B
	 * @param codigoCompania Codigo de la compania
	 * @param codigoProveedor Codigo del proveedor
	 * @return ProveedorB2B
	 * @throws SICException
	 */
	public Collection<ProveedorB2BDTO> obtenerProveedorB2B(Integer codigoCompania, String codigoProveedor)throws SICException;
	
	/**
	 * Permite obtener la Bodega
	 * @param codigoCompania Codigo de la compania
	 * @param codigoBodega Codigo de la bodega
	 * @return BodegaDTO
	 */
	public Collection<BodegaDTO> obtenerBodega(Integer codigoCompania, String codigoBodega);
	
	/**
	 * Permite obtener los pedidos que tienen pendiente el envio de email al usuario del proveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoDTO> obtenerPedidosPendientesEnvioEmail(Integer codigoCompania) throws SICException;
	
	/**
	 * Valida si un pedido tiene ordenes de compra con estado Enviada
	 * @param codigoCompania Codigo de la compania
	 * @param codigoPedido Codigo del pedido que se esta procesando
	 * @return True si tiene ordenes de compra con estado enviada, False en caso contrario
	 * @throws SICException
	 */
	public Boolean validarOrdenCompraEstadoEnviada(Integer codigoCompania, Long codigoPedido) throws SICException;
	
	/**
	 * Permite actualizar el Pedido despues del proceso de envio de email
	 * @param pedidoDTO
	 * @param procesoEnvioEmail
	 * @throws SICException
	 */
	public void actualizarPedidoEnvioEmail(PedidoDTO pedidoDTO, Integer procesoEnvioEmail) throws SICException;
	
	/**
	 * Permite obtener los codigos de los usuarios proveedor que tengan determinado rol
	 * @param usuarioProveedorCol Coleccion de usuarios Proveedor
	 * @param rolId Rol a verificar
	 * @return Coleccion de codigos de los proveedor que cumplen el rol
	 * @throws SICException
	 */
	public Collection<String> filtrarCodigosUsuariosProveedorRol(Collection<UsuarioProveedor> usuarioProveedorCol, String rolId) throws SICException;

	/**
	 * Verifica si el estado de la orden de compra
	 * que se está visualizando es la actual o la 
	 * misma fue modificada
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean validarEstadoActualOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

	/**
	 * Busca las ordenes de compras que cumplan los parametros ingresados.
	 * @param ordenCompraEstado Objeto contenedor de los parametros de busqueda.
	 * @param componentesMap
	 *            Map con los componentes de busqueda. Utiliza los siguientes
	 *            componentes.
	 *            <table style="text-align:center;">
	 *            <tr>
	 *            <td><b>KEY</b></td>
	 *            <td><b>OBJETO</b></td>
	 *            </tr>
	 *            <tr>
	 *            <td>filtroBusquedaProveedor</td>
	 *            <td>PlantillaBusquedaProveedor</td>
	 *            </tr>
	 *            <tr>
	 *            <td>filtroBusquedaArticuloF</td>
	 *            <td>PlantillaBusquedaArticulo</td>
	 *            </tr>
	 *            <tr>
	 *            <td>codigoClasificacionF</td>
	 *            <td>SearchTemplateDTO&lt;String&gt;</td>
	 *            </tr>
	 *            <tr>
	 *            <td>descClasificacionF</td>
	 *            <td>SearchTemplateDTO&lt;String&gt;</td>
	 *            </tr>
	 *            </table>
	 * @param bodegas Lista de bodegas en las cuales buscar las ordenes de compras.
	 * @return
	 */
	public SearchResultDTO<OrdenCompraEstadoDTO> buscarOrdenesCompra(AdminOrdenCompraVO ordenCompraEstado, Map<String, Object> componentesMap, Collection<BodegaDTO> bodegas);



	public Long contarOrdenesCompra(Map<String, Object> componentesMap, Collection<BodegaDTO> bodegas);

	/**
	 * Metodo para obtener las ordenes de compra por sus codigos de ordenCompra.
	 * @param codigoCompania
	 * @param codigosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraEstadoDTO> obtenerOrdenesCompraPorCodigos(Integer codigoCompania, Set<String> codigosOrdenCompra) throws SICException;

	public BodegaDTO buscarBodegaParaOrdenCompra(Integer codigoCompania, String codigoBodega);

	public AreaTrabajoDTO buscarAreaTrabajoParaOrdenCompra(Integer codigoCompania, String codigoAreaTrabajo);

	public FuncionarioDTO buscarFuncionarioParaOrdenCompra(Integer codigoCompania, String codigoUsuario);

	/**
	 * Obtiene las LineaComercialClasificacion dada una lista de codigos de lineas comerciales.
	 * @param lineas Codigos de lineas comerciales.
	 * @return Listado de LineaComercialClasificacionDTO.
	 */
	public Collection<LineaComercialClasificacionDTO> obtenerLineaComercialClasificacionPorLineaComercial(Collection<Long> lineas, String codigoSub);
	
	
	
	/**
	 * Metodo para obtener un objeto de tipo catalogo valor apartir de su valor numerico y el tipo
	 * @param valorNumerico
	 * @param codigoCatalogoTipo
	 * @return CatalogoValorDTO
	 * @throws SICException
	 */
	public CatalogoValorDTO obtenerCatalogoValorPlazoPago(Long valorNumerico, Integer codigoCatalogoTipo) throws SICException;
	
	/**
	 * Obtiene el ArticuloUnidadManejoDTO dado por los parametros correspondientes
	 * @param articuloProveedorDTO
	 * @param valorUnidadManejo
	 * @param listadoDatosFila
	 * @param codigoBarras
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("rawtypes")
	public ArticuloUnidadManejoDTO validarExistenciaArticuloUnidadManejo(ArticuloProveedorDTO articuloProveedorDTO, Integer valorUnidadManejo, 
			List listadoDatosFila, String codigoBarras, String codigoAreaTrabajo) throws SICException;

	/**
	 * Busca las ordenes de compras que cumplan los parametros ingresados para impresion.
	 * @param listadoIdsOrdenesCompra
	 * @return
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraParaImpresion(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra);

	/**
	 * Busca los códigos de barras de cada artículo en una orden de compra
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @param codigoFuncionario
	 * @return Collection<String>
	 */
	public Collection<String> obtenerCodigoBarrasEtiquetado(Integer codigoCompania, String numeroOrdenCompra, String codigoFuncionario) throws SICException;
	
	/**
	 * Obtiene informaci&oacute;n de un proveedor
	 * @param pedidoDTO
	 * @throws SICException
	 */
	public void actualizarInformacionProveedor(PedidoDTO pedidoDTO) throws SICException;
		
	/**
	 * Busca ordenes de compra por ids
	 * @param listadoIdsOrdenesCompra
	 * @return
	 */
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraPorIds(Collection<OrdenCompraEstadoID> listadoIdsOrdenesCompra);
	
	/**
	 * Validar existencia de ordenes de compra pendientes validas
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @param tipo
	 * @param numeroOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Boolean validarOrdenesCompraPendientes(String codigoProveedor, Integer codigoCompania, CatalogoValorDTO tipoPedido, String numeroOrdenCompra) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Long contarArticulosClases(ArticuloDTO articuloDTO) throws SICException;
	
	/**
	 * @param codigoLocal
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public String validarAlcanceLocal(Integer codigoLocal, Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Valida si la orden de compra
	 * se debe cerrar en base al numero
	 * de entregas.
	 * 
	 * @param codigoOrdenCompra
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Boolean verificarCierreOrdenCompra(Long codigoOrdenCompra, Integer codigoCompania) throws SICException;

}
