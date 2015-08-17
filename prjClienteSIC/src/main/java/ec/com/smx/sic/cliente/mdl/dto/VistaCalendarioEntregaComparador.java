package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Comparator;

public class VistaCalendarioEntregaComparador implements Comparator<VistaCalendarioEntregaBodegaDTO>{
	Boolean ordenDiario;
	public VistaCalendarioEntregaComparador(Boolean ordenDiario){
		this.ordenDiario = ordenDiario;
	}
	@Override
	public int compare(VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO1, VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO2) {
		 int c;
		 if(ordenDiario){
			 
			 if(vistaCalendarioEntregaBodegaDTO1.getNombreProveedor() == null){
				 vistaCalendarioEntregaBodegaDTO1.setNombreProveedor("");
			 }
			 
			 if(vistaCalendarioEntregaBodegaDTO2.getNombreProveedor() == null){
				 vistaCalendarioEntregaBodegaDTO2.setNombreProveedor("");
			 }
			 
			 c = vistaCalendarioEntregaBodegaDTO1.getNombreProveedor().compareTo(vistaCalendarioEntregaBodegaDTO2.getNombreProveedor()); 
			 if (c == 0){
				 if (vistaCalendarioEntregaBodegaDTO1.getHoraInicio() != null && vistaCalendarioEntregaBodegaDTO2.getHoraInicio() != null && c == 0){        
					 c = vistaCalendarioEntregaBodegaDTO1.getHoraInicio().compareTo(vistaCalendarioEntregaBodegaDTO2.getHoraInicio());       
				 }
			 }
		 }
		 else{
			 /*c = vistaCalendarioEntregaBodegaDTO1.getFechaCalendario().compareTo(vistaCalendarioEntregaBodegaDTO2.getFechaCalendario());
			 if (vistaCalendarioEntregaBodegaDTO1.getHoraInicio() != null && vistaCalendarioEntregaBodegaDTO2.getHoraInicio() != null && c == 0){**/        
				 c = vistaCalendarioEntregaBodegaDTO1.getHoraInicio().compareTo(vistaCalendarioEntregaBodegaDTO2.getHoraInicio());  
				 if (c == 0){
					 c = vistaCalendarioEntregaBodegaDTO1.getId().getCodigoProveedor().compareTo(vistaCalendarioEntregaBodegaDTO2.getId().getCodigoProveedor());
				 }
			 //}
		 }
		 return c; 
	}

}
