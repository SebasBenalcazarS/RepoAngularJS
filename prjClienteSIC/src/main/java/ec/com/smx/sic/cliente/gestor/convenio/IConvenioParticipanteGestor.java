package ec.com.smx.sic.cliente.gestor.convenio;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;


/**
 * @author srodriguez
 * 2014-09-10
*/
public interface IConvenioParticipanteGestor {
	

	/**
	 * @author srodriguez
	 * @param codigoCompania
	 * @param codigoParticipacion
	 * @return
	 */
	ConvenioParticipanteDTO findConvenioParticipanteById(Integer codigoCompania, Long codigoParticipacion);

    /**
     * @author srodriguez
     * @param convenioParticipante
     */
    void crearConvenioParticipante(ConvenioParticipanteDTO convenioParticipante);
    
    /**
     * @author srodriguez
     * @param convenioParticipante
     */
    void actualizarConvenioParticipante(ConvenioParticipanteDTO convenioParticipante);
    
    /**
     * @author srodriguez
     * @param convenioParticipantes
     */
    void actualizarConvenioParticipantes(Collection<ConvenioParticipanteDTO> convenioParticipantes);
    
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
     */
    Collection<ArticuloProveedorDTO> findArticuloProveedores(final Collection<String> codigosArticulos, final Integer codigoCompania);
    
}
