package ec.com.smx.sic.cliente.gestor.fruver.busqueda;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OfertaProveedorDTO;

/**
 * 
 * @author KRUGER\oviana
 *
 */
public interface IAlmacenamientoOfertaProveedorGestor {

	/**
	 * Permite registrar las cantidades o pesos que oferta el proveedor
	 * @param ofertaProveedorDTO
	 * @param esCreacion True si es creacion, False en caso contrario
	 */
	public void guardarOfertasProveedor(OfertaProveedorDTO ofertaProveedorDTO, Boolean esCreacion) throws SICException;
	
	/**
	 * Permite cambiar el estado de las ofertas a enviadas
	 * @param codigoCompania Codigo de la compania
	 * @param codigoOferta Codigo de la oferta que se esta enviando
	 * @param codigoProveedor Codigo del proveedor que esta realizando la oferta
	 * @throws SICException
	 */
	public void enviarOfertasProveedor(Integer codigoCompania, Integer codigoOferta, String codigoProveedor) throws SICException;
	
}
