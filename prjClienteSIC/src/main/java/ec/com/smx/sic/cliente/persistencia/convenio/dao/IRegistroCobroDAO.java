/** ec.com.smx.sic.cliente.persistencia.convenio.dao
 * IRegistroCobroDAO.java
 * @author srodriguez
 * 23/2/2015
 */
package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.ArrayList;
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
import ec.com.smx.sic.cliente.mdl.dto.VistaRegistroCobroConvenioParticiapanteDTO;

/**
 * @author srodriguez
 *
 */
public interface IRegistroCobroDAO {
	/** Metodo persistirRegistroCobro, utilizado para registrar o actualizar los registros de cobro
	 * @author srodriguez
	 * 23/2/2015
	 * @param registroCobroDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirRegistroCobro(RegistroCobroDTO registroCobroDTO,Integer companyId, String userId);
	
	
	/** Metodo persistirRegistroCobroDetalle, utilizado para persistir los detalles
	 * @author srodriguez
	 * 23/2/2015
	 * @param registroCobroDetalleDTO
	 * @param companyId
	 * @param userId
	 * @return void
	 */
	void persistirRegistroCobroDetalle(RegistroCobroDetalleDTO registroCobroDetalleDTO,Integer companyId, String userId);
	
	
	/** Metodo findRegistroCobroDTO, utilizado para encontrar el registro de cobro expecifico
	 * @author srodriguez
	 * 23/2/2015
	 * @param companyId
	 * @param codigoRegistroCobro
	 * @return
	 * @return RegistroCobroDTO
	 */
	RegistroCobroDTO findRegistroCobroDTO(Integer companyId, Long codigoRegistroCobro);
	
	
	/** Metodo findRegistroCobroPorNegociacionGestionPrecioConvenioParticipante, utilizado para encontrar el registro de cobro expecifico por NegociacionGestionPrecioConvenioParticipante
	 * @author srodriguez
	 * 23/2/2015
	 * @param companyId
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 * @return RegistroCobroDTO
	 */
	RegistroCobroDTO findRegistroCobroPorNegociacionGestionPrecioConvenioParticipante(Integer companyId, Long codigoNegociacionGestionPrecioConvenioParticipante);
	
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
	 * Metodo para obtner una vista java todos los cobros de un participante que no  se a integrado con el SIF
	 * @return
	 * @throws SICException
	 */
	Collection<VistaRegistroCobroConvenioParticiapanteDTO> obtenerRegistroCobroParticipantesPendientesPorIntegrar(Integer codigoCompania) throws SICException;
	
    void  actualizarRegistroCobroPreFacturado(Integer codigoCompania,String idUsuario,Collection<Long> codigoRegistroCobroCol,String numeroDocumentoSIF,String valorError,Integer tipoError);
    
    /**
	 * Metodo para obtner una vista java con las relaciones de FechaRegistroCobro
	 */
    Collection<VistaRegistroCobroConvenioParticiapanteDTO> obtenerVistaPlanFechaRegistroCobroParaFacturacion(Integer codigoCompania,Collection<Long> codigoPlanFechaRegistroCobroCol)  throws SICException;
    
    /**
     * Devuelve cabecera con registros
     * @author amunoz
     * @param codigoCampania
     * @param codigoCompuesto
     * @return
     */
	Collection<PlanFechaRegistroCobroDTO> findRegistroCobroPlanFecha(Long codigoCampania, String codigoCompuesto);
	/**
	 * Devuelve hijos RegistroCobro
	 * @param codigoCampania
	 * @param codigoPlanFechaRegistroCobro
	 * @return
	 */
	Collection<RegistroCobroDTO> findRegistroCobroProveedoresPlanFecha(ArrayList<Long> codigoPlanFechaRegistroCobroCol);
	
	/**
	 * Cambia el estado a rechazado de todos los registros cobros de estos planes de cobro
	 * @param userId
	 * @param planRegistroSeleccionados
	 * @throws SICException
	 */
	void actualizarEstadoRegistroCobro(String userId,Collection<RegistroCobroDTO> planRegistroSeleccionados,String valorEstado,Integer tipoEstado) throws SICException ;
	
	/**
	 * Cambia el estado a rechazado de todos los registros cobros de estos planes de cobro por detalle negociacion y negociaciongestionPrecionConvenioParticupante.
	 */
	void actualizarEstadoRegistroCobro(Integer codigoCompania,String userId, Collection<Long> codigoRegistroCobro, String valoEstadoCobro,Integer tipoEstadoCobro) throws SICException ;
	
	/**
	 * Metodo para buscar Registros  mediante el detNegGesPreConPar
	 * @param companyId
	 * @param codigoDetNegGesPreConPar
	 * @return
	 */
	 Collection<RegistroCobroDTO> findRegistroCobroPorDetNegGesPreConPart(Integer companyId,Long codigoDetNegGesPreConPar);
	 
	 /**
	 * Actualizar registro cobro diario a rechazado
	 * @param codigoCompania
	 * @param codDetNegGesPreConPar
	 * @param userId
	 */
	void actualizarRegistroCobroDiarioRechazado(Integer codigoCompania, Long codDetNegGesPreConPar, String userId);
	
	/**
	 * Obtener cobros no facturados
	 * @param codigoCompania
	 * @param fecha
	 * @return
	 */
	Collection<Long> obtenerCobrosNoFacturados(Integer codigoCompania, Date fecha);
	
}
