package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ControlRecipienteDetalleID;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteProveedorDocumentoTrasient;
import ec.com.smx.sic.cliente.mdl.vo.ControlRecipienteVO;
/**
 * 
 * @author amunoz
 *
 */
public interface IControlRecipienteDetalleDAO {
	
	void crearControlRecipienteDetalle(ControlRecipienteDetalleDTO controlRecipienteDetalle);
	
	void actualizarControlRecipienteDetalle(ControlRecipienteDetalleDTO controlRecipienteDetalle);

	ControlRecipienteDetalleDTO findControlRecipienteDetalleDTO(Long codigoControlRecipienteDetalle);
  
    Boolean findExistsControlRecipienteDetalleDTO(ControlRecipienteDetalleID id) ;
    /**
     * Metodo que busca los detalles entregados y por entregar de acuerdo a determinados filtros(Factura/ Proveedor)
     * @return
     */
    Collection<RecipienteProveedorDocumentoTrasient> obtenerConRecDetallePorFacturaProveedor(Integer codigoCompania, Long codigoControlRecipiente, ArrayList<String> codigosTipoArticuloList) ;
  
    Collection<ControlRecipienteDetalleDTO> findCampaniasFiltros (ControlRecipienteDetalleDTO controlRecipienteDetalleDTO,Map<String, Object> componentesMap);
    /**
     * Metodos de sincronizacion
     * @param codigoDatosTarea
     * @return
     */
    Collection<ControlRecipienteDetalleDTO> findControlRecipienteDetalle (Long codigoDatosTarea);
    
    /**
     * M\u00E9todo que busca los recipientes a entregar
     * @param codigoControlRecipiente
     * @return
     */
    Collection<ControlRecipienteDetalleDTO> findEntregaRecipienteDetalle(Collection<Long> idsConRecCol);
    /**
     * 
     * @param controlRecipienteTaraDetallesCol
     * @param codigoDatosTarea
     * @param usuario
     */
    void crearControlRecipienteDetalleSincronizado (Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, 
										    		Long codigoDatosTarea,
													String usuario);
    /**
     * 
     * @param controlRecipienteVO
     */
    void guardarCambioRecipienteRecepcionProveedor(ControlRecipienteVO controlRecipienteVO);

    /**
     * @author yarmentero
     * @param codigoCompania
     * @param codigoRecepcionProveedor
     * @param codigosTipoArticulo
     * @return
     * @throws SICException
     */
	Collection<RecipienteProveedorDocumentoTrasient> obtenerConRecDetallePorRecepcionProveedor(Integer codigoCompania, Long codigoRecepcionProveedor, ArrayList<String> codigosTipoArticulo) throws SICException;
}
