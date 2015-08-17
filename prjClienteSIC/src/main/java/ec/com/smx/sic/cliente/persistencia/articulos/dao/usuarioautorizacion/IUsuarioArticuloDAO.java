package ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IUsuarioArticuloDAO {

	/**
	 * Metodo para la busqueda de articulos que no estan asignados al usuario ingresado, ni asignados a una clasificacion que pertenezca al usuario
	 * @param areaTrabajoVO
	 * @return
	 */
	public  Collection<ArticuloDTO> obtenerArticulos(ArticuloVO articuloVO, String userId, Boolean paginador, Collection<String> codigoArticulosCol, Collection<String> codigoClasificacionAsignadasCol)throws SICException;
	
	/**
	 * Metodo para contar los articulos que no estan asignados al usuario ingresado, ni asignados a una clasificacion que pertenezca al usuario
	 * @param articuloVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public  Integer cuentaArticulos(ArticuloVO articuloVO, String userId,Collection<String> codigoArticulosCol,Collection<String> codigoClasificacionAsignadasCol)throws SICException;
	
	/**
	 * Metodo que obtiene los articulos relacionados al usuario ingresado
	 * @param articuloVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulosUsuario(ArticuloVO articuloVO, String userId)throws SICException;
	
	/**
	 * Metodo para actualizar la relacion del usuario y clasificacion
	 * @param usuArtDTO
	 * @throws SICException
	 */
	public void actualizarUsuarioArticulo(UsuarioArticuloDTO usuArtDTO)throws SICException;
	
	/**
	 * * Metodo para buscar una relacion usuario clasificacion
	 * @param usuArtDTO
	 * @return
	 * @throws SICException
	 */
	public UsuarioArticuloDTO buscarUsuarioArticulo(UsuarioArticuloDTO usuArtDTO)throws SICException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<String> consultarCodigosArticulosAsignados(String userId)throws SICException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<String> consultarCodigosClasificacionesAsignados(String userId)throws SICException;
}
