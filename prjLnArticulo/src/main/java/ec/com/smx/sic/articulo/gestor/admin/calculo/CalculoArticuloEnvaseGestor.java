/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloEnvaseGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEnvaseDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author fmunoz
 *
 */
public class CalculoArticuloEnvaseGestor implements ICalculoArticuloEnvaseGestor {

	private DataGestor dataGestor;
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.admin.calculo.ICalculoArticuloEnvaseGestor#registrarArticuloEnvase(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO)
	 */
	@Override
	public void registrarArticuloEnvase(ArticuloVO articuloVO)throws SICException{
		try{
			if(articuloVO.getBaseDTO().getTieneEnvases()){
				for(ArticuloEnvaseDTO ae : articuloVO.getBaseDTO().getEnvases()){
					asignarCamposArticuloEnvase(ae);
					ae.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					ae.setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					ae.setUserId(articuloVO.getBaseDTO().getUserId());
					if(ae.getId().getSecuencial() == null){
						dataGestor.create(ae);
					}else{
						dataGestor.update(ae);
					}
					
				}
			}
		}catch(Exception e){
			throw new SICException(e.getMessage(), e);
		}
	}

	private void asignarCamposArticuloEnvase(ArticuloEnvaseDTO articuloEnvaseDTO)throws SICException{
		if(StringUtils.isEmpty(articuloEnvaseDTO.getEstado())){
			articuloEnvaseDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		}
		if(StringUtils.isNotEmpty(articuloEnvaseDTO.getValorTipoEnvase())){
			articuloEnvaseDTO.setCodigoTipoEnvase(TipoCatalogoArticulo.TIPO_CONTEXTO_ENVASE);
		}
	}
	
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}
