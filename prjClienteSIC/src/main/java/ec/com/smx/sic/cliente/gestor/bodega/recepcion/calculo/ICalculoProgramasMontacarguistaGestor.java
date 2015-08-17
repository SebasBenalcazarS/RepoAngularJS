/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;


/**
 * @author jdvasquez
 *
 */
public interface ICalculoProgramasMontacarguistaGestor {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoEAN
	 * @return
	 * @throws SICException
	 */
	public ArticuloUnidadManejoDTO obtenerUnidadManejoPorEAN(Integer codigoCompania, String codigoEAN) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerArticuloUnidadManejoCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticuloUnidadManejo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoUsoDTO> obtenerArticuloUnidadManejoUso(Integer codigoCompania, Long codigoArticuloUnidadManejo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerDetalleSeccionPorIdentificador(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador, String valorTipoSeccion) throws SICException;

}
