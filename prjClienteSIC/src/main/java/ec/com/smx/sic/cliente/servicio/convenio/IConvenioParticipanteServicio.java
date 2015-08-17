package ec.com.smx.sic.cliente.servicio.convenio;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;

/**
 * @author srodriguez
 * 2014-09-10
*/
public interface IConvenioParticipanteServicio {

    /**
     * @author srodriguez
     * @param codigoCompania
     * @param codigoPromocion
     * @return
     */
    Collection<ConvenioParticipanteDTO> findParticipantesPromocion(Integer codigoCompania, Long codigoPromocion);
    
    /**
     * @author srodriguez
     * @param codigoCompania
     * @param codigoCampania
     * @return
     */
    Collection<ConvenioParticipanteDTO> findParticipantesCampania(Integer codigoCompania, Long codigoCampania);
    
    /**
     * @author srodriguez
     * @param convenioParticipantes
     */
    void transActualizarConvenioParticipantes(Collection<ConvenioParticipanteDTO> convenioParticipantes);
    
    /**
     * @author srodriguez
     * @param convenioParticipante
     */
    void transActualizarConvenioParticipante(ConvenioParticipanteDTO convenioParticipante);

    /**
     * 
     * @param codigoCompania
     * @param codigosBarras
     * @return
     * @throws SICException
     */
    Collection<ArticuloDTO> findArticulosPorCodigosBarras(final Integer codigoCompania, final Collection<String> codigosBarras) throws SICException;
    
    /**
     * 
     * @param codigosArticulos
     * @param codigoCompania
     * @return
     * @throws SICException
     */
    Collection<ArticuloProveedorDTO> findArticuloProveedores(final Collection<String> codigosArticulos, final Integer codigoCompania) throws SICException ;
    
}
