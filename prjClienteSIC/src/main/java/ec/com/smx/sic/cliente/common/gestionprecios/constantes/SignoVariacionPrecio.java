package ec.com.smx.sic.cliente.common.gestionprecios.constantes;


/**
 * 
 * @author Luis Yacchirema
 *
 */
public abstract class SignoVariacionPrecio {

	private String valorSignoVariacionPrecio;
	public final static Integer CODIGO_SIGNO_VARIACION_PRECIO = TipoCatalogosGestionPrecios.SIGNO_VARIACION_PRECIO;

	public SignoVariacionPrecio(String valorSignoVariacionPrecio) {
		this.valorSignoVariacionPrecio = valorSignoVariacionPrecio;
	}

	public String getValorSignoVariacionPrecio() {
		return valorSignoVariacionPrecio;
	}

	public static final SignoVariacionPrecio SUMA = new SignoVariacionPrecio(GestionPrecioConstantes.getInstancia().VALOR_SIGNO_VARIACION_PRECIO_SUMA) {};
	public static final SignoVariacionPrecio RESTA = new SignoVariacionPrecio(GestionPrecioConstantes.getInstancia().VALOR_SIGNO_VARIACION_PRECIO_RESTA) {};
	public static final SignoVariacionPrecio IGUAL = new SignoVariacionPrecio(GestionPrecioConstantes.getInstancia().VALOR_SIGNO_VARIACION_PRECIO_IGUAL) {};

}