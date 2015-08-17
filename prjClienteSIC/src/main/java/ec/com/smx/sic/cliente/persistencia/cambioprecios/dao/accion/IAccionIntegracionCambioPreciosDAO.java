package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.accion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosPreciosArticuloProveedorIntegracion;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IAccionIntegracionCambioPreciosDAO extends Serializable {

	/**
	 * Obtener los precios y los costos de cada articulo proveedor en caso de tener
	 * 
	 * @param codigoCompania
	 * @param secuencialArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<DatosPreciosArticuloProveedorIntegracion> obtenerPreciosCostosArticuloProveedor(Integer codigoCompania, Set<Long> secuencialArticulos) throws SICException;
	
	/**
	 * Eliminar los articulos que se encontraban pendientes para integrar y ya han sido integrados
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	void eliminarArticulosPendientesIntegracion(Integer codigoCompania) throws SICException;
	
	/**
	 * Obtener los codigos secuenciales de los articulos que estan pendientes para la integracion
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Set<Long> obtenerSecuencialArticulosPendientesParaIntegracion(Integer codigoCompania) throws SICException;
	
	/**
	 * Actualizar las observaciones enviadas de los articulos pendientes para la integracion
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @param observacion
	 * @throws SICException
	 */
	void actualizarObservacionArticuloPendienteIntegracion(Integer codigoCompania, String codigoArticulo, String codigoProveedor, String observacion) throws SICException;
}
