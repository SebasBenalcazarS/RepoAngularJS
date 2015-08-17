package ec.com.smx.sic.cliente.servicio.procesamientoventas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.common.procesamientoventas.beans.DatoPrecioMargenReal;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IProcesamientoVentasServicio extends Serializable {
	
	/**
	 * Metodo para migrar los datos de las ventas que son enviados por el SIC 
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void ejecutarVentasDevolucionesProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTransaccionSIC
	 * @return
	 * @throws SICException
	 */
	Collection<TransaccionDTO> obtenerCodigoTransaccionRelacionadoSIC(Integer codigoCompania, Set<Integer> codigoTransaccionSIC) throws SICException;

	/**
	 * 
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	Collection<DatoPrecioMargenReal> obtenerListadoPreciosMargenReal(String codigoArticulo, Integer codigoCompania, Date fechaInicial, Date fechaFinal) throws SICException;

}
