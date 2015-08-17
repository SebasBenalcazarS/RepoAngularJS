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

	FacturaEstadoImpuestoDTO armarNuevafacturaEstadoImpuesto(FacturaEstadoImpuestoDTO facturaEstadoImpuesto) throws SICException;

	BigDecimal obtenerValorTotalImpuesto(FacturaEstadoImpuestoDTO facturaEstadoImpuesto);

	Collection<FacturaEstadoImpuestoDTO> agregarImpuestosFactura(Collection<TipoImpuestoDTO> litaTipoImpuestoDTOs, BigDecimal valorTotalFactura, BigDecimal valorImpuestoVerde, BigDecimal valorImpuestoIVa, String userId) throws SICException;

	
}
