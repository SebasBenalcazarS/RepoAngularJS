package ec.com.smx.sic.cliente.persistencia.fruver.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.FechaOfertaProveedorDTO;

/**
 * @author  jcayo<josecayo4@gmail.com>
 *
 */
public interface IFechaOfertaProveedorDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param restricciones
	 * @return Collection<FechaOfertaProveedorDTO>
	 */
	Collection<FechaOfertaProveedorDTO> getFechasOfertaProveedor(Integer codigoCompania, String codigoProveedor, Map<String,Object> restricciones);

}
