package ec.com.smx.sic.cliente.servicio.proveedorServicios;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author ivasquez
 *
 */

public interface IAccionMigracionProveedorServiciosServicio extends Serializable {

	/**
	 * Cargar el archivo en excel de proveedores de servicios a una tabla temporal
	 * 
	 * @param archivoProveedorServicios
	 * @throws SICException
	 */
	public void cargarArchivoProveedorServicios(String archivoProveedorServicios) throws SICException;
}