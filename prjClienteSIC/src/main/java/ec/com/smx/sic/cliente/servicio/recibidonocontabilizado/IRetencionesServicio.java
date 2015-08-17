package ec.com.smx.sic.cliente.servicio.recibidonocontabilizado;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoRetencionesDTO;

public interface IRetencionesServicio {
	
	public Collection<VistaRecibidoNoFacturadoRetencionesDTO> obtenerRetenciones(String codigoProveedor, Date fechaDesde, Date fechaHasta, String numeroRetencion, String numeroFactura) throws SICException;
	
	public void transRegistrarRetencionesDesdeArchivos(String rutaDirectorio) throws SICException;
	
}
