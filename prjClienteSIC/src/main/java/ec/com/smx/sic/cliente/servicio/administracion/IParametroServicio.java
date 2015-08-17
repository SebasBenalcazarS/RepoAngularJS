/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.administracion;

import java.util.Collection;

import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.sic.cliente.common.beans.DatosParametro;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * @author Mario Braganza
 *
 */
public interface IParametroServicio {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoParametro
	 * @param codigoSistema
	 * @return
	 * @throws SICException
	 */
	ParametroDTO obtenerParametro(Integer codigoCompania, String codigoParametro, String codigoSistema) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 * @throws SICException
	 */
	ParametroDTO obtenerParametro(Integer codigoCompania, String codigoParametro) throws SICException;
	
	/**
	 * Obtiene un parámetro basado en el id del sistema SIC
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 * @throws SICException
	 */
	ParametroDTO obtenerParametroSIC(Integer codigoCompania, String codigoParametro) throws SICException;
	
	/**
	 * Obtiene la lista de sistemas desde la tabla de parámetros del SIC
	 * @return
	 * @throws SICException
	 */
	Collection<SystemDto> obtenerSistemasParametro(Integer codigoCompania) throws SICException;
	
	
	/**
	 * 
	 * @param <T>
	 * @param codigoCompania
	 * @param codigoParametro
	 * @param separadorListaValores
	 * @param tipoDatoListaValores
	 * @param codigoSistema
	 * @return
	 * @throws SICException
	 */
	<T> DatosParametro<T> obtenerParametro(Integer codigoCompania, 
			String codigoParametro,
			String separadorListaValores,
			Class<T> tipoDatoListaValores,
			String codigoSistema) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param grupoSistema
	 * @param codigoParametros
	 * @return
	 * @throws SICException
	 */
	Collection<ParametroDTO> obtenerParametros(Integer codigoCompania, String grupoSistema, String... codigoParametros)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoParametros
	 * @return
	 * @throws SICException
	 */
	Collection<ParametroDTO> obtenerParametrosSIC(Integer codigoCompania, String... codigoParametros)throws SICException;
}
