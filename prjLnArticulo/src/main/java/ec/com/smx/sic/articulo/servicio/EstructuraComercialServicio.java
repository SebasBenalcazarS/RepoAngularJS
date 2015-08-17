package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.sic.articulo.gestor.estructuracomercial.EstructuraComercialGestor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.IEstructuraComercialGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
import ec.com.smx.sic.cliente.servicio.articulo.IEstructuraComercialServicio;

public class EstructuraComercialServicio implements IEstructuraComercialServicio {

	private IEstructuraComercialGestor estructuraComercialGestor;
	
	public void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, Integer compania)	throws SICException {
		this.estructuraComercialGestor.desactivarEstadoPorClasificacionUsuario(usuarios, clasificaciones, compania);
	}

	
	public Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID) throws SICException {
		return this.estructuraComercialGestor.esActivoConceptoClasificacion(conceptoClasificacionID);
	}

	public void registrarUsuarioClasificacion(Collection<ClasificacionUsuarioDTO> clasificacionUsuarioDTO) throws SICException {
		this.estructuraComercialGestor.registrarUsuarioClasificacion(clasificacionUsuarioDTO);
	}

	public void actualizarClasificacion(ClasificacionVO clasificacionVO) throws SICException {
		this.estructuraComercialGestor.actualizarClasificacion(clasificacionVO);

	}

	public void crearClasificacion(ClasificacionVO clasificacionVO) throws SICException {
		this.estructuraComercialGestor.crearClasificacion(clasificacionVO);
	}

	public void setEstructuraComercialGestor(
			EstructuraComercialGestor estructuraComercialGestor) {
		this.estructuraComercialGestor = estructuraComercialGestor;
	}

	@Override
	public void actualizarSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException {
		this.estructuraComercialGestor.actualizarSubClasificacion(subClasificacionDTO);
	}

	@Override
	public void crearSubClasificacion(SubClasificacionDTO subClasificacionDTO) throws SICException {
		this.estructuraComercialGestor.crearSubClasificacion(subClasificacionDTO);
	}
	
	public ArticuloVO reclasificarArticulos(Collection<ArticuloDTO> articulos, SubClasificacionDTO subClasificacionDTO) throws SICException{
		return this.estructuraComercialGestor.reclasificarArticulos(articulos,subClasificacionDTO);
	}


	public Map<String, Object> obtenerCompradoresLineaComercial(String userId, Integer codigoCompania) throws SICException {
		return this.estructuraComercialGestor.obtenerCompradoresLineaComercial(userId, codigoCompania);
	}
	
	public Collection<ClasificacionDTO> obtenerClasificaciones(String tipoEstructura, String estado) throws SICException{
		return this.estructuraComercialGestor.obtenerClasificaciones(tipoEstructura, estado);
	}
	
	public ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException{
		return this.estructuraComercialGestor.obtenerClasificacionesLineaComercial(codigoCompania, codigoFuncionario, codigoProveedor, codigoBodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial);
	}
	
	public Collection<ClasificacionDTO> obtenerClasificaciones(Collection<String> codigos, Collection<String>codigosSubClasificacion) throws SICException{
		return this.estructuraComercialGestor.obtenerClasificaciones(codigos, codigosSubClasificacion);
	}
	@SuppressWarnings("rawtypes")
	public Collection<ClasificacionRelacionadaDTO> obtenerSubClasificacionRelacionada(String codigoClasificacion,Integer codigoCompania, String estadoClasificacionRelacionada, CriteriaSearchParameter filtroBusqueda)throws SICException{
		return this.estructuraComercialGestor.obtenerSubClasificacionRelacionada(codigoClasificacion, codigoCompania,  estadoClasificacionRelacionada, filtroBusqueda);
	}
	
	public Collection<ClasificacionDTO> buscarArbolEOC(ClasificacionVO clafiltro) throws SICException{
		return this.estructuraComercialGestor.buscarArbolEOC(clafiltro);
	}
	
	public Collection<ClasificacionRelacionadaDTO> buscarClasificacionesAsignadas(ClasificacionDTO clasificacionDTO) throws SICException{
		return this.estructuraComercialGestor.buscarClasificacionesAsignadas(clasificacionDTO);
	}
	
	public void actualizarClasificacionesAsignadas(Collection<ClasificacionRelacionadaDTO> clasificacionRelacionadaDTOs)throws SICException{
		this.estructuraComercialGestor.actualizarClasificacionesAsignadas(clasificacionRelacionadaDTOs);
	}
	@Override
	public boolean verificarArticulosClasificaciones(ClasificacionVO clasificacion) throws SICException{
		return this.estructuraComercialGestor.verificarArticulosClasificaciones(clasificacion);
	}
	@Override
	public boolean verificarClasificaciones(ClasificacionVO clasificacion)throws SICException{
		return this.estructuraComercialGestor.verificarClasificaciones(clasificacion);
	}
	@Override
	public boolean verificarArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException{
		return this.estructuraComercialGestor.verificarArticulosSubClasificaciones(subClasificacion);
	}
	@Override
	public Collection<ClasificacionDTO> obtenerEstComercialRelacionadaEstWRT(ClasificacionDTO estComercialDTO)throws SICException{
		return this.estructuraComercialGestor.obtenerEstComercialRelacionadaEstWRT(estComercialDTO);
	}
	@Override
	public Collection<ClasificacionDTO> obtenerECDesdeWRT(ClasificacionDTO estWRT)throws SICException{
		return this.estructuraComercialGestor.obtenerECDesdeWRT(estWRT);
	}
	@Override
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException{
		return this.estructuraComercialGestor.existeArticuloUnificarCosto(clasificacionDTO);
	}
	
	@Override
	public Collection<ClasificacionDTO> contarHijosClasificacion(Collection<ClasificacionDTO> claCol,ClasificacionDTO claHijo,String propLista, SubClasificacionDTO subCla) throws SICException{
		return this.estructuraComercialGestor.contarHijosClasificacion(claCol, claHijo, propLista, subCla);
	}
	
	public void procesoRedimensionarImagenesYEnviarPorFTP(ClasificacionArchivoDTO clasificacionArchivoDTO) throws SICException{
		this.estructuraComercialGestor.procesoRedimensionarImagenesYEnviarPorFTP(clasificacionArchivoDTO);
	}
	
	@Override
	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException{
		return this.estructuraComercialGestor.validarDescripcionClasificacion(clasificacion);
	}
	@Override
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion( SubClasificacionDTO subcla)throws SICException{
		return this.estructuraComercialGestor.validarDescripcionSubclasificacion(subcla);
	}
	
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
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesConSubClasificion(Integer codigoCompania,String codigoClasificacion,String codigoBodega,String codigoProveedor) throws SICException{
		return this.estructuraComercialGestor.obtenerClasificacionesConSubClasificion(codigoCompania, codigoClasificacion, codigoBodega, codigoProveedor);
	}
	
	/**
	 * Obtener la  subclasificacion especifica por codigoClasificacion, y subclasificacion
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @param codigoSubClasificacion
	 * @return
	 * @throws SICException
	 */
	@Override
	public SubClasificacionDTO  obtenerSubClasificacionDTO(Integer codigoCompania,String codigoClasificacion,String codigoSubClasificacion) throws SICException{
		return this.estructuraComercialGestor.obtenerSubClasificacionDTO(codigoCompania, codigoClasificacion, codigoSubClasificacion);
	}
}
