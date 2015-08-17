/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * @author wcaiza
 *
 */
public final class EstadosPalletsUtil {
	
	private static final EstadosPalletsUtil INSTANCIA = new EstadosPalletsUtil();
	
	private Collection<String> colCodigoTipoControlCostoPesar;
	private Collection<String> colCodigoTipoControlCostoNoPesar;
	
	private EstadosPalletsUtil () {};
	
	public static EstadosPalletsUtil getInstancia(){
		return INSTANCIA;
	}
	
	/**
	 * @return the colCodigoTipoControlCostoPesar
	 */
	public Collection<String> getColCodigoTipoControlCostoPesar() {
		if (CollectionUtils.isEmpty(colCodigoTipoControlCostoPesar)) {
			colCodigoTipoControlCostoPesar = obtenerValoresPorPesar();
		}
		return colCodigoTipoControlCostoPesar;
	}

	/**
	 * @return the colCodigoTipoControlCostoNoPesar
	 */
	public Collection<String> getColCodigoTipoControlCostoNoPesar() {
		if (CollectionUtils.isEmpty(colCodigoTipoControlCostoNoPesar)) {
			colCodigoTipoControlCostoNoPesar = obtenerValoresSinPesar();
		}
		return colCodigoTipoControlCostoNoPesar;
	}
	
	/**
	 * Obtener la lista de codigos de tipo de control de costos para pesar
	 * @return
	 */
	private Collection<String> obtenerValoresPorPesar(){
		Collection<String> tipoControlCostosPorPesar = new ArrayList<String>();
		tipoControlCostosPorPesar.add(SICArticuloConstantes.TIPCONCOS_PIEPES);
		tipoControlCostosPorPesar.add(SICArticuloConstantes.TIPCONCOS_PESPES);
		return tipoControlCostosPorPesar;
	}
	/**
	 * Obtener lista de codigos de tipo de control de costos sin pesar
	 * @return
	 */
	private Collection<String> obtenerValoresSinPesar(){
		Collection<String> tipoControlCostosSinPesar = new ArrayList<String>();
		tipoControlCostosSinPesar.add(SICArticuloConstantes.TIPCONCOS_PIEPIE);
		tipoControlCostosSinPesar.add(SICArticuloConstantes.TIPCONCOS_PIEPESUM);
		return tipoControlCostosSinPesar;
	}

}
