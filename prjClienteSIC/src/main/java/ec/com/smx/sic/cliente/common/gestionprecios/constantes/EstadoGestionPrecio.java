package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

import ec.com.smx.sic.cliente.resources.cambioprecios.SICCambioPreciosMessages;


/**
 * 
 * @author Luis Yacchirema
 *
 */
public enum EstadoGestionPrecio {

	NINGUNA(null,null),
	NO_APLICA(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_NO_APLICA, null),
	PENDIENTE(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_PENDIENTE, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.pendiente")),	
	CONFIRMADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_CONFIRMADO, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.confirmado")),
	AUTORIZADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_AUTORIZADO, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.autorizado")),
	DESAUTORIZADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_DESAUTORIZADO, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.desautorizado")),
	POR_FINALIZAR(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_POR_FINALIZAR, SICCambioPreciosMessages.getInstancia().getString("ec.com.smx.sic.cambioPrecios.etiqueta.estado.por.finalizar")),
	ANULADO(GestionPrecioConstantes.getInstancia().VALOR_ESTADO_GESTION_PRECIO_ANULADO, null);

	private String valorEstadoGestionPrecio;
	private String labelEstadoGestionPrecio;
	public final static Integer CODIGO_ESTADO_GESTION_PRECIO = TipoCatalogosGestionPrecios.TIPO_ESTADO_GESTION_PRECIO;

	private EstadoGestionPrecio(String valorEstadoGestionPrecio, String labelEstadoGestionPrecio) {
		this.valorEstadoGestionPrecio = valorEstadoGestionPrecio;
		this.labelEstadoGestionPrecio = labelEstadoGestionPrecio;
	}
	
	/**
	 * @return the valorEstadoGestionPrecio
	 */
	public String getValorEstadoGestionPrecio() {
		return valorEstadoGestionPrecio;
	}

	/**
	 * @return the labelEstadoGestionPrecio
	 */
	public String getLabelEstadoGestionPrecio() {
		return labelEstadoGestionPrecio;
	}
	
	/**
	 * @param valorEstadoGestionPrecio
	 * @return
	 */
	public static EstadoGestionPrecio valueOfValorEstado(String valorEstadoGestionPrecio) {
		
		EstadoGestionPrecio estadoGestionPrecio = EstadoGestionPrecio.NINGUNA;

		if (PENDIENTE.valorEstadoGestionPrecio.equals(valorEstadoGestionPrecio)) {
			estadoGestionPrecio = EstadoGestionPrecio.PENDIENTE;
		} 
		else if (CONFIRMADO.valorEstadoGestionPrecio.equals(valorEstadoGestionPrecio)) {
			estadoGestionPrecio = EstadoGestionPrecio.CONFIRMADO;			
		}
		else if (AUTORIZADO.valorEstadoGestionPrecio.equals(valorEstadoGestionPrecio)) {
			estadoGestionPrecio = EstadoGestionPrecio.AUTORIZADO;			
		}
		else if (DESAUTORIZADO.valorEstadoGestionPrecio.equals(valorEstadoGestionPrecio)) {
			estadoGestionPrecio = EstadoGestionPrecio.DESAUTORIZADO;			
		}
		else if (ANULADO.valorEstadoGestionPrecio.equals(valorEstadoGestionPrecio)) {
			estadoGestionPrecio = EstadoGestionPrecio.ANULADO;
		}
		
		return estadoGestionPrecio;
		
	}

}
