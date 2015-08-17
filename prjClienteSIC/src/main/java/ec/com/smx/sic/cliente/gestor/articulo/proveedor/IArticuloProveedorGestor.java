/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.proveedor;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author fmunoz
 *
 */
public interface IArticuloProveedorGestor {

	/**
	 * Realiza el registro de una colecci�n de datos art�culo-proveedor
	 * @param artPros
	 */
	public void registrarArticuloProveedor(Collection<ArticuloProveedorDTO> artPros) throws SICException;
	
	/**
	 * Realiza el registro de una condicion comercial para un art�culo (ARTICULO-PROVEEDOR-CLASIFICACION)
	 * @param articuloVO
	 */
	public void registrarArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @param respaldoArticulo
	 * @param esCreacionArticulo
	 */
	public void registrarArticuloProveedorDesdeArticulo(ArticuloVO articuloVO, Boolean esCreacionArticulo) throws SICException;

	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException;

	public Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException;

	public void registrarArticuloProveedorImpuesto(ArticuloProveedorDTO articuloProveedorDTO,Boolean esCreacion) throws SICException;
	
	public Boolean verificarArticuloImportado(String codigoArticulo , Integer codigoCompania) throws SICException;
	
	/**
	 * Permite obtener el ArtiuloImortacion de un determinado art\u00EDculo y proveedor
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	
	/**
	 * Permite verificar si un Articulo contiene c\u00F3digo disney
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;

	/**
	 * Metodo que permite obtener las clasificaciones de un proveedor en las que se debe visualizar los precios en B2B
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerClasificacionesConPreciosB2B(Integer codigoCompania, String codigoProveedor) throws SICException;
}
