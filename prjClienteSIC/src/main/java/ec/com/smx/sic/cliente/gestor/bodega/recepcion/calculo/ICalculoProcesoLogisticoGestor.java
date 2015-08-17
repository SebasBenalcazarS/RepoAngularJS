package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.exception.CorporativoException;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;


/**
 * 
 * @author acaiza
 *
 */
public interface ICalculoProcesoLogisticoGestor {
	//TODO	
	/**
	 * 
	 * @param actualCatVal
	 * @param accionEntregaCatVal
	 * @return
	 * @throws SICException
	 */
	CatalogoValorRelacionadoDTO buscarEstadoRelacionado(CatalogoValorDTO actualCatVal, CatalogoValorDTO accionEntregaCatVal) throws SICException;

	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	Collection<ProcesoLogisticoDTO> obtenerProcesosLogisticosMonitorRecepcion(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	
//	/**
//	 * Este m&eacute;todo devuelve una colecci&oacute;n de procesos logisticos en base a los 
//	 * parametros que recibe como parametro y adem&aacute;s considerando que las entregas involucradas deben estar en proceso de recepci&oacute;n
//	 * @param codigoCompania
//	 * @param codigoJdeProveedor
//	 * @param nombreProveedor
//	 * @param codigoAreaTrabajoBodega
//	 * @param codigoAreaTrabajoSubBodega
//	 * @param fechaSeleccionada
//	 * @param tipoRecepcion
//	 * @param estadoProcesoLogistico
//	 * @return
//	 * @throws SICException
//	 */
//	VistaProcesoLogisticoVO obtenerProcesosLogisticosMonitor(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, Date fechaSeleccionada, String tipoRecepcion, String estadoProcesoLogistico)throws SICException;
	
//	VistaProcesoLogisticoVO obtenerProcesosLogisticosMonitorOpcion2(Integer codigoCompania, String codigoJdeProveedor, String nombreProveedor, Integer codigoAreaTrabajoBodega, String codigoSubBodega, Date fechaSeleccionada, String tipoRecepcion, String estadoProcesoLogistico)throws SICException;
	
//	/**
//	 * 
//	 * @param vistaProcesoLogisticoVO
//	 * @return
//	 * @throws SICException
//	 */
//	@Deprecated
//	VistaProcesoLogisticoVO obtenerProcesosLogisticosMonitorPaginado(VistaProcesoLogisticoVO vistaProcesoLogisticoVO) throws SICException;
	
	/**
	 * 
	 * @param vistaProcesoLogisticoVO
	 * @param esFechaEspecifica
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO obtenerProcesoLogisticoPaginado(VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Boolean esFechaEspecifica) throws SICException;
	
	/**
	 *  Obtener el total de pallets recibidos, en andenes y ubicados en el proceso de recepcion
	 * @param vistaProcesoLogisticoVO
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO obtenerTotalPalletsRecepcion(VistaProcesoLogisticoVO vistaProcesoLogisticoVO) throws SICException;
	
	/**
	 * Obtiene las todos los tipos de tarea de un proceso logistico
	 * 
	 * @param vistaProcesoLogisticoDTO Un VistaProcesoLogisticoDTO
	 * @return Un Collection de TareaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<TareaDTO> obtenerTareasProcesosLogistico(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	
	/**
	 * Obtener las areas de trabajo donde hay recepciones configuradas
	 * @param codigoCompania
	 * @param fechaRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreaTrabajoRecepcion (Integer codigoCompania, Date fechaRecepcion) throws SICException;
	
	/**
	 * Obtener el total de proveedores en recepcion
	 * @param vistaProcesoLogisticoVO
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalProveedoresRecepcion(VistaProcesoLogisticoVO vistaProcesoLogisticoVO) throws SICException;

	/**
	 * Obtiene el estado actual del proceso logistico
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	ProcesoLogisticoDTO obtenerEstadoActualProcesoLogistico(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
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
