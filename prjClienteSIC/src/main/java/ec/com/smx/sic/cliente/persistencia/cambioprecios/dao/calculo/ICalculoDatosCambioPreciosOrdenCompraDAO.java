package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.calculo;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArticuloOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Marcelo Hidalgo
 *
 */
public interface ICalculoDatosCambioPreciosOrdenCompraDAO {

	/**
	 * Validacion para consultar los conflictos con las ordenes de compra existentes.
	 * @param codigoCompania
	 * @param fechaInicioVigenciaCosto
	 * @param fechaRetornoVigenciaCosto
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Set<DatosArticuloOrdenCompra> obtenerDatosArticulosOrdenesCompra(Integer codigoCompania, Date fechaInicioVigenciaCosto, Date fechaRetornoVigenciaCosto, String codigoProveedor) throws SICException;
	
	/**
	 * Obtenemos los datos de las ordenes de compra con las cuales existen conflictos.
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @param codigosProveedor
	 * @param codigosOrdenesCompra
	 * @param fechaInicioVigenciaCosto
	 * @param fechaRetornoVigenciaCosto
	 * @return
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerConflictosArticuloGestionOrdenCompra(Integer codigoCompania, Set<String> codigosArticulo, Set<String> codigosProveedor,Set<Long> codigosOrdenesCompra, Date fechaInicioVigenciaCosto, Date fechaRetornoVigenciaCosto) throws SICException;

	/**
	 * Funcion que busca los articulos pertenecientes a la ordenes de compra enviada.
	 * @param codigosOrdenCompra
	 * @param compania
	 * @param tipoConflicto
	 * @throws SICException
	 */
	Collection<DatosArticuloOrdenCompra> obtenerArticulosPorOrdenCompra(Set<Long> codigosOrdenCompra, Integer compania, TipoConflictoArticulo tipoConflicto) throws SICException;
	
	/**
	 * Metodo para obtener los codigos de bodegas que anulan ordenes de compra por defecto
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerCodigosBodegaConAnularOrdenCompraPordefecto(Integer codigoCompania) throws SICException;
	
	/**
	 * metodo que obtiene las ordenes de compra en conflicto con un articulo proveedor
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	public Collection<DatosOrdenCompra> obtenerConflictosConOrdenCompraArticuloProveedor(Integer codigoCompania , String codigoArticulo , String codigoProveedor) throws SICException;
}
