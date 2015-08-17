/**
 * 
 */
package ec.com.smx.sic.cliente.common.pedidoAsistido;

import java.util.Arrays;
import java.util.List;

/**
 * @author bsandoval
 *
 */
public class ComparadorBodegaPereciblesUtil {

	public ComparadorBodegaPereciblesUtil(){

	}

	public static Boolean verificarBodegaPerecibles(Integer codigoBodega){

		List<String> parametroBodegasPerecibles = Arrays.asList(SICPedidoAsistidoConstantes.CODIGO_AREA_TRABAJO_BODEGA_PERECIBLES.split(",")) ;

		if(parametroBodegasPerecibles.contains(Integer.toString(codigoBodega.intValue()))){		
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}

	}

}
