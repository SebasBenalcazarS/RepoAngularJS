package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IProveedorMarcaDAO {

	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param userId
	 * @param codigosSecuencialMarca
	 * @param estado
	 * @throws SICException
	 */
	
	public abstract void actualizarMarcaProveedor(Integer codigoCompania, String codigoProveedor, String userId, 
			List<Long> codigosSecuencialMarca, String estado) throws SICException;
	
}
