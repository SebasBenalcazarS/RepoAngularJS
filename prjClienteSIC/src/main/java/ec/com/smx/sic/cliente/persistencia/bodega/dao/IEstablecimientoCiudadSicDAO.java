package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author cortiz
 *
 */
public interface IEstablecimientoCiudadSicDAO {

	/**
	 * Metodo para saber si existe o no un establecimiento ciudad
	 * @param codigoCiudad
	 * @param codigoEstablecimiento
	 * @return
	 * @throws SICException
	 */
	public Boolean existeEstablecimientoCiudad(String codigoCiudad , Integer codigoEstablecimiento, Integer codigoCompania)throws SICException;
	/**
	 * obtiene un establecimiento ciudad segun el id
	 * @param codigoCiudad
	 * @param codigoEstablecimiento
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public EstablecimientoCiudadDTO obtenerEstablecimientoCiudad(String codigoCiudad , Integer codigoEstablecimiento, Integer codigoCompania)throws SICException;
	/**
	 * Actualiza el estado del establecimiento ciudad
	 * @param codigoCiudad
	 * @param codigoEstablecimiento
	 * @param codigoCompania
	 * @param estado
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarEstablecimientoCiudad(String codigoCiudad , Integer codigoEstablecimiento, Integer codigoCompania, String estado, String userID)throws SICException;
}
