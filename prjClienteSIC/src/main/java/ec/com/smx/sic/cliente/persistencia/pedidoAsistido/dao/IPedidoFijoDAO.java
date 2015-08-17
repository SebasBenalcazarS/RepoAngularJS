package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoFijoVO;



/**
 * 
 * @author bsandoval
 *
 */
public interface IPedidoFijoDAO {

	/**
	 * 
	 * @param pedidoPlantilla
	 * @param codigosSubbodega
	 * @param pedidoFijo
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDTO> obtenerPedidoPlantillaAreaTrabajo(PedidoPlantillaAreaTrabajoDTO pedidoPlantilla, Collection<Integer> codigosSubbodega, 
			PedidoFijoVO pedidoFijo) throws SICException;
	
	/**
	 * 
	 * @param plantillaArticulo
	 * @param codigoFuncionario
	 * @param codigoSubbodega
	 * @param pedidoFijo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerArticulos(ArticuloUnidadManejoDTO plantillaArticulo, String codigoFuncionario, Integer codigoSubbodega, 
			PedidoFijoVO pedidoFijo) throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<EstablecimientoDTO> obtenerFormatos() throws SICException;
	
	/**
	 * 
	 * @param codigosEstablecimiento
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo(Collection<Integer> codigosEstablecimiento ) throws SICException;
	
	/**
	 * 
	 * @param codigoArticulo
	 * @param codigosLocales
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> articuloLocalAreaTrabajo(String codigoArticulo, Collection<Integer> codigosLocales ) throws SICException;
	
	/**
	 * 
	 * @param idcodigoPlantillaCabecera
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> obtenerPedidoPlantillaDetalle(Long idcodigoPlantillaCabecera ) throws SICException;
	
	/**
	 * 
	 * @param pedidoFijoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDTO> obtenerPedidosPlantillaCabecera(PedidoFijoVO pedidoFijoVO ) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPedidoPlantillaAreaTrabajo
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarPedidoPlantillaAreaTrabajoDetalle(Integer codigoCompania, Long codigoPedidoPlantillaAreaTrabajo, String userId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCD
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoAreaTrabajoPedido
	 * @param codigoDiaSemana
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> obtenerDetallesPedidoFijoPorSubbodegaCD(Integer codigoCompania, Integer codigoAreaTrabajoCD, 
			Integer codigoAreaTrabajoSubbodega, Integer codigoAreaTrabajoPedido, Integer codigoDiaSemana) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDia
	 * @param codigoCD
	 * @param codigoSubbodega
	 * @param codigosLocales
	 * @return
	 * @throws SICException
	 */
	public Collection<Object[]> obtenerLocalesConPlantillasConfiguradas(Integer codigoCompania, Integer codigoDia, Integer codigoCD, Integer codigoSubbodega, 
			Collection<Integer> codigosLocales) throws SICException;
	
	/**
	 * 
	 * @param pUserId
	 * @return
	 * @throws SICException
	 */
	public UserDto obtenerInformacionUsuarioRegistro(String pUserId) throws SICException;
	
	/**
	 * 
	 * @param idCodigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoArticulo(ArticuloUnidadManejoDTO plantillaArticulo  ) throws SICException;
	
	/**
	 * 
	 * @param idcodigoPlantillaCabecera
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> obtenerPedidoPlantillaDetallePorLocal(Long idcodigoPlantillaCabecera, Integer codigoLocal ) throws SICException;
	
	public Collection<PedidoPlantillaAreaTrabajoDTO> obtenerPedidosCabecera(String codigoArticulo,Integer codigoDia,Integer codigoSubbodega, Integer codigoCD ) throws SICException ;
}
