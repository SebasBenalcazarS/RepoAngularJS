package ec.com.smx.sic.webservices.recargaCupon.controller;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoArchivoDto;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.CodigoArchivoID;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ContenidoID;
import ec.com.smx.sic.cliente.mdl.vo.ContenidoVO;
import ec.com.smx.sic.cliente.mdl.vo.FileInformationContentVO;
import ec.com.smx.sic.webservices.commons.utils.LogText;
import ec.com.smx.sic.webservices.commons.utils.RecargaCuponUtils;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Promotion;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Promotions;

/**
 * @author ediaz
 *
 */
public final class ContentController {

	private ContentController() {
	}

	public static Promotions findAll() {
		Collection<Promotion> promotions = new ArrayList<Promotion>();
		try {
			Collection<ContenidoDTO> contentDTOs = SICFactory.getInstancia().recargaCupon.getContenidoService().findContent();
			for (ContenidoDTO contentDTO : contentDTOs) {
				if (contentDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
					Promotion promotion = new Promotion();
					promotion.setOrden(contentDTO.getOrden());
					promotion.setId(contentDTO.getId().getSecuencialContenido());
					promotion.setTipo(contentDTO.getValorTipoContenido().trim());
					promotion.setDetalle(contentDTO.getDetalle().trim());
					promotion.setName(contentDTO.getDescripcion().trim());
					promotion.setCodigoArticulo(contentDTO.getCodigoArticulo());
					promotion.setCodigoCompania(contentDTO.getCodigoCompania());
					promotion.setName(contentDTO.getDescripcion());

					if (contentDTO.getFechaInicioTemporada() != null) {
						promotion.setFrom(contentDTO.getFechaInicioTemporada().getTime());
					}
					
					if (contentDTO.getFechaFinTemporada() != null) {
						promotion.setTo(contentDTO.getFechaFinTemporada().getTime());
					}

					if (CollectionUtils.isNotEmpty(contentDTO.getContenidoDefinicionArchivoDTOs())) {
						for (ContenidoDefinicionArchivoDTO contentDefinitionFileDTO : contentDTO.getContenidoDefinicionArchivoDTOs()) {
							if (contentDefinitionFileDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
								switch (contentDefinitionFileDTO.getValorTipoArchivo()) {
								case "IMC":
									promotion.setNombreImagenCelular(contentDefinitionFileDTO.getNombreArchivo().trim());
									promotion.setPhoneFileId(contentDefinitionFileDTO.getId().getCodigoArchivo());
									break;
								case "IMT":
									promotion.setNombreImagenTablet(contentDefinitionFileDTO.getNombreArchivo().trim());
									promotion.setTabletFileId(contentDefinitionFileDTO.getId().getCodigoArchivo());
									break;
								case "IMD":
									promotion.setNombreImagenDestacada(contentDefinitionFileDTO.getNombreArchivo().trim());
									promotion.setSpecialFileId(contentDefinitionFileDTO.getId().getCodigoArchivo());
									break;
								}
							}
						}
					}
					promotions.add(promotion);
				}
			}
		} catch (SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/findAll: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/findAll: {}", e);
		}
		Promotions promos = new Promotions();
		promos.setPromotions(promotions);
		return promos;
	}

