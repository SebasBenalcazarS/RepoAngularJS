package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;

public interface IAsignacionAutomaticaFuncionarioTareaServicio {
	
	/**
	 * Permite la asignaci&oacute;n de funcionarios con perfil de recibidor disponibles a tareas en estado Registrado
	 * @param codigoCompania
	 * @param codigoCd
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param codigoPerfil
	 * @throws SICException
	 */
	public void transAsignacionAutomaticaFuncionarioTarea(Integer codigoCompania, Integer codigoCd, Integer codigoBodega, Integer codigoSubBodega, Long codigoPerfil) throws SICException;
	
	/**
	 * Retorna funcionarios con perfil de recibidor disponibles
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFuncionarioPerfilDTO> transObtenerFuncionariosDisponibles(Integer codigoCompania,Integer areaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;
	
	/**
	 * Retorna una lista con todos los funcionarios recibidores, tambi&eacute;n identifica cuales est&aacute;n ocupados
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecibidorRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;
	
}