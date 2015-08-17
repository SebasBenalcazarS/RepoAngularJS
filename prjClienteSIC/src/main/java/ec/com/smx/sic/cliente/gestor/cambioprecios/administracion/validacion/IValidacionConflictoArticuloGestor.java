package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.validacion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface IValidacionConflictoArticuloGestor extends Serializable {


	/**
	 * @param articuloGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	void existeConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	void validarConflictosArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;

	
	/**
	 * Validar los conflictos de los proveedores relacionados a un articulo
	 * 
	 * @param articuloGestionPrecio
	 * @param codigoProveedorRelacionado
	 * @throws SICException
	 */
	void validarConflictosArticuloProveedor(ArticuloGestionPrecioDTO articuloGestionPrecio, String codigoProveedorRelacionado) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	void validarConflictosPrecioDiferenciadoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;

	/**
	 * @param articuloGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @return
	 * @throws SICException
	 */
	TipoConflictoArticulo validarTipoConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @param tipoConflictoArticulo
	 * @return
	 * @throws SICException
	 */
	void validarConflictoArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo) throws SICException;


	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param datosCalculoCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<TipoConflictoArticulo> generarTiposConflictosArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;

}