package ec.com.smx.sic.cliente.gestor.bodega.administracion.migracion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;

/**
 * @author osaransig
 * May 28, 2013
 */
public interface IMigracionOrdenesCompraGestor {

	/**
	 * Migrar ordenes de compra B2B - SIC
	 * @param vistaEntregaFacturaDigitalDTO
	 * @throws SICException
	 */
	void migrarOrdenesCompra(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO) throws SICException;
	
	/**
	 * Migracion ordenes de compra facturas
	 * @param codigoCompania
	 * @param fechaEntrega
	 * @throws SICException
	 */
	void migrarOrdenCompraFactura(Integer codigoCompania, String fechaEntrega) throws SICException;
	
	/**
	 * Migracion ordenes de compra factura
	 * @param codigoCompania
	 * @throws SICException
	 */
	void migrarOrdenCompraFactura(Integer codigoCompania) throws SICException;
	
	/**
	 * Enviar y generar el archivo de Entregas Planificadas del proveedor 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void enviarPlanificacionEntregaProveedor(Integer codigoCompania)throws SICException;
	

	
}
