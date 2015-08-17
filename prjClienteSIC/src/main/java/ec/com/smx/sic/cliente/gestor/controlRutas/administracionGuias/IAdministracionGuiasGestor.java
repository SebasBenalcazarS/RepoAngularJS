package ec.com.smx.sic.cliente.gestor.controlRutas.administracionGuias;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ChoferDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoChoferDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoFurgonDTO;
import ec.com.smx.sic.cliente.mdl.vo.LocalizacionFundacionFilialVO;


/**
 * @author egudino
 *
 */

public interface IAdministracionGuiasGestor {
	
	/**
	 * Lista de vehiculos por furgon
	 * @param codigoCompania
	 * @param codigoFurgon
	 * @return
	 * @throws SICException
	 */
	public Collection<VehiculoFurgonDTO> obtenerListaVehiculosporFurgon(Integer codigoCompania, Integer codigoFurgon) throws SICException;
	
	
	/**
	 * Lista de choferes por vehiculo
	 * @param codigoCompania
	 * @param codigoTransportista
	 * @param tipoChofer
	 * @return
	 * @throws SICException
	 */	
//	public Collection<GuiaTransporteDestinoDTO> obtenerListaDestinosporGuia(Integer codigoCompania, Long codigoGuia) throws SICException;
	
	/**
	 * Lista de choferes por transportista
	 * @param codigoCompania
	 * @param codigoTransportista
	 * @param tipoChofer
	 * @return
	 * @throws SICException
	 */
	public Collection<VehiculoChoferDTO> obtenerListaChoferesporTransportista(Integer codigoCompania, Long codigoTransportista) throws SICException;
	
	
	/**
	 * Lista de choferes por vehiculo
	 * @param codigoCompania
	 * @param codigoTransportista
	 * @param tipoChofer
	 * @return
	 * @throws SICException
	 */
	public Collection<VehiculoChoferDTO> obtenerListaChoferesporVehiculo(Integer codigoCompania, Long codigoVehiculo) throws SICException;
	
	/**
	 * Devuelve el chofer por codigo
	 * @param codigoCompania
	 * @param codigoChofer
	 * @return
	 * @throws SICException
	 */
	public ChoferDTO obtenerChoferesporCodigo(Integer codigoCompania, Long codigoChofer) throws SICException;
	
	/**
	 * Lista de proveedores
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroRUC
	 * @param razonSocial
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorDTO> obtenerProveedoresTipo(Integer codigoCompania, Integer codigoJDE, String numeroRUC, String razonSocial) throws SICException;
	
	/**
	 * Devuelve lista de FUNDACIONES O FILIALES 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroRUC
	 * @param razonSocial
	 * @return
	 * @throws SICException
	 */
	public LocalizacionFundacionFilialVO obtenerFundacionFilial(Boolean datosPaginados, Integer firstResult, Integer maxResults, LocalizacionFundacionFilialVO plantillaBusqueda) throws SICException;
	/**
	 * Obtiene area de trabajo por codigo
	 * @param codigoCompania
	 * @param codigoTransportista
	 * @param tipoChofer
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO obtenerAreaTrabajoPorCodigo(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * M�todo que busca la lista de guias dependiendo de la plantilla indicada
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param datosPaginados
	 * @param firstResult
	 * @param maxResults
	 * @param paginadoManual
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
//	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerGuiasPorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario) throws SICException;
	
	/**
	 * Metodo para guardar la pre-guia de transporte
	 * @param guiaTransporteDTO
	 * @param guiaTransporteDestinoCols
	 * @param guiaTransporteDocumentoCols
	 * @throws SICException
	 */
//	public void guardarPreGuia(GuiaTransporteDTO guiaTransporteDTO, Collection<GuiaTransporteDestinoDTO> guiaTransporteDestinoCols, Collection<GuiaTransporteDocumentoDTO> guiaTransporteDocumentoCols) throws SICException;
	
	/**
	 * Crear guia de remision
	 * @param guiaTransporteDTO
	 * @return
	 * @throws SICException
	 */
//	public GuiaTransporteDTO crearGuiaRemision(GuiaTransporteDTO guiaTransporteDTO) throws SICException;
}
