package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.accion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;

/**
 * @author mhidalgo
 *
 */
public interface IAccionMigracionArticuloLocalPreciosGestor extends Serializable{
	
	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	void ejecutarCambioPreciosArticulosLocalesPrecios(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	Collection<ArticuloLocalGestionPrecioDTO> obtenerArticulosLocalesPreciosPlanificados(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @param codigosLocal
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPrecioDTO> obtenerArticulosLocalPrecio(Integer codigoCompania, Set<String> codigosArticulo, Set<Integer> codigosLocal) throws SICException;
	
	/**
	 * @param fechaCierre
	 * @param articulosLocalPrecio
	 * @param precioPlanificado
	 * @return
	 * @throws SICException
	 */
	void migrarArticuloLocalPrecioPlanificado(Date fechaCierre, Collection<ArticuloLocalPrecioDTO> articulosLocalPrecio, ArticuloLocalGestionPrecioDTO precioPlanificado) throws SICException;

}
