package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;

public interface IAndenesLocalDAO {

	public abstract void inactivarAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajo, String userId) throws SICException;
	
	public abstract void activarAndenesLocal(Collection<? extends SearchDTO> andenesCol, Integer codigoAreaTrabajo, String userId) throws SICException;
	
	public abstract void insertarAndenesLocales(Collection<? extends SearchDTO> andenesCol, Integer codigoAreaTrabajo, String userId)throws SICException;
}
