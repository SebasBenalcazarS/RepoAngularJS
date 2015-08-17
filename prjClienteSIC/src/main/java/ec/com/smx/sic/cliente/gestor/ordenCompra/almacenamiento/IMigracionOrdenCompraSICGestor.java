/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.ordenCompra.almacenamiento;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion.IMigracionFacturaInternaDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion.IMigracionFacturaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion.IMigracionOrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion.IMigracionOrdenCompraDetalleDTO;

/**
 * @author jvillacis
 *
 */
public interface IMigracionOrdenCompraSICGestor extends Serializable{

	/**
	 * 
	 * @param codigoCompania
	 * @param archivoProcesamientoActual
	 * @return LogProcesosMigracionDTO
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO procesarArchivoEntregaFacturaInterna(Integer codigoCompania, File archivoProcesamientoActual) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param archivoProcesamientoActual
	 * @return LogProcesosMigracionDTO
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO procesarArchivoEntregaOrdenCompra(Integer codigoCompania, File archivoProcesamientoActual) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param migracionOrdenCompraDTO
	 * @param migracionOrdenCompraDetalleDTOCol
	 * @param nombreArchivo
	 * @return
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO migrarEntregaOrdenCompra(Integer codigoCompania, IMigracionOrdenCompraDTO migracionOrdenCompraDTO, 
			Collection<IMigracionOrdenCompraDetalleDTO> migracionOrdenCompraDetalleDTOCol, String nombreArchivo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param migracionFacturaInternaDTO
	 * @param migracionFacturaProveedorDTOCol
	 * @param nombreArchivo
	 * @return
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO migrarEntregaFacturaInterna(Integer codigoCompania, IMigracionFacturaInternaDTO migracionFacturaInternaDTO, 
			Collection<IMigracionFacturaProveedorDTO> migracionFacturaProveedorDTOCol, String nombreArchivo) throws SICException;
}
