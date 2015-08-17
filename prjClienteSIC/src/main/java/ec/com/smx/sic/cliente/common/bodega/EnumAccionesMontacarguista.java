package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumAccionesMontacarguista {
	
	INICIAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.iniciar")),
	REGISTRAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.registrar")),
	ASIGNAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.asignadar")),
	PROCESAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.procesar")),
	SUSPENDER(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.suspender")),
	REANUDAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.reanudar")),
	LIBERAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.liberar")),
	TERMINAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.terminar")),
	CANCELAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.montacarguista.accion.cancelar")),
	;
	
	String accion;
	
	EnumAccionesMontacarguista(String accion) {
		this.accion = accion;
	}
	
	public String getAccion() {
		return accion;
	}
}
