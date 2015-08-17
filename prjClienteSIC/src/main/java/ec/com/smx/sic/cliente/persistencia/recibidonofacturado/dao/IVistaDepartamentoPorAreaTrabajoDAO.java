package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaDepartamentoPorAreaTrabajoDTO;

public interface IVistaDepartamentoPorAreaTrabajoDAO {
	public List<VistaDepartamentoPorAreaTrabajoDTO> obtenerDepartamentosPorAreaTrabajo(Integer codigoCompania, Integer codigoAreaTrabajo)throws SICException;
}
