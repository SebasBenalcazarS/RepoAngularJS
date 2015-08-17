package ec.com.smx.sic.cliente.common.articulo;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.framework.common.util.dto.Duplex;

/**
 * 
 * @author mgranda
 *
 */
@SuppressWarnings("serial")
public class ConversionUnidadUtil implements Serializable{

	
	/**
	 * @author mgranda
	 * @param cantidadMedida
	 * @param codigoTipoMedida
	 * @param valorTipoMedida
	 * @param conversionesUnidadMinima
	 * @return
	 */
	public static Duplex<String, String> obtenerValorConversionUnidadMinima(Integer codigoTipoMedida, String valorTipoMedida ,Collection<CatalogoValorRelacionadoDTO> conversionesUnidadMinima ){
		Duplex<String, String> valorUnidadMinima = null;
		if(CollectionUtils.isNotEmpty(conversionesUnidadMinima) && codigoTipoMedida != null && valorTipoMedida != null){
			CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO = (CatalogoValorRelacionadoDTO) CollectionUtils.find(conversionesUnidadMinima, PredicateUtils.andPredicate(new BeanPredicate("id.codigoCatalogoValorTipoPadre", PredicateUtils.equalPredicate(codigoTipoMedida)),new BeanPredicate("id.codigoCatalogoValorPadre", PredicateUtils.equalPredicate(valorTipoMedida))));
			if(catalogoValorRelacionadoDTO != null){
				String valorConversion = catalogoValorRelacionadoDTO.getValor();
				String unidad = catalogoValorRelacionadoDTO.getId().getCodigoCatalogoValorRelacionado();
				valorUnidadMinima = new Duplex<String, String>();
				valorUnidadMinima.setFirstObject(valorConversion);
				valorUnidadMinima.setSecondObject(unidad);
			}
			
		}
		
		return valorUnidadMinima;
	}


}
