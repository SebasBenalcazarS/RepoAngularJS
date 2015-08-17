package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IDetalleAjusteFacturaEstadoDAO {

	/**
	 * Permite inactivar el registro automatico de los ajustes
	 * @param codigoFacturaEstado
	 * @param userId
	 */
	public void inactivarAjusteAutomatico(Long codigoFacturaEstado, String userId)throws SICException;
	
	/**
	 * Permite marcar como contabilizado los ajustes de la nota de ingreso
	 * @param codigoDetalleAjusteFacturaEstado
	 * @param userId
	 * @throws SICException
	 */
	public void marcarContabilizado(Long codigoDetalleAjusteFacturaEstado, String userId) throws SICException;
}
