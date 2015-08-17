package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import ec.com.smx.sic.cliente.exception.SICException;


public interface IArticuloComercialDAO {

	public Integer actualizarMarcaComercial(Integer codigoCompania, String codigoArticulo, String userId, Long codigoMarca) throws SICException;
}
