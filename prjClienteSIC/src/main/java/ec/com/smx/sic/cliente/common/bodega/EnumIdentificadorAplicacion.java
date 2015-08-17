package ec.com.smx.sic.cliente.common.bodega;


import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;


public enum EnumIdentificadorAplicacion {
	
	SSCC(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.sscc"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion18.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	EAN14(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.ean14"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion14.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	EAN13(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.ean13"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion14.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	LOTE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.lote"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion20.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.variable")),
	FECHA_ELABORACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.fecha.fabricacion"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion6.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	FECHA_CADUCIDAD(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.fecha.maxima.duracion"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion6.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	FECHA_MINIMA_DURACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.fecha.minima.duracion"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion6.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),		
	VARIANTE_PRODUCTO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.variante.producto"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion2.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")),
	CANTIDAD(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.cantidad"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.indentificador.aplicacion8.max.length"),
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.variable"));
	
	private String codigoIdentificadorAplicacion;
	private Integer longitudIdentificadorAplicacion;
	private String tipoIdentificadorAplicacion;
	
	/**
	 * @param codigoIdentificadorAplicacion
	 */
	private EnumIdentificadorAplicacion(String codigoIdentificadorAplicacion, String longitudIdentificadorAplicacion, String tipoIdentificadorAplicacion) {
		this.codigoIdentificadorAplicacion = codigoIdentificadorAplicacion;
		this.longitudIdentificadorAplicacion = Integer.valueOf(longitudIdentificadorAplicacion);
		this.tipoIdentificadorAplicacion = tipoIdentificadorAplicacion;
	}

	public static EnumIdentificadorAplicacion valueOfCodigoIdentificadorAplicacion(final String codigoIdentificadorAplicacion){
		if(StringUtils.isNotBlank(codigoIdentificadorAplicacion)){
			for(EnumIdentificadorAplicacion enumIdentificadorAplicacion: EnumIdentificadorAplicacion.values()){
				if(StringUtils.equals(codigoIdentificadorAplicacion, enumIdentificadorAplicacion.getCodigoIdentificadorAplicacion())){
					return enumIdentificadorAplicacion;
				}
			}	
		}
		return null;
	}
	
//	public int getLength() {
//	switch(this) {
//	case SSCC:  return 18;
//	case EAN13: return 14;
//	case EAN14: return 14;
//	default: return 0;
//	}
//}


	/**
	 * @return the codigoIdentificadorAplicacion
	 */
	public String getCodigoIdentificadorAplicacion() {
		return codigoIdentificadorAplicacion;
	}

	/**
	 * @return the longitudIdentificadorAplicacion
	 */
	public Integer getLongitudIdentificadorAplicacion() {
		return longitudIdentificadorAplicacion;
	}

	/**
	 * @return the tipoIdentificadorAplicacion
	 */
	public String getTipoIdentificadorAplicacion() {
		return tipoIdentificadorAplicacion;
	}
}
