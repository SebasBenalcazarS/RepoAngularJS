package ec.com.smx.sic.cliente.gestor.convenio;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;

/**
 * @author srodriguez
 * 2014-09-10
*/
public interface ICampaniaPromocionGestor {
	
	
    /**
     * @author srodriguez
     * @param campania
     */
    void crearCampania(GestionPrecioDTO campania);
    
    /**
     * @author srodriguez
     * @param campania
     */
    void actualizarCampania(GestionPrecioDTO campania,UserDto user);
    
    /**
     * @author srodriguez
     * @param campania
     * @param codigoCompania
     * @param usuarioAuditoria
     */
    void registrarCampania(GestionPrecioDTO campania, Integer codigoCompania, String usuarioAuditoria);
    
    /**
     * @author srodriguez
     * @param codigoPromocion
     * @return GestionPrecioDTO
     */
    GestionPrecioDTO findPromocion(Long codigoPromocion);
    
    /**
     * @author srodriguez
     * @param codigoCampaniaReferencia
     * @return GestionPrecioDTO
     */
    GestionPrecioDTO findCampania(String codigoCampaniaReferencia);
    
    /**
     * @author srodriguez
     * @param codigoCompania
     * @param codigoCampania
     * @return  Collection<GestionPrecioRelacionDTO>
     */
    Collection<GestionPrecioRelacionDTO> findPromocionesCampania(Integer codigoCompania, Long codigoCampania);
    
    /**
     * @author srodriguez
     * @param codigoCampaniaReferencia
     * @param campania
     * @return GestionPrecioDTO
     */
    GestionPrecioDTO sincronizarCampaniaLoyalty(String codigoCampaniaReferencia,GestionPrecioDTO campania);
    
    /**
     * @author srodriguez
     * @return Collection<GestionPrecioDTO>
     */
    Collection<GestionPrecioDTO> findCampaniasPendientes();
    

	/**
	 * @author srodriguez
     * @param gestionPrecio
     * @param estadoCobro
	 */
//    Collection<GestionPrecioDTO> findCampaniasFiltros (GestionPrecioDTO gestionPrecio, String estadoCobro);
    
    SearchResultDTO<GestionPrecioDTO> findCampaniasPendientesLazy (Integer firstResult, Integer pageSize, Boolean countAgain);
    
    SearchResultDTO<GestionPrecioDTO> findCampaniasFiltrosLazy (GestionPrecioDTO gestionPrecio, String estadoCobro,Integer firstResult, Integer pageSize, Boolean countAgain);
    
    /**
     * 
     * @param campania
     * @throws SICException
     */
    void registrarCampania(final GestionPrecioDTO campania) throws SICException;
    
    GestionPrecioDTO findCampania(String codigoReferencia, Integer codigoCompania) throws SICException; 
    
    Boolean tieneParticipantesCampania(String codigoReferencia) throws SICException;
}
