package ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IValidacionUnidadManejoGestor {

	/**
	 * Verifica si los c�digos de barras de las unidades de manejo est�n en otros art�culos actualmente
	 * @param idArticulo
	 * @param unidades
	 * @return
	 */
	public abstract Collection<ArticuloUnidadManejoDTO> validarUnicidadEAN14(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> unidadesManejo) throws SICException;
	
	/**
	 * <b> Valida que el codigo EAN que se pasa como parametro no este asociado a una unidad de manejo existente. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/10/2014]
	 * </p>
	 * 
	 * @param codigoEAN
	 *            codigo EAN a validar (obligatorio)
	 * @param codigoCompania
	 *            codigo de compania para filtrar la busqueda (puede ser nulo)
	 * @throws SICException
	 *             excepcion lanzada en caso de no cumplir la validacion
	 */ 
	void validarCondigoEANunico(String codigoEAN, Integer codigoCompania) throws SICException;

}