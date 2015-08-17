package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.InterfacePedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.vo.InterfacePedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;

public interface IInterfacePedidoAsistidoDAO {

	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValorDTO() throws SICException;

	/**
	 * 
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValorDTO(Integer codigoCatalogoTipo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param fechaPedido
	 * @param codigoCentroDistribucion
	 * @param codigoSubbodega
	 * @param local
	 * @param tipoPedido
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoAreaTrabajoDTO> buscarPedidosParaInterface(int codigoCompania, Date fechaPedido, Integer codigoCentroDistribucion, Integer codigoSubbodega, Integer local, String tipoPedido) throws SICException;
	
	/**
	 * 
	 * @param interfacePedidoAsistidoVO
	 * @param pedidosConsolidados
	 * @param insertarDetalle
	 * @return
	 */
	public InterfacePedidoAreaTrabajoDTO crearInterfacePedidoAreaTrabajo(InterfacePedidoAsistidoVO interfacePedidoAsistidoVO, Collection<PedidoAreaTrabajoDTO> pedidosConsolidados, boolean insertarDetalle);
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public boolean verificarSubbodegaGeneraOC(Integer codigoCompania, Integer codigoSubbodega) throws SICException;

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
	 * @param codigoIntefacePedidoAreaTrabajo
	 * @param codigoProcesado
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarEstadoInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoIntefacePedidoAreaTrabajo, Character codigoProcesado, String userId) throws SICException;

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
