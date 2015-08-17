package ec.com.smx.sic.cliente.servicio.bodega;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.exception.CorporativoException;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoNovedadArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.IndicadorPropietarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloJustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaNovedadRecepcionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionJugueteDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionOrdenCompraDetalleEstadoAuditEST;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionJugueteVO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.SlickGridVO;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;

/**
 * 
 * @author acaiza
 *
 */
public interface IRecepcionBodegaServicio {
	
	/**
	 * 
	 * @param proveedorDTO
	 * @param bodegaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<CalendarioDTO> transObtenerHorariosProveedorRecepcion(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleRecepcionEntregaDTO> transObtenerAndenesDetalleRecepcionEntrega(RecepcionProveedorDTO recepcion) throws SICException;
	/**
	 * 
	 * @param detalleSeccionDTOs
	 * @param recepcionProveedorDTO
	 * @param tareaDTO
	 * @throws CDException
	 */
	Collection<DetalleTareaDTO> transRegistrarAndenesTareaRecepcion(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor, TareaDTO tareaDTO) throws SICException;
	/**
	 * 
	 * @param detalleSeccionDTOs
	 * @param recepcionProveedorDTO
	 * @throws CDException
	 */
	TareaDTO transRegistrarTareaRecepcionProveedor(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor) throws SICException;
	
	/**
	 * Crear una recepcion vacia de planificacion
	 * 
	 * @param horaCalendarioDTO
	 * @param recepcionProveedorDTO
	 * @param detalleSeccionDTOs
	 * @throws SICException
	 */
	RecepcionProveedorDTO transCrearRecepcionPlanificacionProveedor(HoraCalendarioDTO horaCalendarioDTO, RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes) throws SICException;
	
	/**
	 * Completar el proceso de recepcion por tipo y subbodega de las ordenes de compra
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @param pedidoDTOs
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	void transCompletarTiposDeRecepcion(EntregaDTO entregaDTO, Collection<DetalleSeccionDTO> andenes, Collection<OrdenCompraEstadoDTO> listaOrdenCompraEstado , RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * Obtiene la lista de las areas de trabajo del funcionario en base a los datos del usuario
	 * @param usuario Un UserDto
	 * @return Un Collection<AreaTrabajoDTO>
	 * @throws SICException Excepcion en caso de producirse un error en el proceso
	 */
	Collection<AreaTrabajoDTO> transObtenerAreasTrabajoFuncionario(UserDto usuario) throws SICException;	

	/**
	 * Modifica los andenes de registro del proveedor para la recepcion en bodega y asignacion de tarea con andenes seleccionados de una entrega
	 * 
	 * @param entregasDTO
	 * @param detalleSeccionDTOs
	 * @param detalleSeccionDTO
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	void transModificarAndenesRecepcionEntrega(Collection<EntregaDTO> entregasDTO, Collection<DetalleSeccionDTO> andenes, DetalleSeccionDTO andenNuevoValor, DetalleSeccionDTO andenModificar) throws SICException;
	
	
	/**
	 * Modifica un anden de registro del proveedor para la recepcion en bodega y asignacion de tarea con andenes seleccionados de una entrega
	 * 
	 * @param entregsaDTO
	 * @param andenActual
	 * @param andenAnterior
	 * @return DetalleTareaDTO
	 * @throws SICException
	 */
	DetalleTareaDTO transModificarAndenRecepcionEntrega(Collection<EntregaDTO> entregasDTO, DetalleSeccionDTO andenActual, DetalleSeccionDTO andenAnterior) throws SICException;
	
	/**
	 * 
	 * @param proveedor
	 * @param cd
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaDTO> transObtenerFacturasEntregasProveedor(VistaProveedorDTO proveedor, AreaTrabajoDTO cd, Timestamp fechaEntrega) throws SICException ;
	
	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaDTO> tranObtenerEntregasFacturasSinAsignarProceso(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param subBodega
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
//	Collection<DetalleSeccionDTO> obtenerAndenesOcupadosPorSubBodega(BodegaDTO subBodega, Timestamp fecha) throws SICException;
	
	
	/**
	 * 
	 * @param entregaDTO
	 * @param funcionarioHistorico
	 * @throws SICException
	 */
	void transAsignarFuncionarioRecibidorEntrega(EntregaDTO entregaDTO, FuncionarioAreaTrabajoPerfilDTO funcionarioHistorico) throws SICException;
	
