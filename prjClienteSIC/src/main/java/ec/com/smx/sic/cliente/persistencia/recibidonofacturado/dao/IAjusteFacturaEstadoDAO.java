package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.AjusteFacturaEstadoDTO;

public interface IAjusteFacturaEstadoDAO {
	public AjusteFacturaEstadoDTO obtenerAjusteEstadoDTO(AjusteFacturaEstadoDTO ajusteFacturaEstadoPlantilla, Long codigoFacturaEstado)throws SICException;
	
	/**
	 * Permite inactivar el registro automatico de los ajustes
	 * @param codigoFacturaEstado
	 * @param userId
	 */
	public void inactivarAjusteAutomatico(Long codigoFacturaEstado, String userId)throws SICException;
	
	/**
	 * Metodo para eliminar el detalle de los ajustes establecidos que han sido borrados.
	 * @param codigoCompania
	 * @param codigoDetalleAjusteFacturaEstado
	 * @throws SICException
	 */
	void eliminarDetalleAjusteEstado(Integer codigoCompania, Long codigoDetalleAjusteFacturaEstado) throws SICException;
	
	/**
	 * Este metodo devuelve una coleccion de ajustes de la facturaEstado que recibe como parametro en el AjusteFacturaDTO
	 * @param ajusteFacturaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AjusteFacturaEstadoDTO> obtenerAjusteFacturaEstadoCol(AjusteFacturaDTO ajusteFacturaDTO) throws SICException;
}
