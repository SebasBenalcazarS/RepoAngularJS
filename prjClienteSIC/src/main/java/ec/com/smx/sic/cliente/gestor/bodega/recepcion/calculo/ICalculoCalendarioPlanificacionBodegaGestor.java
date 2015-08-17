package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumCalendarioDiaSemana;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionMasivaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioPlanificacionBodegaDTO;

public interface ICalculoCalendarioPlanificacionBodegaGestor {

	Collection<VistaCalendarioPlanificacionBodegaDTO> findVistaCalendarioPlanificacionBodega(Integer codigoCompania,Integer codigoAreaTrabajo, String codigoProveedor,
			EnumCalendarioDiaSemana diaSemana,Integer diaMes, Integer mes, Integer anio)throws SICException;

	void eliminarCalendarioPlanificacionBodega(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaDTO)throws SICException;
	
	void eliminarCalendarioPlanificacionBodega(Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol)throws SICException;

	void procesarCalendarioPlanificacionBodega(Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol) throws SICException;
	
	Collection<VistaCalendarioPlanificacionBodegaDTO> procesarCalendarioPlanificacionBodega(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaDTO,Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaCol, Date fechaBusqueda) throws SICException;
	
	/**
	 * Este m&eacute;todo devuelve los datos de la autorizacion y las horas con disponibilidad de andenes en la fecha indicada
	 * @param codigoCompania
	 * @param numeroCaso
	 * @param usuarioLogueado
	 * @param codigoProveedor
	 * @param codigoBodega
	 * @return
	 */
	VistaAutorizacionCalendarioEntregaBodegaDTO findVistaAutorizacionCalendarioEntregaBodegaDTO(Integer codigoCompania, String numeroCaso, String codigoProveedor, Integer codigoAreaTrabajo, Date fechaInicio, Date fechaFin, Date fechaSeleccionada, Boolean traerCabecera, Long codigoDetalleEntregaProveedor, Long codigoHoraCalendario, Boolean contabilizarPlanificadoComoUtilizado, Boolean conSolicitudes) throws SICException;
	/**
	 * Este m&eactue;todo devuelve un objeto que tiene dos colecciones una con la disponibilidad diaria y otra con la disponibilidad por hora para un rango de fechas y una fechaSeleccionada de este rango
	 * @param codigoCompania
	 * @param numeroCaso
	 * @param usuarioLogueado
	 * @param codigoProveedor
	 * @param codigoBodega
	 * @return
	 */
	VistaAutorizacionCalendarioEntregaBodegaDTO findDisponibilidadAndenes(Integer codigoCompania, String codigoProveedor,Integer codigoAreaTrabajo, Date fechaInicio, Date fechaFin, Date fechaSeleccionada, Boolean traerCabecera, Boolean contabilizarPlanificadoComoUtilizado) throws SICException;
	/**
	 * Este metodo guarda la autorizacion desde el calendario
	 * @param horasAutorizadas
	 * @param vistaAutorizacionPadre
	 */
	Collection<VistaCalendarioEntregaBodegaDTO> guardarAutorizacion(Collection<VistaCalendarioEntregaBodegaDTO> detallesAutorizacion, VistaAutorizacionCalendarioEntregaBodegaDTO vistaAutorizacionPadre, String numeroCaso) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param frecuencia
	 * @param traerDatosSolicitud
	 * @param traerNumeroBultos
	 * @param traerAndenesAutorizados
	 * @param contabilizarPlanificadoComoUtilizado
	 * @return
	 * @throws SICException
	 */
	Collection<VistaCalendarioEntregaBodegaDTO> obtenerVistasCalendarioEntregasSumarizadoPorHoras(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, Long frecuencia, Boolean traerDatosSolicitud, Boolean traerNumeroBultos, Boolean traerAndenesAutorizados, Boolean contabilizarPlanificadoComoUtilizado, Integer firstResult, Integer pageSize, Boolean conSolicitudes)  throws SICException;
	
	/**
	 * M&eacute;todo para contar el total de registros de la vista completa de la planificaci&oacute;n de las entregas diario
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param tipoCalendario
	 * @param frecuencia
	 * @return
	 * @throws SICException
	 */
	Integer obtenerTotalProveedorCalendario (Integer codigoCompania, Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, String tipoCalendario, Long frecuencia) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param frecuencia
	 * @param traerNumeroBultos
	 * @param contabilizarPlanificadoComoUtilizado
	 * @return
	 * @throws SICException
	 */
	Collection<VistaCalendarioEntregaBodegaDTO> obtenerVistaCalendarioEntregasSumarizadoDiario(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoProveedor, Date fechaInicio, Date fechaFin, Long frecuencia, Boolean traerNumeroBultos, Boolean contabilizarPlanificadoComoUtilizado) throws SICException;
	/**
	 * Este metodo  utiliza cron para discriminar las fechas por dia en un rango de fechas y devuelve los totales, con la prioridad D/M/A por hora
	 * @param fechaInicio
	 * @param fechaFin
	 * @param frecuencia
	 * @param priorizarFechaEspecifica
	 * @param planificacionCol
	 * @return
	 * @throws SICException
	 */
	Map<Long, Map<String, Map<Long, Collection<VistaCalendarioPlanificacionBodegaDTO>>>> obtenerVistaCalendarioEntregasPorHora(Date fechaInicio, Date fechaFin,Long frecuencia,boolean priorizarFechaEspecifica,Collection<VistaCalendarioPlanificacionBodegaDTO> planificacionCol,Boolean ordenenDiario) throws SICException ;
	/**
	 * Este metodo  utiliza cron para discriminar las fechas por dia en un rango de fechas y devuelve los totales, con la prioridad D/M/A por dia
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoProveedor
	 * @param fechaInicio
	 * @param fechaFin
	 * @param frecuencia
	 * @param traerNumeroBultos
	 * @return
	 * @throws SICException
	 */
	Map<Long, Map<String, Collection<VistaCalendarioPlanificacionBodegaDTO>>> obtenerVistaCalendarioEntregasPorDia(Date fechaInicio, Date fechaFin, Long frecuencia,boolean priorizarFechaEspecifica,Collection<VistaCalendarioPlanificacionBodegaDTO> planificacionCol) throws SICException;
	
	/**
	 * Metodo que  devuelve el tipo de consulta que se debe  realizar, para saber de que vista debe consulta resultado (BOD,SBO,CD,MB)
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	Map<String, CaracteristicaProcesoAreaTrabajoDTO> findTipoVisualizacionCalendario(Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * M&eacute;todo que devuelve las autorizaciones pendientes por area de trabajo
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 * @throws Exception
	 */
	Collection<VistaAutorizacionMasivaDTO> findAutorizacionesPendientes(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * M&eacute;todo que devuelven todas las autorizaciones pendientes en todas las areas de trabajo del usuario
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 * @throws Exception
	 */
	Collection<VistaAutorizacionMasivaDTO> findTodasLasAutorizacionesPendientes(Integer codigoCompania, Integer ... colCodigoAreaTrabajo) throws SICException;
}