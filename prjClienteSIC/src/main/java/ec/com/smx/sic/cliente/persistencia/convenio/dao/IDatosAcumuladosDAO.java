package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;
import java.util.HashMap;

import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionDatosProcesadosAcumuladosDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosAcumuladosDTO;


/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface IDatosAcumuladosDAO {
	
	/**
	 * @author srodriguez
	 * @param datosAcumuladosDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void registrarRecuperacionVentas(DatosAcumuladosDTO datosAcumuladosDTO,Integer codigoCompania, String userId);
	
	/**
	 * @author srodriguez
	 * @param codigoCampania
	 * @param codigoPromocion
	 * @param codigoArticulo
	 * @return DatosAcumuladosDTO
	 */
	DatosAcumuladosDTO recuperarVentasPorArticuloPromocion(String codigoLocalLoyalty, Long codigoCampaniaLoyalty, Long codigoPromocionLoyalty, String codigoArticuloLoyalty);
	
	/**
	 * Metodo para verificar si existe la campania en la tabla gestion precios
	 * @param codigoReferencia
	 * @return
	 */
	HashMap<String, Long> recuperarDatoGestionPrecios(Collection<String> codigoReferencia, String tipoGestionPrecio);
	
	/**
	 * Obtiene codigo de articulo a traves de codigo de barras
	 * @param codigoReferencia
	 * @return
	 */
	HashMap<String, String> recuperarDatoArticulos(Collection<String> codigoBarrasLoyalty);
	
	
	/**
	 * Obtiene codigo de local a traves del codigo referencia
	 * @param codigoReferencia
	 * @return
	 */	
	HashMap<String, Integer> recuperarDatoLocales(String codigoLocalLoyalty);
	
	/**
	 * @author srodriguez
	 * @return Object
	 */
	Object recuperarUltimaFechaRegistrada ();
	
	/**
	 * Metodo de IDatosAcumuladosDAO.java, utilizado para registrar la tabla de rompimiento
	 * srodriguez
	 * 7/2/2015
	 * @param configuracionDatosProcesadosAcumuladosCol
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDatosAcumulados
	 * void
	 */
	public void registrarConfiguracionDatosProcesadosAcumulados(Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol,Integer codigoCompania, String userId, Long codigoDatosAcumulados);

}
