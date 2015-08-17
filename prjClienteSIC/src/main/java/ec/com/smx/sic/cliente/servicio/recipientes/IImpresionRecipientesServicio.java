package ec.com.smx.sic.cliente.servicio.recipientes;

import org.jdom.Document;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

public interface IImpresionRecipientesServicio {
	/**
	 * Imprime la orden de salida obteniendo los datos del objeto OrdenSalidaRecipienteDTO de  TareaDTO
	 * @param codigoCompania
	 * @param tareaDTO
	 * @throws SICException
	 */
	Document construirReporteOrdenSalida(Integer codigoCompania,TareaDTO tareaDTO) throws SICException;
	
	
}
