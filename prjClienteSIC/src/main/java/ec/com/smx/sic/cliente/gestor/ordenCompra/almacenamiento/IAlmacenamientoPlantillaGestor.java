package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.PlantillaOrdenCompraVO;

public interface IAlmacenamientoPlantillaGestor {

	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public String crearPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;
	
	/**
	 * @param plantillaOrdenCompraVO
	 * @return
	 * @throws SICException
	 */
	public String modificarPlantilla(PlantillaOrdenCompraVO plantillaOrdenCompraVO) throws SICException;
}
