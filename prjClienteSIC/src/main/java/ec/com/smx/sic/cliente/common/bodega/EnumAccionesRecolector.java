package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumAccionesRecolector {
	
	INICIAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.iniciar")),
	REGISTRAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.registrar")),
	ASIGNAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.asignadar")),
	PROCESAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.procesar")),
	BALANZA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.balanza")),
	REGISTRAR_PESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.accion.registrar.peso")),
	SUSPENDER(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.suspender")),
	REANUDAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.reanudar")),
	LIBERAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.liberar")),
	TERMINAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.terminar")),
	CANCELAR(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tarea.recolector.accion.cancelar")),
	;
	
	String accion;
	
	EnumAccionesRecolector(String accion){
		this.accion = accion;
	}
	
	public String getAccion() {
		return accion;
	}
}
