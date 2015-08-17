package ec.com.smx.sic.cliente.common.proveedor;

import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.SICConstantes;

public enum OrigenProveedor {
	
	NACIONAL(SICConstantes.getInstancia().ORIGEN_PROVEEDOR_NACIONAL,SICConstantes.getInstancia().ORIGEN_PROVEEDOR_NACIONAL_DESCRIPCION),
	IMPORTADO(SICConstantes.getInstancia().ORIGEN_PROVEEDOR_IMPORTADO,SICConstantes.getInstancia().ORIGEN_PROVEEDOR_IMPORTADO_DESCRIPCION);
	
	private final String value;
	private final String label;
	
	/**
	 * Cosntructor.
	 * @param value
	 * @param label
	 */
	private OrigenProveedor(String value, String label) {
		this.label = label;
		this.value = value;
	}
	
	/**
	 * Lista con valores.
	 * @return
	 */
	public static List<OrigenProveedor> getOrigenProveedor(){
		return Arrays.asList(OrigenProveedor.values());
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
