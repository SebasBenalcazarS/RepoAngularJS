package ec.com.smx.sic.cliente.gestor.convenio;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.sic.cliente.common.convenio.enums.SelecionNegociacionEnum;
import ec.com.smx.sic.cliente.common.convenio.estructura.CampaniaPromocionParticipanteEstructura;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CuentaContableDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionDTO;

public interface INegociacionGestor {

//	Collection<DetalleNegociacionDTO> findNegociacionesByCampania(Integer codigoCompania,Long codigoCampania);


	/**
	 * Metodo de INegociacionGestor.java, utilizado para
	 * khidalgo
	 * 28/1/2015
	 * @param codigoCompania
	 * @param codigoGestionPrecio
	 * @return
	 * NegociacionDTO
	 */
	NegociacionDTO findNegociacionByGestionPrecio(Integer codigoCompania, Long codigoGestionPrecio);
	
	
	/**
	 * Metodo de INegociacionGestor.java, utilizado para
	 * khidalgo
	 * 28/1/2015
	 * @return
	 * Collection<CuentaContableDTO>
	 */
	Collection<CuentaContableDTO> findCuentasContablesNegociacion();

	/**
	 * Metodo de INegociacionGestor.java, utilizado para
	 * khidalgo
	 * 28/1/2015
	 * @param codigoCompania
	 * @param codigoParticipacion
	 * @return
	 * NegociacionDTO
	 */
	NegociacionDTO findNegociacionPorParticipante(Integer codigoCompania, Long codigoParticipacion); 
	
	/**
	 * @author khidalgo
	 * @param negociacionDTO
	 * @param usuarioAuditoria
	 */
	void registrarNegociacion(NegociacionDTO negociacionDTO,CampaniaPromocionParticipanteEstructura campaniaPromocionParticipanteEstructura,GestionPrecioDTO promocion,Integer codigoCompania, String idUsuarioAuditoria);
	
	/**
	 * Metodo que registra la negociacion cuando existe algun detalle es estado Rechazado
	 * @param campaniaGeneral
	 * @param negociacionDTO
	 * @param campaniaPromocionParticipanteEstructura
	 * @param campaniaPromocionParticipante
	 * @param gestionPrecioRelacionSeleccionado
	 * @param codigoCompania
	 * @param idUsuarioAuditoria
	 * @throws SICException
	 */
	void registrarNegociacionConRechazo(GestionPrecioDTO campaniaGeneral,NegociacionDTO negociacionDTO,CampaniaPromocionParticipanteEstructura campaniaPromocionParticipanteEstructura,Object campaniaPromocionParticipante,GestionPrecioRelacionDTO gestionPrecioRelacionSeleccionado,Integer codigoCompania, String idUsuarioAuditoria) throws SICException;
	/**
	 * Metodo de INegociacionGestor.java, utilizado para
	 * aquingaluisa
	 * 28/1/2015
	 * @param gestionPrecioDTOParametro
	 * @param selecionNegociacionEnum
	 * @param codigoSeleccion
	 * @return
	 * CampaniaPromocionParticipanteEstructura
	 */
	CampaniaPromocionParticipanteEstructura obtenerEstructuraInvolucradosCambiosExistentes(GestionPrecioDTO gestionPrecioDTOParametro,SelecionNegociacionEnum selecionNegociacionEnum,Long codigoSeleccion);
	
