/** ec.com.smx.sic.cliente.persistencia.convenio.dao
 * IPlanFechaRegistroCobroDAO.java
 * @author srodriguez
 * 25/3/2015
 */
package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PlanFechaRegistroCobroDTO;

/**
 * @author srodriguez
 *
 */
public interface IPlanFechaRegistroCobroDAO {

	/** Metodo persistirPlanFechaRegistroCobro, utilizado para persistir un plan de fecha de registro de cobro
	 * @author srodriguez
	 * 25/3/2015
	 * @param planFechaRegistroCobroDTO
	 * @return void
	 */
	void persistirPlanFechaRegistroCobro(PlanFechaRegistroCobroDTO planFechaRegistroCobroDTO, Integer companyId, String userId);
	

	
	/** Metodo eliminarPlanFechaRegistrosCobro, utilizado para eliminar el registro de las fechas
	 * @author srodriguez
	 * 25/3/2015
	 * @param companyId
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return void
	 */
	void eliminarPlanFechaRegistrosCobro(Integer companyId,Collection<Long> codigoNegociacionGestionPrecioConvenioParticipantes);
	
	/**
	 * Metodo para actualizar los estados en  la tablaq plan fecha cobro
	 * @param codigoCompania
	 * @param idUsuario
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 */
	void actualizarPlanFechaRegistrosCobro(Integer codigoCompania,String idUsuario,Long codigoDetalleNegociacionGestionPrecioConvenioParticipante,String valoEstadoCobro,Integer tipoEstadoCobro) ;
	
	/**
	 * Metodo que actualiza el estado de cobro de la tabla detalleNegociacionGestionPrecioConvenioParticipante.
	 * @param codigoCompania
	 * @param idUsuario
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 */
	public void actualizarEstadoCobroADetalleNegociacionGestionPrecionConvenioParticipante(Integer codigoCompania,String idUsuario,Long codigoDetalleNegociacionGestionPrecioConvenioParticipante,String valorEstadoCobro,Integer tipoEstadoCobro,String valorEstadoGeneracionFecha,Integer tipoEstadoGeneracionFecha);
	
	/**
	 * MEtodo para traer una collecion de PlanFechaRegistroCobroDTO mediante el codigo Registro de la entidad RegistroCobroDTO
	 * @param codigoCompania
	 * @param codigoRegistroCobroCol
	 * @return
	 */
	public Collection<PlanFechaRegistroCobroDTO> findPlanFechaRegCobroPorCodigoRegistroCobro(Integer codigoCompania, Collection<Long> codigoRegistroCobroCol);
	
	/**
	 * Metodo para actualizarPlanFechaRegistro por el id
	 * @param codigoCompania
	 * @param idUsuario
	 * @param codigoPlaFechaRegistroCobro
	 * @param valoEstadoCobro
	 * @param tipoEstadoCobro
	 */
	public void actualizarPlanFechaRegistrosCobroPorId(Integer codigoCompania,String idUsuario,Long codigoPlaFechaRegistroCobro,String valoEstadoCobro,Integer tipoEstadoCobro) ;
	
	
	/**
	 * Total de cuotas
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 * @throws SICException
	 */
	Integer obtenerNumeroCuotasGeneradasByCodDetNEgGesPreConPar(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante);
}
