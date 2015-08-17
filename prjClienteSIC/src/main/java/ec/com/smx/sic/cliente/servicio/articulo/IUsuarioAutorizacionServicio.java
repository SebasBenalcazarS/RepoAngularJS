package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;


public interface IUsuarioAutorizacionServicio {

	/**
	 * metodo para obtener una coleccion de clasificaciones segun el usuario
	 * @param clasificacionVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public  Collection<ClasificacionDTO> obtenerClasificaciones(ClasificacionVO clasificacionVO, String userId)throws SICException;
	
	/**
	 * Metodo para obtener las clasificaciones relacionadas a un usuario
	 * @param clasificacionVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerClasificacionesUsuario(ClasificacionVO clasificacionVO, String userId)throws SICException;
	
	/**
	 * Metodo para  obtener los funcionarios del local asignado al usuario de sesion
	 * @param areaTrabajo
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioAreaTrabajoDTO> consultarFuncionarioAreaTrabajoPorAreaTrabajo(AreaTrabajoDTO areaTrabajo, String userId, String usuarioSesion)throws SICException;
	
	/**
	 * metodo para obtener una coleccion de articulos segun el usuario
	 * @param articuloVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public  Map<String, Object> obtenerArticulos(ArticuloVO articuloVO, String userId)throws SICException;
	
	/**
	 * Metodo para obtener uan coleccion de articulos que estan relacionados con el usuario mensionado
	 * @param articuloVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulosUsuario(ArticuloVO articuloVO, String userId)throws SICException;
	
	/**
	 * Metodo para obtener los reportes de las clasificaciones segun los parametros ingresados
	 * @param codigoClasificacion
	 * @param codigoCompania
	 * @param usuario
	 * @param disponible
	 * @param parametro
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> repotesClasificaciones(String codigoClasificacion, Integer codigoCompania, String usuario, Boolean disponible)throws SICException;
	
	/**
	 * Metodo para obtener el reporte de clasificaciones con sus respectivos usuarios
	 * @param codigoCompania
	 * @param codigoclasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion, String user)throws SICException;
	
	/**
	 * Obtiene una coleccion de clases de articulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ClaseArticuloDTO> consultarClaseArticulos(Integer codigoCompania)throws SICException;
	
	/****************************************************************************************************************************************
	 * metodos de insercion y modificacion de la autorizacion de usuarios
	 * 
	 * **************************************************************************************************************************************
	 */
	
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
	 * Desactivación de la relacion entre usuario y clasificacion
	 * @param usuarioClasificacionProcesoDTO
	 * @throws SICException
	 */
	public void desactivarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException;
	
	/**
	 * Desactivación de la relacion entre usuario y articulo
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
	 * Metodo para intercambiarcalsificaciones entre dos usuarios
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
