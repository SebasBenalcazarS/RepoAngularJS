package ec.com.smx.sic.articulo.gestor.impresionEtiquetas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.etiquetado.exception.EtiquetadoException;
import ec.com.smx.corpv2.etiquetado.gestor.solicitudImpresion.ISolicitudImpresionGestor;
import ec.com.smx.corpv2.etiquetado.modelo.dto.PrintRequestDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.id.PrintRequestID;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.articulo.persistence.dao.ArticuloSolicitudImpresionDAO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloProveedorSolImpresion;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloSolImpresion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.impresionEtiquetas.IArticuloSolicitudImpresionEtiquetasGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.persistencia.proveedor.restricciones.ProveedorFiltroRestriction;
/**
 * 
 * @author aquingaluisa
 *
 */
public class ArticuloSolicitudImpresionEtiquetasGestor implements IArticuloSolicitudImpresionEtiquetasGestor {
	private DataGestor dataGestor;
	
	private ArticuloSolicitudImpresionDAO solicitudImpresionDAO;
	///gestor del motulo de etiquetado
	private ISolicitudImpresionGestor solicitudImpresionGestor;
	
	@Override
	public PrintRequestDTO buscarSolicitud(PrintRequestID printRequestID) throws SICException{
		return solicitudImpresionGestor.buscarSolicitudImpresionUnico(printRequestID);
	}
	
