package ec.com.smx.sic.webservices.recargaCupon.ws.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

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
import ec.com.smx.sic.webservices.commons.utils.HeaderType;
import ec.com.smx.sic.webservices.commons.utils.RecargaCuponUtils;
import ec.com.smx.sic.webservices.recargaCupon.controller.BinCardController;
import ec.com.smx.sic.webservices.recargaCupon.enums.JsonParameter;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.BinTarjeta;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.BinesTarjetas;

/**
 * @author ediaz
 *
 */
@Controller
@RequestMapping("/binCard")
public class BinCardResourceService {
	private Gson gson;

	@PostConstruct
	private void inicializar() {
		gson = new Gson();
	}

	
	@RequestMapping(value = "/findAll", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public @ResponseBody BinesTarjetas findAll(@RequestBody Map<String, Object> data) {
		Long idWS = System.currentTimeMillis();
		String nameWS = "binCard/findAll";
		RecargaCuponUtils.printBanner(idWS, nameWS, data.toString(), Boolean.FALSE, null);
		BinesTarjetas binesTarjetas = new BinesTarjetas();
		if (data != null) {
			binesTarjetas = BinCardController.findAll(data);
		}
		String jsonResponse = gson.toJson(binesTarjetas);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		return binesTarjetas;
	}

	
	@RequestMapping(value = "/delete", consumes = HeaderType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<Answer> delete(@RequestBody Map<String, Object> data) {		
		Answer answer = new Answer();
		answer.setContentId(-1L);
		
		Long idWS = System.currentTimeMillis();
		String nameWS = "binCard/delete";
		RecargaCuponUtils.printBanner(idWS, nameWS, data.toString(), Boolean.FALSE, null);
		
		if (data != null) {
			Collection<Long> binCardIds = new ArrayList<Long>();
			@SuppressWarnings("unchecked")
			ArrayList<Object> res = (ArrayList<Object>) data.get(JsonParameter.BIN_CARD_IDS);
			for (Object obj : res) {
				binCardIds.add(Long.valueOf(obj.toString()));
			}
			
			Boolean showBinCards = Boolean.valueOf(data.get(JsonParameter.SHOW_BIN_CARDS).toString());
			
			Logeable.LOG_SICV2.info("mostrarBinTarjetas  binCardIds: {}", binCardIds);
		
			answer =BinCardController.delete(binCardIds, showBinCards);
			String jsonResponse = gson.toJson(answer);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		}
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", consumes = HeaderType.MULTIPART_FORM_DATA, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Answer> create(MultipartHttpServletRequest input) throws IOException {
		Answer answer = new Answer();
		answer.setContentId(-1L);

		String data = RecargaCuponUtils.findJson(input);
		Long idWS = System.currentTimeMillis();
		String nameWS = "binCard/create";
		RecargaCuponUtils.printBanner(idWS, nameWS, data, Boolean.FALSE, null);
		
		BinTarjeta binTarjeta= new BinTarjeta();
		binTarjeta= gson.fromJson(data, BinTarjeta.class);
		answer.setContentId(BinCardController.create(binTarjeta, input));
		String jsonResponse = gson.toJson(answer);
		RecargaCuponUtils.printFooter(idWS, nameWS, jsonResponse, Boolean.FALSE, null);
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}
}
