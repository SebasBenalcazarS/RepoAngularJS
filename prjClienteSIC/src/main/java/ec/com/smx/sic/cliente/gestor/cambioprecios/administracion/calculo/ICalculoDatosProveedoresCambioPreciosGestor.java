/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosProveedoresCambioPreciosGestor extends Serializable {

	/**
	 * @param articuloProveedor
	 * @param precioPVP
	 * @param precioSMX
	 * @param esProveedorBase
	 * @return
	 * @throws SICException
	 */
	ArticuloProveedorGestionPrecioDTO generarArticuloProveedorGestionPreciosActuales(ArticuloProveedorDTO articuloProveedor, Double precioPVP, Double precioSMX, Boolean esProveedorBase) throws SICException;


	/**
	 * @param codigoCompania
	 * @param articulosGestionPrecios
	 * @throws SICException
	 */
	void validarProveedoresRelacionados(Integer codigoCompania, Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios) throws SICException;
	
	
	/**
	 * @param articuloGestionPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorGestionPrecioDTO> obtenerProveedoresRelacionadosPorArticuloGestion(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;
	

	/**
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorDTO> obtenerProveedoresRelacionadosPorCodigosArticulos(Integer codigoCompania, Set<String> codigosArticulos) throws SICException;


	/**
	 * @param codigoCompania
	 * @param articulosPrecios
	 * @throws SICException
	 */
	void obtenerProveedoresRelacionadosPorArticulosGestion(Integer codigoCompania, Collection<ArticuloGestionPrecioDTO> articulosPrecios) throws SICException;

}
