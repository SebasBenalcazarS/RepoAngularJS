package ec.com.smx.sic.webservices.recargaCupon.ws;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.com.smx.sic.webservices.commons.utils.HeaderType;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.BinesTarjetas;

/**
 * @author ediaz
 *
 */

@Controller
@RequestMapping("/binCard")
@Scope(value = "request")
public interface IBinCardResourceService {
	
	/**
	 * Obtienen todas las BIN de tarjetas.
	 * @return
	 */
	@RequestMapping(value = "/findAll", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	BinesTarjetas findAll(@RequestBody  Map<String, Object> data);

	/**
	 * Crear una promocion
	 * @param input
	 * @return
	 * @throws SICException
	 * @throws IOException
	
	@RequestMapping(value = "/create", consumes = HeaderType.MULTIPART_FORM_DATA, method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<Answer> create(MultipartHttpServletRequest input)
			throws SICException, IOException; */
	
	/**
	 * Elimina promociones por promotionIds
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/delete", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	ResponseEntity<Answer> delete(@RequestBody Map<String, Object> data);
	
}
