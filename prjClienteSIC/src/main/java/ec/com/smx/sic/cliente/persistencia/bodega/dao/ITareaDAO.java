package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaPalletDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionPalletMontacarguistaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.VistaTareaRecolectorTransient;

public interface ITareaDAO {

	/**
	 * @param hibernateH
	 *            the hibernateH to set
	 */
//	public abstract void setHibernateH(IHibernateH<TareaDTO> hibernateH);

	/**
	 * 
	 * @param tareaPerfilDTO
	 * @param timestamp
	 * @return
	 * @throws SICException
	 */
	Integer valorMaxOrden(TipoTareaPerfilDTO tareaPerfilDTO, Timestamp timestamp) throws SICException;
	
	/**
	 * Obtiene todas la tareas de una recepcion de una entrega a partir de una tarea
	 * 
	 * @param tareaDTO Un TareaDTO
	 * @return Un Collection TareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<TareaDTO> obtenerTareasEntrega(TareaDTO tareaDTO) throws SICException;
	
	/**
	 * Finaliza el estado de un tarea estado
	 * 
	 * @param tareaEstadoDTO
	 * @param usuario
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void finalizarEstadoTareaEstado(TareaEstadoDTO tareaEstadoDTO, String usuario) throws SICException;
	
	/**
	 * Actualiza el estado actual de la tarea en base a su secuencial
	 * 
	 * @param secuencialTarea
	 * @param estado
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void actualizarEstadoActualTarea(Long secuencialTarea, CatalogoValorDTO estado) throws SICException;
	
	/**Libera el recibidor de la tarea que se encuentra asignado
	 * @param tareaDTO
	 * @param estadoactual
	 * @param tareaLiberada
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void liberarProveedor(TareaDTO tareaDTO, CatalogoValorDTO estadoactual, Boolean tareaLiberada) throws SICException;
	
	/**
	 * Actualiza los datos de una tarea con la informacion del funcionario
	 * 
	 * @param tareaDTO Un TareaDTO 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void asignarFuncionarioTareaRecepcion(TareaDTO tareaDTO) throws SICException;

	/**
	 * Consultar de tareas para recepcion
	 * @author lguaman
	 * @param codigoCompania
	 * @param codigoTarea
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	TareaDTO consultarTarea(Integer codigoCompania, Long codigoTarea) throws SICException;
	
	/**
	 * Consulta los detalles de una's tarea en base al codigo de una tarea
	 * @param codigoCompania Codigo de la compania
	 * @param codigosTarea Codigos de la tarea
	 * @return Un Collection de DetalleTareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<DetalleTareaDTO> consultarDetallesTarea(Integer codigoCompania, Collection<Long> codigosTarea)  throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosDetalleSeccion
	 * @param estadosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
    Collection<DetalleTareaDTO> consultarDetallesTareaAndenesRelacionados(Integer codigoCompania, Collection<Long> codigosDetalleSeccion, Collection<String> estadosProcesoLogistico) throws SICException;
	
	/**
	 * Obtiene las tareas del recollector que aun estan pendientes o asignadas a un usuario
	 * 
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param tipoTareaPerfilDTO
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<TareaDTO> buscarTareasRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, TipoTareaPerfilDTO tipoTareaPerfilDTO,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
	
	/**
	 * 
	 * @param funSublugarTraRel
	 * @param tipoTareaPerfilDTO
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaRecolectorTransient> obtenerVistaTareasRecolectorPerecibles (FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, TipoTareaPerfilDTO tipoTareaPerfilDTO) throws SICException; 

	/**
	 * Obtiene el total de tareas del recolector
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	Integer obtenerTotalTareasRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, TipoTareaPerfilDTO tipoTareaPerfilDTO,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
	
	/**
	 * Retorna una coleccion de pallets que aun no han sido ubicados y se encuentra en pasillo
	 * @param funcionarioAreaTrabajoDTO
	 * @param tipoTareaPerfilDTO
	 * @param codigoBarrasPallet
	 * @return
	 * 
	 */
	Collection<VistaUbicacionPalletMontacarguistaDTO> buscarPaletsMontacarguista(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, TipoTareaPerfilDTO tipoTareaPerfilDTO, String codigoBarrasPallet) throws SICException;
	