	/**
	 * Metodo de INegociacionGestor.java, utilizado para
	 * khidalgo
	 * 28/1/2015
	 * @param campania
	 * @param tieneActivarCampania
	 * @param usuarioAuditoria
	 * void
	 */
	void actualizarCampaniaParticipantesConfigurados(GestionPrecioDTO campania,Boolean tieneActivarCampania,String usuarioAuditoria);
	
	
	/**
	 * Metodo de INegociacionGestor.java, utilizado para eliminar los registros de la negociacion fisicamente
	 * @author srodriguez
	 * 30/1/2015
	 * @param negociacionDTO
	 * void
	 */
	void eliminarRegistrosDetalleNegociacionFisico(NegociacionDTO negociacionDTO);
	
	
	/**
	 * Metodo de INegociacionGestor.java, utilizado para eliminar un detalle de negociacion fisicamente
	 * @author srodriguez
	 * 2/2/2015
	 * @param detalleNegociacionDTO
	 * void
	 */
	void eliminarRegistrosDetalleNegociacionFisico(DetalleNegociacionDTO detalleNegociacionDTO);
	
	
	/**
	 * Metodo de INegociacionGestor.java, utilizado para eliminar un detalle de negociacion fisicamente
	 * @author srodriguez
	 * 4/2/2015
	 * @param companyId
	 * @param codigoNegociacion
	 * void
	 */
	void eliminarDetallesNegociacionFisico(Integer companyId,Long codigoNegociacion);
	
	
	/** Metodo registrarNegociacion, utilizado para registrar la negociacion y su integracion con Loyalty
	 * @author srodriguez
	 * 27/2/2015
	 * @param negociacionDTO
	 * @param campaniaPromocionParticipanteEstructura
	 * @param campaniPromocionParticipante
	 * @param codigoCompania
	 * @param idUsuarioAuditoria
	 * @param eliminarDetalles
	 * @return void
	 */
	void registrarNegociacion(Collection<GestionPrecioDTO> campaniaGeneralCol, GestionPrecioDTO campaniaGeneral,NegociacionDTO negociacionDTO,CampaniaPromocionParticipanteEstructura campaniaPromocionParticipanteEstructura,Object campaniaPromocionParticipante,GestionPrecioRelacionDTO gestionPrecioRelacionSeleccionado,Integer codigoCompania, String idUsuarioAuditoria);
	
	/**
	 * Metodo para los detalles de negociacion para guardar
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @return
	 */
	DetalleNegociacionGestionPrecioCovenioParticipanteDTO obtenerDatosNegociacionRegistroFecha(Integer codigoCompania, Long codigoGestionPrecioPromocion);
	
	/**
	 * Metodo que consulta las fechas y valores de cobros
	 */
	Collection<Long> obtenerCodigoDetNegGesPreConParDeFechasFaltantes(Long codigoPromocion,Integer codigoCompania);
	
	/**
	 * Metodo para eliminar los detalles de registro cobro modo cascada
	 * @param codigoCompania
	 * @param codigoNegociacion
	 * @param codigoNegociacionGePreParticipante
	 */
	 void eliminarDetallesRegistroCobroFisico(Integer codigoCompania,Long codigoNegociacion,Long codigoNegociacionGePreParticipante);
	 
	 /**
	  * Metodo para validar si el  el nodo enviado o sus hijos tienen algun registro de cobro
	  * @param gestionPrecioDTOParametro
	  * @param selecionNegociacionEnum
	  * @param codigoSeleccion
	  * @return
	  * @throws SICException
	  */
	 Boolean tieneRegistroCobroDetalleGestionPrecioParticipante(GestionPrecioDTO gestionPrecioDTOParametro,SelecionNegociacionEnum selecionNegociacionEnum,Long codigoSeleccion)throws SICException;
	
	 /**
	  * Metodo que activa la promocion del webservice controlado dentro de un try catch
	  * @param codigoPromocionReferencia
	  * @param estado
	  * @return
	  */
	 Boolean activarPromocionWS(String codigoPromocionReferencia,	Boolean estado);
	 
	/**
	 * Obtiene la utima fecha de cobro
	 * @param codDetNegGesPreConPar
	 * @return
	 */
	 HashMap<Long, Date> obtenerFechasCobroRegistradasByCodDetNegociacion(Collection<Long> codDetNegGesPreConParCols);

	 /** Metodo generarDatosPlanCobro, utilizado para calcular las fechas de cobro para cada uno de los detalles de un participante
	 * @param promocion
	 * @param detalleNegociacionDTO
	 * @param detalleNegociacionGestionPrecioCovenioParticipanteDTO
	 * @return void
	 */
	 void generarDatosPlanCobroMejorado(Integer companyId, String userId, Date fechaACobrar);
	
	 
	 Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> findDetalleNegociacionGesPreConParPendientePorGenerarFechas(Integer codigoCompania);
}
