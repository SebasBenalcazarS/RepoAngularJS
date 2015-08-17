package ec.com.smx.sic.cliente.persistencia.procesamientoventas.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface ICalculoDatosProcesamientoVentasDAO extends Serializable {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTransaccionSIC
	 * @return
	 * @throws SICException
	 */
	public Collection<TransaccionDTO>  obtenerCodigoTransaccionRelacionadoSIC(Integer codigoCompania, Set<Integer> codigoTransaccionSIC) throws SICException;

}