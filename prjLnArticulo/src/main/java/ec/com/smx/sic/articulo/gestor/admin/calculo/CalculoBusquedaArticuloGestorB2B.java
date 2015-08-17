/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.filtros.PlantillaFiltrosBusquedaB2B;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestorB2B;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;

/**
 * @author mgranda  
 *
 */
public class CalculoBusquedaArticuloGestorB2B implements ICalculoBusquedaArticuloGestorB2B {

	private IArticuloDAO articuloDAO;
	
	private DataGestor dataGestor;
	
	@SuppressWarnings("unchecked")
	@Override
	public SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException {
		
		// Busqueda con like para codigo de referencia proveedor
		if(articuloVO.getArticuloProveedorDTO() != null && !StringUtils.isEmpty(articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor())){
			articuloVO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("articuloProveedorCol.codigoReferenciaProveedor", ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR, articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor()));
		}
		SearchResultDTO<ArticuloDTO> resultDTO = articuloDAO.obtenerArticulosAgrupados(articuloVO);
		
		Collection<String> articulosId = CollectionUtils.collect(resultDTO.getResults(), new Transformer() {
			
			@Override
			public Object transform(Object arg0) {
				ArticuloDTO articuloDTO = (ArticuloDTO) arg0;
				return articuloDTO.getId().getCodigoArticulo();
			}
		});
		
		ArticuloDTO articuloDTOExt = new ArticuloDTO();	
		articuloDTOExt.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
		CriteriaSearch criteriaSearch = SerializationUtils.clone(articuloVO.getCriteriaSearch());
		articuloDTOExt.setCriteriaSearch(criteriaSearch);
		articuloDTOExt.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Object>("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, articulosId));
		ArticuloProveedorDTO apFiltro = articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next();			
			
		articuloDTOExt.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloDTOExt.getArticuloProveedorCol().add(apFiltro);	
		apFiltro.setVistaProveedor(new VistaProveedorDTO());
		articuloDTOExt.setArticuloComercialDTO(new ArticuloComercialDTO());
		articuloDTOExt.getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());
		articuloDTOExt.getArticuloComercialDTO().setPaisOrigen(new DivisionGeoPoliticaDTO());
		
		articuloDTOExt.setArticuloMedidaDTO(new ArticuloMedidaDTO());
		articuloDTOExt.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora",ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloDTOExt.getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);
		
		ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO = new ArticuloDefinicionArchivoDTO();
		articuloDefinicionArchivoDTO.setArticuloArchivo(new ArticuloArchivoDTO());
		Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol = new ArrayList<ArticuloDefinicionArchivoDTO>();
		articuloDefinicionArchivoCol.add(articuloDefinicionArchivoDTO);
		
		ArticuloRegistroSanitarioDTO registroSanitarioDTO = new ArticuloRegistroSanitarioDTO();
		//registroSanitarioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoRegistroSanitario",ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		//registroSanitarioDTO.setArtDefArcCol(new ArrayList<ArticuloDefinicionArchivoDTO>());
		//registroSanitarioDTO.getArtDefArcCol().add(new ArticuloDefinicionArchivoDTO());
		registroSanitarioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoEstudioNutricional",ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL));
		registroSanitarioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstudioNutricional",ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO));
		registroSanitarioDTO.setArtDefArcCol(articuloDefinicionArchivoCol);
		
		RelacionArticuloRegistroSanitarioDTO artRegSan = new RelacionArticuloRegistroSanitarioDTO();
		artRegSan.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado",ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		artRegSan.setRegistroSanitario(registroSanitarioDTO);
		
		articuloDTOExt.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
		articuloDTOExt.getRegistroSanitarioCol().add(artRegSan);
		
		Collection<ArticuloDTO> articuloDetalleCol = dataGestor.findObjects(articuloDTOExt);
		if(CollectionUtils.isNotEmpty(articuloDetalleCol) && articuloDetalleCol.size() > 0){
			for(ArticuloDTO articuloDTO : articuloDetalleCol){
				if(CollectionUtils.isNotEmpty(articuloDTO.getRegistroSanitarioCol()) && articuloDTO.getRegistroSanitarioCol().size() > 0){
					Collection<RelacionArticuloRegistroSanitarioDTO> relacionArticuloRegistroSanitarioDTOs = new ArrayList<RelacionArticuloRegistroSanitarioDTO>();
					for(RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO : articuloDTO.getRegistroSanitarioCol()){
						if(relacionArticuloRegistroSanitarioDTO != null && relacionArticuloRegistroSanitarioDTO.getRegistroSanitario() != null){
							if(relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().getValorTipoEstudioNutricional().equals(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO)){
								relacionArticuloRegistroSanitarioDTOs.add(relacionArticuloRegistroSanitarioDTO);
							}
						}
					}
					articuloDTO.setRegistroSanitarioCol(relacionArticuloRegistroSanitarioDTOs);
				}
			}
		}
		
