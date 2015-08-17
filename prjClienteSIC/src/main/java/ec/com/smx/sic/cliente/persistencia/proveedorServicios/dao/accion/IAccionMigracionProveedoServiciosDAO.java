package ec.com.smx.sic.cliente.persistencia.proveedorServicios.dao.accion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MigracionProveedorServiciosDTO;

/**
 * 
 * @author ivasquez
 *
 */

public interface IAccionMigracionProveedoServiciosDAO extends Serializable {

	/**
	 * Cargar la tabla temporal de los proveedores de servicios
	 * 
	 * @param datosArchivoCargado
	 * @throws SICException
	 */
	void cargarTablaTemporalProveedorServicios(MigracionProveedorServiciosDTO datosArchivoCargado) throws SICException;
	
	/**
	 * Obtener los proveedores que se encuentran en la tabla temporal
	 * 
	 * @throws SICException
	 */
	Collection<MigracionProveedorServiciosDTO> obtenerProveedoresTablaTemporal() throws SICException;
	
	/**
	 * Actualizar la tabla temporal de los proveedores de servicios
	 * 
	 * @param datosArchivoCargado
	 * @throws SICException
	 */
	void actualizarTablaTemporalProveedorServicios(MigracionProveedorServiciosDTO datosArchivoCargado) throws SICException;
	
}
