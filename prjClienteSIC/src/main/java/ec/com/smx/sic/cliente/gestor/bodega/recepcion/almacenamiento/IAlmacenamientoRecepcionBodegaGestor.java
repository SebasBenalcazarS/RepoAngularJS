package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;
import java.util.List;

import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaRecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaNovedadRecepcionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;

/**
 * 
 * @author acaiza
 *
 */
public interface IAlmacenamientoRecepcionBodegaGestor {
	
	/**
	 * Crear los datos de la Tarea de una recepcion
	 * 
	 * @param detalleSeccionDTOs
	 * @param recepcionProveedorDTO 
	 * @param tareaDTO
	 * @throws SICException
	 */
	public Collection<DetalleTareaDTO> registrarAndenesTareaRecepcion(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor, TareaDTO tareaDTO) throws SICException;
	
	/**
	 * Crear los datos de la Tarea de una recepcion
	 * 
	 * @param detalleSeccionDTOs
	 * @param recepcionProveedorDTO 
	 * @throws SICException
	 */
	public TareaDTO registrarTareaRecepcionProveedor(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor) throws SICException;
	
	
	/**
	 * Crear una recepcion vacia de planificacion
	 * 
	 * @param horaCalendarioDTO
	 * @param recepcionProveedorDTO
	 * @param detalleSeccionDTOs
	 * @throws SICException
	 */
	public RecepcionProveedorDTO crearRecepcionPlanificacionProveedor(HoraCalendarioDTO horaCalendarioDTO, RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes) throws SICException;
	
	/**
	 * Completar el proceso de recepcion por tipo y subbodega de las ordenes de compra
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @param ordenCompraEstadoDTOs
	 * @param recepcionProveedorDTO 
	 * @throws SICException
	 */
	public EntregaDTO completarTiposDeRecepcion(EntregaDTO entregaDTO, Collection<DetalleSeccionDTO> andenes, Collection<OrdenCompraEstadoDTO> listaOrdenCompraEstado , RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * Registra un tipo de recepcion de una entrega de un proveedor para la recepcion por bodega, subobodega, tipo pedido
	 * 
	 * @param entregaDTO
	 * @param andenes
	 * @param codigoAreaTrabajoBodega
	 * @param codigoSubBodega
	 * @param codigoTipoRecepcion
	 * @param valorTipoRecepcion
	 * @return
	 * @throws SICException
	 */
	public EntregaRecepcionProveedorDTO registrarProveedorRecepcionEntrega(EntregaDTO entregaDTO, Integer codigoAreaTrabajoBodega, String codigoSubBodega, 
			Integer codigoTipoRecepcion, String valorTipoRecepcion) throws SICException;
	
	public RecepcionProveedorDTO registrarProveedorRecepcionEntrega(Collection<EntregaDTO> entregaDTOs, Integer codigoAreaTrabajoBodega, String codigoSubBodega, 
			Integer codigoTipoRecepcion, String valorTipoRecepcion) throws SICException;
	
	/**
	 * 
	 * @param funcionarioHistorico
	 * @param tareaDTO
	 * @throws SICException
	 */
	public void asignarFuncionarioTarea(TareaDTO tareaDTO, FuncionarioAreaTrabajoPerfilDTO funcionarioAreaTrabajoPerfilDTO) throws SICException;

	/**
	 * 
	 * @param entregaDTO
	 * @param historico
	 * @throws SICException
	 */
	public void asignarFuncionarioRecibidorEntrega(EntregaDTO entregaDTO, FuncionarioAreaTrabajoPerfilDTO funcionarioHistorico) throws SICException;

	/**
	 * Cambia estado del proceso logistico y la tarea a asignada
	 * @param tareaDTO
	 * @param historicoDTO
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void asignarFuncionario(TareaDTO tareaDTO, FuncionarioAreaTrabajoPerfilDTO historicoDTO, ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 */
	public void liberarProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;

	/**
	 * Cambia estado del proceso logistico y la tarea a suspendida
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	public void reanudarProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;

	/**
	 * Cambia estado del proceso logistico a en recepcion y la tarea a proceso luegode ser suspendida
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	public void recibirProveedor(TareaDTO tareaDTO, ProcesoLogisticoDTO procesoLog) throws SICException;

	/**
	 * Cambia estado del proceso logistico y la tarea a terminado
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	public void modificarCantidadRecepcion(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * Cambia estado del proceso logistico y la tarea a facturado
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	public void facturarProveedor( ProcesoLogisticoDTO procesoLog ) throws SICException;
		
	
	/**
	 * Asigna un anden a una tarea de recepcion en el detalle de las tareas
	 * @param recepcionProveedorDTO
	 * @param andenes
	 * @throws SICException
	 */
	public void registarAndenesRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes) throws SICException;
	/**
	 * Este m�todo solicita una autorizacion por el listado de preguntas que recibe como parametro
	 * @param codigoSistema
	 * @param preguntasAutorizar
	 * @param informacionUsurio
	 */
	public List<AutorizacionDTO> solicitarAutorizacionListaGuardia(Collection<GrupoCampoPlantillaDTO> preguntasAutorizar, UserCompanySystemDto informacionUsurio);
	/**
	 * Este m�todo libera al usuario del proveedor que tiene acargo actualmente
	 * @param vistaProcesoLogisticoDTO
	 * @throws SICException
	 */
	public void liberarProveedor (VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	/**
	 * Este m�todo asigna un usuario a la tarea actual
	 * @param vistaProcesoLogisticoDTO
	 * @param userId
	 * @return
	 */
	public VistaProcesoLogisticoDTO asignarUsuarioTarea(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, String userId)throws SICException;
	
	/**
	 * 
	 * @param procesoLogisticos
	 * @param diferenciasFacturasRecepcion
	 * @throws SICException
	 */
	public void registrarDiferenciasFacturasRecepcion(Collection<VistaProcesoLogisticoDTO> procesoLogisticos, Collection<VistaDiferenciaFacturasRecepcionDTO> diferenciasFacturasRecepcion) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param codigoPerfil
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void asignarFuncionarioRecepcion(TareaDTO tareaDTO, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * Las novedades de oficina no tienen proceso logistico asociado, ya que tienen el codigo de grupo novedad articulo
	 * Las novedades del recibidor tiene proceso logistico asociado para poder identificarlas y agruparlas en las diferencias de oficina
	 * @param procesosLogisticos
	 * @param novedadesOficina
	 * @throws SICException
	 */
	public void registrarNovedadesOficina(Collection<VistaProcesoLogisticoDTO> procesosLogisticos, Collection<VistaNovedadRecepcionArticuloDTO> novedadesOficina) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @throws SICException
	 */
	public void eliminarNovedadesRegistradas(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
}
