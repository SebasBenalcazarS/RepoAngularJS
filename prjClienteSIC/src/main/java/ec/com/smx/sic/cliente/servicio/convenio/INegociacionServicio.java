package ec.com.smx.sic.cliente.servicio.convenio;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.sic.cliente.common.convenio.enums.SelecionNegociacionEnum;
import ec.com.smx.sic.cliente.common.convenio.enums.TipoGestionPrecioParticipante;
import ec.com.smx.sic.cliente.common.convenio.estructura.CampaniaPromocionParticipanteEstructura;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CuentaContableDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionGestionPrecioParticipanteDTO;

public interface INegociacionServicio {
	
	
//	Collection<DetalleNegociacionDTO> findNegociacionesByCampania(Integer codigoCompania, Long codigoCampania);

	NegociacionDTO findNegociacionByGestionPrecio(Integer codigoCompania, Long codigoGestionPrecio);

	
	Collection<CuentaContableDTO> findCuentasContablesNegociacion();

	NegociacionDTO findNegociacionPorParticipante(Integer codigoCompania, Long codigoParticipacion);
	
	Collection<NegociacionGestionPrecioParticipanteDTO> findNegociacionGestionPrecioParticipante(Integer companyId, Collection<Long> codigoSecuencias, TipoGestionPrecioParticipante tipo,Boolean relacionConDetNegGesPre);
	
	
	/** Metodo transRegistrarNegociacion, utilizado para persistir la negociacion, sus detalles y la integracion con Loyalty
	 * @author srodriguez
	 * 27/2/2015
	 * @param negociacionDTO
	 * @param campaniaPromocionParticipanteEstructura
	 * @param campaniaPromocionParticipante
	 * @param codigoCompania
	 * @param usuarioAuditoria
	 * @param eliminarDetalles
	 * @return void
	 */
	void transRegistrarNegociacion(Collection<GestionPrecioDTO> campaniaGeneralCol, GestionPrecioDTO campaniaGeneral,NegociacionDTO negociacionDTO,CampaniaPromocionParticipanteEstructura campaniaPromocionParticipanteEstructura,Object campaniaPromocionParticipante,GestionPrecioRelacionDTO gestionPrecioRelacionSeleccionado,Integer codigoCompania, String idUsuarioAuditoria);
	
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
	void transRegistrarNegociacionConRechazo(GestionPrecioDTO campaniaGeneral,NegociacionDTO negociacionDTO,CampaniaPromocionParticipanteEstructura campaniaPromocionParticipanteEstructura,Object campaniaPromocionParticipante,GestionPrecioRelacionDTO gestionPrecioRelacionSeleccionado,Integer codigoCompania, String idUsuarioAuditoria) throws SICException;
	
	/**
	 * Metodo  para obtener la estructura con los datos necesarios necesario para validar lo que se debe guardar 
	 * @param gestionPrecioDTOParametro el arbol visual
	 * @param selecionNegociacionEnum el tipo de seleccion que se realizo
	 * @param codigoSeleccion el codigo id de la seleccion 
	 * @return CampaniaPromocionParticipanteEstructura 
	 */
	CampaniaPromocionParticipanteEstructura obtenerEstructuraInvolucradosCambiosExistentes(GestionPrecioDTO gestionPrecioDTOParametro,SelecionNegociacionEnum selecionNegociacionEnum,Long codigoSeleccion);
	
	/**
	 * 
	 */
	void actualizarCampaniaParticipantesConfigurados(GestionPrecioDTO campania,Boolean tieneActivarCampania,String usuarioAuditoria);
	
	/**
	 * Metodo para los detalles de negociacion para guardar
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @return
	 */
	DetalleNegociacionGestionPrecioCovenioParticipanteDTO findDatosNegociacionRegistroFecha(Integer codigoCompania, Long codigoGestionPrecioPromocion);
	
	/**
	 * Metodo que consulta las fechas y valores de cobros
	 */
	Collection<Long> obtenerCodigoDetNegGesPreConParDeFechasFaltantes(Long codigoPromocion,Integer codigoCompania);
	
	Boolean tieneRegistroCobroDetalleGestionPrecioParticipante(GestionPrecioDTO gestionPrecioDTOParametro,SelecionNegociacionEnum selecionNegociacionEnum,Long codigoSeleccion)throws SICException;
	
	/**
	 * Metodo que activa la promocion del webservice controlado dentro de un try catch
	 * @param codigoPromocionReferencia
	 * @param estado
	 * @return
	 */
	Boolean activarPromocionWS(String codigoPromocionReferencia, Boolean estado);
	
	/**
	 * Obtiene la utima fecha de cobro
	 * @param codDetNegGesPreConPar
	 * @return
	 */
	HashMap<Long, Date> findFechasCobroRegistradasByCodDetNegociacion(Collection<Long> codDetNegGesPreConParCols);
	
	/** Metodo generarDatosPlanCobro, utilizado para calcular las fechas de cobro para cada uno de los detalles de un participante
	 * @param promocion
	 * @param detalleNegociacionDTO
	 * @param detalleNegociacionGestionPrecioCovenioParticipanteDTO
	 * @return void
	 */
	void transGenerarDatosPlanCobroMejorado(Integer companyId, String userId, Date fechaACobrar);
	
	public Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> findDetalleNegociacionGesPreConParPendientePorGenerarFechas(Integer codigoCompania);
}
