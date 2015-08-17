package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;

public interface ICalculoConfiguracionValidacionesEtiquetadoRecepcionGestor {
	
	/**
	 * Metodo que obtiene las justificaciones para configurar las validaciones de etiquetado en la recepcion
	 * @param codigoCompania
	 * @param justificacionesEtiquetadoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionesEtiquetadoRecepcion(Integer codigoCompania, Collection<String> justificacionesEtiquetadoRecepcion, String codigoArticulo,
			Long codigoUnidadManejo, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * <b> Obtiene la configuracion de etiquetado de, registro sanitario
	 * transgénico y semaforo, para activar y desactivar las validaciones<b>
	 * <p>
	 * [Author: aecaiza, Date: 27/02/2015]	 
	 * @param codigoCompania
	 * @param codigoRecepcionProveedorArticulo
	 * @param validacionesEtiquetado
	 * @return
	 * @throws SICException
	 */
	Map<String, Boolean> obtenerConfiguracionesValidacionesEtiquetado(Integer codigoCompania, Long codigoRecepcionProveedorArticulo, Collection<String> validacionesEtiquetado)throws SICException;
	
	/**
	 * <b> Obtiene el codigo de de recepcion proveedor articulo<b>
	 * <p>
	 * [Author: aecaiza, Date: 02/03/2015]	 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Long obtenerCodigoRecepcionProveedorArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoRecepcionProveedor)throws SICException;
}
