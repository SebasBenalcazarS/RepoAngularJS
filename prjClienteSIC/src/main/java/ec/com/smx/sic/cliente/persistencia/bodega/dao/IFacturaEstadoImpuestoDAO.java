package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IFacturaEstadoImpuestoDAO {
	
	/**
	 * Almacena el impuestos de la factura
	 * @param facturaEstadoDTO
	 * @param comprobanteVO
	 * @param crearFacturaEstadoImpuesto
	 * @throws SICException
	 */
	void guardarFacturaEstadoImpuesto(FacturaEstadoDTO facturaEstadoDTO, ComprobanteVO comprobanteVO, Boolean crearFacturaEstadoImpuesto)throws SICException;

	/**
	 * Actualiza los valores de los impuestos en factura estado impuesto
	 * @param facturaEstadoImpuestoDTO
	 * @throws SICException
	 */
	void actualizarValoresFacturaEstadoImpuesto(FacturaEstadoImpuestoDTO facturaEstadoImpuestoDTO) throws SICException;

	/**
	 * Obtiene los impuestos que tiene configurado una factura
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @throws SICException
	 */
	Collection<FacturaEstadoImpuestoDTO> obtenerImpuestosFactura(Integer codigoCompania, Long codigoFacturaEstado) throws SICException;
	
	/**
	 * <b> Actualiza el estado del impuesto, puede activarlo o inactivarlo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/6/2015]
	 * </p>
	 *
	 * @param userId
	 *            usuario que realiza la transaccion.
	 * @param nuevoEstado
	 *            estado con el que se actualiza el impuesto (Activo/Inactivo).
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param codigosFacturaEstado
	 *            identificador para definir la o las facturas a actualizar.
	 */
	void actualizarEstadoFacturaImpuesto(String userId, String nuevoEstado, Integer codigoCompania, Long... codigosFacturaEstado);
}
