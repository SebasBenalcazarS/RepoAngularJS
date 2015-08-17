package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDetalleRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteTaraDetalleID;
/**
 * 
 * @author amunoz
 *
 */
public interface IControlRecipienteTaraDetalleDAO {
	
	void crearControlRecipienteTaraDetalle(ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalle);
	
	void actualizarControlRecipienteTaraDetalle(ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalle);

	ControlRecipienteTaraDetalleDTO findControlRecipienteTaraDetalleDTO(Long codigoControlRecipienteTaraDetalle);
  
    Boolean findExistsControlRecipienteTaraDetalleDTO(ControlRecipienteTaraDetalleID id) ;
  
    Collection<ControlRecipienteTaraDetalleDTO> findControlRecipienteTaraDetalleAll() ;
    
    Collection<DatosTareaDetalleRecipienteDTO> findControlRecipienteDatosTaraDetalleAll() ;
  
    Collection<ControlRecipienteTaraDetalleDTO> findControlRecipienteTaraDetalleFiltros (ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO,Map<String, Object> componentesMap);
  
    /**
    * Retorna todos los recipientes asociados al articulo pro tipo de control costo 
    * @param articulo
    * @param codigoTipoControlCosto
    * @return
    */
    Collection<ControlRecipienteTaraDetalleDTO> findControlRecipienteTaraPorArticulo (ArticuloDTO articulo,Integer codigoTipoControlCosto);
    /**
     * Crea una coleccion de control recipiente que pertenecen a los articulos que se recibieron en la bodega
     * @param controlRecipienteTaraDetallesCol
     */
    void crearControlRecipienteTaraDetalles(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol ,Long codigoDatosTarea);

	void actualizarCantidadControlRecipienteTaraDetalle(Integer codigoCompania, String userId, Long codigoControlRecipienteDetalleTara, Integer cantidad) throws SICException;
    

}
