package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Date;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

public interface IValidacionRecepcionProveedorGestorScanner {

	/**
	 * Validacion de los campos obligatorios para obtener las tareas pendientes del recibidor
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param funcionarioPerfilDTO
	 * @param fechaTarea
	 * @throws SICException
	 */
	void obtenerTareasPendienteRecibidor(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Date fechaTarea) throws SICException;
	
	
	/**
	 * Validacion de campos obligatorios para obtener el anden por bodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param Identificador
	 * @throws SICException
	 */
	void obtenerAndenPorBodega(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador) throws SICException;
	
	/**
	 * Validar datos para obtener el resumen de ordenes de compra de recepcion
	 * @param tareaRecepcion
	 */
	void validarObtenerDatosRecepionProveedorArticulo(TareaDTO tareaRecepcion);
}