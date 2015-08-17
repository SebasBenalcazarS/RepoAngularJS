package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;

/**
 * @author Luis Yacchirema
 *
 */
public enum TipoAfectacionCalculoPrecio {
	
	NINGUNA(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.ninguna")),
	COSTO(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.costo")),
	MARGEN(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.margen")),
	VENTA(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.venta")),
	COSTO_MARGEN(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.costomargen")),
	COSTO_VENTA(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.costoventa")),
	VENTA_MARGEN(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.ventamargen")),
	FACTOR_IMPORTACION(SICCambioPreciosMessages.getInstancia().getInteger("ec.com.smx.sic.cambioPrecios.codigo.tipo.afectacion.factor.importacion"));

	
	private final Integer codigoTipoAfectacion;

	private TipoAfectacionCalculoPrecio(Integer codigoTipoAfectacion) {
		this.codigoTipoAfectacion = codigoTipoAfectacion;
	}

	/**
	 * @return the codigoTipoAfectacion
	 */
	public Integer getCodigoTipoAfectacion() {
		return codigoTipoAfectacion;
	}
	
	/**
	 * @param codigoTipoAfectacion
	 * @return
	 */
	public static String valorTipoAfectacion(Integer codigoTipoAfectacion) {
		return obtenerTipoAfectacionCalculoPrecio(codigoTipoAfectacion).toString();
	}
	
	/**
	 * @param codigoTipoAfectacion
	 * @return
	 */
	public static TipoAfectacionCalculoPrecio obtenerTipoAfectacionCalculoPrecio(Integer codigoTipoAfectacion) {
		
		TipoAfectacionCalculoPrecio tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.NINGUNA;

		if (COSTO.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.COSTO;
		} 
		else if (MARGEN.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.MARGEN;
		}
		else if (VENTA.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.VENTA;
		}
		else if (COSTO_MARGEN.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.COSTO_MARGEN;
		}
		else if (COSTO_VENTA.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.COSTO_VENTA;
		}
		else if (VENTA_MARGEN.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.VENTA_MARGEN;
		}
		else if (FACTOR_IMPORTACION.codigoTipoAfectacion == codigoTipoAfectacion) {
			tipoAfectacionCalculoPrecio = TipoAfectacionCalculoPrecio.FACTOR_IMPORTACION;
		}
			
		return tipoAfectacionCalculoPrecio;
		
	}

}
