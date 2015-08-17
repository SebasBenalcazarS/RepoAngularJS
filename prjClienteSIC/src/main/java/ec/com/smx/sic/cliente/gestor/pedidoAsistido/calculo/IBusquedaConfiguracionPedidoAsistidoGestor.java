package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.EstructuraConfiguracionPedidoAsistidoVO;

/**
 * @author aguato
 *
 */
public interface IBusquedaConfiguracionPedidoAsistidoGestor extends Serializable {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCalendario
	 * @param codigoAreaTrabajoConfiguracion
	 * @param codigoAreaTrabajoCalendarioPadre
	 * @param soloAreTraCalPro
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoCalendarioProcesoDTO buscarAreaTrabajoCalendarioProceso (Integer codigoCompania, Integer codigoAreaTrabajoCalendario, 
			Collection<Integer> codigosAreaTrabajoConfiguracion, Integer codigoAreaTrabajoCalendarioPadre, boolean soloAreTraCalPro, 
			boolean codigoProceso, Integer diaSemana, Collection<Long> codigosConfiguracionHijos) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @throws SICException
	 */
	public void buscarConfiguracionAreaTrabajo(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @param codigoDia
	 * @return
	 * @throws SICException
	 */
	public EstructuraConfiguracionPedidoAsistidoVO buscarConfiguracionDiaAreaTrabajo(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO, Integer codigoDia) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @param codigoDia
	 * @return
	 * @throws SICException
	 */
	public Collection<EstructuraConfiguracionPedidoAsistidoVO> buscarConfiguracionesDiaAreaTrabajo(ConfiguracionPedidoAsistidoVO configuracionPedidoAsistidoVO, Integer codigoDia) throws SICException;
	
	/**
	 * 
	 * @param configuracionPedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public void buscarConfiguracionLocales(ConfiguracionPedidoAsistidoVO  configuracionPedidoAsistidoVO) throws SICException;
	
}
