package ec.com.smx.sic.cliente.gestor.fruver.busqueda;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloOfertaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroRangoFechaDTO;

/**
 * 
 * @author jcayo<josecayo4@gmail.com>
 *
 */
public interface IBusquedaOfertaProveedorGestor extends Serializable {


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param filtros
	 * @param parametroRangoFechaDTO
	 * @return
	 */
	Collection<ArticuloOfertaProveedorDTO> buscarArticulosOfertaProveedor(Integer codigoCompania, String codigoProveedor, Map<String, Object> filtros,ParametroRangoFechaDTO parametroRangoFechaDTO);

	/**
	 * Busca si la oferta ya ha sido enviada
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 */
	Boolean esOfertaEnviada(Integer codigoCompania, String codigoProveedor);


}
