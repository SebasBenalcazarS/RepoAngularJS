package ec.com.smx.sic.cliente.gestor.ordenCompra.accion;

import java.io.File;
import java.util.Collection;

import ec.com.smx.generadorexportacion.estructura.InfoRecepcionEST;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

public interface IAccionOrdenCompraGestor {

	/**
	 * Registra un orden de compra
	 * almacenada
	 * @param ordenCompraEstadoDTO
	 * @param mensajesErroOmitirOrdenCompra
	 * @throws SICException
	 */
	public void registrarOrdenCompra(OrdenCompraEstadoDTO ordenCompraEstadoDTO, Integer codigoAccion, Integer ultimaOrdenCompra, String mensajesErroOmitirOrdenCompra) throws SICException;
	
	/**Envia email de notificacion de
	 * error cuando no se procesa las 
	 * tareas de migracion de B2B O SIC
	 * 
	 * @param parametrosEmail[codigoCompania, tipoMigracion, cabeceraError, descripcionError]
	 * @param parametroDireccionEmailFuncionarios: Direcciones de email para cada proceso
	 * @throws SICException
	 */
	public void enviarEmailErrorMigracion(String[] parametrosEmail, String parametroDireccionEmailFuncionarios) throws SICException;
	
	/**
	 * Permite enviar email a los usuarios del proveedor relacionados con el pedido que se esta
	 * registrando
	 * 
	 * @param pedidoDTO                 : PedidoDTO que se esta registrando
	 * @param verificarOrdenCompra      : Indica si se debe validar o no la Orden de compra
	 * @param verificarFechaPublicacion : Indica si se debe validar o no la Fecha de Publicacion
	 * @param manejarExcepcion          : Verifica si maneja la excepxion en el metodo 
	 * @param accionPedido              : Idica el estado de la orden de compra: ENV / ANULAR
	 * @throws SICException
	 */
	public void enviarEmailsPedidos(PedidoDTO pedidoDTO, Boolean verificarOrdenCompra, Boolean verificarFechaPublicacion, Boolean manejarExcepcion, String accionPedido) throws SICException;
	
	/**
	 * Obtiene los datos de los usuarios proveedores
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioProveedor> obtenerDatosUsuarioProveedor(PedidoDTO pedidoDTO) throws SICException;
	
	/**
	 * Permite validar el Pedido, si tiene OrdenCompraEstado con estado Enviada
	 * @param pedidoDTO PedidoDTO a validar sus ordenes de compra
	 * @return True si valida, False en caso contrario
	 */
	public Boolean validarOrdenCompra(PedidoDTO pedidoDTO);
	
	/**
	 * Metodo que importa los datos
	 * del archivo de migracion de
	 * Entregas/Factura interna
	 * 
	 * @param fileTemp
	 * @param codigoCompania
	 * @param codigoFormato
	 * @return
	 */
	public InfoRecepcionEST importarDatos(File fileTemp, Integer codigoCompania, String codigoFormato);
	
}
