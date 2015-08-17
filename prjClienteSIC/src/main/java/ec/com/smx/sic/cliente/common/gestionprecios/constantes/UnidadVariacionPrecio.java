package ec.com.smx.sic.cliente.common.gestionprecios.constantes;


/**
 * 
 * @author Luis Yacchirema
 *
 */
public abstract class UnidadVariacionPrecio {

	private String valorUnidadVariacionPrecio;
	public final static Integer CODIGO_UNIDAD_VARIACION_PRECIO = TipoCatalogosGestionPrecios.UNIDAD_VARIACION_PRECIO;

	public UnidadVariacionPrecio(String valorUnidadVariacionPrecio) {
		this.valorUnidadVariacionPrecio = valorUnidadVariacionPrecio;
	}

	public String getValorUnidadVariacionPrecio() {
		return valorUnidadVariacionPrecio;
	}

	public static final UnidadVariacionPrecio PORCENTAJE = new UnidadVariacionPrecio(GestionPrecioConstantes.getInstancia().VALOR_UNIDAD_VARIACION_PRECIO_PORCENTAJE) {};
	public static final UnidadVariacionPrecio MONEDA = new UnidadVariacionPrecio(GestionPrecioConstantes.getInstancia().VALOR_UNIDAD_VARIACION_PRECIO_MONEDA) {};

}