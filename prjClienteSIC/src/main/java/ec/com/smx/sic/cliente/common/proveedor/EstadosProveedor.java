/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author vjaramillo
 *
 */
public enum EstadosProveedor {
	
	ACTIVO(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO, SICConstantes.getInstancia().LABEL_ESTADO_ACTIVO),
	INACTIVO(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO, SICConstantes.getInstancia().LABEL_ESTADO_INACTIVO);

	private final String value;
	private final String label;
	
	private EstadosProveedor(String value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public static List<EstadosProveedor> getEstadosProveedor(){
		return Arrays.asList(EstadosProveedor.values());
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
