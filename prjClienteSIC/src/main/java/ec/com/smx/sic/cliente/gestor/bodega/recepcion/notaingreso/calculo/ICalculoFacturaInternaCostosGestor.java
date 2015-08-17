/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.notaingreso.calculo;

import java.math.BigDecimal;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaInternaVO;

/**
 * <b> Gestor encargado de calcular los costos totales y parciales asociados a la factura interna. </b>
 *
 * @author mchiliquinga, Date: 12/12/2014
 *
 */
public interface ICalculoFacturaInternaCostosGestor {

	/**
	 * <b> Calcula el total de los impuestos y las tarifas asociadas al a Factura Interna. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/12/2014]
	 * </p>
	 *
	 * @param facturaInterna contiene los datos de la recepcion
	 * @throws SICException
	 */ 
	void calcularTotalesFacturaInterna(FacturaInternaVO facturaInterna) throws SICException;
	
	/**
	 * <b> Suma dos valores BigDecimal y los redonde a cuatro decimales hacia el inmediato superior. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/12/2014]
	 * </p>
	 *
	 * @param valorA
	 *            primer dato para sumar
	 * @param valorB
	 *            segundo dato para sumar
	 * @return resultado de sumar los dos parametros
	 */ 
	BigDecimal sumarBigDecimal(BigDecimal valorA, BigDecimal valorB) throws SICException;
	
	String valorTotalColumna(List<DetalleFacturaEstadoDTO> datosReporte, String columnaSuma) throws SICException;
	
	/**
	 * <b> En el caso que algun valor del reporte este en null retorna cero como valor por defecto. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/3/2015]
	 * </p>
	 *
	 * @param valorFactura
	 *            representa un valor de la factura
	 * @return cadena con el valor que tiene la factura
	 */
	String validarAtributoValor(BigDecimal valorFactura) throws SICException;
	
}

