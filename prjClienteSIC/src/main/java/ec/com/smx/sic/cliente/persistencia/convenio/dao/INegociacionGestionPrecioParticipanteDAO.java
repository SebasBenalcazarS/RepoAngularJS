package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.convenio.enums.TipoGestionPrecioParticipante;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionGestionPrecioParticipanteDTO;

/**
 * INegociacionGestionPrecioParticipanteDAO, interfaz de NegociacionGestionPrecioParticipanteDAO
 * 
 * @author srodriguez 2014-12-15
 * **/
public interface INegociacionGestionPrecioParticipanteDAO {

	/**
	 * @author srodriguez
	 * @param companyId
	 * @param codigosSecuencia
	 * @param tipo
	 * @return Collection<NegociacionGestionPrecioParticipanteDTO>
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findNegociacionGestionPrecioParticipante(Integer companyId, Collection<Long> codigosSecuencia, TipoGestionPrecioParticipante tipo,Boolean relacionConDetNegGesPre);

	/**
	 * Metodo de INegociacionGestionPrecioParticipanteDAO.java, utilizado para recuperar un solo registro de la entidad NegociacionGestionPrecioParticipanteDTO
	 * srodriguez
	 * 13/1/2015
	 * @param companyId
	 * @param codigosSecuencia
	 * @param tipo
	 * @return
	 * NegociacionGestionPrecioParticipanteDTO
	 */
	NegociacionGestionPrecioParticipanteDTO findNegociacionGestionPrecioParticipante(Integer companyId, Long codigosSecuencia);
	
	
	/**
	 * Metodo de INegociacionGestionPrecioParticipanteDAO.java, utilizado para persistir la entidad NegociacionGestionPrecioParticipanteDTO
	 * srodriguez
	 * 13/1/2015
	 * @param negociacionGestionPrecioParticipanteCol
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirNegociacionGestionPrecioParticipacion(NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipante, Integer companyId, String userId);
	

	/**
	 * @author cbarahona
	 * @param negociacionGestionPrecioParticipanteDTO
	 */
	void crearNegociacionGestionPrecioParticipacion(NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipanteDTO);

	/**
	 * @author cbarahona
	 * @param negociacionGestionPrecioParticipanteDTO
	 */
	void actualizarNegociacionGestionPrecioParticipacion(NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipanteDTO);

	/**
	 * @author cbarahona
	 * @param codigoCampania
	 * @return NegociacionGestionPrecioParticipanteDTO
	 */
	NegociacionGestionPrecioParticipanteDTO findByCodigoCampania(Long codigoCampania);

	/**
	 * @author srodriguez
	 * @param codigoPromocion
	 * @param codigoNegociacion
	 * @return Collection<NegociacionGestionPrecioParticipanteDTO>
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findNegociacionGestionPrecioParticipanteByCodigoPromocion(Long codigoPromocion, Long codigoNegociacion);

	/**
	 * @author srodriguez
	 * @param codigoParticipacion
	 * @return NegociacionGestionPrecioParticipanteDTO
	 */
	NegociacionGestionPrecioParticipanteDTO findNegociacionGestionPrecioByCodigoParticipacion(Long codigoParticipacion);

	/**
	 * @author srodriguez
	 * @param codigoParticipacion
	 * @return Collection<NegociacionGestionPrecioParticipanteDTO>
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findByCodigoParticipacion(Long codigoParticipacion);

	/**
	 * @author srodriguez
	 * @param codigoParticipacion
	 * @param codigoNegociacion
	 * @return Collection< NegociacionGestionPrecioParticipanteDTO>
	 */
	Collection<NegociacionGestionPrecioParticipanteDTO> findByParticipanteNegociacion(Long codigoParticipacion, Long codigoNegociacion);
	
	
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
	
