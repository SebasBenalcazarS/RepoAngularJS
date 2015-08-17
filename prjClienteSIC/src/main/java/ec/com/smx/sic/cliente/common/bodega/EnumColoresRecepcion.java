package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumColoresRecepcion {
	ENCONTRADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.color.articulos.encontrado")),
	COMPLETO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.color.articulos.completo")),
	MEDIO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.color.articulos.medio")),
	BAJO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.color.articulos.bajo")),
	;
	
	String accion;
	
	EnumColoresRecepcion(String accion){
		this.accion = accion;
	}
	public String getAccion() {
		return accion;
	}

	public static EnumColoresRecepcion getEnumColoresRecepcion(String accion) {
		for (EnumColoresRecepcion enumColoresRecepcion : EnumColoresRecepcion.values()) {
			if (enumColoresRecepcion.getAccion().equals(accion))  {
				return enumColoresRecepcion;
			}
		}
		return null;
	}
}
