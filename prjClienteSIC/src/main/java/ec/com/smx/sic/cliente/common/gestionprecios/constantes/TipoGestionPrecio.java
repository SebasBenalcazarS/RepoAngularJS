package ec.com.smx.sic.cliente.common.gestionprecios.constantes;


/**
 * 
 * @author Luis Yacchirema
 *
 */
public abstract class TipoGestionPrecio {

	private String valorTipoGestionPrecio;
	public final static Integer CODIGO_TIPO_GESTION_PRECIO = TipoCatalogosGestionPrecios.TIPO_GESTION_PRECIO;

	public TipoGestionPrecio(String valorTipoGestionPrecio) {
		this.valorTipoGestionPrecio = valorTipoGestionPrecio;
	}

	/**
	 * @return
	 */
	public String getValorTipoGestionPrecio() {
		return valorTipoGestionPrecio;
	}

	public static final TipoGestionPrecio PROMOCION = new TipoGestionPrecio(GestionPrecioConstantes.getInstancia().VALOR_TIPO_GESTION_PRECIO_PROMOCION) {};
	public static final TipoGestionPrecio CAMBIO_PRECIO = new TipoGestionPrecio(GestionPrecioConstantes.getInstancia().VALOR_TIPO_GESTION_PRECIO_CAMBIO_PRECIOS) {};
	public static final TipoGestionPrecio OFERTA = new TipoGestionPrecio(GestionPrecioConstantes.getInstancia().VALOR_TIPO_GESTION_PRECIO_OFERTA) {};
	public static final TipoGestionPrecio PLANTILLA = new TipoGestionPrecio(GestionPrecioConstantes.getInstancia().VALOR_TIPO_GESTION_PLANTILLA) {};
	public static final TipoGestionPrecio CAMPANIA = new TipoGestionPrecio(GestionPrecioConstantes.getInstancia().VALOR_TIPO_GESTION_CAMPANIA) {};

}
