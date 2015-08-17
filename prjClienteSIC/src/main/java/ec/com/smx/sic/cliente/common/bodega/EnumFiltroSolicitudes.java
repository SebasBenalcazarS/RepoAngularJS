package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumFiltroSolicitudes {
	TODOS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.filtro.solicitudes.todos")),
	CONSOLICITUDES(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.filtro.solicitudes.conSolicitudes")),
	SINSOLICITUDES(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.filtro.solicitudes.sinSolicitudes"));
	String estado;
	EnumFiltroSolicitudes(String estado){
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
}
