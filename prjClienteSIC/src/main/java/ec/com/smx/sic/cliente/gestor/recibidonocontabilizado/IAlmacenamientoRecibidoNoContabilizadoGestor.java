package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.interfaz.jde.mdl.vo.InterfazBase;
import ec.com.smx.sic.cliente.common.recibidonocontabilizado.EnumTipoDocumentoResumen;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArchivoDocumentoXmlDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoElectronicoSRI;
import ec.com.smx.sic.cliente.mdl.nopersistente.InterfacesEstructurasJDE;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IAlmacenamientoRecibidoNoContabilizadoGestor {

	/**
	 * Permite consolidar y registrar facturas relacionadas
	 * @param vistaRecibidoNoFacturadoCol
	 * @param valorTipoAsignacion
	 * @param userId
	 * @throws SICException
	 */
	public void consolidarFacturas(Collection<VistaRecibidoNoFacturadoDTO> vistaRecibidoNoFacturadoCol,String valorTipoAsignacion, String userId)throws SICException;
	/**
	 * Este metodo guarda una coleccion de ajusteFacturaEstado con sus respectivos detalles
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param ajusteFacturaEstadoDTO
	 * @throws SICException
	 */
	public Boolean guardarAjusteFacturaEstado(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, Collection<AjusteFacturaEstadoDTO> ajustesFacturaEstadoDTO, String codigoUsuario) throws SICException;
	
	/**
	 * Permite deshacer las facturas relacionadas a travez de la factura padre
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param userId
	 * @param estadoFacturasRevisadas
	 * @throws SICException
	 */
	public void deshacerConsolidado(Integer codigoCompania, Long codigoFactura, String userId, String estadoFacturasRevisadas)throws SICException;
	/**
	 * Este metodo cambia el estado de la factura
	 * @param facturaDTO
	 * @param accionFactura
	 * @param valorTipoCuadre
	 * @throws SICException
	 */
	public void cambiarEstadoFactura(FacturaDTO facturaDTO, CatalogoValorDTO accionFactura, String valorTipoCuadre) throws SICException;
	
	/**
	 * Permite cambiar los estados de las facturas seleccionadas
	 * @param recibidoNoFacturadoCol
	 * @param valorAccionFactura
	 * @param userId
	 */
	public void cambiarEstadoFacturas(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String valorAccionFactura, String userId)throws SICException;
	
	/**
	 * Permite la creacion de la factura relacionando a la nota de ingreso
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param crearFactura
	 * @param factura
	 * @param tareaProgramada
	 * @throws SICException
	 */
	public FacturaDTO guardarFactura(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, Boolean crearFactura, DocumentoElectronicoSRI factura, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Permite registrar en la tabla validacionDocumento el estado rechazado de una factura electrónica
	 * @param facturaElectronica
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param codigoUsuario
	 */
	public String registrarValidacionFacturaElectronica(DocumentoElectronicoSRI facturaElectronica, Integer codigoCompania, Long codigoFactura, String codigoUsuario)throws SICException;
	
	/**
	 * Permite registrar en la tabla validacionDocumento el estado rechazado de una factura electrónica
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param codigoUsuario
	 * @param estadoFacturaElectronica
	 */
	public void registrarValidacionFacturaElectronica(Integer codigoCompania, Long codigoFactura, String codigoUsuario, String estadoFacturaElectronica)throws SICException;
	
	/**
	 * Permite la creacion de la factura relacionado a la factura del proveedor
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaDTO
	 * @param crearFactura
	 * @param tareaProgramada
	 * @return
	 * @throws SICException
	 */
	public FacturaDTO guardarFactura(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, Boolean crearFactura, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Este metodo registra el estado de la nota de ingreso en la tabla de flujo de estados los parametros requeridos en el objeto que recibe como parametro son: codigocompania, codigoFacturaEstado
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param notaIngresoDTO
	 */
	public Boolean actualizarFlujoEstadoNotaIngreso(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, String codigoUsuario) throws SICException;
	/**
	 * Este metodo realiza el cambio de estado de las notas de ingreso ademas de enviar a contabilizar las notas de ingreso en el JDE
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param enviarInterfazJDE
	 * @param valorAccion
	 * @throws SICException
	 */
	public void contabilizarNotasIngreso(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion)throws SICException;
	
	/**
	 * Permite cambiar el estado a enviadas y contalizar en el JDE
	 * devolviendo los codigos de facturas que se procesaron y no se procesaron
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @return
	 * @throws SICException
	 */
	public Map<String, List<String>> contabilizarNotasIngresoValidado(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion)throws SICException;
	
	
	/**
	 * Este metodo realiza el cambio de estado de las notas de ingreso ademas de enviar a contabilizar las notas de ingreso en el JDE
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @param valorAccion
	 * @param enviarInterfazJDE
	 * @throws SICException
	 */
	public void contabilizarNotasIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId, String valorAccion)throws SICException;
	
	/**
	 * Este metodo realiza el cambio de estado de las notas de ingreso ademas de enviar a generar las notas de ingreso en el JDE
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @return
	 * @throws SICException
	 */
	public Map<String, List<String>> generarCuentasPorPagarNotasIngreso(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion)throws SICException;
	
	/**
	 * Este metodo realiza el cambio de estado de las notas de ingreso ademas de enviar a generar las notas de ingreso en el JDE
	 * @param userId
	 * @param valorAccion
	 * @param recibidoNoFacturadoDTO
	 * @param interfazBaseF0911Col
	 * @param interfazF0411Col
	 * @throws SICException
	 */
	public void generarCuentasPorPagarNotasIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId, String valorAccion)throws SICException;
	
	/**
	 * Permite inactivar la factura relacionada, factura estado y factura
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Boolean inactivarFactura(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, String codigoUsuario)throws SICException;
	
	
	/**
	 * Pemite activar las notas de ingreso que han sido rechazadas, ubicando el estado automaticamente si son notas de ingreso cuadradas o sin cuadrar
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @throws SICException
	 */
	public  Map<String, List<String>> activarNotasIngresoRechazadasNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId) throws SICException;
	
	
	/**
	 * Pemite activar la nota de ingreso que han sido rechazadas, ubicando el estado automaticamente si son notas de ingreso cuadradas o sin cuadrar
	 * @param recibidoNoFacturado
	 * @param userId
	 * @throws SICException
	 */
	public void activarNotasIngresoRechazada(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String userId) throws SICException;
	
	/**
	 * Permite contabilizar y generar las cuentas por cobrar mediante la tarea programada
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void contabilizarGenerarCuentasPorPagar(Integer codigoCompania, String userId)throws SICException;
	
	/**
	 * Permite enviar la información a las interfaz JDE para la contabilidad y cuentas por pagar
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @throws SICException
	 */
	public Duplex<Collection<InterfazBase>, InterfacesEstructurasJDE> generarProcesarInterfazJDE(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId)throws SICException;
	
	/**
	 * Permite registrar el flujo de estado de la nota de ingreso
	 * @param notaIngresoDTO
	 * @param valorTarifaCero
	 * @param valorTarifaDoce
	 * @param valorIve
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void actualizarFlujoEstadoNotaIngreso(FacturaEstadoDTO notaIngresoDTO, BigDecimal valorTarifaCero, BigDecimal valorTarifaDoce, BigDecimal valorIve, String codigoUsuario)throws SICException;

	/**
	 * Metodo para relaizar el ajuste automatico despues de guardar una factura.
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaDTO
	 * @param crearFactura
	 * @param factura
	 * @param tareaProgramada
	 * @return
	 * @throws SICException
	 */
	Boolean guardarFacturaAjuste(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, Boolean crearFactura, DocumentoElectronicoSRI factura, Boolean tareaProgramada) throws SICException;

	/**
	 * Metodo para procesar las interfaces ya generadas despues de guardar las facturas.
	 * @param colInterfazF09
	 * @param interfacesEstructurasJDE
	 * @param tareaProgramada
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	String procesoCierreDocumentos(Collection<InterfazBase> colInterfazF09, InterfacesEstructurasJDE interfacesEstructurasJDE, Boolean tareaProgramada, Integer codigoCompania) throws SICException;

	/**
	 * Metodo para generar la interfaz base JDE
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @param esTareaProgramada
	 * @return
	 * @throws SICException
	 */
	Collection<InterfazBase> generarInterfazBase(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId, Boolean esTareaProgramada) throws SICException ;
	
	/**
	 * Permite obtener y generar el archivo de la interfaz F0411
	 * @param recibidoNoFacturadoDTO
	 */
	InterfacesEstructurasJDE generarArchivoJDEF0411(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO) throws SICException;
	
	/**
	 * Metodo para generar la contabilidad y las cuentas por pagar.
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @throws SICException
	 */
	void cambiarEstadosContabilizacionCuentasPorPagar(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId)throws SICException;
	
	/**
	 * Este metodo crea o actualiza un registro en la tabla ValidacionDocumento, esto quiere decir que si el estado del registro es activo
	 * quiere decir que el numero de documento esta validado si el estado es negativo quiere decir que el numero documento no ha sido validado
	 * @param validacionDocumentoDTO
	 * @throws SICException
	 */
	public void guardarValidacionNumeroDocumento(ValidacionDocumentoDTO validacionDocumentoDTO) throws SICException;
	
	/**
	 * Metodo no transaccional para aplicar el ajuste automatico a los registros que poseen la marca aplicarRangoTolerancia
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Map<String, List<String>> aplicarAjusteAutomaticoNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite para aplicar el ajuste automatico
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void aplicarAjusteAutomatico(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para aprobar las notas de ingreso
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Map<String, List<String>> aprobarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para aprobar las notas de ingreso forzadas
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Map<String, List<String>> aprobarForzadoNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite aprobar la nota de ingreso
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void aprobar(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite aprobar la nota de ingreso forzadas
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void aprobarForzado(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para cambiar el estado a revisado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Map<String, List<String>> revisarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo para cambiar el estado a revisado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void revisar(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para cambiar el estado a rechazado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Map<String, List<String>> rechazarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo para cambiar el estado a rechazado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void rechazar(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite cambiar el estado de las factura seleccionada
	 * @param recibidoNoFacturadoDTO
	 * @param valorAccionFactura
	 * @param userId
	 */
	public void cambiarEstadoFactura(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, String valorAccionFactura, String userId)throws SICException;
	
	/**
	 * Metodo para crear o actualizar una factura con datos financieros.
	 * @param recibidoNoFacturado
	 * @param factura
	 * @throws SICException
	 */
	public void guardarFacturaDatoFinanciero(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, Long codigoFactura, String userId) throws SICException;
	
	/**
	 * Metodo no transaccional para marcar por hacer
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> porHacerNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;	
	/**
	 * Metodo para marcar por hacer
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void porHacer(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite cambiar el plazo de pago de la nota de ingreso y sus documentos relacionados
	 * @param recibidoNoFacturadoDTO
	 * @param valorTipoPlazoPago
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void cambioPlazoPagoNotaIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String valorTipoPlazoPago, String codigoUsuario)throws SICException;
	

	/**
	 * Obtiene todos los documentosXml de la factura dada
	 * @param numeroFactura
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArchivoDocumentoXmlDTO> obtenerDocumentoXml(final Long codigoFactura, final Integer codigoCompania) throws SICException;
	
	/**
	 * Permite consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void registrarTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoNotaIngreso
	 * @throws SICException
	 */
	void eliminarTotalesFacturasNotasIngreso(Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void eliminarCrearTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para regresar de estado aprobado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> regresarAprobadoNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para regresar de estado aprobado
	 * @param recibidoNoFacturado
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void regresarAprobado(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las notas de credito y debito del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @param enumTipoDocumentoResumen
	 * @throws SICException
	 */
	void eliminarCrearTotalesNotasCreditoDebitoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, String codigoUsuario, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
}