	/**
	 * 
	 * @param tareaPerfilDTO
	 * @param timestamp
	 * @return
	 * @throws SICException
	 */
	Integer obtenerSiguienteValorTipoTarea(TipoTareaPerfilDTO tareaPerfilDTO, Timestamp timestamp) throws SICException;

	/**
	 * 
	 * @param userDto
	 * @return
	 * @throws SICException
	 */
	FuncionarioAreaTrabajoPerfilDTO obtenerFuncionarioAreaTrabajoPerfilPorUsuario(UserDto userDto) throws SICException ;
	
	/**
	 * @param vistaProveedorDTO
	 * @return Collection<OrdenCompraEstadoDTO>
	 * @throws SICException
	 */
	Collection<OrdenCompraEstadoDTO> transObtenerListaOrdenesProveedor(OrdenCompraEstadoDTO ordenCompraEstadoDTO,AreaTrabajoDTO areaTrabajoDTO, BodegaDTO bodegaDTO, ProveedorDTO proveedorDTO,  CatalogoValorDTO catalogoValorDTO, Date fechaInicio, Date fechaFin) throws SICException;
	
	/**
	 * @param Integer codigoCatalogoTipo
	 * @return Collection<CatalogoValorDTO>
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> transObtenerCategoriasDetalleSeccion(Integer codigoCatalogoTipo) throws SICException;
	
	/**
	 * @param CatalogoValorDTO 
	 * @param Integer 
	 * @param Collection<DetalleSeccionDTO>
	 * @return DetalleSeccionDTO
	 * @throws SICException
	 */
	DetalleSeccionDTO transObtenerAndenPorCategoria(CatalogoValorDTO catalogo, Collection<Integer> codigosAreaTrabajoEntregas, Collection<DetalleSeccionDTO> listTempDetSeccion) throws SICException;
	
