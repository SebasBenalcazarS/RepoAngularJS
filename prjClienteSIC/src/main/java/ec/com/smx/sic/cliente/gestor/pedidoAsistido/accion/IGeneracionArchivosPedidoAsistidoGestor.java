package ec.com.smx.sic.cliente.gestor.pedidoAsistido.accion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;

/**
 * @author finga
 * 
 */
public interface IGeneracionArchivosPedidoAsistidoGestor {

	/**
	 * M&eacute;todo para la generaci&oacute;n de reporte para pedido asistido
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
	
	/**
	 * 
	 * @param codigoCompania
	 */
	public void contingenciaGenerarArchivoInterfacePedidoAreaTrabajo(Integer codigoCompania);
}
