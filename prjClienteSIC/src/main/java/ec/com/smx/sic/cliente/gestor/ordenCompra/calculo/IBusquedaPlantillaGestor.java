package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;

public interface IBusquedaPlantillaGestor extends Serializable{
	
	/**
	 * @param codigoCompania
	 * @param plantillaOrdenCompraVO
	 * @throws SICException
	 */
	public void buscarColeccionesFiltrosPlantilla(Integer codigoCompania, PlantillaOrdenCompraVO plantillaOrdenCompraVO)  throws SICException;
	
	/**
	 * @param plantillaOrdenCompraVO
	 * @param componentesMap
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<PedidoPlantillaDTO> buscarPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO, Map<String, Object> componentesMap, boolean ordenCompra, boolean filtroDia) throws SICException;
	
	/**
	 * @param pedidoPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaDetalleDTO> obtenerDetallesPlantilla(PedidoPlantillaDTO pedidoPlantillaDTO, boolean ordenCompra) throws SICException;
}