	public static Long create(Promotion promotion,
			MultipartHttpServletRequest input) throws IOException {
		try {
			Collection<ContenidoDefinicionArchivoDTO> definitions = new ArrayList<ContenidoDefinicionArchivoDTO>();
			ContenidoDTO content = new ContenidoDTO();
			content.setValorTipoContenido(promotion.getTipo());
			content.setDetalle(promotion.getDetalle());
			content.setDescripcion(promotion.getName());
			content.setOrden(promotion.getOrden());
			content.setCodigoCompania(promotion.getCodigoCompania());
			content.setCodigoArticulo(promotion.getCodigoArticulo());
			ContenidoID contenidoID= new ContenidoID();
			contenidoID.setSecuencialContenido(promotion.getId());
			content.setId(contenidoID);

			if (promotion.getFrom() == null && promotion.getTo() == null) {
				LOG_SICV2.error(LogText.INVALID_PARAMETER,"content/create fechaInicioTemporada o fechaFinTemporada es null: {}");
				//throw new SICException(LogText.INVALID_PARAMETER,"content/create fechaInicioTemporada o fechaFinTemporada es null: {}");
			} else {
				content.setFechaInicioTemporada(new Date(promotion.getFrom()));
				content.setFechaFinTemporada(new Date(promotion.getTo()));
			}
			
			
			Collection<FileInformationContentVO> fileIMC = RecargaCuponUtils.fileUploadByKey(input, "IMC");
			Collection<FileInformationContentVO> fileIMT = RecargaCuponUtils.fileUploadByKey(input, "IMT");
			Collection<FileInformationContentVO> fileIMD = RecargaCuponUtils.fileUploadByKey(input, "IMD");

			if (CollectionUtils.isNotEmpty(fileIMC)) {
				Collection<ContenidoArchivoDto> files = new ArrayList<ContenidoArchivoDto>();
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				definition.setNombreArchivo(fileIMC.iterator().next().getNombreArchivo());
				definition.setTipoContenidoArchivo(fileIMC.iterator().next().getTipoContenidoArchivo());
				definition.setTamanioArchivo(fileIMC.iterator().next().getTamanioArchivo());
				files.add(fileIMC.iterator().next().getContenidoArchivoDTOs().iterator().next());
				definition.setValorTipoArchivo("IMC");
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getPhoneFileId());
				definition.setId(codigoArchivoID);
				definition.setContenidoArchivoDtos(files);
				definitions.add(definition);
			}
			
			if (CollectionUtils.isNotEmpty(fileIMT)) {
				Collection<ContenidoArchivoDto> archivos = new ArrayList<ContenidoArchivoDto>();
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				definition.setNombreArchivo(fileIMT.iterator().next().getNombreArchivo());
				definition.setTipoContenidoArchivo(fileIMT.iterator().next().getTipoContenidoArchivo());
				definition.setTamanioArchivo(fileIMT.iterator().next().getTamanioArchivo());
				archivos.add(fileIMT.iterator().next().getContenidoArchivoDTOs().iterator().next());
				definition.setValorTipoArchivo("IMT");
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getTabletFileId());
				definition.setId(codigoArchivoID);
				definition.setContenidoArchivoDtos(archivos);
				definitions.add(definition);
			}
			
