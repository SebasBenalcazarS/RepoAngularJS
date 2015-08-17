package ec.com.smx.sic.cliente.gestor.pedidoAsistido.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.InterfacePedidoAsistidoVO;

public interface IAlmacenamientoInterfacePedidoAsistidoGestor extends Serializable {

	/**
	 * 
	 * @param interfacePedidoAsistidoVO
	 * @throws SICException
	 */
	public void procesarInterfacePedidos(InterfacePedidoAsistidoVO interfacePedidoAsistidoVO) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoIntefacePedidoAreaTrabajo
	 * @param codigoProcesado
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarEstadoInterfacePedidoAreaTrabajo(Integer codigoCompania, Long codigoIntefacePedidoAreaTrabajo, Character codigoProcesado, String userId) throws SICException;
}
