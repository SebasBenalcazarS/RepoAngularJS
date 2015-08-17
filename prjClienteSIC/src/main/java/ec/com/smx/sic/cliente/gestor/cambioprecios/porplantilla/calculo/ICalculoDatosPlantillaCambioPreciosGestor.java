/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.porplantilla.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author gnolivos
 *
 */
public interface ICalculoDatosPlantillaCambioPreciosGestor extends Serializable {

	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @param codigoPlantilla
	 * @return
	 * @throws SICException
	 */
	GestionPrecioDTO obtenerDatosPlantillas(Integer codigoCompania, String userId, String codigoFuncionario, String codigoPlantilla, 
			Boolean tipoGestionPrecio) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @param codigoPlantilla
	 * @return
	 * @throws SICException
	 */
	Collection<GestionPrecioDTO> obtenerPlantillasPrecios(Integer codigoCompania, String userId, String codigoFuncionario, 
			Collection<ISearchTemplate> plantillasBusquedasPlantillas) throws SICException;
}
