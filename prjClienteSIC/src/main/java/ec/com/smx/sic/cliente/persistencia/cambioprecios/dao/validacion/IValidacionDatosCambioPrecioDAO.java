package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.validacion;

import java.io.Serializable;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraValorCostoDTO;

/**
 * @author Luis Yacchirema
 *
 */

public interface IValidacionDatosCambioPrecioDAO extends Serializable {
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Boolean existenCambiosPreciosResolverPorFuncionario(Integer codigoCompania, String codigoFuncionario) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param dynamicCriteriaRestriction
	 * @return
	 * @throws SICException
	 */
	Boolean validarMaximoResultadoBusquedaArticulos(Integer codigoCompania, DynamicCriteriaRestriction dynamicCriteriaRestriction) throws SICException;
	
	/**
	 * @param bitacoraArticuloGestionPrecio
	 * @return TRUE si existe
	 * @throws SICException
	 */
	Boolean existenBitacorasArticulosGestion(BitacoraArticuloGestionPrecioDTO bitacoraArticuloGestionPrecio) throws SICException;
	
	/**
	 * @param bitacoraValorCosto
	 * @return TRUE si existe
	 * @throws SICException
	 */
	Boolean existenBitacorasValorCosto(BitacoraValorCostoDTO bitacoraValorCosto) throws SICException;
}
