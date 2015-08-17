package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;

public interface IArticuloEtiquetaServicio {
	
	/**
	 * Obtiene los articulos por tipo de etiqueta y por tipo de articulo
	 * @author dbravo
	 * @param codigoCompania
	 * @param codigoEtiqueta
	 * @param codigoTipoArticulo
	 * @return
	 */
	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo)throws SICException;
	
	/**
	 * Obtiene los articulos recipientes 
	 * @author dbravo
	 * @param codigoCompania
	 * @param codigoArticuloTipoPadre
	 * @return
	 * @throws SICException
	 */
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre)throws SICException;
	
	/**
	 * Obtiene el valorSecuencia de la relacion entre Articulo-Etiqueta
	 * @author dbravo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoEtiqueta
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta)throws SICException;
	
	/**
	 * Actualiza el objeto ArticuloEtiqueta que contiene el secuencial
	 * @param articuloEtiquetaDTO
	 * @throws SICException
	 */
	public void  actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO)throws SICException;
}
