package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumAccionesRecibidor {
	INICIAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.iniciar")),
	REGISTRAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.registrar")),
	ASIGNAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.asignar")),
	PROCESAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.procesar")),
	SUSPENDER(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.suspender")),
	REANUDAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.reanudar")),
	TERMINAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.terminar")),
	LIBERAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.liberar")),
	REABRIR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.reabrir")),
	CANCELAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recibidor.accion.cancelar")),
	;
	
	String accion;
	
	EnumAccionesRecibidor(String accion){
		this.accion = accion;
	}
	
	public String getAccion() {
		return accion;
	}
}
