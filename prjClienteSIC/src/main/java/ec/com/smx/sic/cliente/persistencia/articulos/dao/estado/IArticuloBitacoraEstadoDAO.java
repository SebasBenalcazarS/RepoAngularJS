package ec.com.smx.sic.cliente.persistencia.articulos.dao.estado;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraEstadoDTO;

public interface IArticuloBitacoraEstadoDAO {

	ArticuloBitacoraEstadoDTO buscarPrimerEstadoRegistrado(Integer codigoCompania, String codigoArticulo, String codigoEstado, String... camposProyeccion) throws SICException;
	
}
