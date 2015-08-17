package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumEstadosProcesoLogistico {
	
	REGISTRADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.registrado")),
	ASIGNADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.asignado")),	
	EN_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.enRecepcion")),
	RECIBIDO_JABAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.recibido.jabas")),
	SUSPENDIDO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.suspendido")),	
	RECIBIDO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.recibido")),	
	FACTURADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.facturado")),	
	INICIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.inicio")),	
	CANCELADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.cancelado")),	
	TERMINADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.proceso.logistico.estado.terminado"));
	
	String estado;
	
	EnumEstadosProcesoLogistico(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
}
