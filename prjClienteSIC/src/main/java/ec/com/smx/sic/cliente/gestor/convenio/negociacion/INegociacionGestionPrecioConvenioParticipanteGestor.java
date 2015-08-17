package ec.com.smx.sic.cliente.gestor.convenio.negociacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.convenio.enums.TipoGestionPrecioParticipante;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionGestionPrecioParticipanteDTO;


/**
 * INegociacionGestionPrecioConvenioParticipanteGestor, interfaz de NegociacionGestionPrecioConvenioParticipanteGestor
 * @author srodriguez
 * **/
public interface INegociacionGestionPrecioConvenioParticipanteGestor {
	
	
	/**
	 * @author srodriguez
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @param campaniaPromocionParticipanteEstructura
	 * @param companyId
	 * @param userId
	 */
	void persistirNegociacionGestionPrecioConvenioParticipante(Collection<NegociacionGestionPrecioParticipanteDTO> negociacionGestionPrecioParticipanteCol,Integer companyId, String userId);
	
	/**
	 * @author srodriguez
	 * @param companyId
	 * @param codigoSecuencias
	 * @param tipo
	 * @return Collection<NegociacionGestionPrecioParticipanteDTO>
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findNegociacionGestionPrecioParticipante(Integer companyId, Collection<Long> codigoSecuencias, TipoGestionPrecioParticipante tipo,Boolean relacionConDetNegGesPre);
	
	
	/**
	 * Metodo de INegociacionGestionPrecioConvenioParticipanteGestor.java, utilizado para recuperar un registro
	 * srodriguez
	 * 13/1/2015
	 * @param companyId
	 * @param codigoSecuencias
	 * @param tipo
	 * @return
	 * Collection<NegociacionGestionPrecioParticipanteDTO>
	 */
	NegociacionGestionPrecioParticipanteDTO findNegociacionGestionPrecioParticipante(Integer companyId, Long codigoSecuencia);
	
	
	/** Metodo persistirDetalleNegociacionGestionPrecioConvenioParticipante, utilizado para persistir un detalle de negociacion de convenio participante
	 * @author srodriguez
	 * 23/3/2015
	 * @param detalleNegociacionGestionPrecioCovenioParticipanteDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirDetalleNegociacionGestionPrecioConvenioParticipante(DetalleNegociacionGestionPrecioCovenioParticipanteDTO detalleNegociacionGestionPrecioCovenioParticipanteDTO,Integer companyId,String userId);
	
	/** Metodo persistirDetalleNegociacionGestionPrecioConvenioParticipante, utilizado para utilizado para persistir varios detalle de negociacion de convenio participante
	 * @author srodriguez
	 * 23/3/2015
	 * @param detalleNegociacionGestionPrecioCovenioParticipanteDTOs 
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirDetalleNegociacionGestionPrecioConvenioParticipante(Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> detalleNegociacionGestionPrecioCovenioParticipanteDTOs,Integer companyId,String userId);
	
	/** Metodo eliminarDetalleNegociacionGestionPrecioConvenioParticipante, utilizado para eliminar los registros de un convenio participante
	 * @author srodriguez
	 * 24/3/2015
	 * @param companyId
	 * @param codigosDetalleNegociacionGestionPrecioCovenioParticipanteDTOs
	 * @return void
	 */
	void eliminarDetalleNegociacionGestionPrecioConvenioParticipante(Integer companyId,Collection<Long> codigosDetalleNegociacionGestionPrecioCovenioParticipanteDTOs);

}
