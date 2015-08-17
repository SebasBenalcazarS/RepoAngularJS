/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor.bean;

import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author gnolivos
 *
 */
public enum EstadosArticuloProveedor {
	
	ACTIVO(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO, SICConstantes.getInstancia().LABEL_ESTADO_ACTIVO),
	INACTIVO(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO, SICConstantes.getInstancia().LABEL_ESTADO_INACTIVO);

	private final String value;
	private final String label;
	
	private EstadosArticuloProveedor(String value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public static List<EstadosArticuloProveedor> getEstadosArticuloProveedor(){
		return Arrays.asList(EstadosArticuloProveedor.values());
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
