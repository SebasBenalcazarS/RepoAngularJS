package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;

public interface IObtencionDatosAlmacenamientoPlantillaGestor extends Serializable{
	
	/**
	 * @param plantillaOrdenCompraVO
	 * @throws SICException
	 */
	public void obtenerDatosGeneralesCreacionPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;
	
	/**
	 * Obtiene listado de dias habiles
	 * con codigos
	 * @param plantillaOrdenCompraVO 
	 */
	public void obtenerDias(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;
	
	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public Collection<PedidoPlantillaDetalleDTO> obtenerItemsPlantillaCreacion(PlantillaOrdenCompraVO plantillaOrdenCompraVO, ArticuloUnidadManejoProveedorDTO artUniManProDTO) throws SICException;

}
