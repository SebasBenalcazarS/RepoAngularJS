package ec.com.smx.sic.cliente.servicio.bodega;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ec.com.smx.sic.cliente.common.bodega.EnumCalendarioDiaSemana;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoConfiguracionCalendario;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionMasivaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioPlanificacionBodegaDTO;
import ec.com.smx.sic.cliente.mdl.vo.CalendarioPlanificacionVO;

/**
 * @author cbarahona
 * 
 */
public interface ICalendarioPlanificacionBodegaServicio {

	void transEliminarCalendarioPlanificacionBodega(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaDTO)throws SICException;
	
	void transEliminarCalendarioPlanificacionBodega(Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol)throws SICException;
	
	void transProcesarCalendarioPlanificacionBodega(Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol) throws SICException,Exception;
	
	Collection<VistaCalendarioPlanificacionBodegaDTO> transProcesarCalendarioPlanificacionBodega(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaPlantilla,Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol) throws SICException,Exception;
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de andenes diaria.
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param diaSemana
	 * @param diaMes
	 * @param mes
	 * @param anio
	 * @return
	 * @throws SICException
	 */
	CalendarioPlanificacionVO buscarCalendarioPlanificacionDiario(Integer codigoCompania, Integer codigoAreaTrabajo,String codigoProveedor, EnumCalendarioDiaSemana diaSemana, Integer diaMes, Integer mes, Integer anio) throws SICException;
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de andenes semanal	
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	CalendarioPlanificacionVO buscarCalendarioPlanificacionSemanal(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoProveedor) throws SICException;
	/**
	 * Este metodo devuelve la vista completa de la planificacion semanal en base a la colecci&eacute;n que recibe como parametro
	 * @param vistaCalendariosPlanificacionBodegas
	 */
	CalendarioPlanificacionVO transArmarVistasCalendarioPlanificacionSemanal(List<VistaCalendarioPlanificacionBodegaDTO> vistaCalendariosPlanificacionBodegas);
	/**
	 * Este m&eacute;todo guarda el calendario de planificaci&oacute;n
	 * @param vistaCalendarioPlanificacionBodegaPlantilla
	 * @param datosCalendarioCambiadosJson
	 * @param idUsuarioAuditoria
	 * @param enumTipoConfiguracionCalendario
	 * @throws SICException
	 */
	CalendarioPlanificacionVO transGuardarCalendario(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaPlantilla, String datosCalendarioCambiadosJson, String idUsuarioAuditoria, EnumTipoConfiguracionCalendario enumTipoConfiguracionCalendario, String esGuardar, Date fechaBusqueda) throws SICException;
	/**
	 * Este m&eacute;todo devuelve los datos para el excel del calendario de planificaci&oacute;n
	 * @param tipoOpcionCalendario
	 * @param datosJSon
	 * @param horaDiaMap
	 * @param horaColumnaReporte
	 * @return
	 */
	HSSFWorkbook obteneReporteCalendarioPlanificacion(Integer codigoCompania,String tipoExportacionExcel, Integer fechaPlanificacion, Date fechaPuntual, String tipoOpcionCalendario, String datosJSon, Map<String, String> horaDiaMap)throws SICException;
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de las entregas diario
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @param conSolicitudes
	 * @return
	 * @throws ParseException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasDiarioFiltrado(Integer codigoCompania,  Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Boolean conSolicitudes) throws ParseException;
	
	/**
	 * M&eacute;todo para contar el total de proveedores que se van a mostrar en el calendario de planificaci&oacute;n de entregas de la bodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param tipoCalendario
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @return
	 * @throws SICException
	 */
	Integer obtenerTotalProveedorCalendario(Integer codigoCompania,  Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, String tipoCalendario, boolean autorizaAsignarAndenes, String tipoFiltro) throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&eacute;n de las entregas semanal
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @return
	 * @throws ParseException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasSemanalFiltrado(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Integer lastId, Boolean conSolicitudes) throws ParseException;
	/**
	 * Este metodo arma las vistas en base a la colecci&oacute;n que recibe como parametro
	 * @param vistaCalendarioEntregaBodega
	 * @param autorizaAsignarAndenes
	 * @return
	 * @throws ParseException
	 */
	CalendarioPlanificacionVO transArmarVistasCalendarioEntregasDiario(List<VistaCalendarioEntregaBodegaDTO> vistaCalendarioEntregaBodega, boolean autorizaAsignarAndenes) throws ParseException;

