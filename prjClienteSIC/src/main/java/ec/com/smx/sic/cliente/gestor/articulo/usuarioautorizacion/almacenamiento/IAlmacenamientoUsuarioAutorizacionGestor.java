package ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;

/**
 * 
 * @author cortiz
 *
 */
public interface IAlmacenamientoUsuarioAutorizacionGestor {

	/**
	 * Creacion de la relacion entre usuario y clasificacion
	 * @param usuarioClasificacionProcesoDTO
	 * @throws SICException
	 */
	public void guardarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException;
	
	/**
	 * Creacion de la relacion entre usuario y clasificacion
	 * @param usuarioArticuloDTO
	 * @throws SICException
	 */
	public void guardarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException;
	
	/**
	 * Desactivacion de la relacion entre usuario y clasificacion de artículos
	 * @param usuarioClasificacionProcesoDTO
	 * @throws SICException
	 */
	public void desactivarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException;
	
	/**
	 * Desactivacion de la relacion entre usuario y artículos
	 * @param UsuarioArticuloDTO
	 * @throws SICException
	 */
	public void desactivarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException;

	/**
	 * Metodo para inactivar las clasificaciones de un funcionario
	 * @param usuario
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void inactivarClasificacionesFuncionario(String usuario, Integer codigoCompania)throws SICException;
	
	/**
	 * Intercambia las clasificaciones asignadas entre dos usuarios
	 * @param codigoCompania
	 * @param usuario1
	 * @param usuario2
	 * @param calsificaciones
	 * @throws SICException
	 */
	public void intercambiarClasificacionesFuncionario(Integer codigoCompania, String usuario1, String usuario2 , Collection<UsuarioClasificacionProcesoDTO> calsificaciones)throws SICException;
	/**
	 * Intercambia las clasificaciones asignadas entre dos usuarios
	 * @param calsificaciones
	 * @param usuario
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void reemplazarClasificacionesFuncionario( Collection<UsuarioClasificacionProcesoDTO> calsificaciones, String usuario, Integer codigoCompania)throws SICException;
}
