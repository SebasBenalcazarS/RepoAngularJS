/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloProveedorNovedadGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadReferenciaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;


/**
 * @author fmunoz
 *
 */
public class CalculoArticuloProveedorNovedadGestor implements ICalculoArticuloProveedorNovedadGestor{
	
	private DataGestor dataGestor;

	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.admin.calculo.ICalculoArticuloNovedadGestor#registrarNovedadArticulo(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO)
	 */
	@Override
	public void registrarNovedadArticuloProveedor(ArticuloVO articuloVO)throws SICException{
		try{
			if(articuloVO.getBaseDTO().getArticuloProveedorCol() != null && !articuloVO.getBaseDTO().getArticuloProveedorCol().isEmpty()){
				for(ArticuloProveedorDTO articuloProveedorDTOIte : articuloVO.getBaseDTO().getArticuloProveedorCol()){
					if(articuloProveedorDTOIte.hasDynamicProperty(ArticuloTransient.ALERTA_IMPORTACION)){
//						Boolean crearAlerta = Boolean.TRUE;
						ArticuloProveedorNovedadDTO artnov = ((ArticuloProveedorNovedadDTO)articuloProveedorDTOIte.getDynamicProperty(ArticuloTransient.ALERTA_IMPORTACION));
						ArticuloProveedorNovedadDTO nov = new ArticuloProveedorNovedadDTO();
						nov.getId().setCodigoCompania(articuloProveedorDTOIte.getId().getCodigoCompania());
						nov.setCodigoArticulo(articuloProveedorDTOIte.getId().getCodigoArticulo());
						nov.setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
						nov.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						nov.setCodigoTipoNovedad(TipoCatalogoArticulo.TIPO_NOVEDAD_IMPORTACION);
						nov.setValorTipoNovedad(artnov.getValorTipoNovedad());
						nov.setUserId(articuloVO.getBaseDTO().getUserId());
						nov.setCodigoEstadoNovedad(TipoCatalogoArticulo.TIPO_ESTADO_NOVEDAD);
						nov.setValorEstadoNovedad(TipoCatalogoArticulo.VALOR_ESTADO_NOVEDAD_PENDIENTE);
						dataGestor.create(nov);
						
						if(CollectionUtils.isNotEmpty(artnov.getReferencias())){
							for(ArticuloProveedorNovedadReferenciaDTO anr : artnov.getReferencias()){
								anr.getId().setCodigoCompania(nov.getId().getCodigoCompania());
								anr.getId().setSecuencialNovedad(nov.getId().getSecuencial());
								anr.getId().setCodigoArticulo(anr.getId().getCodigoArticulo());
								anr.getId().setCodigoProveedor(anr.getId().getCodigoProveedor());
								if(StringUtils.isEmpty(anr.getReferenciaProveedor())){
									anr.setReferenciaProveedor("");
								}
								if(StringUtils.isEmpty(anr.getCodigoBarras())){
									anr.setCodigoBarras("");
								}
								anr.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
								anr.setUserId(nov.getUserId());
								dataGestor.create(anr);
							}
						}
						articuloVO.getBaseDTO().removeDynamicProperty(ArticuloTransient.ALERTA_IMPORTACION);
					}
//					else if(articuloProveedorDTOIte.getTieneNovedades()){
//						//desde la pantalla del MAX
//					}
				}
			}
		}catch (Exception e) {
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.novedad"),e);
		}
	}
	
	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
 
	
}
