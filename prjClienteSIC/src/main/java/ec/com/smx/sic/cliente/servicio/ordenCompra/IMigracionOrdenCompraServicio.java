/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.ordenCompra;

import java.io.File;
import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.generadorexportacion.estructura.InfoRecepcionEST;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDetalleRelacionadoDTO;

/**
 * @author jvillacis
 *
 */
public interface IMigracionOrdenCompraServicio extends Serializable {
	
	/**
	 * 
	 * @param pedidoDTOB2B
	 * @throws SICException
	 */
	public void migrarOrdenCompraB2B(PedidoDTO pedidoDTOB2B) throws SICException;
	
	/**
	 * 
	 * @param pedidoDetalleRelacionadoDTOB2B
	 * @throws SICException
	 */
	public void migrarOrdenCompraRelacionadaB2B(PedidoDetalleRelacionadoDTO pedidoDetalleRelacionadoDTOB2B)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param archivoProcesamientoActual
	 * @return LogProcesosMigracionDTO
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO procesarArchivoEntregaFacturaInterna(Integer codigoCompania, File archivoProcesamientoActual) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param archivoProcesamientoActual
	 * @return LogProcesosMigracionDTO
	 * @throws SICException
	 */
	public LogProcesosMigracionDTO procesarArchivoEntregaOrdenCompra(Integer codigoCompania, File archivoProcesamientoActual) throws SICException;
	
	/**
	 * Migra las ordenes de compra
	 * de cada pedido
	 * creadas/actualizadas/anuladas
	 * en el MAX al SIC
	 * @param pedidoDTO
	 * @param mensajesErroOmitirOrdenCompra: Mensajes a omitir de los errores que devuelve el SIC
	 * @throws SICException
	 */
	public void migrarOrdenCompraMAX(ec.com.smx.sic.cliente.mdl.dto.PedidoDTO pedidoDTO, String mensajesErroOmitirOrdenCompra) throws SICException;
	
	/**
	 * Metodo que actualiza un pedido
	 * despues de migrar todas sus
	 * ordenes de compra al SIC
	 * @param codigoCompania
	 * @param codigoPedido
	 * @param codigoMigracion
	 * @throws SICException
	 */
	public void actualizarPedidoMigracion(Integer codigoCompania, Long codigoPedido, Integer codigoMigracion) throws SICException;
	
	/**
	 * Metodo que cosulta si un listado
	 * de articulos esta integrado en el SIC
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public Boolean consultarExistenciaArticulosIntegrados(Integer codigoCompania, String[] codigosArticulos)throws SICException;
	
	/**
	 * Consulta el numero de embarque asociado
	 * a las facturas de las ordenes de compra
	 * de un pedido especifico
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public String obtenerNumeroEmbarqueFacturaOrdenCompra(Integer codigoCompania, Long codigoOrdenCompra) throws SICException; 
	
	/**
	 * Indica si un pedido tiene ordenes de compra con estado enviada
	 * @param codigoCompania
	 * @param codigoPedido
	 * @return True si contiene ordenes de compra en estado enviada, False en caso contrario
	 * @throws SICException
	 */
	public Boolean validarOrdenCompraEstadoEnviada(Integer codigoCompania, Long codigoPedido) throws SICException;
	
	/**
	 * Metodo que envia un email
	 * de error
	 * @param parametrosEmail
	 * @param parametroDireccionEmailFuncionarios
	 * 
	 * @throws SICException
	 */
	public void enviarEmailErrorMigracion(String[] parametrosEmail, String parametroDireccionEmailFuncionarios) throws SICException;
	
	/**
	 * Metodo que envia un email a los usuarios de proveedor relacionado con el pedido que se esta registrando
	 * @param pedidoDTO PedidoDTO que se esta registrando
	 * @param verificarOrdenCompra Indica si se debe validar o no la Orden de Compra
	 * @param verificarFechaPublicacion Indica si se debe validar o no la Fecha de Publicacion
	 * @param manejarExcepcion Indica si debe manejar o no las excepciones controladas
	 */
	public void enviarEmailsPedidos(ec.com.smx.sic.cliente.mdl.dto.PedidoDTO pedidoDTO, Boolean verificarOrdenCompra, 
			Boolean verificarFechaPublicacion, Boolean manejarExcepcion, String accionPedido) throws SICException;
	
	/**
	 * Permite actualizar el pedido despues de realizar el proceso de envio de email
	 * @param pedidoDTO
	 * @param procesoEnvioEmail
	 * @throws SICException
	 */
	public void actualizarPedidoEnvioEmail(ec.com.smx.sic.cliente.mdl.dto.PedidoDTO pedidoDTO, Integer procesoEnvioEmail)throws SICException;
	
	/**
	 * Metodo que obtiene los usuarios proveedores relacionados al pedido
	 * @param pedidoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<UsuarioProveedor> obtenerDatosUsuarioProveedor(ec.com.smx.sic.cliente.mdl.dto.PedidoDTO pedidoDTO) throws SICException;
	
	/**
	 *  Metodo que permite obtener los pedidos que tienen pendiente el envio de email al usuario del proveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ec.com.smx.sic.cliente.mdl.dto.PedidoDTO> obtenerPedidosPendientesEnvioEmail(Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo que importa los datos
	 * dee un archivo plano
	 * 
	 * @param fileTemp
	 * @param codigoCompania
	 * @param codigoFormato
	 * @return
	 * @throws SICException
	 */
	public InfoRecepcionEST importarDatos(File fileTemp, Integer codigoCompania, String codigoFormato) throws SICException;
	
}
