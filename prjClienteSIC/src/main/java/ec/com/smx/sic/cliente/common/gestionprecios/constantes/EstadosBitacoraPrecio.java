package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * 
 * @author Luis Yacchirema
 *
 */
public abstract class EstadosBitacoraPrecio {

	private String valorEstadoBitacoraPrecios;
	public final static Integer CODIGO_ESTADO_BITACORA_PRECIO = TipoCatalogosGestionPrecios.TIPO_ESTADO_BITACORA_PRECIO;

	public EstadosBitacoraPrecio(String valorEstadoBitacoraPrecios) {
		this.valorEstadoBitacoraPrecios = valorEstadoBitacoraPrecios;
	}

	/**
	 * @return the valorEstadoBitacoraPrecios
	 */
	public String getValorEstadoBitacoraPrecios() {
		return valorEstadoBitacoraPrecios;
	}



	public static final EstadosBitacoraPrecio REGISTRADO = new EstadosBitacoraPrecio(SICConstantes.getInstancia().VALOR_ESTADO_BITACORA_PRECIO_REGISTRADO) {};
	public static final EstadosBitacoraPrecio CONFIRMADO = new EstadosBitacoraPrecio(SICConstantes.getInstancia().VALOR_ESTADO_BITACORA_PRECIO_CONFIRMADO) {};

}
