/*
 * Creado el 2013-04-10
 */
package ec.com.smx.sic.cliente.gestor.recargacupon;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.framework.common.util.dto.TreeNode;
import ec.com.smx.frameworkv2.security.dto.InformationSystemDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.CuponDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.BinTarjetaDTO;
import ec.com.smx.sic.cliente.mdl.vo.AsistenteCompraVO;

/**
 * Interfaz que expone lo metodos de cambio de estado de cupones.
 * 
 * @author fvallejo
 * 
 */
public interface ICuponGestor {

	/**
	 * Obtiene cupones vigentes o no vigentes dependiendo del codigo de estado.
	 * 
	 * @param articulo
	 * @param fechaProceso
	 * @return the Collection<ArticuloDTO>
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> findCuponesVigentes(ArticuloDTO articulo, Date fechaProceso) throws SICException;

	/**
	 * Obtiene cupones vigentes por fecha y establecimientos.
	 * 
	 * @param articuloDTO
	 * @param fechaProceso
	 * @param establecimientosCol
	 * @param codigoClientePedido
	 * @param valorAgrupador
	 * @return the SearchResultDTO<CuponDTO>
	 * @throws SICException
	 */
	public SearchResultDTO<CuponDTO> findCuponesVigentesPaged(ArticuloDTO articuloDTO, Date fechaProceso, Collection<EstablecimientoDTO> establecimientosCol, Long codigoClientePedido, String valorAgrupador)
			throws SICException;

	/**
	 * Actualiza los cupones codificados a vigentes y los vigentes (caducados) a no vigentes.
	 * 
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void actualizarCupones(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;
	
	/**
	 * Actualiza los cupones con estado codificado a vigentes.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void actualizarACuponesVigentes(Integer codigoCompania,String usuarioProceso,String fechaProceso) throws SICException;
	
	/**
	 * Actualiza los cupones con estado vigente (caducados) a no vigente.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void actualizarACuponesNoVigentes(Integer codigoCompania,String usuarioProceso,String fechaProceso) throws SICException;
	
	/**
	 * Inactiva cupones caducados a los clientes, estos cupones pueden ser recomendados o selecionados por el cliente (activos).
	 * @param codigoCompania
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void inactivarCuponesAClientes(Integer codigoCompania, String fechaProceso) throws SICException;
	
	/**
	 * Actualiza los cupones codificados a vigentes,los vigentes (caducados) a no vigentes y procesa la asignacion de codigos internos a los cupones.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	public void actualizarCuponesYAsignarCodigoInterno(Integer codigoCompania,String usuarioProceso,String fechaProceso) throws SICException;
	
	/**
	 * Proceso para la asignacon de codigos internos a los cupones.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	void asignarCodigoInternoCupones(Integer codigoCompania, String usuarioProceso) throws SICException;
	
	/**
	 * Proceso para la asignacion de codigos internos a los cupones por local.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param maximoCuponesValidos
	 * @param articuloLocalTreeNode
	 * @throws SICException
	 */
	public void asignarCodigoInternoCuponesPorLocal(Integer codigoCompania, String usuarioProceso, Integer maximoCuponesValidos, TreeNode articuloLocalTreeNode) throws SICException;
	
	/**
	 * Obtiene los codigos de referencia que se encuentran disponibles para volver a asignar
	 * @param vistaArticuloLocalDTO
	 * @return Collection<String>
	 * @throws SICException
	 */
	Collection<String> findCodigoReferenciaDisponibles(VistaArticuloLocalDTO vistaArticuloLocalDTO) throws SICException;
	/**
	 * Obtiene el total de cupones que tienen que transmitirse a los locales en el archivo diario.
	 * @param codigoCompania
	 * @param fecha
	 * @param codigoLocal
	 * @return Long
	 * @throws SICException
	 */
	Long findCountCuponesProcesoArchivo(Integer codigoCompania, Date fecha, Integer codigoLocal) throws SICException;

	/**
	 * Metodo utilizado en los web service para actualizar datos de cupones.
	 * @param asistenteCompraVO
	 * @return 
	 * @throws SICException
	 */
	AsistenteCompraVO actualizarDatosWS(AsistenteCompraVO asistenteCompraVO) throws SICException;
	
	/**
	 * Busca el articulo en base al codigo de barras.
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return ArticuloDTO
	 * @throws SICException
	 */
	ArticuloDTO findArticuloByCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	/**
	 * Obtiene los terminos y condiciones de acuerdo al/los tipos
	 * @param tipoContenido
	 * @param fechaUltimaActualizacion
	 * @return InformationSystemDTO
	 * @throws SICException
	 */
	InformationSystemDTO findTerminosAndCondiciones(String tipoContenido, Timestamp fechaUltimaActualizacion) throws SICException;
	
	/**
	 * Devuelve el codigo de barras del codigo EAN recibido.
	 * @param codigoEAN
	 * @return
	 * @throws SICException
	 */
	public String consultarCodigoCuponWS(String codigoEAN) throws SICException;
	
	/**
	 * Metodo para consultar los cupones por formato de negocio 
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO transConsultarCuponesKiosko(AsistenteCompraVO asistenteCompraVO)throws SICException;
	
	/**
	 * Busca cupones vigentes que no tengan imagen web o movil.
	 * @param fechaProceso
	 * @return Collection<ArticuloDTO>
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> findCuponesSinImagen(Date fechaProceso)throws SICException;
	
	/**
	 * Metodo utilizado en el web service para actualizar datos estructura
	 * @param asistenteCompraVO
	 * @return
	 * @throws SICException
	 */
	public AsistenteCompraVO  actualizarDatosEstructuraWS(AsistenteCompraVO asistenteCompraVO) throws SICException;
	
	/**
	 * Metodo que inactiva cupon a todos los clientes que lo tienen seleccionado
	 * @param codigoArticulo codigo del cupon que se va inactivar a los clientes.
	 */
	public void inactivarCuponAClientes(String codigoArticulo) throws SICException;
	
	/**
	 * Marcar cupones como cupones recomendados, estos cupones recomendados tiene un mejor ahorro.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	public void marcarCuponesRecomendados(Integer codigoCompania,String usuarioProceso) throws SICException;
	
	/**
	 * Elimina registros inactivos en la tabla cliente articulo.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 */
	public void eliminarCuponesInactivos(Integer codigoCompania, String usuarioProceso, String fechaProceso) throws SICException;
	
	
	
	public Collection<ArticuloDTO> findCuponesByCodigoTipoAgrupador(Timestamp fechaUltimaActualizacion,Long codigoClientePedido, Integer codigoTipoAgrupador,String[] valorTipoAgrupador) throws SICException;
	
	/**
	 * Marcar cupones como cupones popularaes, un cupon popular es aquel que fue usado varias veces y por varios clientes en las ultimas 2 semanas y le quede al menos 2 dias de vigencia.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	public void marcarCuponesPopulares(Integer codigoCompania,String usuarioProceso) throws SICException;

	public void showBinCards(Collection<Long> binCardIds, Boolean showBinCards);
	
	public Collection<BinTarjetaDTO> findBinCards(Timestamp lastUpdate);

	public Long createBinCard(BinTarjetaDTO binTarjetaDTO);
}
