package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author srodriguez
 *	2014-12-15
 */
public interface IPromocionDAO {
	
	/**
	 * @author srodriguez
	 * @param promocion
	 */
	void crearPromocion(GestionPrecioDTO promocion);
	
	/**
	 * @author srodriguez
	 * @param promocion
	 */
	void actualizarPromocion(GestionPrecioDTO promocion);
	
	/**
	 * @author srodriguez
	 * @param codigoPromocion
	 * @return
	 */
	GestionPrecioDTO findPromocion(Long codigoPromocion);
	
	void crearArticuloGestionPrecio(ArticuloGestionPrecioDTO articuloGestionPrecioDTO) throws SICException;
	
	void actualizarPromocion(GestionPrecioDTO promocion, final Long codigoPromocion);
	
	void actualizarArticuloGestionPrecio(ArticuloGestionPrecioDTO articuloGestionPrecioDTO) throws SICException;
}
