package ec.com.smx.sic.cliente.persistencia.articulos.dao.relacionado;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;

public interface IArticuloRelacionadoDAO {

	/**
	 * M\u00E9todo que permite relacionar varios art\u00EDculos con un tipo de relaci\u00F3n espec\u00EDfica a un art\u00EDculo princial
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

	/**
	 * Retorna una coleccion todos los artisulos relacionados a un articulo en especifico
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param codigoTipoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRelacionDTO> obtenerArticulosRelacionadosCol(Integer codigoCompania, Collection<String> codigosBarrasArticulo, String valorTipoRelacion, String codigoTipoArticulo) throws SICException;

}
