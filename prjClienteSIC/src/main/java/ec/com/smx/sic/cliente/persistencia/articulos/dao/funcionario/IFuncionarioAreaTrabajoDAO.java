package ec.com.smx.sic.cliente.persistencia.articulos.dao.funcionario;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IFuncionarioAreaTrabajoDAO {

	
	public Collection<FuncionarioAreaTrabajoDTO> consultarFuncionarioAreaTrabajoPorAreaTrabajo(Integer codigoAreaTrabajo,String userId, Integer codigoCompania, String usuarioSesion)throws SICException;
}
