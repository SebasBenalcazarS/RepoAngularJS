package ec.com.smx.sic.articulo.gestor.articuloagrupador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloagrupador.IArticuloAgrupadorGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorRelacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAgrupadorDAO;

public class ArticuloAgrupadorGestor implements IArticuloAgrupadorGestor, Logeable{
	private DataGestor dataGestor;
	private IArticuloAgrupadorDAO articuloAgrupadorDAO;
	
	/**
	 * 
	 * @param articuloVO
	 * @param esCreacion
	 */
	public void registrarAgrupadorArticulo(ArticuloVO articuloVO, Boolean esCreacion) throws SICException{
		
		ArticuloAgrupadorDTO agrActual = null;
		Map<String, Object> relations = null;
		
		try{
			//este proceso funciona siempre y cuando llegen todos los agrupadores
			if(articuloVO.getBaseDTO().getTieneArticuloAgrupador()){
				
				Logeable.LOG_SICV2.info("==> Registrando articulo agrupador");
				if(!esCreacion){
					this.actualizarEstadosAgrupadorRelacion(articuloVO, SICConstantes.ESTADO_INACTIVO_NUMERICO);
				}
				
				for(ArticuloAgrupadorDTO ag : articuloVO.getBaseDTO().getArticuloAgrupadorCol()){
					ag.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					ag.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					ag.setUserId(articuloVO.getBaseDTO().getUserId());
					agrActual = ag;
					relations = SICUtil.getInstance().clearRelations(ag);
					if(StringUtils.equals(ag.getEstado(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						if(esCreacion){
							dataGestor.create(ag);
						}else{
							dataGestor.createOrUpdate(ag);
						}
					}
					
					dataGestor.detach(ag);
					
					SICUtil.getInstance().restoreRelations(ag, relations);
					relations = null;
				}
				
				for( ArticuloAgrupadorDTO ag : articuloVO.getBaseDTO().getArticuloAgrupadorCol() ){
					if(StringUtils.equals(ag.getEstado(),SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						this.registrarArticuloAgrupadorRelacionDTO(ag);
					}
				}
			}
		}catch (Exception e) {
			throw new SICException("Error al registrar el agrupador del articulo",e);
		}finally{
			SICUtil.getInstance().restoreRelations(agrActual, relations);
			relations = null;
			agrActual = null;
		}
	}
	
	/**
	 * 
	 * @param articuloVO
	 * @param estado
	 */
	private void actualizarEstadosAgrupadorRelacion(ArticuloVO articuloVO, String estado) {
		List<Integer> codigoTipoAgrupadorList = new ArrayList<Integer>();
		List<String> tipoValorAgrupadorList = new ArrayList<String>();
		String estadolimitar = (estado.equals(SICConstantes.ESTADO_INACTIVO_NUMERICO))?  SICConstantes.ESTADO_ACTIVO_NUMERICO: SICConstantes.ESTADO_INACTIVO_NUMERICO; 
		
		for(ArticuloAgrupadorDTO articuloAgrupadorDTO : articuloVO.getBaseDTO().getArticuloAgrupadorCol()) {
			if(!codigoTipoAgrupadorList.contains(articuloAgrupadorDTO.getId().getCodigoTipoAgrupador())) {
				codigoTipoAgrupadorList.add(articuloAgrupadorDTO.getId().getCodigoTipoAgrupador());
			}
			
			if(articuloAgrupadorDTO.getEstado().equals(estadolimitar)) {
				tipoValorAgrupadorList.add(articuloAgrupadorDTO.getId().getCodigoTipoAgrupador() + "." + articuloAgrupadorDTO.getId().getValorTipoAgrupador());						
			}
		}
		
		this.articuloAgrupadorDAO.actualizarEstadoRelacion(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), "id.codigoArticulo",
				estado, "estado", ArticuloAgrupadorDTO.class, articuloVO.getBaseDTO().getUserId(),codigoTipoAgrupadorList, tipoValorAgrupadorList);
		this.articuloAgrupadorDAO.actualizarEstadoRelacion(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), "codigoArticulo",
				estado, "estado", ArticuloAgrupadorRelacionDTO.class,articuloVO.getBaseDTO().getUserId(),codigoTipoAgrupadorList, tipoValorAgrupadorList);
	}
	
	/**
	 * @author gaortiz
	 * @param articuloAgrupadorDTO
	 */
	private void registrarArticuloAgrupadorRelacionDTO(final ArticuloAgrupadorDTO articuloAgrupadorDTO ){
		
		if(articuloAgrupadorDTO.getTieneArticuloAgrupadorRelacion()){
			
			Logeable.LOG_SICV2.info("==> Registrando articulo agrupador relacion");
			for(ArticuloAgrupadorRelacionDTO agr : articuloAgrupadorDTO.getArticuloAgrupadorRelacionDTOs()){
				agr.getId().setCodigoCompania(articuloAgrupadorDTO.getId().getCodigoCompania());
				agr.setCodigoArticulo(articuloAgrupadorDTO.getId().getCodigoArticulo());
				agr.setUserId(articuloAgrupadorDTO.getUserId());
				
				this.registrarArticuloAgrupadorRelacionDTO(agr);
				
			}
			
		}
		
	}
	
	/**
	 * @author gaortiz
	 * @param articuloAgrupadorRelacionDTO
	 */
	private void registrarArticuloAgrupadorRelacionDTO(final ArticuloAgrupadorRelacionDTO articuloAgrupadorRelacionDTO ){
		
		if(articuloAgrupadorRelacionDTO.getCodigoArticulo() == null)
			throw new SICException("El codigo articulo no puede ser nulo");
		
		if(articuloAgrupadorRelacionDTO.getCodigoTipoAgrupador() == null)
			throw new SICException("El CodigoTipoAgrupador no puede ser nulo");
		
		if(articuloAgrupadorRelacionDTO.getCodigoTipoAgrupadorRelacionado() == null)
			throw new SICException("El CodigoTipoAgrupadorRelacionado no puede ser nulo");
		
		if(articuloAgrupadorRelacionDTO.getValorTipoAgrupador() == null)
			throw new SICException("El ValorTipoAgrupador no puede ser nulo");
		
		if(articuloAgrupadorRelacionDTO.getValorTipoAgrupadorRelacionado() == null)
			throw new SICException("El ValorTipoAgrupadorRelacionado no puede ser nulo");
		
		
		ArticuloAgrupadorRelacionDTO agrupadorRelacionTemplate = new ArticuloAgrupadorRelacionDTO();
		agrupadorRelacionTemplate.setCodigoArticulo(articuloAgrupadorRelacionDTO.getCodigoArticulo());
		agrupadorRelacionTemplate.setCodigoTipoAgrupador(articuloAgrupadorRelacionDTO.getCodigoTipoAgrupador());
		agrupadorRelacionTemplate.setCodigoTipoAgrupadorRelacionado(articuloAgrupadorRelacionDTO.getCodigoTipoAgrupadorRelacionado());
		agrupadorRelacionTemplate.setValorTipoAgrupador(articuloAgrupadorRelacionDTO.getValorTipoAgrupador());
		agrupadorRelacionTemplate.setValorTipoAgrupadorRelacionado(articuloAgrupadorRelacionDTO.getValorTipoAgrupadorRelacionado());
		
		agrupadorRelacionTemplate = dataGestor.findUnique(agrupadorRelacionTemplate);
		
		if(agrupadorRelacionTemplate != null){
			
			articuloAgrupadorRelacionDTO.getId().setCodigoCompania(agrupadorRelacionTemplate.getId().getCodigoCompania());
			articuloAgrupadorRelacionDTO.getId().setSecuencial(agrupadorRelacionTemplate.getId().getSecuencial());
			articuloAgrupadorRelacionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			this.dataGestor.update(articuloAgrupadorRelacionDTO);
			
		}else{
			
			this.dataGestor.create(articuloAgrupadorRelacionDTO);
			
		}
		
	}
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO){ 
		return this.articuloAgrupadorDAO.obtenerAgrupadoresHijos(catalogoValorDTO);
	}
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo){
		return this.articuloAgrupadorDAO.obtenerAgrupadoresPadres(codigoCatalogoTipo);
	}
	
	public Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException {
		return this.articuloAgrupadorDAO.obtenerArticuloAgrupadorPorCodigoTipoAgrupador(codigoCompania, codigoArticulo, codigoTipoAgrupador);
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setArticuloAgrupadorDAO(IArticuloAgrupadorDAO articuloAgrupadorDAO) {
		this.articuloAgrupadorDAO = articuloAgrupadorDAO;
	}
 }
