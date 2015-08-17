package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.sql.Time;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;

public interface IAlmacenamientoCalendarioGestor {
	public void guardarDetalleCalendarioDTO(DetalleCalendarioDTO detalleCalendario);
	public void actualizarDetalleCalendario(DetalleCalendarioDTO detalleCalendario);
	/**
	 * Metodo para crear o actualizar un calendario
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoAreaTrabajo
	 * @param diaSemana
	 * @param diaMes
	 * @param mes
	 * @param anio
	 * @param usuarioId
	 * @param horaInicio
	 * @param cantidadAndenes
	 * @param codigoHoraCalendario
	 * @param calendarioPlanificacion (Parametro que depende  si se busca una planificacion o se crea una autorizacion)
	 * @return
	 * @throws SICException
	 */
	public HoraCalendarioDTO crearActualizarCalendario(Integer codigoCompania, String codigoProveedor, Integer codigoAreaTrabajo, Integer diaSemana, Integer diaMes, Integer mes, Integer anio, String usuarioId, Time horaInicio, Integer cantidadAndenes, Long codigoHoraCalendario, Boolean calendarioPlanificacion)throws SICException,Exception;
	/**
	 * En este metodo se recibe como parametro la coleccion de detallesCalendario que se escogio desde la pantalla de entregas, aqui valido si esta coleccion es una plantilla es decir 
	 * no tiene una fecha especifica entonces yo creo una nuevo calendario identico al que viene representado en cada elmento de la coleccion que se recibe como parametro
	 * y este lo devuelvo para que sea atado a la entrega y la original se queda como plantilla.
	 * @param detalleEntregas
	 * @return
	 */
	public Collection<VistaCalendarioEntregaBodegaDTO> guardarPlantillaCalendarioEntregas(Collection<VistaCalendarioEntregaBodegaDTO> detalleEntregas)throws SICException,Exception;
}
