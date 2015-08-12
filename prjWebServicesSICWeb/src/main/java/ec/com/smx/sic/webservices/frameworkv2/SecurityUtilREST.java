package ec.com.smx.sic.webservices.frameworkv2;

import java.util.Collection;
import java.util.Map;
import java.util.MissingResourceException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ec.com.smx.corpv2.common.factory.CorporativoFactory;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.corpv2.dto.VistaFuncionarioPerfilOpcionDTO;
import ec.com.smx.framework.common.logging.LogFramework;
import ec.com.smx.framework.common.util.StringPropertryParameterUtil;
import ec.com.smx.framework.exception.FrameworkException;
import ec.com.smx.frameworkv2.common.factory.FrameworkFactory;
import ec.com.smx.frameworkv2.multicompany.dto.ProfileCompanySystemDtoId;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.frameworkv2.security.dto.UserExtendDto;
import ec.com.smx.sic.webservices.commons.mindata.frameworkv2.MinifiedFavoriteObjectData;
import ec.com.smx.sic.webservices.commons.mindata.frameworkv2.MinifiedSystemData;
import ec.com.smx.sic.webservices.commons.utils.SicWSMessages;

/**
 * Controller Web Services
 * 
 * @author aquingaluisa
 * 
 */
//http://localhost:8080/prjWebServicesSICWeb/rest/active/json/usersystem/?userId=aecaiza
//http://localhost:8080/prjWebServicesSICWeb/rest/active/json/usersystem/?userId=aecaiza
//http://localhost:8080/prjWebServicesSICWeb/rest/active/json/useroptions/?userId=aecaiza&sysId=MAX
//http://localhost:8080/prjWebServicesSICWeb/rest/active/json/systemopenuser/?userId=aecaiza&sysId=MAX
//http://localhost:8080/prjWebServicesSICWeb/rest/active/json/systemopenuser/?userId=aecaiza&sysId=MAX&status=1
@Controller
@RequestMapping("/rest/active")
public class SecurityUtilREST {
	@RequestMapping(value = "/dos", method = RequestMethod.GET,headers = "Accept= application/json")
	public @ResponseBody  String getMovie() {
		return "hola mundo";

	}
	/**
	 * Permite ecntontrar los sistemas asociados a la cuenta del usuario del mbase que esta relacionada a una cuenta de windows
	 * @param activeDirectoryUserId
	 * @return
	 */
	@RequestMapping(value = "/json/usersystem/",method = RequestMethod.GET,headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findSystemUser(@RequestParam("userId") String activeDirectoryUserId) {

		Collection<UserCompanySystemDto> userCompanySystemCol = FrameworkFactory.getInstancia().getSecurityService().findSystemByUser(activeDirectoryUserId);
		
		MinifiedSystemData minifiedSystemData  = new MinifiedSystemData();
		if(CollectionUtils.isNotEmpty(userCompanySystemCol)){
			for(UserCompanySystemDto userCompanySystem: userCompanySystemCol){
				StringBuilder stringSystem =new StringBuilder();
				
				/*stringSystem.append("Id Sistema :"+ userCompanySystem.getCompanySystemDto().getSystemDto().getSystemId());
				stringSystem.append("Nombre Sistema :"+ userCompanySystem.getCompanySystemDto().getSystemDto().getSystemName());
				stringSystem.append("Alias Sistema :"+ userCompanySystem.getCompanySystemDto().getSystemDto().getAlias());
				stringSystem.append("Url Sistema :"+userCompanySystem.getCompanySystemDto().getSystemDto().getSystemTarget());
				stringSystem.append("Contexto Sistema :"+userCompanySystem.getCompanySystemDto().getSystemDto().getContextpath());
				stringSystem.append("DefaultInitPage Sistema :"+userCompanySystem.getCompanySystemDto().getSystemDto().getDefaultInitPage());
				//Metodo para anadir el nombre del sistema, la url, defaultinitpage  en el objeto gson
				minifiedSystemData.addMinSystemData(userCompanySystem.getCompanySystemDto().getSystemDto().getSystemId(),
						userCompanySystem.getCompanySystemDto().getSystemDto().getSystemName(),
						userCompanySystem.getCompanySystemDto().getSystemDto().getAlias(), 
						userCompanySystem.getCompanySystemDto().getSystemDto().getSystemTarget(), 
						userCompanySystem.getCompanySystemDto().getSystemDto().getContextpath(),
						userCompanySystem.getCompanySystemDto().getSystemDto().getDefaultInitPage());
						*/
				
				String contextpathSystem  = userCompanySystem.getCompanySystemDto().getSystemDto().getContextpath();
				String sysDefaultInitPage = userCompanySystem.getCompanySystemDto().getSystemDto().getDefaultInitPage() == null ? "gdt.jsf":userCompanySystem.getCompanySystemDto().getSystemDto().getDefaultInitPage();
				Map<String, String> mapSystem = null;
				
				if(StringUtils.equals(SicWSMessages.getString("ec.com.smx.sic.webservices.url.alternative.active"), "1")){
					
					try {
						mapSystem = StringPropertryParameterUtil.getInstance().getConfiguredSystemPropertries(SicWSMessages.getString("ec.com.smx.sic.webservices.url.alternative.system.id"));
						
						contextpathSystem = mapSystem.get(userCompanySystem.getCompanySystemDto().getId().getSystemId());
					} catch (MissingResourceException e) {
						LogFramework.getLogger().error(e.getLocalizedMessage());
					} catch (Exception e) {
						LogFramework.getLogger().error(e.getLocalizedMessage());
					}
					
					
				}
				stringSystem.append("\n*****************MAX GDT**************\n");
				stringSystem.append("Nombre Sistema :"+ userCompanySystem.getCompanySystemDto().getSystemDto().getSystemName());
				stringSystem.append("\nAlias Sistema :"+ userCompanySystem.getCompanySystemDto().getSystemDto().getAlias());
				stringSystem.append("\nUrl Sistema :"+userCompanySystem.getCompanySystemDto().getSystemDto().getSystemTarget());
				stringSystem.append("\nContexto Sistema :"+contextpathSystem);
				stringSystem.append("\nDefaultInitPage Sistema :"+sysDefaultInitPage);
				
				if(StringUtils.isNotEmpty(contextpathSystem)){
					minifiedSystemData.addMinSystemData(userCompanySystem.getCompanySystemDto().getSystemDto().getSystemId(),
							userCompanySystem.getCompanySystemDto().getSystemDto().getSystemName(),
							userCompanySystem.getCompanySystemDto().getSystemDto().getAlias(), 
							userCompanySystem.getCompanySystemDto().getSystemDto().getSystemTarget(), 
							contextpathSystem ,
							sysDefaultInitPage);
				}else{
					LogFramework.getLogger().warn("El sistema con ID ....{}.... no tiene una ruta de contexto valido y no se agregara a la lista", userCompanySystem.getCompanySystemDto().getId().getSystemId());
				}
				
				LogFramework.getLogger().info(stringSystem.toString());
			}
		}
		//Gson, escapar caracteres HTML
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//Si la respuesta para las solicitudes HTTP si se ejecutaron con exito. status 200
		
		return new ResponseEntity<String>(gson.toJson(minifiedSystemData),responseHeaders,HttpStatus.OK);
	}
	
	/*
	@RequestMapping(value="/json/usersincronize",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody ResponseEntity<String> findUserSincronize(@RequestParam("userName") String userName){
		try {
			Collection<UserDto> userCol = null;
			userCol = FrameworkFactory.getInstancia().getSecurityService().findUsersByUserName(userName, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
			UserDto userDto=null;			
			if(CollectionUtils.isNotEmpty(userCol) && CollectionUtils.size(userCol)<2){
				userDto = userCol.iterator().next();				
				UserExtendDto userExtendDto = new UserExtendDto();
				userExtendDto.setUserId(userDto.getUserId());
				userExtendDto = FrameworkFactory.getInstancia().getDataService().findUnique(userExtendDto);
				if(!(userExtendDto == null)){
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
		
	}
	
	*/
	/**
	 * Permite encontrar las opciones de acceso directo asociadas al sistema seleccionado por el usuario (Win-Mbase)
	 * @param systemId
	 * @param activeDirectoryUserId
	 * @return
	 */
	@RequestMapping(value = "/json/useroptions/",method = RequestMethod.GET,headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findUserOptions(@RequestParam("sysId") String systemId, @RequestParam("userId") String activeDirectoryUserId) {
		if(systemId != null && activeDirectoryUserId != null){
		UserExtendDto userExtendDto=new UserExtendDto();
		userExtendDto.getId().setActDirUserId(activeDirectoryUserId);
		userExtendDto.setUserParentDto(new UserDto());
		
		userExtendDto = FrameworkFactory.getInstancia().getDataService().findUnique(userExtendDto);		
		FuncionarioPerfilDTO funcionarioPerfilDTO = new FuncionarioPerfilDTO();
		
		funcionarioPerfilDTO.setFuncionarioDTO(new FuncionarioDTO());
		funcionarioPerfilDTO.getFuncionarioDTO().setUsuarioFuncionario(userExtendDto.getId().getUserId());
		funcionarioPerfilDTO.setEsPerfilPorDefecto(Boolean.TRUE);
		
		Collection<FuncionarioPerfilDTO> lst = CorporativoFactory.getInstancia().getDataService().findObjects(funcionarioPerfilDTO);
		String profileId = null;
		for(FuncionarioPerfilDTO funcionarioPerfilDTOTMP: lst){
			if(funcionarioPerfilDTOTMP.getEsPerfilPorDefecto()){
				profileId = funcionarioPerfilDTOTMP.getId().getCodigoPerfil();
				break;
			}
			
		}
		ProfileCompanySystemDtoId profileCompanySystemDtoId = new ProfileCompanySystemDtoId();
		profileCompanySystemDtoId.setSystemId(systemId);
		profileCompanySystemDtoId.setProfileId(profileId);
		profileCompanySystemDtoId.setCompanyId(1);
		
		Collection<VistaFuncionarioPerfilOpcionDTO>  lstVistaFuncionarioPerfilOpcionDTOs = null; 
		
		try {
			lstVistaFuncionarioPerfilOpcionDTOs = CorporativoFactory.getInstancia().getPerfilesService().getMenuUserTree(userExtendDto.getUserParentDto(), profileCompanySystemDtoId, Boolean.TRUE);
		} catch (Exception e) {
			LogFramework.getLogger().error("Ocurrio un error al intentar cargar las opciones del sistema.. ", e);
		} 
		
		
		MinifiedFavoriteObjectData minifiedObjectData = new MinifiedFavoriteObjectData();
		int cont = 0;
		for(VistaFuncionarioPerfilOpcionDTO vistaFuncionarioPerfilOpcionDTO:  lstVistaFuncionarioPerfilOpcionDTOs){
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(" Id modulo.."+vistaFuncionarioPerfilOpcionDTO.getCodigoModulo());
			stringBuilder.append(" Nombre modulo"+vistaFuncionarioPerfilOpcionDTO.getNombreOpcion());
			
//			System.out.println(stringBuilder.toString());
			//Metodo para aniadir el nombre, url, id, del modulo, y el nombre, url, y estilo de la opcion,  en el objeto gson
			minifiedObjectData.addMinModuleData(vistaFuncionarioPerfilOpcionDTO.getCodigoModulo(), vistaFuncionarioPerfilOpcionDTO.getNombreOpcion());
			for(VistaFuncionarioPerfilOpcionDTO vistaFuncionarioPerfilOpcionDTOTMP:  vistaFuncionarioPerfilOpcionDTO.getVistaFuncionarioPerfilOpcionCol()){
				StringBuilder stringBuilderOpcion = new StringBuilder();
				stringBuilderOpcion.append(" Estilo..:"+vistaFuncionarioPerfilOpcionDTOTMP.getEstiloPanel());
				stringBuilderOpcion.append(" Id modulo..:"+vistaFuncionarioPerfilOpcionDTOTMP.getCodigoModulo());
				stringBuilderOpcion.append(" Nombre opcion..: "+vistaFuncionarioPerfilOpcionDTOTMP.getNombreOpcion());
				stringBuilderOpcion.append(" Url..: "+vistaFuncionarioPerfilOpcionDTOTMP.getNombreOpcion());
				minifiedObjectData.addMinModuleOptionData(cont, vistaFuncionarioPerfilOpcionDTOTMP.getNombreOpcion(), vistaFuncionarioPerfilOpcionDTOTMP.getUrl(), vistaFuncionarioPerfilOpcionDTOTMP.getEstiloPanel());
			}
			cont++;
		}
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		return new ResponseEntity<String>(gson.toJson(minifiedObjectData),responseHeaders,HttpStatus.OK);
		}
		LogFramework.getLogger().error("Ocurrio un error, usuario o sistema null");
		throw new FrameworkException();
	}
	@RequestMapping(value = "/json/systemopenuser/",method = RequestMethod.GET,headers = "Accept= application/json")
	public @ResponseBody ResponseEntity<String> findSystemOpenUser(@RequestParam("sysId") String systemId, @RequestParam("userId") String activeDirectoryUserId, @RequestParam("status")String status) {
		if(systemId != null && activeDirectoryUserId!= null ){
//			if(StringUtils.equals(opened, FrameworkMessages.getString("framework.status.enabled"))){
			try {
				Boolean userSystemOpen = FrameworkFactory.getInstancia().getSecurityService().transSystemOpenByUser(activeDirectoryUserId, systemId, status);
				SystemOpen systemOpen = new SystemOpen();
				systemOpen.setRespuesta(userSystemOpen.toString());				
				Gson gson = new GsonBuilder().disableHtmlEscaping().create();
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.add("Content-Type", "text/html; charset=utf-8");
				return new ResponseEntity<String>(gson.toJson(systemOpen),responseHeaders,HttpStatus.OK);
			} catch (Exception e) {
				LogFramework.getLogger().error("Ocurrio un error, al consultar el status en la tabla KSSEGTUSESYSACC");
			}
		}
		LogFramework.getLogger().error("Ocurrio un error, usuario o sistema null");
		throw new FrameworkException();
	}
	 class SystemOpen{
		String respuesta;
		/**
		 * @return the respuesta
		 */
		public String getRespuesta() {
			return respuesta;
		}
		/**
		 * @param respuesta the respuesta to set
		 */
		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}
		
	}
	
}
