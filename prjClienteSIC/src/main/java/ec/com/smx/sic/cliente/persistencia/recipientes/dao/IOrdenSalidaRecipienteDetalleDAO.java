package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaRecipienteDetalleID;

public interface IOrdenSalidaRecipienteDetalleDAO {
	
	void crearOrdenSalidaRecipienteDetalle(OrdenSalidaRecipienteDetalleDTO ordenSalidaRecipienteDetalle);
	
	void actualizarOrdenSalidaRecipienteDetalle(OrdenSalidaRecipienteDetalleDTO ordenSalidaRecipienteDetalle);

	OrdenSalidaRecipienteDetalleDTO findOrdenSalidaRecipienteDetalleDTO(Long codigoOrdenSalidaRecipienteDetalle);
  
    Boolean findExistsOrdenSalidaRecipienteDetalleDTO(OrdenSalidaRecipienteDetalleID id) ;
  
    Collection<OrdenSalidaRecipienteDetalleDTO> findOrdenSalidaRecipienteDetalleAll() ;
  
    Collection<OrdenSalidaRecipienteDetalleDTO> findCampaniasFiltros (OrdenSalidaRecipienteDetalleDTO ordenSalidaRecipienteDetalleDTO,Map<String, Object> componentesMap);

}