	/**
	 * Retorna una coleccion de las tareas que aun no han sido asignadas a los recibidores
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param tipoTareaPerfilDTO
	 * @param codigoProceso
	 * 
	 */
	Collection<TareaDTO> obtenerTareasRecibidorSinAsignar(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, TipoTareaPerfilDTO tipoTareaPerfilDTO, Long codigoProceso) throws SICException;


	/**
	 * Obtiene todos los tipos de tarea de un proceso logistico de una recepcion
	 * 
	 * @param vistaProcesoLogisticoDTO Un VistaProcesoLogisticoDTO
	 * @return Un Collection de TareaDatosTareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaTareaPalletDTO> obtenerTareasProcesosLogistico(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param funSubLugarTraRel
	 * @param funcionarioPerfilDTO
	 * @param fechaTarea
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaDTO> obtenerTareasPendienteRecibidor(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Obtener la tarea de receso de un funcionario si esta sin finalizar.
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareaRecesoPorFuncionarioEnProceso(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda) throws SICException;
	
	/**
	 * Obtener las tareas en estado activo que un funcionario tiene asociadas por el catalogovalor del estado de la tarea
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param codigoPerfil
	 * @param catalogoTipoEstadoTarea
	 * @param colCatalogoValorEstadoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasPorFuncionarioYEstadoTarea(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String codigoPerfil, Integer catalogoTipoEstadoTarea, Collection<String> colCatalogoValorEstadoTarea) throws SICException;

	/**
	 * <b>  Obtener el tipo tarea para la recepcion<b>
	 * <p>
	 * [Author: lguaman, Date: 11/11/2014]
	 * @param codigoReferencia
	 * @param codigoCompania
	 * @return
	 */
	TipoTareaDTO obtenerTipoTarea(String codigoReferencia, Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param codigoPerfil
	 * @param catalogoTipoEstadoTarea
	 * @param colCatalogoValorEstadoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasPorFuncionario(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String codigoPerfil, Integer catalogoTipoEstadoTarea, Collection<String> colCatalogoValorEstadoTarea) throws SICException;

	/**
	 * Obtener una tarea con los datos actualizados en el proceso log&iacute;stico
	 * @param codigoProcesoLogistico
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	TareaDTO obtenerTareaRecibidor(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Obtener una tarea con los datos actualizados en el proceso log&iacute;stico de acuerdo a los par&aacute;metros enviados
	 * @param codigoProcesoLogistico
	 * @param codigoCompania
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException
	 */
	TareaDTO obtenerTareaPerfil(Long codigoProcesoLogistico, Integer codigoCompania, String codigoReferenciaTipoTarea) throws SICException;
	
//	/**
//	 * Obtener tarea por id
//	 * @param codigoCompania
//	 * @param codigoProcesoLogistico
//	 * @return
//	 * @throws SICException
//	 */
//	TareaDTO obtenerTarea(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Obtener tarea estado por c&oacute;digo tarea
	 * @param codigoCompania
	 * @param codigoTarea
	 * @return
	 * @throws SICException
	 */
	TareaEstadoDTO obtenerTareaEstadoActual(Integer codigoCompania, Long codigoTarea) throws SICException;
	
	/**
	 * Obtener tarea activa de un proceso logistico
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param referenceCode
	 * @return
	 * @throws SICException
	 */
	TareaDTO obtenerTareaActualEnProcesoLogistico(Integer codigoCompania, Long codigoProcesoLogistico, String referenceCode) throws SICException;
	
	/**
	 * Obtener todas las tareas de un proceso logistico
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasProcesoLogistico(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Obtener datos tarea proceso logistico
	 * @param codigoTareaCol
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerTareaDatosTareaProcesoLogistico(Collection<Long> codigoTareaCol) throws SICException;

	/**
	 * Obtener funcionario perfil por usuario
	 * @param userDto
	 * @param referenceCode
	 * @return
	 * @throws SICException
	 */
	FuncionarioPerfilDTO obtenerFuncionarioPerfilPorUsuario(UserDto userDto, String referenceCode) throws SICException; 
	
}