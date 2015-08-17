/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.cambioprecios;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface IPlantillaCambioPreciosServicio extends Serializable{
	
	/**
	 * @param gestionPrecioRegistro
	 * @throws SICException
	 */
	void registrarDatosPlantillas(GestionPrecioDTO gestionPrecioRegistro) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @param codigoPlantilla
	 * @return
	 * @throws SICException
	 */
	GestionPrecioDTO obtenerDatosPlantillasCambioPrecios(Integer codigoCompania, String userId, String codigoFuncionario, 
			String codigoPlantilla, Boolean tipoGestionPrecio) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @return
	 * @throws SICException
	 */
	Collection<GestionPrecioDTO> obtenerPlantillasPrecios(Integer codigoCompania, String userId, String codigoFuncionario, 
			Collection<ISearchTemplate> plantillasBusquedasPlantillas) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoPlantilla
	 * @return
	 * @throws SICException
	 */
	Boolean validarCodigoPlantilla(Integer codigoCompania, String codigoPlantilla) throws SICException;
}
