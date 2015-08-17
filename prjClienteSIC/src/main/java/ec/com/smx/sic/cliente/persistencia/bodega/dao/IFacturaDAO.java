package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.smx.auditoria.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.TransaccionProcesoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IFacturaDAO {

	/**
	 * Permite activar o desactivar facturas
	 * @param codigosFacturas
	 * @param estadoRegistro
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void activarDesactivarFacturas(Collection<Long> codigosFacturas, String estadoRegistro, String codigoUsuario) throws SICException;	
	
	/**
	 * Permite activar las facturas inactivar al deshacer la consolidacion
	 * @param codigoFactura
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void activarFacturasConsolidadas(Long codigoFactura, String codigoUsuario)throws SICException;
	
	/**
	 * Permite la creacion de la facturas, notas de credito y debido
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param crearFactura
	 * @param vistaFacturaRelacionadaDTO
	 * @throws SICException
	 */
	public FacturaDTO guardarFactura(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, Boolean crearFactura, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO)throws SICException;
	
	/**
	 * Permite ubicar y desmarcar la nota de ingreso que posee la marca en sitio
	 * @param codigoCompania
	 * @param codigoFacturaNotaIngreso
	 * @throws SICException
	 */
	public String desmarcarNotaIngresoEnSitio(Integer codigoCompania, Long codigoFacturaNotaIngreso)throws SICException;
	
	/**
	 * Permite ubicar y desmarcar la factura del proveedor que posee la marca en sitio
	 * @param codigoCompania
	 * @param codigoFacturaNotaIngreso
	 */
	public void desmarcarFacturaEnSitio(Integer codigoCompania, Long codigoFacturaProveedor)throws SICException;	
	
	/**
	 * Permite activar o desactivar factura
	 * @param codigoFactura
	 * @param estadoRegistro
	 * @param codigoUsuario
	 * @param facturaEnSitio
	 * @throws SICException
	 */
	public void activarDesactivarFactura(Long codigoFactura, String estadoRegistro, String codigoUsuario) throws SICException;
	
	/**
	 * Permite obtener una lista de notas de ingreso para enviar al JDE
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoContabilizarCuentasPorPagar(Integer codigoCompania)throws SICException;
	
	/**
	 * Permite marcar como contabilizado la nota de ingreso
	 * @param codigoFactura
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void marcarContabilizado(Long codigoFactura, String codigoUsuario) throws SICException;
	
	/**
	 * Permite obtener la factura con sus respectivos detalles de la orden de compra estado
	 * @param recibidoNoFacturadoDTO
	 */
	public Collection<FacturaDTO> obtenerValoresOrdenCompra(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;

	/**
	 * Metodo para crear o actualizar una factura con datos financieros.
	 * @param recibidoNoFacturado
	 * @param factura
	 * @throws SICException
	 */
	public void guardarFacturaDatoFinanciero(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, Long codigoFactura, String userId) throws SICException;

	/**
	 * Metodo para obtener todos las transacciones con el codigo de proceso recibido.
	 * @param codigoCompania
	 * @param codigosTipoTransaccion
	 * @param codigosProceso
	 * @return
	 * @throws SICException
	 */
	Collection<TransaccionProcesoDTO> obtenerProcesosTransaccionNotasIngreso(Integer codigoCompania, Set<Integer> codigosTipoTransaccion, Set<Long> codigosProceso) throws SICException;

	/**
	 * Metodo que valida si la factura ya se encuentra registrada en la BD.
	 * @param codigoCompania
	 * @param numeroFactura
	 * @param fechaFactura
	 * @param rucProveedor
	 * @param valorTipoDocumentoFactura
	 * @return
	 * @throws SICException
	 */
	Boolean existeFacturaActual(Integer codigoCompania, String numeroFactura, Date fechaFactura, String rucProveedor, String valorTipoDocumentoFactura) throws SICException;

	/**
	 * Metodo para obtener el primer codigo de las recepciones por el codigo de factura recibido.
	 * @param codigoCompania
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	Long obtenerCodigoRecepcionPorCodigoFactura(Integer codigoCompania, Long codigoFactura) throws SICException;
	/**
	 * Este metodo devuelve verdadero si la factura que recibe como parametro tiene un registro en la tabla Validacion documento para la validacion que recibe como parametro
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	public ValidacionDocumentoDTO obtenerValidacionDocumento(FacturaDTO factura, CatalogoValorDTO tipoValidacion)throws SICException;
	/**
	 * Este metodo obtiene una lista de todas las facturas del proveedor de las notas de ingreso que resultan de los filtros que recibe como parametro.
	 * @param filtrosBusqueda
	 * @param vistaRecibidoNoFacturadoPlantilla
	 * @param equalMode
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFacturaDTO> obtenerFacturasProveedor(Criterion filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Boolean equalMode)throws SICException;

	/**
	 * Metodo para obtener la autorizacion vigente del proveedor.
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @param numeroAutorizacion
	 * @return
	 * @throws SICException
	 */
	public AutorizacionDTO obtenerAutorizacionPorProveedor(String codigoProveedor, Integer codigoCompania, String numeroAutorizacion) throws SICException;

	/**
	 * Metodo para crear una autorizacion
	 * TODO Borrar una vez que ya se tenga el metodo para crear igual que en el B2B
	 * @param autorizacion
	 * @throws SICException
	 */
	AutorizacionDTO crearAutorizacion(AutorizacionDTO autorizacion) throws SICException;
	
	/**
	 * Metodo que nos ayuda a actualizar el numero de autorizacion y fecha caducidad de las facturas de proveedor que no se encuentran revisadas de una nota de ingreso recibida
	 * @param codigoCompania
	 * @param codigoFacturaNotaIngreso
	 * @param numeroAutorizacion
	 * @param fechaCaducidad
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Boolean actualizarAutorizacionFacturasPendientesPorRevisar(Integer codigoCompania, String codigoProveedor, String numeroAutorizacion, Date fechaCaducidad, String userId) throws SICException;

	/**
	 * Permite obtener el numero de veces que la nota de ingreso paso por el estado aprobado forzado
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	Long obtenerNumeroEstadoAprobadoForzado(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite cambiar el plazo de pago de los documentos relacionados
	 * @param codigoFactura
	 * @param valorTipoPlazoPago
	 * @param codigoUsuario
	 */
	void cambiarPlazoPagoDocumentosRelacionados(Long codigoFactura, String valorTipoPlazoPago, String codigoUsuario)throws SICException;
	
	/**
	 * Permite cambiar el plazo de pago de la nota de ingreso
	 * @param codigoFactura
	 * @param valorTipoPlazoPago
	 * @param codigoUsuario
	 */
	void cambiarPlazoPagoDocumento(Long codigoNotaIngreso, String valorTipoPlazoPago, String codigoUsuario)throws SICException;
	
	/**
	 * Este metodo obtiene una lista de todas las notas de ingreso que resultan de los filtros que recibe como parametro.
	 * @param filtrosBusqueda
	 * @param vistaRecibidoNoFacturadoPlantilla
	 * @param equalMode
	 * @return
	 * @throws SICException
	 */
	Collection<VistaFacturaDTO> obtenerRegistrosNotasIngresoSubBodega(Criterion filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Boolean equalMode)throws SICException;
}