/** ec.com.smx.sic.cliente.servicio.convenio.cobros
 * IRegistroCobroServicio.java
 * @author srodriguez
 * 23/2/2015
 */
package ec.com.smx.sic.cliente.servicio.convenio.cobros;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.PlanFechaRegistroCobroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCobroProveedoresDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaParticipantesDTO;

/**
 * @author srodriguez
 *
 */
public interface IRegistroCobroServicio {

	/** Metodo transPersistirRegistroCobro, utilizado para persistir una negociacion
	 * @author srodriguez
	 * 23/2/2015
	 * @param registroCobroDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void transPersistirRegistroCobro(RegistroCobroDTO registroCobroDTO,Integer companyId, String userId);
	
	/**
	 * MEtodo para obtener la lista de cobro a proveedores
	 * @return
	 */
	Collection<VistaCobroProveedoresDTO> findDatosCobroProveedores(Long codigoCampania, String codigoCompuesto);
	  /**
     * Devuelve cabecera con registros
     * @author amunoz
     * @param codigoCampania
     * @param codigoCompuesto
     * @return
     */
	Collection<PlanFechaRegistroCobroDTO> findRegistroCobroPlanFecha(Long codigoCampania, String codigoCompuesto);
	/**
	 * Devuelve los datos de una campaña 
	 * @param codigoCampania
	 * @param codigoReferencia
	 * @return
	 */
	GestionPrecioDTO findDatosCampaniabyCodigos(Long codigoCampania, String codigoReferencia);
	
	/**
	 * MEtodo para obtener la lista de participantes por campania
	 * @return
	 */
	Collection<VistaParticipantesDTO> findParticipantesByCampania(Long codigoCampania, String codigoReferencia);
	/**
	 * Obtiene la lista de campanias
	 * @param codigoCampaniLoyalty
	 * @param nombreCampania
	 * @return
	 */
	Collection<GestionPrecioDTO> findCampaniasByCodigoNombre(String codigoCampaniLoyalty, String nombreCampania);
	
	/**
	 * Devuelve los datos de las campanias por participantes 
	 * @param vistaEmpresaParticipanteDTO
	 * @return
	 */
	Collection<GestionPrecioDTO> findDatosCampaniabyParticipante(VistaEmpresaParticipanteDTO vistaEmpresaParticipanteDTO);
	
	void crearPrefactura(Integer codigoCompania,String userId,Long codigoConcepto,String codigoCentroCosto) throws SICException ;
	
	/**
	 * Crear la prefactura , integracion con el sif.
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	public void trasCrearPrefactura(Integer codigoCompania,String userId,Collection<Long> codigoPlanFechaRegistroCobroColParametro) throws SICException ;
	/**
	 * Cambia el estado a rechazado de todos los registros cobros de estos planes de cobro
	 * @param userId
	 * @param planRegistroSeleccionados
	 * @throws SICException
	 */
	public void transRechazarRegistroCobro(Integer codigoCompania,String userId,Collection<PlanFechaRegistroCobroDTO> planRegistroSeleccionados) throws SICException ;
}
