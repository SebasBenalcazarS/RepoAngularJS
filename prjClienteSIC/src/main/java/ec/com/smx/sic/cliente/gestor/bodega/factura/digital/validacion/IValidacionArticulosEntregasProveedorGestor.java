package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.validacion;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiKeyMap;
import org.w3c.dom.Document;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DiferenciaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;

/**
 * <p>
 * 	Interface con los metodos para validar los articulos enviados 
 * 	contra los articulos recibidos en una entrega
 * </p>
 * @author osaransig
 * Aug 13, 2013
 */
public interface IValidacionArticulosEntregasProveedorGestor {

	
	/**
	 * Consultar proveedores por entrega para la validacion de articulos facturados contra los recibidos
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> consultarProveedoresPorEntrega(EntregaVO entregaVO) throws SICException;
	
	
	/**
	 * Consultar articulos por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> consultarArticulosPorEntrega(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Consultar articulos por orden de compra y factura
	 * @param numeroFacturaList
	 * @param numeroOrdenCompraList
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> consultarArticulosPorOrdenCompraFactura(
			List<String> numeroFacturaList, List<String> numeroOrdenCompraList) throws SICException;
	
	
	/**
	 * Metodo que devuelve una lista con la diferencia de los articulos facturados contra
	 * los recibidos, utilizando la integracion con el message broker, metodo para a utilizarse
	 * en la aplicacion web
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<Collection<OrdenCompraDetalleEstadoDTO>> obtenerDiferenciasArtFacturadosContraRecibidos(
			EntregaVO entregaVO) throws SICException;
	
	/**
	 * Obtener los articulos recibidos en el CD por entrega
	 * @param entregaVO
	 * @return collection<ArticuloDTO>
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerArticulosRecibidosEntrega(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Validar existe diferencias entrega articulos facturados contra recibidos
	 * @param mensaje		objeto Document
	 * @param id			Id del mensaje, obtenido del listener
	 * @throws SICException
	 * @author osaransig
	 */
	void validarDiferenciaArtFacturadosContraRecibidosDesdeIntegracion(Document mensaje, byte[] id) throws SICException;
	
	/**
	 * Obtener facturas por numero de factura
	 * @param numeroFacturas
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<FacturaEstadoDTO> obtenerFacturasPorNumFac(Collection<String> numeroFacturas) throws SICException;
	
	/**
	 * Obtener facturas por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<FacturaEstadoDTO> obtenerFacturasPorEntrega(EntregaVO entregaVO) throws SICException;

	
	/**
	 * Validar diferencia articulos facturados contra recibidos
	 * @param mapaProcesos
	 * @throws SICException
	 * @author osaransig
	 */
	void validarDiferenciaArtFacturadosContraRecibidosDesdeIntegracion(Map<String, Collection<Object>> mapaProcesos) throws SICException;
	
	/**
	 * Consultar ordenes de compra por datos de la plantilla 
	 * @param ordenCompraEstadoDTO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<OrdenCompraEstadoDTO> consultarOrdenCompraEstadoPorCodOrdComCodEnt(OrdenCompraEstadoDTO ordenCompraEstadoDTO, MultiKeyMap multiKeyMapOrdenEntrega) throws SICException;
	
	/**
	 * Consultar proveedores por detalle factura estado
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> consultarProveedoresPorDetalleFacturaEstado(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Consultar proveedores por orden compra detalle estado
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> consultarProveedoresPorOrdenCompraDetalleEstado(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Actualizar diferencias proceso logistico
	 * @param diferenciaProcesoLogisticoCol
	 * @throws SICException
	 * @author osaransig
	 */
	void actualizarJustificaciones(Collection<DiferenciaProcesoLogisticoDTO> diferenciaProcesoLogisticoCol) throws SICException;
	
	/**
	 * 
	 * @param mapaProcesos
	 * @throws SICException
	 */
	void almacenarCabecerasRecepcionProveedorArticulos(Map<String, Collection<Object>> mapaProcesos)throws SICException;
	
	/**
	 * 
	 * @param mapaProcesos
	 * @throws SICException
	 */
	public void validarDiferenciaArtFacturadosContraRecibidosDesdeIntegracionSIC(Map<String, Collection<Object>> mapaProcesos) throws SICException;
	
	/**
	 * Metodo que obtiene los articulos con diferencias en cantidad y peso que se registraron durante la recepcion.
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaDiferenciaFacturasRecepcionDTO> obtenerDiferenciasRecepcion(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * Metodo que obtiene procesoLogistico creado desde la entrega B2B - SIC
	 * @param vistaProcesoLogisticoVO
	 * @param esFechaEspecifica
	 * @return
	 * @throws SICException
	 */
	VistaProcesoLogisticoVO obtenerProcesoLogisticoRecepcion(VistaProcesoLogisticoVO vistaProcesoLogisticoVO, Boolean esFechaEspecifica) throws SICException; 
	
	/**
	 * 
	 * @param usuarioId
	 * @param tipoAreaTrabajoMayorNivel
	 * @param tipoAreaTrabajoMenorNivel
	 * @param codigoProcesoCaracteristicaAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<AreaTrabajoDTO> obtenerAreasTrabajoPorUsuario(String usuarioId, String tipoAreaTrabajoMayorNivel, String tipoAreaTrabajoMenorNivel) throws SICException;
}
