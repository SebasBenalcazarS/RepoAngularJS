package ec.com.smx.sic.cliente.gestor.articulo.articuloagrupador;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IArticuloAgrupadorGestor {
	/**
	 * 
	 * @param articuloVO
	 * @param esCreacion
	 */
	void registrarAgrupadorArticulo(ArticuloVO articuloVO, Boolean esCreacion);
	
	Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO);
	
	Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo);
	
	Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException;
}
