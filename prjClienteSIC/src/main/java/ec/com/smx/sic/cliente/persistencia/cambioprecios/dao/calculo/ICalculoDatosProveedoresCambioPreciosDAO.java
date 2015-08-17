/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosProveedoresCambioPreciosDAO extends Serializable {
	
	/** 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Set<String> obtenerCodigosArticulosQueTienenVariosProveedores(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosClasificacion
	 * @return
	 * @throws SICException
	 */
	HashMap<String, Boolean> obtenerClasificacionesUnificarCostoProveedor(Integer codigoCompania, Set<String> codigosClasificacion) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @param codigosProveedores
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorDTO> obtenerArticulosProveedoresPorCodigos(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoGestionPrecio
	 * @param codigosArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorGestionPrecioDTO> obtenerArticulosProveedorRelacionadosCambioPrecios(Integer codigoCompania, Set<Long> codigoGestionPrecio, Set<String> codigosArticulo) throws SICException;

}
