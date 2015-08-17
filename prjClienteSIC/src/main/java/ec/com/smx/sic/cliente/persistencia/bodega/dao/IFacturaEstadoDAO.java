package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FlujoEstadoFacturaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IFacturaEstadoDAO {

	/**
	 * Permite crear el registro del detalle de la factura
	 * @param comprobanteVO
	 * @param facturaDTO
	 * @param crearFacturaEstado
	 * @param tareaProgramada
	 * @throws SICException
	 */
	public FacturaEstadoDTO guardarFacturaEstado(ComprobanteVO comprobanteVO, FacturaDTO facturaDTO, Boolean crearFacturaEstado, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Permite inactivar la factura estado
	 * @param codigoFactura
	 * @param codigoUsuario
	 * @param estado
	 * @throws SICException
	 */
	public void activarDesactivarFacturaEstado(Long codigoFactura, String codigoUsuario, String estado)throws SICException;
	
	/**
	 * Permite actualizar los valores de la factura
	 * @param codigoFactura
	 * @param valorTotalFactura
	 * @param valorTotalTarifaCeroFactura
	 * @param codigoUsuario
	 * @param sumar
	 * @throws SICException
	 */
	public void actualizarValoresFacturaEstado(Long codigoFactura, BigDecimal valorTotalFactura, BigDecimal valorTotalTarifaCeroFactura, String codigoUsuario, Boolean sumar)throws SICException;

	/**
	 * Metodo para actualizar la factura estado
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param userId
	 * @param inactivarFacturaEstado
	 */
	void actualizarFacturaEstado(Integer codigoCompania, Long codigoFacturaEsatado, String userId, Boolean inactivarFacturaEstado);

	/**
	 * Metodo para obtener el objeto FacturaEstadoDTO en base a un comprobanteVO .
	 * @param codigoFactura
	 * @param comprobanteVO
	 * @param crearFacturaEstado
	 * @param tareaProgramada
	 * @return
	 * @throws SICException
	 */
	FacturaEstadoDTO obtenerFacturaEstadoDTO(Long codigoFactura, ComprobanteVO comprobanteVO, Boolean crearFacturaEstado, Boolean tareaProgramada) throws SICException;

	/**
	 * Metodo que me devuelve una factura estado de acuerdo al tipo de impuesto recibido seteado la relacion con el tipo de impuesto
	 * @param codigoFacturaEstado
	 * @param codigoCompania
	 * @param codigoTipoImpuesto
	 * @param valorSujetoImpuesto
	 * @param totalImpuesto
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	FacturaEstadoImpuestoDTO obtenerFacturaEstadoImpuestoPorTipoImpuesto(Long codigoFacturaEstado, Integer codigoCompania, Integer codigoTipoImpuesto, BigDecimal valorSujetoImpuesto, BigDecimal totalImpuesto, String userId) throws SICException;

	/**
	 * Metodo para obtener la facturaEstado en base a una factura electronica
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param factura
	 * @param idUser
	 * @param catalogoTipoCambio
	 * @return
	 * @throws SICException
	 */
	FacturaEstadoDTO obtenerFacturaEstadoDTO(Integer codigoCompania, Long codigoFactura, Object factura, String idUser, String catalogoTipoCambio) throws SICException;

	/**
	 * Metodo para actualizar el campo AjusteAutomatico en factura estado 
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param userId
	 * @param ajusteAutomatico
	 * @param valorDiferenciaRangoTolerancia
	 * @throws SICException
	 */
	void actualizarAjusteAutomaticoFacturaEstado(Integer codigoCompania, Long codigoFacturaEstado, String userId, Boolean ajusteAutomatico, BigDecimal valorDiferenciaRangoTolerancia) throws SICException ;

	/**
	 * Metodo para obtener el flujoEstadoFactura por codigo de factura
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	FlujoEstadoFacturaDTO obtenerFlujoEstadoFactura(Long codigoFactura) throws SICException;
	/**
	 * Este metodo obtiene una facturaEstado en base a los parametros que recibe como parametro
	 * @param codigoCompania
	 * @param fechaNotaIngreso
	 * @param numeroNotaIngreso
	 * @return
	 * @throws SICException
	 */
	public FacturaEstadoDTO obtenerFacturaEstado(Integer codigoCompania, Date fechaNotaIngreso, String numeroNotaIngreso) throws SICException;

	/**
	 * Permite actualizar el valor total de las facturas del proveedor en la nota de ingreso
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param valorTotalProveedor
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarTotalProveedorConImpuestoNotaIngreso(Integer codigoCompania, Long codigoFacturaEstado, BigDecimal valorTotalProveedor, String codigoUsuario)throws SICException;

	/**
	 * Metodo para actualizar la facturaEstadoImpuesto.
	 * @param codigoCompania
	 * @param codigoFacturaEstado
	 * @param userId
	 * @param estadoFacturaEstado
	 * @throws SICException
	 */
	void actualizarFacturaEstadoImpuesto(Integer codigoCompania, Long codigoFacturaEstado, String userId, String estadoFacturaEstado) throws SICException;
	
	
	/**
	 * Permite cambiar el valor cambio informacion de las facturas del proveedor o notas de ingreso
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param valorCambioInformacion
	 * @param userId
	 * @throws SICException
	 */
	void actualizarValorCambioInformacion(Integer codigoCompania, Long codigoFactura, String valorCambioInformacion, String userId)throws SICException;
	
	/**
	 * Permite cambiar al estado revisado a todas las notas de ingreso que fueron consolidadas
	 * @param codigoCompania
	 * @param codigoFacturaNotaIngreso
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarValorCambioInformacionDeshacerNotaIngresoConsolidado(Integer codigoCompania, Long codigoFacturaNotaIngreso, String codigoUsuario)throws SICException;

	/**
	 * Permite actualizar el estado por hacer y la observacion de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param estadoPorHacer
	 * @param observacion
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void actualizarNotaIngresoPorHacer(Integer codigoCompania, Long codigoNotaIngreso, String estadoPorHacer, String observacion, String codigoUsuario)throws SICException;
	
	/**
	 * <b> Actualiza el estado de la factura; puede actualizar una o mas facturas. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param userId
	 *            identificador del usuario que realizo la transaccion
	 * @param estado
	 *            nuevo estado de la factura puede ser activo o in activo
	 * @param codigosFacturaEstado
	 *            codigos de las facturas para actualizar le estado
	 */
	void actualizarEstadoFactura(Integer codigoCompania, String userId, String estado, Long... codigosFacturaEstado);
	
	/**
	 * Permite actualizar la facturaEstado dada como parametro
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	void actualizarFacturaEstado(final FacturaEstadoDTO facturaEstadoDTO) throws SICException;
}