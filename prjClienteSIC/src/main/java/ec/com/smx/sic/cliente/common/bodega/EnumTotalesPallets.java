package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumTotalesPallets 
{
	TOTAL_TOTAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.total.recibidos")),
	TOTAL_ANDEN(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.total.anden")),
	TOTAL_EN_PROCESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.total.enProceso")),
	TOTAL_EN_PASILLO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.total.enPasillo")),
	TOTAL_TERMINADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.monitor.total.terminados"));
	
	private String mensajeMostrar;
	
	EnumTotalesPallets(String message)
	{
		mensajeMostrar = message;
	}
	
	public String getMensajeMostrar() 
	{
		return mensajeMostrar;
	}
}