		for(ArticuloDTO articuloDTO : resultDTO.getResults()){
			
			Predicate predicate = PredicateUtils.andPredicate(
					PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoCompania"), PredicateUtils.equalPredicate(articuloDTO.getId().getCodigoCompania()) ), 
					PredicateUtils.transformedPredicate(new GetInvokerTransformer("id.codigoArticulo"), PredicateUtils.equalPredicate(articuloDTO.getId().getCodigoArticulo()))
			);		
			
			ArticuloDTO articuloDetalle = (ArticuloDTO) CollectionUtils.find(articuloDetalleCol, predicate);			
			
			if(articuloDetalle != null){
				
				ArticuloDTO articuloDTOInfo = articuloDetalle;
				BeanUtils.copyProperties(articuloDTOInfo, articuloDTO,new String[]{"estadoPerecibleReceta","npImplemento"});
				
				if(!CollectionUtils.isEmpty(articuloDTO.getArticuloProveedorCol())){
					ArticuloProveedorDTO articuloProveedorDTOFirst = articuloDTO.getArticuloProveedorCol().iterator().next();
					articuloDTO.addDynamicProperty("referencia", articuloProveedorDTOFirst);
				}
			}			
			this.asignarCiudadOrigen(articuloDTO);
		}
		resultDTO.setResults(this.crearEstructuraArticulosPorRegistroSanitario(resultDTO.getResults()));
		return resultDTO;	
		
	}
	
	private void asignarCiudadOrigen(ArticuloDTO articuloDTO){
		if(articuloDTO.getTieneArticuloComercial()){
			articuloDTO.addDynamicProperty("codigoPais", (articuloDTO.getArticuloComercialDTO().getTienePaisOrigen() && articuloDTO.getArticuloComercialDTO().getCodigoPaisOrigen() != null)  ? articuloDTO.getArticuloComercialDTO().getPaisOrigen().getCodigoDivGeoPolRoot() : "");
		}else{			
			ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
			articuloComercialDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			articuloComercialDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			articuloDTO.setArticuloComercialDTO(articuloComercialDTO);
			articuloDTO.addDynamicProperty("codigoPais","");
		}
		articuloDTO.addDynamicProperty("listaCiudades", new ArrayList<DivisionGeoPoliticaDTO>());
	}
	

	@SuppressWarnings("unchecked")
	private Collection<ArticuloDTO> crearEstructuraArticulosPorRegistroSanitario(Collection<ArticuloDTO> articuloDTOs) {
		Collection<ArticuloDTO> articuloEstructura = new ArrayList<ArticuloDTO>();
		if (CollectionUtils.isNotEmpty(articuloDTOs)) {
			for (ArticuloDTO articuloDTO : articuloDTOs) {
				if (articuloDTO.getCantidadRegistroSanitario() <= 1) {
					this.registroSanitarioSimple(articuloDTO);
				}else{
					this.registroSanitarioMultiple(articuloDTO);
				}
				articuloEstructura.add(articuloDTO);
				if(articuloDTO.getDynamicProperty("multipleRegSan") != null){
					articuloEstructura.addAll((Collection<ArticuloDTO>) articuloDTO.getDynamicProperty("multipleRegSan"));
				}
			}
		}
		return articuloEstructura;
	}
	
	public void registroSanitarioSimple(ArticuloDTO articuloDTO){
		RelacionArticuloRegistroSanitarioDTO artRegSan = null;
		if (articuloDTO.getTieneRegistroSanitario()) {
			artRegSan = articuloDTO.getRegistroSanitarioCol().iterator().next();
		}
		if (artRegSan == null) {
			artRegSan = new RelacionArticuloRegistroSanitarioDTO();
			artRegSan.setArticulo(articuloDTO);
			artRegSan.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			artRegSan.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			artRegSan.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			artRegSan.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
			artRegSan.getRegistroSanitario().getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			//artRegSan.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			artRegSan.getRegistroSanitario().setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
			artRegSan.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
		}
		artRegSan.setArticulo(articuloDTO);
		articuloDTO.addDynamicProperty("RegSan", artRegSan);
		articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
		articuloDTO.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
		articuloDTO.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
	}
	
	public void registroSanitarioMultiple(ArticuloDTO articuloDTO){
//		ArticuloRegistroSanitarioDTO registroSanitarioActivoDTO = null;
//		if (articuloDTO.getTieneRegistroSanitario() && articuloDTO.getRegistroSanitarioCol().size() >= articuloDTO.getCantidadRegistroSanitario()) {
//			Collection<ArticuloDTO> collection = new ArrayList<ArticuloDTO>();
//			List<ArticuloRegistroSanitarioDTO> registroSanitarioDTOs = (List<ArticuloRegistroSanitarioDTO>) articuloDTO.getRegistroSanitarioCol();
//			for (int i = 0; i < articuloDTO.getCantidadRegistroSanitario(); i++) {
//				ArticuloDTO dto = new ArticuloDTO();
//				dto.addDynamicProperty("RegSan", registroSanitarioDTOs.get(i));
//				dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
//				dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
//				dto.addDynamicProperty("articulo",articuloDTO);
//				dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
//				collection.add(dto);
//			}
//			articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
//			articuloDTO.addDynamicProperty("multipleRegSan", collection);
//			articuloDTO.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
//		} 
//		
//		if (articuloDTO.getTieneRegistroSanitario() && articuloDTO.getRegistroSanitarioCol().size() < articuloDTO.getCantidadRegistroSanitario()) {
//			Collection<ArticuloDTO> collection = new ArrayList<ArticuloDTO>();
//			List<ArticuloRegistroSanitarioDTO> registroSanitarioDTOs = (List<ArticuloRegistroSanitarioDTO>) articuloDTO.getRegistroSanitarioCol();
//			for (int i = 0; i < articuloDTO.getCantidadRegistroSanitario(); i++) {
//				ArticuloDTO dto = new ArticuloDTO();
//				if(i >= articuloDTO.getRegistroSanitarioCol().size()){
//					registroSanitarioActivoDTO = new ArticuloRegistroSanitarioDTO();
//					registroSanitarioActivoDTO.setArticuloDTO(articuloDTO);
//					registroSanitarioActivoDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
//					registroSanitarioActivoDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
//					registroSanitarioActivoDTO.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
//					dto.addDynamicProperty("RegSan", registroSanitarioActivoDTO);
//					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
//					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
//					dto.addDynamicProperty("articulo",articuloDTO);
//					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
//				}else{
//					dto.addDynamicProperty("RegSan", registroSanitarioDTOs.get(i));
//					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
//					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
//					dto.addDynamicProperty("articulo",articuloDTO);
//					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
//				}				
//				collection.add(dto);
//			}
//			articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
//			articuloDTO.addDynamicProperty("multipleRegSan", collection);
//			articuloDTO.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
//		}
		
		RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO = null;
		if (articuloDTO.getTieneRegistroSanitario() && articuloDTO.getRegistroSanitarioCol().size() >= articuloDTO.getCantidadRegistroSanitario()) {
			Collection<ArticuloDTO> collection = new ArrayList<ArticuloDTO>();
			List<RelacionArticuloRegistroSanitarioDTO> registroSanitarioDTOs = (List<RelacionArticuloRegistroSanitarioDTO>) articuloDTO.getRegistroSanitarioCol();
			for (int i = 0; i < articuloDTO.getCantidadRegistroSanitario(); i++) {
				ArticuloDTO dto = new ArticuloDTO();
				dto.addDynamicProperty("RegSan", registroSanitarioDTOs.get(i));
				dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
				dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
				dto.addDynamicProperty("articulo",articuloDTO);
				dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
				dto.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
				dto.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
				collection.add(dto);
			}
			articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
			articuloDTO.addDynamicProperty("multipleRegSan", collection);
			articuloDTO.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
		} 
		
		if (articuloDTO.getTieneRegistroSanitario() && articuloDTO.getRegistroSanitarioCol().size() < articuloDTO.getCantidadRegistroSanitario()) {
			Collection<ArticuloDTO> collection = new ArrayList<ArticuloDTO>();
			List<RelacionArticuloRegistroSanitarioDTO> registroSanitarioDTOs = (List<RelacionArticuloRegistroSanitarioDTO>) articuloDTO.getRegistroSanitarioCol();
			for (int i = 0; i < articuloDTO.getCantidadRegistroSanitario(); i++) {
				ArticuloDTO dto = new ArticuloDTO();
				if(i >= articuloDTO.getRegistroSanitarioCol().size()){
					relacionArticuloRegistroSanitarioDTO = new RelacionArticuloRegistroSanitarioDTO();
					relacionArticuloRegistroSanitarioDTO.setArticulo(articuloDTO);
					relacionArticuloRegistroSanitarioDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
					relacionArticuloRegistroSanitarioDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
					relacionArticuloRegistroSanitarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					relacionArticuloRegistroSanitarioDTO.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
					relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
					relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
					//relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					dto.addDynamicProperty("RegSan", relacionArticuloRegistroSanitarioDTO);
					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
					dto.addDynamicProperty("articulo",articuloDTO);
					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
					dto.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
					dto.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
				}else{
					dto.addDynamicProperty("RegSan", registroSanitarioDTOs.get(i));
					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
					dto.addDynamicProperty("articulo",articuloDTO);
					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
					dto.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
					dto.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
				}				
				collection.add(dto);
			}
			articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
			articuloDTO.addDynamicProperty("multipleRegSan", collection);
			articuloDTO.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
		} 
		
		if (!articuloDTO.getTieneRegistroSanitario() && articuloDTO.getRegistroSanitarioCol().size() < articuloDTO.getCantidadRegistroSanitario()) {
			Collection<ArticuloDTO> collection = new ArrayList<ArticuloDTO>();
			List<RelacionArticuloRegistroSanitarioDTO> registroSanitarioDTOs = (List<RelacionArticuloRegistroSanitarioDTO>) articuloDTO.getRegistroSanitarioCol();
			for (int i = 0; i < articuloDTO.getCantidadRegistroSanitario(); i++) {
				ArticuloDTO dto = new ArticuloDTO();
				if(i >= articuloDTO.getRegistroSanitarioCol().size()){
					relacionArticuloRegistroSanitarioDTO = new RelacionArticuloRegistroSanitarioDTO();
					relacionArticuloRegistroSanitarioDTO.setArticulo(articuloDTO);
					relacionArticuloRegistroSanitarioDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
					relacionArticuloRegistroSanitarioDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
					relacionArticuloRegistroSanitarioDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					relacionArticuloRegistroSanitarioDTO.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
					relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
					relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO);
					//relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					dto.addDynamicProperty("RegSan", relacionArticuloRegistroSanitarioDTO);
					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
					dto.addDynamicProperty("articulo",articuloDTO);
					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
					dto.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
					dto.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
				}else{
					dto.addDynamicProperty("RegSan", registroSanitarioDTOs.get(i));
					dto.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);	
					dto.addDynamicProperty("referencia", articuloDTO.getDynamicProperty("referencia"));
					dto.addDynamicProperty("articulo",articuloDTO);
					dto.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
					dto.addDynamicProperty("TieneFechaCaducidad", Boolean.TRUE);
					dto.addDynamicProperty("FechaCaducidadMayor", Boolean.TRUE);
				}				
				collection.add(dto);
			}
			articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
			articuloDTO.addDynamicProperty("multipleRegSan", collection);
			articuloDTO.addDynamicProperty("esMultipleRegSan",Boolean.TRUE);
		}
	}
	
	
	@Override
	@SuppressWarnings("rawtypes")
	public void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException{
		
		articuloFiltro.setBaseDTO(new ArticuloDTO());				
		ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
		articuloFiltro.setArticuloProveedorDTO(articuloProveedorDTO);		
		ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
		abcb.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora",ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		
		articuloFiltro.getBaseDTO().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articuloFiltro.getBaseDTO().getArtBitCodBarCol().add(abcb);
		abcb.getId().setCodigoBarras(plantillaFiltrosBusqueda.getCodigoBarras());
		
		
		
		articuloFiltro.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());		
		articuloFiltro.setCriteriaSearch(new CriteriaSearch());	
		articuloFiltro.setArticuloRegSanDTO(new RelacionArticuloRegistroSanitarioDTO());
		
		articuloFiltro.getArticuloRegSanDTO().setRegistroSanitario(new ArticuloRegistroSanitarioDTO());	
		
		ArticuloComercialDTO artComDTO = new ArticuloComercialDTO();
		artComDTO.setMarcaComercialArticulo(new MarcaArticuloDTO());
		articuloFiltro.getBaseDTO().setArticuloComercialDTO(artComDTO);
		
		/**
		 * ASIGNACION DE VALORES DESDE EL OBJETO PLANTILLA
		 */			
		articuloFiltro.getBaseDTO().getId().setCodigoCompania(plantillaFiltrosBusqueda.getCompaniaId());    		
		articuloFiltro.setCodigoSistemaOrigen(plantillaFiltrosBusqueda.getSistemaOrigen());		
		articuloFiltro.getArticuloProveedorDTO().setEstadoArticuloProveedor(plantillaFiltrosBusqueda.getEstadoArticuloProveedor());
		articuloFiltro.getArticuloProveedorDTO().setCodigoReferenciaProveedor(plantillaFiltrosBusqueda.getCodigoReferenciaProveedor());		
		articuloFiltro.getBaseDTO().setDescripcionArticulo(plantillaFiltrosBusqueda.getDescripcionArticulo());
		articuloFiltro.getBaseDTO().setEstadoArticulo(plantillaFiltrosBusqueda.getEstadoArticulo());
		articuloFiltro.getBaseDTO().setAplicaRegistroSanitario(plantillaFiltrosBusqueda.getAplicaRegistroSanitario());
		articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setRegistroSanitario(plantillaFiltrosBusqueda.getRegistroSanitario());
		//FILTROS DE BUSQUEDA SEGUN EL SISTEMA B2B REGISTRO SANITARIO ARTICULO
		//Filtro Proveedor B2B 
		articuloFiltro.getArticuloProveedorDTO().getId().setCodigoProveedor(plantillaFiltrosBusqueda.getCodigoProveedor());
		
		//NEGOCIO DE BUSQUEDA DE B2B
		
		if(StringUtils.isNotEmpty(abcb.getId().getCodigoBarras())){
			articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("artBitCodBarCol.id.codigoBarras", ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR, abcb.getId().getCodigoBarras()));
		}
		
		if(articuloFiltro.getArticuloProveedorDTO() != null && StringUtils.isNotEmpty(articuloFiltro.getArticuloProveedorDTO().getCodigoReferenciaProveedor())){
			articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("articuloProveedorCol.codigoReferenciaProveedor", ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR, articuloFiltro.getArticuloProveedorDTO().getCodigoReferenciaProveedor()));
		}		
		
		if(plantillaFiltrosBusqueda.getRegSanCaducados()){
			plantillaFiltrosBusqueda.setRegSanCaducados(Boolean.TRUE);
			Date actualDate = new Date();	
			actualDate = DateUtils.addDays(actualDate, -1);
			articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new CriteriaSearch());
			articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaCaducidadRegistroSanitario", ComparatorTypeEnum.LESS_THAN_COMPARATOR, actualDate));
		}else{
			articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(null);
		}	
		//filtro reg Sanitario
		if(plantillaFiltrosBusqueda.getVisualizarFiltros()){
			Collection<RelacionArticuloRegistroSanitarioDTO> registroSanitarioCol = new ArrayList<RelacionArticuloRegistroSanitarioDTO>();
			articuloFiltro.getArticuloRegSanDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado",ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoEstudioNutricional",ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL));
			articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoEstudioNutricional",ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO));
			//articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);

			//SECCION DE FILTROS POR FECHAS
			RangeValue<Date> rangeValue = new RangeValue<Date>();
			if(plantillaFiltrosBusqueda.getRegSanCaducados()  && plantillaFiltrosBusqueda.getfCadRegSfin() != null && plantillaFiltrosBusqueda.getfCadRegSinicio() != null){
				Date actualDate = new Date();	
				if(plantillaFiltrosBusqueda.getfCadRegSfin().compareTo(actualDate) > 0)
					plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate, -1));		
			}
			if(plantillaFiltrosBusqueda.getRegSanCaducados()  && plantillaFiltrosBusqueda.getfCadRegSfin() != null && plantillaFiltrosBusqueda.getfCadRegSinicio() == null){
				Date actualDate = new Date();	
				if(plantillaFiltrosBusqueda.getfCadRegSfin().compareTo(actualDate) > 0)
					plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate, -1));		
			}
			if(plantillaFiltrosBusqueda.getRegSanCaducados()  && plantillaFiltrosBusqueda.getfCadRegSfin() == null && plantillaFiltrosBusqueda.getfCadRegSinicio() != null){
				Date actualDate = new Date();	
				if(plantillaFiltrosBusqueda.getfCadRegSinicio().compareTo(actualDate) < 0)
					plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate, -1));		
			}
			
			if(plantillaFiltrosBusqueda.getfCadRegSfin() == null && plantillaFiltrosBusqueda.getfCadRegSinicio() == null && !plantillaFiltrosBusqueda.getRegSanCaducados()){
				articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(null);
			}
			
			if(plantillaFiltrosBusqueda.getfCadRegSfin() ==null && plantillaFiltrosBusqueda.getfCadRegSinicio() == null && plantillaFiltrosBusqueda.getRegSanCaducados()){
				Date actualDate = new Date();	
				actualDate = DateUtils.addDays(actualDate, -1);
				articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new CriteriaSearch());
				articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaCaducidadRegistroSanitario", ComparatorTypeEnum.LESS_THAN_COMPARATOR, actualDate));
				}
				
			if(plantillaFiltrosBusqueda.getfCadRegSfin() !=null || plantillaFiltrosBusqueda.getfCadRegSinicio() != null){			
				rangeValue.setBottomValue(plantillaFiltrosBusqueda.getfCadRegSinicio());
				rangeValue.setTopValue(plantillaFiltrosBusqueda.getfCadRegSfin());
				articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new CriteriaSearch());
				articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<RangeValue>("fechaCaducidadRegistroSanitario", ComparatorTypeEnum.BETWEEN_INCLUDE_COMPARATOR, rangeValue));	
				
			}
			
			registroSanitarioCol.add(articuloFiltro.getArticuloRegSanDTO());
			articuloFiltro.getBaseDTO().setRegistroSanitarioCol(registroSanitarioCol);				
		}else{
			articuloFiltro.getBaseDTO().setRegistroSanitarioCol(null);
		}
		
		//filtros de articulos B2B si aplican o no registro sanitario
		if(articuloFiltro.getBaseDTO().getAplicaRegistroSanitario() == null){			
			Boolean[] estados = new Boolean[]{Boolean.FALSE,Boolean.TRUE};			
			articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario", ComparatorTypeEnum.IN_COMPARATOR,estados));
		}else{
			if(articuloFiltro.getBaseDTO().getAplicaRegistroSanitario().equals(Boolean.TRUE)){
				Boolean[] estados = new Boolean[]{Boolean.TRUE};
				articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario", ComparatorTypeEnum.EQUAL_COMPARATOR,estados));
			}else{
				Boolean[] estados = new Boolean[]{Boolean.FALSE};
				articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario", ComparatorTypeEnum.EQUAL_COMPARATOR,estados));
			}
		}
		
		//Filtro Clasificacion
		if(CollectionUtils.isNotEmpty(plantillaFiltrosBusqueda.getClasificacionCol()) && plantillaFiltrosBusqueda.getClasificacionCol().size() > 0){
			Collection<ClasificacionDTO> clasificacionCol = plantillaFiltrosBusqueda.getClasificacionCol();
			String[] retricClasificacion = new String[clasificacionCol.size()];
			Integer indice = 0;
			for(ClasificacionDTO clasificacionDTO2:clasificacionCol){
				retricClasificacion[indice] = clasificacionDTO2.getId().getCodigoClasificacion();
				indice++;
			}
			articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, retricClasificacion));
		}else{
			//Restricciones para B2B Reg San exclusion Clase Obsoletos
			String[] retricClasificacion = new String[]{"9___"};
			articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoClasificacion", ComparatorTypeEnum.LIKE_EXACT_COMPARATOR,Boolean.TRUE, retricClasificacion));
		}
		
		//filtro proveedor
		Collection<ArticuloProveedorDTO> articuloProveedorCol = new ArrayList<ArticuloProveedorDTO>();
		articuloProveedorCol.add(articuloFiltro.getArticuloProveedorDTO());
		articuloFiltro.getBaseDTO().setArticuloProveedorCol(articuloProveedorCol);		
	}
	
	@Override
	public Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException {		
		Collection<ArticuloDTO> articuloDTOs = new ArrayList<ArticuloDTO>();
		Double totalPaginas = 1D;
		Integer inicialPage = 0;
		articuloVO.setCountAgain(Boolean.TRUE);	
		for(int i = 1;i <= totalPaginas;i++){
			articuloVO.setFirstResult(inicialPage);
			articuloVO.setMaxResults(23);
			incluirRestriccionesBusquedaArticuloB2B(articuloVO, plantillaFiltrosBusqueda);
			SearchResultDTO<ArticuloDTO> searchResultDTO = buscarArticulosB2B(articuloVO);
			totalPaginas = Math.ceil((Double) (searchResultDTO.getCountResults()/23D));
			articuloDTOs.addAll(searchResultDTO.getResults());
			inicialPage = articuloVO.getMaxResults()*i;
		}		
		return articuloDTOs;		
	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}	
}
