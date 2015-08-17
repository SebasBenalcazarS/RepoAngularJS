package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;


public enum EnumEstadosTareaMontacarguista {
	
	INICIADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.inicio")),
	REGISTRADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.registrada")),
	ASIGNADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.asignada")),
	ENPROCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.en.proceso")),
	SUSPENDIDA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.suspendida")),
	TERMINADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.terminada")),
	CANCELADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.estado.cancelada")),
	;
	
	String estado;
	
	EnumEstadosTareaMontacarguista(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
