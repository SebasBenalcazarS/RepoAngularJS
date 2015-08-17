package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;

public interface IConfigAsignacionAutomaticaTareasRecibidorGestor {

	/**
	 * Permite la asignaci&oacute;n de funcionarios con perfil de recibidor disponibles a tareas en estado Registrado
	 * @param codigoCompania
	 * @param codigoCd
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param codigoPerfil
	 * @throws SICException
	 */
	public void asignarTareasFuncionario(Integer codigoCompania, Integer codigoCd, Integer codigoBodega, Integer codigoSubBodega, Long codigoPerfil) throws SICException;
	
	/**
	 * Retorna funcionarios con perfil de recibidor disponibles
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecepcionDisponibles(Integer codigoCompania,Integer areaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;
	
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
