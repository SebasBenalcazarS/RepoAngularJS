package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * 
 * @author fmunoz
 *
 */
public interface IArticuloValidacionServicio {

	/***
	 * Verifica si es requerido el peso aproximado dependiento del control de costo
	 * @param tipoControlCosto
	 * @return
	 */
	public Boolean esRequeridoPesoAproximado(String tipoControlCosto);
	
	/**
	 * Verifica si los c�digos de barras de las unidades de manejo est�n en otros art�culos actualmente
	 * @param idArticulo
	 * @param unidades
	 * @return
	 */
	public Collection<ArticuloUnidadManejoDTO> validarUnicidadEAN14(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> unidades)throws SICException;
	/**
	 * 
	 * @param sca
	 * @return
	 */
	public void validarPasoCreacion(SegmentoCreacionArticuloDTO sca, ArticuloVO articuloVO);
	
	public void validarRangoSecuenciaCodigoInterno(ArticuloDTO articuloDTO)throws SICException;
	
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
