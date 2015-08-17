package ec.com.smx.sic.cliente.common.articulo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;

public class CaracteristicaDinamicaUtil {

	@SuppressWarnings("unchecked")
	public static Set<EnumCaracteristicaDinamica> transformarCaracteristicasDinamicas(final Collection<CaracteristicaDinamicaDTO> caracteristicasDinamicas) throws SICException{
		Set<EnumCaracteristicaDinamica> carDin = null;
		try{
			
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicas)){
				Collection<EnumCaracteristicaDinamica> enumsCarDin = CollectionUtils.collect(caracteristicasDinamicas, new Transformer() {			
					@Override
					public Object transform(Object arg0) {
						CaracteristicaDinamicaDTO caracteristicaDinamicaDTO = (CaracteristicaDinamicaDTO) arg0;
						if(StringUtils.isNotEmpty(caracteristicaDinamicaDTO.getCodigoValorCaracteristica()) 
								&& caracteristicaDinamicaDTO.getCodigoTipoCaracteristica() != null 
								&& (caracteristicaDinamicaDTO.getCodigoTipoCaracteristica().compareTo(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION) == 0
								|| caracteristicaDinamicaDTO.getCodigoTipoCaracteristica().compareTo(TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO) == 0)){
							return EnumCaracteristicaDinamica.getEnumByValueCode(caracteristicaDinamicaDTO.getCodigoValorCaracteristica(), caracteristicaDinamicaDTO.getCodigoTipoCaracteristica());
						}else{
							return EnumCaracteristicaDinamica.getEnumByCode(caracteristicaDinamicaDTO.getCodigoTipoCaracteristica());
						}
					}
				});	
				carDin = new HashSet<EnumCaracteristicaDinamica>(enumsCarDin);
			}
			
		}catch(Exception ex){
			throw new SICException("Ha ocurrido un error al transformar caracter\u00EDsticas din\u00E1micas.");
		}
		return carDin;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Set<EnumCaracteristicaDinamica> transformarCaracteristicasDinamicasPorCatalogo(final Collection<CaracteristicaDinamicaDTO> caracteristicasDinamicas) throws SICException {
		Set<EnumCaracteristicaDinamica> carDin = null;
		try{
			
			if(CollectionUtils.isNotEmpty(caracteristicasDinamicas)){
				Collection<EnumCaracteristicaDinamica> enumsCarDin = CollectionUtils.collect(caracteristicasDinamicas, new Transformer() {			
					@Override
					public Object transform(Object arg0) {
						CaracteristicaDinamicaDTO caracteristicaDinamicaDTO = (CaracteristicaDinamicaDTO) arg0;
						return EnumCaracteristicaDinamica.getEnumByValueCode(caracteristicaDinamicaDTO.getCodigoValorCaracteristica(), caracteristicaDinamicaDTO.getCodigoTipoCaracteristica());
					}
				});	
				carDin = new HashSet<EnumCaracteristicaDinamica>(enumsCarDin);
			}
			
		}catch(Exception ex){
			throw new SICException("Ha ocurrido un error al transformar caracter\u00EDsticas din\u00E1micas.");
		}
		return carDin;
	}	
}