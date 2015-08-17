package ec.com.smx.sic.cliente.servicio.bodega;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author aecaiza
 *
 */
public interface IBodegaArticuloCalculoServicio {
	
	/**
	 * Validar el codigo de barras interno y ean
	 * @param codigoBarrasArticulo
	 * @return
	 * @throws SICException
	 */
	String validarCodigoBarrasArticulo(String codigoBarrasArticulo) throws SICException;
}
