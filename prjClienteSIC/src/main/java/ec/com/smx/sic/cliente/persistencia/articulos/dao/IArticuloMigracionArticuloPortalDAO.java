package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author corbe
 *
 */
public interface IArticuloMigracionArticuloPortalDAO {
	public void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException;
}
