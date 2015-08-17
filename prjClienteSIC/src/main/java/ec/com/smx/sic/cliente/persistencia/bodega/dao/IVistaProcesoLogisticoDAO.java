package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;

public interface IVistaProcesoLogisticoDAO {

	/**
	 * Este m&eacute;todo devuelve una colecci&oacute;n de procesos logisticos en base a los parametros que recibe 
	 * como parametro y adem&aacute;s considerando que las entregas involucradas deben estar en proceso de recepci&oacute;n
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @param nombreProveedor
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubBodega
	 * @param tipoRecepcion
	 * @param estadoProcesoLogistico
	 * @param colEstadoProcesoLogisticoExcluir
	 * @param relacionJoinTarea
	 * @param traerRecepcionesAnteriores
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws SICException
	 */
	@Deprecated
	Collection<VistaProcesoLogisticoDTO> obtenerProcesosLogisticosMonitor(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, String tipoRecepcion, String estadoProcesoLogistico, Collection<String> colEstadoProcesoLogisticoExcluir, String relacionJoinTarea, Boolean traerRecepcionesAnteriores, Integer firstResult, Integer pageSize) throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve una colecci&oacute;n de procesos logisticos en base a los parametros que recibe 
	 * como parametro y adem&aacute;s considerando que las entregas involucradas deben estar en proceso de recepci&oacute;n utilizando criteria querry 
	 * @param vistaProcesoLogisticoVO
	 * @param colEstadoProcesoLogisticoExcluir
	 * @param relacionJoinTarea
	 * @param esFechaEspecifica
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> obtenerProcesosLogisticos (VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Collection<String> colEstadoProcesoLogisticoExcluir, String relacionJoinTarea, Boolean esFechaEspecifica, Integer firstResult, Integer pageSize) throws SICException;
	
	/**
	 * Contar el total de recepciones que hay para obtenere los datos paginados en el monitor del proceso logistico
	 * @param codigoCompania
	 * @param codigoJdeProveedor
	 * @param nombreProveedor
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubBodega
	 * @param tipoRecepcion
	 * @param estadoProcesoLogistico
	 * @param colEstadoProcesoLogisticoExcluir
	 * @param relacionJoinTarea
	 * @param traerRecepcionesAnteriores
	 * @return
	 * @throws SICException
	 */
	@Deprecated
	Integer obtenerTotalProcesosLogisticosMonitor(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, String tipoRecepcion, String estadoProcesoLogistico, Collection<String> colEstadoProcesoLogisticoExcluir, String relacionJoinTarea, Boolean traerRecepcionesAnteriores) throws SICException;
	
	/**
	 * Obtener el total de vistas de procesos logistico utilizando criteria querry 
	 * y aplicando los criterios que se utilizan en los componentes de b&uacute;squeda search component
	 * @param vistaProcesoLogisticoVO
	 * @param colEstadoProcesoLogisticoExcluir
	 * @param relacionJoinTarea
	 * @param esFechaEspecifica
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalProcesosLogisticos(VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Collection<String> colEstadoProcesoLogisticoExcluir, String relacionJoinTarea, Boolean esFechaEspecifica) throws SICException;
	
//	public Collection<VistaProcesoLogisticoDTO> obtenerProcesosLogisticosMonitorOpcion2(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, String codigoSubBodega, Date fechaSeleccionada, String tipoRecepcion, String estadoProcesoLogistico)throws SICException;
	/**
	 * Este m&eacute;todo setea en el objeto que recibe como parametro la cantidad de items
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public VistaProcesoLogisticoDTO obtenerDatosCantidadesItemsProcesoLogistico(VistaProcesoLogisticoDTO vistaProcesoLogistico, String estadoOrdenCompra, String tipoRecepcion) throws SICException;
	/**
	 * Este m�todo setea en el objeto que recibe como parametro la cantidad de bultos
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public VistaProcesoLogisticoDTO obtenerDatosCantidadesBultosProcesoLogistico(VistaProcesoLogisticoDTO vistaProcesoLogistico, String estadoOrdenCompra, String tipoRecepcion) throws SICException;
	
	/**
	 * Este m�todo setea en el objeto que recibe como parametro la cantidad de andenes del proceso logistico
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public VistaProcesoLogisticoDTO obtenerDatosCantidadAndenesProcesoLogistico(VistaProcesoLogisticoDTO vistaProcesoLogistico) throws SICException;
	/**
	 * Este m�todo setea en el objeto que recibe como parametro la cantidad de palets recibidos en el proceso logistico
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public VistaProcesoLogisticoDTO obtenerDatosCantidadPaletsRecibidosProcesoLogistico(VistaProcesoLogisticoDTO vistaProcesoLogistico) throws SICException;
	/**
	 * Este devuelve la fecha de inicio de la tarea que recibe como parametro en el estado que recibe como parametro
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Date obtenerFechaProcesoLogisticoPorEstadoTarea(VistaProcesoLogisticoDTO vistaProcesoLogistico, String estadoTarea) throws SICException;
	/**
	 * Este m�todo devuleve la cantidad de andenes que est�n ubicados o recibidos dependiendo de los parametros que recibe como parametro
	 * @param vistaProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Long obtenerDatosCantidadPaletsPorProcesoLogisticoPorPerfil(Collection<VistaProcesoLogisticoDTO> procesosLogisticos, Long codigoTipoTareaPerfil, Boolean tareasTerminadas) throws SICException;
}
