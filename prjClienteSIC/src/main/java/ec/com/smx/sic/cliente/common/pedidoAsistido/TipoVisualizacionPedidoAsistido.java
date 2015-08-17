package ec.com.smx.sic.cliente.common.pedidoAsistido;

import java.util.Arrays;
import java.util.List;

/**
 * @author khidalgo
 *
 */
public enum TipoVisualizacionPedidoAsistido {
	TODOS("Todos",1),
	PEDIDOS("Pedidos",2),
	NO_PEDIDOS("No pedidos",3);
	
	private final String label;
	private final int value;
	
	/**
	 * @param label
	 */
	private TipoVisualizacionPedidoAsistido(String label,int value) {
		this.label = label;
		this.value=value;
	}
	
	/**
	 * @return
	 */
	public static List<TipoVisualizacionPedidoAsistido> getTipoVisualizacionesPedidoAsistido(){
		return Arrays.asList(TipoVisualizacionPedidoAsistido.values());
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}
	
	
}
