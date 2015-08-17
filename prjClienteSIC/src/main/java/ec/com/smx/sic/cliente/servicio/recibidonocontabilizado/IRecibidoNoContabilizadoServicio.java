package ec.com.smx.sic.cliente.servicio.recibidonocontabilizado;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ec.com.kruger.cliente.sri.consumo.ws.RespuestaWsSRI;
import ec.com.smx.auditoria.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.TransaccionProcesoDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.interfaz.jde.mdl.vo.InterfazBase;
import ec.com.smx.sic.cliente.common.recibidonocontabilizado.EnumTipoDocumentoResumen;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArchivoDocumentoXmlDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDepartamentoPorAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFlujoEstadoFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoElectronicoSRI;
import ec.com.smx.sic.cliente.mdl.nopersistente.InterfacesEstructurasJDE;
import ec.com.smx.sic.cliente.mdl.nopersistente.TotalesFacturasNotaIngresoEST;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IRecibidoNoContabilizadoServicio {
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
	 * Este m�todo devuelve una colecci�n de los departamentos del �rea de trabajo que recibe como parametro, el �rea de trabajo que recibe como parametro corresponde a una
	 * subBodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */	
	public List<VistaDepartamentoPorAreaTrabajoDTO> obtenerDepartamentosPorAreaTrabajo(Integer codigoCompania, Integer codigoAreaTrabajo)throws SICException;
	/**
	 * Este metodo guarda un ajusteFacturaEstado con sus respectivos detalles
	 * @param ajusteFacturaEstadoDTO
	 * @throws SICException
	 */
	public Boolean transGuardarAjusteFacturaEstado(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, Collection<AjusteFacturaEstadoDTO> ajustesFacturaEstadoDTO, String usuarioId) throws SICException;
	
	public AjusteFacturaEstadoDTO obtenerAjusteFacturaEstado(AjusteFacturaEstadoDTO ajusteFacturaEstadoPlantilla, Long codigoFacturaEstado) throws SICException;
	
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
	 * Permite consolidar y registrar facturas relacionadas
	 * @param vistaRecibidoNoFacturadoCol
	 * @param valorTipoAsignacion
	 * @param userId
	 * @throws SICException
	 */
	public void transConsolidarFacturas(Collection<VistaRecibidoNoFacturadoDTO> vistaRecibidoNoFacturadoCol,String valorTipoAsignacion, String userId)throws SICException;
	
	/**
	 * Permite obtener las facturas relacionadas con la informacion de la cabecera
	 * @param codigoFactura
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerFacturasRelacionadas(Long codigoFactura)throws SICException;
	
	/**
	 * Permite deshacer las facturas relacionadas a travez de la factura padre
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param userId
	 * @param estadoFacturasRevisadas
	 * @throws SICException
	 */
	public void transDeshacerConsolidado(Integer codigoCompania, Long codigoFactura, String userId, String estadoFacturasRevisadas)throws SICException;
	
	/**
	 * Permite cambiar los estados de las facturas seleccionadas
	 * @param recibidoNoFacturadoCol
	 * @param valorAccionFactura
	 * @param userId
	 */
	public void transCambiarEstadoFacturas(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String valorAccionFactura, String userId)throws SICException;
	
	/**
	 * Permite la creacion de la factura relacionando a la nota de ingreso
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param crearFactura
	 * @param tareaProgramada
	 * @throws SICException
	 */
	public FacturaDTO transGuardarFactura(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, Boolean crearFactura, DocumentoElectronicoSRI factura, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Permite la creacion de la factura relacionado a la factura del proveedor
	 * @param comprobanteVO
	 * @param vistaFacturaRelacionadaDTO
	 * @param crearFactura
	 * @param tareaProgramada
	 * @throws SICException
	 */
	public FacturaDTO transGuardarFactura(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, Boolean crearFactura, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Metodo para crear una factura y realizar el ajuste automatico si es necesario.
	 * @param comprobanteVO
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaDTO
	 * @param crearFactura
	 * @param factura
	 * @param tareaProgramada
	 * @return
	 * @throws SICException
	 */
	Boolean transGuardarFacturaAjuste(ComprobanteVO comprobanteVO, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, Boolean crearFactura, DocumentoElectronicoSRI factura, Boolean tareaProgramada)throws SICException;
	
	/**
	 * Este metodo permite enviar a contabilizar las notas de ingreso a demanda del usuario
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @throws SICException
	 */
	public void transContabilizarNotasIngreso(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion)throws SICException;
	/**
	 * Este metodo permite enviar a generar las cuentas por pagar a demanda del usuario
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @return
	 * @throws SICException
	 */
	public Map<String, List<String>>  transGenerarCuentasPorPagarNotasIngreso(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion)throws SICException;
	
	/**
	 * Permite inactivar la factura relacionada, factura estado y factura
	 * @param vistaRecibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public Boolean transInactivarFactura(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, VistaFacturaRelacionadaDTO vistaFacturaRelacionadaDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Pemite activar las notas de ingreso que han sido rechazadas, ubicando el estado automaticamente si son notas de ingreso cuadradas o sin cuadrar
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @throws SICException
	 */
	public Map<String, List<String>> activarNotasIngresoRechazadasNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId) throws SICException;
	
	/**
	 * Pemite activar la nota de ingreso que han sido rechazadas, ubicando el estado automaticamente si son notas de ingreso cuadradas o sin cuadrar
	 * @param recibidoNoFacturado
	 * @param userId
	 * @throws SICException
	 */
	public void transActivarNotasIngresoRechazada(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String userId) throws SICException;
	
	
	/**
	 * Permite obtener una lista de notas de ingreso para enviar al JDE
	 * @param codigoCompania
	 * @param facturaDTO
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoContabilizarCuentasPorPagar(Integer codigoCompania)throws SICException;
	
	/**
	 * Permite enviar la información a las interfaz JDE para la contabilidad y cuentas por pagar
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @throws SICException
	 */
	public Duplex<Collection<InterfazBase>, InterfacesEstructurasJDE> transGenerarProcesarInterfazJDE(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId)throws SICException;

	/**
	 * Permite obtener el departamento de mayor valor de una factura
	 * @param recibidoNoFacturadoDTO
	 * @return
	 * @throws SICException
	 */
	public VistaRecibidoNoFacturadoDTO obtenerDepartamentoMayorValorFactura(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;

	/**
	 * Metodo para consultar la autorizacion en el Web service del SRI mediante la clave de acceso
	 * @param claveAcceso
	 * @param respuestaWsSRI
	 * @throws SICException
	 */
	public DocumentoElectronicoSRI obtenerWSAutorizacionFacturaSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI) throws SICException;

	/**
	 * Metodo para enviar a contabilizar las notas de ingreso.
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @return
	 * @throws SICException
	 */
	Map<String, List<String>> contabilizarNotasIngresoValidado(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String userId, String valorAccion) throws SICException;

	/**
	 * Permite cambiar el estado a enviadas y contalizar en el JDE
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @param valorAccion
	 *  
	 */
	void contabilizarNotasIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId, String valorAccion)throws SICException;

	/**
	 * Metodo para procesar las interfaces ya generadas despues de guardar las facturas.
	 * @param colInterfazF09
	 * @param interfaceEstructuraJDE
	 * @param tareaProgramada -> TRUE
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	String procesoCierreDocumentos(Collection<InterfazBase> colInterfazF09, InterfacesEstructurasJDE interfaceEstructuraJDE, Boolean tareaProgramada, Integer codigoCompania) throws SICException;
			
	/**
	 * Permite cambiar el estado a remuneradas y enviar las cuentas por pagar a la interfaz del JDE
	 * @param recibidoNoFacturadoCol
	 * @param userId
	 * @param valorAccion
	 * @param recibidoNoFacturadoDTO
	 * @param interfazBaseF0911Col
	 * @param interfazF0411Col
	 */
	void generarCuentasPorPagarNotasIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId, String valorAccion)throws SICException;

	/**
	 * Metodo para generar la interfaz base JDE
	 * @param recibidoNoFacturadoDTO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Collection<InterfazBase> generarInterfazBase(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String userId) throws SICException ;
	
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
	Boolean obtenerFacturaExistenteActual(Integer codigoCompania, String numeroFactura, Date fechaFactura, String rucProveedor, String valorTipoDocumentoFactura) throws SICException;
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
	 * Este metodo crea o actualiza un registro en la tabla ValidacionDocumento, esto quiere decir que si el estado del registro es activo
	 * quiere decir que el numero de documento esta validado si el estado es negativo quiere decir que el numero documento no ha sido validado
	 * @param validacionDocumentoDTO
	 * @throws SICException
	 */
	public void transGuardarValidacionNumeroDocumento(ValidacionDocumentoDTO validacionDocumentoDTO) throws SICException;
	
	/**
	 * Metodo no transaccional para aplicar el ajuste automatico a los registros que poseen la marca aplicarRangoTolerancia
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> aplicarAjusteAutomaticoNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite para aplicar el ajuste automatico
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transAplicarAjusteAutomatico(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
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
	 * Metodo no transaccional para aprobar las notas de ingreso
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> aprobarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para aprobar las notas de ingreso forzadas
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> aprobarForzadoNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite aprobar la nota de ingreso
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transAprobar(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo que permite aprobar la nota de ingreso forzadas
	 * @param recibidoNoFacturadoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transAprobarForzado(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Este metodo devuelve una coleccion de ajustes de la facturaEstado que recibe como parametro en el AjusteFacturaDTO
	 * @param ajusteFacturaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AjusteFacturaEstadoDTO> obtenerAjusteFacturaEstadoCol(AjusteFacturaDTO ajusteFacturaDTO) throws SICException;

	/**
	 * MNetodo para validar si exisitieron cambios y deolver las estrucutras auditables y si exisiteron cambios en los datos 
	 * generales o valores del documento recibido
	 * @param codigoCompania
	 * @param systemId
	 * @param accesItemId
	 * @param comprobanteVOInicial
	 * @param comprobanteVOFinal
	 * @return
	 * @throws SICException
	 */
	Map<String, Object> obtenerValidarComprobanteAuditable(Integer codigoCompania, String systemId, String accesItemId, ComprobanteVO comprobanteVOInicial, ComprobanteVO comprobanteVOFinal) throws SICException;

	/**
	 * Permite registrar en la tabla validacionDocumento el estado rechazado de una factura electrónica
	 * @param facturaElectronica
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param codigoUsuario
	 */
	public String transRegistrarValidacionFacturaElectronica(DocumentoElectronicoSRI facturaElectronica, Integer codigoCompania, Long codigoFactura, String codigoUsuario)throws SICException;
	
	/**
	 * Permite registrar en la tabla validacionDocumento el estado rechazado de una factura electrónica
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param codigoUsuario
	 * @param estadoFacturaElectronica
	 */
	public void transRegistrarValidacionFacturaElectronica(Integer codigoCompania, Long codigoFactura, String codigoUsuario, String estadoFacturaElectronica)throws SICException;
	
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
	 * Metodo para obtener el id de contenido para registrar el log de la auditoria de las facturas.
	 * @param codigoFacturaPadre
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	String obtenerIdLogAuditoriaFactura(Long codigoFacturaPadre, Long codigoFactura) throws SICException;
	
	/**
	 * Metodo no transaccional para cambiar el estado a revisado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> revisarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo para cambiar el estado a revisado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transRevisar(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo no transaccional para cambiar el estado a rechazado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	Map<String, List<String>> rechazarNoTransaccional(Collection<VistaRecibidoNoFacturadoDTO> recibidoNoFacturadoCol, String codigoUsuario)throws SICException;
	
	/**
	 * Metodo para cambiar el estado a rechazado
	 * @param recibidoNoFacturadoCol
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transRechazar(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
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
	 * Permite cambiar el estado de las factura seleccionada
	 * @param recibidoNoFacturadoDTO
	 * @param valorAccionFactura
	 * @param userId
	 */
	public void transCambiarEstadoFactura(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO, String valorAccionFactura, String userId)throws SICException;
	
	/**
	 * Metodo para crear o actualizar una factura con datos financieros.
	 * @param recibidoNoFacturado
	 * @param factura
	 * @throws SICException
	 */
	public void transGuardarFacturaDatoFinanciero(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, Long codigoFactura, String userId) throws SICException;
	
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
	void transPorHacer(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite cambiar el plazo de pago de la nota de ingreso y sus documentos relacionados
	 * @param recibidoNoFacturadoDTO
	 * @param valorTipoPlazoPago
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transCambioPlazoPagoNotaIngreso(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, String valorTipoPlazoPago, String codigoUsuario)throws SICException;
	
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
	 * Obtiene todos los documentosXml de la factura dada
	 * @param numeroFactura
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArchivoDocumentoXmlDTO> obtenerDocumentoXml(final Long codigoFactura, final Integer codigoCompania) throws SICException;
	
	/**
	 * Permite obtener los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	Collection<TotalesFacturasNotaIngresoEST> obtenerTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transRegistrarTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoNotaIngreso
	 * @throws SICException
	 */
	void transEliminarTotalesFacturasNotasIngreso(Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void transEliminarCrearTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
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
	void transRegresarAprobado(VistaRecibidoNoFacturadoDTO recibidoNoFacturado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las notas de credito y debito del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @param enumTipoDocumentoResumen
	 * @throws SICException
	 */
	void transEliminarCrearTotalesNotasCreditoDebitoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, String codigoUsuario, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
}
