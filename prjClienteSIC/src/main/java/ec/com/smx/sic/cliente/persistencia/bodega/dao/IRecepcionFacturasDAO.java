package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionFacturaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;


public interface IRecepcionFacturasDAO {
	
	/**
	 * <b> Contar el numero de facturas que tiene la recepcion<b>
	 * <p>
	 * [Author: lguaman, Date: 25/11/2014]
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @param codigosEntrega
	 * @return
	 */
	Integer contarFacturasRecepcion(Integer codigoCompania, Long codigoRecepcionProveedor, Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * <b>  Guardar las facturas en la recepcion del proveedor<b>
	 * <p>
	 * [Author: lguaman, Date: 11/11/2014]
	 * @param recepcionProveedorFacturaDTO
	 * @return
	 */
	void asignarFacturasRecepcion(RecepcionProveedorFacturaDTO recepcionProveedorFacturaDTO);
	
	/**
	 * <b> Obtener facturas digitales en la recepcion<b>
	 * <p>
	 * [Author: lguaman, Date: 10/11/2014]
	 * @param codigosEntregaFacturaDigital
	 * @param codigoCompania
	 * @return
	 */
	Collection<Long> obtenerListaFacturaDigitalRecepcion(Collection<Long> codigosEntregaFacturaDigital, Integer codigoCompania) throws SICException;
	
	/**
	 * Elimina la factura que esta asociada a la recepcion
	 *
	 * @param recepcion
	 * @param codigoFactura
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void removerFacturaRecepcion(RecepcionProveedorDTO recepcion, Long codigoFactura) throws SICException;
	
	/**
	 * Obtiene un lista de facturas relacionadas con la recepcion
	 *
	 * @param codigosRecepcion
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<RecepcionProveedorFacturaDTO> buscarFacturasRecepcion(Collection<Long> codigosRecepcion) throws SICException;

	/**
	 * @param numeroAutorizacion
	 * @param codigoEmpresaProveedor
	 * @param codigoPersona
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<VistaAutorizacionFacturaProveedorDTO>  obtenerNumeroAutorizacion(String numeroAutorizacion,Long codigoEmpresaProveedor, Long codigoPersona, Integer codigoCompania) throws SICException;
	
	/**
	 * Cuenta el numero de facturas de una recepcion de un proveedor
	 * 
	 * @param vistaProcesoLogisticoDTO Una recepcion de un proveedor
	 * @return cantidad de facturas de la recepcion
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Integer contarFacturasRecepcionProveedor(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	
	/**
	 * <b> Obtiene los ids de los estados de las facturas en base a los detalles y el codigo de barras de un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 15/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            codigo de la compania para filtrar la busqueda
	 * @param estado
	 *            estado activo
	 * @param codigoBarras
	 *            codigo de barras del articulo
	 * @param codigosOrdenCompraFacturas
	 *            detalles de ordenes de compra asociado a las facturas
	 * @return ids de los estados de las factura
	 */
	List<Long> obtenerIdFacturaCodigoBarras(Integer codigoCompania, String estado, String codigoBarras,
			List<Long> codigosOrdenCompraFacturas);
	
	/**
	 * <b> Actualiza el estado de la tabla RecepcionProveedorFacturaDTO en base al identificador de la tabla y las facturas que posee. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 22/6/2015]
	 * </p>
	 *
	 * @param codigoRecepcionProveedor
	 *            identificador de la tabla
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param userId
	 * 			  identificador del usuario que realiza la transaccion
	 * @param nuevoEstado
	 *            nuevo valor del estado, activo(1) o inactivo(0)
	 * @param codigosFactura
	 *            codigos de las facturas asociadas a la recepcion
	 */ 
	void actualizarEstadoFacturaRecepcion(Long codigoRecepcionProveedor, Integer codigoCompania, String userId, String nuevoEstado,
			Long... codigosFactura);

}