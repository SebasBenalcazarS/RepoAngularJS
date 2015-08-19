/** ec.com.smx.sic.cliente.gestor.convenio.cobros
 * IRegistroCobroGestor.java
 * @author srodriguez
 * 23/2/2015
 */
package ec.com.smx.sic.cliente.gestor.convenio.cobros;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.PlanFechaRegistroCobroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCobroProveedoresDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaParticipantesDTO;

/**
 * @author srodriguez
 *
 */
public interface IRegistroCobroGestor {
	
	/** Metodo persistirRegistroCobro, utilizado para persistir una fila de la tabla de registro de cobro
	 * @author srodriguez
	 * 23/2/2015
	 * @param registroCobroDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirRegistroCobro(RegistroCobroDTO registroCobroDTO,Integer companyId, String userId);
	
	/** Metodo persistirRegistroCobroDetalle, utilizado para registrar los detalles de un registro de cobro
	 * @author srodriguez
	 * 23/2/2015
	 * @param registroCobroDetalleDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirRegistroCobroDetalle(RegistroCobroDetalleDTO registroCobroDetalleDTO,Integer companyId, String userId);
	
	
	/** Metodo persistirRegistroCobro, utilizado para obtener un registro de cobro
	 * @author srodriguez
	 * 23/2/2015
	 * @param companyId
	 * @param codigoRegistroCobro
	 * @return void
	 */
	RegistroCobroDTO findRegistroCobroDTO(Integer companyId, Long codigoRegistroCobro);
	

	/**
	 * Metodo findRegistroCobroPorNegociacionGestionPrecioConvenioParticipante,
	 * utilizado para
	 * 
	 * @author srodriguez 23/2/2015
	 * @param companyId
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 * @return Collection<RegistroCobroDTO>
	 */
	public RegistroCobroDTO findRegistroCobroPorNegociacionGestionPrecioConvenioParticipante(Integer companyId, Long codigoNegociacionGestionPrecioConvenioParticipante);

	/**
	 * MEtodo para obtener la lista de cobro a proveedores
	 * @return
	 */
	Collection<VistaCobroProveedoresDTO> obtenerDatosCobroProveedores(Long codigoCampania, String codigoCompuesto);
	
	/**
	 * Devuelve los datos de una campaña 
	 * @param codigoCampania
	 * @param codigoReferencia
	 * @return
	 */
	GestionPrecioDTO obtenerDatosCampaniabyCodigos(Long codigoCampania, String codigoReferencia);
	
	/**
	 * MEtodo para obtener la lista de participantes por campania
	 * @return
	 */
	Collection<VistaParticipantesDTO> obtenerParticipantesByCampania(Long codigoCampania, String codigoReferencia);
	/**
	 * Obtiene la lista de campanias
	 * @param codigoCampaniLoyalty
	 * @param nombreCampania
	 * @return
	 */
	Collection<GestionPrecioDTO> obtenerCampaniasByCodigoNombre(String codigoCampaniLoyalty, String nombreCampania);
	
	/**
	 * Devuelve los datos de las campanias por participantes 
	 * @param vistaEmpresaParticipanteDTO
	 * @return
	 */
	Collection<GestionPrecioDTO> obtenerDatosCampaniabyParticipante(VistaEmpresaParticipanteDTO vistaEmpresaParticipanteDTO);
	/**
	 * Metodo para crear prefactura en el SIF
	 * @throws SICException
	 */

	
	void crearPrefactura(Integer codigoCompania,String userId,Long codigoConcepto,String codigoCentroCosto) throws SICException ;
	
	/**
	 * Crear la prefactura , integracion con el sif.
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void crearPrefactura(Integer codigoCompania,String userId,Collection<Long> codigoPlanFechaRegistroCobroColParametro) throws SICException ;
	  /**
     * Devuelve cabecera con registros
     * @author amunoz
     * @param codigoCampania
     * @param codigoCompuesto
     * @return
     */
	Collection<PlanFechaRegistroCobroDTO> findRegistroCobroPlanFecha(Long codigoCampania, String codigoCompuesto);
	/**
	 * Cambia el estado a rechazado de todos los registros cobros de estos planes de cobro
	 * @param userId
	 * @param planRegistroSeleccionados
	 * @throws SICException
	 */
	void rechazarRegistroCobro(Integer codigoCampania,String userId,Collection<PlanFechaRegistroCobroDTO> planRegistroSeleccionados) throws SICException ;
	
	/**
	 * Obtener cobros no facturados
	 * @param codigoCompania
	 * @param fecha
	 * @return
	 */
	Collection<Long> obtenerCobrosNoFacturados(Integer codigoCompania, Date fecha);
}
