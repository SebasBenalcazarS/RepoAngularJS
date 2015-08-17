/**
 * 
 */
package ec.com.smx.sic.cliente.common.ofertas;

import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.ofertas.constantes.OfertaConstantes;

/**
 * @author gnolivos
 *
 */
public enum TipoOfertas {
	
	COSTO(OfertaConstantes.getInstancia().CODIGO_TIPO_OFERTA_COSTO, OfertaConstantes.getInstancia().DESCRIPCION_TIPO_OFERTA_COSTO),
	VENTA(OfertaConstantes.getInstancia().CODIGO_TIPO_OFERTA_VENTA, OfertaConstantes.getInstancia().DESCRIPCION_TIPO_OFERTA_VENTA),
	VENTA_COSTO(OfertaConstantes.getInstancia().CODIGO_TIPO_OFERTA_VENTA_COSTO, OfertaConstantes.getInstancia().DESCRIPCION_TIPO_OFERTA_VENTA_COSTO);
	
	private final String value;
	private final String label;
	/**
	 * Cosntructor.
	 * @param value
	 * @param label
	 */
	private TipoOfertas(String value, String label) {
		this.label = label;
		this.value = value;
	}
	
	public static List<TipoOfertas> getTipoOfertas(){
		return Arrays.asList(TipoOfertas.values());
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

}
