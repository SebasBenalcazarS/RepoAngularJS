package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.List;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;

public interface IArticuloProveedorDAO {

	public abstract Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol, Integer codigoCompania);

	public abstract Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol, Integer codigoCompania);

	/**
	 * @param articuloProveedorID	- identificador del art&iacute;culo proveedor
	 * @param estado				- valor del campe estado
	 * @param campoEstado			- Nombre del campo que hace referencia al estado
	 * @param clase					- Clase de la entidad que se desea actualizar
	 */
	public void actualizarEstado(ArticuloProveedorDTO ap, String valorEstado, String campoEstado, String campoArticulo, Class<? extends SearchDTO> clase)throws SICException;

	/**
	 * 
	 * @param apActual
	 * @param nombreCampoProveedor
	 * @param codigoProveedorAnterior
	 * @param clase
	 * @throws SICException
	 */
	public abstract void actualizarCodigoProveedorEnRelaciones(ArticuloProveedorDTO apActual, String nombreCampoProveedor, String codigoProveedorAnterior, Class<? extends SearchDTO> clase) throws SICException;
	
	/**
	 * @author bcueva
	 * Permite obtener los c\u00F3digos de los Proveedores a partir de el c\u00F3digo de Barras de un Articulo
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoBarras C\u00F3digo de barras del Art\u00EDculo a buscar
	 * @return
	 * @throws SICException
	 */
	List<Integer> obtenerCodigosProveedorPorCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Boolean verificarArticuloImportado(String codigoArticulo , Integer codigoCompania) throws SICException;
	
	/**
	 * Permite obtener el Articulo Importacion de un Proveedor
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	
	/**
	 * Permite verificar si un art\u00EDculo tiene c\u00F3digo disney
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	
	/**
	 *  Metodo que retorna la relacion entre articulo proveedor con los codigos de articulo(El dto de articulo viene cargado)
	 */
	Collection<ArticuloProveedorDTO> obtenerArticuloProveedorPorCodigoArticulo(Integer codigoCompania,Collection<String> codigoArticuloCol);

	ArticuloProveedorDTO obtenerArticuloProveedor(Integer codigoCompania, String codigoBarras, String codigoReferencia, String codigoProveedor, String codigoEstado);
	
	
	/**
	 * @author rali
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @return Obtiene la cantidad de proveedores de un articulo
	 * @throws SICException
	 */
	public long cantidadProveedores(String codigoArticulo,Integer codigoCompania) throws SICException;
	
	/**
	 * busca el descuento articulo proveedor por en codigoProveedor, codigoArticulo, codigoTipoDescuento
	 * @param descuentoProveedorArticuloDTO
	 * @return
	 */
	DescuentoProveedorArticuloDTO obtenerDescuentoArticuloProveedor(DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO);

	void actualizarEstadoDesArtPro(ArticuloProveedorDTO ap, String valorEstado) throws SICException;
}