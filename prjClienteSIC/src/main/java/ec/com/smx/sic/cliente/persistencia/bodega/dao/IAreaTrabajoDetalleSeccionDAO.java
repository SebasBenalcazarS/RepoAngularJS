package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

/**
 * 
 * @author cortiz
 *
 */
public interface IAreaTrabajoDetalleSeccionDAO {

	/**
	 * metodo para actualizar la relacion con el anden y el local
	 * @param localDet
	 * @throws SICException
	 */
	public void actualizarRelacionLocalDetalle(AreaTrabajoDetalleSeccionDTO localDet) throws SICException;
	
	/**
	 * para buscar los locales de un anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDetalleSeccionDTO> busquedaAndenLocales(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Metodo para verificar la existencia de locales asignados a un anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Boolean existeLocalesAsignados(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Busca una relacion de local anden sin importar si esta activa o inactiva
	 * @param localAnden
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDetalleSeccionDTO buscarAndenLocal(AreaTrabajoDetalleSeccionDTO localAnden) throws SICException;
}
