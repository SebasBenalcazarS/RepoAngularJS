package ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;

public interface IUsuarioClasificacionProcesoDAO {

	/**
	 * Metodo para contar los usuarios que estan relacionados con cada clasificacion 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public ArrayList<String> obtenerClasificacionesContarUsuario(Integer codigoCompania , String parametro)throws SICException;
	
	/**
	 * Metodo para obtener el reporte de clasificaciones con sus respectivos usuarios
	 * @param codigoCompania
	 * @param codigoclasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion, String user, Integer firstResult, Integer maxResult, Boolean paginador)throws SICException;
	
	/**
	 * Metodo para actualizar la relacion del usuario y clasificacion
	 * @param usuClaDTO
	 * @throws SICException
	 */
	public void actualizarUsuarioClasificacion(UsuarioClasificacionProcesoDTO usuClaDTO)throws SICException;
	
	/**
	 * Metodo para buscar una relacion usuario clasificacion
	 * @param usuClaDTO
	 * @return
	 * @throws SICException
	 */
	public UsuarioClasificacionProcesoDTO buscarUsuarioCLasificacion(UsuarioClasificacionProcesoDTO usuClaDTO)throws SICException;
	
	/**
	 * Metodo para obtener la relacion de las clasificaciones que pertenecen a un usuario 
	 * @param codigoCompania
	 * @param usuario
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioClasificacionProcesoDTO> obtenerClasificacionesUsuario(Integer codigoCompania, String usuario)throws SICException;
	/**
	 * Metodo para obtener el numero de clasificaciones asignadas
	 * @param codigoCompania
	 * @param codigoclasificacion
	 * @param user
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public Integer cuentaClasificaciones(Integer codigoCompania, String codigoclasificacion, String user, Integer firstResult, Integer maxResult)throws SICException;
}
