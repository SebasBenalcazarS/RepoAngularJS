package ec.com.smx.sic.cliente.gestor.bodega.administracion.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

public interface IValidacionAndenesGestor {

	public void asignarAndenesLocal(Collection<DetalleSeccionDTO> andenesCol, Integer codigoAreaTrabajo, String userId)throws SICException;
	
	public void reasignarAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, Integer codigoAreaTrabajoAsignar, String userId)throws SICException;
	
	public void removerAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, String userId)throws SICException;
}
