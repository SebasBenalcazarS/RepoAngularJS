package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;

public interface IArticuloLocalPrecioDAO {

	/**
	 * 
	 * @param precioPlanificado
	 * @param estado
	 * @param userId
	 * @throws SICException
	 */
	public abstract void actualizarArticuloLocalPrecio(ArticuloLocalGestionPrecioDTO precioPlanificado, String estado, String userId) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @param estado
	 * @throws SICException
	 */
	public abstract void actualizarEstadoPorArticuloLocal(Integer codigoCompania, Integer codigoLocal, String codigoArticulo, String estado) throws SICException;

	/**
	 * 
	 * @param alp
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp) throws SICException;
	
	public void desactivarTipoPrecio(Integer codigoCompania, String codigoArticulo, String tipoPrecio) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @param codigosLocal
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPrecioDTO> obtenerArticulosLocalPrecio(Integer codigoCompania, Set<String> codigosArticulo, Set<Integer> codigosLocal) throws SICException;
	
	/**
	 * @param articuloLocalPrecio
	 * @return
	 * @throws SICException
	 */
	public void registrarArticuloLocalPrecio(ArticuloLocalPrecioDTO articuloLocalPrecio) throws SICException;
	

	/**
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @param tiposPrecios
	 * @return
	 */
	List<ArticuloPrecioDTO> obtenerDatosArticulosPreciosPorTiposPrecios(Integer codigoCompania, Set<String> codigosArticulo, Set<EnumTipoPrecio> tiposPrecios) throws SICException;

	
	/**
	 * @param articulosPrecio
	 * @throws SICException
	 */
	public void registrarPrecioArticuloPorTipoPrecio(Collection<ArticuloPrecioDTO> articulosPrecio) throws SICException; 
}