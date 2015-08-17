package ec.com.smx.sic.webservices.recargaCupon.controller;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.BinTarjetaArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.BinTarjetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.BinTarjetaDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.BinTarjetaID;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.CodigoArchivoBinID;
import ec.com.smx.sic.cliente.mdl.vo.FileInformationBinCardVO;
import ec.com.smx.sic.webservices.commons.utils.LogText;
import ec.com.smx.sic.webservices.commons.utils.RecargaCuponUtils;
import ec.com.smx.sic.webservices.recargaCupon.enums.JsonParameter;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.Answer;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.BinTarjeta;
import ec.com.smx.sic.webservices.recargaCupon.jsonObjects.BinesTarjetas;

/**
 * @author ediaz
 *
 */
public final class BinCardController {

	private BinCardController() {
	}

	public static BinesTarjetas findAll(Map<String, Object> data) {
		try {
			Long lastDate = null;
			Timestamp lastUpdate= null;
			if(data.get(JsonParameter.LAST_UPDATE)!= null) {
				lastDate=Long.valueOf(data.get(JsonParameter.LAST_UPDATE).toString());
				lastDate=lastDate*1000;
				lastUpdate=new Timestamp(lastDate);
			}
			
			Collection<BinTarjetaDTO> binTarjetaDTOs = SICFactory.getInstancia().recargaCupon.getCuponServicio().findBinCards(lastUpdate);
			BinesTarjetas binesTarjetas = new BinesTarjetas();
			
			if (CollectionUtils.isNotEmpty(binTarjetaDTOs)) {
				
				Collection<BinTarjeta> binTarjetaInsert = new ArrayList<BinTarjeta>();
				Collection<BinTarjeta> binTarjetaUpdate = null;
				Collection<BinTarjeta> binTarjetaDelete = null;

				if (lastDate != null) {
					binTarjetaUpdate = new ArrayList<BinTarjeta>();
					binTarjetaDelete = new ArrayList<BinTarjeta>();
				}
				
				for (BinTarjetaDTO binTarjetaDTO : binTarjetaDTOs) {
					
					BinTarjeta binTarjeta = new BinTarjeta();
					binTarjeta.setCodigo(String.valueOf(binTarjetaDTO.getId().getCodigoBinTarjeta()));
					binTarjeta.setRangoInicial(binTarjetaDTO.getRangoInicial());
					binTarjeta.setRangoFinal(binTarjetaDTO.getRangoFinal());
					binTarjeta.setDescription(binTarjetaDTO.getDescripcion());
					
					if(binTarjetaDTO.getBinTarjetaDefinicionArchivoDTOs()!=null&&CollectionUtils.isNotEmpty(binTarjetaDTO.getBinTarjetaDefinicionArchivoDTOs())) {
					if(binTarjetaDTO.getBinTarjetaDefinicionArchivoDTOs().iterator().next().getEstado().equals("ACT"))
					binTarjeta.setImagen(binTarjetaDTO.getBinTarjetaDefinicionArchivoDTOs().iterator().next().getNombreArchivo());
					binTarjeta.setImagenId(binTarjetaDTO.getBinTarjetaDefinicionArchivoDTOs().iterator().next().getId().getCodigoArchivo());
					}
					if (lastDate == null) {
						binTarjetaInsert.add(binTarjeta);
					} else {
						if (binTarjetaDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
							// Si la fecha de modificaciones null se lo envia como insert
							if (binTarjetaDTO.getFechaRegistro().getTime() > lastDate) {
								binTarjetaInsert.add(binTarjeta);
							}
							// Si la fecha de modificacion es mayor a la fecha de ultima consulta se lo envia como update
							else if (binTarjetaDTO.getFechaModificacion() != null && binTarjetaDTO.getFechaModificacion().getTime() > lastDate) {
								binTarjetaUpdate.add(binTarjeta);
							}
						} else {
							binTarjetaDelete.add(binTarjeta);
						}
					}
				}
				
				if (CollectionUtils.isNotEmpty(binTarjetaInsert)) {
					binesTarjetas.setInsert(binTarjetaInsert);
				}
				
				if (CollectionUtils.isNotEmpty(binTarjetaDelete)) {
					binesTarjetas.setDelete(binTarjetaDelete);
				}
				
				if (CollectionUtils.isNotEmpty(binTarjetaUpdate)) {
					binesTarjetas.setUpdate(binTarjetaUpdate);
				}
				
				// GC
				binTarjetaInsert = null;
				binTarjetaDelete = null;
				binTarjetaUpdate = null;
				return binesTarjetas;
			}
		} catch (SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "binCard/findAll: {}", e);
			throw new SICException(LogText.ERROR_WS, "binCard/findAll: {}", e);
		}
		