	VistaAutorizacionCalendarioEntregaBodegaDTO findVistaAutorizacionCalendarioEntregaBodegaDTO(Integer codigoCompania, String numeroCaso, String codigoProveedor, Integer codigoAreaTrabajo, Date fechaInicio, Date fechaFin, Date fechaSeleccionada, Boolean traerCabecera, Long codigoDetalleEntregaProveedor, Long codigoHoraCalendario, Boolean contabilizarPlanificadoComoUtilizado)throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve un objeto que tiene dos colecciones una con la disponibilidad diaria y otra con la disponibilidad por hora para un rango de fechas y una fechaSeleccionada de este rango
	 * @param codigoCompania
	 * @param numeroCaso
	 * @param usuarioLogueado
	 * @param codigoProveedor
	 * @param codigoBodega
	 * @return
	 */
	VistaAutorizacionCalendarioEntregaBodegaDTO findDisponibilidadAndenes(Integer codigoCompania, String codigoProveedor,Integer codigoAreaTrabajo, Date fechaInicio, Date fechaFin, Date fechaSeleccionada, Boolean traerCabecera, Boolean contabilizarPlanificadoComoUtilizado) throws SICException;
	/**
	 * Este metodo guarda la autorizacion desde el calendario y devuelve todo cargado nuevamente
	 * @param detallesAutorizacion
	 * @param vistaAutorizacionPadre
	 */
	CalendarioPlanificacionVO transGuardarAutorizacion(Collection<VistaCalendarioEntregaBodegaDTO> detallesAutorizacion, VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre, String numeroCaso, String opcionTipo, Date fechaInicio, Date fechaFinal, Integer codigoCompania, Integer codigoAreaTrabajo, String filtroSolicitudes) throws SICException;
	
	/**
	 *  Metodo que devuelve las autorizaciones pendientes
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 * @throws Exception
	 */
	Collection<VistaAutorizacionMasivaDTO> findAutorizacionesPendientes(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 *  Metodo que devuelve las autorizaciones pendientes en todas las bodegas
	 * @param codigoCompania
	 * @param coleccion area trabajo a obtener las autorizaciones pendientes
	 * @return
	 * @throws SICException
	 * @throws Exception
	 */
	Collection<VistaAutorizacionMasivaDTO> findTodasLasAutorizacionesPendientes(Integer codigoCompania, Integer... colCodigoAreaTrabajo) throws SICException;
	
	/**
	 * M&eacute;todo para almacenar una autorizaci&oacute;n
	 * @param detallesAutorizacion
	 * @param vistaAutorizacionPadre
	 * @param numeroCaso
	 */
	void transGuardarAutorizacion(Collection<VistaCalendarioEntregaBodegaDTO> detallesAutorizacion, VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre, String numeroCaso) throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de las entregas diario por proveedor 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoJDEProveedor
	 * @param nombreProveedor
	 * @param fechaInicio
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws ParseException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasDiarioProveedor(Integer codigoCompania,  Integer codigoAreaTrabajo, String codigoJDEProveedor, String nombreProveedor, Date fechaInicio, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize) throws SICException;
	
	/**
	 *Este m&eacute;todo devuelve la vista completa de la planificaci&eacute;n de las entregas semanal por proveedor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoJDEProveedor
	 * @param nombreProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @param firstResult
	 * @param pageSize
	 * @param lastId
	 * @return
	 * @throws ParseException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasSemanalProveedor(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoJDEProveedor, String nombreProveedor, Date fechaInicio, Date fechaFin, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Integer lastId) throws SICException;
	
}
