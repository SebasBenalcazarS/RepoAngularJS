package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.GestionPrecioID;

/**
 * DAO para acceder el repositorio representado por la entidad
 * CampaniaDTO
 * @author cbarahona
 *
 */
public interface ICampaniaDAO {
	/**
	 * Crear la campania en el repositorio
	 * @param campania
	 */
	void crearCampania(GestionPrecioDTO campania);
	
	
	/**
	 * Actualizar la campania en el repositorio
	 * @param campania
	 */
	void actualizarCampania(GestionPrecioDTO campania, UserDto user);
	
	/** Metodo actualizarCampania, utilizado para actualizar una campania
	 * @author srodriguez
	 * 27/2/2015
	 * @param campania
	 * @param user
	 * @return void
	 */
	void actualizarCampania(GestionPrecioDTO campania, String user);
	
	/**
	 * Buscar la campania por el c&oacute;digo de referencia
	 * de Loyalty
	 * @param codigoCampaniaReferencia C&oacute;digo de Loyalty
	 * @return
	 */
	GestionPrecioDTO findCampania(String codigoCampaniaReferencia);
    /**
     * Verifica si una campania existe dado su clave primaria como
     * par&aacute;metro de b&uacute;squeda
     * @param id
     * @returnS
     */
    Boolean findExistsCampania(GestionPrecioID id) ;
    /**
     * Obtener todas las campanias existentes en el repositorio
     * @return
     */
    Collection<GestionPrecioDTO> findCampaniasPendientes() ;
    /**
     * Buscar un listado de campanias dado una plantilla de b&uacute;squeda y el
     * estado de cobro
     * @param gestionPrecio Plantilla de b&uacute;squeda
     * @param estadoCobro Estado de cobro. Ej: PENDIENTE, CONFIGURADA, COBRADA, EN CURSO, etc.
     * @return
     */
    Collection<GestionPrecioDTO> findCampaniasFiltros (GestionPrecioDTO gestionPrecio,String estadoCobro);
    
    /**
     * @author cbarahona
     * @param campania
     */
    void actualizarCampaniaLoyalty (GestionPrecioDTO campania);
    
    SearchResultDTO<GestionPrecioDTO> findCampaniasPendientesLazy (Integer firstResult, Integer pageSize, Boolean countAgain);
    
    SearchResultDTO<GestionPrecioDTO> findCampaniasFiltrosLazy (GestionPrecioDTO gestionPrecio, String estadoCobro,Integer firstResult, Integer pageSize, Boolean countAgain);
    
    GestionPrecioDTO findCampania(final String codigoReferencia, final Integer codigoCompania) throws SICException;
    
    void actualizarCampania(GestionPrecioDTO campania) throws SICException;
    
    /**
     * Metodo que valida si una campaña tiene participantes
     * @param codigoReferencia
     * @return
     * @throws SICException
     */
    Boolean tieneParticipantesCampania(String codigoReferencia) throws SICException;
}
