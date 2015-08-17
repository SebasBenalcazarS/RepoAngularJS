/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.math.BigDecimal;
import java.util.Date;

import ec.com.kruger.cliente.sri.consumo.ws.RespuestaWsSRI;
import ec.com.kruger.cliente.sri.respuesta.ws.jaxb.Autorizacion;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoElectronicoSRI;
import ec.com.smx.sic.integracion.dto.recibidoNoContabilizado.ObtenerNotasIngresoSubBodegaIDTO;

/**
 * @author vjaramillo
 *
 */
public interface IIntegracionRecibidoNoContabilizadoGestor {

	/**
	 * Metodo para consultar la autorizacion y nota de débito en el Web service del SRI mediante la clave de acceso
	 * @param claveAcceso
	 * @param respuestaWsSRI
	 * @throws SICException
	 */
	DocumentoElectronicoSRI obtenerWSAutorizacionFacturaSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI) throws SICException;
	
	/**
	 * Metodo para consultar la autorizacion y nota de crédito en el Web service del SRI mediante la clave de acceso
	 * @param claveAcceso
	 * @param respuestaWsSRI
	 * @throws SICException
	 */
	public DocumentoElectronicoSRI obtenerWSAutorizacionNotaCreditoSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI) throws SICException;
	
	/**
	 * Metodo para crear una factura estado con sus impuestos iva 12 y base cero
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param factura
	 * @param idUser
	 * @param catalogoTipoCambio
	 * @return
	 * @throws SICException
	 */
	FacturaEstadoDTO guardarFacturaEstadoConImpuestos(Integer codigoCompania, Long codigoFactura, Duplex<?, Autorizacion> factura, String idUser, String catalogoTipoCambio) throws SICException;

	/**
	 * Actualiza los valores totales:
	 * <p>Total tarifa DOCE</p>
	 * <p>Total tarifa CERO</p>
	 * <p>Valor tarifa IVE</p>
	 * <p>de la factura estado del proveedor</p>
	 * @param migracionFacturaInternaDTO
	 * @param facturaEstadoProveedorDTO
	 * @param tarifaDoceProveedor
	 * @param valorIveProveedor
	 */
	void actualizarTotalesFacturaEstadoProveedor(String usuarioRecepcion, FacturaEstadoDTO facturaEstadoProveedorDTO, BigDecimal tarifaDoceProveedor, BigDecimal tarifaCeroProveedor, BigDecimal valorIveProveedor) throws SICException;
	
	/**
	 * Este metodo devuelve por integracion la cantidad de notas de ingreso por subBodega en base a la fecha que recibo
	 * como parametro
	 * @param fechaNotasIngreso
	 * @return
	 * @throws SICException
	 */
	public ObtenerNotasIngresoSubBodegaIDTO obtenerCantidadNotasIngresoSubBodega(Date fechaNotasIngreso) throws SICException;
}
