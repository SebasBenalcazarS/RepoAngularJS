package ec.com.smx.sic.webservices.recargaCupon.ws;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Articulo;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.CatalogoValorConvenio;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Convenio;

@Controller
@RequestMapping("/convenio")
@Scope(value = "request")
public interface IConveniosResourceService {
	
	/**
	 * Crea convenio
	 * @param input
	 * @return
	 * @throws SICException
	 * @throws IOException
	 */
	
	@RequestMapping(value = "/create", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> create(@RequestBody Convenio convenioRequestBody) throws SICException, IOException;
	
	@RequestMapping(value = "/create", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createCliente(@RequestBody Map<String, Object> data) throws SICException, IOException;
	
	@RequestMapping(value = "/findConvenios", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Convenio> findConvenios(@RequestBody Convenio convenioRequestBody) throws SICException, IOException;
	
	@RequestMapping(value = "/findCatalogoConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Collection<CatalogoValorConvenio>> findCatalogoConvenio() throws SICException, IOException;
	
	@RequestMapping(value = "/findArticulo", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findArticulo(@RequestBody Articulo convenioRequestBody) throws SICException, IOException;
	
	@RequestMapping(value = "/findCliente", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findCliente(@RequestBody Map<String, Object> convenioRequestBody) throws SICException, IOException;
	
	@RequestMapping(value = "/findArticulosConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findArticulosConvenio(@RequestBody Map<String, Object> convenioRequestBody) throws SICException, IOException;
	
	@RequestMapping(value = "/findClientesConvenio", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Collection<Map<String, String>> findClientesConvenio(@RequestBody Map<String, Object> convenioRequestBody) throws SICException, IOException;
}
