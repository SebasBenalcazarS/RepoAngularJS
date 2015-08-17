package ec.com.smx.sic.cliente.gestor.articulo.tareaprogramada;
/**
 * 
 */



import java.util.Collection;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.integration.service.IntegrationServiceI;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author jmontenegro
 *
 */
public interface IArticuloTareaProgramadaGestor {
	
	/**
	 * Permite iniciar o finalizar el alcance de los articulos cuya fecha se haya programado
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public void activarDesactivarArticulosAlcance(Integer codigoCompania, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * Migracion de articulo area trabajo
	 * @param url
	 * @throws SICException
	 */
	public void migracionArticuloAreaTrabajo(String url)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void enviarArticulosPendientesAlSIC(Integer codigoCompania) throws SICException;

	void enviarArticulosPendientesEdicionMasivaAlSIC(Integer codigoCompania) throws SICException;

	void enviarArticulosPendientesCreacionMasivaAlSIC(Integer codigoCompania) throws SICException;
	
	void enviarArticulosPendientesActualizacionArchivoAlSIC(Integer codigoCompania) throws SICException;
	
	void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException;
	
	void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	void enviarErroresIntegracionSIC(Integer codigoCompania)throws SICException;
	
//	/**
//	 * Metodo para integrar las condiciones comerciales de los articulos al SIC
//	 * @param codigoCompania
//	 * @param valorTipoProceso
//	 * @throws SICException
//	 * @author eharo
//	 */
//	void enviarArticulosPendientesPorProcesoAlSIC(final Integer codigoCompania, final String valorTipoProceso) throws SICException;
		
	Collection<ArticuloPendienteIntegracionDTO> obtenerArticuloPendientesIntegracion(Integer codigoCompania, String valorTipoProceso) throws SICException;
	
	void transferirArticuloSICAsincrona(Integer codigoCompania, ArticuloDTO articuloPlantilla, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol, ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO, MultiKeyMap multiKey, IntegrationServiceI integrationServiceI, ArticuloVO vo, ArticuloLocalDTO al, ArticuloProveedorDTO apFiltro, RelacionArticuloRegistroSanitarioDTO ars) throws SICException;
	
	void enviarArticulosPendientesActualizacionCondicionesComercialesAlSIC(Integer codigoCompania) throws SICException;
	
	/**
	 * Permite resolver las inconsistencias de articulos relacionados a cupon que no tienen estructura comercial de cliente relacionada
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @throws SICException
	 */
	public void resolverInconsistenciasArticuloRelacionadoCupon(Integer codigoCompania, Integer numeroEjecucion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoEstado
	 * @param habilitaFechaCreacion
	 * @param codigoLineaComercial 
	 */
	public void invalidarArticulosFecha(Integer codigoCompania,String codigoEstado, Integer habilitaFechaCreacion,String codigoLineaComercial);

}
