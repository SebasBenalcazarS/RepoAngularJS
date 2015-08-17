package ec.com.smx.sic.cliente.gestor.datosCorporativos.proceso;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProcesoVO;

public interface IProcesoGestor {

	
	public Collection<ProcesoClaseDTO> obtenerClaseProceso(Integer codigoCompania,Long codigoProceso) throws SICException;
	
	public void actualizarProceso(ProcesoDTO procesoDTO,	Collection<ProcesoClaseDTO> procesoClaseDTOs) throws SICException;
	
	public void crearProceso(ProcesoDTO procesoDTO,	Collection<ProcesoClaseDTO> procesoClaseDTOs) throws SICException;
	
	/**
	 * Permite guardar una caracteristica del arae de trabajo mediante un proceso
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @throws SICException
	 */
	
	public void crearCaracteristicaProcesoAreaTrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO) throws SICException;
	
	/**
	 * Permite actualizar una caracteristica del arae de trabajo mediante un proceso
	 * @throws SICException
	 */
	public void actualizarCaracteristicaProcesoAreaTrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;

	public ProcesoVO obtenerProceso(ProcesoVO procesoVO) throws SICException;
}
