package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GrupoNovedadArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaNovedadRecepcionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;

/**
 * @author dalmeida
 *
 */
public interface IDiferenciasFacturasDAO {
	
	/**
	 * Retorna una colecci&oacute;n de todos las justificaciones registradas en la tabla SBLOGTJUSTIFICACION
	 * @return
	 * @throws SICException
	 */
	public Collection<JustificacionDTO> obtenerJustificaciones()throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaDiferenciaFacturasRecepcionDTO> obtenerDiferenciasRecepcion(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * 
	 * @param vistaProcesoLogisticoCol
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaDiferenciaFacturasRecepcionDTO> obtenerDiferenciasRecepcion(Collection<VistaProcesoLogisticoDTO> vistaProcesoLogisticoCol) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadRecepcionArticulo(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadRecepcionArticuloRegistrada(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * Elimina los registros de combinaciones anteriores en RecepcionNovedadArticuloJustificacion, RecepcionNovedadArticulo, RecepcionProcesoLogisticoDetalle y RecepcionProcesoLogistico
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @throws SICException
	 */
	public void eliminarDiferenciasRegistradas(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * Elimina los registros de novedades considerando que la oficina puede registrar varias novedades 
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @throws SICException
	 */
	public void eliminarNovedadesRegistradas(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * Retorna los procesos logisticos involucrados en la agrupacion de las diferencias en la tabla SBLOGTPROLOGGRUNOVART
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> obtenerAgrupacionProcesosLogisticos(Collection<Long> codigosProcesosLogisticos) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	public GrupoNovedadArticuloDTO obtenerGrupoNovedadArticulo(Integer codigoCompania, Collection<Long> codigosProcesosLogisticos) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadRecepcionArticuloRegistrada(Integer codigoCompania, Collection<Long> codigosProcesoLogistico, String codigoArticulo, Long codigoUnidadManejo) throws SICException;

	/**
	 * @param vistaDiferencia
	 * @throws SICException
	 */
	public void eliminarNovedadArticuloJustificacion(VistaDiferenciaFacturasRecepcionDTO vistaDiferencia) throws SICException;

}