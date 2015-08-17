package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloJustificacionDTO;

public interface IAlmacenamientoConfiguracionValidacionesEtiquetadoRecepcionGestor {
	
	/**
	 * Registrar las justificaciones para las validaciones del etiquetado en la recepcion
	 * @param recepcionProveedorArticuloJustificacionCol
	 * @throws SICException
	 */
	void registrarJustificacionesEtiquetadoRecepcion(Collection<RecepcionProveedorArticuloJustificacionDTO> recepcionProveedorArticuloJustificacionCol, Integer codigoCompania, String codigoArticulo,
			Long codigoUnidadManejo, Long codigoRecepcionProveedor, Collection<String> validacionesEtiquetado, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO, String accesItemID, String codigoBarras,String userId)throws SICException;

}