			if (CollectionUtils.isNotEmpty(fileIMD)) {
				Collection<ContenidoArchivoDto> archivos = new ArrayList<ContenidoArchivoDto>();
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				definition.setNombreArchivo(fileIMD.iterator().next().getNombreArchivo());
				definition.setTipoContenidoArchivo(fileIMD.iterator().next().getTipoContenidoArchivo());
				definition.setTamanioArchivo(fileIMD.iterator().next().getTamanioArchivo());
				archivos.add(fileIMD.iterator().next().getContenidoArchivoDTOs().iterator().next());
				definition.setValorTipoArchivo("IMD");
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getSpecialFileId());
				definition.setId(codigoArchivoID);
				definition.setContenidoArchivoDtos(archivos);
				definitions.add(definition);
			}
			
			if(promotion.getNombreImagenCelular()==null) {
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getPhoneFileId());
				definition.setId(codigoArchivoID);
				definition.setNombreArchivo(null);
				definitions.add(definition);
			}
			
			if(promotion.getNombreImagenTablet()==null) {
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getTabletFileId());
				definition.setId(codigoArchivoID);
				definition.setNombreArchivo(null);
				definitions.add(definition);
			}
			
			if(promotion.getNombreImagenDestacada()==null) {
				ContenidoDefinicionArchivoDTO definition = new ContenidoDefinicionArchivoDTO();
				CodigoArchivoID codigoArchivoID = new CodigoArchivoID();
				codigoArchivoID.setCodigoArchivo(promotion.getSpecialFileId());
				definition.setId(codigoArchivoID);
				definition.setNombreArchivo(null);
				definitions.add(definition);
			}
			
			content.setContenidoDefinicionArchivoDTOs(definitions);
			
			ContenidoVO contentVO = new ContenidoVO();
			contentVO.setContenidoDTO(content);
			return SICFactory.getInstancia().recargaCupon.getContenidoService().transCrearContenido(contentVO);
		} catch (SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/create: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/create: {}", e);
		}
	}
	


	public static Answer delete(Collection<Long> promotionIds, Boolean showPromotions) {
		Answer answer = new Answer();
		answer.setContentId(-1L);
		try {
		SICFactory.getInstancia().recargaCupon.getContenidoService().showPromotions(promotionIds, showPromotions );
		answer.setContentId(1L);
		}catch(SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/delete: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/delete: {}", e);
		}
		return answer;
	}
	
	public static Collection<Promotions> findAllByGroup() {
		Collection<Promotion> c = new ArrayList<Promotion>();
		Collection<Promotion> v = new ArrayList<Promotion>();
		Collection<Promotion> r = new ArrayList<Promotion>();
		Collection<Promotion> p = new ArrayList<Promotion>();
		Collection<Promotion> d = new ArrayList<Promotion>();
		Promotions coupon= new Promotions();
		Promotions video= new Promotions();
		Promotions destacada= new Promotions();
		Promotions receta= new Promotions();
		Promotions promocion= new Promotions();
		
		Collection<Promotions> result= new ArrayList<Promotions>();
		try {
			Collection<ContenidoDTO> contentDTOs = SICFactory.getInstancia().recargaCupon.getContenidoService().findContent();
			for (ContenidoDTO contentDTO : contentDTOs) {
				if (contentDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
					Promotion promotion = new Promotion();
					promotion.setOrden(contentDTO.getOrden());
					promotion.setId(contentDTO.getId().getSecuencialContenido());
					promotion.setTipo(contentDTO.getValorTipoContenido());
					promotion.setDetalle(contentDTO.getDetalle());
					promotion.setName(contentDTO.getDescripcion());

					if (contentDTO.getFechaInicioTemporada() != null) {
						promotion.setFrom(contentDTO.getFechaInicioTemporada().getTime());
					}
					
					if (contentDTO.getFechaFinTemporada() != null) {
						promotion.setTo(contentDTO.getFechaFinTemporada().getTime());
					}

					if (CollectionUtils.isNotEmpty(contentDTO.getContenidoDefinicionArchivoDTOs())) {
						for (ContenidoDefinicionArchivoDTO contentDefinitionFileDTO : contentDTO.getContenidoDefinicionArchivoDTOs()) {
							if (contentDefinitionFileDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
								if (contentDefinitionFileDTO.getValorTipoArchivo().equals("IMC")) {
									promotion.setNombreImagenCelular(contentDefinitionFileDTO.getNombreArchivo());
								} else if (contentDefinitionFileDTO.getValorTipoArchivo().equals("IMT")) {
									promotion.setNombreImagenTablet(contentDefinitionFileDTO.getNombreArchivo());
								}
								
							}
						}
					}
					switch (promotion.getTipo().toUpperCase()) {
					case "C":
						promotion.setColor("rgba(130, 103, 57, 0.7)");
						c.add(promotion);
						break;
					case "V":
						promotion.setColor("rgba(114, 15, 204, 0.5)");
						v.add(promotion);
						break;
					case "R":
						promotion.setColor("rgba(0, 128, 5, 0.56)");
						r.add(promotion);
						break;
					case "P":
						promotion.setColor("rgba(95, 81, 81, 0.592157)");
						p.add(promotion);
						break;
					case "D":
						promotion.setColor("rgba(255, 0, 0, 0.43)");
						d.add(promotion);
						break;
					}
				}
			}
			coupon.setPromotions(c);
			coupon.setTipo(c.iterator().next().getTipo().toUpperCase());
			destacada.setPromotions(d);
			destacada.setTipo(d.iterator().next().getTipo().toUpperCase());
			video.setPromotions(v);
			video.setTipo(v.iterator().next().getTipo().toUpperCase());
			promocion.setPromotions(p);
			promocion.setTipo(p.iterator().next().getTipo().toUpperCase());
			receta.setPromotions(r);
			receta.setTipo(r.iterator().next().getTipo().toUpperCase());
			result.add(coupon);
			result.add(destacada);
			result.add(video);
			result.add(promocion);
			result.add(receta);
			
		} catch (SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/findAll: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/findAll: {}", e);
		}
	
		return result;
	}

	
	public static List<ContenidoDefinicionArchivoDTO> findFiles(Collection<Long> fileIds) {
		 List<ContenidoDefinicionArchivoDTO> answer= new ArrayList<ContenidoDefinicionArchivoDTO>();
		try {
			answer = SICFactory.getInstancia().recargaCupon.getContenidoService().findFiles(fileIds);
		}catch(SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/findFiles: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/findFiles: {}", e);
		}
		return answer;
	}

	
}