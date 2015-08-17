package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionArticuloUnidadManejoDTO;

public interface IAsignacionArticuloUnidadManejoDAO {

	/**
	 * Permite buscar si existe articulounidadManejo para insert o update
	 * @param codigoCompania
	 * @param codigoDetalleSeccion
	 * @param codigoUnidadMan
	 * @param codigoArticulo
	 * @return
	 */
	public AsignacionArticuloUnidadManejoDTO consultarAsignacionArticuloUnidadManejo(Integer codigoCompania,Long codigoDetalleSeccion,Long codigoUnidadMan,String codigoArticulo,String estado);
	
	/**
	 * Permite activar un reguisro AsignacionArticuloUnidadManejoDTO
	 * @param asArticuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void actualizarAsignacionArticuloUnidadManejo(AsignacionArticuloUnidadManejoDTO asArticuloUnidadManejoDTO)throws SICException;
	
	/**
	 * Permite actualizar la cantidad de articulos en una ubicacion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param cantidadUbicacion
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarCantidadArticuloUbicacion(Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Integer cantidadUbicacion,Integer codigoCompania,String userID)throws SICException;

	/**
	 * Permite actualizar la relacion que existe con la ubicacion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarRelacionUbicacionUnidadManejo(Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Integer codigoCompania,String userID)throws SICException;
	
	/**
	 * Permita actualizar la fecha de caducidad si es necesario
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param fechaCaducidad
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarFechaCaducidadArticuloUbicacion(Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Timestamp fechaCaducidad,Integer codigoCompania,String userID)throws SICException;

	/**
	 * Permite obtener las unidades de manejo atadas a las ubicaciones virtuales de una ubicacion fisica
	 * @param codigoDetalleSeccionPadre
	 * @param codigoCompania
	 * @param codigosUnidadesM
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> obtenerAsignacionesUbicacionUnidadManejo(Long codigoDetalleSeccionPadre,Integer codigoCompania,Collection<Long> codigosUnidadesM, Collection<String> codigosArticulos)throws SICException;
	
	
	
}