	@Override
	public SearchResultDTO<PrintRequestDTO> buscarSolicitudImpresionPaginados(PrintRequestDTO printRequestDTOPlantilla) throws SICException{
		try {
			return solicitudImpresionGestor.buscarSolicitudesImpresionPaginado(printRequestDTOPlantilla);
		}catch (EtiquetadoException e) {
			throw new SICException("01",e.getDescripcionError()) ;
		} catch (Exception e) {
			throw new SICException(e) ;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> buscarArticulosPorCodigoRefencia(String codigoReferenciaExterna,Integer codigoCompania){
		ArticuloProveedorDTO articuloProveedorPlatilla = new ArticuloProveedorDTO();
		//agrego el filtro para que lo realize mediante LIKE_ANYWHERE_COMPARATOR 
		articuloProveedorPlatilla.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoReferenciaProveedor",ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR,codigoReferenciaExterna));
		articuloProveedorPlatilla.getId().setCodigoCompania(codigoCompania);
		articuloProveedorPlatilla.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		//busco el resultado
		Collection<ArticuloProveedorDTO> resultadoPlantilla = this.dataGestor.findObjects(articuloProveedorPlatilla);
		Collection<String>  codigoArticuloCol = null;
		if (resultadoPlantilla !=null && CollectionUtils.isNotEmpty(resultadoPlantilla)){
			//retorno solamente la collecion de  codigoArticulo
			codigoArticuloCol = CollectionUtils.collect(resultadoPlantilla, new GetInvokerTransformer("id.codigoArticulo"));
		}
		resultadoPlantilla = null;
		return codigoArticuloCol;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> buscarArticulosPorCodigoBarras(String codigoBarras,Integer codigoCompania){
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasPlantilla = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasPlantilla.getId().setCodigoCompania(codigoCompania);
		articuloBitacoraCodigoBarrasPlantilla.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		//agrego el filtro para que lo realize mediante LIKE_ANYWHERE_COMPARATOR 
		articuloBitacoraCodigoBarrasPlantilla.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoBarras",ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR,codigoBarras));
		//busco el resultado
		Collection<ArticuloBitacoraCodigoBarrasDTO> resultadoPlantilla = this.dataGestor.findObjects(articuloBitacoraCodigoBarrasPlantilla);
		Collection<String>  codigoArticuloCol = null;
		if (resultadoPlantilla !=null && CollectionUtils.isNotEmpty(resultadoPlantilla)){
			//retorno solamente la collecion de  codigoArticulo
			codigoArticuloCol = CollectionUtils.collect(resultadoPlantilla, new GetInvokerTransformer("id.codigoArticulo"));
		}
		resultadoPlantilla = null;
		return codigoArticuloCol;
	}
	
	@Override
	public SearchResultDTO<EstructuraArticuloSolImpresion>  buscarArticulosporFiltros(ArticuloDTO articuloPlantillaBusqueda)throws SICException{
		SearchResultDTO<EstructuraArticuloSolImpresion> articuloResultado; 
		articuloPlantillaBusqueda.setIsPaginable(Boolean.TRUE);
		SearchResultDTO<ArticuloDTO> resultDTO = this.solicitudImpresionDAO.obtenerArticulosAgrupadosBusqueda(articuloPlantillaBusqueda, 1000);
		//solo obtengo los articulos de la busqueda realizada
		Collection<String> codigoArticuloCol = obtenerCodigosArticulos(resultDTO.getResults());
		if (CollectionUtils.isNotEmpty(codigoArticuloCol)) {
			//con los codigos de articulos realizo la busqueda
			articuloResultado = this.solicitudImpresionDAO.obtenerArticulosPorCodigo(codigoArticuloCol, articuloPlantillaBusqueda.getId().getCodigoCompania());
			//coloco una bandera al resultado para saber si el articulo tiene o no semaforo
			SearchResultDTO<ArticuloEtiquetaDTO> resultadoEtiquetaSemaforo  = this.solicitudImpresionDAO.buscarArticuloEtiquetaSemaforo(codigoArticuloCol, articuloPlantillaBusqueda.getId().getCodigoCompania());
			//valido los articulos que contienen semaforo y coloco una bandera
			for(EstructuraArticuloSolImpresion solImpresionIteracion:articuloResultado.getResults()){
				ArticuloEtiquetaDTO etiquetaResultado = (ArticuloEtiquetaDTO)CollectionUtils.find(resultadoEtiquetaSemaforo.getResults(),new BeanPredicate("id.codigoArticulo", PredicateUtils.equalPredicate(solImpresionIteracion.getCodigoArticulo())));
				if(etiquetaResultado != null){
					solImpresionIteracion.setTieneSemaforo(Boolean.TRUE);
				}
			}
			//coloco en numero de registros total para que se pueda  calcular el numero de paginas
			articuloResultado.setCountResults(resultDTO.getCountResults());
			return articuloResultado;
		}else{
			throw new SICException("01", "El n\u00FAmero de resultados es demasiado extenso. Por favor incluya m\u00E1s filtros en la b\u00FAsqueda");
		}
		
		
	}
	
	@Override
	public Collection<EstructuraArticuloProveedorSolImpresion> buscarArticuloProveedorPorIdArticulo(ArticuloID articulioID)throws SICException{
		return this.solicitudImpresionDAO.buscarArticuloProveedorPorIdArticulo(articulioID);
		
	}
	
	/**
	 * Metodo aue permite obtener solo los codigos de los articulos desde una collecion de ArticuloDTO
	 * @param articulosPlantilla
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	private Collection<String> obtenerCodigosArticulos(Collection<ArticuloDTO> articuloPlantillaCol) {
		Collection<String> idsArticuloDTO = CollectionUtils.collect(articuloPlantillaCol, new Transformer() {
			//solo retorno la coleccion de codigoArticulo
			@Override
			public Object transform(Object articuloObj) {
				ArticuloDTO articuloDTO = (ArticuloDTO) articuloObj;
				return articuloDTO.getId().getCodigoArticulo();
			}
		});
		return idsArticuloDTO;
	}
	
	
	@Override
	@SuppressWarnings("rawtypes")
	public void generarRestricicionesBusquedaArticulos(ArticuloDTO articuloPlantilla,HashMap<String, CriteriaSearchParameter> mapCriteriaSearchParameter,HashMap<String, BaseCriteriaRestriction> mapaBaseCriteriaRestriction,Integer codigoCompoania) throws SICException{
		//Creo un conjunto de restricciones dinamicas
		DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();
		Collection<ArticuloProveedorDTO> articuloProveedorCol = null;
		if(articuloPlantilla ==null){
			articuloPlantilla = new ArticuloDTO();
		}
		//inicializo la relacion con proveedor
		if(mapCriteriaSearchParameter.get("codigoProvedor")!=null || mapaBaseCriteriaRestriction.get("nombreComercialProv")!=null){
			ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
			articuloProveedorDTO.setVistaProveedor(new VistaProveedorDTO());
			articuloProveedorDTO.getVistaProveedor().setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
			articuloProveedorDTO.getVistaProveedor().getCriteriaRestrictions().add(new ProveedorFiltroRestriction());
			// Relacion con Proveedor
			articuloProveedorCol = new ArrayList<ArticuloProveedorDTO>();
			articuloProveedorCol.add(articuloProveedorDTO);
		}
		//agrego los filtros de bitacora de codigo de barras
		ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
		abcb.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloPlantilla.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articuloPlantilla.getArtBitCodBarCol().add(abcb);
		
		articuloPlantilla.getId().setCodigoCompania(1);
		articuloPlantilla.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		articuloPlantilla.setArticuloProveedorCol(articuloProveedorCol);
		//agrego las restricciones del componente de busqueda
		if(MapUtils.isNotEmpty(mapCriteriaSearchParameter)){
			if(mapCriteriaSearchParameter.get("codigoArticulo")!=null){
				dynamicCriteriaRestriction.add(mapCriteriaSearchParameter.get("codigoArticulo"));
			}
			if(mapCriteriaSearchParameter.get("codigoProvedor")!=null){
				dynamicCriteriaRestriction.add(mapCriteriaSearchParameter.get("codigoProvedor"));
			}
			if(mapCriteriaSearchParameter.get("estArticulo")!=null){
				dynamicCriteriaRestriction.add(mapCriteriaSearchParameter.get("estArticulo"));
			}
			if(mapCriteriaSearchParameter.get("descArticulo")!=null){
				dynamicCriteriaRestriction.add(mapCriteriaSearchParameter.get("descArticulo"));
			}
			if(mapCriteriaSearchParameter.get("codigoBarras")!=null){
				dynamicCriteriaRestriction.add(mapCriteriaSearchParameter.get("codigoBarras"));
			}
		}
		if(MapUtils.isNotEmpty(mapaBaseCriteriaRestriction)){
			if(mapaBaseCriteriaRestriction.get("nombreComercialProv")!=null){
				dynamicCriteriaRestriction.add(mapaBaseCriteriaRestriction.get("nombreComercialProv"));
			}
			if(mapaBaseCriteriaRestriction.get("codClasificacion")!=null){
				if (articuloPlantilla.getClasificacionDTO() == null) {
					articuloPlantilla.setClasificacionDTO(new ClasificacionDTO());
				}
				articuloPlantilla.getClasificacionDTO().setClasificacionPadre(new ClasificacionDTO());
				dynamicCriteriaRestriction.add(mapaBaseCriteriaRestriction.get("codClasificacion"));
			}
		}
		//siempre tiene que traer los articulos que no  sean tipo cupon (08)
		articuloPlantilla.addCriteriaSearchParameter("codigoTipoArticulo",ComparatorTypeEnum.NOT_EQUAL_COMPARATOR,SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON);
		articuloPlantilla.getCriteriaRestrictions().add(dynamicCriteriaRestriction);
	}
	
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	public ISolicitudImpresionGestor getSolicitudImpresionGestor() {
		return solicitudImpresionGestor;
	}
	public void setSolicitudImpresionGestor(ISolicitudImpresionGestor solicitudImpresionGestor) {
		this.solicitudImpresionGestor = solicitudImpresionGestor;
	}

	public ArticuloSolicitudImpresionDAO getSolicitudImpresionDAO() {
		return solicitudImpresionDAO;
	}

	public void setSolicitudImpresionDAO(ArticuloSolicitudImpresionDAO solicitudImpresionDAO) {
		this.solicitudImpresionDAO = solicitudImpresionDAO;
	}

}
