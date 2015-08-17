package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Comparator;

public class VistaArticuloUnidadManejoRecepcionComparador implements Comparator<VistaArticuloUnidadManejoRecepcionDTO>{

	@Override
	public int compare(VistaArticuloUnidadManejoRecepcionDTO vistaArticuloUnidadManejoRecepcion1, VistaArticuloUnidadManejoRecepcionDTO vistaArticuloUnidadManejoRecepcion2) {
		 int comparador = vistaArticuloUnidadManejoRecepcion1.getFechaEntrega().compareTo(vistaArticuloUnidadManejoRecepcion2.getFechaEntrega()); 
		 if (comparador == 0){
			 if (vistaArticuloUnidadManejoRecepcion1.getId().getHoraInicio() != null && vistaArticuloUnidadManejoRecepcion2.getId().getHoraInicio() != null && comparador == 0){
				 comparador = vistaArticuloUnidadManejoRecepcion1.getId().getHoraInicio().compareTo(vistaArticuloUnidadManejoRecepcion2.getId().getHoraInicio());
				 if (vistaArticuloUnidadManejoRecepcion1.getCostoNeto() != null && vistaArticuloUnidadManejoRecepcion2.getCostoNeto() != null && comparador == 0){
					 comparador = vistaArticuloUnidadManejoRecepcion1.getCostoNeto().compareTo(vistaArticuloUnidadManejoRecepcion2.getCostoNeto());
					 if (vistaArticuloUnidadManejoRecepcion1.getFechaElaboracionPedido() != null && vistaArticuloUnidadManejoRecepcion2.getFechaElaboracionPedido() != null && comparador == 0){
						 comparador = vistaArticuloUnidadManejoRecepcion1.getFechaElaboracionPedido().compareTo(vistaArticuloUnidadManejoRecepcion2.getFechaElaboracionPedido());	 
					 }
				 }
			 }
		 }
		return comparador;
	}

}
