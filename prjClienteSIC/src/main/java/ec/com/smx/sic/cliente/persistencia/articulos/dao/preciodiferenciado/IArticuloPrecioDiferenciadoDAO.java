package ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;


public interface IArticuloPrecioDiferenciadoDAO {
	
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
	public void guardarArticuloPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException;

	void actualizarArticuloPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException;

	Collection<ArticuloPrecioDiferenciadoDTO> buscarArticuloPrecioDiferenciadoPorValor(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException;
	
}
