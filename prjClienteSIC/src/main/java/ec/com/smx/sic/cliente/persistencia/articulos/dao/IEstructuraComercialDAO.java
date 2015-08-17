/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;

/**
 * @author gnolivos
 *
 */
public interface IEstructuraComercialDAO {
	
	/**
	 * @param codigoFuncionario
	 * @param codigoProveedor
	 * @param codigoBoega
	 * @param codigoTipoClasificacion
	 * @throws SICException
	 */
	ClasificacionDTO obtenerClasificacionesLineaComercial(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBoega, String codigoClasificacion, String codigoDepartamento, Long codigoLineaComercial) throws SICException;

}
