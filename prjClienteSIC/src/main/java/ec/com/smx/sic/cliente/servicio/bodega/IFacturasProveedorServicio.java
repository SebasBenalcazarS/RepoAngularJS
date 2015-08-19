package ec.com.smx.sic.cliente.servicio.bodega;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;


/**
 * 
 * @author acaiza
 *
 */
public interface IFacturasProveedorServicio {

	/**
	 * 
	 * @param entregaVO
	 * @param ordenCompraDetalleEstadoDTOCol
	 * @return
	 * @throws SICException
	 */
	public FacturaDTO transCrearFacturaProveedor(FacturaEstadoDTO facturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	public void transEliminarFacturaProveedor(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * 
	 * @param entregaVO
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	public void transActualizarFacturaProveedor(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
		
	/**
	 * Recalcula los valores de una factura con los nuevos valores para impuesto tarifa 12 y 0
	 * @param facturaEstadoOriginal
	 * @param facturaEstadoImpuestoDoce
	 * @param facturaEstadoImpuestoCero
	 * @param facturaEstadoImpuestoIve
	 */
	void transRecalcularFacturaProveedor(FacturaEstadoDTO facturaEstadoOriginal, FacturaEstadoImpuestoDTO facturaEstadoImpuestoDoce, FacturaEstadoImpuestoDTO facturaEstadoImpuestoCero, FacturaEstadoImpuestoDTO facturaEstadoImpuestoIve) throws SICException;

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
	void transCrearFacturaFisicaRecepcionProveedor(Long codigoRecepcionProveedor, FacturaEstadoDTO facturaEstadoNuevo, FacturaEstadoImpuestoDTO facturaEstadoImpuestoDoce, FacturaEstadoImpuestoDTO facturaEstadoImpuestoCero, FacturaEstadoImpuestoDTO facturaEstadoImpuestoIve) throws SICException;

	/**
	 * Crea una coleccion de impuestos como plantilla para agregar a la factura
	 * 
	 * @param litaTipoImpuestoDTOs
	 * @param valorTotalFactura
	 * @param valorImpuestoVerde
	 * @param valorImpuestoIVa
	 * @param userId
	 * @throws SICException
	 */
	Collection<FacturaEstadoImpuestoDTO> agregarImpuestosFactura(Collection<TipoImpuestoDTO> litaTipoImpuestoDTOs, BigDecimal valorTotalFactura, BigDecimal valorImpuestoVerde, BigDecimal valorImpuestoIVA, String userId) throws SICException;
	
	/**
	 * <b> Crea una coleccion con los impuestos que aplica las facturas del proveedor; incluye el calculo de las sujetos impuestos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/8/2015]
	 * </p>
	 *
	 * @param valorTotalFactura
	 *            valor total ingresado para la factura
	 * @param valorImpuestoVerde
	 *            valor ingresado para el impuesto verde
	 * @param valorImpuestoIVA
	 *            valor ingresado para el impuesto IVA12
	 * @param userId
	 *            identificador del usuario logeado
	 * @return coleccion con los impuesto que seran agregados a la factura
	 * @throws SICException
	 *             excepcion propagada en caso de existir un error
	 */
	Collection<FacturaEstadoImpuestoDTO> obtenerImpuestosEstadoFactura(BigDecimal valorTotalFactura, BigDecimal valorImpuestoVerde,
			BigDecimal valorImpuestoIVA, String userId) throws SICException;
}
