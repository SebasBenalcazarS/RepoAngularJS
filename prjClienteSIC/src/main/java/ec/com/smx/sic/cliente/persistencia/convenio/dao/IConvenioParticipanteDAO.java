package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;

/**
 * @author srodriguez
 * 2014-09-10
*/

public interface IConvenioParticipanteDAO {
	
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
	 * @author dbravo
	 * @param estado
	 * @param usuarioModificacion
	 * @param fechaModificacion
	 * @param codigoConvenioParticipantes
	 */
	void actualizarParticipantes(Integer codigoCompania, String estado, String usuarioModificacion, java.util.Date fechaModificacion, Collection<Long> codigoConvenioParticipantes) throws SICException;
    
	/**
	 * @author dbravo
	 * @param codigoCompania
	 * @param estado
	 * @param codigoConvenioParticipantes
	 */
	void actualizarNegociacionGestionPrecio(Integer codigoCompania, String estado, Collection<Long> codigoConvenioParticipantes) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @return Collection<ConvenioParticipanteDTO>
	 */
	Collection<ConvenioParticipanteDTO> findParticipantesPromocion(Integer codigoCompania, Long codigoPromocion);
    
	/**
	 * @author srodriguez
	 * @param codigoCompania
	 * @param codigoCampania
	 * @return Collection<ConvenioParticipanteDTO>
	 */
	Collection<ConvenioParticipanteDTO> findParticipantesCampania(Integer codigoCompania, Long codigoCampania);
    
	/**
	 * @author srodriguez
	 * @param codigoCompania
	 * @param codigoParticipacion
	 * @return ConvenioParticipanteDTO
	 */
	ConvenioParticipanteDTO findConvenioParticipanteById(Integer codigoCompania, Long codigoParticipacion);


	/**
	 * 
	 * @param codigoCompania
	 * @param codigosBarras
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> findArticulosPorCodigosBarras(Integer codigoCompania, final Collection<String> codigosBarras) throws SICException;

	/**
	 * 
	 * @param codigosArticulos
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloProveedorDTO> findArticuloProveedores(final Collection<String> codigosArticulos, final Integer codigoCompania) throws SICException;

	void actualizarParticipante(final ConvenioParticipanteDTO participante) throws SICException;
}
