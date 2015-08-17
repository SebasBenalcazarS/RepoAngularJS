/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.pedidoAsistido;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;

/**
 * @author jvillacis
 *
 */
public interface IAccionPedidoAsistidoServicio  extends Serializable {
	
	/**
	 * Generar datos para la creaci&oacute;n de reporte para pedido asistido
	 * 
	 * @param pedidoAreaTrabajoDTO
	 * @param url
	 * @return
	 * @throws SICException
	 */
	public byte[] obtenerDatosReportePedidoAsistido(PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO, String url) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoInterface
	 * @param userId
	 * @throws SICException
	 */
	public void generarArchivoInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoInterface, String userId) throws SICException;
	
}
