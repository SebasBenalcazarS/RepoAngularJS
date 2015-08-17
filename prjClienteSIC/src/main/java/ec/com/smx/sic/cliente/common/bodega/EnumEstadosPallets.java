package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumEstadosPallets {
	
	INICIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.inicio")),
	EN_ANDEN(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.enAnden")),	
	EN_PROCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.enProceso")),
	EN_BALANZA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.balanza")),
	PESADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.pesado")),
	EN_PASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.enPasillo")),
	ANULADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.anulado")),
	TERMINADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.pallets.estado.terminado"));
	
	String estado;
	
	EnumEstadosPallets(String estado){
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
}
