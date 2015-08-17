package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;

public interface IFacturaRelacionadaDAO {

	/**
	 * Permite consolidar y registrar facturas relacionadas
	 * @param vistaRecibidoNoFacturadoCol
	 * @param valorTipoAsignacion
	 * @param userId
	 * @throws SICException
	 */
	public FacturaDTO consolidarFacturas(Collection<VistaRecibidoNoFacturadoDTO> vistaRecibidoNoFacturadoCol,String valorTipoAsignacion, String userId)throws SICException;
	
	/**
	 * Permite obtener las facturas relacionadas con la informacion de la cabecera
	 * @param codigoFactura
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerFacturasRelacionadas(Long codigoFactura)throws SICException;
	
	/**
	 * Permite deshacer las facturas consolidadas
	 * @param codigoCompania 
	 * @param codigoFactura
	 * @param userId
	 * @param estadoFacturasRevisadas
	 * @throws SICException
	 */
	public void deshacerConsolidado(Integer codigoCompania, Long codigoFactura, String userId, String estadoFacturasRevisadas)throws SICException;
	
	/**
	 * Permite registrar la relacion de la nota de ingreso con el documento ingresado
	 * @param codigoFacturaPadre
	 * @param facturaDTO
	 * @throws SICException
	 */
	public void crearFacturaRelacionada(Long codigoFacturaPadre, FacturaDTO facturaDTO)throws SICException;
	
	
	/**
	 * Permite inactivar la factura relacionada
	 * @param codigoFactura
	 * @param codigoFacturaRelacionada
	 * @param codigoUsuario
	 * @param estado
	 * @throws SICException
	 */
	public void activarDesactivarFacturaRelacionada(Long codigoFactura, Long codigoFacturaRelacionada, String codigoUsuario, String estado)throws SICException;
	
	/**
	 * Permite obtener las facturas del proveedor que se encuentran repetidas
	 * @param codigosNotasIngreso
	 * @return
	 * @throws SICException
	 */
	Collection<VistaRecibidoNoFacturadoDTO> obtenerFacturasRepetidas(List<Long> codigosNotasIngreso)throws SICException;
	
	/**
	 * Permite obtener las facturas del proveedor que no han sido revisadas de la nota de ingreso.
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 */
	Collection<VistaRecibidoNoFacturadoDTO> obtenerFacturasSinValorCambioInformacion(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite obtener el numero de facturas validas de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	Long obtenerNumeroFacturasProveedor(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
}
