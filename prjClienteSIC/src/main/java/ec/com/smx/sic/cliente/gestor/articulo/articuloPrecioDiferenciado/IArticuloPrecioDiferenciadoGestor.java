/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;


/**
 * @author guvidia
 *
 */
public interface IArticuloPrecioDiferenciadoGestor {
	
	/**
	 * Consulta los precios diferenciados por articulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloPrecioDiferenciadoDTO> obtenerArticulosPrecioDiferenciado(Integer codigoCompania, String codigoArticulo, String estado) throws SICException;

	/**
	 * Metodo para guardar el precio diferenciado desde la edicion de articulos
	 * @param articuloPrecioDiferenciadoDTO
	 * @throws SICException
	 */
	void registrarCollArticuloPrecioDiferenciado(Collection<ArticuloPrecioDiferenciadoDTO> articuloPrecioDiferenciadoDTOCol, ArticuloGestionPrecioDTO articuloGestionPrecioConflictos) throws SICException;
	
//	List<String> buscarCodigosArticulos(ArticuloVO articuloVO, IPlantillaBusquedaArticuloPrecioDiferenciado plantillaBusquedaArticulos);

	void guardarPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException;
}
