package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * 
 * @author gaortiz
 *
 */
public interface IArticuloAgrupadorDAO extends Logeable, Serializable {
	
	/**
	 * 
	 * @param articuloDTO
	 * @param tipoCatalogo
	 * @param valorCatalogo
	 * @return
	 * @throws SICException
	 */
	public Boolean existeCaracteristicaArticulo(ArticuloDTO articuloDTO, Integer tipoCatalogo, String valorCatalogo)throws SICException;
	
	/**
	 * Permite consultar los ArticulosAgrupador de un determinado articulo, que cumpla con codigo del tipo de agrupador
	 * @param codigoCompania C\u00F3digo de la compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoTipoAgrupador C\u00F3digo del Tipo de Agrupador
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException;
	
	Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo);
	
	Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO);
	
	void actualizarEstadoRelacion(Integer codigoCompania, String codigoArticulo, String campoArticulo, String nuevoEstado, String campoEstado, Class<? extends SearchDTO> clase, String userId ,List<Integer> codigoTipoAgrupadorList, List<String> tipoValorAgrupadorList) throws SICException;
}
