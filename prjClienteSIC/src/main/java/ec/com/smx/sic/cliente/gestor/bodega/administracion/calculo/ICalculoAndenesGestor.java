package ec.com.smx.sic.cliente.gestor.bodega.administracion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

public interface ICalculoAndenesGestor {

	/**
	 * Permite obtener la lista de andenes de la bodega
	 * @param codigoBodega
	 * @param disponible(True -> andenes que no estan asignados a ningun local)
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerListaAndenes(Integer codigoBodega, Boolean disponible)throws SICException;
	
	/**
	 * Permite obtener la lista de locales para asignar los andenes correspondientes
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerLocalesAsignacionAndenes()throws SICException;
	
	/**
	 * Permite obtener la lista de andenes de la bodega asignados de un local
	 * @param codigoBodega
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionAreaTrabajoDTO> obtenerListaAndenesLocal(Integer codigoBodega, Integer codigoLocal)throws SICException;
}
