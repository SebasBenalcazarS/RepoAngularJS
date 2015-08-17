package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDetalleCalendarioProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloOrdenCompraEstadoDTO;

public interface IEntregaDAO {

	/**
	 * @param hibernateH
	 *            the hibernateH to set
	 */
	public abstract void setHibernateH(IHibernateH<EntregaDTO> hibernateH);

	/**
	 * obtiene las entregas del dia segun el proveedor y codigo de la bodega a
	 * nivel de area de trabajo
	 * 
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @param codigoAreaTrabajoEntrega
	 * @param codigoCompania
	 * @param codigosEntrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract Collection<EntregaDTO> obtenerEntregasDia(String codigoProveedor, Date fechaEntrega, Integer codigoAreaTrabajoEntrega, Integer codigoCompania, Collection<Long> codigosEntrega) throws SICException;

	/**
	 * actualiza el valor de la unidad de manejo
	 * 
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract void actualizarCantidadArticuloUM(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;

	/**
	 * Obtiene las facturas que no estan asignadas a un proceso de recepcion
	 * 
	 * @param entregaDTO
	 *            Una entrega
	 * @return Una coleccion de entregas
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract Collection<EntregaDTO> obtenerEntregasFacturasSinAsignarProceso(EntregaDTO entregaDTO) throws SICException;

	/**
	 * 
	 * @param codigosRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<EntregaDTO> obtenerEntregasProveedorByRecepcionProveedor(Collection<Long> codigosRecepcionProveedor) throws SICException;

	/**
	 * Elimina todos los datos de una entrega cambiando el estado a inactivo
	 * 
	 * @param codigoEntrega
	 *            EntregaDTO entrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract void eliminarEntrega(EntregaDTO entregaDTO) throws SICException;

	/**
	 * Busca los tipos de pedido de una entrega
	 * 
	 * @param codigoEntrega
	 *            Codigo entrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract Collection<CatalogoValorDTO> obtenerTiposPedidoEntrega(Collection<Long> codigosEntrega) throws SICException;

	/**
	 * Obtiene los tipos de pedido de una entrega por bodega, subbodega, tipo
	 * pedido: [codigoAreaTrabajoBodega, codigoSubBodega, codigoTipoRecepcion,
	 * valorTipoRecepcion]
	 * 
	 * @param codigoEntrega
	 *            Id de la entrega
	 * @return Una coleccion de Object[]
	 * @throws SICException
	 */
	public Collection<Object[]> obtenerTiposPedidoSubbodegaEntrega(Long codigoEntrega) throws SICException;

	/**
	 * Obtiene los tipos de pedido de una entrega por bodega, subbodega, tipo
	 * pedido: [codigoAreaTrabajoBodega, codigoSubBodega, codigoTipoRecepcion,
	 * valorTipoRecepcion]
	 * 
	 * @param codigosEntrega
	 *            ID's de la entrega
	 * @return Una coleccion de Object[]
	 * @throws SICException
	 */
	public Collection<Object[]> obtenerTiposPedidoSubbodegaEntrega(Collection<Long> codigosEntrega) throws SICException;

	/**
	 * Obtiene las subbodegas relacionadas a la entrega
	 * 
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerSubBodegasEntrega(Long codigoEntrega) throws SICException;

	/**
	 * Obtiene las tarea de la entrega
	 * 
	 * @param codigosEntrega
	 *            coleccion Codigos de las entregas
	 * @return Coleccion de tareas
	 * @throws SICException
	 *             Excepcion en caso de producirse un error
	 */
	public Collection<TareaDTO> obtenerTareasEntrega(Collection<Long> codigosEntrega) throws SICException;

	/**
	 * Elimina los detalles de las tareas de una entrega
	 * 
	 * @param codigosDetalleTarea
	 *            Codigos de detalle tarea
	 * @throws SICException
	 *             Excepcion en caso de producirse un error
	 */
	public void eliminarDetallesTareaEntrega(Collection<Long> codigosDetalleTarea) throws SICException;

	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<Object[]> obtenerMonitorRecepcionAbastos() throws SICException;

