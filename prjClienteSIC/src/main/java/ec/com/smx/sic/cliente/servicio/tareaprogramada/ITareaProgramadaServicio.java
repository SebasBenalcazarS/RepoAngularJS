/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.tareaprogramada;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.integration.service.IntegrationServiceI;
import ec.com.smx.framework.common.anotaciones.InformacionMetodo;
import ec.com.smx.framework.common.anotaciones.InformacionParametro;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.stp.commons.util.ParametroInformacionEjecucion;

/**
 * @author fmunoz
 *
 */
public interface ITareaProgramadaServicio {
	/**
	 * Realiza la migraci&oacute;n de los datos del articulo proveedor desde un archivo generado por el SIC hacia una tabla temporal en el esquema SMXSIC y luego a la tabla
	 * definitiva
	 * @param codigoCompania
	 * @throws SICException
	 */
//	public void migrarArticuloProveedor(Integer codigoCompania) throws SICException;
	
	/**
	 * Realiza la migraci&oacute;n de los datos de las relaciones de un art&iacute;culo con otros desde un archivo generado por el SIC hacia una tabla temporal en el esquema SMXSIC 
	 * y luego a la tabla definitiva
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarArticuloRelacion(Integer codigoCompania) throws SICException;
	
	public void migrarArticuloLocalTemporal(Integer codigoCompania)throws SICException;
	
//	public void migrarArticuloLocal(Integer codigoCompania)throws SICException;
//	
//	public void migrarArticuloGeneral(Integer codigoCompania)throws SICException;
	
	public void migrarArticuloCompleto(Integer codigoCompania)throws SICException;
	
	public void procesarCargaInicial(Integer codigoCompania) throws SICException;
	
	/**
	 * Tarea para sincronizar los componentes de control de rotulado
	 * @param opcion Un Integer
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void sincronizarComponetesRotulado(Integer opcion, String clasificaciones) throws SICException;
	
	/**
	 * Tarea para registrar Datos de Proveedor Usuario Clasificacion Comprador en tablas del B2B
	 * @param codCom
	 * @throws SICException
	 */
	public void ejecutarRegistroDatosProveedorUsuarioClaCom(Integer codCom) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param rangoInicial
	 * @param rangoFinal
	 * @throws SICException
	 */
	public void migrarOrdenesCompraB2B(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="Rango inicial", requerido=true, descripcion="Rango inicial para la fecha de elaboraci&oacute;n del pedido", ejemplosValores={"2013-01-31"})String rangoInicial, 
			@InformacionParametro(nombre="Rango final", requerido=false, descripcion="Rango final para la fecha de elaboraci&oacute;n del pedido", ejemplosValores={"2013-06-30"})String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param rangoInicial
	 * @param rangoFinal
	 * @throws SICException
	 */
	public void migrarOrdenesCompraRelacionadasB2B(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="Rango inicial", requerido=true, descripcion="Rango inicial para la fecha de elaboraci&oacute;n del pedido", ejemplosValores={"2013-01-31"})String rangoInicial, 
			@InformacionParametro(nombre="Rango final", requerido=false, descripcion="Rango final para la fecha de elaboraci&oacute;n del pedido", ejemplosValores={"2013-06-30"})String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param fechaCorteS
	 * @throws SICException
	 */
	public void migrarEntregas(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="Rango inicial", requerido=false, descripcion="Rango inicial para la fecha del archivo", ejemplosValores={"2013-01-31"})String rangoInicial, 
			@InformacionParametro(nombre="Rango final", requerido=false, descripcion="Rango final para la fecha del archivo", ejemplosValores={"2013-06-30"})String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param fechaCorteS
	 * @throws SICException
	 */
	public void migrarEntregasFacturaInterna(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="Rango inicial", requerido=false, descripcion="Rango inicial para la fecha del archivo", ejemplosValores={"2013-01-31"})String rangoInicial, 
			@InformacionParametro(nombre="Rango final", requerido=false, descripcion="Rango final para la fecha del archivo", ejemplosValores={"2013-06-30"})String rangoFinal) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param fechaCorteS
	 * @throws SICException
	 */
	public void migrarEntregasOrdenCompra(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="Rango inicial", requerido=false, descripcion="Rango inicial para la fecha del archivo", ejemplosValores={"2013-01-31"})String rangoInicial, 
			@InformacionParametro(nombre="Rango final", requerido=false, descripcion="Rango final para la fecha del archivo", ejemplosValores={"2013-06-30"})String rangoFinal) throws SICException;
	
	
	/**
	 * Este metodo permite la activacion o desactivacion dependiendo de la fecha de inicio o fin de un 
	 * articulo local
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void activarDesactivarArticulosAlcance(Integer codigoCompania, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * 
	 * @param url
	 * @throws SICException
	 */
	public void migracionArticuloAreaTrabajo(String url)throws SICException;
	
	/**Permite enviar un correo con los art\u00EDculos que fallar\u00F3n en la integraci\u00F3n al SIC
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void enviarErroresIntegracionSIC(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania)throws SICException;
	
	/**
	 * Permite integrar los articulos que aun no se ha integrado con el sic
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public void obtenerArticuloLocalSIC(Integer codigoCompania, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * Permite comunicar al sic los alcance del tipo local, bodega, oficina
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public void comunicarSicPaginado(Integer codigoCompania, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * Permite comunicar al sic los alcances del tipo local que son es apertura
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void comunicarSicEsApertura(Integer codigoCompania)throws SICException;
	
	/**
	 * Cargar el archivo para la planificacion de la bodega
	 * @throws SICException
	 */
	void ejecutarCargarArchivoPlanificacionBodega (@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania) throws SICException;
	
	/**
	 * Iniciar listener max
	 * @throws SICException
	 */
	public void iniciarListener() throws SICException;
	
	
	/**
	 * Detener listener max
	 * @throws SICException
	 */
	public void detenerListener() throws SICException;
	
	/**
	* Cambio de Precios
	*/
	
	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	void ejecutarCambioPreciosArticulosLocalesPrecios(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarOrdenesCompraMAX(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void enviarEmailPedidosPendientes(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania) throws SICException;
	
	/**
	 * Permite la asignaci&oacute;n de funcionarios con perfil de recibidor disponibles a tareas en estado Registrado
	 * @param codigoCompania
	 * @param codigoCd
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param codigoPerfil
	 * @throws SICException
	 */
	public void asignarTareasFuncionario(Integer codigoCompania,Integer codigoCd, Integer codigoBodega, Integer codigoSubBodega, Long codigoPerfil)throws SICException;
	/**
	 * Permite comunica al sSIC los alcances usando un paginado mediante Spring
	 * @param codigoCompania
	 * @param userId
	 * @param tipoAreatrabajo
	 * @throws SICException
	 **/
	@InformacionMetodo(descripcion = "Permite comunica al SIC los alcances usando un paginado mediante Spring")
	public void comunicarSicPaginadoSpring(Integer codigoCompania, String tipoAreatrabajo)throws SICException;
	
	/**
	 * Envia un mail al usuario de los alcances que no se integraron con SIC
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public void envioMailAlcancesErrorIntegradosSIC(Integer codigoCompania, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void migrarArticuloActualizacionMasiva(Integer codigoCompania) throws SICException;
	
	/**
	 * Migrar ordenes de compra - facturas
	 * @param codigoCompania
	 * @throws SICException
	 * @author osaransig
	 */
	void migrarOrdenesCompraFacturas(Integer codigoCompania) throws SICException;
	
	/**
	 * Migrar ordenes de compra - facturas
	 * @param codigoCompania
	 * @param fechaEntrega
	 * @throws SICException
	 * @author osaransig
	 */
	void migrarOrdenesCompraFacturas(Integer codigoCompania, String fechaEntrega) throws SICException;
	
	/**
	 * @see 
	 * Enviar y generar el archivo de Entregas Planificadas por el proveedor 
	 * @param codigoCompania
	 * @author jtoapanta
	 * @throws SICException
	 */
	public void enviarPlanificacionEntregaProveedor(Integer codigoCompania)throws SICException;


	public void enviarArticulosPendientesAlSIC(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="C&oacute;digo Proceso", requerido=false, descripcion="C&oacute;digo del Proceso donde se origin&oacute; la integraci&oacute;n de art&iacute;culos", ejemplosValores={"1"})String valorTipoProceso) throws SICException;

	public void enviarArticulosPendientesAlSICCreacionMasiva(Integer codigoCompania)throws SICException;
	
	public void enviarArticulosPendientesAlSICEdicionMasiva(Integer codigoCompania)throws SICException;
	
	public void enviarArticulosPendientesActualizacionArchivoAlSIC(Integer codigoCompania) throws SICException;
	
	public void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException;
	
	public void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException;
	
	Collection<ArticuloPendienteIntegracionDTO> obtenerArticuloPendientesIntegracion(Integer codigoCompania, String valorTipoProceso) throws SICException;
	
	void transferirArticuloSICAsincrona(Integer codigoCompania, ArticuloDTO articuloPlantilla, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol, ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO, MultiKeyMap multiKey, IntegrationServiceI integrationServiceI, ArticuloVO vo, ArticuloLocalDTO al, ArticuloProveedorDTO apFiltro, RelacionArticuloRegistroSanitarioDTO ars) throws SICException;
	
	//-------------------------------------------------------------------------------------------------------
	// METODOS DE RECIBIDO NO FACTURADO
	//-------------------------------------------------------------------------------------------------------
	public void contabilizarGenerarCuentasPorPagar(Integer codigoCompania, String userId)throws SICException;
	/**
	 * Metodo  para sincronizar las ordenes de compra con los conflictos en cambio de precios.
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void sincronizarCambioPreciosOrdenesCompra(Integer codigoCompania) throws SICException;
	
	public void enviarArticulosPendientesActualizacionCondicionesComercialesAlSIC(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoInterface
	 * @param userId
	 * @throws SICException
	 */
	public void generarArchivoInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoInterface, String userId) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 */
	public void contingenciaGenerarArchivoInterfacePedidoAreaTrabajo(Integer codigoCompania);
	
	
	/**
	 * Metodo de recuperacion de ventas(descuentos) de Loyalty de promociones y campanias
	 * para el cobro de estos valores para los participantes
	 * @param companyId
	 * @param userId
	 * **/
	@InformacionMetodo(descripcion = "Recupera el acumulado de las ventas(descuentos) de Loyalty de promociones y campa&ntilde;a")
	void recuperarVentasLoyalty(@InformacionParametro(nombre="Tama&ntilde;o cada lote", requerido=true, descripcion="N&uacute;mero de cada lote", ejemplosValores={"10,100,1000"}) Integer numeroElementosSeleccion,
								@InformacionParametro(nombre="D&iacute;as a procesar", requerido=true, descripcion="N&uacute;mero de d&iacute;as a procesar, a partir de hoy", ejemplosValores={"1,5,10"}) Integer numeroDiasProcesar,
								@InformacionParametro(nombre="N&uacute;mero de d&iacute;as atr&aacute;s", requerido=true, descripcion="N&uacute;mero de d&iacute;as desde donde se va a procesar, a partir de hoy", ejemplosValores={"1,5,10"}) Integer diasAtrasProcesar,
								@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer companyId, 
								@InformacionParametro(nombre="C&oacute;digo Usuario", requerido=true, descripcion="Usuario al que pertenecen los datos", ejemplosValores={"FRM0"}) String userId,
								@InformacionParametro(nombre="Tipo recuperaci&oacute;n ventas", requerido=true, descripcion="Tipo de proceso que se va a ejecutar", ejemplosValores={"0,1"}) Integer recupearVenta);
	
	
	/**
	 * Procesa el cobro a proveedores de las ventas de promociones
	 * @param companyId
	 * @param userId
	 * **/
	@InformacionMetodo(descripcion = "Procesa el cobro a proveedores de las ventas de promociones ")
	void procesarVentasLoyalty(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer companyId, 
							   @InformacionParametro(nombre="C&oacute;digo Usuario", requerido=true, descripcion="Usuario al que pertenecen los datos", ejemplosValores={"FRM0"}) String userId,
								@InformacionParametro(nombre="N&uacute;mero de d&iacute;as atr&aacute;s", requerido=true, descripcion="N&uacute;mero de d&iacute;as desde donde se va a procesar, a partir de hoy", ejemplosValores={"1,5,10"}) Integer diasAtrasProcesar);
	
	/**
	 * Procesa el cobro a proveedores de las ventas de promociones
	 * @param companyId
	 * @param userId
	 * **/
	@InformacionMetodo(descripcion = "Procesa el cobro a proveedores de las ventas de promociones diarias")
	void procesarCobrosDiariosProyectados(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer companyId, 
							   @InformacionParametro(nombre="C&oacute;digo Usuario", requerido=true, descripcion="Usuario al que pertenecen los datos", ejemplosValores={"FRM0"}) String userId,
								@InformacionParametro(nombre="N&uacute;mero de d&iacute;as atr&aacute;s", requerido=true, descripcion="N&uacute;mero de d&iacute;as desde donde se va a procesar, a partir de hoy", ejemplosValores={"1,5,10"}) Date fecha);
	/**
	 * Genera las prefacturas de los cobros no procesados
	 * @param companyId
	 * @param userId
	 * @param diasEsperados
	 */
	@InformacionMetodo(descripcion = "Procesa el cobro a proveedores de las ventas de promociones diarias")
	void generarPrefacturasCobrosNoProcesados(@InformacionParametro(nombre="C&oacute;digo Compa&ntilde;&iacute;a", requerido=true, descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer companyId, 
			   @InformacionParametro(nombre="C&oacute;digo Usuario", requerido=true, descripcion="Usuario al que pertenecen los datos", ejemplosValores={"FRM0"}) String userId,
				@InformacionParametro(nombre="N&uacute;mero de d&iacute;as atr&aacute;s", requerido=true, descripcion="N&uacute;mero de d&iacute;as desde donde se va a procesar, a partir de hoy", ejemplosValores={"1,5,10"}) Integer diasEsperados);
	
	/**
	 * Metodo para carga de archivos xml de retenciones
	 * */
	public void cargaArchivosRetencionesXML() throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @param codigosProveedores
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedor(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException;
	
	void transferirDatosArticuloProveedorSIC(Integer codigoCompania, IntegrationServiceI servicioIntegracion, ArticuloPendienteIntegracionDTO dto, Collection<ArticuloPendienteIntegracionDTO> articulos, Collection<ArticuloProveedorDTO> proveedores) throws SICException;
	/**
	 * Metodo que realiza la tarea de eliminar entregas caducadas con estado confirmado en ENTREGAS B2B. 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void transEliminarEntregaCaducadasConfirmadasB2B()throws SICException;
	
	/**
	 * Metodo que realiza el proceso de regresar articulos nos recibidos a disponibles.
	 * @param codigoCompania
	 */
	public void transRegresarArticulosPlanificadosADisponibles(Long codigoCompania)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws Exception
	 */
	void integrarArticuloProveedorCambioPreciosSIC(Integer codigoCompania) throws Exception;
	
	/**
	 * Permite resolver las inconsistencias de Articulos relacionados a cupones que no tiene una estructura comercial de cliente relacionada
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @throws SICException
	 */
	public void resolverInconsistenciasArticuloRelacionadoCupon(@InformacionParametro(nombre="C\u00F3digo Compan\u00EDa", requerido=true, descripcion="C\u00F3digo Compan\u00EDa", ejemplosValores = { "1" }) Integer codigoCompania, @ParametroInformacionEjecucion  @InformacionParametro(nombre="N\u00FAmero de Ejecuci\u00F3n", requerido=true, descripcion="N\u00FAmero de Ejecuci\u00F3n", ejemplosValores = { "1" }) Integer numeroEjecucion) throws SICException;
	
	/**
	 * Migrar ordenes de compra - facturas
	 * @param codigoCompania
	 * @throws SICException
	 * @author rali
	 */
	public void migrarArticulosActivos(Integer codigoCompania) throws SICException;

	void integrarDatosLogisticosBodega(Integer codigoCompania) throws SICException;

	/**
	 * 
	 * @param userId
	 * @throws SICException
	 */
	public void validarFacturasElectronicasAutorizadas(String userId) throws SICException;

	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void inactivarArticulosInactivos(String codigoCompania) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoEstado
	 * @param habilitaFechaCreacion
	 * @param codigoLineaComercial 
	 */
	public void invalidarArticulosFecha(@InformacionParametro(nombre="C&oacute;digo Compan&iacute;a", requerido=true, descripcion="C&oacute;digo Compan&iacute;a", ejemplosValores={"1"}) Integer codigoCompania,
			@InformacionParametro(nombre="C&oacute;digo Estado", requerido=true, descripcion="C&oacute;digo Estado", ejemplosValores={"PCO"})String codigoEstado,
			@InformacionParametro(nombre="Habilitar fecha de creaci&oacute;n", requerido=true, descripcion="Habilitar fecha de creaci&oacute;n", ejemplosValores={"1","0"}) Integer habilitaFechaCreacion,
			@InformacionParametro(nombre="C&oacute;digo de L&iacute;nea Comercial", requerido=true, descripcion="C&oacute;digo de L&iacute;nea Comercial", ejemplosValores={"365"}) String codigoLineaComercial);
	

	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @throws SICException
	 */
	public void migrarArticulosCodificados(int codigoCompania, String codigoCompEstado) throws SICException;

	/**
	 * Metodo que permite migrar articulos para la reclasificacion
	 * @param codigoCompania
	 * @throws SICException
	 */
	void migrarReclasificacionArticulos(Integer codigoCompania) throws SICException;
	
	/**
	 * metodo que permite migrar las ubicaciones y la estructura logistica
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaUbicaciones(String url)throws SICException;
	
	/**
	 * metodo que permite migrar los andenes
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaAndenes(String url)throws SICException;
	

	/**
	 * Metodo para migrar los datos de las ventas que son enviados por el SIC 
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void ejecutarVentasDevolucionesProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * Ejecuta todos los descuentos registrados de un articulo
	 * @param codigoCompania
	 * @param fechasProcesamiento
	 * @throws SICException
	 */
	void ejecutarDescuentosProcesamientoVentas(Integer codigoCompania, Date fechaProcesamiento) throws SICException;
	
	/**
	 * Ejecuta una simulacion de los cobros diarios
	 * @param codigoCompania
	 * @param fechasProcesamiento
	 * @throws SICException
	 */
	void ejecutarRecuperacionesDiariasProcesamientoVentas(Integer codigoCompania, Date fechaProcesamiento) throws SICException;
	
	/**
	 * Ejecuta los cobros acumulados guardados
	 * @param codigoCompania
	 * @param fechasProcesamiento
	 * @throws SICException
	 */
	void ejecutarRecuperacionesProcesamientoVentas(Integer codigoCompania, Date fechaProcesamiento) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * Ejecutar la migrac&oacute;n de la tabla SCSADTARTBOD, SCSADTARTLOC y SCSADTARTOFI hacia la base no relacional orientDB
	 * @param codigoCompania
	 * @param sufijoTabla Sufijo para la tabla ArticuloAreaTrabajoBitacoraDTO", ejemplosValores = { "LOC, BOD, OFI" }
	 * @throws SICException
	 */
	void migrarArticuloAlcanceAOrientDB(@InformacionParametro(nombre = "C&oacute;digo Compa&ntilde;&iacute;a", requerido = true, descripcion = "Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores = { "1" }) Integer codigoCompania, @InformacionParametro(nombre = "Sufijo Tabla", requerido = true, descripcion = "Sufijo Tabla de la tabla articuloLocal", ejemplosValores = { "LOC, BOD, OFI" }) String sufijoTabla) throws SICException;
	
	/**
	 * Ejecutar la migrac&oacute;n de la tabla SCSADTARTBOD, SCSADTARTLOC y SCSADTARTOFI hacia la base no relacional orientDB
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param sufijoTabla Sufijo para la tabla ArticuloAreaTrabajoBitacoraDTO", ejemplosValores = { "LOC, BOD, OFI" }
	 * @throws SICException
	 */
	void migrarArticuloAlcanceAOrientDB(@InformacionParametro(nombre = "C&oacute;digo Compa&ntilde;&iacute;a", requerido = true, descripcion = "Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores = { "1" }) Integer codigoCompania, @InformacionParametro(nombre = "Codigo Local", requerido = true, descripcion = "Codigo del local a migrar", ejemplosValores = { "10, 701" }) Integer codigoLocal, @InformacionParametro(nombre = "Sufijo Tabla", requerido = true, descripcion = "Sufijo Tabla de la tabla articuloLocal", ejemplosValores = { "LOC, BOD, OFI" }) String sufijoTabla) throws SICException;
	
//	/**
//	 * Ejecutar la migrac&oacute;n de la tabla SCSADTARTARETRABITBOD, SCSADTARTARETRABITLOC y SCSADTARTARETRABITOFI hacia la base no relacional orientDB
//	 * @param codigoCompania
//	 * @param codigoLocal
//	 * @param sufijoTabla Sufijo para la tabla ArticuloAreaTrabajoBitacoraDTO", ejemplosValores = { "LOC, BOD, OFI" }
//	 * @throws SICException
//	 */
//	void migrarArticuloAlcanceBitacoraAOrientDB(@InformacionParametro(nombre = "C&oacute;digo Compa&ntilde;&iacute;a", requerido = true, descripcion = "Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores = { "1" }) Integer codigoCompania, @InformacionParametro(nombre = "Codigo Local", requerido = true, descripcion = "Codigo del local a migrar", ejemplosValores = { "10, 701" }) Integer codigoLocal, @InformacionParametro(nombre = "Sufijo Tabla", requerido = true, descripcion = "Sufijo Tabla de la tabla articuloLocal", ejemplosValores = { "LOC, BOD, OFI" }) String sufijoTabla) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param fechaCierre
	 */
	void ejecutarPlanificacionCambioPrecios(Integer codigoCompania, Date fechaCierre) throws SICException;


	/**
	 * Metodo que envia mail a los proveedores que tengan pendientes la actualizacion mensual de sus precios
	 *  en Comparacion de Precios del Portal B2B.
	 * @author jtoapanta
	 * @param codigoCompania
	 * @exception
	 */
	public void enviarMailProveedoresComparacionPreciosPendientes(Integer codigoCompania)throws SICException;

	void validarDatosArticulosSIC(Integer codigoCompania) throws SICException;

	/**
	 * Migrar los datos de un archivo de proveedores de servicio a una tabla temporal
	 * 
	 * @author ivasquez
	 * @param archivoProveedorServicios
	 * @throws SICException
	 */
	void transMigrarArchivoProveedorServicios(String archivoProveedorServicios) throws SICException;
	
	/**
	 * Migrar los datos que se encuentran en la tabla temporal de proveedor de servicios a la tabla de proveedores
	 * 
	 * @author ivasquez
	 * @throws SICException
	 */
	void transMigrarDatosProveedoServicios() throws SICException;

}