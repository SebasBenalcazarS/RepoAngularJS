package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * 
 * @author cortiz
 *
 */

public interface ICaracteristicaProcesoAreaTrabajoDAO {

	
	/**
	 * Busqueda de carcteristicas
	 * @param caracteristicaProcesoAreaTrabajoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<CaracteristicaProcesoAreaTrabajoDTO> buscarCaracteristicas(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTOs)throws SICException;
	
	/**
	 * Permite actualizar las caracteristicas de la areatrabajo
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void modificarCaracteristicasAreatrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
	/**
	 * 
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public CaracteristicaProcesoAreaTrabajoDTO buscarCaracteristica(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
}
