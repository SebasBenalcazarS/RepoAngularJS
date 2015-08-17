package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;


/**
 * 
 * @author acaiza
 * 
 */
public interface IAlmacenamientoEntregasProveedorGestor {
 	
	/**
 	 * 
 	 * @param entregaVO
 	 * @throws SICException
 	 */
 	public EntregaDTO crearEntregaPlanificacionRecepcionProveedor(EntregaVO entregaVO) throws SICException;
	
	/**
 	 * 
 	 * @param areaTrabajoDTOs
 	 * @param horaCalendarioDTO
 	 * @param ordenCompraEstadoDTOs
 	 * @param recepcionProveedorDTO
 	 * @return
 	 * @throws SICException
 	 */
 	public Collection<EntregaDTO> crearEntregasOrdenCompraPlanificacion(Collection<AreaTrabajoDTO> listaAreaTrabajo, HoraCalendarioDTO horaCalendarioDTO, Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
 	 * 
 	 * @param articuloUnidadManejoDTO
 	 * @throws SICException
 	 */
 	public void actualizarCantidadArticuloUM(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
 	 * 
 	 * @param entregaVO
 	 * @return
 	 * @throws SICException
 	 */
 	public EntregaVO crearEntregaProveedor(EntregaVO entregaVO) throws SICException;
 	
 	/**
 	 * Reconfigurar entrega 
 	 * 
 	 * @param entregaVO
 	 * @param mapEntregaVO
 	 * @return
 	 * @throws SICException
 	 */
 	public Collection<EntregaVO> reConfigurarEntregaProveedor(EntregaDTO entregaPrincipal, Collection<EntregaVO> entregaVOs) throws SICException;
 	
 	/**
 	 * Crea la entrega, el primer estado de la entrega, el calendario de una entrega para un proveedor
 	 * 
 	 * @param entregaVO
 	 * @return
 	 * @throws SICException
 	 */
 	public EntregaDTO crearCabeceraEntregaProveedor(EntregaVO entregaVO) throws SICException;
 	
 	/**
 	 * 
 	 * @param ordenCompraEstadoDTOs
 	 * @param entregaDTO
 	 * @return
 	 * @throws SICException
 	 */
 	public Collection<EntregaVO> crearEntregaProveedorPorOrdenCompraEstado(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
 	
 	/**
 	 * Eliminia los datos de una entrega y inactiva todas las ordenes de compra estado que intervienen en la entrega
 	 * 
 	 * @param entregaDTO Un EntregaDTO
 	 * @throws SICException Excepcion en caso de producirse un error en el proceso
 	 */
 	public void eliminarEntregaProveedor(EntregaDTO entregaDTO) throws SICException;
 	
 	/**
 	 * 
 	 * @param entregaVO
 	 * @param ordenCompraDetalleEstadoDTO
 	 * @throws SICException
 	 */
 	public void eliminarItemEntregaProveedor(EntregaDTO entregaDTO, OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) throws SICException;
 	
 	/**
 	 * Actualiza los articulos de una entrega de la factura digital. La coleccion ordenCompraDetalleEstadoDTOs tiene los nuevos articulos de la entrega, 
 	 * Cada articulo representado por un OrdenCompraDetalleEstadoDTO En el dynamicProperty.cantidadOrdenCompra se debe poner la nueva cantidad del articulo
 	 * para calcular la cantidad de la orden compra con la cantidad del articulo de las facturas de la entrega
 	 * 
 	 * @param entregaDTO Datos de la entrega
 	 * @param ordenCompraDetalleEstadoDTOs Articulos de la entrega. 
 	 * @return VistaEntregaFacturaDigitalDTO Un VistaEntregaFacturaDigitalDTO con las articulos y facturas actualizadas
 	 * @throws SICException Excepcion en caso de producirse un error en el proceso
 	 */
 	public VistaEntregaFacturaDigitalDTO actualizarEntregaProveedor(EntregaDTO entregaDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
 	/**
 	 * 
 	 * @param entregaVO
 	 * @throws SICException
 	 */
 	public void agregarItemsEntregaProveedor(EntregaVO entregaVO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) throws SICException;
	
 	/**
 	 * 
 	 * @param entregaVO
 	 * @param ordenCompraDetalleEstadoDTOs
 	 */
 	public void eliminarItemsEntregaProveedor(EntregaDTO entregaDTO, Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs);
 	
 	/**
 	 * 
 	 * @param entregaDTO
 	 */
 	public void cambiarEstadoEntregaProveedorParaRecepcion(Collection<EntregaDTO> entregasDTO, RecepcionProveedorDTO recepcion) throws SICException;
 	
 	/**
 	 * Cambia el estado de una entrega mediante la configuracion de la maquina de estados de una entrega
 	 * 
 	 * @param entregaDTO Una Entrega
 	 * @param accionEntregaCatVal Una accion de la maquina de estado de las entregas
 	 */
 	public void cambiarEstadoEntregaProveedor(EntregaDTO entregaDTO, CatalogoValorDTO accionEntregaCatVal)throws SICException;
 	
 	/**
 	 * Guarda el calendario de un entrega que se crea con autorizaciones
 	 * @param entregaDTO
 	 * @param vistaCalendarioEntregaBodegaDTO
 	 * @param autorizacionDTO
 	 * @throws SICException Excepcion en caso de producirse un error
 	 */
 	public void guardarAutorizacionesAndenesEntrega(EntregaDTO entregaDTO, VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO) throws SICException;
 	
 	/**
 	 * Rechaza los articulos de la entrega cuando el proveedor no acepta los costos del articulo con los de la corporacion
 	 * 
 	 * @param entregaDTO Un EntregaDTO
 	 * @param facturaDigitalESTs Un Collection FacturaDigitalEST con los articulos agrupados que se va rechazar 
 	 * @return Un Collection de DetalleFacturaEstadoDTO con los articulos que faltan por rechazar
 	 * @throws SICException Excepcion en caso de producirse un error
 	 */
 	public Collection<DetalleFacturaEstadoDTO> recharzarArticulosEntrega(EntregaDTO entregaDTO, Collection<FacturaDigitalEST> facturaDigitalESTs) throws SICException;
 	
 	/**
	 * Actualiza la fecha Calendario de una Entrega Normal Configurada.
	 * 
	 * @param entregaVO
	 */
	public void actualizarEntregaNormalConfigurada(EntregaVO entregaVO) throws SICException;
	
	/**
	 * 
	 * @param codigoEntrega
	 * @return Collection<Object>
	 */
	public Collection<Object> consultarFechaCaducidadByEntrega(Long codigoEntrega)throws SICException;

	/**
	 * 
	 * @param userId
	 * @param codigoEntrega
	 */
	public void cambiarEstadoEntregaConfirmadaARecibida(String userId, Collection<Long> codigoEntregaS, String accionCatalogoValor)throws SICException;
	
	/**
	 * Metodo que realiza la tarea de eliminar entregas caducadas con estado confirmado en ENTREGAS B2B. 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void eliminarEntregasConfirmadasCaducadas()throws SICException;
	
	/**
	 * Metodo que realiza el proceso de regresar articulos nos recibidos a disponibles.
	 * @param codigoCompania
	 */
	public void regresarArticulosPlanificadosADisponibles(Long codigoCompania)throws SICException;
 	
}
