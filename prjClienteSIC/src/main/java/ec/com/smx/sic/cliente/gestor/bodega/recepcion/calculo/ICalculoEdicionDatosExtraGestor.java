/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaDatosLogisticosVO;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoEdicionDatosExtraGestor {

	public Long obtenerCantidadArticulosBuscar(IPlantillaBusquedaEdicionMasivaArticulos plantillaBusquedaArticulos) throws SICException;

	public Collection<ArticuloEdicionMasivaDatosLogisticosVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;

	public Collection<ArticuloDTO> obtenerArticulosPorProceso(Integer codigoCompania, Long codigoProceso) throws SICException;

}
