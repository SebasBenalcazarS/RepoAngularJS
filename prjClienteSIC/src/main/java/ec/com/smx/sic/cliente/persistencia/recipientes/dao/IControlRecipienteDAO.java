package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteID;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteCabeceraEntregaTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteCabeceraProveedorDocumentoTrasient;
/**
 * 
 * @author amunoz
 *
 */
public interface IControlRecipienteDAO {
	
	void crearControlRecipiente(ControlRecipienteDTO controlRecipiente);
	
	void actualizarControlRecipiente(ControlRecipienteDTO controlRecipiente);

	ControlRecipienteDTO findControlRecipienteDTO(Long codigoControlRecipiente);
  
    Boolean findExistsControlRecipienteDTO(ControlRecipienteID id) ;
  
    Collection<ControlRecipienteDTO> findControlRecipienteAll() ;
  
    Collection<ControlRecipienteDTO> findCampaniasFiltros (ControlRecipienteDTO controlRecipienteDTO,Map<String, Object> componentesMap);
    
    /**
     * Busqueda por filtros de las cabeceras en el canje de recipientes por proveedor
     * @param componentesMap
     * @return
     */
     Collection<RecipienteCabeceraProveedorDocumentoTrasient> obtenerCabecerasControlRecipiente(Map<String, Object> componentesMap);
     
     /**
      * @author yarmentero
      * Busqueda por recepcionesProveedorDTO de las cabeceras en el canje de recipientes por proveedor
      * @param recepcionesProveedorDTO
      * @return
      */
      Collection<RecipienteCabeceraProveedorDocumentoTrasient> obtenerCabecerasControlRecipiente(Collection<RecepcionProveedorDTO> recepcionesProveedorDTO);
     
     /**
      * B\u00FAsqueda por filtros de las cabeceras en la entrega de recipientes por proveedor
      * @param componentesMap
      * @return
      */
     Collection<RecipienteCabeceraEntregaTrasient> obtenerCabeceraEntregaRecipiente(Map<String, Object> componentesMap);
     /**
      * Actgualiza el codigo de factura en la cabecera de control recipiente 
      * @param facturaRegistrada
      */
     void actualizarNumeroFacturaControlRecipiente(List<RecepcionProveedorFacturaDTO> datosRecepcionFactura);
   
}
