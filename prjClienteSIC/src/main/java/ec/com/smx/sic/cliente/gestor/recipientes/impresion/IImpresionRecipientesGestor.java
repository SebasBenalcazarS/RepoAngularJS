package ec.com.smx.sic.cliente.gestor.recipientes.impresion;

import org.jdom.Document;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * 
 * @author aquingaluisa
 *
 */
public interface IImpresionRecipientesGestor {
	/**
	 * Imprime la orden de salida obteniendo los datos del objeto OrdenSalidaRecipienteDTO de  TareaDTO
	 * @param codigoCompania
	 * @param tareaDTO
	 * @throws SICException
	 */
	Document construirReporteOrdenSalida(Integer codigoCompania,TareaDTO tareaDTO) throws SICException;
}
