package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;


public enum EnumEstadosTareaRecolector {
	INICIADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.inicio")),
	REGISTRADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.registrada")),
	ASIGNADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.asignada")),
	ENPROCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.en.proceso")),
	SUSPENDIDA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.suspendida")),
	TERMINADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.terminada")),
	CANCELADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.estado.cancelada")),
	;
	
	String estado;
	
	EnumEstadosTareaRecolector(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
