package ec.com.smx.sic.cliente.gestor.convenio.ventas;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;

import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionDatosProcesadosDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosAcumuladosDTO;
import ec.com.smx.sic.cliente.mdl.dto.DefinicionConfiguracionDTO;

/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface IDatosAcumuladosGestor {

	/**
	 * @author srodriguez
	 * @param datosAcumuladosDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void registrarRecuperacionVentas(DatosAcumuladosDTO datosAcumuladosDTO, Integer codigoCompania, String userId);
	
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
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param codigoCompania
	 * @param userId
	 * @param numeroElementosSeleccion
	 */
	@Deprecated
	void procesoRegistrarRecuperacionVentas(Timestamp fechaInicial,Timestamp fechaFinal,Integer codigoCompania, String userId,Integer numeroElementosSeleccion);
	
	/**
	 * @author srodriguez
	 * @param configuracionDatosProcesadosDTO
	 * @param datosAcumuladosCol
	 * @param definicionConfiguracionDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void registrarRecuperacionVentasCol(ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO,Collection<DatosAcumuladosDTO> datosAcumuladosCol, DefinicionConfiguracionDTO definicionConfiguracionDTO,Integer codigoCompania, String userId);
	
	/**
	 * Metodo de IDatosAcumuladosGestor.java, utilizado para
	 * srodriguez
	 * 5/2/2015
	 * @param datosAcumuladosCol
	 * @param definicionConfiguracionDTO
	 * @param codigoCompania
	 * @param userId
	 * void
	 */
	void registrarRecuperacionVentasCol(Collection<DatosAcumuladosDTO> datosAcumuladosCol, DefinicionConfiguracionDTO definicionConfiguracionDTO,Integer codigoCompania, String userId);
}
