/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.unidadManejo;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;

/**
 * @author gaortiz
 *
 */
public interface IArticuloUnidadManejoRecepcionJugueteDAO {
	
	/**
	 * Metodo que permite solo actualizar el tipo unidad y el valor de la unidad de manejo
	 * @param articuloUnidadManejoDTO
	 */
	void registrarUnidadMenajo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO);

}
