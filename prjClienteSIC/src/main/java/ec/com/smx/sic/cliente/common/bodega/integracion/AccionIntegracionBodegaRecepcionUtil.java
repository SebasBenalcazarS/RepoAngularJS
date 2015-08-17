/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega.integracion;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.ArrayUtils;


/**
 * @author jdvasquez
 *
 */
public final class AccionIntegracionBodegaRecepcionUtil {
	
	private static final AccionIntegracionBodegaRecepcionUtil INSTANCIA = new AccionIntegracionBodegaRecepcionUtil();

	/**
	 * @return the instancia
	 */
	public static AccionIntegracionBodegaRecepcionUtil getInstancia() {
		return INSTANCIA;
	}
	
	/**
	 * Particiona una coleccion en N colecciones dependiendo del numero de iteraciones (partes) enviado como parametro  
	 * @param articulos
	 * @param iteracion
	 * @param cantidadMaximaItems
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Collection<T> obtenerSubColeccionAIntegrar(Collection<T> articulos, int iteracion, int cantidadMaximaItems){
		int root = (iteracion == 1) ? 0 : (iteracion-1) * cantidadMaximaItems;
		int length = (articulos.size() < cantidadMaximaItems * iteracion) ? articulos.size() : cantidadMaximaItems * iteracion;
		Collection<T> listaParticionada = new ArrayList<T>();
		Object[] arrPart = ArrayUtils.subarray(articulos.toArray(), root, length);
		for(Object object : arrPart){
			listaParticionada.add((T)object);
		}
		return listaParticionada;
	}
	
	/**
	 * Calcula el numero de iteraciones (particiones) de una coleccion 
	 * @param totalItems
	 * @param maximoItemsIntegrar
	 * @return
	 */
	public Integer calcularIteraciones(Integer totalItems, Integer maximoItemsIntegrar) {
		if(totalItems <= maximoItemsIntegrar){
			return 1;	
		}
		return ((totalItems % maximoItemsIntegrar) == 0 ? (totalItems / maximoItemsIntegrar) : ((totalItems / maximoItemsIntegrar) + 1));
	}
}
