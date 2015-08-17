/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ConfiguracionBloqueoPedidoVO;

/**
 * @author bsandoval
 *
 */
public interface IConfiguracionBloqueoPedido {
	
	/**
	 * 
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoCalendarioProcesoDTO> obtenerBloqueosConfiguracionLocales(Integer codigoSubbodega , String userID , ConfiguracionBloqueoPedidoVO bloqueoVO) throws SICException;

}
