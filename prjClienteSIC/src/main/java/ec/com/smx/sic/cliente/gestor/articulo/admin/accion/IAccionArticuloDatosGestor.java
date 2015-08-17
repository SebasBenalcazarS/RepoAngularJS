package ec.com.smx.sic.cliente.gestor.articulo.admin.accion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarDatosArticuloIDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

/**
 * @author aguato
 *
 */
public interface IAccionArticuloDatosGestor {

	/**
	 * Metodo que retorna estructura con datos
	 * de articulos para ordenes de compra
	 * @param adminOrdenCompraVO
	 * @return ConsultarDatosArticuloIDTO
	 * @throws SICException
	 */
	IConsultarDatosArticuloIDTO consultarDatosArticulosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, Collection<OrdenCompraDetalleEstadoDTO> detalles) throws SICException;
}
