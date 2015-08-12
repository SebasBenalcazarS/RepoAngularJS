package ec.com.smx.sic.webservices.recargaCupon.ws.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.webservices.commons.utils.HeaderType;
import ec.com.smx.sic.webservices.commons.utils.RecargaCuponUtils;
import ec.com.smx.sic.webservices.recargaCupon.controller.ContentController;
import ec.com.smx.sic.webservices.recargaCupon.enums.JsonParameter;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Promotion;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Promotions;
import ec.com.smx.sic.webservices.recargaCupon.ws.IContentResourceService;

/**
 * @author ediaz
 *
 */
@Controller
@RequestMapping("/content")
public class ContentResourceService implements IContentResourceService {
	private Gson gson;

	@PostConstruct
	private void inicializar() {
		gson = new Gson();
	}

	/**
	 * Obtienen todas las promociones.
	 * 
	 * @param data
	 * @return
	 * @throws CouponException
	 */
	@RequestMapping(value = "/findAll", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public @ResponseBody Promotions findAll() {
		Long idWS = System.currentTimeMillis();
		String nameWS = "content/findAll";
		RecargaCuponUtils.printBanner(idWS, nameWS, null, Boolean.FALSE, null);
		Promotions promotions = ContentController.findAll();
		String jsonResponse = gson.toJson(promotions);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		return promotions;
	}

	
	@RequestMapping(value = "/create", consumes = HeaderType.MULTIPART_FORM_DATA, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Answer> create(MultipartHttpServletRequest input)
			throws SICException, IOException {
		Answer answer = new Answer();
		answer.setContentId(-1L);

		String data = RecargaCuponUtils.findJson(input);
		Long idWS = System.currentTimeMillis();
		String nameWS = "content/create";
		RecargaCuponUtils.printBanner(idWS, nameWS, data, Boolean.FALSE, null);
		
		Promotion promotion= new Promotion();
		promotion= gson.fromJson(data, Promotion.class);

		if (promotion != null && StringUtils.isNotEmpty(promotion.getTipo())) {
			answer.setContentId(ContentController.create(promotion, input));
		}
		String jsonResponse = gson.toJson(answer);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/delete", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<Answer> delete(@RequestBody Map<String, Object> data) {		
		Answer answer = new Answer();
		answer.setContentId(-1L);
		
		Long idWS = System.currentTimeMillis();
		String nameWS = "content/delete";
		RecargaCuponUtils.printBanner(idWS, nameWS, data.toString(), Boolean.FALSE, null);
		
		if (data != null) {
			Collection<Long> promotionIds = new ArrayList<Long>();
			@SuppressWarnings("unchecked")
			ArrayList<Object> res = (ArrayList<Object>) data.get(JsonParameter.PROMOTION_IDS);
			for (Object obj : res) {
				promotionIds.add(Long.valueOf(obj.toString()));
			}
			
			Boolean showPromotions = Boolean.valueOf(data.get(JsonParameter.SHOW_PROMOTIONS).toString());
			
			Logeable.LOG_SICV2.info("mostrarPromociones promotionIds: {}", promotionIds);
		
			answer = ContentController.delete(promotionIds, showPromotions);
			String jsonResponse = gson.toJson(answer);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		}
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/findAllByGroup", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public @ResponseBody Collection<Promotions> findAllByGroup() {
		Long idWS = System.currentTimeMillis();
		String nameWS = "content/findAllByGroup";
		RecargaCuponUtils.printBanner(idWS, nameWS, null, Boolean.FALSE, null);
		Collection<Promotions> promotions = ContentController.findAllByGroup();
		String jsonResponse = gson.toJson(promotions);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		return promotions;
	}
	
}
