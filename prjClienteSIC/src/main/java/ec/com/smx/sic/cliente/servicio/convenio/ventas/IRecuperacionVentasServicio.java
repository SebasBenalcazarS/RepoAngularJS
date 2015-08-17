package ec.com.smx.sic.cliente.servicio.convenio.ventas;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;

import ec.com.smx.sic.cliente.mdl.dto.ConfiguracionDatosProcesadosDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosAcumuladosDTO;
import ec.com.smx.sic.cliente.mdl.dto.DefinicionConfiguracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecuperacionVentasLoyaltyDTO;

/**
 * @author srodriguez 2014-11-29
 */
public interface IRecuperacionVentasServicio {

	/**
	 * @author srodriguez
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param codigoCompania
	 * @param userId
	 * @param numeroElementosSeleccion
	 */
	@Deprecated
	void transRecuperarVentasLoyalty(Timestamp fechaInicial, Timestamp fechaFinal, Integer codigoCompania, String userId, Integer numeroElementosSeleccion);

	/**
	 * @author srodriguez
	 * @param datosAcumuladosDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void guardarVentasLoyalty(DatosAcumuladosDTO datosAcumuladosDTO, Integer codigoCompania, String userId);

	/**
	 * @author srodriguez
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return Integer
	 */
	Integer findNumeroRegistroVentas(Timestamp fechaInicial, Timestamp fechaFinal);

	/**
	 * @author srodriguez
	 * @param codigoCampania
	 * @param codigoPromocion
	 * @param codigoArticulo
	 * @return DatosAcumuladosDTO
	 */
	DatosAcumuladosDTO findRecuperarVentasPorArticuloPromocion(String codigoLocalLoyalty, Long codigoCampaniaLoyalty, Long codigoPromocionLoyalty, String codigoArticuloLoyalty);
	
	/**
	 * Metodo para verificar si existe la campania en la tabla gestion precios
	 * @param codigoReferencia
	 * @return
	 */	
	HashMap<String, Long> findRecuperarDatoGestionPrecios(Collection<String> codigoReferencia, String tipoGestionPrecio);
	
	/**
	 * Obtiene codigo de articulo a traves de codigo de barras
	 * @param codigoReferencia
	 * @return
	 */
	HashMap<String, String> findRecuperarDatoArticulos(Collection<String> codigoBarrasLoyalty);
	
	/**
	 * Obtiene codigo de local a traves del codigo referencia
	 * @param codigoReferencia
	 * @return
	 */
	HashMap<String, Integer> findRecuperarDatoLocales(String codigoLocalLoyalty);

	/**
	 * @author srodriguez
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param registroInicial
	 * @param registroFinal
	 * @return Collection<VistaRecuperacionVentasLoyaltyDTO>
	 */
	Collection<VistaRecuperacionVentasLoyaltyDTO> findRecuperarVentasLoyalty(Timestamp fechaInicial, Timestamp fechaFinal, Integer registroInicial, Integer registroFinal);

	/**
	 * @param datosAcumuladosDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void transRegistrarRecuperacionVentas(DatosAcumuladosDTO datosAcumuladosDTO, Integer codigoCompania, String userId);

	/**
	 * @author srodriguez
	 * @param configuracionDatosProcesadosDTO
	 * @param datosAcumuladosCol
	 * @param definicionConfiguracionDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void transRegistrarRecuperacionVentasCol(ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO, Collection<DatosAcumuladosDTO> datosAcumuladosCol, DefinicionConfiguracionDTO definicionConfiguracionDTO, Integer codigoCompania, String userId);

	/**
	 * Metodo de IRecuperacionVentasServicio.java, utilizado para srodriguez
	 * 5/2/2015
	 * 
	 * @param configuracionDatosProcesadosDTO
	 * @param datosAcumuladosCol
	 * @param definicionConfiguracionDTO
	 * @param codigoCompania
	 * @param userId
	 *            void
	 */
	public void transRegistrarRecuperacionVentasCol(Collection<DatosAcumuladosDTO> datosAcumuladosCol, DefinicionConfiguracionDTO definicionConfiguracionDTO, Integer codigoCompania, String userId);
}
