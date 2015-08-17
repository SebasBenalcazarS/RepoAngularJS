package ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.calculo;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;

public interface ICalculoUsuarioAutorizacionGestor {

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
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion,String user)throws SICException;
	
	/**
	 * Obtiene una coleccion de clases de articulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ClaseArticuloDTO> consultarClaseArticulos(Integer codigoCompania)throws SICException;
}
