package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaRecipienteID;

public interface IOrdenSalidaRecipienteDAO {
	
	void crearOrdenSalidaRecipiente(OrdenSalidaRecipienteDTO ordenSalidaRecipiente);
	
	void actualizarOrdenSalidaRecipiente(OrdenSalidaRecipienteDTO ordenSalidaRecipiente);

	OrdenSalidaRecipienteDTO findOrdenSalidaRecipienteDTO(Long codigoOrdenSalidaRecipiente);
  
    Boolean findExistsOrdenSalidaRecipienteDTO(OrdenSalidaRecipienteID id) ;
  
    Collection<OrdenSalidaRecipienteDTO> findOrdenSalidaRecipienteAll() ;
  
    Collection<OrdenSalidaRecipienteDTO> findCampaniasFiltros (OrdenSalidaRecipienteDTO ordenSalidaRecipienteDTO,Map<String, Object> componentesMap);
    
    /**
     * Metodo para consultar una areaTrabajo dependiendo a partir del id
     * @param idAreaTrabajo
     * @return
     * @throws SICException
     */
    AreaTrabajoDTO obtenerAreaTrabajoPorId(AreaTrabajoID idAreaTrabajo) throws SICException;
    
    
    	
}
