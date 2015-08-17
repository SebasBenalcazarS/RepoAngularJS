package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Comparator;

public class VistaCalendarioPlanificacionComparador implements Comparator<VistaCalendarioPlanificacionBodegaDTO>{
	public VistaCalendarioPlanificacionComparador(){
	}
	@Override
	public int compare(VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacionBodegaDTO1, VistaCalendarioPlanificacionBodegaDTO vistaCalendarioPlanificacinBodegaDTO2) {
		 int c;
		 if(vistaCalendarioPlanificacionBodegaDTO1.getNombreProveedor() == null){
			 vistaCalendarioPlanificacionBodegaDTO1.setNombreProveedor("");
		 }
		 if(vistaCalendarioPlanificacinBodegaDTO2.getNombreProveedor() == null){
			 vistaCalendarioPlanificacinBodegaDTO2.setNombreProveedor("");
		 }
		 c = vistaCalendarioPlanificacionBodegaDTO1.getNombreProveedor().compareTo(vistaCalendarioPlanificacinBodegaDTO2.getNombreProveedor()); 
		 return c; 
	}

}
