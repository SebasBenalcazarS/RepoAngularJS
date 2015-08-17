package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumRelacionDetallesOrdenCompra {
	
	CAMBIO_CODIGOS_BARRAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.juguetes.cambio.codigo.barras"))
	;
	
	String valor;
	
	EnumRelacionDetallesOrdenCompra(String valor){
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
}
