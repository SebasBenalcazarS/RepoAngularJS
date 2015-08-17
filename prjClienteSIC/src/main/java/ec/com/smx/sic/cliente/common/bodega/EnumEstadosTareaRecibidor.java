package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;


public enum EnumEstadosTareaRecibidor {
	INICIADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.inicio")),
	REGISTRADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.registrada")),
	ASIGNADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.asignada")),
	ENPROCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.en.proceso")),
	SUSPENDIDA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.suspendida")),
	TERMINADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.terminada")),
	CANCELADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.cancelada")),
	LIBERADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.estado.liberado")),
	;
	
	String estado;
	
	EnumEstadosTareaRecibidor(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
