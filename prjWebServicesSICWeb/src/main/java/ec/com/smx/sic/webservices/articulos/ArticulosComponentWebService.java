package ec.com.smx.sic.webservices.articulos;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;


/**
 * @author guvidia
 * 
 */

@Controller
@RequestMapping("/ws/articulos")
@Scope(value = "request")
public class ArticulosComponentWebService {
	
	@RequestMapping(value = "/datosagrupador", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> findDatosComponentAgrupador(
			@RequestParam(value = "codigoCompania", required = true) String codigoCompania) {
		
		LOG_SICV2.info("Inicio web service findDatosComponentAgrupador, codigoCompania: {}", codigoCompania);
		Collection<CatalogoValorDTO> agrupadoresCol = null;
		
		HttpHeaders headers = null;
		String datos = "[]";
		try{
			agrupadoresCol = obtenerAgrupadoresPadre(SICArticuloConstantes.CATALOGOTIPO_AGRUPADOR);
			
			if( CollectionUtils.isNotEmpty(agrupadoresCol) ){
				datos = JsonPojoMapper.getInstance().writeValueAsString(this.construirDatosArticulos(agrupadoresCol));
			}
	
			headers = new HttpHeaders();					
			headers.add("Content-Type", "text/html; charset=utf-8");
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/datosmarcasespeciales", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> findDatosComponentTipoMarcasEspeciales(@RequestParam(value = "valoresAgrupador", required = true) String valoresAgrupador) {
		
		LOG_SICV2.info("Inicio web service findDatosComponentTipoMarcasEspeciales: {}");
		Collection<CatalogoValorDTO> agrupadoresCol = null;
		
		HttpHeaders headers = null;
		String datos = "[]";
		try{
			Map<String, Object> mapValorAgrupador = transformarParametrosAgrupador(valoresAgrupador);
			if( mapValorAgrupador != null ){
				if( mapValorAgrupador.get("caracteristicasEspeciales") == null || 
						( mapValorAgrupador.get("caracteristicasEspeciales") != null && mapValorAgrupador.get("caracteristicasEspeciales").equals("[]"))){
					mapValorAgrupador.put("caracteristicasEspeciales",new ArrayList<Map<String, Object>>());
				}
				if( mapValorAgrupador.get("cabecera") == null ){
					mapValorAgrupador.put("cabecera", Boolean.FALSE);
				}
			}
			final Boolean esCabecera = Boolean.valueOf(mapValorAgrupador.get("cabecera").toString());
		
			Collection<ArticuloEdicionMasivaVO> agrupadores = obtenerArticuloAgrupador((Collection<Map<String, Object>>)mapValorAgrupador.get("caracteristicasEspeciales"));
			
			agrupadoresCol = obtenerAgrupadoresCaracEspe(TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES);
			
			if( CollectionUtils.isNotEmpty(agrupadoresCol) ){
				datos = JsonPojoMapper.getInstance().writeValueAsString(this.construirDatosArticulosMarcaEspecial(agrupadoresCol, agrupadores, esCabecera));
			}
			
	
			headers = new HttpHeaders();					
			headers.add("Content-Type", "text/html; charset=utf-8");
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param valoresAgrupador
	 * @return
	 */
	private Collection<ArticuloEdicionMasivaVO> obtenerArticuloAgrupador(Collection<Map<String, Object>> mapValorAgrupador){
		LOG_SICV2.info("Metodo : obtenerArticuloAgrupador {}");
		Collection<ArticuloEdicionMasivaVO> agrupadores = null;
		try{
			if(CollectionUtils.isNotEmpty(mapValorAgrupador)){
				agrupadores = new ArrayList<ArticuloEdicionMasivaVO>(); 
				for (Map<String, Object> map : mapValorAgrupador) {
					if( map.get("codigoArticulo") != null && map.get("codigoTipoAgrupador") != null && map.get("valorTipoAgrupador") != null && map.get("event") != null ){
						ArticuloEdicionMasivaVO agr = new ArticuloEdicionMasivaVO();
						agr.setCodigoArticulo(map.get("codigoArticulo").toString());
						agr.setCodigoTipoAgrupador(Integer.valueOf(map.get("codigoTipoAgrupador").toString()));
						agr.setValorTipoAgrupador(map.get("valorTipoAgrupador").toString());
						agr.setEvent(map.get("event").toString());
						agrupadores.add(agr);
					}
				}
			}
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return agrupadores;		
	}
	
	/**
	 * Obtiene los agrupadores padre y sus relaciones enviando como parametro el codigo del catalogo tipo
	 * @param codigoCatalogoTipo
	 * @return
	 */
	public Collection<CatalogoValorDTO> obtenerAgrupadoresPadre(Integer... codigoCatalogoTipo){
		Collection<CatalogoValorDTO> agrupadoresCol = null;
		if( codigoCatalogoTipo != null ){
			agrupadoresCol = SICFactory.getInstancia().articulo.getArticuloService().obtenerAgrupadoresPadres(codigoCatalogoTipo);
			Collection<CatalogoValorDTO> agrupadoresHijos = null;			
			for(CatalogoValorDTO catalogoValorDTO : agrupadoresCol){ 
				agrupadoresHijos = SICFactory.getInstancia().articulo.getArticuloService().obtenerAgrupadoresHijos(catalogoValorDTO);
				if(CollectionUtils.isNotEmpty(agrupadoresHijos)){
					catalogoValorDTO.setCatalogosRelacionadosDTO(agrupadoresHijos);
				}
			}
		}
		return agrupadoresCol;
	}
	
	/**
	 * Obtiene los agrupadores enviando como parametro el codigo del catalogo tipo
	 * @param codigoCatalogoTipo
	 * @return
	 */
	public Collection<CatalogoValorDTO> obtenerAgrupadoresCaracEspe(Integer codigoCatalogoTipo){
		Collection<CatalogoValorDTO> agrupadoresCol = null;
		if( codigoCatalogoTipo != null ){			
			CatalogoValorDTO catalogoValorDTO = new CatalogoValorDTO();
			catalogoValorDTO.setEstado(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
			catalogoValorDTO.getId().setCodigoCatalogoTipo(codigoCatalogoTipo);
			agrupadoresCol = SICFactory.getInstancia().administracion.getDataService().findObjects(catalogoValorDTO);
		}
		return agrupadoresCol;
	}
	
	/**
	 * 
	 * @param agrupadoresCol
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unused")
	private DatosBusquedaArticulosJSON construirDatosArticulos(Collection<CatalogoValorDTO> agrupadoresCol) throws SICException{
		Integer contador = 0;
		Integer contadorHijo = 0;
		Map<String, Object> datos = null;
		DatosBusquedaArticulosJSON datosAgr = new DatosBusquedaArticulosJSON();
		if( CollectionUtils.isNotEmpty(agrupadoresCol) ){
			Collection<Map<String, Object>> datosArticuloCol = new ArrayList<Map<String,Object>>();		
			datos = new HashMap<String, Object>();
			for ( CatalogoValorDTO catalogo : agrupadoresCol ) {					
				Map<String, Object> agrupador = new HashMap<String, Object>();
				agrupador.put("id", contador);
				agrupador.put("idx", contador);
				agrupador.put("indent", 0);
				agrupador.put("_collapsed", Boolean.TRUE);
				agrupador.put("isParent", Boolean.TRUE);
				agrupador.put("hijo", Boolean.FALSE);
				agrupador.put("codigoCatalogoValor", catalogo.getId().getCodigoCatalogoValor());
				agrupador.put("codigoCatalogoTipo", catalogo.getId().getCodigoCatalogoTipo());
				agrupador.put("nombre", catalogo.getNombreCatalogoValor());				
									
				datosArticuloCol.add(agrupador);
				
				if( SearchDTO.isLoaded(catalogo.getCatalogosRelacionadosDTO()) && 
						CollectionUtils.isNotEmpty(catalogo.getCatalogosRelacionadosDTO()) ){
					contadorHijo = contador;
					for (CatalogoValorDTO catalogoRel : catalogo.getCatalogosRelacionadosDTO()) {
						contadorHijo++;
						Map<String, Object> agrupadorRel = new HashMap<String, Object>();
						agrupadorRel.put("id", contadorHijo);
						agrupadorRel.put("idx", contadorHijo);
						agrupadorRel.put("indent", 1);
						agrupadorRel.put("parent", contador);
						agrupadorRel.put("isParent", Boolean.FALSE);
						agrupadorRel.put("hijo", Boolean.TRUE);
						agrupadorRel.put("codigoCatalogoValor", catalogoRel.getId().getCodigoCatalogoValor());
						agrupadorRel.put("codigoCatalogoTipo", catalogoRel.getId().getCodigoCatalogoTipo());
						agrupadorRel.put("nombre", catalogoRel.getNombreCatalogoValor());
						datosArticuloCol.add(agrupadorRel);
					}
					contador = contadorHijo;
				}				
				contador++;
			}			
			// COLUMNAS
			Collection<CabeceraColumnaJSON> articuloColumns = new ArrayList<CabeceraColumnaJSON>();		
			CabeceraColumnaJSON columnNombre = new CabeceraColumnaJSON();
			columnNombre.setId("nombre");
			columnNombre.setWidth(240);
			columnNombre.setField("nombre");
			columnNombre.setName("Descripci\u00F3n");
			columnNombre.setToolTip("Descripci\u00F3n");
			articuloColumns.add(columnNombre);
			// asignar los datos 
			datosAgr.setColumnasCabecera(articuloColumns);
			datosAgr.setDatosArticuloCol(datosArticuloCol);
		}
		return datosAgr;
	}
	
	/**
	 * 
	 * @param agrupadoresCol
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unused")
	private DatosBusquedaArticulosJSON construirDatosArticulosMarcaEspecial(Collection<CatalogoValorDTO> agrupadoresCol, Collection<ArticuloEdicionMasivaVO> agrupadores, final Boolean esCabecera) throws SICException{
		Integer contador = 0;
		String valorActivo = "1";
		Map<String, Object> datos = null;
		DatosBusquedaArticulosJSON datosAgr = new DatosBusquedaArticulosJSON();
		if( CollectionUtils.isNotEmpty(agrupadoresCol) ){
			Collection<Map<String, Object>> datosArticuloCol = new ArrayList<Map<String,Object>>();		
			datos = new HashMap<String, Object>();
			for ( CatalogoValorDTO catalogo : agrupadoresCol ) {					
				Map<String, Object> agrupador = new HashMap<String, Object>();
				agrupador.put("id", contador);
				agrupador.put("esCabecera", esCabecera);
				agrupador.put("codigoCatalogoValor", catalogo.getId().getCodigoCatalogoValor());
				agrupador.put("codigoCatalogoTipo", catalogo.getId().getCodigoCatalogoTipo());
				ArticuloEdicionMasivaVO caracEsp = (ArticuloEdicionMasivaVO)CollectionUtils.find(agrupadores, new BeanPredicate("valorTipoAgrupador", PredicateUtils.equalPredicate(catalogo.getId().getCodigoCatalogoValor())));
				if( caracEsp == null ){
					agrupador.put("checkMarcaEspecial", null);
				}else{
					agrupador.put("checkMarcaEspecial", valorActivo.equals(caracEsp.getEvent()));
				}
				agrupador.put("nombre", catalogo.getNombreCatalogoValor());		
				
				datosArticuloCol.add(agrupador);				
						
				contador++;
			}			
			// COLUMNAS
			// columna check
			Collection<CabeceraColumnaJSON> articuloColumns = new ArrayList<CabeceraColumnaJSON>();		
			if( esCabecera ){
				CabeceraColumnaJSON columnCheck = new CabeceraColumnaJSON();
				columnCheck.setId("checkMarcaEspecial");
				columnCheck.setName("Seleccione");
				columnCheck.setField("checkMarcaEspecial");
				columnCheck.setEditor("SelectCellEditor");
				columnCheck.setWidth(100);
				columnCheck.setFormatter("SelectFormatter");
				columnCheck.setCssClass("cell-effort-driven");
				articuloColumns.add(columnCheck);
			}
			// columna descripcion
			CabeceraColumnaJSON columnNombre = new CabeceraColumnaJSON();
			columnNombre.setId("nombre");
			columnNombre.setWidth(240);
			columnNombre.setField("nombre");
			columnNombre.setName("Descripci\u00F3n");
			columnNombre.setToolTip("Descripci\u00F3n");
			articuloColumns.add(columnNombre);
			// asignar los datos 
			datosAgr.setColumnasCabecera(articuloColumns);
			datosAgr.setDatosArticuloCol(datosArticuloCol);
		}
		return datosAgr;
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, Object> transformarParametrosAgrupador(String param){
		LOG_SICV2.info("METODO :: transformarParametrosAgrupador {}");
		Map<String, Object> result = null;
		try {
			if( StringUtils.isNotEmpty(param) ){
				result = JsonPojoMapper.getInstance().readValue(param, new TypeReference<Map<String, Object>>() {});
				LOG_SICV2.info("Numero de datos:: " + result.size());
			}
		} catch (JsonParseException e) {			
			LOG_SICV2.error("METODO :: transformarParametrosAgrupador {}");
		} catch (JsonMappingException e) {
			LOG_SICV2.error("METODO :: transformarParametrosAgrupador {}");
		} catch (IOException e) {
			LOG_SICV2.error("METODO :: transformarParametrosAgrupador {}");
		}		
		return result;
	}
	
	class CabeceraColumnaJSON implements Serializable{
		private static final long serialVersionUID = 1L;
		private String id;
		private String name;
		private String field;
		private String cssClass;
		private Integer width = 100;
		private String formatter;
		private String toolTip;
		private String editor;
		
		private static final String TEMPLATE = "{id: \"%s\", name: \"%s\", field: \"%s\", toolTip: \"%s\",formatter:%s, cssClass:\"%s\", width: %s, editor:%s}";

		@Override
		public String toString() {
			return String.format(TEMPLATE, id, name, field, toolTip, formatter, cssClass, width, editor);
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getCssClass() {
			return cssClass;
		}

		public void setCssClass(String cssClass) {
			this.cssClass = cssClass;
		}

		public String getFormatter() {
			return formatter;
		}

		public void setFormatter(String formatter) {
			this.formatter = formatter;
		}

		public String getToolTip() {
			return toolTip;
		}

		public void setToolTip(String toolTip) {
			this.toolTip = toolTip;
		}

		public Integer getWidth() {
			return width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public String getEditor() {
			return editor;
		}

		public void setEditor(String editor) {
			this.editor = editor;
		}
		
	}
	
	class DatosBusquedaArticulosJSON implements Serializable{	
		private static final long serialVersionUID = 1L;
		private Collection<?> columnasCabecera;
		Collection<Map<String, Object>> datosArticuloCol;
		private Boolean tieneDatos;		

		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder("[");
			if (CollectionUtils.isNotEmpty(columnasCabecera)) {
				for (Object columna : columnasCabecera) {
					builder.append(columna.toString());
					builder.append(",");
				}
			}
			builder.append("]");
			return builder.toString();
		}

		public Boolean getTieneDatos() {
			if( CollectionUtils.isEmpty(this.columnasCabecera) || CollectionUtils.isEmpty(this.datosArticuloCol) ) this.tieneDatos = Boolean.FALSE;
			else this.tieneDatos = Boolean.TRUE;			
			return tieneDatos;
		}

		public Collection<Map<String, Object>> getDatosArticuloCol() {
			return datosArticuloCol;
		}

		public void setDatosArticuloCol(Collection<Map<String, Object>> datosArticuloCol) {
			this.datosArticuloCol = datosArticuloCol;
		}

		public Collection<?> getColumnasCabecera() {
			return columnasCabecera;
		}

		public void setColumnasCabecera(Collection<?> columnasCabecera) {
			this.columnasCabecera = columnasCabecera;
		}
		
	}
		
}
