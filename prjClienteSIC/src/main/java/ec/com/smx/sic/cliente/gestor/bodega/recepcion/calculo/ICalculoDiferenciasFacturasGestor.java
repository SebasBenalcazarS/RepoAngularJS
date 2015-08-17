package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

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
public interface ICalculoDiferenciasFacturasGestor {
	
	/**
	 * Retorna una colecci&oacute;n de todos las justificaciones registradas en la tabla SBLOGTJUSTIFICACION filtradas por SUBBODEGA
	 * @return
	 * @throws SICException
	 */
	public Collection<JustificacionDTO> obtenerJustificaciones(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO)throws SICException;
	
	/**
	 * 
	 * @param vistaProcesoLogisticoCol
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaDiferenciaFacturasRecepcionDTO> obtenerDiferenciasRecepcion(Collection<VistaProcesoLogisticoDTO> vistaProcesoLogisticoCol) throws SICException;
	
	/**
	 * Retorna los procesos logisticos involucrados en la agrupacion de las diferencias en la tabla SBLOGTPROLOGGRUNOVART
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> obtenerAgrupacionProcesosLogisticos(Collection<Long> codigosProcesosLogisticos) throws SICException;

	/**
	 * @param procesosSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadesRegistradas(Collection<VistaProcesoLogisticoDTO> procesosSeleccionados) throws SICException;

	/**
	 * @param procesoLogisticos
	 * @param diferenciaSeleccionada
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> obtenerNovedadesRegistradas(Collection<VistaProcesoLogisticoDTO> procesoLogisticos, VistaDiferenciaFacturasRecepcionDTO diferenciaSeleccionada) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesosLogisticos
	 * @return
	 * @throws SICException
	 */
	public GrupoNovedadArticuloDTO obtenerGrupoNovedadArticulo(Integer codigoCompania, Collection<Long> codigosProcesosLogisticos) throws SICException;

	/**
	 * Retorna una coleccion de procesos logisticos con novedades registradas previamente 
	 * @param procesosSeleccionados
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaProcesoLogisticoDTO> validarAgrupacionProcesosLogisticos(Collection<VistaProcesoLogisticoDTO> procesosSeleccionados) throws SICException;

}
