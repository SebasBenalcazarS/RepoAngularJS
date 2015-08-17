/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
//import ec.com.smx.sic.cliente.exception.SICRuleException;
/**
 * @author fmunoz
 *
 */
public interface IEstructuraComercialServicio {

	/**
	 * 
	 * @param conceptoClasificacionID
	 * @return
	 * @throws SICRuleException
	 */
	public Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID)throws SICException;
	/**
	 * Proceso para desactivar las clasificaciones de un grupo de usuarios
	 * @param usuarios
	 * @param clasificaciones
	 * @param compania
	 * @throws SICException
	 */	public void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, Integer compania) throws SICException;
	/**
	 * Proceso que permite crear o actualizar una coleccion de ClasificacionUsuarios
	 * @param clasificacionUsuarioDTO
	 */
	public void registrarUsuarioClasificacion(Collection<ClasificacionUsuarioDTO> clasificacionUsuarioDTO) throws SICException;
	/**
	 * 
	 * @param clasificacionVO
	 * @throws SICException
	 */
	public void actualizarClasificacion(ClasificacionVO clasificacionVO)throws SICException;
	/**
	 * 
	 * @param clasificacionVO
	 * @throws SICException
	 */
	public void crearClasificacion(ClasificacionVO clasificacionVO) throws SICException;
	/**
	 * 
	 * @param subClasificacionDTO
	 * @throws SICException
	 */
	public void actualizarSubClasificacion(SubClasificacionDTO subClasificacionDTO)throws SICException;
	/**
	 * 
	 * @param subClasificacionDTO
	 * @throws SICException
	 */
	public void crearSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException;
	/**
	 * 
	 * @param articulos
	 * @param subClasificacionDTO
	 * @return
	 * @throws SICException
	 */
	public ArticuloVO reclasificarArticulos(Collection<ArticuloDTO> articulos, SubClasificacionDTO subClasificacionDTO) throws SICException;
	
	/**
	 * Proceso que obtiene los compradores de una linea 
	 * comercial a la cual pertenece un usuario
	 * @param userId
	 * @return Collection<FuncionarioDTO>
	 * @throws SICException
	 */
	public Map<String, Object> obtenerCompradoresLineaComercial(String userId, Integer codigoCompania) throws SICException;
	
	/**
	 * Permite obtener las Clasificaciones
	 * por medio de un filtro 
	 * @param tipoEstructura
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerClasificaciones(String tipoEstructura, String estado) throws SICException;
	
	/**
	 * Permite obtener las Clasificaciones por liena comercial
	 * @param codigoFuncionario
	 * @param codigoProveedor
	 * @param codigoBoega
	 * @param tipoEstructura
	 * @return
	 * @throws SICException
	 */
	public ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException;
	
	/**
	 * Permite obtener las clasificaciones en base a una lista de codigos de entrada
	 * @param codigos
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerClasificaciones(Collection<String> codigos, Collection<String>codigosSubClasificacion) throws SICException;
	/**
	 * Permite obtener las subclasificaciones 
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
		@SuppressWarnings("rawtypes")
		public Collection<ClasificacionRelacionadaDTO> obtenerSubClasificacionRelacionada(String codigoClasificacion,Integer codigoCompania, String estadoClasificacionRelacionada,CriteriaSearchParameter filtroBusqueda)throws SICException;
	
	/**
	 * permite la busqueda de las clasificaciones en el arbol estructura comercial orientada al cliente
	 */
	public Collection<ClasificacionDTO> buscarArbolEOC(ClasificacionVO clafiltro)  throws SICException;
	
	/**
	 * permite buscar si la clasificacion tiene asignado
	 * clasificaciones de la estructura comercial
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ClasificacionRelacionadaDTO> buscarClasificacionesAsignadas(ClasificacionDTO clasificacionDTO) throws SICException;
	
	/**
	 * Este metodo permite cambiar el estado a inactivo a las distintas 
	 * clasificaciones asignadas de la estructura comercial
	 * @param clasificacionRelacionadaDTOs
	 * @throws SICException
	 */
	public void actualizarClasificacionesAsignadas(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs) throws SICException;
	/**
	 * Verifica si existen articulos dentro de las clasificaciones padres e hijas
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public boolean verificarArticulosClasificaciones(ClasificacionVO clasificacion) throws SICException;
	/**
	 * Verifica si la division tiene clasificaciones asignadas
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public boolean verificarClasificaciones(ClasificacionVO clasificacion)throws SICException;
	/**
	 * Verifica si existen articulos relacionados a las subclasificacion enviada como parametro
	 * @param subClasificacion
	 * @return
	 * @throws SICException
	 */
	
	public boolean verificarArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException;
	/**
	 * Obtiene la lista de las estructuras WRT de una estructura comercial
	 * @param estComercialDTO
	 * @return
	 */
	public Collection<ClasificacionDTO> obtenerEstComercialRelacionadaEstWRT(ClasificacionDTO estComercialDTO)throws SICException;
	
	/**
	 * Metodo para devolver una estructura comercial por medio de una estructura WRT
	 * @param estWRT
	 * @return clasificacionDTO
	 */
	public Collection<ClasificacionDTO> obtenerECDesdeWRT(ClasificacionDTO estWRT)throws SICException;
	
	/**
	 * Metodo para validar que existe almenos un articulo de la clasificacion dada que tenga alguno de los estados PEN, CON, AUT
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException;
	
	/**
	 * Metodo para consultar el numero de estructuras hijas
	 * @param claCol
	 */
	public Collection<ClasificacionDTO> contarHijosClasificacion(Collection<ClasificacionDTO> claCol,ClasificacionDTO claHijo,String propLista, SubClasificacionDTO subCla) throws SICException;
	
	
	public void procesoRedimensionarImagenesYEnviarPorFTP(ClasificacionArchivoDTO clasificacionArchivoDTO) throws SICException;
	
	/**
	 * Valida si existe una clasificacion que tiene igual descripcion
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException;
	/**
	 * Valida si tiene subclasificaciones con la misma descripcion
	 * @param subcla
	 * @return
	 * @throws SICException
	 */
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion( SubClasificacionDTO subcla)throws SICException;
	
	/**
	 * Obtener la clasificacion con la colecion de subclasificacion correspondiente.
	 * @author aquingaluisa
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
}
