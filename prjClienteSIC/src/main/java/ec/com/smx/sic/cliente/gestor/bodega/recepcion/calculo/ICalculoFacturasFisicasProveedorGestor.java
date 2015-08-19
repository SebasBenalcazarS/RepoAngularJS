package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;


/**
 * 
 * Fecha 15-01-2015
 * 
 * @author lguaman
 * 
 */
public interface ICalculoFacturasFisicasProveedorGestor {

	BigDecimal calcularValorFactura(BigDecimal valorTotalFactura, BigDecimal descuento, BigDecimal valorIvaDoce, BigDecimal valorIvaCero);

	BigDecimal calcularValorTotalFactura(BigDecimal totalSujetoImpuestoDoce, BigDecimal totalSujetoImpuestoCero, BigDecimal valorImpIvaDoce, BigDecimal valorImpIvaCero, BigDecimal valorImpVerde);

	@Deprecated
	FacturaEstadoImpuestoDTO armarNuevafacturaEstadoImpuesto(FacturaEstadoImpuestoDTO facturaEstadoImpuesto) throws SICException;

	BigDecimal obtenerValorTotalImpuesto(FacturaEstadoImpuestoDTO facturaEstadoImpuesto);

	Collection<FacturaEstadoImpuestoDTO> agregarImpuestosFactura(Collection<TipoImpuestoDTO> litaTipoImpuestoDTOs, BigDecimal valorTotalFactura, BigDecimal valorImpuestoVerde, BigDecimal valorImpuestoIVa, String userId) throws SICException;
	
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
