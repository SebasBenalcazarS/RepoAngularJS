package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface IArticuloBitacoraCodigoBarrasDAO {

	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException;

	/**
	 * Metodo para consultar los codigos de articulo de los codigos de barras recibidos
	 * @param codigoCompania
	 * @param codigosBarras
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerCodigosArticulosPorCodigosBarras(Integer codigoCompania, Set<String> codigosBarras) throws SICException;
	
	/***
	 * Retorna la cantidad de articulos que comparten el mismo codigo de barras en la bitacora.
	 * @author rachid
	 * @param codigoBarras
	 * @param codigoCompania
	 * @return int cantidad
	 * @throws SICException
	 */
	public long cantidadArticulosRelacionados(String codigoBarras,Integer codigoCompania) throws SICException;
	
	/**
	 * Retorna los articulos asociados a un codigo de barras.
	 * @param compania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException;
	
	void desactivarBitacoraActual(Integer codigoCompania, String codigoarticulo, String userId, Date fecha) throws SICException;

	Long obtenerSecuenciaInternaDisponible(Integer codigoCompania, String valorTipoSecuencia, String userID) throws SICException;

	int desactivarBitacoraCodigoBarras(Integer codigoCompania, Long secuencia, String userId, Date fecha) throws SICException;

	void registrarSecuenciaDisponible(Integer codigoCompania, String codigoArticulo, String userId) throws SICException;

	int desactivarBitacoraCodigoBarrasArticulo(Integer codigoCompania, Long secuencia) throws SICException;
	
	void reutilizarCodigoBarrasEan(String codigoArticulo , Integer codigoCompania , String codigoBarras , String usuarioModificacion)throws SICException;
}