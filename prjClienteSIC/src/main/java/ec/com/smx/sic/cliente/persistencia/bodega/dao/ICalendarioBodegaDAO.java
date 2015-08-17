package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Time;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;

public interface ICalendarioBodegaDAO {
	/**
	 * Metodo que obtiene  el objeto horacalendario planificado, filtra de la tabla horacalendarioAutorizacion
	 * @param compania
	 * @param codigoAreaTrabajo
	 * @param codigoCalendario
	 * @param horaInicio
	 * @return
	 * @throws SICException
	 */
	public abstract HoraCalendarioDTO obtenerHoraCalendarioPlanificada(Integer compania,Integer codigoAreaTrabajo, Long codigoCalendario,Time horaInicio) throws SICException;
	
	
	public abstract CalendarioDTO obtenerCalendarioPlanificada(Integer compania,String codigoProveedor,Integer diaSemana, Integer diaMes, Integer mes, Integer anio,Time horaInicio, Integer codigoAreaTrabajo) throws SICException,Exception;
	
	

}
