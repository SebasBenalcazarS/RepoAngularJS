package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

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
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioPlanificacionBodegaDTO;
import ec.com.smx.sic.cliente.mdl.vo.CalendarioPlanificacionVO;

public interface ICalculoCalendariosBodegaGestor {
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
	public CalendarioPlanificacionVO buscarCalendarioPlanificacionDiario(Integer codigoCompania, Integer codigoAreaTrabajo,String codigoProveedor, EnumCalendarioDiaSemana diaSemana, Integer diaMes, Integer mes, Integer anio) throws SICException;
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificacion de andenes semanal	
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public CalendarioPlanificacionVO buscarCalendarioPlanificacionSemanal(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoProveedor) throws SICException;
	
	/**
	 * Este metodo devuelve la vista completa de la planificacion semanal en base a la colecci&oacute;n que recibe como parametro
	 * @param vistaCalendariosPlanificacionBodegas
	 */
	public CalendarioPlanificacionVO armarVistasCalendarioPlanificacionSemanal(List<VistaCalendarioPlanificacionBodegaDTO> vistaCalendariosPlanificacionBodegas);
	/**
	 * Este m&eacute;todo guarda el calendario de planificaci&oacute;n
	 * @param vistaCalendarioPlanificacionBodegaPlantilla
	 * @param datosCalendarioCambiadosJson
	 * @param idUsuarioAuditoria
	 * @param enumTipoConfiguracionCalendario
	 * @throws SICException
	 */
	public CalendarioPlanificacionVO guardarCalendario(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaPlantilla, String datosCalendarioCambiadosJson, String idUsuarioAuditoria, EnumTipoConfiguracionCalendario enumTipoConfiguracionCalendario, String esGuardar, Date fechaBusqueda) throws SICException;
	/**
	 * Este m&eacute;todo devuelve los datos para el excel del calendario de planificaci&oacute;n
	 * @param tipoOpcionCalendario
	 * @param datosJSon
	 * @param horaDiaMap
	 * @param horaColumnaReporte
	 * @return
	 */
	public HSSFWorkbook obtenerDatosExcel(Integer codigoCompania,String tipoExportacionExcel, Integer fechaPlanificacion, Date fechaPuntual, String tipoOpcionCalendario, String datosJSon, Map<String, String> horaDiaMap)throws SICException;
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
	public CalendarioPlanificacionVO buscarCalendarioEntregasDiarioFiltrado(Integer codigoCompania,  Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Boolean conSolicitudes) throws ParseException;
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de las entregas semanal
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
	public CalendarioPlanificacionVO buscarCalendarioEntregasSemanalFiltrado(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Integer lastId, Boolean conSolicitudes) throws ParseException;
	/**
	 * Este metodo arma las vistas en base a la colecci&oacute;n que recibe como parametro
	 * @param vistaCalendarioEntregaBodega
	 * @param autorizaAsignarAndenes
	 * @return
	 * @throws ParseException
	 */
	public CalendarioPlanificacionVO armarVistasCalendarioEntregasDiario(Collection<VistaCalendarioEntregaBodegaDTO> vistaCalendarioEntregaBodega, boolean autorizaAsignarAndenes, Integer firstResult) throws ParseException;
	/**
	 * Este metodo guarda la autorizacion desde el calendario y devuelve todo cargado nuevamente
	 * @param detallesAutorizacion
	 * @param vistaAutorizacionPadre
	 */
	public CalendarioPlanificacionVO guardarAutorizacion(Collection<VistaCalendarioEntregaBodegaDTO> detallesAutorizacion, VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre, String numeroCaso, String opcionTipo, Date fechaInicio, Date fechaFinal, Integer codigoCompania, Integer codigoAreaTrabajo, String filtroSolicitudes) throws SICException;
	
	/**
	 * Este m&eacute;todo guarda la autorizaci&oacute;n desde el calendario
	 * @param detallesAutorizacion
	 * @param vistaAutorizacionPadre
	 */
	public void guardarAutorizacion(Collection<VistaCalendarioEntregaBodegaDTO> detallesAutorizacion, VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre, String numeroCaso) throws SICException;
	
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
	 * @throws SICException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasDiarioProveedor(Integer codigoCompania,  Integer codigoAreaTrabajo, String codigoJDEProveedor, String nombreProveedor, Date fechaInicio, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize) throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve la vista completa de la planificaci&oacute;n de las entregas semanal
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoJDEProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param autorizaAsignarAndenes
	 * @param tipoFiltro
	 * @param firstResult
	 * @param pageSize
	 * @param lastId
	 * @return
	 * @throws SICException
	 */
	CalendarioPlanificacionVO buscarCalendarioEntregasSemanalProveedor(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoJDEProveedor, String nombreProveedor, Date fechaInicio, Date fechaFin, boolean autorizaAsignarAndenes, String tipoFiltro, Integer firstResult, Integer pageSize, Integer lastId) throws SICException;
	
}
