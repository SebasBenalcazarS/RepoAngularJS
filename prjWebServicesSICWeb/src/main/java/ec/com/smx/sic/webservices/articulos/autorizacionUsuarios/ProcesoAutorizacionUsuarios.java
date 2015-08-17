package ec.com.smx.sic.webservices.articulos.autorizacionUsuarios;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;

/**
 * 
 * @author cortiz
 *
 */

@Controller
@RequestMapping("/ws/autorizacionUsuarios")
@Scope(value = "request")
public class ProcesoAutorizacionUsuarios {

	// @ManagedProperty(value = "#{sessionDataManagerBase}")
	// private SessionDataManagerBase sessionDataManagerBase;
	/**
	 * metodo para consultar los funcionarios del local insertado
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param usuarioSesion
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/datosfuncionarios", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findFuncionariosLocal(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoLocal", required = true) Integer codigoLocal,
			@RequestParam(value = "usuarioSesion", required = true) String usuarioSesion,
			@RequestParam(value = "usuario", required = false) String usuario) {

		LOG_SICV2.info(
				"Inicio web service findFuncionariosLocal, codigoCompania: {}",
				codigoCompania);
		LOG_SICV2.info("codigoLocal: {}", codigoLocal);
		LOG_SICV2.info("usuario: {}", usuario);
		Collection<FuncionarioLocal> funcionariosCol = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			funcionariosCol = obtenerFuncionariosLocal(codigoCompania,
					codigoLocal, usuario, usuarioSesion);
			LOG_SICV2.info("funcionarios: {}", funcionariosCol.size());

			if (CollectionUtils.isNotEmpty(funcionariosCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						funcionariosCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	/**
	 * Obtiene los funcionarios del local ingresado
	 * 
	 */
	public Collection<FuncionarioLocal> obtenerFuncionariosLocal(
			Integer codigoCompania, Integer codigoLocal, String usuario,
			String usuarioSesion) {
		try {
			Collection<FuncionarioAreaTrabajoDTO> funcionariosCol = null;
			Collection<FuncionarioLocal> funFormat = new ArrayList<ProcesoAutorizacionUsuarios.FuncionarioLocal>();
			if (codigoCompania != null && codigoLocal != null) {
				AreaTrabajoDTO areaTrabajo = new AreaTrabajoDTO();
				areaTrabajo.getId().setCodigoCompania(codigoCompania);
				areaTrabajo.getId().setCodigoAreaTrabajo(codigoLocal);
				funcionariosCol = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.consultarFuncionarioAreaTrabajoPorAreaTrabajo(
								areaTrabajo, usuario, usuarioSesion);
			}
			if (CollectionUtils.isNotEmpty(funcionariosCol)) {

				for (FuncionarioAreaTrabajoDTO funcionario : funcionariosCol) {
					FuncionarioLocal fun = new FuncionarioLocal();
					fun.setUserId(funcionario.getFuncionarioDTO()
							.getUsuarioDTO().getUserId());
					fun.setIdCodigoCompania(funcionario.getId()
							.getCodigoCompania());
					fun.setIdCodigoAreaTrabajo(funcionario.getId()
							.getCodigoAreaTrabajo());
					fun.setIdCodigoFuncionario(funcionario.getId()
							.getCodigoFuncionario());
					fun.setUserCompleteName(funcionario.getFuncionarioDTO()
							.getUsuarioDTO().getUserCompleteName());
					fun.setUserName(funcionario.getFuncionarioDTO()
							.getUsuarioDTO().getUserName());
					fun.setNombreAreaTrabajo(funcionario.getAreaTrabajoDTO()
							.getNombreAreaTrabajo());
					funFormat.add(fun);
				}
			}
			return funFormat;
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	public class FuncionarioLocal {

		private String userId;
		private Integer idCodigoCompania;
		private String idCodigoFuncionario;
		private Integer idCodigoAreaTrabajo;
		private String nombreAreaTrabajo;
		private String userName;
		private String userCompleteName;

		public Integer getIdCodigoCompania() {
			return idCodigoCompania;
		}

		public void setIdCodigoCompania(Integer idCodigoCompania) {
			this.idCodigoCompania = idCodigoCompania;
		}

		public String getIdCodigoFuncionario() {
			return idCodigoFuncionario;
		}

		public void setIdCodigoFuncionario(String idCodigoFuncionario) {
			this.idCodigoFuncionario = idCodigoFuncionario;
		}

		public Integer getIdCodigoAreaTrabajo() {
			return idCodigoAreaTrabajo;
		}

		public void setIdCodigoAreaTrabajo(Integer idCodigoAreaTrabajo) {
			this.idCodigoAreaTrabajo = idCodigoAreaTrabajo;
		}

		public String getNombreAreaTrabajo() {
			return nombreAreaTrabajo;
		}

		public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
			this.nombreAreaTrabajo = nombreAreaTrabajo;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserCompleteName() {
			return userCompleteName;
		}

		public void setUserCompleteName(String userCompleteName) {
			this.userCompleteName = userCompleteName;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

	}

	@RequestMapping(value = "/clasesArticulos", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findClasesArticulos(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania) {

		LOG_SICV2.info("==== Inici� web service findClasesArticulos ====");

		LOG_SICV2.info(
				"Inicio web service findClasesArticulos, codigoCompania: {}",
				codigoCompania);
		Collection<ClaseArticulo> claseArticuloCol = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			claseArticuloCol = obtenerClaseArticulo(codigoCompania);
			LOG_SICV2.info("clases de articulos: {}", claseArticuloCol.size());

			if (CollectionUtils.isNotEmpty(claseArticuloCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						claseArticuloCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	// ************REVISAR INSTANCIAS DE LAS CLASES
	// UTILIZADAS*******************
	public Collection<ClaseArticulo> obtenerClaseArticulo(Integer codigoCompania) {
		try {
			Collection<ClaseArticuloDTO> claseArticuloCol = null;
			Collection<ClaseArticulo> claseArtFormat = new ArrayList<ProcesoAutorizacionUsuarios.ClaseArticulo>();
			if (codigoCompania != null) {
				// -------------------------JAR AreaTrabajoDTO
				// ----------------------------------
				claseArticuloCol = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.consultarClaseArticulos(codigoCompania);
			}
			if (CollectionUtils.isNotEmpty(claseArticuloCol)) {
				// -------------------------JAR ClaseArticuloDTO
				// ----------------------------------
				for (ClaseArticuloDTO clasearticulo : claseArticuloCol) {
					ClaseArticulo claseArt = new ClaseArticulo();
					claseArt.setIdCodigoCompania(clasearticulo.getId()
							.getCodigoCompania());
					claseArt.setName(clasearticulo.getName());
					claseArt.setCodigoclasearticulo(clasearticulo.getId()
							.getCodigoClaseArticulo());
					claseArt.setStatus(clasearticulo.getStatus());
					claseArtFormat.add(claseArt);
				}
			}
			return claseArtFormat;
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	public class ClaseArticulo {

		private Integer idCodigoCompania;
		private String status;
		private String codigoclasearticulo;
		private String name;

		// private String CODIGOCOMPANIA;
		public Integer getIdCodigoCompania() {
			return idCodigoCompania;
		}

		public void setIdCodigoCompania(Integer idCodigoCompania) {
			this.idCodigoCompania = idCodigoCompania;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCodigoclasearticulo() {
			return codigoclasearticulo;
		}

		public void setCodigoclasearticulo(String codigoclasearticulo) {
			this.codigoclasearticulo = codigoclasearticulo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	/**
	 Metodo para obtener los articulos que no estan asignados al usuario
	 * logueado
	 * @param data
	 * @throws SICException
	 */
	@RequestMapping(value = "/findAllArticulos", method = RequestMethod.POST, headers = "Accept= application/json;charset=UTF-8")
	
	public @ResponseBody  ResponseEntity<String> findAllArticulos(@RequestBody String  data)
			//throws SICException 
	{
		JsonParser parser = new JsonParser();
		JsonObject jsonData =	(JsonObject)parser.parse(data);
		Integer codigoCompania = jsonData.get("codigoCompania").getAsInt();
		Integer maxResult = jsonData.get("maxResult").getAsInt();
		Integer firstResult = jsonData.get("firstResult").getAsInt();
		String usuarioSesion = jsonData.get("usuarioSesion").toString().replace("\"","");
		String codigoBarras = jsonData.get("codigoBarras").toString().replace("\"","");
		String descripcion = jsonData.get("descripcion").toString().replace("\"","");
		String codigoEstructura= jsonData.get("codigoEstructura").toString().replace("\"","");
		JsonObject jsonObject = (JsonObject) jsonData.get("clasesArticulos");
		ArrayList<String> resultArrayClaseArticulos = new ArrayList<String>();
		
		if (jsonObject != null) {
			JsonArray jsonE= (JsonArray)jsonObject.get("claseArticulo");	
			for(int i=0; i<jsonE.size(); i++){
				resultArrayClaseArticulos.add(jsonE.get(i).toString().replace("\"",""));
			}
		}
		
		LOG_SICV2.info("Inicio web service findArticulosUsuario, codigoCompania: {}",codigoCompania);
		LOG_SICV2.info("maxResult: {}", maxResult);
		LOG_SICV2.info("firstResult: {}", firstResult);
		LOG_SICV2.info("usuarioSesion: {}", usuarioSesion);
		LOG_SICV2.info("codigoBarras: {}", codigoBarras);
		LOG_SICV2.info("descripcion: {}", descripcion);
		LOG_SICV2.info("codigoEstructura: {}", codigoEstructura);
		LOG_SICV2.info("claseArticulo: {}", resultArrayClaseArticulos);
		
		Collection<Articulo> articulosCol = null;
		Map<String, Object> mapArticulosNum= new HashMap<String, Object>();
		Integer numArticulos=0;
		Collection<ArticuloDTO> articuloDTOCol= null;

//			ResponseEntity<String> re=findArticulosUsuario(codigoCompania, maxResult,
//				firstResult, usuarioSesion, codigoBarras, descripcion,
//				codigoEstructura, resultArrayClaseArticulos);
//		return re;
		HttpHeaders headers = null;
		String datos = "[]";
		Integer datoNumArticulos = 0;
		String dataFail = "{\"status\":\"FAIL\"}";
		try {
			mapArticulosNum = obtenerArticulosUsuario(codigoCompania, maxResult,
					firstResult, usuarioSesion, codigoBarras, descripcion,
					codigoEstructura, resultArrayClaseArticulos);
			
			articuloDTOCol = (Collection<ArticuloDTO>)mapArticulosNum.get("articulos");
			
			articulosCol = retornarArticulo(articuloDTOCol);
			numArticulos = (Integer)mapArticulosNum.get("cantidad");
		
			LOG_SICV2.info("articulos: {}", articulosCol.size());

			mapArticulosNum.clear();
			
			mapArticulosNum.put("numeroArticulos", numArticulos);
			mapArticulosNum.put("coleccionArticulos", articulosCol);
			

			if (mapArticulosNum != null && mapArticulosNum.size()>0) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						mapArticulosNum);
			}
			//datoNumArticulos= (Integer)JsonPojoMapper.getInstance().writeValueAsString(numArticulos);
			
			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers,
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
		
	}
	
	private Collection<Articulo> retornarArticulo(Collection<ArticuloDTO> articuloDTOColeccion){
		Collection<Articulo> articulosCol = new ArrayList<ProcesoAutorizacionUsuarios.Articulo>();
		for (ArticuloDTO articuloDTO : articuloDTOColeccion) {
			String vunidadManejo = "";
			if (CollectionUtils.isNotEmpty(articuloDTO
					.getArticuloUnidadManejoCol())) {
				if (articuloDTO.getArticuloUnidadManejoCol().iterator()
						.next().getValorUnidadManejo() != null) {
					vunidadManejo = articuloDTO
							.getArticuloUnidadManejoCol().iterator()
							.next().getValorUnidadManejo().toString();
				}
			}
			Articulo art= new Articulo();
			art.setClaseArticulo(articuloDTO.getClaseArticulo());
			art.setCodigoBarras(articuloDTO.getCodigoBarras());
			art.setCodigoClasificacion(articuloDTO.getCodigoClasificacion());
			art.setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			art.setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			art.setDescripcion(articuloDTO.getDescripcionArticulo());
			art.setReferenciaMedida(articuloDTO.getArticuloMedidaDTO().getReferenciaMedida());
			art.setValorUnidadManejo(vunidadManejo);
			articulosCol.add(art);
		}
		return articulosCol;
	}

	/**
	 * Metodo para obtener los articulos que no estan asignados al usuario
	 * logueado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/articulosUsuario", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findArticulosUsuario(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "maxResult", required = true) Integer maxResult,
			@RequestParam(value = "firstResult", required = true) Integer firstResult,
			@RequestParam(value = "usuarioSesion", required = true) String usuarioSesion,
			@RequestParam(value = "codigoBarras", required = false) String codigoBarras,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "codigoEstructura", required = false) String codigoEstructura,
			@RequestParam(value = "claseArticulo", required = false) ArrayList<String> codigoclaseArticulo) {

		LOG_SICV2.info(
				"Inicio web service findArticulosUsuario, codigoCompania: {}",
				codigoCompania);
		LOG_SICV2.info("maxResult: {}", maxResult);
		LOG_SICV2.info("firstResult: {}", firstResult);
		LOG_SICV2.info("usuarioSesion: {}", usuarioSesion);
		LOG_SICV2.info("codigoBarras: {}", codigoBarras);
		LOG_SICV2.info("descripcion: {}", descripcion);
		LOG_SICV2.info("codigoEstructura: {}", codigoEstructura);
		LOG_SICV2.info("claseArticulo: {}", codigoclaseArticulo);
		// LOG_SICV2.info("valorUnidadManejo: {}", valorUnidadManejo);
		Collection<Articulo> articulosCol = null;
		Map<String, Object> mapContArticulos= new HashMap<String, Object>();
		HttpHeaders headers = null;
		String datos = "[]";
		String dataFail = "{\"status\":\"FAIL\"}";
		try {
			mapContArticulos= obtenerArticulosUsuario(codigoCompania, maxResult,
					firstResult, usuarioSesion, codigoBarras, descripcion,
					codigoEstructura, codigoclaseArticulo);
			
			articulosCol = (Collection<Articulo>)mapContArticulos.get("articulos");
			LOG_SICV2.info("funcionarios: {}", articulosCol.size());

			if (CollectionUtils.isNotEmpty(articulosCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						articulosCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers,
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Map<String, Object> obtenerArticulosUsuario(Integer codigoCompania,
			Integer maxResult, Integer firstResult, String usuarioSesion,
			String codigoBarras, String descripcion, String codigoEstructura,
			ArrayList<String> codClaseArticulos) {
		try {
			Collection<ArticuloDTO> articulos = new ArrayList<ArticuloDTO>();
			Map<String, Object> articulosNum= new HashMap<String, Object>();
			Integer numArticulos=0;
			// ArticuloDTO art = new ArticuloDTO();
			Collection<Articulo> articulosCol = new ArrayList<ProcesoAutorizacionUsuarios.Articulo>();
			ArticuloVO articuloVO = new ArticuloVO();

			if (codigoCompania != null && maxResult != null
					&& firstResult != null && usuarioSesion != null) {
				articuloVO.setBaseDTO(new ArticuloDTO());
				articuloVO.getBaseDTO().getId()
						.setCodigoCompania(codigoCompania);
				articuloVO.setMaxResults(maxResult);
				articuloVO.setFirstResult(firstResult);
				if(StringUtils.isNotEmpty(codigoBarras)){
					articuloVO.getBaseDTO().setCodigoBarras(codigoBarras);
				}
				if(StringUtils.isNotEmpty(descripcion)){
					articuloVO.getBaseDTO().setDescripcionArticulo(descripcion);
				}
				if(StringUtils.isNotEmpty(codigoEstructura)){
					articuloVO.getBaseDTO().setCodigoClasificacion(codigoEstructura);
				}
				//articuloVO.getBaseDTO().setClaseArticulo(codClaseArticulo);
				if(CollectionUtils.isNotEmpty(codClaseArticulos)){
					articuloVO.getBaseDTO().setNpClases(codClaseArticulos);
				}
				
				articulosNum = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio().obtenerArticulos(
								articuloVO, usuarioSesion);
			}
			
			articulos=(Collection<ArticuloDTO>)articulosNum.get("articulos");
			numArticulos=(Integer)articulosNum.get("cantidad");
			
			if (CollectionUtils.isNotEmpty(articulos)) {
				for (ArticuloDTO articulo : articulos) {
					String vunidadManejo = "";
					if (CollectionUtils.isNotEmpty(articulo
							.getArticuloUnidadManejoCol())) {
						if (articulo.getArticuloUnidadManejoCol().iterator()
								.next().getValorUnidadManejo() != null) {
							vunidadManejo = articulo
									.getArticuloUnidadManejoCol().iterator()
									.next().getValorUnidadManejo().toString();
						}
					}
					Articulo art = new Articulo();
					art.setCodigoArticulo(articulo.getId().getCodigoArticulo());
					art.setCodigoCompania(articulo.getId().getCodigoCompania());
					art.setDescripcion(articulo.getDescripcionArticulo());
					art.setCodigoBarras(articulo.getCodigoBarras());
					art.setClaseArticulo(articulo.getClaseArticulo());
					art.setReferenciaMedida(articulo.getArticuloMedidaDTO()
							.getReferenciaMedida());
					art.setCodigoClasificacion(articulo
							.getCodigoClasificacion());
					art.setValorUnidadManejo(vunidadManejo);
					articulosCol.add(art);
				}
			}
			Map<String, Object> articulosCant= new HashMap<String, Object>();
			articulosCant.put("cantidad", numArticulos);
			articulosCant.put("articulos", articulos);

			return articulosCant;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	public class Articulo {

		String codigoArticulo;
		Integer codigoCompania;
		String descripcion;
		String codigoBarras;
		String claseArticulo;
		String referenciaMedida;
		String codigoClasificacion;
		String valorUnidadManejo;

		public String getValorUnidadManejo() {
			return valorUnidadManejo;
		}

		public void setValorUnidadManejo(String valorUnidadManejo) {
			this.valorUnidadManejo = valorUnidadManejo;
		}

		public String getCodigoArticulo() {
			return codigoArticulo;
		}

		public void setCodigoArticulo(String codigoArticulo) {
			this.codigoArticulo = codigoArticulo;
		}

		public Integer getCodigoCompania() {
			return codigoCompania;
		}

		public void setCodigoCompania(Integer codigoCompania) {
			this.codigoCompania = codigoCompania;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getCodigoBarras() {
			return codigoBarras;
		}

		public void setCodigoBarras(String codigoBarras) {
			this.codigoBarras = codigoBarras;
		}

		public String getClaseArticulo() {
			return claseArticulo;
		}

		public void setClaseArticulo(String claseArticulo) {
			this.claseArticulo = claseArticulo;
		}

		public String getReferenciaMedida() {
			return referenciaMedida;
		}

		public void setReferenciaMedida(String referenciaMedida) {
			this.referenciaMedida = referenciaMedida;
		}

		public String getCodigoClasificacion() {
			return codigoClasificacion;
		}

		public void setCodigoClasificacion(String codigoClasificacion) {
			this.codigoClasificacion = codigoClasificacion;
		}

	}

	/**
	 * Metodo para obtener los articulos que estan asignados al usuario logueado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/articulosPorUsuario", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findArticulosPorUsuario(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "maxResult", required = true) Integer maxResult,
			@RequestParam(value = "firstResult", required = true) Integer firstResult,
			@RequestParam(value = "usuario", required = true) String usuario) {

		LOG_SICV2
				.info("Inicio web service findArticulosPorUsuario, codigoCompania: {}",
						codigoCompania);
		LOG_SICV2.info("maxResult: {}", maxResult);
		LOG_SICV2.info("firstResult: {}", firstResult);
		LOG_SICV2.info("usuario: {}", usuario);
		Collection<Articulo> articulosCol = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			articulosCol = obtenerArticulosPorUsuario(codigoCompania,
					maxResult, firstResult, usuario);
			LOG_SICV2.info("funcionarios: {}", articulosCol.size());

			if (CollectionUtils.isNotEmpty(articulosCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						articulosCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Collection<Articulo> obtenerArticulosPorUsuario(
			Integer codigoCompania, Integer maxResult, Integer firstResult,
			String usuario) {
		try {
			Collection<ArticuloDTO> articulos = new ArrayList<ArticuloDTO>();
			Collection<Articulo> articulosCol = new ArrayList<ProcesoAutorizacionUsuarios.Articulo>();
			ArticuloVO articuloVO = new ArticuloVO();
			if (codigoCompania != null && maxResult != null
					&& firstResult != null && usuario != null) {
				articuloVO.setBaseDTO(new ArticuloDTO());
				articuloVO.getBaseDTO().getId()
						.setCodigoCompania(codigoCompania);
				articuloVO.setMaxResults(maxResult);
				articuloVO.setFirstResult(firstResult);
				articulos = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.obtenerArticulosUsuario(articuloVO, usuario);
			}
			
			if (CollectionUtils.isNotEmpty(articulos)) {
				for (ArticuloDTO articulo : articulos) {
				String vunidadManejo = "";
				if (CollectionUtils.isNotEmpty(articulo
							.getArticuloUnidadManejoCol())) {
						if (articulo.getArticuloUnidadManejoCol().iterator()
								.next().getValorUnidadManejo() != null) {
							vunidadManejo = articulo
									.getArticuloUnidadManejoCol().iterator()
									.next().getValorUnidadManejo().toString();
						}
					}
					Articulo art = new Articulo();
					art.setCodigoArticulo(articulo.getId().getCodigoArticulo());
					art.setCodigoCompania(articulo.getId().getCodigoCompania());
					art.setDescripcion(articulo.getDescripcionArticulo());
					art.setCodigoBarras(articulo.getCodigoBarras());
					art.setClaseArticulo(articulo.getClaseArticulo());
					art.setReferenciaMedida(articulo.getArticuloMedidaDTO()
							.getReferenciaMedida());
					art.setCodigoClasificacion(articulo
							.getCodigoClasificacion());
					art.setValorUnidadManejo(vunidadManejo);
					articulosCol.add(art);
				}
			}
			return articulosCol;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	/**
	 * Metodo para obtener las clasificaciones que no estan relacionadas al
	 * usuario logueado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/clasificacionesUsuario", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findClasificacionesUsuario(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "maxResult", required = true) Integer maxResult,
			@RequestParam(value = "firstResult", required = true) Integer firstResult,
			@RequestParam(value = "usuarioSesion", required = true) String usuarioSesion,
			@RequestParam(value = "codigoEstructuraComercial", required = false) String codigoEstructuraComercial,
			@RequestParam(value = "codigoSubbodega", required = false) String codigoSubbodega) {

		LOG_SICV2
				.info("Inicio web service findClasificacionesUsuario, codigoCompania: {}",
						codigoCompania);
		LOG_SICV2.info("maxResult: {}", maxResult);
		LOG_SICV2.info("firstResult: {}", firstResult);
		LOG_SICV2.info("usuarioSesion: {}", usuarioSesion);
		LOG_SICV2.info("codigo de Estructura Comercial: {}",
				codigoEstructuraComercial);
		LOG_SICV2.info("codigo de Sub Bodega: {}", codigoSubbodega);

		Collection<Clasificacion> clasificacionCol = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			clasificacionCol = obtenerClasificacionesUsuario(codigoCompania,
					maxResult, firstResult, usuarioSesion,
					codigoEstructuraComercial, codigoSubbodega);
			LOG_SICV2.info("funcionarios: {}", clasificacionCol.size());

			if (CollectionUtils.isNotEmpty(clasificacionCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						clasificacionCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Collection<Clasificacion> obtenerClasificacionesUsuario(
			Integer codigoCompania, Integer maxResult, Integer firstResult,
			String usuarioSesion, String codigoEstructuraComercial,
			String codigoSubbodega) {
		try {
			ClasificacionDTO cla = new ClasificacionDTO();
			cla.getId().setCodigoClasificacion(codigoEstructuraComercial);
			cla.setCodigoBodega(codigoSubbodega);
			ClasificacionVO claVO = new ClasificacionVO();
			Collection<ClasificacionDTO> clasificaciones = new ArrayList<ClasificacionDTO>();
			Collection<Clasificacion> clasificacionesCol = new ArrayList<ProcesoAutorizacionUsuarios.Clasificacion>();
			if (codigoCompania != null && maxResult != null
					&& firstResult != null && usuarioSesion != null) {
				cla.getId().setCodigoCompania(codigoCompania);
				claVO.setBaseDTO(cla);
				claVO.setMaxResults(maxResult);
				claVO.setFirstResult(firstResult);

				// se esta consultado todas las clasificaciones
				clasificaciones = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.obtenerClasificaciones(claVO, usuarioSesion);
			}
			if (CollectionUtils.isNotEmpty(clasificaciones)) {
				for (ClasificacionDTO clasificacion : clasificaciones) {
					Clasificacion clasi = new Clasificacion();
					clasi.setCodigoClasificacion(clasificacion.getId()
							.getCodigoClasificacion());
					clasi.setCodigoCompania(clasificacion.getId()
							.getCodigoCompania());
					clasi.setDescripcion(clasificacion
							.getDescripcionClasificacion());
					clasificacionesCol.add(clasi);
				}
			}
			return clasificacionesCol;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	public class Clasificacion {
		String descripcion;
		String codigoClasificacion;
		Integer codigoCompania;

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getCodigoClasificacion() {
			return codigoClasificacion;
		}

		public void setCodigoClasificacion(String codigoClasificacion) {
			this.codigoClasificacion = codigoClasificacion;
		}

		public Integer getCodigoCompania() {
			return codigoCompania;
		}

		public void setCodigoCompania(Integer codigoCompania) {
			this.codigoCompania = codigoCompania;
		}

	}

	/**
	 * Metodo para obtener las clasificaciones que estan relacionadas al usuario
	 * logueado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/clasificacionesPorUsuario", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findClasificacionesPorUsuario(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "usuarioSesion", required = true) String usuarioSesion) {

		LOG_SICV2
				.info("Inicio web service findClasificacionesPorUsuario, codigoCompania: {}",
						codigoCompania);
		LOG_SICV2.info("usuarioSesion: {}", usuarioSesion);
		Collection<Clasificacion> clasificacionCol = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			clasificacionCol = obtenerClasificacionesPorUsuario(codigoCompania,
					usuarioSesion);
			LOG_SICV2.info("funcionarios: {}", clasificacionCol.size());

			if (CollectionUtils.isNotEmpty(clasificacionCol)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						clasificacionCol);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Collection<Clasificacion> obtenerClasificacionesPorUsuario(
			Integer codigoCompania, String usuarioSesion) {
		try {
			ClasificacionDTO cla = new ClasificacionDTO();
			ClasificacionVO claVO = new ClasificacionVO();
			Collection<ClasificacionDTO> clasificaciones = new ArrayList<ClasificacionDTO>();
			Collection<Clasificacion> clasificacionesCol = new ArrayList<ProcesoAutorizacionUsuarios.Clasificacion>();
			if (codigoCompania != null && usuarioSesion != null) {
				cla.getId().setCodigoCompania(codigoCompania);
				claVO.setBaseDTO(cla);
				// se esta consultado todas las clasificaciones
				clasificaciones = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.obtenerClasificacionesUsuario(claVO, usuarioSesion);
			}
			if (CollectionUtils.isNotEmpty(clasificaciones)) {
				for (ClasificacionDTO clasificacion : clasificaciones) {
					Clasificacion clasi = new Clasificacion();
					clasi.setCodigoClasificacion(clasificacion.getId()
							.getCodigoClasificacion());
					clasi.setCodigoCompania(clasificacion.getId()
							.getCodigoCompania());
					clasi.setDescripcion(clasificacion
							.getDescripcionClasificacion());
					clasificacionesCol.add(clasi);
				}
			}
			return clasificacionesCol;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	/**
	 * Metodo para obtener las clasificaciones que estan relacionadas al usuario
	 * ingresado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/reporteAutorizacionClasificaciones", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findReporteAutorizacionClasificaciones(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoClasificacion", required = false) String codigoClasificacion,
			@RequestParam(value = "disponible", required = true) Boolean disponible,
			@RequestParam(value = "usuario", required = false) String usuario) {

		LOG_SICV2
				.info("Inicio web service findReporteClasificaciones, codigoCompania: {}",
						codigoCompania);
		LOG_SICV2.info("usuarioSesion: {}", usuario);
		LOG_SICV2.info("usuarioSesion: {}", codigoClasificacion);
		LOG_SICV2.info("usuarioSesion: {}", disponible);
		Collection<Clasificacion> autorizacionClasificaciones = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			autorizacionClasificaciones = obtenerReporteAutorizacionClasificaciones(
					codigoCompania, usuario, codigoClasificacion, disponible);
			LOG_SICV2.info("funcionarios: {}",
					autorizacionClasificaciones.size());

			if (CollectionUtils.isNotEmpty(autorizacionClasificaciones)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						autorizacionClasificaciones);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Collection<Clasificacion> obtenerReporteAutorizacionClasificaciones(
			Integer codigoCompania, String usuario, String codigoClasificacion,
			Boolean disponible) {
		try {
			Collection<ClasificacionDTO> clasificaciones = new ArrayList<ClasificacionDTO>();
			Collection<Clasificacion> clasificacionesCol = new ArrayList<ProcesoAutorizacionUsuarios.Clasificacion>();
			if (codigoCompania != null) {
				clasificaciones = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio()
						.repotesClasificaciones(codigoClasificacion,
								codigoCompania, usuario, disponible);
			}
			if (CollectionUtils.isNotEmpty(clasificaciones)) {
				for (ClasificacionDTO clasificacion : clasificaciones) {
					Clasificacion clasi = new Clasificacion();
					clasi.setCodigoClasificacion(clasificacion.getId()
							.getCodigoClasificacion());
					clasi.setCodigoCompania(clasificacion.getId()
							.getCodigoCompania());
					clasi.setDescripcion(clasificacion
							.getDescripcionClasificacion());
					clasificacionesCol.add(clasi);
				}
			}
			return clasificacionesCol;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	/**
	 * Metodo para obtener las clasificaciones que estan relacionadas al usuario
	 * ingresado
	 * 
	 * @param codigoCompania
	 * @param maxResult
	 * @param firstResult
	 * @param usuarioSesion
	 * @return
	 */
	@RequestMapping(value = "/reporteAutorizacionUsuarioClasificaciones", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findReporteAutorizacionUsuarioClasificaciones(@RequestBody String  data) {
		JsonParser parser = new JsonParser();
		JsonObject jsonData =	(JsonObject)parser.parse(data);
		Integer codigoCompania = jsonData.get("codigoCompania").getAsInt();
		Integer maxResult = jsonData.get("maxResult").getAsInt();
		Integer firstResult = jsonData.get("firstResult").getAsInt();
		String usuarioSesion = jsonData.get("usuarioSesion").toString().replace("\"","");
		String user = jsonData.get("descripcion").toString().replace("\"","");
		String codigoClasificacion= jsonData.get("codigoEstructura").toString().replace("\"","");
//, String user
		LOG_SICV2
				.info("Inicio web service findReporteClasificaciones, codigoCompania: {}",
						codigoCompania);
		LOG_SICV2.info("codigoClasificacion: {}", codigoClasificacion);
		LOG_SICV2.info("usuario: {}", user);
		
		Collection<UsuarioClasificacion> autorizacionClasificaciones = null;

		HttpHeaders headers = null;
		String datos = "[]";
		try {
			autorizacionClasificaciones = obtenerReporteAutorizacionUsuarioClasificaciones(
					codigoCompania, codigoClasificacion, user);
			LOG_SICV2.info("funcionarios: {}",
					autorizacionClasificaciones.size());

			if (CollectionUtils.isNotEmpty(autorizacionClasificaciones)) {
				datos = JsonPojoMapper.getInstance().writeValueAsString(
						autorizacionClasificaciones);
			}

			headers = new HttpHeaders();
			headers.add("Content-Type", "text/html; charset=utf-8");
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}

	public Collection<UsuarioClasificacion> obtenerReporteAutorizacionUsuarioClasificaciones(
			Integer codigoCompania, String codigoClasificacion, String user) {
		try {
			Collection<UsuarioClasificacionProcesoDTO> usuClaCol = new ArrayList<UsuarioClasificacionProcesoDTO>();
			Collection<UsuarioClasificacion> clasificacionesCol = new ArrayList<ProcesoAutorizacionUsuarios.UsuarioClasificacion>();
			if (codigoCompania != null) {
				usuClaCol = SICFactory.getInstancia().articulo
						.getUsuarioAutorizacionServicio().reportesUsuarios(
								codigoCompania, codigoClasificacion, user);
			}
			if (CollectionUtils.isNotEmpty(usuClaCol)) {
				for (UsuarioClasificacionProcesoDTO clasificacion : usuClaCol) {
					UsuarioClasificacion clasUsu = new UsuarioClasificacion();
					clasUsu.setCodigoClasificacion(clasificacion.getId()
							.getCodigoClasificacion());
					clasUsu.setCodigoCompania(clasificacion.getId()
							.getCodigoCompania());
					clasUsu.setCodigoUsuario(clasificacion.getId()
							.getCodigoUsuario());
					clasUsu.setCodigoUsuarioClasificacion(clasificacion
							.getCodigoUsuarioClasificacion());
					clasUsu.setCodigoProceso(clasificacion.getCodigoProceso());
					clasUsu.setDescripcionClasificacion(clasificacion
							.getClasificacionDTO()
							.getDescripcionClasificacion());
					clasUsu.setUserId(clasificacion.getUserDTO().getUserId());
					clasUsu.setUserCompleteName(clasificacion.getUserDTO()
							.getUserCompleteName());

					clasificacionesCol.add(clasUsu);
				}
			}
			return clasificacionesCol;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	public class UsuarioClasificacion {
		Long codigoUsuarioClasificacion;
		Long codigoProceso;
		String codigoClasificacion;
		String codigoUsuario;
		String descripcionClasificacion;
		Integer codigoCompania;
		String userId;
		String userCompleteName;

		public Long getCodigoUsuarioClasificacion() {
			return codigoUsuarioClasificacion;
		}

		public void setCodigoUsuarioClasificacion(
				Long codigoUsuarioClasificacion) {
			this.codigoUsuarioClasificacion = codigoUsuarioClasificacion;
		}

		public Long getCodigoProceso() {
			return codigoProceso;
		}

		public void setCodigoProceso(Long codigoProceso) {
			this.codigoProceso = codigoProceso;
		}

		public String getCodigoClasificacion() {
			return codigoClasificacion;
		}

		public void setCodigoClasificacion(String codigoClasificacion) {
			this.codigoClasificacion = codigoClasificacion;
		}

		public String getCodigoUsuario() {
			return codigoUsuario;
		}

		public void setCodigoUsuario(String codigoUsuario) {
			this.codigoUsuario = codigoUsuario;
		}

		public String getDescripcionClasificacion() {
			return descripcionClasificacion;
		}

		public void setDescripcionClasificacion(String descripcionClasificacion) {
			this.descripcionClasificacion = descripcionClasificacion;
		}

		public Integer getCodigoCompania() {
			return codigoCompania;
		}

		public void setCodigoCompania(Integer codigoCompania) {
			this.codigoCompania = codigoCompania;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserCompleteName() {
			return userCompleteName;
		}

		public void setUserCompleteName(String userCompleteName) {
			this.userCompleteName = userCompleteName;
		}

	}
}