	/**
	 * Elimina todos los datos de una entrega cambiando el estado a inactivo
	 * 
	 * @param codigoEntrega
	 *            Codigo entrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public abstract void actualizarValidacionAndenesEntrega(Long codigoEntrega, Integer validacionAndenes) throws SICException;

	/**
	 * Obtiene la cantidad de detalles de Tarea por Entrega
	 * 
	 * @param codigosEntrega
	 *            Lista de Codigos de entrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public Collection<Object[]> obtenerCantidadAndenesPorEntrega(Collection<Long> codigosEntrega) throws SICException;

	/**
	 * Obtiene las horas de inicio de las entregas de los proveedores de una
	 * fecha determinada
	 * 
	 * @param fechaEntrega
	 *            Fecha de la entrega
	 * @return Una coleccion con las horas de entrega
	 * @throws SICException
	 *             Excepcion en caso de prodicirse un error
	 */
	public Collection<Time> obtenerHorasEntregasPorFecha(Date fechaEntrega) throws SICException;

	/**
	 * 
	 * @param entregaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaArticuloOrdenCompraEstadoDTO> obtenerArticulosOrdenCompraEstadoPEN(EntregaDTO entregaDTO) throws SICException;

	/**
	 * 
	 * @param vistaArticuloOrdenCompraEstadoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaArticuloOrdenCompraEstadoDTO> obtenerArticulosOrdenCompraEstadoENV(Collection<VistaArticuloOrdenCompraEstadoDTO> vistaArticuloOrdenCompraEstadoDTOs) throws SICException;

	/**
	 * Obtiene la autorizaci&oacute;n de una entrega
	 * 
	 * @param entregaDTO
	 * @param estadosEntregaAutorizacion
	 * @param estadosAutorizacion
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDetalleCalendarioProveedorDTO> obtenerCalendarioAprobadoEntrega(EntregaDTO entregaDTO, Collection<String> estadosEntregaAutorizacion, Collection<String> estadosAutorizacion, boolean condicion) throws SICException;
	
	/**
	 * 
	 * @param codigoEntrega
	 * @return Collection<Object>
	 */
	public Collection<Object> consultarFechaCaducidadByEntrega(Long codigoEntrega)throws SICException;
	
	/**
	 * Actualizar campo integrado de las entregas que se procesaron
	 * exitosamente en el SIC
	 * @param colIdEntrega
	 * @param valorIntegrado
	 * @param codigoCompania
	 * @throws SICException
	 * @author osaransig
	 */
	void actualizarCampoIntegradoEntregas(Collection<Long> colIdEntrega, String valorIntegrado, Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param entregaPlantilla
	 * @param colCodigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaDTO> obtenerEntregasFacturaDigital(EntregaDTO entregaPlantilla, Collection<String> colCodigoProveedor, Integer catalogoTipoTipoPedido, String catalogoValorTipoPedido) throws SICException;
	
	/**
	 * Obtener los codigos de los proveedores que tiene una entrega configurada por FDI
	 * @param entregaPlantilla
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerProveedorFacturaDigital(EntregaDTO entregaPlantilla) throws SICException;
	
	/**
	 * Obtiene una entrega con todos sus estados activos.
	 * @param entregaDTO
	 * @return Collection<EntregaDTO>
	 * @throws SICException Excepcion
	 * */
	public EntregaDTO consultarEntregasConEntregaEstado(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * Obtiene las entregas posteriores a la fecha actual
	 * @param codigoProveedor
	 * @param fechaActual
	 * @param codigoAreaTrabajoEntrega
	 * @param codigoCompania
	 * @param codigosEntrega
	 * @return
	 * @throws SICException
	 */
	public Collection<EntregaDTO> obtenerEntregasPosteriores(String codigoProveedor, Date fechaActual, Integer codigoAreaTrabajoEntrega, Integer codigoCompania) throws SICException;
	
	/**
	 * Obtiene el numero de andenes asignados desde el B2B
	 * @param codigoCompania
	 * @param codigoEntrega
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerAndenesEntregaB2B(Integer codigoCompania, Long codigoEntrega) throws SICException;
}