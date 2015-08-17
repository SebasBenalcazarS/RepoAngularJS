package ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;

public interface IEstructuraComercialGestor {

	public Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID)throws SICRuleException;

	public void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, Integer compania) throws SICException;

	public void registrarUsuarioClasificacion(Collection<ClasificacionUsuarioDTO> clasificacionUsuarioDTO) throws SICException;
	
	public void actualizarClasificacion(ClasificacionVO clasificacionVO)throws SICException;

	public void crearClasificacion(ClasificacionVO clasificacionVO) throws SICException;

	public void actualizarSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException;

	public void crearSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException;
	
	public ArticuloVO reclasificarArticulos(Collection<ArticuloDTO> articulos, SubClasificacionDTO subClasificacionDTO) throws SICException;
	
	public Map<String, Object> obtenerCompradoresLineaComercial(String userId, Integer codigoCompania) throws SICException;	
	
	public Collection<ClasificacionDTO> obtenerClasificaciones(String tipoEstructura, String estado) throws SICException;
	
	public ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException;
	
	public Collection<ClasificacionDTO> obtenerClasificaciones(Collection<String> codigos, Collection<String>codigosSubClasificacion) throws SICException;
	
	@SuppressWarnings("rawtypes")
	public Collection<ClasificacionRelacionadaDTO> obtenerSubClasificacionRelacionada(String codigoClasificacion,Integer codigoCompania, String estadoClasificacionRelacionada, CriteriaSearchParameter filtroBusqueda )throws SICException;
	
	public Collection<ClasificacionDTO> buscarArbolEOC(ClasificacionVO clafiltro) throws SICException;
	
	public Collection<ClasificacionRelacionadaDTO> buscarClasificacionesAsignadas(ClasificacionDTO clasificacionDTO) throws SICException;
	
	public void actualizarClasificacionesAsignadas(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs) throws SICException;
	
	public boolean verificarArticulosClasificaciones(ClasificacionVO clasificacion) throws SICException;
	
	public boolean verificarClasificaciones(ClasificacionVO clasificacion)throws SICException;
	
	public boolean verificarArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException;

	public Collection<ClasificacionDTO> obtenerEstComercialRelacionadaEstWRT(ClasificacionDTO estComercialDTO)throws SICException;

	public Collection<ClasificacionDTO> obtenerECDesdeWRT(ClasificacionDTO estWRT)throws SICException;
	
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException;
	
	public Collection<ClasificacionDTO> contarHijosClasificacion(Collection<ClasificacionDTO> claCol,ClasificacionDTO claHijo,String propLista, SubClasificacionDTO subCla) throws SICException;
	
	public void procesoRedimensionarImagenesYEnviarPorFTP(ClasificacionArchivoDTO clasificacionArchivoDTO) throws SICException;

	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException;
	
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion(SubClasificacionDTO subcla)throws SICException;
	
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
