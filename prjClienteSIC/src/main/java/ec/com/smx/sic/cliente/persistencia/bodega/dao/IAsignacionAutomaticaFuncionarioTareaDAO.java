package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

public interface IAsignacionAutomaticaFuncionarioTareaDAO {

	public void actualizarTarea(TareaDTO tareaDTO) throws SICException;
}
