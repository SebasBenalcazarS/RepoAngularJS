package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDescuentoDTO;

public interface IFacturaEstadoDescuentoDAO {

	/**
	 * Metodo para obtener la facturaEstadoDescuento en base a una factura electronica
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param valor
	 * @param concepto
	 * @param idUser
	 * @return
	 * @throws SICException
	 */
	public FacturaEstadoDescuentoDTO obtenerFacturaEstadoDescuentoDTO(Integer codigoCompania, Long codigoFacturaEstado, BigDecimal valor, String concepto, String idUser) throws SICException;	
	
	/**
	 * Metodo para obtener la facturaEstadoDescuento en base a una factura electronica
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param codigoTipoImpuesto
	 * @param valor
	 * @param codigoImpuestoSRI
	 * @param porcentajeImpuestoSRI
	 * @param concepto
	 * @param idUser
	 * @return
	 * @throws SICException
	 */
	public FacturaEstadoDescuentoDTO obtenerFacturaEstadoDescuentoDTO(Integer codigoCompania, Long codigoFacturaEstado, Integer codigoTipoImpuesto, BigDecimal valor, String codigoImpuestoSRI, String porcentajeImpuestoSRI, String concepto, String idUser) throws SICException;
}
