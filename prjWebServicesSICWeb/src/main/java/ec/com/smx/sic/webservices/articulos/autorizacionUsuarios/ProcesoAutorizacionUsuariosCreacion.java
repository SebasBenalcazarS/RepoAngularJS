package ec.com.smx.sic.webservices.articulos.autorizacionUsuarios;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.webservices.articulos.autorizacionUsuarios.objetosJson.ArticuloUsuario;
import ec.com.smx.sic.webservices.articulos.autorizacionUsuarios.objetosJson.ClasificacionUsuario;

/**
 * 
 * @author cortiz
 *
 */

@Controller
@RequestMapping("/ws/autorizacionUsuariosCreacion")
@Scope(value = "request")
public class ProcesoAutorizacionUsuariosCreacion {

	@RequestMapping(value = "/creacionClasificacionFuncionario", consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createClasificacionFuncionario(
			@RequestBody ClasificacionUsuario jsonData) {
		
		LOG_SICV2.info("Inicio web service creacionClasificacionFuncionario, codigoCompania: {}");
		LOG_SICV2.info("codigoClasificacion: {}", jsonData.getCodigoClasificacion());
		LOG_SICV2.info("codigoCompania: {}", jsonData.getCodigoCompania());
		LOG_SICV2.info("usuario: {}", jsonData.getUsuario());
		LOG_SICV2.info("usuarioSesion: {}", jsonData.getUsuarioSesion());
		
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		
		try{
			
			crearClasificacionFuncionariosLocal(jsonData);
			LOG_SICV2.info("funcionarios: {}");
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/desactivarClasificacionFuncionario", consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> desactivarClasificacionFuncionario(
			@RequestBody ClasificacionUsuario jsonData) {
		
		LOG_SICV2.info("Inicio web service desactivarClasificacionFuncionario, codigoCompania: {}");
		LOG_SICV2.info("codigoClasificacion: {}", jsonData.getCodigoClasificacion());
		LOG_SICV2.info("codigoCompania: {}", jsonData.getCodigoCompania());
		LOG_SICV2.info("usuario: {}", jsonData.getUsuario());
		LOG_SICV2.info("usuarioSesion: {}", jsonData.getUsuarioSesion());
		
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		
		try{
			
			desactivarClasificacionFuncionariosLocal(jsonData);
			LOG_SICV2.info("funcionarios: {}");
		
			headers = new HttpHeaders();					
			headers.add("Content-Type", "application/json");
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}
	
	private void desactivarClasificacionFuncionariosLocal(ClasificacionUsuario jsonData)throws SICException{
		try {
			
			UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
			usuarioClasificacionProcesoDTO.getId().setCodigoCompania(jsonData.getCodigoCompania());
			usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(jsonData.getCodigoClasificacion());
			usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(jsonData.getUsuario());
			usuarioClasificacionProcesoDTO.setUserId(jsonData.getUsuarioSesion());
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().desactivarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	public void crearClasificacionFuncionariosLocal(ClasificacionUsuario jsonData)throws SICException{
		try {
			UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
			usuarioClasificacionProcesoDTO.getId().setCodigoCompania(jsonData.getCodigoCompania());
			usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(jsonData.getCodigoClasificacion());
			usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(jsonData.getUsuario());
			usuarioClasificacionProcesoDTO.setUserId(jsonData.getUsuarioSesion());
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().guardarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@RequestMapping(value = "/creacionArticuloFuncionario", headers = "Accept= application/json", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createArticuloFuncionario(
			@RequestBody ArticuloUsuario jsonData) {
		
		LOG_SICV2.info("Inicio web service creacionArticuloFuncionario, codigoCompania: {}");
		LOG_SICV2.info("codigoCompania: {}", jsonData.getCodigoCompania());
		LOG_SICV2.info("codigoArticulo: {}", jsonData.getCodigoArticulo());
		LOG_SICV2.info("usuario: {}", jsonData.getUsuario());
		LOG_SICV2.info("usuarioSesion: {}", jsonData.getUsuarioSesion());
		
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		
		try{
			crearArticulosFuncionariosLocal(jsonData);
			LOG_SICV2.info("funcionarios: {}");
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/desactivarArticuloFuncionario", headers = "Accept= application/json", method = RequestMethod.POST) 
	public @ResponseBody ResponseEntity<String> desactivarArticuloFuncionario(@RequestBody ArticuloUsuario jsonData) {
		
		LOG_SICV2.info("Inicio web service desactivarArticuloFuncionario");
		LOG_SICV2.info("codigoArticulo: {}", jsonData.getCodigoArticulo());
		LOG_SICV2.info("codigoCompania: {}", jsonData.getCodigoCompania());
		LOG_SICV2.info("usuario: {}", jsonData.getUsuario());
		LOG_SICV2.info("usuarioSesion: {}", jsonData.getUsuarioSesion());
		
		HttpHeaders headers = null;
		String dataOK = "{\"status\":\"OK\"}";
		String dataFail = "{\"status\":\"FAIL\"}";
		
		try{
			desactivarArticuloFuncionariosLocal(jsonData);
			LOG_SICV2.info("funcionarios: {}");
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			return new ResponseEntity<String>(dataFail, headers, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(dataOK, headers, HttpStatus.OK);
	}
	
	private void desactivarArticuloFuncionariosLocal(ArticuloUsuario jsonData)throws SICException{
		try {
			
			UsuarioArticuloDTO usuarioArticuloDTO = new UsuarioArticuloDTO();
			usuarioArticuloDTO.getId().setCodigoCompania(jsonData.getCodigoCompania());
			usuarioArticuloDTO.getId().setCodigoArticulo(jsonData.getCodigoArticulo());
			usuarioArticuloDTO.getId().setCodigoUsuario(jsonData.getUsuario());
			usuarioArticuloDTO.setUserId(jsonData.getUsuarioSesion());
			
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().desactivarArticulosUsuario(usuarioArticuloDTO);
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	public void crearArticulosFuncionariosLocal(ArticuloUsuario jsonData)throws SICException{
		try {
			UsuarioArticuloDTO usuarioArticuloDTO= new UsuarioArticuloDTO();
			usuarioArticuloDTO.getId().setCodigoCompania(jsonData.getCodigoCompania());
			usuarioArticuloDTO.getId().setCodigoArticulo(jsonData.getCodigoArticulo());
			usuarioArticuloDTO.getId().setCodigoUsuario(jsonData.getUsuario());
			usuarioArticuloDTO.setUserId(jsonData.getUsuarioSesion());
			
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().guardarArticulosUsuario(usuarioArticuloDTO);
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@RequestMapping(value = "/adicionarClasificacionesFuncionario", consumes="application/json", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> adicionarClasificacionesFuncionario(@RequestBody String  data) {
		
		JsonParser parser = new JsonParser();
		JsonObject jsonData =	(JsonObject)parser.parse(data);
		String usuarioSesion = jsonData.get("usuarioSesion").toString().replace("\"","");
		
		Integer codigoCompania;
		String usuario =jsonData.get("usuario").toString().replace("\"","");
		codigoCompania=jsonData.get("codigoCompania").getAsInt();
		
		Collection<ClasificacionUsuario> listaClasificacionesUsuarioOrigen = new ArrayList<ClasificacionUsuario>();
		
		JsonObject jsonObject = (JsonObject) jsonData.get("clasificaciones");
		
		if (jsonObject != null) {			
			JsonArray jsonE= (JsonArray)jsonObject.get("listaClasificacionesUsuarioOrigen");	
			for(int i=0; i<jsonE.size(); i++){
				ClasificacionUsuario clasificacionesUsuO = new ClasificacionUsuario();
				clasificacionesUsuO.setCodigoClasificacion(jsonE.get(i).toString().replace("\"",""));
				clasificacionesUsuO.setCodigoCompania(codigoCompania);
				clasificacionesUsuO.setUsuario(usuario);
				clasificacionesUsuO.setUsuarioSesion(usuarioSesion.toString().replace("\"",""));
				listaClasificacionesUsuarioOrigen.add(clasificacionesUsuO);	
			}
		}
		
		LOG_SICV2.info("Inicio web service /adicionarClasificacionesFuncionario, codigoCompania: {}", listaClasificacionesUsuarioOrigen.size());
		LOG_SICV2.info("usuario a anadir: {}", usuario);
		
		HttpHeaders headers = null;
		String datos = "[]";
		try{
			anadirClasificacionesFuncionario(listaClasificacionesUsuarioOrigen, usuario );
			LOG_SICV2.info("funcionarios: {}");
			
			headers = new HttpHeaders();					
			headers.add("Content-Type", "application/json");
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}
	
	public void anadirClasificacionesFuncionario(Collection<ClasificacionUsuario> claUsuCol, String usuario)throws SICException{
		try {
			//crea o actualiza las relaciones de las clasificaciones con el usuario insertado
			for(ClasificacionUsuario claUsu:claUsuCol){
				UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
				usuarioClasificacionProcesoDTO.getId().setCodigoCompania(claUsu.getCodigoCompania());
				usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(claUsu.getCodigoClasificacion());
				usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(usuario);
				usuarioClasificacionProcesoDTO.setUserId(claUsu.getUsuarioSesion());
				SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().guardarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
			}
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@RequestMapping(value = "/reemplazarClasificacionesFuncionario", consumes="application/json", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> reemplazarClasificacionesFuncionario(@RequestBody String  data) {
		
		JsonParser parser = new JsonParser();
		JsonObject jsonData =	(JsonObject)parser.parse(data);
		String usuarioSesion = jsonData.get("usuarioSesion").toString().replace("\"","");
		
		Integer codigoCompania;
		String usuario =jsonData.get("usuario").toString().replace("\"","");
		codigoCompania=jsonData.get("codigoCompania").getAsInt();
		
		Collection<ClasificacionUsuario> listaClasificacionesUsuarioOrigen = new ArrayList<ClasificacionUsuario>();
		
		JsonObject jsonObject = (JsonObject) jsonData.get("clasificaciones");
		
		if (jsonObject != null) {			
			JsonArray jsonE= (JsonArray)jsonObject.get("listaClasificacionesUsuarioOrigen");	
			for(int i=0; i<jsonE.size(); i++){
				ClasificacionUsuario clasificacionesUsuO = new ClasificacionUsuario();
				clasificacionesUsuO.setCodigoClasificacion(jsonE.get(i).toString().replace("\"",""));
				clasificacionesUsuO.setCodigoCompania(codigoCompania);
				clasificacionesUsuO.setUsuario(usuario);
				clasificacionesUsuO.setUsuarioSesion(usuarioSesion.toString().replace("\"",""));
				listaClasificacionesUsuarioOrigen.add(clasificacionesUsuO);	
			}
		}
		
		LOG_SICV2.info("Inicio web service /reemplazarClasificacionesFuncionario, clasificaciones de usuario: {}", listaClasificacionesUsuarioOrigen.size());
		LOG_SICV2.info("usuario por reemplazar: {}", usuario);
		
		HttpHeaders headers = null;
		String datos = "[]";
		try{
			reemplazarClasificacionesFuncionario(listaClasificacionesUsuarioOrigen, usuario, codigoCompania);
			LOG_SICV2.info("funcionarios: {}");
			
			headers = new HttpHeaders();					
			headers.add("Content-Type", "application/json");
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}
	
	public void reemplazarClasificacionesFuncionario(Collection<ClasificacionUsuario> claUsuCol, String usuario, Integer codigoCompania)throws SICException{
		try {
			Collection<UsuarioClasificacionProcesoDTO> usuarioClasificacionProcesos= new ArrayList<UsuarioClasificacionProcesoDTO>();
			for(ClasificacionUsuario claUsu:claUsuCol){
				UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
				usuarioClasificacionProcesoDTO.getId().setCodigoCompania(claUsu.getCodigoCompania());
				usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(claUsu.getCodigoClasificacion());
				usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(usuario);
				usuarioClasificacionProcesoDTO.setUserId(claUsu.getUsuarioSesion());
				usuarioClasificacionProcesos.add(usuarioClasificacionProcesoDTO);
			}
			//inactiva las clasificaciones relacionadas al usuario ingresado e inserta o activa las relaciones de las clasificaciones insertadas
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().reemplazarClasificacionesFuncionario( usuarioClasificacionProcesos, usuario,codigoCompania );
			
		} catch (SICException e) {
			 LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@RequestMapping(value = "/intercambiarClasificacionesFuncionario", consumes="application/json", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> intercambiarClasificacionesFuncionario(@RequestBody String  data) {
		
		JsonParser parser = new JsonParser();
		JsonObject jsonData =	(JsonObject)parser.parse(data);
		Integer maxResult = jsonData.get("maxResult").getAsInt();
		Integer firstResult = jsonData.get("firstResult").getAsInt();
		String usuarioSesion = jsonData.get("usuarioSesion").toString().replace("\"","");
		
		Integer codigoCompania;
		String usu1,usu2;
		usu1= jsonData.get("usuarioOrigen").toString().replace("\"","");
		usu2= jsonData.get("usuarioDestino").toString().replace("\"","");
		codigoCompania=jsonData.get("codigoCompaniaUsuOrigen").getAsInt();
		
		Collection<ClasificacionUsuario> listaClasificacionesUsuarioOrigen = new ArrayList<ClasificacionUsuario>();
		Collection<ClasificacionUsuario> listaClasificacionesUsuarioDestino= new ArrayList<ClasificacionUsuario>();
		
		JsonObject jsonObject = (JsonObject) jsonData.get("clasificaciones");
		
		if (jsonObject != null) {			
			JsonArray jsonE= (JsonArray)jsonObject.get("listaClasificacionesUsuarioOrigen");	
			for(int i=0; i<jsonE.size(); i++){
				ClasificacionUsuario clasificacionesUsuO = new ClasificacionUsuario();
				clasificacionesUsuO.setCodigoClasificacion(jsonE.get(i).toString().replace("\"",""));
				clasificacionesUsuO.setCodigoCompania(codigoCompania);
				clasificacionesUsuO.setUsuario(usu1);
				clasificacionesUsuO.setUsuarioSesion(usuarioSesion.toString().replace("\"",""));
				listaClasificacionesUsuarioOrigen.add(clasificacionesUsuO);	
			}
			
			JsonArray jsonE2= (JsonArray)jsonObject.get("listaClasificacionesUsuarioDestino");	
			for(int i=0; i<jsonE2.size(); i++){
				ClasificacionUsuario clasificacionesUsuD = new ClasificacionUsuario();
				clasificacionesUsuD.setCodigoClasificacion(jsonE2.get(i).toString().replace("\"",""));
				clasificacionesUsuD.setCodigoCompania(codigoCompania);
				clasificacionesUsuD.setUsuario(usu2);
				clasificacionesUsuD.setUsuarioSesion(usuarioSesion.toString().replace("\"",""));
				listaClasificacionesUsuarioDestino.add(clasificacionesUsuD);
				
			}
			
		}
		
		
		
		LOG_SICV2.info("Inicio web service intercambiarClasificacionesFuncionario, clasificaciones de usuario1: {}", listaClasificacionesUsuarioOrigen.size());
		LOG_SICV2.info("clasificaciones de usuario2: {}", listaClasificacionesUsuarioDestino.size());
		
		HttpHeaders headers = null;
		String datos = "[]";
		try{
			intercambiarClasificacionesFuncionarios(listaClasificacionesUsuarioOrigen,listaClasificacionesUsuarioDestino);
			LOG_SICV2.info("funcionarios: {}");
			
			headers = new HttpHeaders();					
			headers.add("Content-Type", "application/json");
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return new ResponseEntity<String>(datos, headers, HttpStatus.OK);
	}
	
	public void intercambiarClasificacionesFuncionarios(Collection<ClasificacionUsuario> clasificacionesUsuario1, Collection<ClasificacionUsuario> clasificacionesUsuario2)throws SICException{
		try {
			String usuario1 = clasificacionesUsuario1.iterator().next().getUsuario();
			String usuario2 = clasificacionesUsuario2.iterator().next().getUsuario();
			Integer codigoCompania = clasificacionesUsuario1.iterator().next().getCodigoCompania();
			Collection<UsuarioClasificacionProcesoDTO> usuarioClasificacionProcesos= new ArrayList<UsuarioClasificacionProcesoDTO>();
			
			for(ClasificacionUsuario claUsu:clasificacionesUsuario1){
				UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
				usuarioClasificacionProcesoDTO.getId().setCodigoCompania(claUsu.getCodigoCompania());
				usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(claUsu.getCodigoClasificacion());
				usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(usuario2);
				usuarioClasificacionProcesoDTO.setUserId(claUsu.getUsuarioSesion());
				usuarioClasificacionProcesos.add(usuarioClasificacionProcesoDTO);
			}
			
			for(ClasificacionUsuario claUsu:clasificacionesUsuario2){
				UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO= new UsuarioClasificacionProcesoDTO();
				usuarioClasificacionProcesoDTO.getId().setCodigoCompania(claUsu.getCodigoCompania());
				usuarioClasificacionProcesoDTO.getId().setCodigoClasificacion(claUsu.getCodigoClasificacion());
				usuarioClasificacionProcesoDTO.getId().setCodigoUsuario(usuario1);
				usuarioClasificacionProcesoDTO.setUserId(claUsu.getUsuarioSesion());
				usuarioClasificacionProcesos.add(usuarioClasificacionProcesoDTO);
			}
			
			SICFactory.getInstancia().articulo.getUsuarioAutorizacionServicio().intercambiarClasificacionesFuncionario(codigoCompania, usuario1, usuario2, usuarioClasificacionProcesos);
 
			
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
}
