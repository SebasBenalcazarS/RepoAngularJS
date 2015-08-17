package ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;

/**
 * Interfaz que define el comportamiento de registro y obtencion de informacion historica de los estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public interface IArticuloBitacoraLeyMercadoDAO {

	/**
	 * Metodo que registra la informacion historica de los estados del articulo
	 * @author mgranda
	 * @param articuloBitacoraLeyMercadoDTO
	 * @throws SICException
	 */
	void crearArticuloBitacoraLeyMercado(ArticuloBitacoraLeyMercadoDTO articuloBitacoraLeyMercadoDTO) throws SICException;

}
