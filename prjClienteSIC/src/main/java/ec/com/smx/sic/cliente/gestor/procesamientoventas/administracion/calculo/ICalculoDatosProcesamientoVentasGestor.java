package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosProcesamientoVentasGestor extends Serializable {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTransaccionSIC
	 * @return
	 * @throws SICException
	 */
	Collection<TransaccionDTO> obtenerCodigoTransaccionRelacionadoSIC(Integer codigoCompania, Set<Integer> codigoTransaccionSIC) throws SICException;

}