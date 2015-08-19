package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ec.com.smx.auditoria.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.TransaccionProcesoDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditStructure;
import ec.com.smx.frameworkv2.auditoria.excepcion.AuditException;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PeriodoTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoAccionPeriodoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDepartamentoPorAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFlujoEstadoFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.TotalesFacturasNotaIngresoEST;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface ICalculoRecibidoNoContabilizadoGestor {
	/**
	 * Este metodo devuelve una coleccion de las facturas internas, si viene verdadero en el parametro consulta las facturas relacionadas de la primera factura interna y si posee valor codigoFacturaNI consulta las facturas del proveedor de este registro
	 * @param filtrosBusqueda
	 * @param vistaRecibidoNoFacturadoPlantilla
	 * @param codigoFacturaNI
	 * @param equalMode
	 * @return
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerFacturasInternasPendientes(Collection<ISearchTemplate> filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Long codigoFacturaNI, Boolean equalMode)throws SICException;
	/**
	 * Este metodo devuelve una coleccion de las facturas hijas o relacionadas a la factura interna que recibe como parametro
	 * @param vistaRecibidoNoFacturadoDTO
	 * @return
	 * @throws SICException
	 */
	public List<VistaFacturaRelacionadaDTO> obtenerFacturasRelacionadas(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO) throws SICException;
	/**
	 * Permite obtener la lista de catalogos partiendo como parametro el tipo de catalogo
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> obtenerCatalogoValor(Integer codigoCatalogoTipo)throws SICException;
	
	/**
	 * Permite obtener la lista de los de los estados unificados y sus relacionados
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Duplex<Collection<CatalogoValorDTO>, Collection<CatalogoValorRelacionadoDTO>> obtenerEstadosNotaIngreso(Integer codigoCatalogoTipo)throws SICException;
	/**
	 * Este m�todo devuelve una colecci�n de los departamentos del �rea de trabajo que recibe como parametro, el �rea de trabajo que recibe como parametro corresponde a una
	 * subBodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public List<VistaDepartamentoPorAreaTrabajoDTO> obtenerDepartamentosPorAreaTrabajo(Integer codigoCompania, Integer codigoAreaTrabajo)throws SICException;
	/**
	 * Este metodo devuelve un ajusteFacturaEstado en base a la plantilla que recibe como parametro
	 * @param ajusteFacturaEstadoPlantilla
	 * @param codigoFacturaEstado
	 * @return
	 * @throws SICException
	 */
	public AjusteFacturaEstadoDTO obtenerAjusteFacturaEstado(AjusteFacturaEstadoDTO ajusteFacturaEstadoPlantilla, Long codigoFacturaEstado) throws SICException;
	
	/**
	 * Permite obtener las facturas relacionadas con la informacion de la cabecera
	 * @param codigoFactura
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerFacturasRelacionadas(Long codigoFactura)throws SICException;
	
	/**
	 * Permite obtener los valores de la factura rechazada
	 * @param codigoFactura
	 * @return
	 */
	public VistaRecibidoNoFacturadoDTO obtenerValoresFacturaRechazada(Long codigoFactura)throws SICException;
	
	/**
	 * Permite obtener una lista de notas de ingreso para enviar al JDE
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoContabilizarCuentasPorPagar(Integer codigoCompania)throws SICException;
	
	/**
	 * Permite obtener el departamento de mayor valor de una factura
	 * @param recibidoNoFacturadoDTO
	 * @return
	 * @throws SICException
	 */
	public VistaRecibidoNoFacturadoDTO obtenerDepartamentoMayorValorFactura(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;
	
	/**
	 * Permite obtener los ajustes en mas y menos de la factura
	 * @param codigoFacturaEstado
	 */
	public VistaRecibidoNoFacturadoDTO obtenerTotalAjustes(Long codigoFacturaEstado)throws SICException;

	/**
	 * Metodo para obtener las transacciones de un proceso recibido.
	 * @param codigoCompania
	 * @param codigosTipoTransaccion
	 * @param codigosProceso
	 * @return
	 * @throws SICException
	 */
	Collection<TransaccionProcesoDTO> obtenerProcesosTransaccionNotasIngreso(Integer codigoCompania , Set<Integer> codigosTipoTransaccion, Set<Long> codigosProceso) throws SICException ;


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
	 * Permite obtener las suma de la tarifa cero y doce de las facturas del proveedor de la nota de ingreso
	 * @param codigoFacturaNotaIngreso
	 * @return
	 */
	public VistaRecibidoNoFacturadoDTO obtenerValoresTarifasProveedor(Long codigoFacturaNotaIngreso)throws SICException;
	/**
	 * Este metodo obtiene todos los estados por los que paso la nota de ingreso, los estados estan ordenados cronologicamente
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	public List<VistaFlujoEstadoFacturaDTO> obtenerFlujoEstadosFactura(Long codigoNotaIngreso)throws SICException;
	
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
	public Collection<VistaFacturaDTO> obtenerFacturasProveedor(Collection<ISearchTemplate> filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Boolean equalMode)throws SICException;
	/**
	 * Este metodo devuelve una coleccion de las notas de ingreso hijas o relacionadas a la factura interna que recibe como parametro
	 * @param codigoFacturaNI
	 * @return
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoConsolidadas(Long codigoFacturaNI) throws SICException;
	/**
	 * Este metodo devuelve una coleccion de ajustes de la facturaEstado que recibe como parametro en el AjusteFacturaDTO
	 * @param ajusteFacturaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AjusteFacturaEstadoDTO> obtenerAjusteFacturaEstadoCol(AjusteFacturaDTO ajusteFacturaDTO) throws SICException;
	
	/**
	 * Metodo para obtener las estrcturas auditables para la validacion de la auditoria
	 * @param codigoCompania
	 * @param systemId
	 * @param accesItemId
	 * @param estructuraAuditable
	 * @param comprovante
	 * @return
	 * @throws SICException
	 * @throws AuditException
	 */
	AuditStructure obtenerObjetoAuditable(Integer codigoCompania, String systemId, String accesItemId, String estructuraAuditable, ComprobanteVO comprovante ) throws SICException, AuditException;
	
	/**
	 * Metodo que nos ayuda a validar si existieron cambios y registrar la auditoria
	 * @param codigoCompania
	 * @param idContenido
	 * @param codigoTipoLog
	 * @param idAtributosAuditables
	 * @param objetoActual
	 * @param objetoAnterior
	 * @param idUsuario
	 * @param guardarAuditoria
	 * @return
	 * @throws SICException
	 * @throws AuditException
	 */
	Boolean registrarLogAuditoria(Integer codigoCompania, String idContenido, Integer codigoTipoLog, String idAtributosAuditables, AuditStructure objetoActual, AuditStructure objetoAnterior, String idUsuario, boolean guardarAuditoria) throws SICException, AuditException;
	
	/**
	 * Metodo para obtener el id de contenido para registrar el log de la auditoria de las facturas.
	 * @param codigoFacturaPadre
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	String obtenerIdLogAuditoriaFactura(Long codigoFacturaPadre, Long codigoFactura) throws SICException;
	
	/**
	 * Permite obtener las validaciones del documento de un tipo de resultado especifico
	 * @param codigoFactura
	 * @param valoresTipoValidacion
	 * @param valorTipoResultado
	 * @return
	 * @throws SICException
	 */
	public Collection<ValidacionDocumentoDTO> obtenerValidacionDocumento(Long codigoFactura, List<String> valoresTipoValidacion, String valorTipoResultado)throws SICException;
	
	/**
	 * Permite obtener las facturas del proveedor que se encuentran repetidas
	 * @param codigosNotasIngreso
	 * @return
	 * @throws SICException
	 */
	Collection<VistaRecibidoNoFacturadoDTO> obtenerFacturasRepetidas(List<Long> codigosNotasIngreso)throws SICException;


	/**
	 * Metodo para obtener todas las notas de ingreso que posean facturas electronicas autorizadas
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoConFacturasElectronicas() throws SICException;

	/**
	 * Metodo para obtener el comprobante incial guardado en la BDD
	 * @param codigoCompania
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	ComprobanteVO obtenerComprobanteVOPorCodigoFactura(Integer codigoCompania, Long codigoFactura) throws SICException;

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
	 * Permite obtener el numero de facturas validas de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	 Long obtenerNumeroFacturasProveedor(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite obtener el numero de veces que la nota de ingreso paso por el estado aprobado forzado
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	 Long obtenerNumeroEstadoAprobadoForzado(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	 
	 /**
	 * Este metodo obtiene una lista de todas las notas de ingreso que resultan de los filtros que recibe como parametro.
	 * @param filtrosBusqueda
	 * @param vistaRecibidoNoFacturadoPlantilla
	 * @param equalMode
	 * @return
	 * @throws SICException
	 */
	Collection<VistaFacturaDTO> obtenerRegistrosNotasIngresoSubBodega(Collection<ISearchTemplate> filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Boolean equalMode)throws SICException;
	
	/**
	 * Permite obtener los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	Collection<TotalesFacturasNotaIngresoEST> obtenerTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite obetener el rango de accion del periodo actual
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	RangoAccionPeriodoDTO obtenerRangoAccionPeriodoActual(Integer codigoCompania)throws SICException;
	
	/**
	 * Permite obtener el periodo actual de trabajo
	 * @param codigoCompania
	 * @param obtenerRangoAccion
	 * @return
	 * @throws SICException
	 */
	PeriodoTrabajoDTO obtenerPeriodoTrabajoActual(Integer codigoCompania, Boolean obtenerRangoAccion)throws SICException;
}
