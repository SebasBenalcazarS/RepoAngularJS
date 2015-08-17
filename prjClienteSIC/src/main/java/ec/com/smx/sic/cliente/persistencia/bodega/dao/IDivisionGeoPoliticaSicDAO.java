package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author cortiz
 *
 */

public interface IDivisionGeoPoliticaSicDAO {


	/**
	 * Metodo para obtener una coleccion de ciudades de ecuador
	 * @param tipoDivisionGeopol
	 * @return
	 * @throws SICException
	 */
	public Collection<DivisionGeoPoliticaDTO> obtenerDivisionesGeopol(String tipoDivisionGeopol)throws SICException;
}
