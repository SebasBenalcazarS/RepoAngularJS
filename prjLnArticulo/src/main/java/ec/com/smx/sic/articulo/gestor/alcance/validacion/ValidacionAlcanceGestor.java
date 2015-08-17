package ec.com.smx.sic.articulo.gestor.alcance.validacion;

import java.sql.Timestamp;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.validacion.IValidacionAlcanceGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author dalmeida
 *
 */
public class ValidacionAlcanceGestor implements IValidacionAlcanceGestor {

	/**
	 * Metodo para validar los datos en la creacion del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	@Override
	public void crearGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoCol) throws SICException {
		if(grupoTrabajoDTO == null){
			throw new SICException("No existen datos en grupoTrabajoDTO");
		}
		if(grupoTrabajoDTO.getId().getCodigoCompania() == null){
			throw new SICException("El c\u00F3digo de compania se encuentra vacio");
		}
		if(grupoTrabajoDTO.getUserId() == null){
			throw new SICException("El userId se encuentra vacio.");
		}	
		if(CollectionUtils.isEmpty(areaTrabajoCol)){
			throw new SICException("Las \u00E1reas de trabajo est\u00E1n vacias");
		}
	}
	/**
	 * Metodo para validar los datos en la actualizacion del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */
	@Override
	public void actualizarGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO,Timestamp fechaAplicacion,Collection<GrupoAreaTrabajoDTO> areasAsignar, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Collection<GrupoAreaTrabajoDTO> areasActivar) throws SICException {
		if(grupoTrabajoDTO == null){
			throw new SICException("No existen datos en grupoTrabajoDTO");
		}
		if(fechaAplicacion==null){
			throw new SICException("La fecha aplicacion se encuentra vacia");
		}
		if(grupoTrabajoDTO.getId().getCodigoCompania() == null){
			throw new SICException("El c\u00F3digo de compania se encuentra vacio");
		}
		if(grupoTrabajoDTO.getUserId() == null){
			throw new SICException("El userId de grupoTrabajoDTO se encuentra vacio.");
		}
//		if(CollectionUtils.isEmpty(areasAsignar)
//				&& CollectionUtils.isEmpty(areasDesactivar)
//				&& CollectionUtils.isEmpty(areasActivar)
//				&& grupoTrabajoDTO.getEstadoGrupoTrabajo().equals(CorporativoConstantes.ESTADO_ACTIVO)){
//			throw new SICException("Las \u00E1reas de trabajo estan vacias");
//		}
	}
	
	/**
	 * Metodo para validar los datos en la copia de local
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override
	public void copiarLocal(ArticuloVO articuloVO) throws SICException{
		if(articuloVO.getCodigoLocalBase() == null){
			throw new SICException("El codigoLocalBase se encuentra vacio");
		}
		if(articuloVO.getCodigoLocalAsignar() == null){
			throw new SICException("El codigoLocalAsignar se encuentra vacio");
		}
		if(articuloVO.getUserId() == null){
			throw new SICException("El usuarioId se encuentra vacio");
		}	
		if(articuloVO.getBaseDTO().getId().getCodigoCompania() == null){
			throw new SICException("El c\u00F3digo de compania se encuentra vacio");
		}	
	}
	
	/**
	 * Permite obtener el numero de articulos seleccionados por filtros de subbodega, proveedor, clasificacion y articulos
	 * @param codigosSubbodega
	 * @param codigosProveedor
	 * @param codigosClasificacion
	 * @param codigosArticulos
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	@Override
	public void contarArticulosPorFiltro(Collection<String> codigosSubbodega, Collection<String> codigosProveedor, 
			Collection<String> codigosClasificacion, Collection<String> codigosArticulos,String codigoCompania) throws SICException{
		if(CollectionUtils.isEmpty(codigosSubbodega) && CollectionUtils.isEmpty(codigosProveedor) && CollectionUtils.isEmpty(codigosClasificacion)
				&& CollectionUtils.isEmpty(codigosArticulos)){
			throw new SICException("Todas las listas se encuentran vacias, no se puede realizar la consulta");
		}
		
		if(codigoCompania == null){
			throw new SICException("El c\u00F3digo de compania se encuentra vacio");
		}	
	}
	
	/**
	 * Permite asignar masivamente articulos a los locales
	 * @param articuloFiltro
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	@Override
	public void asignacionMasivaArticulos(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException{
		if(articuloFiltro==null){
			throw new SICException("La plantilla articuloFiltro se encuentra vacio");
		}
		if(plantillaFiltrosBusqueda==null){
			throw new SICException("La plantilla plantillaFiltrosBusqueda se encuentra vacio");
		}
		if(CollectionUtils.isEmpty(articuloFiltro.getLocales())){
			throw new SICException("Las areas de trabajo de grupo de alcance se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloFiltro.getUsuarioAlcance())){
			throw new SICException("El usuario de alcances se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloFiltro.getOpcionAlcance())){
			throw new SICException("La opcion del alcance se encuentra vacio");
		}
		if(articuloFiltro.getFechaInicioAlcance()==null){
			throw new SICException("La fecha de inicio de alcance se encuentra vacio");
		}
		if(articuloFiltro.getFechaAplicacion()==null){
			throw new SICException("La fecha de aplicacion de alcance se encuentra vacio");
		}
	}

	
	/**
	 * Permite asignar alcance del articulo a las areas de trabajo
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	public void asignarArticuloAlcanceAreasTrabajo(ArticuloVO articuloVO)throws SICException{
		if(articuloVO==null){
			throw new SICException("La plantilla articuloVO se encuentra vacio");
		}
		if(articuloVO.getBaseDTO()==null){
			throw new SICException("La plantilla baseDTO se encuentra vacio");
		}
		if(CollectionUtils.isEmpty(articuloVO.getBaseDTO().getArticuloLocalCol())){
			throw new SICException("La plantilla articuloLocal se encuentra vacia");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getUserId())){
			throw new SICException("El userId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
			throw new SICException("El codigoArticulo se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getAccessItemId())){
			throw new SICException("El accessItemId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getSystemId())){
			throw new SICException("El systemId se encuentra vacio");
		}
		if(articuloVO.getCodigoCompania() == null){
			throw new SICException("El codigo compania se encuentra vacio");
		}
	}
	
	public void validarRegistrarAlcanceTemporal(ArticuloVO articuloVO) throws SICException{
			if(articuloVO.getCodigoCompania() == null){
				throw new SICException("El codigo compania se encuentra vacio");
			}
			if(CollectionUtils.isEmpty(articuloVO.getCodigosArticulos())){
				throw new SICException("La coleccion de codigos de articulos se encuentra vacia");
			}
			if(articuloVO.getCodigoLocalAlcance() == null){
				throw new SICException("El codigo del local a dar alcance es nulo");
			}
			if(StringUtils.isBlank(articuloVO.getUserId())){
				throw new SICException("El usuario del alcance es nulo o vacio");
			}
			if(StringUtils.isBlank(articuloVO.getAccessItemId())){
				throw new SICException("El accessitem de usuario es nulo o vacio");
			}
			if(StringUtils.isBlank(articuloVO.getSystemId())){
				throw new SICException("El sistema es nulo o vacio");
			}
	}
	
	public void validarRegistrarAlcanceBodegaSubbodega(ArticuloVO articuloVO) throws SICException{
			if(StringUtils.isBlank(articuloVO.getCodigoSubbodega())){
				throw new SICException("El codigo de a subbodega es nulo o vacio");
			}
			if(StringUtils.isBlank(articuloVO.getAccessItemId())){
				throw new SICException("El item de usuario es nulo o vacio");
			}
			if(StringUtils.isBlank(articuloVO.getSystemId())){
				throw new SICException("El usuario de sistema es nulo o vacio");
			}
	}
	
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException{
		if(articuloVO==null){
			throw new SICException("La plantilla articuloVO se encuentra vacio");
		}
		if(articuloVO.getBaseDTO()==null){
			throw new SICException("La plantilla baseDTO se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getUserId())){
			throw new SICException("El userId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
			throw new SICException("El codigo articulo se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getAccessItemId())){
			throw new SICException("El accessItemId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getSystemId())){
			throw new SICException("El systemId se encuentra vacio");
		}
		if(articuloVO.getBaseDTO().getId().getCodigoCompania() == null){
			throw new SICException("El codigo compania se encuentra vacio");
		}
//		if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() == null){
//			throw new SICException("El codigo grupo alcance se encuentra vacio");
//		}
	}
	
	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * @param articuloVO
	 * @param cadenasCodigosArticulos
	 * @throws SICException
	 */
	public void activarDesactivarArticulosMasivoEstablecimientos(ArticuloVO articuloVO)throws SICException{
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getUserId())){
			throw new SICException("El userId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
			throw new SICException("El codigo articulo se encuentra vacio");
		}
	}
	
	/**
	 * Insertamos los establecimientos dependiendo de los alcances
	 * @param articuloVO
	 * @param cadenasCodigosArticulos
	 * @throws SICException
	 */
	public void insertarArticulosMasivoEstablecimientos(ArticuloVO articuloVO)throws SICException{
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getUserId())){
			throw new SICException("El userId se encuentra vacio");
		}
		if(StringUtils.isEmpty(articuloVO.getBaseDTO().getId().getCodigoArticulo())){
			throw new SICException("El codigo articulo se encuentra vacio");
		}
	}
	
	/**
	 * Permite activar, desactivar, insertar alcances cuando se ha realizado un cambio de prototipo
	 * @param articuloVO
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(ArticuloVO articuloVO) throws SICException{
		if(articuloVO.getBaseDTO().getId().getCodigoCompania()==null){
			throw new SICException("El codigoCompania es requerido");
		}
//		if(articuloVO.getBaseDTO().getCodigoGrupoAlcance()==null){
//			throw new SICException("El codigoGrupoAlcance es requerido");
//		}
		if(articuloVO.getBaseDTO().getId().getCodigoArticulo()==null){
			throw new SICException("El codigoArticulo es requerido");
		}	
		if(StringUtils.isBlank(articuloVO.getBaseDTO().getUserId())){
			throw new SICException("El userId es requerido");
		}
		if(StringUtils.isBlank(articuloVO.getSystemId())){
			throw new SICException("El systemId es requerido");
		}
		if(StringUtils.isBlank(articuloVO.getAccessItemId())){
			throw new SICException("El accessItemId es requerido");
		}
		if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null &&
				articuloVO.getBaseDTO().getCodigoGrupoAlcance().equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)
				&& CollectionUtils.isEmpty(articuloVO.getAreasTrabajoCol())){
			throw new SICException("Las areasTrabajoCol son requeridas para el prototipo personalizado");
		}
	}
}
