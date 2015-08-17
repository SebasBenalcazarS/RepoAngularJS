package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoFacturasRecepcionGestor {

	/**
	 * Guarda una nueva factura de un proveedor
	 * 
	 * @param facturaEstadoDTOs
	 * @param entregaDTO
	 * @throws SICException
	 */
	public FacturaEstadoDTO registroFacturasFisicas(Collection<FacturaEstadoDTO> facturaEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Guarda una nueva factura electronica de un proveedor
	 * 
	 * @param facturaEstadoDTOs
	 * @param entregaDTO
	 * @throws SICException
	 */
	public FacturaEstadoDTO registroFacturasElectronicas(Collection<FacturaEstadoDTO> facturaEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Modifica el numero de una factura
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	public FacturaEstadoDTO modificarFacturaFisica(FacturaEstadoDTO facturaEstadoDTO) throws SICException;

	/**
	 * @param facturaEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public FacturaEstadoDTO modificarFactura(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * Elimina las facturas registradas en una recepcion
	 * 
	 * @param recepcion
	 * @param listaFacturasRegistradas
	 * @throws SICException
	 */
	public void eliminarFacturasRecepcion(RecepcionProveedorDTO recepcion, Collection<FacturaEstadoDTO> listaFacturasRegistradas) throws SICException;
	
	/**
	 * Registra las facturas FDI en la recepcion proveedor factura
	 * 
	 * @param codigosFacturaDigital
	 * @param codigoRecepcion
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void registrarFacturasDigitales(Collection<Long> codigosFacturaDigital, Long codigoRecepcion, Integer codigoCompania, String userId);
		
}
