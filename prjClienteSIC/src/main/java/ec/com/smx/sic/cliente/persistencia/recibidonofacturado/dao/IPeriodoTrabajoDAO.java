package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PeriodoTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RangoAccionPeriodoDTO;

public interface IPeriodoTrabajoDAO {

	/**
	 * Permite obetener el rango de accion del periodo actual
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	RangoAccionPeriodoDTO obtenerRangoAccionPeriodoActual(Integer codigoCompania)throws SICException;
	
	/**
	 * Permite obtener el periodo actual de trabajo
	 * @param codigoCompania
	 * @param obtenerRangoAccion
	 * @return
	 * @throws SICException
	 */
	PeriodoTrabajoDTO obtenerPeriodoTrabajoActual(Integer codigoCompania, Boolean obtenerRangoAccion)throws SICException;
	
	/**
	 * Permite registrar el nuevo periodo de trabajo en base al periodo actual si posee
	 * @param codigoCompania
	 * @param codigoUsuario
	 * @param periodoTrabajoDTO
	 * @throws SICException
	 */
	void registrarPeriodoTrabajo(Integer codigoCompania, String codigoUsuario, PeriodoTrabajoDTO periodoTrabajoDTO)throws SICException;
}
