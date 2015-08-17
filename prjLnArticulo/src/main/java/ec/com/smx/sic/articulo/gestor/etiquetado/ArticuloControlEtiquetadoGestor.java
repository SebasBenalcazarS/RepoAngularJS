/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.etiquetado;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.etiquetado.ArticuloInformacionEtiquetado;
import ec.com.smx.sic.cliente.common.articulo.etiquetado.EnumTransgenicoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.etiquetado.IArticuloControlEtiquetadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloControlEtiquetadoDAO;

/**
 * @author eharo
 *
 */
public class ArticuloControlEtiquetadoGestor implements IArticuloControlEtiquetadoGestor {
	
	IArticuloControlEtiquetadoDAO articuloControlEtiquetadoDAO;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.etiquetado.IArticuloControlEtiquetadoGestor#obtenerInformacionTraRegSanSem(java.lang.Integer, java.lang.String)
	 */
	@Override
	public ArticuloInformacionEtiquetado obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException {
		ArticuloDTO articuloDTO = null;
		ArticuloInformacionEtiquetado articuloInformacionEtiquetado = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				articuloDTO = this.articuloControlEtiquetadoDAO.obtenerInformacionTraRegSanSem(codigoCompania, codigoArticulo);
				if(articuloDTO != null){
					articuloInformacionEtiquetado = this.crearEstructuraInformacionTraRegSanSem(articuloDTO);
				}else{
					Logeable.LOG_SICV2.error("El articulo ingresado no existe o es posible que no tenga permiso para consultar");
					throw new SICException("El articulo ingresado no existe o es posible que no tenga permiso para consultar");
				}
			}else{
				if(codigoCompania == null){
					Logeable.LOG_SICV2.error("El codigoCompania no puede ser null, revise por favor");
					throw new SICException("El codigoCompania no puede ser null, revise por favor");
				}
				if(codigoArticulo == null){
					Logeable.LOG_SICV2.error("El codigoArticulo no puede ser null, revise por favor");
					throw new SICException("El codigoArticulo no puede ser null, revise por favor");
				}
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("No ha sido posible consultar la informacion del transgenico, registro sanitario y semaforo del articulo.{}", e.getMessage());
		}
		return articuloInformacionEtiquetado;
	}

	
	
	private ArticuloInformacionEtiquetado crearEstructuraInformacionTraRegSanSem(ArticuloDTO articuloDTO) throws SICException {
		ArticuloInformacionEtiquetado articuloInformacionEtiquetado = null;
		ArticuloEtiquetaDTO articuloEtiquetaDTO = null;
		Boolean aplicaTransgenico = Boolean.FALSE;
		String aplicaRegistroSanitario = StringUtils.EMPTY;
		Boolean poseeSemaforo = Boolean.FALSE;
		String etiquetaTieneTransgenico = SICConstantes.DESICION_NO;
		EnumTransgenicoArticulo enumTransgenicoArticulo = null;
		String etiquetaValorTransgenico = null;
		String codigoTransgenico = StringUtils.EMPTY;
		try{
			if(articuloDTO != null){
				
				aplicaTransgenico = articuloDTO.getAplicaTransgenico();
				if(aplicaTransgenico == null){
					throw new SICException("El campo aplicatransgenico no puede ser nulo");
				}
				if(aplicaTransgenico){
					codigoTransgenico = articuloDTO.getValorEstadoTransgenico();
					enumTransgenicoArticulo = EnumTransgenicoArticulo.getEnumByCode(codigoTransgenico);
					etiquetaTieneTransgenico = SICConstantes.DESICION_SI;
				}else{
					enumTransgenicoArticulo = EnumTransgenicoArticulo.NO;
				}
				etiquetaValorTransgenico = enumTransgenicoArticulo.getEtiquetaValorTransgenico();

				aplicaRegistroSanitario = articuloDTO.getValorAplicaRegistroSanitario();
			
				articuloEtiquetaDTO = obtenerArticuloPoseeEtiquetaSemaforo(articuloDTO.getId().getCodigoCompania(), articuloDTO.getId().getCodigoArticulo());
				if(articuloEtiquetaDTO != null && StringUtils.equals(articuloEtiquetaDTO.getEstado(), SICConstantes.ESTADO_ACTIVO_NUMERICO)){
					poseeSemaforo = Boolean.TRUE;
				}
				
				articuloInformacionEtiquetado = new ArticuloInformacionEtiquetado(enumTransgenicoArticulo, etiquetaValorTransgenico, aplicaRegistroSanitario, poseeSemaforo, etiquetaTieneTransgenico);
			}
		}catch(Exception e){
			throw new SICException("No ha sido posible armar la estructura con la informacion del transgenico, registro sanitario y semaforo del articulo",e.getMessage());
		}
		return articuloInformacionEtiquetado;
	}
	
	private ArticuloEtiquetaDTO obtenerArticuloPoseeEtiquetaSemaforo(Integer codigoCompania, String codigoArticulo){
		ArticuloEtiquetaDTO articuloEtiquetaDTO = null;
		try{
			
			articuloEtiquetaDTO = this.articuloControlEtiquetadoDAO.obtenerArticuloPoseeEtiquetaSemaforo(codigoCompania, codigoArticulo);
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("No se ha podido obtener si el articulo posee semaforo {}", e.getMessage());
		}
		return articuloEtiquetaDTO;
	}
	
	@Override
	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo) throws SICException {
		return this.articuloControlEtiquetadoDAO.obtenerArticuloEtiquetaPorTipo(codigoCompania, codigoEtiqueta, codigoTipoArticulo);
	}



	@Override
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre) throws SICException {
		return this.articuloControlEtiquetadoDAO.obtenerArticuloRecipientes(codigoCompania, codigoArticuloTipoPadre);
	}



	@Override
	public Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta) throws SICException {
		return this.articuloControlEtiquetadoDAO.obtenerSecuencialArticuloEtiqueta(codigoCompania, codigoArticulo, codigoEtiqueta);
	}



	@Override
	public void actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO) throws SICException {
		this.articuloControlEtiquetadoDAO.actualizarArticuloEtiquetaDTO(articuloEtiquetaDTO);
	}
	
	/**
	 * @param articuloControlEtiquetadoDAO the articuloControlEtiquetadoDAO to set
	 */
	public void setArticuloControlEtiquetadoDAO(IArticuloControlEtiquetadoDAO articuloControlEtiquetadoDAO) {
		this.articuloControlEtiquetadoDAO = articuloControlEtiquetadoDAO;
	}
}
