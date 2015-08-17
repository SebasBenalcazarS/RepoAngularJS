package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;


/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoFacturasFisicasProveedorGestor {		
	/**
	 * Recalcula los valores de la factura
	 * 
	 * @param facturaEstadoOriginal
	 * @param facturaEstadoImpuestoDoce
	 * @param facturaEstadoImpuestoCero
	 * @param facturaEstadoImpuestoIve
	 * @throws SICException
	 */	
	FacturaEstadoDTO recalcularFacturaProveedor(FacturaEstadoDTO facturaEstadoOriginal, FacturaEstadoImpuestoDTO facturaEstadoImpuestoDoce, FacturaEstadoImpuestoDTO facturaEstadoImpuestoCero, FacturaEstadoImpuestoDTO facturaEstadoImpuestoIve) throws SICException;

	/**
	 * Crea una factura fisica del proveedor en una recepcion
	 * 
	 * @param codigoRecepcionProveedor
	 * @param facturaEstadoNuevo
	 * @param facturaEstadoImpuestoDoce
	 * @param facturaEstadoImpuestoCero
	 * @param facturaEstadoImpuestoIve
	 * @throws SICException
	 */	
	FacturaEstadoDTO crearFacturaFisicaRecepcionProveedor(Long codigoRecepcionProveedor, FacturaEstadoDTO facturaEstadoNuevo, FacturaEstadoImpuestoDTO facturaEstadoImpuestoDoce, FacturaEstadoImpuestoDTO facturaEstadoImpuestoCero, FacturaEstadoImpuestoDTO facturaEstadoImpuestoIve);	
			
}
