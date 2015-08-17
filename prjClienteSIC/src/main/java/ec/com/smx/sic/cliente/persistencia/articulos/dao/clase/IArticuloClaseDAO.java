package ec.com.smx.sic.cliente.persistencia.articulos.dao.clase;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;

public interface IArticuloClaseDAO {

	void crearArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException;

	void actualizarArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException;

	ArticuloClaseDTO obtenerUnicoArticuloClase(Long secuencialArtCla);

	Collection<ArticuloClaseDTO> obtenerArticuloClase(Long... secuencialArtCla);
	
	public ArticuloClaseDTO obtenerArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException;

	Boolean existeArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException;

}
