/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.rotulado;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.plantillas.common.util.PlantillasConstantes;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.rotulado.IArticuloRotuladoReporteGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRotuladoReporteDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRotuladoReporteID;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloValorConfiguracionPlantillaID;

/**
 * @author acaiza
 * 
 */

public class ArticuloRotuladoReporteGestor implements IArticuloRotuladoReporteGestor {

	private DataGestor dataGestor;
	
	public Collection<ArticuloValorConfiguracionPlantillaDTO> consultarReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Set<Integer> codigosPreguntas, Timestamp fechaInicio, Timestamp fechaFin) {
		Collection<ArticuloValorConfiguracionPlantillaDTO> collection = new ArrayList<ArticuloValorConfiguracionPlantillaDTO>();
		ArticuloRotuladoReporteDTO plantilla = new ArticuloRotuladoReporteDTO();
		if (plantilla.getCriteriaSearch() == null) {
			plantilla.setCriteriaSearch(new CriteriaSearch());
		}
		if (articuloValorConfiguracionPlantillaDTO != null) {
			plantilla.setId(new ArticuloRotuladoReporteID());
			if (articuloValorConfiguracionPlantillaDTO.getId() != null) {
				plantilla.getId().setCodigoValorConfiguracionPlantilla(articuloValorConfiguracionPlantillaDTO.getId().getCodigoValorConfiguracionPlantilla());
				plantilla.getId().setCodigoArticulo(articuloValorConfiguracionPlantillaDTO.getId().getCodigoArticulo());
			}
			
			if (articuloValorConfiguracionPlantillaDTO.getArticulo() != null) {
				if (StringUtils.isNotEmpty(articuloValorConfiguracionPlantillaDTO.getArticulo().getNpCodigoBarras())) {					
					plantilla.setCodigoBarras(articuloValorConfiguracionPlantillaDTO.getArticulo().getNpCodigoBarras());
				}
				if (StringUtils.isNotEmpty(articuloValorConfiguracionPlantillaDTO.getArticulo().getCodigoClasificacion())) {
					//plantilla.setCodigoClasificacion(articuloValorConfiguracionPlantillaDTO.getArticulo().getCodigoClasificacion());
					String[] codigosClasificacionVec = articuloValorConfiguracionPlantillaDTO.getArticulo().getCodigoClasificacion().split(",");
					if (codigosClasificacionVec != null && codigosClasificacionVec.length > 0) {
						plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, codigosClasificacionVec));
					}
				}
			}
			if (articuloValorConfiguracionPlantillaDTO.getUsuarioRegistro() != null) {
				if (StringUtils.isNotEmpty(articuloValorConfiguracionPlantillaDTO.getUsuarioRegistro().getUserName())) {
					plantilla.setUserName(articuloValorConfiguracionPlantillaDTO.getUsuarioRegistro().getUserName());
				}
			}
			if (StringUtils.isNotEmpty(articuloValorConfiguracionPlantillaDTO.getNovedadAuditoria())) {
				plantilla.setNovedadAuditoria(articuloValorConfiguracionPlantillaDTO.getNovedadAuditoria());
			}
			if (StringUtils.isNotEmpty(articuloValorConfiguracionPlantillaDTO.getCodigoProveedor())) {
				//plantilla.setCodigoProveedor(articuloValorConfiguracionPlantillaDTO.getCodigoProveedor());
				plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoJDEProveedor", ComparatorTypeEnum.EQUAL_COMPARATOR, articuloValorConfiguracionPlantillaDTO.getCodigoProveedor()));
			}
		}
		
		
		if (fechaInicio != null) {
			plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.GREATER_THAN_OR_EQUAL_COMPARATOR ,fechaInicio));
		}			
		if (fechaFin != null) {
			plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Timestamp>("fechaRegistro",ComparatorTypeEnum.LESS_THAN_COMPARATOR ,fechaFin));
		}
		
		if (CollectionUtils.isNotEmpty(codigosPreguntas)) {
			Integer[] codigosPreguntasVec = codigosPreguntas.toArray(new Integer[0]);
			plantilla.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoCampoPlantilla", ComparatorTypeEnum.IN_COMPARATOR, codigosPreguntasVec));
		}
		
		String novedadRegistro = articuloValorConfiguracionPlantillaDTO.getNovedadRegistro();
		String novedadAuditoria = articuloValorConfiguracionPlantillaDTO.getNovedadAuditoria();
		
		/*
		//Realiza el set para filtrar la novedad de registro
		if (StringUtils.isEmpty(novedadRegistro)) {
			plantilla.setValorCumple(null);
		} else if ("1".equals(novedadRegistro)) {
			plantilla.setValorCumple("Si");
		} else if ("2".equals(novedadRegistro)) {
			plantilla.setValorCumple("No");
		} else if ("3".equals(novedadRegistro)) {
			plantilla.setValorCumple("NA");
		}
		*/
		if("3".equals(novedadRegistro)){
			plantilla.setValorCumple("NA");
		}
		else if("4".equals(novedadRegistro)){
			plantilla.setValorCumple("No");
		}
		//Realiza el filtro de la novedad de auditoria
		if (CollectionUtils.isEmpty(codigosPreguntas)) {
			
			if (StringUtils.isEmpty(novedadAuditoria)) {
				plantilla.setNovedadAuditoria(null);
			} else if ("0".equals(novedadAuditoria)) {
				plantilla.setNovedadAuditoria(null);
			} else if ("1".equals(novedadAuditoria)) { //1 SI
				plantilla.setNovedadAuditoria("1");
			} else if ("2".equals(novedadAuditoria)) { //2 NO
				plantilla.setNovedadAuditoria("0");
			} else if ("3".equals(novedadAuditoria)) { //3 NO AUDITADO
				plantilla.isNull("novedadAuditoria");
			}
		} else {
			//Filtro por preguntas de auditoria del control de rotulado, obligatoriamente se necesita que el control de rotulado tenga auditoria
			if (StringUtils.isEmpty(novedadAuditoria)) {
				plantilla.setNovedadAuditoria(null);
				plantilla.setValorAuditoria(null);
			} else if ("1".equals(novedadAuditoria)) {//1 SI, LA PREGUNTA ESTA MARCADA CON AUDITORIA
				plantilla.setValorAuditoria("1");
//				plantilla.setNovedadAuditoria("1");
			} else if ("2".equals(novedadAuditoria)) {//2 NO, LA PREGUNTA NO ESTA MARCADA CON AUDITORIA
				plantilla.isNull("valorAuditoria");
				plantilla.setNovedadAuditoria("0");
			} else if ("3".equals(novedadAuditoria)) {//3 NO AUDITADO, EL CONTROL DE ROTULADO NO ESTA AUDITADO
				//plantilla.isNull("valorAuditoria");
				plantilla.isNull("novedadAuditoria");
			}
		}

		//Ordena los registros en base a codigoBarras, fechaRegistro
		plantilla.setOrderByField(OrderBy.orderAsc(new String[] {"codigoBarras","fechaRegistro"}));
		
		//Realiza la consulta en la vista del reporte de control de rotulado
		Collection<ArticuloRotuladoReporteDTO> articuloRotuladoReporteDTOCol = dataGestor.findObjects(plantilla);
		
		//Consolida los registros encontrados en la consulta
		if (CollectionUtils.isNotEmpty(articuloRotuladoReporteDTOCol)) {
			Map<Integer, Collection<ArticuloRotuladoReporteDTO>> map = new LinkedHashMap<Integer, Collection<ArticuloRotuladoReporteDTO>>();
			//Consolida todos los registros que corresponde a un control de rotulado en base al codigoValorConfiguracionPlantilla
			for (ArticuloRotuladoReporteDTO arr : articuloRotuladoReporteDTOCol) {
				if (map.containsKey(arr.getId().getCodigoValorConfiguracionPlantilla()) == false) {
					Collection<ArticuloRotuladoReporteDTO> preguntasRotuladoArticulo = new ArrayList<ArticuloRotuladoReporteDTO>();
					preguntasRotuladoArticulo.add(arr);
					map.put(arr.getId().getCodigoValorConfiguracionPlantilla(), preguntasRotuladoArticulo);
				} else {
					Collection<ArticuloRotuladoReporteDTO> preguntasRotuladoArticulo = map.get(arr.getId().getCodigoValorConfiguracionPlantilla());
					preguntasRotuladoArticulo.add(arr);
				}
			}
			//Recorre cada control de rotulado que esta en el map
			Iterator<Entry<Integer, Collection<ArticuloRotuladoReporteDTO>>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Collection<ArticuloRotuladoReporteDTO>> entry = it.next();
				Integer codigoValorConfiguracionPlantilla = entry.getKey();
				//Logeable.LOG_SICV2.info("reporte codigoValorConfiguracionPlantilla: " +  codigoValorConfiguracionPlantilla);
				//Preguntas del control de rotulado
				ArrayList<ArticuloRotuladoReporteDTO> preguntas = new ArrayList<ArticuloRotuladoReporteDTO>(entry.getValue()); 
				ArticuloRotuladoReporteDTO rep = preguntas.get(0);
				
				ArticuloMedidaDTO articuloMedidaDTO = new ArticuloMedidaDTO();
				articuloMedidaDTO.setReferenciaMedida(rep.getReferenciaMedida());
				
				ArticuloValorConfiguracionPlantillaDTO avcpRegistro = new ArticuloValorConfiguracionPlantillaDTO();
				avcpRegistro.setId(new ArticuloValorConfiguracionPlantillaID());
				avcpRegistro.getId().setCodigoValorConfiguracionPlantilla(codigoValorConfiguracionPlantilla);
				avcpRegistro.setCodigoProveedor(rep.getCodigoProveedor());
				
				avcpRegistro.setArticulo(new ArticuloDTO());
				avcpRegistro.getArticulo().setId(new ArticuloID());
				avcpRegistro.getArticulo().getId().setCodigoArticulo(rep.getId().getCodigoArticulo());
				avcpRegistro.getArticulo().setDescripcionArticulo(rep.getDescripcionArticulo());
				avcpRegistro.getArticulo().setCodigoClasificacion(rep.getCodigoClasificacion());
				avcpRegistro.getArticulo().setNpCodigoBarras(rep.getCodigoBarras());
//				avcpRegistro.getArticulo().setDescripcionArticulo(rep.getDescripcionArticulo());
				avcpRegistro.getArticulo().setArticuloMedidaDTO(articuloMedidaDTO);
				
				avcpRegistro.setFechaRegistro(rep.getFechaRegistro());
				avcpRegistro.setFechaModificacion(rep.getFechaModificacion());
				avcpRegistro.setFechaAuditoria(rep.getFechaAuditoria());
				
				avcpRegistro.setIdUsuarioRegistro(rep.getId().getIdUsuarioRegistro());
				avcpRegistro.setCodigoPadre(rep.getCodigoPadre());
				
				UserDto usuarioRegistro = new UserDto();
				usuarioRegistro.setUserName(rep.getUserName());
				avcpRegistro.setUsuarioRegistro(usuarioRegistro);
				
				UserDto usuarioModificacion = new UserDto();
				usuarioModificacion.setUserName(rep.getUserNameModificacion());
				avcpRegistro.setUsuarioModificacion(usuarioModificacion);
				
				UserDto usuarioAuditoria = new UserDto();
				usuarioAuditoria.setUserName(rep.getUserNameAuditor());
				avcpRegistro.setUsuarioAuditoria(usuarioAuditoria);
				
				Collection<ArticuloRotuladoReporteDTO> preguntasSI = new ArrayList<ArticuloRotuladoReporteDTO>();
				Collection<ArticuloRotuladoReporteDTO> preguntasNO = new ArrayList<ArticuloRotuladoReporteDTO>();
				Collection<ArticuloRotuladoReporteDTO> preguntasNA = new ArrayList<ArticuloRotuladoReporteDTO>();
				Collection<ArticuloRotuladoReporteDTO> preguntasAuditoria = new ArrayList<ArticuloRotuladoReporteDTO>();
				
				//Codigos de busqueda para los valores de la novedad de registro: 1-Si 2-No 3-NA
				
				//Valida los valores de cada una de las preguntas del control de rotulado actual 
				for (ArticuloRotuladoReporteDTO arrDTO : preguntas) {
					//Si el valor es un Si no hay novedad de auditoria
					if ("Si".equals(arrDTO.getValorCumple())) {
						preguntasSI.add(arrDTO);
					} 
					//Si el valor es un No hay novedad de auditoria
					else if ("No".equals(arrDTO.getValorCumple())) {
						preguntasNO.add(arrDTO);
					}
					//Si el valor es un NA hay novedad de auditoria
					else if ("NA".equals(arrDTO.getValorCumple())) {
						preguntasNA.add(arrDTO);
					}
					//Si existe un valor en valorauditoria existe novedad de auditoria
					if (StringUtils.isNotEmpty(arrDTO.getValorAuditoria())) {
						preguntasAuditoria.add(arrDTO);
					}
				}
				
				avcpRegistro.addDynamicProperty("preguntas", preguntas);
				avcpRegistro.addDynamicProperty("preguntasSI", preguntasSI);
				avcpRegistro.addDynamicProperty("preguntasNO", preguntasNO);
				avcpRegistro.addDynamicProperty("preguntasNA", preguntasNA);
				avcpRegistro.addDynamicProperty("preguntasAuditoria", preguntasAuditoria);
				
				//Valida si tiene novedad de registro con No y NA [2-No 3-NA]
				if (CollectionUtils.isNotEmpty(preguntasNO) || CollectionUtils.isNotEmpty(preguntasNA)) {
					avcpRegistro.setNovedadRegistro("Si");
				} else if (CollectionUtils.isEmpty(preguntasNO) && CollectionUtils.isEmpty(preguntasNA)) {
					avcpRegistro.setNovedadRegistro("No");
				}
				
				avcpRegistro.setNovedadAuditoria(rep.getNovedadAuditoria());
				
				//Toma solo los controles de rotulado que coinciden con el valor de la novedad de registro que viene en el parametro de busqueda
				if  (StringUtils.isEmpty(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
					collection.add(avcpRegistro);
				} else {
					//Si la novedad de registro es 0 se guarda todos los controles de rotulado
					if ("0".equals(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
						collection.add(avcpRegistro);
					}
					//Si la novedad de registro es 1 se guarda todos los controles de rotulado que tiene novedad, por lo menos un No en los valores del cumple
					else if ("1".equals(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
						if (CollectionUtils.isNotEmpty(preguntasNO) || CollectionUtils.isNotEmpty(preguntasNA)) { 
							collection.add(avcpRegistro);
						}
					} 
					//Si la novedad de registro es 2 se guarda todos los controles de rotulado que no tienen novedad, todos los valores del cumple son 'Si'
					else if ("2".equals(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
						if (CollectionUtils.isEmpty(preguntasNO) && CollectionUtils.isEmpty(preguntasNA)) { 
							collection.add(avcpRegistro);
						}
					}
					
					else if ("3".equals(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
						if (CollectionUtils.isNotEmpty(preguntasNA)) { 
							avcpRegistro.setMostrarRegistrosNo(Boolean.FALSE);
							collection.add(avcpRegistro);
						}
					}
					
					else if ("4".equals(articuloValorConfiguracionPlantillaDTO.getNovedadRegistro())) {
						if (CollectionUtils.isNotEmpty(preguntasNO)) { 
							avcpRegistro.setMostrarRegistrosNA(Boolean.FALSE);
							collection.add(avcpRegistro);
						}
					}
				}
			}
			
			
		}
//		Logeable.LOG_SICV2.info("articuloRotuladoReporteDTOCol: " + articuloRotuladoReporteDTOCol.size());
		return collection;
	}

	@Override
	public Collection<ArticuloValorConfiguracionPlantillaDTO> obtenerReporteControlRotulado(ArticuloValorConfiguracionPlantillaDTO articuloValorConfiguracionPlantillaDTO, Set<Integer> codigosPreguntas, Timestamp fechaInicio, Timestamp fechaFin) throws SICException {
		//BUSCA LOS REGISTRO DE CONTROL DE ROTULADO
		Collection<ArticuloValorConfiguracionPlantillaDTO> collection = this.consultarReporteControlRotulado(articuloValorConfiguracionPlantillaDTO, codigosPreguntas, fechaInicio, fechaFin);
		//LLENA EL REGISTRO DE CONTROL DE AUDITORIA EN EL CONTROL DE REGISTRO
		if (CollectionUtils.isNotEmpty(collection)) {
			for (ArticuloValorConfiguracionPlantillaDTO avcpRegistro : collection) {
				if (PlantillasConstantes.ESTADO_ACTIVO_BOOLEANO.equals(avcpRegistro.getNovedadAuditoria()) && avcpRegistro.getId() != null && avcpRegistro.getId().getCodigoValorConfiguracionPlantilla() != null) {
					//BUSCAR PRIMERO EN LA COLECCION PARA VER SI ESTA AHI, NO BUSCAR EN LA BBDD
					ArticuloValorConfiguracionPlantillaDTO avcpAuditoria = (ArticuloValorConfiguracionPlantillaDTO) CollectionUtils.find(collection, PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoPadre"), PredicateUtils.equalPredicate(avcpRegistro.getId().getCodigoValorConfiguracionPlantilla())));
					if (avcpAuditoria == null) {
						avcpAuditoria = this.buscarReporteAuditoria(avcpRegistro);
					}
					avcpRegistro.addDynamicProperty("avcpAuditoria", avcpAuditoria);
				}
			}
		}
		return collection;
	}
	
	
	
	public ArticuloValorConfiguracionPlantillaDTO buscarReporteAuditoria(ArticuloValorConfiguracionPlantillaDTO avcpRegistro) {
		ArticuloValorConfiguracionPlantillaDTO reporteAuditoria = null;
		if (avcpRegistro != null && avcpRegistro.getId() != null && avcpRegistro.getId().getCodigoValorConfiguracionPlantilla() != null) {
			ArticuloValorConfiguracionPlantillaDTO plantilla = new ArticuloValorConfiguracionPlantillaDTO();
			plantilla.setId(new ArticuloValorConfiguracionPlantillaID());
			plantilla.getId().setCodigoArticulo(avcpRegistro.getId().getCodigoArticulo());
			plantilla.getId().setCodigoCompania(avcpRegistro.getId().getCodigoCompania());
			plantilla.setCodigoPadre(avcpRegistro.getId().getCodigoValorConfiguracionPlantilla());

			Collection<ArticuloValorConfiguracionPlantillaDTO> coll = this.dataGestor.findObjects(plantilla);
			if (CollectionUtils.isNotEmpty(coll)) {
				ArticuloValorConfiguracionPlantillaDTO plantillaAVCPAuditoria = coll.iterator().next();
				Set<Integer> preguntasSeleccionadas = null;
				Timestamp fechaI = null;
				Timestamp fechaF = null;
				plantillaAVCPAuditoria.setArticulo(null);
				plantillaAVCPAuditoria.setUsuarioRegistro(null);
				Collection<ArticuloValorConfiguracionPlantillaDTO> avcpReporteAuditoriaCol = this.consultarReporteControlRotulado(plantillaAVCPAuditoria,
						preguntasSeleccionadas, fechaI, fechaF);
				if (CollectionUtils.isNotEmpty(avcpReporteAuditoriaCol)) {
					reporteAuditoria = avcpReporteAuditoriaCol.iterator().next();
				}
			}
		}
		return reporteAuditoria;
	}

	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor
	 *            the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

}
