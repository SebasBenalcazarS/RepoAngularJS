package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.InterfacePedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;
import ec.com.smx.sic.cliente.mdl.vo.EstructuraConfiguracionPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.InterfacePedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;

public interface IObtencionDatosInterfacePedidoAsistidoGestor extends Serializable {

	/**
	 * 
	 * @param codigoCompania
	 * @param datosBusquedaAreaTrabajoEST
	 * @param estructuraConfiguracionPedidoAsistidoVOs
	 * @return
	 * @throws SICException
	 */
	public boolean obtenerConfiguracionSubbodega(Integer codigoCompania, DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST, 
			List<EstructuraConfiguracionPedidoAsistidoVO> estructuraConfiguracionPedidoAsistidoVOs) throws SICException;
	
	/**
	 * 
	 * @param interfacePedidoAsistidoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> buscarPedidosParaInterface(InterfacePedidoAsistidoVO interfacePedidoAsistidoVO) throws SICException;

	/**
	 * 
	 * @return
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValorDTO();

	/**
	 * 
	 * @param configuracion
	 * @return
	 */
	public Collection<SumatoriaUnidadManejoOrdenCompraVO> obtenerSumatoriaParaOrdenCompra(Collection<InterfacePedidoAreaTrabajoDTO> configuracion);

	/**
	 * 
	 * @param codigoCompania
	 * @param servidorDestino
	 * @return
	 * @throws SICException
	 */
	public ProcesoConfiguracionDTO obtenerProcesoConfiguracionInterface(Integer codigoCompania, boolean servidorDestino) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoInterfacePedidoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public InterfacePedidoAreaTrabajoDTO obtenerInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoInterfacePedidoAreaTrabajo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<Long> obtenerInterfacesPedidoSinGenerarArchivo(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCD
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoAreaTrabajoPedido
	 * @param fechaPedido
	 * @param verificaOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<Long> obtenerInterfacesPedidoNormalDelDia(Integer codigoCompania, Integer codigoAreaTrabajoCD, Integer codigoAreaTrabajoSubbodega, 
			Integer codigoAreaTrabajoPedido, Date fechaPedido, boolean verificaOrdenCompra) throws SICException;
}
