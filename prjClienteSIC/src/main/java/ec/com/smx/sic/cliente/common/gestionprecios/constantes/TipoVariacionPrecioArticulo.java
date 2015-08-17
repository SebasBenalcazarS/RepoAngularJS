package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * 
 * @author Luis Yacchirema
 *
 */
public abstract class TipoVariacionPrecioArticulo {

	private String valorTipoVariacionPrecio;
	public final static Integer CODIGO_TIPO_VARIACION_PRECIO = TipoCatalogosGestionPrecios.TIPO_VARIACION_PRECIO;

	public TipoVariacionPrecioArticulo(String valorTipoVariacionPrecio) {
		this.valorTipoVariacionPrecio = valorTipoVariacionPrecio;
	}

	public String getValorTipoVariacionPrecio() {
		return valorTipoVariacionPrecio;
	}

	public static final TipoVariacionPrecioArticulo COSTO_BRUTO = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_COSTO_BRUTO) {};
	public static final TipoVariacionPrecioArticulo MARGEN_PRECIO_BASE = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_MARGEN_BASE) {};
	public static final TipoVariacionPrecioArticulo PRECIO_BASE = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_BASE) {};
	public static final TipoVariacionPrecioArticulo FACTOR_IMPORTACION_COSTO_BRUTO = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_FAC_IMP_COSTO_BRUTO) {};
	public static final TipoVariacionPrecioArticulo FACTOR_IMPORTACION_PRECIO_PVP = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_FAC_IMP_PVP) {};
	public static final TipoVariacionPrecioArticulo FACTOR_IMPORTACION_PRECIO_SMX = new TipoVariacionPrecioArticulo(SICArticuloConstantes.TIPO_PRECIO_FAC_IMP_SMX) {};

}
