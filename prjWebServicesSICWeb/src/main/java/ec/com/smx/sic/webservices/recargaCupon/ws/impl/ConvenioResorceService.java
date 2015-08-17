package ec.com.smx.sic.webservices.recargaCupon.ws.impl;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.corpv2.vo.PersonaVO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ConvenioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ConvenioID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConvenioVO;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Articulo;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.ArticuloConvenio;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.CatalogoValorConvenio;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.ClienteConvenio;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Convenio;
import ec.com.smx.sic.webservices.recargaCupon.ws.IConveniosResourceService;

@Controller
@RequestMapping("/convenio")
@Scope(value = "request")
public class ConvenioResorceService implements IConveniosResourceService {

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> create (@RequestBody Convenio convenioRequestBody) {
		Map<String, Object> responseBody = new HashMap<String, Object>();
		
		try {
			Collection<ArticuloConvenio> articuloConvenioCol = convenioRequestBody.getArticuloConvenioDTOCol();
			Collection<ClienteConvenio> clienteConvenioCol = convenioRequestBody.getClienteConvenioDTOCol();
			
			ConvenioDTO convenioDTO = new ConvenioDTO();
			convenioDTO.setId(convenioRequestBody.getId().getSecuencialConvenio()==null ? new ConvenioID() : convenioRequestBody.getId());
			convenioDTO.setNombre(convenioRequestBody.getNombre());
			convenioDTO.setDescripcion(convenioRequestBody.getDescripcion());
			convenioDTO.setFechaInicio(convenioRequestBody.getFechaInicio());
			convenioDTO.setFechaFin(convenioRequestBody.getFechaFin());
			convenioDTO.setEstado(convenioRequestBody.getEstado());
			convenioDTO.setCodigoTipoEstado(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.codigo.estado.convenio"));
			convenioDTO.setValorTipoConvenio(convenioRequestBody.getValorTipoConvenio());
			convenioDTO.setCodigoTipoConvenio(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.codigo.tipo.convenio"));
			
			Collection<ArticuloDTO> articuloDTOCol = null;
			Collection<ClienteDTO> clienteDTOCol = null;
			
			if (CollectionUtils.isNotEmpty(articuloConvenioCol)) {
				articuloDTOCol = new ArrayList<ArticuloDTO>();
				for (ArticuloConvenio articuloConvenio : articuloConvenioCol) {
					ArticuloDTO articuloDTO = new ArticuloDTO();
					articuloDTO.getId().setCodigoCompania(articuloConvenio.getId().getCodigoCompania());
					articuloDTO.getId().setCodigoArticulo(articuloConvenio.getId().getCodigoArticulo());
					articuloDTO.setEstadoArticulo(articuloConvenio.getEstado());
					articuloDTOCol.add(articuloDTO);
				}
			}

			if(CollectionUtils.isNotEmpty(clienteConvenioCol)){
				clienteDTOCol = new ArrayList<ClienteDTO>();
				for (ClienteConvenio clienteConvenio: clienteConvenioCol){
					ClienteDTO clienteDTO = new ClienteDTO();
					clienteDTO.setPersonaDTO(new PersonaDTO());
					clienteDTO.getPersonaDTO().setNumeroDocumento(clienteConvenio.getNumeroDocumento());
					clienteDTO.getPersonaDTO().setNombreCompleto(clienteConvenio.getNombre());
					clienteDTO.setEstadoClientePedido(clienteConvenio.getEstado());
					clienteDTO.setCodigoPersona(clienteConvenio.getCodigoPersona());
					clienteDTOCol.add(clienteDTO);
				}
			}
			responseBody.put("coleccion",clienteConvenioCol);
			ConvenioVO convenioVO = new ConvenioVO();
			convenioVO.setConvenioDTO(convenioDTO);
			convenioVO.setArticuloDTOCol(articuloDTOCol);
			convenioVO.setClienteDTOCol(clienteDTOCol);
			convenioVO.setUserID(convenioRequestBody.getUsuarioRegistro());
			if (convenioRequestBody.getId().getSecuencialConvenio() == null){
				SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().transCrearConvenio(convenioVO);
			}else{
				SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().transEditConvenio(convenioVO);
			}
				
			responseBody.put("id", convenioDTO.getId());
			responseBody.put("nombre", convenioDTO.getNombre());
			responseBody.put("descripcion", convenioDTO.getDescripcion());
			responseBody.put("codigoReferencia", convenioDTO.getCodigoReferencia());
			responseBody.put("codigoTipoEstado", convenioDTO.getCodigoTipoEstado());
			responseBody.put("estado", convenioDTO.getEstado());
			responseBody.put("usuarioRegistro", convenioDTO.getUsuarioRegistro());
			responseBody.put("valorTipoConvenio", convenioDTO.getValorTipoConvenio());
			responseBody.put("codigoTipoConvenio", convenioDTO.getCodigoTipoConvenio());
			responseBody.put("fechaInicio", convenioDTO.getFechaInicio());
			responseBody.put("fechaFin", convenioDTO.getFechaFin());

		} catch (SICException e) {
			Logeable.LOG_SAC.error("error:", e);
			responseBody.put("respuesta", e);
		}
		return responseBody;
	}

	@Override
	@RequestMapping(value = "/createCliente", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> createCliente(@RequestBody Map<String, Object> data) {
		Map<String, Object> responseBody = new HashMap<String, Object>();
		try{
			String tipoDocumento = (String) data.get("tipoDocumento");
			String numeroDocumento = (String) data.get("numeroDocumento");
			String primerNombre = (String) data.get("primerNombre");
			String segundoNombre = (String) data.get("segundoNombre");
			String primerApellido = (String) data.get("primerApellido");
			String segundoApellido = (String) data.get("segundoApellido");
			String genero = (String) data.get("genero");
			String estadoCivil = (String) data.get("estadoCivil");		
			String userID = (String) data.get("usuarioRegistro");
			
			PersonaVO personaVO = SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().transCrearCliente(tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, genero, estadoCivil, userID);

			responseBody.put("codigoPersona", personaVO.getBaseDTO().getId().getCodigoPersona());
			responseBody.put("tipoDocumento", personaVO.getBaseDTO().getTipoDocumento());
			responseBody.put("numeroDocumento", personaVO.getBaseDTO().getNumeroDocumento());
			responseBody.put("primerNombre", personaVO.getBaseDTO().getPrimerNombre());
			responseBody.put("segundoNombre", personaVO.getBaseDTO().getSegundoNombre());
			responseBody.put("primerApellido", personaVO.getBaseDTO().getPrimerApellido());
			responseBody.put("segundoApellido", personaVO.getBaseDTO().getSegundoApellido());
			responseBody.put("nombreCompleto", personaVO.getBaseDTO().getNombreCompleto());
			responseBody.put("generoPersona", personaVO.getBaseDTO().getGeneroPersona());
			responseBody.put("estadoCivil", personaVO.getBaseDTO().getEstadoCivil());
			
		}catch(SICException e){
			Logeable.LOG_SAC.error("error:", e);
			responseBody.put("respuesta", e);
		}
		return responseBody;
	}
	
	@Override
	@RequestMapping(value = "/findConvenios", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Collection<Convenio> findConvenios(@RequestBody Convenio convenioRequestBody) {
		Collection<Convenio> responseBody = new ArrayList<Convenio>();
		try {
			Collection<ConvenioDTO> convenioDTOCol = null;
			ConvenioDTO convenioDTO = new ConvenioDTO();
			convenioDTO.setNombre(convenioRequestBody.getNombre());
			convenioDTO.setCodigoReferencia(convenioRequestBody.getCodigoReferencia());
			convenioDTO.setDescripcion(convenioRequestBody.getDescripcion());
			convenioDTO.setValorTipoConvenio(convenioRequestBody.getValorTipoConvenio());
			convenioDTO.setEstado(convenioRequestBody.getEstado());
			
			ConvenioVO convenioVO = new ConvenioVO();
			convenioVO.setConvenioDTO(convenioDTO);
			convenioDTOCol = SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findConvenios(convenioVO);
			
			for(ConvenioDTO map : convenioDTOCol){
				Convenio convenio = new Convenio();
				convenio.setId(map.getId());
				convenio.setNombre(map.getNombre());
				convenio.setDescripcion(map.getDescripcion());
				convenio.setCodigoReferencia(map.getCodigoReferencia());
				convenio.setCodigoTipoEstado(map.getCodigoTipoEstado());
				convenio.setEstado(map.getEstado());
				convenio.setUsuarioRegistro(map.getUsuarioRegistro());
				convenio.setFechaRegistro(map.getFechaRegistro());
				convenio.setUsuarioModificacion(map.getUsuarioModificacion());
				convenio.setFechaModificacion(map.getFechaModificacion());
				convenio.setValorTipoConvenio(map.getValorTipoConvenio());
				convenio.setCodigoTipoConvenio(map.getCodigoTipoConvenio());
				convenio.setFechaInicio(map.getFechaInicio());
				convenio.setFechaFin(map.getFechaFin());
				responseBody.add(convenio);
			}
			return responseBody;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@Override
	@RequestMapping(value = "/findCatalogoConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Collection<CatalogoValorConvenio>> findCatalogoConvenio(){
		
		Map<String, Collection<CatalogoValorConvenio>> responseBody = new HashMap<String, Collection<CatalogoValorConvenio>>(); 
		try {
			ConvenioVO convenioVO = new ConvenioVO();
			convenioVO = SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findCatalogoConvenio();
			 
			Collection<CatalogoValorConvenio> catalogoConvenioCol = new ArrayList<CatalogoValorConvenio>();
			
			for (CatalogoValorDTO map: convenioVO.getCatalogoValorEstadosDTOCol()){
				CatalogoValorConvenio catalogoConvenioEstado = new CatalogoValorConvenio();
				catalogoConvenioEstado.setCodigoCatalogoValor(map.getId().getCodigoCatalogoValor());
				catalogoConvenioEstado.setNombreCatalogoValor(map.getNombreCatalogoValor());
				catalogoConvenioCol.add(catalogoConvenioEstado);
			}
			responseBody.put("estados", catalogoConvenioCol);
			
			Collection<CatalogoValorConvenio> catalogoConvenioTipoCol = new ArrayList<CatalogoValorConvenio>();
			
			for (CatalogoValorDTO map: convenioVO.getCatalogoValorTipoConvenioDTOCol()){
				CatalogoValorConvenio catalogoConvenioTipo = new CatalogoValorConvenio();
				catalogoConvenioTipo.setCodigoCatalogoValor(map.getId().getCodigoCatalogoValor());
				catalogoConvenioTipo.setNombreCatalogoValor(map.getNombreCatalogoValor());
				catalogoConvenioTipoCol.add(catalogoConvenioTipo);
			}
			responseBody.put("tiposConvenio", catalogoConvenioTipoCol);
			
		} catch (SICException e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
		return responseBody;
	}
	
	@Override
	@RequestMapping(value = "/findArticulo", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findArticulo(@RequestBody Articulo requestBody){
		try{
			Collection<String> codigoBarras = requestBody.getCodigoBarras();
			String valorTipoConvenio = requestBody.getValorTipoConvenio();
			String descripcionArticulo = requestBody.getDescripcionArticulo();
			Date fechaInicioVigencia = requestBody.getFechaInicioVigencia();
			Date fechaFinVigencia = requestBody.getFechaFinVigencia();
			String codigoBarrasArticuloRelacionado = requestBody.getCodigoBarrasArticuloRelacionado();
			String descripcionArticuloRelacionado = requestBody.getDescripcionArticuloRelacionado();
			String tituloCupon = requestBody.getTituloCupon();
			String nombreLocal = requestBody.getNombreLocal();
			String codigoLocal = requestBody.getCodigoLocal();
			return SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findArticulo(codigoBarras, valorTipoConvenio, descripcionArticulo, fechaInicioVigencia, fechaFinVigencia, codigoBarrasArticuloRelacionado, descripcionArticuloRelacionado, tituloCupon, nombreLocal, codigoLocal) ;
		}catch(SICException e){
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@Override
	@RequestMapping(value = "/findCliente", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findCliente(@RequestBody Map<String, Object> requestBody){
		try{
			Collection<String> numeroDocumento = (Collection<String>) requestBody.get("numeroDocumento");
			String tipoDocumento = (String) requestBody.get("tipoDocumento");
			String primerNombre = (String) requestBody.get("primerNombre");
			String primerApellido = (String) requestBody.get("primerApellido");
			Integer min = (Integer) requestBody.get("min");
			Integer max = (Integer) requestBody.get("max");
			return SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findCliente(numeroDocumento, tipoDocumento, primerNombre, primerApellido, min, max);
		}catch(SICException e){
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}

	@Override
	@RequestMapping(value = "/findArticulosConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findArticulosConvenio(@RequestBody Map<String, Object> requestBody){
		try{
			Long secuencialConvenio = Long.valueOf(requestBody.get("secuencialConvenio").toString());
			return SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findArticulosConvenio(secuencialConvenio);
		}catch(SICException e){
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
	
	@Override
	@RequestMapping(value = "/findClientesConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findClientesConvenio(@RequestBody Map<String, Object> requestBody){
		try{
			Long secuencialConvenio = Long.valueOf(requestBody.get("secuencialConvenio").toString());
			return SICFactory.getInstancia().recargaCupon.getConvenioCuponServicie().findClientesConvenio(secuencialConvenio);
		}catch(SICException e){
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);
		}
	}
}
