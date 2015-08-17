package ec.com.smx.sic.cliente.gestor.proveedorServicios.administracion.accion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * 
 * @author ivasquez
 *
 */

public interface IAccionMigracionProveedorServiciosGestor extends Serializable {

	/**
	 * Migrar el archivo en excel de proveedores de servicios a una tabla temporal
	 * 
	 * @param archivoProveedorServicios
	 * @throws SICException
	 */
	void transMigrarArchivoProveedorServicios(String archivoProveedorServicios) throws SICException;
	
	/**
	 * Migrar los datos de la tabla temporal de proveedor de servicios a la tabla de proveedores
	 * 
	 * @throws SICException
	 */
	void transMigrarDatosProveedoServicios() throws SICException;
	
	/**
	 * Generar correos automaticamente al ingresar un proveedor de servicios
	 * 
	 * @param proveedorVO
	 * @param emailContactoB2B
	 * @param nombreEntidad
	 * @throws SICException
	 */
	void generarCorreoCreacionProveedorServicios(ProveedorVO proveedorVO, String emailContactoB2B, String nombreEntidad) throws SICException;
}