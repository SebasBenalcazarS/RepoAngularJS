package ec.com.smx.sic.cliente.persistencia.articulos.dao.estructuracomercial;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;

public interface IClasificacionDAO {

	/**
	 * Metodo para la busqueda de clasificaciones que no esten asignadas al usuario ingresado
	 * @param areaTrabajoVO
	 * @return
	 */
	public  Collection<ClasificacionDTO> obtenerClasificaciones(ClasificacionVO clasificacionVO, String userId, Boolean paginador)throws SICException;
	
	/**
	 * Metodo para contar las clasificaciones que no esten asignadas al usuario ingresado
	 * @param clasificacionVO
	 * @param userId
	 * @param paginador
	 * @return
	 * @throws SICException
	 */
	public  Integer cuentaClasificaciones(ClasificacionVO clasificacionVO, String userId)throws SICException;
	
	/**
	 * Metodo para obtener las clasificaciones relacionadas a un usuario
	 * @param clasificacionVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerClasificacionesUsuario(ClasificacionVO clasificacionVO, String userId)throws SICException;
	
	
	
	/**
	 * Obtener la clasificacion con la colecion de subclasificacion correspondiente.
	 * @param codigoCompania
	 * @param codigoClasificacion en el caso de no traer este dato trae todas las clasificaciones
	 * @param codigoBodega
	 * @param codigoProveedor 
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerClasificacionesConSubClasificion(Integer codigoCompania,String codigoClasificacion,String codigoBodega,String codigoProveedor) throws SICException;
	
	/**
	 * Obtener la  subclasificacion especifica por codigoClasificacion, y subclasificacion
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param codigoSubClasificacion
	 * @return
	 * @throws SICException
	 */
	public SubClasificacionDTO  obtenerSubClasificacionDTO(Integer codigoCompania,String codigoClasificacion,String codigoSubClasificacion) throws SICException;
	
	/**
	 * Metodo para obtener los reportes de las clasificaciones segun los parametros ingresados
	 * @param clasificacionVO
	 * @param codigoClasificacion
	 * @param codigoCompania
	 * @param usuario
	 * @param disponible
	 * @param parametro
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> repotesClasificaciones(ClasificacionVO clasificacionVO, String codigoClasificacion, Integer codigoCompania, String usuario, Boolean disponible, String parametro)throws SICException;

	
}
