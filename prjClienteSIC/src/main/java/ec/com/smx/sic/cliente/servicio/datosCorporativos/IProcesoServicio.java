package ec.com.smx.sic.cliente.servicio.datosCorporativos;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProcesoVO;


public interface IProcesoServicio {
		
	ProcesoVO obtenerProceso(ProcesoVO procesoVO)throws SICException;
	
	Collection<ProcesoClaseDTO> obtenerClaseProceso(Integer codigoCompania,Long codigoProceso) throws SICException;
	
    void actualizarProceso(ProcesoDTO procesoDTO,Collection<ProcesoClaseDTO> procesoClaseDTOs)throws SICException;
    
    void crearProceso(ProcesoDTO procesoDTO,Collection<ProcesoClaseDTO> procesoClaseDTOs)throws SICException;
    
    /**
     * Permite guardar una caracteristica del arae de trabajo mediante un proceso
     * @param caracteristicaProcesoAreaTrabajoDTO
     * @throws SICException
     */
    void crearCaracteristicaProcesoAreaTrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
    
    /**
     * Permite actualizar una caracteristica del arae de trabajo mediante un proceso
     * @param caracteristicaProcesoAreaTrabajoDTO
     * @throws SICException
     */
    void actualizarCaracteristicaProcesoAreaTrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
    
}

