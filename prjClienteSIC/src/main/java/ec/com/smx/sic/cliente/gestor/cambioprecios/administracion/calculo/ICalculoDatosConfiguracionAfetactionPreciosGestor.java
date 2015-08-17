/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoAfectacionCalculoPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GrupoAfectacionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoAfectacionPrecioDTO;

/**
 * 
 * @author cjara
 *
 */
public interface ICalculoDatosConfiguracionAfetactionPreciosGestor extends Serializable {
	/**
	 * @author cjara
	 * 
	 * @param codigoCompania
	 * @param codigoTipoAfectacion
	 * @return
	 * @throws SICException
	 */
	TipoAfectacionPrecioDTO obtenerTipoAfectacionPrecioDTO(Integer codigoCompania, Integer codigoTipoAfectacion) throws SICException;
	

	/**
	 * @param codigoCompania
	 * @param tiposAfectacionNoVisualizar
	 * @return
	 * @throws SICException
	 */
	Collection<TipoAfectacionPrecioDTO> obtenerTiposAfectacionPrecioCol(Integer codigoCompania, Set<TipoAfectacionCalculoPrecio> tiposAfectacionNoVisualizar) throws SICException;
	
	/**
	 * @author cjara
	 * 
	 * @param grupoAfectacionPrecio
	 * @return
	 * @throws SICException
	 */
	GrupoAfectacionPrecioDTO obtenerValoresGrupoAfectacionPrecio(Long codigoGrupoAfectacionPrecio, Integer codigoCompania) throws SICException;
}
