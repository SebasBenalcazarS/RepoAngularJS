package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleNegociacionID;

/**
 * @author srodriguez
 *
 */
public interface IDetalleNegociacionDAO {
	/**
	 * Metodo de IDetalleNegociacionDAO.java, utilizado para
	 * srodriguez
	 * 30/1/2015
	 * @param detalleNegociacionDTO
	 * @param codigoCompania
	 * @param idUsuarioRegistro
	 * void
	 */
	void crearDetalleNegociacion(DetalleNegociacionDTO detalleNegociacionDTO,Integer codigoCompania, String idUsuarioRegistro);
	/**
	 * Metodo de IDetalleNegociacionDAO.java, utilizado para
	 * srodriguez
	 * 30/1/2015
	 * @param detalleNegociacionDTO
	 * @param idUsuarioAuditoria
	 * void
	 */
	void actualizarDetalleNegociacion(DetalleNegociacionDTO detalleNegociacionDTO, String idUsuarioAuditoria);
	/**
	 * Metodo de IDetalleNegociacionDAO.java, utilizado para
	 * srodriguez
	 * 30/1/2015
	 * @param detalleNegociacionID
	 * @return
	 * Boolean
	 */
	Boolean findExistsDetalleNegociacion(DetalleNegociacionID detalleNegociacionID);
	/**
	 * Metodo de IDetalleNegociacionDAO.java, utilizado para
	 * srodriguez
	 * 30/1/2015
	 * @param codigoCompania
	 * @param idUsuarioAuditoria
	 * @param codigoNegociacion
	 * void
	 */
	@Deprecated
	void inactivarDetalleNegociacionConRelaciones(Integer codigoCompania ,String idUsuarioAuditoria,Long codigoNegociacion);
	
	/**
	 * Metodo de INegociacionDAO.java, utilizado para eliminar los registros de detalles de negociacion correspondientes a una negociacion
	 * @author srodriguez
	 * 30/1/2015
	 * @param companyId
	 * @param codigoDetalleNegociacion
	 * void
	 */
	void eliminarDetallesNegociacionFisico(DetalleNegociacionDTO detalleNegociacionDTO);
	
	
	/**
	 * Metodo de IDetalleNegociacionDAO.java, utilizado para eliminar los registros de detalles de negociacion correspondientes a una negociacion
	 * @author srodriguez
	 * 4/2/2015
	 * @param companyId
	 * @param codigoNegociacion
	 * void
	 */
	@Deprecated
	void eliminarDetallesNegociacionFisico(Integer companyId, Long codigoNegociacion);
	
	/**
	 * Metodo para eliminar los detalles de registro cobro modo cascada
	 * @param codigoCompania
	 * @param codigoNegociacion
	 * @param codigoNegociacionGePreParticipante
	 */
	@Deprecated
	void eliminarDetallesRegistroCobroFisico(Integer codigoCompania,Long codigoNegociacion,Long codigoNegociacionGePreParticipante);
	
	/**
	 * Eliminar datos detalle negociacion
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param codNegGesPreConPar
	 * @param userId
	 */
	void inactivacionDatosDetalleNegociacion(Integer codigoCompania, Long codigoDetalleNegociacion, Long codNegGesPreConPar, String userId,Collection<Long> codigoDetNegGesPreConPar);
	
	/**
	 * Metodo para buscar los detalles negociacion a partir de una negociacion
	 * @param codigoCompania
	 * @param codigoNegociacion
	 * @return
	 */
	Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> buscarDetalleNegociacionGesPreConParPorCodigoNegociacion(Integer codigoCompania,Long codigoNegociacion,Long codigoNegociacionGePreParticipante,Boolean cargarNeggespreconpar);
	
	/**
	 * Metodo que inactiva los detalles de registro fisico mediante el codigo de codigoDetNegociacionGePreParCol 
	 * @param idUsuario
	 * @param codigoCompania
	 * @param codigoDetalleNegociacionCol
	 * @param codigoNegociacionGePreParticipante
	 */
	void inactivarDetallesRegistroCobroFisico(String idUsuario,Integer codigoCompania,Collection<Long> codigoDetNegociacionGePreParCol,Boolean inactivarRegistroCobro);
	
	/**
	 * Metodo para actualizar del detalleNegociacionGesPreConPart con un nuevo detalle de un especifico NegGesPreConPart
	 * @param idUsuario
	 * @param codigoCompania
	 * @param codigoNegociacionGePrePar
	 * @param codigoDetalleNegociacionAnterior
	 * @param codigoDetalleNegociacionNuevo
	 * @throws SICException
	 */
	void actualizarCodigoDetalleNegociacionADetalleNegGesPreConPar(String idUsuario,Integer codigoCompania,Long codigoNegociacionGePrePar,Long codigoDetalleNegociacionAnterior,Long codigoDetalleNegociacionNuevo) throws SICException;
	
	/**
	 * Metodo para  buscar el codigo de un detalleNegociacion mediante el codigoNegociacion y el codigoValorFormaVenta.
	 * @param codigoCompania
	 * @param codigoNegociacion
	 * @param codigoValorFormaVenta
	 * @return
	 */
	DetalleNegociacionDTO findCodigoDetalleNegociacionPorFormaVenta(Integer codigoCompania, Long codigoNegociacion, String codigoValorFormaVenta);
	
	/**
	 * Actualiza las cuotas de las negociaciones que no
	 * se configurarion con el numero de cuotas
	 * @param idUsuario
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param cuotas
	 * @throws SICException
	 */
	void actualizarCuotasDetalleNegociacion(String idUsuario,Integer codigoCompania,Long codigoDetalleNegociacion, Integer cuotas);
	
	/**
	 * Actualiza es estado de generacion de fechas a 0
	 * cuando las fechas se han completado
	 * @param idUsuario
	 * @param codigoCompania
	 * @param codigoDetalleNegociacionGestionPrecioConvenioParticipante
	 * @throws SICException
	 */
	void actualizarDetalleNegociacionGestionPrecioConvenioParticipanteGenerarFechas(String idUsuario,Integer codigoCompania,Long codigoDetalleNegociacionGestionPrecioConvenioParticipante);
}