		return null;
	}

	public static Answer delete(Collection<Long> binCardIds, Boolean showBinCards) {
		Answer answer = new Answer();
		answer.setContentId(-1L);
		try {
		SICFactory.getInstancia().recargaCupon.getCuponServicio().showBinCards(binCardIds, showBinCards );
		answer.setContentId(1L);
		}catch(SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "binCards/delete: {}", e);
			throw new SICException(LogText.ERROR_WS, "binCards/delete: {}", e);
		}
		return answer;
	}
	
	public static Long create(BinTarjeta binTarjeta, MultipartHttpServletRequest input) throws IOException {
		try {
			Collection<BinTarjetaDefinicionArchivoDTO> definitions = new ArrayList<BinTarjetaDefinicionArchivoDTO>();
			BinTarjetaDTO binTarjetaDTO = new BinTarjetaDTO();
			binTarjetaDTO.setDescripcion(binTarjeta.getDescription());
			binTarjetaDTO.setRangoInicial(binTarjeta.getRangoInicial());
			binTarjetaDTO.setRangoFinal(binTarjeta.getRangoFinal());
			binTarjetaDTO.setDescripcion(binTarjeta.getDescription());
			BinTarjetaID binTarjetaID= new BinTarjetaID();
			if(binTarjeta.getCodigo()!=null)
			binTarjetaID.setCodigoBinTarjeta(Long.parseLong(binTarjeta.getCodigo()));
			binTarjetaDTO.setId(binTarjetaID);

			Collection<FileInformationBinCardVO> fileIMC = RecargaCuponUtils.fileUpload(input);

			if (CollectionUtils.isNotEmpty(fileIMC)) {
				Collection<BinTarjetaArchivoDTO> files = new ArrayList<BinTarjetaArchivoDTO>();
				BinTarjetaDefinicionArchivoDTO definition = new BinTarjetaDefinicionArchivoDTO();
				definition.setNombreArchivo(fileIMC.iterator().next().getNombreArchivo());
				definition.setTipoContenidoArchivo(fileIMC.iterator().next().getTipoContenidoArchivo());
				definition.setTamanioArchivo(fileIMC.iterator().next().getTamanioArchivo());
				files.add(fileIMC.iterator().next().getBinTarjetaArchivoDTOs().iterator().next());
				CodigoArchivoBinID codigoArchivoBinID = new CodigoArchivoBinID();
				codigoArchivoBinID.setCodigoArchivo(binTarjeta.getImagenId());
				definition.setId(codigoArchivoBinID);
				definition.setBinTarjetaArchivoDTOs(files);
				definitions.add(definition);
			}else if(binTarjeta!=null){
				BinTarjetaDefinicionArchivoDTO definition = new BinTarjetaDefinicionArchivoDTO();
				definition.setNombreArchivo(binTarjeta.getImagen());
				CodigoArchivoBinID codigoArchivoBinID = new CodigoArchivoBinID();
				codigoArchivoBinID.setCodigoArchivo(binTarjeta.getImagenId());
				definition.setId(codigoArchivoBinID);
				definitions.add(definition);
			}
			
			if(binTarjeta.getImagen()==null) {
				BinTarjetaDefinicionArchivoDTO definition = new BinTarjetaDefinicionArchivoDTO();
				CodigoArchivoBinID codigoArchivoBinID = new CodigoArchivoBinID();
				codigoArchivoBinID.setCodigoArchivo(binTarjeta.getImagenId());
				definition.setId(codigoArchivoBinID);
				definition.setNombreArchivo(null);
				definitions.add(definition);
			}
			
			binTarjetaDTO.setBinTarjetaDefinicionArchivoDTOs(definitions);
			
			return SICFactory.getInstancia().recargaCupon.
					getCuponServicio().createBinCard(binTarjetaDTO);
		} catch (SICException e) {
			LOG_SICV2.error(LogText.ERROR_WS, "content/create: {}", e);
			throw new SICException(LogText.ERROR_WS, "content/create: {}", e);
		}
	}
	
}