	/**
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaEstadoDTO> transObtenerFacturasProveedor(Collection<EntregaDTO> entregasDTO, Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO) throws SICException;

	/**
	 *
	 * @param codigosBarras
	 * @param facturaEstadoDTO
	 * @param recepcionProveedorDTOs
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaEstadoDTO> transObtenerFacturasPorCriterios(Collection<String> codigosBarras, FacturaEstadoDTO facturaEstadoDTO, Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param Integer
	 * @return Collection<DetalleTareaDTO>
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> transObtenerAndenesOcupados(Collection<Integer> codigosAreaTrabajoentregas, String numeroAnden) throws SICException;
	
	/**
	 * @param Collection<DetalleTareaDTO>
	 * @param EntregaDTO
	 * @return Collection<DetalleTareaDTO>
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> transObtenerAndenesLibres(Collection<DetalleTareaDTO> lisDetTareaOcupados, Collection<EntregaDTO> entregasSelect, RecepcionProveedorDTO recepcionSelect) throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoLogisticoDTO> obtenerProcesosLogisticosMonitorRecepcion(RecepcionProveedorVO recepcionProveedorVO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transAsignarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transRecibirProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transCancelarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transLiberarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @param historicoDTO
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transAsignarTareaFuncionario(TareaDTO tareaDTO, FuncionarioAreaTrabajoPerfilDTO historicoDTO, ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param codigoPerfil
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void transAsignarFuncionarioRecepcion(TareaDTO tareaDTO, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transLiberarProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;
	/**
	 * Este m�todo libera al usuario del proveedor que tiene acargo actualmente
	 * @param vistaProcesoLogisticoDTO
	 * @throws SICException
	 */
	void transLiberarProveedor (VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transReanudarProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transRecibirProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;
	
	
	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transModificarCantidadRecepcion(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;	
	
	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transFacturarProveedor( ProcesoLogisticoDTO procesoLog) throws SICException;	
	
/**
 * Este m�todo solicita una autorizacion por el listado de preguntas que recibe como parametro
 * @param codigoSistema
 * @param preguntasAutorizar
 * @param informacionUsurio
 */
	List<AutorizacionDTO> transSolicitarAutorizacionListaGuardia(Collection<GrupoCampoPlantillaDTO> preguntasAutorizar, UserCompanySystemDto informacionUsurio);
	
	/**
	 * Obtener las areas de trabajo donde existen recepciones pendientes
	 * @param codigoCompania
	 * @param fechaRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> transObtenerAreaTrabajoRecepcion (Integer codigoCompania, Date fechaRecepcion) throws SICException;
	
//	/**
//	 * Este m&eacute;todo devuelve una colecci&oacute;n de procesos log&iacute;sticos 
//	 * en base a los par&aacute;metros que recibe como parametro y adem&aacute;s considerando que las entregas involucradas deben estar en proceso de recepci&oacute;n
//	 * @param codigoCompania
//	 * @param codigoJdeProveedor
//	 * @param nombreProveedor
//	 * @param codigoAreaTrabajoBodega
//	 * @param codigoAreaTrabajoSubBodega
//	 * @param fechaSeleccionada
//	 * @param tipoRecepcion
//	 * @param estadoProcesoLogistico
//	 * @param firstResult
//	 * @param pageSize
//	 * @return
//	 * @throws SICException
//	 */
//	VistaProcesoLogisticoVO transObtenerProcesosLogisticosMonitor(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, Date fechaSeleccionada, String tipoRecepcion, String estadoProcesoLogistico)throws SICException;
	
//	VistaProcesoLogisticoVO transObtenerProcesosLogisticosMonitorOpcion2(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, String codigoSubBodega, Date fechaSeleccionada, String tipoRecepcion, String estadoProcesoLogistico)throws SICException;
	
	/**
	 * Obtener los procesos log&iacute;sticos en base a los par&aacute;metros paginados desde la BD
	 * @param vistaProcesoLogisticoVO
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO obtenerProcesoLogisticoMonitorPaginado(VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Boolean esFechaEspecifica) throws SICException;
	
	/**
	 * Obtener el total de pallets recibidos, en andenes y ubicados en el proceso de recepcion
	 * @param vistaProcesoLogisticoVO
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO transObtenerTotalPalletsRecepcion(VistaProcesoLogisticoVO vistaProcesoLogisticoVO)throws SICException;
	
	/**
	 * Este metodo asigna un usuario a la tarea actual
	 * @param vistaProcesoLogistico
	 * @param userId
	 * @return
	 */
	VistaProcesoLogisticoDTO transAsignarUsuarioTarea(VistaProcesoLogisticoDTO vistaProcesoLogistico, String userId)throws SICException;
	/**
	 * Este metodo obtiene todas las facturas de una recepcion y de las entregas de la recepcion segun los parametros que recibe ademas si la lista de recepciones no trae las entregas
	 * primero las calcula
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<FacturaEstadoDTO> obtenerFacturasProveedorRecepcion(Collection<RecepcionProveedorDTO> listaRecepcionProveedorDTO, Boolean traerFacturasRecepcion, Boolean traerFacturasEntregas, Boolean traerDetallesFacturas, Boolean traerFacturaInterna) throws SICException;
	
	/**
	 * Metodo para recibir un articulo en el proceso de recepcion de bodega en base al tipo de metodo de recepcion que se encuentre configurado por area de trabajo de la recepcion del proveedor
	 * 
	 * @param recepcionProveedorDTO Un RecepcionProveedorDTO
	 * @param articuloUnidadManejoDTO Un ArticuloUnidadManejoDTO
	 * @param cantidadRecibida Un Integer
	 * @return Un Collection de OrdenCompraDetalleEstadoDTO
	 * @throws SICException Excepcion en caso de producirse un error en el proceso
	 */
	Collection<OrdenCompraDetalleEstadoDTO> transRecibirArticuloRecepcion(
			RecepcionProveedorDTO recepcionProveedorDTO, 
			ArticuloUnidadManejoDTO articuloUnidadManejoDTO, 
			Integer cantidadRecibida, 
			BigDecimal pesoRecibido, 
			String tipoControlCosto) throws SICException;
	
	
	//Collection<OrdenCompraDetalleEstadoDTO> transRecibirArticuloEntregaOriginal(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer cantidadRecibida, BigDecimal pesoRecibido, String tipoControlCosto) throws SICException;
	
	
	Collection<OrdenCompraDetalleEstadoDTO> transRecibirArticuloEntregasPedidos(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer cantidadRecibida, BigDecimal pesoRecibido, String tipoControlCosto) throws SICException;
		
	/**
	 * Retorna una colecci&oacute;n de todos las justificaciones registradas en la tabla SBLOGTJUSTIFICACION filtradas por SUB BODEGA
	 * @param vistaProcesoLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificaciones(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO)throws SICException;
	/**
	 * Este m�todo devuelve una colecci�n de ordenesCompraDetalleEstado de las recepciones que recibe como parametro, tomando en cuenta tanto las que fueron planificadas(PEN)
	 * como las que no fueron planificadas (ENV)
	 * @param codigosRecpecion
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> transObtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosRecpecion, Long codigoOrdenCompraEstado) throws SICException;

	/**
	 * 
	 * @param procesoLogisticos
	 * @param diferenciasFacturasRecepcion
	 * @throws SICException
	 */
	void transRegistrarDiferenciasFacturas(Collection<VistaProcesoLogisticoDTO> procesoLogisticos, Collection<VistaDiferenciaFacturasRecepcionDTO> diferenciasFacturasRecepcion) throws SICException;
	
	/**
	 * <b> Obtiene una lista mediante un sql nativo, la cual contiene todos los
	 * datos necesarios para realizar una recepcion de juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/03/2014]
	 * </p>
	 * 
	 * @param fechaRegistroDesde
	 *            filtro de fecha limite inferior (fecha de registro del pedido)
	 * @param fechaRegistroHasta
	 *            filtro de fecha limite superior (fecha de registro del pedido)
	 * @param codigoProveedor
	 *            codigo del proveedor
	 * @param nombreProveedor
	 *            nombre del proveedor
	 * @param codigoBodega
	 *            codigo de la bodega de juguetes
	 * @param codigoSubBodega
	 * 			  codigo de la subbodega de juguetes 
	 * @param ubicacion
	 *            define si se realiza o no la relacion con las tablas para obtener la ubicacion
	 * @param codigosEmbarque
	 * 			  filtra la recepcion por el codigo de embarque(s)
	 * @return lista con los datos que cumplan la condicion
	 */ 
	List<VistaRecepcionJugueteDTO> obtenerRecepcionJuguetes(Date fechaRegistroDesde, Date fechaRegistroHasta, String codigoProveedor,
			String nombreProveedor, String codigoJDEProveedor, Integer codigoCD, Integer codigoBodega, String codigoSubBodega, boolean ubicacion, List<Long> codigosEmbarque) throws SICException;
	
	/**
	 * <b> Crea la estructura necesaria para mostrar datos usando SlickGrid.
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/03/2014]
	 * </p>
	 * 
	 * @param recepcionJugueteDTOs
	 *            lista que contiene los datos de la recepcion de juguetes
	 * @return objeto de tipo SlickGridVO que contiene las cabeceras y el
	 *         contenido que se mostrara en el SlickGrid
	 * @throws SICException
	 */
	SlickGridVO createDataFromDTOtoJson(List<VistaRecepcionJugueteDTO> recepcionJugueteDTOs) throws SICException;
	
	/**
	 * <b> Obtiene los datos de un proveedor filtrado por el codigo de compania y proveedor. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 01/04/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	VistaProveedorDTO obtenerProveedorPorID(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * <b> Obtiene un objeto de tipo compania con su respectiva provincia. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 01/04/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	CompaniaDTO obtenerCompaniaConProvincia(Integer codigoCompania) throws SICException;
	
	/**
	 * <b> Crea una lista con los datos que fueron cambiados en pantalla, para
	 * lo cual recibe una cadena un formato JSON. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/04/2014]
	 * </p>
	 * 
	 * @param origenDatosJSON
	 *            cadena en formato JSON con los datos que fueron modificados en
	 *            pantalla
	 * @return lista de tipo VistaRecepcionJugueteDTO
	 * @throws SICException
	 */
	List<VistaRecepcionJugueteDTO> obtenerDatosDesdeJSON(String origenDatosJSON) throws SICException;
	
	/**
	 * <b> Crea un objeto de tipo EntregaDTO con todos los datos necesarios para registrar la recepcion
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/04/2014]
	 * </p>
	 * 
	 * @param vistaRecepcionJugueteDTOs
	 *            lista que contiene los datos de la recepcion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	EntregaDTO obtenerEntegarParaCrearRecepcion(List<VistaRecepcionJugueteDTO> vistaRecepcionJugueteDTOs, Integer codigoCompania) throws SICException;
	
	/**
	 * <b> Agrupa los datos por proveedor, cada elemento de la lista contiene:
	 * EntregaDTO, RecepcionProveedorDTO, VistaProveedorDTO, List<<VistaRecepcionJugueteDTO>>. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/04/2014]
	 * </p>
	 * 
	 * @param recepcionJuguetes
	 *            datos de la recepcion
	 * @param codigoCompania
	 *            codigo de la compa�ia
	 * @param userId
	 *            identificador del usuario logeado
	 * @param codigoCD
	 *            codigo del centro de distribucion
	 * @param codigoATBodega
	 *            codigo area trabajo bodega
	 * @param codigoATSubBodega
	 *            codigo area trabajo subbodega
	 * @param paraRecepcion
	 * 			  define la los datos que se necesitan son para crear la recepcion o para generar el reporte
	 * @return lista de tipo RecepcionJugueteVO
	 * @throws SICException
	 */ 
	List<RecepcionJugueteVO> crearAgruparDatosParaRecepcion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania,
			String userId, Integer codigoCD, Integer codigoATBodega, Integer codigoATSubBodega, boolean paraRecepcion) throws SICException;
	/**
	 * <b> Actualiza los datos del articulo (codigo barras, unidad manejo, cantidad unidad manejo), el pedido (codigo migracion) y la
	 * OrdenCompraDetalleEstado (cantidad entregada); seguidamente crea los datos de la recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/04/2014]
	 * </p>
	 * 
	 * @param recepcionJuguetes
	 *            datos de la rececpion, lista para realizar las actualizaciones
	 * @param codigoCompania
	 * @param datosRecepcion
	 *            datos de la recepcion agrupado por proveedor, lista para crear la recepcion
	 * @throws SICException
	 */ 
	void transActualizarCrearDatosRecepcion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania,
			Integer codigoCD, Integer codigoATBodega, Integer codigoATSubBodega, String userId, String accesItemID, String systemId) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 *            Codigo de la compania
	 * @param codigoOrdenCompraDetalleEstado
	 *            Codigo del detalle de la orden de compra estado
	 * @param codigoArticulo
	 *            Codigo del articulo
	 * @param codigoUnidadManejo
	 *            Codigo de la unidad de manejo
	 * @param codigoProveedor
	 *            Codigo del proveedor
	 * @throws SICException
	 *             Excepcion en caso de producirse un error
	 */
	@Deprecated
	Collection<VistaRecepcionJugueteDTO> transCambiarArticuloOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String codigoArticulo, Long codigoUnidadManejo, Integer valorUnidadManejoNuevo, String codigoProveedor, String userId, Long codigoEmbarque) throws SICException;
	
	/**
	 * <b> Actualiza los datos cuando se remplaza un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 10/07/2015]
	 * </p>
	 * 
	 * @param recepcionJuguete
	 *            representa datos de la recepcion
	 * @param systemId
	 *            identificador del sistema(MAX)
	 * @param accessItemId
	 *            identificador de la opcion dentro del sistema(131-recepcion
	 *            juguetes)
	 * @param userId
	 *            identificador del usuario logeado
	 * @return coleccion con los datos actualizados para remplazar en la parte
	 *         visual
	 * @throws SICException
	 *             escepcion lanzada en caso de existir un error
	 */
	Collection<VistaRecepcionJugueteDTO> transCambiarArticuloOrdenCompraDetalleEstado(VistaRecepcionJugueteDTO recepcionJuguete,
			String systemId, String accessItemId, String userId) throws SICException;
	
	/**
	 * <b> Obtiene un string con la cabecera de las columnas para mostrar en el SlickGrid. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/03/2014]
	 * </p>
	 *
	 * @param isRecepcion define si tiene la funcionalidad de recepcion o solamente es un usuario de codificacion
	 * @return columnas para mostrar en el slickGrid
	 * @throws SICException
	 */ 
	String crearColumnasSlickGrid(boolean isRecepcion) throws SICException;
	
	/**
	 * <b> Crea una cadena en formato JSON para mostrarlo en el SlickGrid. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 06/05/2014]
	 * </p>
	 * 
	 * @param recepcionJugueteDTOs lista que contiene los datos de la recepcion
	 * @return cadena en formato JSON
	 * @throws SICException
	 */ 
	String crearDatosSlickGrid(List<VistaRecepcionJugueteDTO> recepcionJugueteDTOs) throws SICException;
	
	void transTerminarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * <b> Deshace el cambio de un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 30/05/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoArticulo
	 * @param codigoUnidadManejoActual
	 * @param codigoProveedorActual
	 * @param userId
	 * @param codigoEmbarque
	 * @return
	 * @throws SICException
	 */ 
	Collection<VistaRecepcionJugueteDTO> transReversaArticuloOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado,
			String codigoArticulo, Long codigoUnidadManejoActual, String codigoProveedorActual, String userId, Long codigoEmbarque)
			throws SICException;
	
	/**
	 * <b> Obtiene los grupos de trabajo(Prototipo) para mostralo en el popUp del SlickGrid; obtine los que se encuentran en estado activo y el tipo
	 * se ALC. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 04/06/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 */
	Collection<GrupoTrabajoDTO> obtenerPrototipos(Integer codigoCompania) throws SICException;
	
	/**
	 * <b>Actualiza los datos de la rececpion en caso de que el perfil del usuario no sea de recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 10/06/2014]
	 * </p>
	 * 
	 * @param recepcionJuguetes
	 * @throws SICException
	 */ 
	void transActualizarCrearDatosCodificacion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania, String userId,
			String accesItemID, String systemId) throws SICException;
	
	/**
	 * <b> Retorna una coleccion de proveedor que cumplan las condiciones de igualdad en codigo y nombre usando el operador LIKE. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 26/06/2014]
	 * </p>
	 * 
	 * @param codigoProveedor
	 * @param nombreProveedor
	 * @param codigoCompania
	 * @return
	 */
	Collection<VistaProveedorDTO> buscarProveedorPorCodigoNombre(String codigoProveedor, String nombreProveedor, Integer codigoCompania)
			throws SICException;
	
	/**
	 * Permite obtener los controles log&iacute;sticos para el monitor de recepci&oacute;n de abastos
	 * @param codigoCompania
	 * @param codigoAreaTrabajo: La subbodega
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<ControlLogisticoDTO> obtenerControlesLogisticos(Integer codigoCompania, Integer codigoAreaTrabajo, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * Permite almacenar los problemas encontrados para el control log&iacute;stico
	 * @param recepcionProveedorDTO
	 * @param controlLogisticoCol
	 * @throws SICException
	 */
	void transGuardarDatosControlLogistico(RecepcionProveedorDTO recepcionProveedorDTO, Collection<ControlLogisticoDTO> controlLogisticoCol) throws SICException;
	
	/**
	 * Retorna ordenesCompraDetalleEstado de recepciones con ordenes de compra Enviadas y Planificadas
	 * @param codigoCompania
	 * @param codigosProcesosLogisticos
	 * @param ordenCompraEstadoMap: Si tiene datos es una consulta especifica de ordenes de compra, si viene null es para consultar articulos de la recepcion
	 * @param estadoProcesoLogistico: Filtrar los art&iacute;culos de acuerdo al estado del proceso log&iacute;stico
	 * @return
	 * @throws SICException
	 */
	Collection<VistaOrdenCompraDetalleEstadoDTO> obtenerOrdenesCompraDetalleEstadoPorRecepcion(Integer codigoCompania, Collection<Long> codigosProcesosLogisticos, Map<Long,String> ordenCompraEstadoMap, String estadoProcesoLogistico) throws SICException;
	
	/**
	 * Es trans debido a que se eliminan registros de novedades registrados previo a modificar cantidades de recepcion
	 * @param vistaProcesoLogisticoCol
	 * @return
	 * @throws SICException
	 */
	Collection<VistaDiferenciaFacturasRecepcionDTO> transObtenerDiferenciasRecepcion(Collection<VistaProcesoLogisticoDTO> vistaProcesoLogisticoCol) throws SICException;
	
	/**
	 * <b> Obtiene una lista con los codigos de locales en el cual tiene alcances el articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/11/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 *            articulo para buscar los alcances
	 * @param estadoArticuloLocal
	 *            estado para filtrar la busqueda
	 * @return
	 */
	List<Integer> obtenerIdsLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal) throws SICException;
	
	/**
	 * <b> Obtiene una lista de tipo 'ArticuloLocalDTO' la cual representa los locales en el cual tienen alcances el articulo(codigo) que se pasa como
	 * parametro. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/11/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 *            articulo para buscar los alcances
	 * @param estadoArticuloLocal
	 *            estado para filtrar la busqueda
	 * @return
	 */
	List<ArticuloLocalDTO> obtenerLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal)
			throws SICException;
	
	/**
	 * Retorna los procesos logisticos involucrados en la agrupacion de las diferencias en la tabla SBLOGTPROLOGGRUNOVART
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> obtenerAgrupacionProcesosLogisticos(Collection<Long> codigosProcesosLogisticos) throws SICException;
	
	/**
	 * Actualiza el costo bruto en la recepcion
	 * @param costoBrutoActualizado
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void actualizarCostosRecepcion(RecepcionOrdenCompraDetalleEstadoAuditEST auditESTactual, RecepcionOrdenCompraDetalleEstadoAuditEST auditESTanterior, BigDecimal costoBrutoActualizado, Long codigoOrdenCompraDetalleEstado, Integer codigoCompania, String userId, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;
	

	/**
	 * <b> Obtiene las caracteristicas dinamicas en base a la clasificacion del articulo, estas caracteristicas definen si se puedo o no 
	 * editar el idicador propietario. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 06/01/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigosClasificacion
	 *            clasificacion asociado al articulo
	 * @param codigoTipoCatalogo
	 *            define el catalogo por el cual se quiere realizar la busqueda
	 * @return coleccion con las propiedades dinamicas que tiene el articulo
	 */
	Collection<CaracteristicaDinamicaDTO> obtenerCaratecristicasDinamicas(Integer codigoCompania, Set<String> codigosClasificacion, Integer codigoTipoCatalogo);
	
	/**
	 * <b> Obtiene los los datos de los diferentes tipos de indicador propietario. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param estado filtra la busqueda por un estado especifico
	 * @return lista de Indicador propietario
	 * @throws SICException
	 */ 
	List<IndicadorPropietarioDTO> obtenerDatosIndicadorPropietario(String estado) throws SICException;
	
	/**
	 * <b> Valida que el codigo de clasificacion pertenezca a la subbodega de juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @param codigoClasificacion
	 *            clasificacion del articulo
	 * @param subBodegaJuguetes
	 *            codigo de la subbodega de juguetes
	 * @param estado
	 *            filtra la consulta por el estado (ACT/INC)
	 */ 
	void validarClasificacionBodegaJuguetes(String codigoClasificacion, String subBodegaJuguetes, String estado) throws SICException;
	
	/**
	 * <b> Obtiene un area de trabajo en base a su identificador. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 *            identificador del area de trabajo
	 * @param estado
	 *            filtra el estado del area de trabjo
	 * @return area de trabajo
	 * @throws SICException excepcion lanzada en caso de existir un error
	 */
	AreaTrabajoDTO obtenerAreaTrabajoPorId(Integer codigoCompania, Integer codigoAreaTrabajo, String estado) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 */
	BigDecimal consultarCostoNetoOrdenCompraDetalleEstado (Integer codigoCompania, Long codigoOrdenCompraEstado, Long codigoUnidadManejo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 */
	ProcesoLogisticoDTO obtenerEstadoActualProcesoLogistico(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param justificacionesEtiquetadoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionesEtiquetadoRecepcion(Integer codigoCompania, Collection<String> justificacionesEtiquetadoRecepcion, String codigoArticulo,
			Long codigoUnidadManejo, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * Registrar las justificaciones para las validaciones del etiquetado en la recepcion
	 * @param recepcionProveedorArticuloJustificacionCol
	 * @throws SICException
	 */
	void registrarJustificacionesEtiquetadoRecepcion(Collection<RecepcionProveedorArticuloJustificacionDTO> recepcionProveedorArticuloJustificacionCol, Integer codigoCompania, String codigoArticulo,
			Long codigoUnidadManejo, Long codigoRecepcionProveedor, Collection<String> validacionesEtiquetado, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO, String accesItemID, String codigoBarras, String userId)throws SICException;
	
	
	/**
	 * <b> Obtiene la configuracion de etiquetado de, registro sanitario
	 * transgénico y semaforo, para activar y desactivar las validaciones<b>
	 * <p>
	 * [Author: aecaiza, Date: 27/02/2015]	 
	 * @param codigoCompania
	 * @param codigoRecepcionProveedorArticulo
	 * @param validacionesEtiquetado
	 * @return
	 */
	Map<String, Boolean> obtenerConfiguracionesValidacionesEtiquetado(Integer codigoCompania, Long codigoRecepcionProveedorArticulo, Collection<String> validacionesEtiquetado);
	
	/**
	 * <b> Obtiene el codigo de de recepcion proveedor articulo<b>
	 * <p>
	 * [Author: aecaiza, Date: 02/03/2015]	 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Long obtenerCodigoRecepcionProveedorArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoRecepcionProveedor)throws SICException;

	/**
	 * 
	 * @param procesosLogisticos
	 * @param novedadesOficina
	 * @throws SICException
	 */
	void transRegistrarNovedadesOficina(Collection<VistaProcesoLogisticoDTO> procesosLogisticos, Collection<VistaNovedadRecepcionArticuloDTO> novedadesOficina) throws SICException;

	/**
	 * @param procesosSeleccionados
	 */
	Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadesRegistradas(Collection<VistaProcesoLogisticoDTO> procesosSeleccionados) throws SICException;

	/**
	 * @param procesoLogisticos
	 * @param diferenciaSeleccionada
	 * @return
	 * @throws SICException
	 */
	Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadesRegistradasPorArticulo(Collection<VistaProcesoLogisticoDTO> procesoLogisticos, VistaDiferenciaFacturasRecepcionDTO diferenciaSeleccionada) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	GrupoNovedadArticuloDTO obtenerGrupoNovedadArticulo(Integer codigoCompania, Collection<Long> codigosProcesosLogisticos) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @throws SICException
	 */
	void transEliminarNovedadesRegistradas(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;

	/**
	 * @param procesosSeleccionados
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> validarAgrupacionProcesosLogisticos(Collection<VistaProcesoLogisticoDTO> procesosSeleccionados) throws SICException;
	
	/**
	 * <b> Obtiene los ids de los estados de las facturas en base a los detalles y el codigo de barras de un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 15/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            codigo de la compania para filtrar la busqueda
	 * @param estado
	 *            estado activo
	 * @param codigoBarras
	 *            codigo de barras del articulo
	 * @param codigosOrdenCompraFacturas
	 *            detalles de ordenes de compra asociado a las facturas
	 * @return ids de los estados de las factura
	 */
	List<Long> obtenerIdFacturaCodigoBarras(Integer codigoCompania, String estado, String codigoBarras,
			List<Long> codigosOrdenCompraFacturas) throws SICException;
	
	/**
	 * Obtiene el valor de la caracteristica proceso area de trabajo
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigoAreaTrabajo
	 * @param codigoCatalogoTipo
	 * @param codigoCatalogoValor
	 * @return
	 * @throws SICException
	 */
	String obtenerValorCaracteristica(Integer codigoCompania, Long codigoProceso, Integer codigoAreaTrabajo, Integer codigoCatalogoTipo, String codigoCatalogoValor) throws SICException;

	/**
	 * Obtiene el estado actual de un proceso logistico 
	 * @param procesoLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	ProcesoLogisticoEstadoDTO consultarEstadoActualProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;


	
	/**
	 * Obtiene una coleccion de CaracteristicaProcesoAreaTrabajoDTO filtrado por el codigoCatalogoTipo
	 * @author yarmentero
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigoAreaTrabajo
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws CorporativoException
	 */
	Collection<CaracteristicaProcesoAreaTrabajoDTO> obtenerColeccionCaracteristicaProcesoAreaTrabajoDTO(Integer codigoCompania, Long codigoProceso, Integer codigoAreaTrabajo, Integer codigoCatalogoTipo) throws SICException;

}
