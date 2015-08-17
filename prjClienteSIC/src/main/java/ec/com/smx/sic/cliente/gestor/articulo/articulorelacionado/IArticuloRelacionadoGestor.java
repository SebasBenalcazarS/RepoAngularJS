package ec.com.smx.sic.cliente.gestor.articulo.articulorelacionado;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;

/**
 * @author gaortiz, mgranda
 *
 */
public interface IArticuloRelacionadoGestor {
	
	void registrarArticulosRelacionados( Collection<ArticuloRelacionDTO> articulosRelacionados ) throws SICException;
	
	void registrarArticuloRelacionado( ArticuloRelacionDTO articuloRelacionDTO ) throws SICException;

	/**
	 * Metodo que permite relacionar uno o varios articulos con un tipo de relacion especifica con un articulo principal
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param userId
	 * @param codigosArticulosRelacionados
	 * @return
	 * @throws SICException
	 */
	Integer relacionarArticulo(Integer codigoCompania, String codigoArticulo, String valorTipoRelacion, String userId, String... codigosArticulosRelacionados) throws SICException;
}
