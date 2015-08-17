package ec.com.smx.sic.cliente.common.pedidoAsistido;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @author aguato
 *
 */
public enum DiasConfiguracionPedidoAsistido {
	LUNES(Calendar.MONDAY, "Lunes"),
	MARTES(Calendar.TUESDAY, "Martes"),
	MIERCOLES(Calendar.WEDNESDAY, "Mi\u00E9rcoles"),
	JUEVES(Calendar.THURSDAY, "Jueves"),
	VIERNES(Calendar.FRIDAY, "Viernes"),
	SABADO(Calendar.SATURDAY, "S\u00E1bado"),
	DOMINGO(Calendar.SUNDAY, "Domingo");
	
	private final int value;
	private final String label;
	
	/**
	 * @param value
	 * @param label
	 */
	private DiasConfiguracionPedidoAsistido(int value, String label) {
		this.value = value;
		this.label = label;
	}
	
	/**
	 * @return
	 */
	public static List<DiasConfiguracionPedidoAsistido> getDiasConfiguracionPedidoAsistido(){
		return Arrays.asList(DiasConfiguracionPedidoAsistido.values());
	}
	
	public static DiasConfiguracionPedidoAsistido getDiaConfiguracion(Integer codigoDia){
		switch (codigoDia) {
		case Calendar.MONDAY:
			return DiasConfiguracionPedidoAsistido.LUNES;
		case Calendar.TUESDAY:
			return DiasConfiguracionPedidoAsistido.MARTES;
		case Calendar.WEDNESDAY:
			return DiasConfiguracionPedidoAsistido.MIERCOLES;
		case Calendar.THURSDAY:
			return DiasConfiguracionPedidoAsistido.JUEVES;
		case Calendar.FRIDAY:
			return DiasConfiguracionPedidoAsistido.VIERNES;
		case Calendar.SATURDAY:
			return DiasConfiguracionPedidoAsistido.SABADO;
		default:
			return DiasConfiguracionPedidoAsistido.DOMINGO;
		}
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
}
