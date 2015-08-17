package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumEstadosEntrega {
	
	INICIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.inicio")),
	PENDIENTE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.pendiente")),
	ENVIADA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.enviada")),
	CONFIRMADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.confirmado")),
	RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.enRecepcion")),
	RECIBIDA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.recibida")),
	SOLICITADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.solicitado")),
	RECIBIDATOTAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.recibidaTotal")),
	RECIBIDAPARCIAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.entrega.estado.recibidaParcial"));
	
	String estado;
	
	EnumEstadosEntrega(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
}
