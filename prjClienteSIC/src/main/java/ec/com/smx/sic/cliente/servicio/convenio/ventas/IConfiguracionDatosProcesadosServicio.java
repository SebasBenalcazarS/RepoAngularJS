package ec.com.smx.sic.cliente.servicio.convenio.ventas;

import java.sql.Timestamp;
import java.util.HashMap;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionDatosProcesadosDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface IConfiguracionDatosProcesadosServicio {

	/**
	 * @author srodriguez
	 * @param codigoCompania
	 * @param codigoConfiguracion
	 * @return
	 */
	ConfiguracionDatosProcesadosDTO findConfiguracionDatosProcesados(Integer codigoCompania, Long codigoConfiguracion);

	/**
	 * @author srodriguez
	 * @param configuracionDatosProcesadosDTO
	 * @param companyId
	 * @param userId
	 */
	void transRegistrarConfiguracionDatosProcesados(ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO, Integer companyId, String userId);

	/**
	 * @author srodriguez
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	ConfiguracionDatosProcesadosDTO findConfiguracionDatosProcesadosByFechas(Timestamp fechaInicio, Timestamp fechaFin);
	
	/**
	 * Recupera el total de registros procesados y guardados por dia
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	Integer findTotalRegistroGuardadosLote(Integer codigoCompania, Long codigoConfiguracion);
	
	/**
	 * Retorna todo el objeto parametro
	 * @param parametroDTO
	 * @return
	 */
	ParametroDTO findObtenerParametroDTO(ParametroDTO parametroDTO);
	
	/**
	 * Obtiene la coleccion de lotes por codigo
	 * @param codigoCompania
	 * @param codigoConfiguracion
	 * @return
	 * @throws SICException
	 */
	HashMap<Integer, String> findDatosProcesadosByCodigoConfiguracion(Integer codigoCompania, Long codigoConfiguracion);
}