	/** Metodo eliminarDetalleNegociacionGestionPrecioConvenioParticipante, utilizado para eliminar los detalles de negociacion por participantes
	 * @author srodriguez
	 * 24/3/2015
	 * @param codigosDetalleNegociacionGestionPrecioCovenioParticipanteDTOs
	 * @return void
	 */
	void eliminarDetalleNegociacionGestionPrecioConvenioParticipante(Integer companyId,Collection<Long> codigosDetalleNegociacionGestionPrecioCovenioParticipanteDTOs);
	
	/**
	 * Metodp para buscar DetalleNegGestPreConPar
	 * @param codigoCompania
	 * @param codigoNegociacionGePreParticipante
	 * @param codigoDetalleNegoacionacion
	 * @param cargarPlanFechas
	 * @return
	 */
	DetalleNegociacionGestionPrecioCovenioParticipanteDTO findDetalleNegociacionGesPreConPar(Integer codigoCompania,Long codigoNegociacionGePreParticipante,Long codigoDetalleNegoacionacion,Boolean cargarPlanFechas);

	/**
	 * Retorn una colecion de DetalleNegGesPreConPar mediante el codigo NegGesPreConPar
	 * @param codigoCompania
	 * @param codigoNegociacionGePreParticipante
	 * @return
	 */
	Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> findDetalleNegociacionGesPreConPar(Integer codigoCompania,Long codigoNegociacionGePreParticipante,Boolean relacionPlanFecha,Boolean relacionDetalleNegociacion);
	
	/**
	 * Metodo para obtener los secuenciales de la tabla DetalleNegociacionGesPreConPar
	 * @param codigoCompania
	 * @param codigoNegociacionGePreParticipante
	 * @param codigoDetalleNegociacion
	 * @return
	 */
	Collection<Long> findCodigoDetalleNegociacionGesPreConPar(Integer codigoCompania,Long codigoNegociacionGePreParticipante,Long codigoDetalleNegociacion);
	
	/**
	 * Metodo para buscar DetNegGesPreConPar por id
	 * @param codigoCompania
	 * @param codigoNegociacionGePreParticipante
	 * @return
	 */
	DetalleNegociacionGestionPrecioCovenioParticipanteDTO findDetalleNegociacionGesPreConParPorId(Integer codigoCompania,Long codigoNegociacionGePreParticipante);

	
	/**
	 * Metodo para buscar DetNegGesPreConPar por id
	 * @param codigoCompania
	 * @param codigoNegociacionGePreParticipante
	 * @return Collection DetalleNegociacionGestionPrecioCovenioParticipanteDTO
	 */
	Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> findDetalleNegociacionGesPreConParPorId(Integer codigoCompania,Collection<Long> codigoNegociacionGePreParticipante);
	
	/**
	 * Metodo para actualizar detalleNegociacionGestionPrecioConvenioParticipante los estados  de generacion de fechas de Factura
	 * @param codigoCompania
	 * @param idUsuario
	 * @param codigoDetNegGesPreConParCol
	 * @param estadoGeneracionFactura
	 */
	void actualizarDetalleNegociacionGestionPrecioConvenioParticipanteAEstadoGeneracionFactura(Integer codigoCompania,String idUsuario,Collection<Long> codigoDetNegGesPreConParCol,String estadoGeneracionFechasFactura);
	
	/**
	 * Metodo para  buscar los codigosDetalleNegociacionGesPreConPar
	 * @param codigoCompania
	 * @param codigoDetNegociacionGePreParticipanteCol
	 * @return
	 */
	Collection<Long> findCodigoDetalleNegociacionGesPreConParPorId(Integer codigoCompania,Collection<Long> codigoDetNegociacionGePreParticipanteCol);

	/**
	 * Metodo para buscar los detallesNegociacionGesPreConPar pendiente de generacion de fechas , cargado el detalle de la negociacion y as fechas de la promocion
	 * @param codigoCompania
	 * @return
	 */
	Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> findDetalleNegociacionGesPreConParPendientePorGenerarFechas(Integer codigoCompania);
}