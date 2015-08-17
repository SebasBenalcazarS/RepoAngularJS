/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoRetencionesDTO;


public interface IRetencionesGestor {

	public Collection<VistaRecibidoNoFacturadoRetencionesDTO> obtenerRetenciones(String codigoProveedor, Date fechaDesde, Date fechaHasta, String numeroRetencion, String numeroFactura) throws SICException;
	
	public void registrarRetencionesDesdeArchivos(String rutaDirectorio) throws SICException;
	
}
