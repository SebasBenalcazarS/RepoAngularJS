package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.LinkedHashMap;

import ec.com.smx.sic.cliente.mdl.nopersistente.ContenedorEstadoPalletRutaTrasient;

/**
 * 
 * @author cherrera
 *
 */

public interface IRecepcionRecipientesDAO {
	
	/**
	 * @param parametrosConsulta
	 * @return contenedorEstadoRutaTrasient
	 */
	public ContenedorEstadoPalletRutaTrasient obtenerPalletRuta(LinkedHashMap<String, Object> parametrosConsulta);
	
	/**
	 * @param parametrosConsulta
	 * @return
	 */
	public Integer contarNumeroCajas(LinkedHashMap<String, Object> parametrosConsulta);
	
	/**
	 * @param parametrosConsulta
	 * @return
	 */
	public Integer contarNumeroPallets(LinkedHashMap<String, Object> parametrosConsulta);
}
