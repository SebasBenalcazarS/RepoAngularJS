package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.BusquedaTransferenciaTrasient;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;
/**
 * 
 * @author amunoz
 *
 */
public interface IContenedorEstadoDAO {
	/**
	 * @param parametrosConsulta
	 * @return
	 */
	public  Collection<BusquedaTransferenciaTrasient> obtenerConedorEstadoPaged(AdminContenedorVO adminContenedorVO, final Map<String, Object> componentesMap) throws SICException;
	
}
