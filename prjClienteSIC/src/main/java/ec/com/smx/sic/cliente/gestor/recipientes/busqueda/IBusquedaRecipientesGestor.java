package ec.com.smx.sic.cliente.gestor.recipientes.busqueda;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorRelacionadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RutaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TransferenciaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ContenedorEstadoCountTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.ContenedorEstadoPalletRutaTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.TransferenciaCountTrasient;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;

/**
 * 
 * @author cherrera
 *
 */
public interface IBusquedaRecipientesGestor {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param adminContenedorVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosContenedores(AdminContenedorVO adminContenedorVO)  throws SICException;
	
	/**
	 * @param adminContenedorVO
	 * @throws SICException
	 */
	public Collection<ContenedorDetalleDTO> buscarDetalleContenedor(Long codigoContenedor,Integer codigoCompania,String vista) throws SICException;
	
	/**
	 * @param adminContenedorVO
	 * @trhows SICException
	 */
	public Collection<ContenedorRelacionadoDTO> buscarContenedoresRelacionados(AdminContenedorVO adminContenedorVO) throws SICException;
	
	/**
	 * @param adminContenedorVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ContenedorEstadoDTO> buscarContenedores(AdminContenedorVO adminContenedorVO, Map<String, Object> componentesMap) throws SICException;

	/**
	 * @param componentesBusqueda
	 * @param adminContenedorVO
	 */
	public void agregarRestriccionesBusquedaContenedores(Map<String, Object> componentesBusqueda, AdminContenedorVO adminContenedorVO);

	/**
	 * @param contenedorEstadoDTO
	 * @throws SICException
	 */
	public void inicializarBusquedaContenedores(ContenedorEstadoDTO contenedorEstadoDTO) throws SICException;
	
	/**
	 * @param idTiposTransaccion
	 * @return
	 */
	public Collection<TransaccionDTO> buscarTipoTransaccion(Integer tipoAreaTrabajoTIC,String tipoAreaTrabajoValor) throws SICException;
	
	/**
	 * @param codigoTipoTransaccion
	 * @param codigoCatalogoTipo
	 * @param codigoCatalogoValor
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<ContenedorEstadoCountTrasient> obtenerCantidadCajasPorEstado (List<Integer> codigosTipoTransaccion, Integer codigoCatalogoTipo,List<String> codigoCatalogoValor, String estado) throws SICException;
	
	/**
	 * @param codigoTipoTransaccion
	 * @param codigoCatalogoTipo
	 * @param codigoCatalogoValor
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<ContenedorEstadoCountTrasient> obtenerCantidadPalletsPorEstado (List<Integer> codigosTipoTransaccion, Integer codigoCatalogoTipo,List<String> codigoCatalogoValor,String estado) throws SICException;
	
	/**
	 * @param codigoTipoTransaccion
	 * @param codigoCatalogoTipo
	 * @param codigoCatalogoValor
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<TransferenciaCountTrasient> obtenerCantidadRecipientesPorEstado (Integer codigoTipoTransaccion, Integer codigoCatalogoTipo,List<String> codigoCatalogoValor, String estado) throws SICException;
	
	/**
	 * @param adminContenedorVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ContenedorEstadoDTO> buscarTodoContenedores(AdminContenedorVO adminContenedorVO) throws SICException;
	
	/**
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
	public RutaDTO buscarRuta(String codigoRuta) throws SICException;
	
	/**
	 * @param codigoCatalogoValorActual
	 * @param codigoCatalogoTipoActual
	 * @param numeroContenedor
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
	public ContenedorEstadoPalletRutaTrasient obtenerPalletRuta (List<String> codigoCatalogoValorActual, Integer codigoCatalogoTipoActual,String numeroContenedor,String codigoRuta,String estado) throws SICException;
	
	/**
	 * @param codigoContenedor
	 * @return
	 * @throws SICException
	 */
	public Integer contarNumeroCajas(Long codigoContenedor) throws SICException;
	
	/**
	 * @param contenedorEstadoDTO
	 * @throws SICException
	 */
	public void inicializarBusquedaTransferencias(ContenedorEstadoDTO contenedorEstadoDTO) throws SICException;
	
	/**
	 * @param componentesBusqueda
	 * @param adminTransferenciaVO
	 */
	public void agregarRestriccionesBusquedaTransferencias(Map<String, Object> componentesBusqueda, AdminContenedorVO adminContenedorVO);

	/**
	 * @param adminTransferenciaVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ContenedorEstadoDTO> buscarTransferencias(AdminContenedorVO adminContenedorVO, Map<String, Object> componentesMap) throws SICException;
	
	/**
	 * @param adminTransferenciaVO
	 * @return
	 * @throws SICException
	 */
	public Collection<TransferenciaDTO> buscarTodoTransferencias(AdminContenedorVO adminContenedorVO) throws SICException;
	
	/**
	 * @param codigoRuta
	 * @return
	 * @throws SICException
	 */
	public Integer contarNumeroPallets(String codigoRuta) throws SICException;
	
	/**
	 * @return
	 * @throws SICException
	 */
	public Collection<ContenedorDetalleDTO> buscarTransaccionesCausales(ContenedorDetalleDTO contenedorDetalleDTO) throws SICException;
	
	/**
	 * @param codigoContenedor
	 * @throws SICException
	 */
	public void eliminarContenedorRelacionado(Long codigoContenedorPadre, Long codigoContenedorRelacionado) throws SICException;
	
	/**
	 * @param codigoContenedor
	 * @throws SICException
	 */
	public void eliminarContenedorDetalle(Long codigoContenedor) throws SICException;
	
	/**
	 * @param codigoContenedorRelacionado
	 * @return
	 * @throws SICException
	 */
	public ContenedorRelacionadoDTO buscarContenedorRelacionado(String estado, Long codigoContenedorPadre, Long codigoContenedorRelacionado) throws SICException;
}
