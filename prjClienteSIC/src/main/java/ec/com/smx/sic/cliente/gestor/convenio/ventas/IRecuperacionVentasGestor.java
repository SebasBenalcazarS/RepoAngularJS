package ec.com.smx.sic.cliente.gestor.convenio.ventas;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.VistaRecuperacionVentasLoyaltyDTO;

/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface IRecuperacionVentasGestor {

	/**
	 * @author srodriguez
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param registroInicial
	 * @param registroFinal
	 * @return Collection<VistaRecuperacionVentasLoyaltyDTO>
	 */
	Collection<VistaRecuperacionVentasLoyaltyDTO> recuperarVentas(Timestamp fechaInicial,Timestamp fechaFinal, Integer registroInicial, Integer registroFinal);
	
	/**
	 * @author srodriguez
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return Integer
	 */
	Integer recuperarNumeroRegistroVentas(Timestamp fechaInicial,Timestamp fechaFinal);
	
	
}
