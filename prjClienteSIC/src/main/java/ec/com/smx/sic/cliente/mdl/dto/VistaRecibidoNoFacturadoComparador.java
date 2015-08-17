package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Comparator;

public class VistaRecibidoNoFacturadoComparador implements Comparator<VistaRecibidoNoFacturadoDTO>{

	@Override
	public int compare(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO1, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO2) {
		int comparador = vistaRecibidoNoFacturadoDTO1.getDiferenciaValoresFacturas().compareTo(vistaRecibidoNoFacturadoDTO2.getDiferenciaValoresFacturas()); 
		return comparador*-1;
	}

}
