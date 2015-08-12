package ec.com.smx.sic.webservices.recargaCupon.ws;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.webservices.commons.utils.HeaderType;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Promotions;

/**
 * @author ediaz
 *
 */

@Controller
@RequestMapping("/content")
@Scope(value = "request")
public interface IContentResourceService {
	
	/**
	 * Obtienen todas las promociones.
	 * @return
	 */
	@RequestMapping(value = "/findAll", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	@ResponseBody
	Promotions findAll();

	/**
	 * Crear una promocion
	 * @param input
	 * @return
	 * @throws SICException
	 * @throws IOException
	 */
	@RequestMapping(value = "/create", consumes = HeaderType.MULTIPART_FORM_DATA, method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<Answer> create(MultipartHttpServletRequest input)
			throws SICException, IOException;
	
	/**
	 * Elimina promociones por promotionIds
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/delete", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<Answer> delete(@RequestBody Map<String, Object> data);
	
	/**
	 * Obtienen todas las promociones por grupos.
	 * @return
	 */
	@RequestMapping(value = "/findAllByGroup", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public @ResponseBody Collection<Promotions> findAllByGroup();

}
