package ec.com.smx.sic.webservices.commons.utils;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoArchivoDto;
import ec.com.smx.sic.cliente.mdl.vo.FileInformationContentVO;
import ec.com.smx.sic.webservices.recargaCupon.enums.JsonParameter;

/**
 * @author ediaz
 *
 */

public final class RecargaCuponUtils {
	
	public RecargaCuponUtils() {
		
	}
	
	public static void printBanner(Long idWS, String nombreWS, String jsonRequest, Boolean imprimirToken, String loginToken){
		if(imprimirToken){
			Logeable.LOG_SAC.info("idWS: {}, WS: {}, loginToken: {}, json request: {}", idWS, nombreWS, loginToken, jsonRequest);
		}else{
			Logeable.LOG_SAC.info("idWS: {}, WS: {}, json request: {}", idWS, nombreWS, jsonRequest);
		}
	}

	public static void printFooter(Long idWS, String nombreWS, String jsonResponse, Boolean imprimirHeaders, HttpHeaders httpHeaders){
		if(imprimirHeaders){
			Logeable.LOG_SAC.info("idWS: {}, WS: {}, header: {}, json response: {}", idWS, nombreWS, httpHeaders, jsonResponse);
		}else{
			Logeable.LOG_SAC.info("idWS: {}, WS: {}, json response: {}", idWS, nombreWS, jsonResponse);
		}
		
	}
	
	public static String findJson(MultipartHttpServletRequest files) {
		String result = null;
		try {
			String[] data = (String[]) files.getParameterMap().get(
					JsonParameter.JSON_DATA);
			if (data == null || data.length == 0) {
				throw new SICException(LogText.INVALID_PARAMETER);
			}
			String json = data[0].replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			result = URLDecoder.decode(json, "UTF-8");
			result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException | SICException e) {
			LOG_SICV2.error(LogText.ERROR_METHOD, "json", e);
			throw new SICException(LogText.ERROR_WS,e);
		}
		return result;
	}
	
	public static Collection<FileInformationContentVO> fileUpload(MultipartHttpServletRequest input, String key) throws IOException {
		Collection<FileInformationContentVO> archivosAdjuntos = null;
		if (input != null && input.getFileMap() != null && StringUtils.isNotBlank(key) && CollectionUtils.isNotEmpty(input.getFileMap().values())) {
			archivosAdjuntos = new ArrayList<FileInformationContentVO>();
			Collection<MultipartFile> files = input.getMultiFileMap().get(key.trim());
			Collection<ContenidoArchivoDto> contenidoArchivoDTOs = new ArrayList<ContenidoArchivoDto>();
			if(CollectionUtils.isNotEmpty(files)) {
			for (MultipartFile file : files) {
				byte[] bytes = file.getBytes();
				String filename = (file.getOriginalFilename().length() > 31) ? file.getOriginalFilename().substring(0, 31) : file.getOriginalFilename();
				String contentType = file.getContentType();
				FileInformationContentVO fileInfo = new FileInformationContentVO();
				fileInfo.setNombreArchivo(filename);
				fileInfo.setTamanioArchivo(Long.valueOf(bytes.length));
				fileInfo.setTipoContenidoArchivo(contentType);
				ContenidoArchivoDto contenidoArchivoDTO = new ContenidoArchivoDto();
				contenidoArchivoDTO.setContenidoArchivo(bytes);
				contenidoArchivoDTOs.add(contenidoArchivoDTO);

				fileInfo.setContenidoArchivoDTOs(contenidoArchivoDTOs);
				archivosAdjuntos.add(fileInfo);
			}
			}
		}
		return archivosAdjuntos;
	}
	
	public static Date stringToDate(String fecha) {
		Date dateFecha = new Date();
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isNotBlank(fecha)) {
			try {
				dateFecha = inputFormat.parse(fecha);
			} catch (ParseException e) {
				LOG_SICV2.error(LogText.ERROR_METHOD, "stringToDate", e);
			}
		}
		return dateFecha;
	}
}
