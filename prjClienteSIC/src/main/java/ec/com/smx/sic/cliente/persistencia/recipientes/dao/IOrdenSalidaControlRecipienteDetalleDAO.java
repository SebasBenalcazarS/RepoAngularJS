package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenSalidaControlRecipienteDetalleID;

public interface IOrdenSalidaControlRecipienteDetalleDAO {
	void crearOrdenSalidaControlRecipienteDetalle(OrdenSalidaControlRecipienteDetalleDTO ordenSalidaControlRecipienteDetalle);
	
	void actualizarOrdenSalidaControlRecipienteDetalle(OrdenSalidaControlRecipienteDetalleDTO ordenSalidaControlRecipienteDetalle);

	OrdenSalidaControlRecipienteDetalleDTO findOrdenSalidaControlRecipienteDetalleDTO(Long codigoOrdenSalidaControlRecipienteDetalle);
  
    Boolean findExistsOrdenSalidaControlRecipienteDetalleDTO(OrdenSalidaControlRecipienteDetalleID id) ;
  
    Collection<OrdenSalidaControlRecipienteDetalleDTO> findOrdenSalidaControlRecipienteDetalleAll() ;
  
    Collection<OrdenSalidaControlRecipienteDetalleDTO> findCampaniasFiltros (OrdenSalidaControlRecipienteDetalleDTO ordenSalidaControlRecipienteDetalleDTO,Map<String, Object> componentesMap);
}
