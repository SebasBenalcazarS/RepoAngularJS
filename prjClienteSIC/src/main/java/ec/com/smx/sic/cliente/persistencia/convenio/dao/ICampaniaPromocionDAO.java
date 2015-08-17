package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;

/**
 * DAO para acceder al repositorio representado por la entidad CampaniaPromocionDTO
 * Created by cbarahona on 22/09/2014.
 */
public interface ICampaniaPromocionDAO {
    /**
     * Crear una entidad de campania promoci&oacute;n en el repositorio
     * @param campaniaPromocion
     */
    void crearCampaniaPromocion(GestionPrecioRelacionDTO campaniaPromocion);
    /**
     * Actualizar una campa&ntilde;a promoci&oacute;n en el repositorio
     * @param campaniaPromocion
     */
    void actualizarCampaniaPromocion(GestionPrecioRelacionDTO campaniaPromocion);
    
    
    /**
     * Metodo de ICampaniaPromocionDAO.java, utilizado para
     * srodriguez
     * 13/1/2015
     * @param codigoCompania
     * @param codigoCampania
     * @return
     * Collection<GestionPrecioRelacionDTO>
     */
    Collection<GestionPrecioRelacionDTO> findParticipantesPromocionesCampania(Integer codigoCompania, Long codigoCampania);
    
    /**
     * @param codigosPromociones
     * @return
     */
    Collection<ConvenioParticipanteDTO> findTieneParticipantesByPromocion(Collection<Long> codigosPromociones);
    
    /**
     * @author cbarahona
     * @param codigosPromociones
     * @return
     */
    @Deprecated
    Collection<Object> findTieneActivoMotorPromocion (Collection<Long> codigosPromociones);
    
    void actualizarCampaniaPromocion(final GestionPrecioRelacionDTO campaniaPromocion, final Long codigoCampaniaPromocion);

}
