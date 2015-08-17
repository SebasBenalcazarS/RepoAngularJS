package ec.com.smx.sic.cliente.gestor.bodega.administracion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

public interface IAlmacenamientoAndenesGestor {

	/**
	 * Permite registrar los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajo
	 * @param userId
	 * @throws SICException
	 */
	public void asignarAndenesLocal(Collection<DetalleSeccionDTO> andenesCol, Integer codigoAreaTrabajo, String userId)throws SICException;
	
	/**
	 * Permite reasignar los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajoRemover
	 * @param codigoAreaTrabajoAsignar
	 * @param userId
	 * @throws SICException
	 */
	public void reasignarAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, Integer codigoAreaTrabajoAsignar, String userId)throws SICException;

	/**
	 * Permite remover los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajoRemover
	 * @param userId
	 * @throws SICException
	 */
	public void removerAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, String userId)throws SICException;
}
