/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.condicionescomerciales.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author Victor Jaramillo
 *
 */
public interface IValidacionProveedorClasificacionGestor {

	/**
	 * @param codigoCompania
	 * @param listaProveedorClasificacion
	 * @param listaAsignacionTipoDescuento
	 * @throws SICException
	 */
	void completarDescuentosProveedorClasificacion(Integer codigoCompania,
			Collection<ProveedorClasificacionDTO> listaProveedorClasificacion, Collection<AsignacionTipoDescuentoDTO> listaAsignacionTipoDescuento) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Boolean validarClasificacionesExistentesLineaComercial( Integer codigoCompania, 
			String codigoFuncionario, String codigoProceso) throws SICException;
}
