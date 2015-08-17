/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.garantia;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.framework.common.util.Util;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.garantia.IArticuloGarantiaGestor;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.GarantiaArticuloDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.garantia.IArticuloGarantiaDAO;

/**
 * @author eharo
 *
 */
public class ArticuloGarantiaGestor implements IArticuloGarantiaGestor, Logeable {
	
	IArticuloGarantiaDAO articuloGarantiaDAO;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.garantia.IArticuloGarantiaGestor#obtenerRangosGE(ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO, java.lang.Double)
	 */
	@Override
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException {
		return this.articuloGarantiaDAO.obtenerRangosGE(rangoExtensionGarantiaDTO, precioBaseImp);
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.garantia.IArticuloGarantiaGestor#buscarPrecioExtension(java.util.Collection)
	 */
	@Override
	public Collection<GarantiaArticuloDTO> buscarPrecioExtension(Collection<ArticuloRangoExtensionGarantiaDTO> rangosGE, Double precioBaseImp) throws SICException {
		Collection<GarantiaArticuloDTO> garantiasCol = null;
		try{
			if(CollectionUtils.isNotEmpty(rangosGE)){
				LOG_SICV2.info("Rangos: {}", rangosGE.size());
				garantiasCol = new ArrayList<GarantiaArticuloDTO>();
				Long i = 0L;
				for(ArticuloRangoExtensionGarantiaDTO rango : rangosGE){
					GarantiaArticuloDTO garantia = new GarantiaArticuloDTO();
					garantia.getId().setSecuencialGarantia(i);
					garantia.setTiempoGarantia(rango.getTiempo());
					//Si esta activo el porcentaje
					if(rango.getPorcentaje()!=0){
						Double costo = (precioBaseImp * rango.getPorcentaje()) / 100;
						if(costo <= rango.getValorMinimo()){
							costo = rango.getValorMinimo();// * SICConstantes.IVA;
							garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));
						}else{
							//costo = costo * SICConstantes.IVA;
							garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));
						}
					}
					//Si esta activo un costo fijo
					else{
						Double costo = rango.getValor();// * SICConstantes.IVA;
						garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));
					}
					garantiasCol.add(garantia);
					i++;
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar buscar el precio de la extensi\u00F3n. {}", e.getMessage());
		}
		return garantiasCol;
	}



	/**
	 * @param articuloGarantiaDAO the articuloGarantiaDAO to set
	 */
	public void setArticuloGarantiaDAO(IArticuloGarantiaDAO articuloGarantiaDAO) {
		this.articuloGarantiaDAO = articuloGarantiaDAO;
	}
}
