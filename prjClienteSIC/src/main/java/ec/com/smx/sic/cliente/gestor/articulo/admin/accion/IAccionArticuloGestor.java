package ec.com.smx.sic.cliente.gestor.articulo.admin.accion;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.integration.service.IntegrationServiceI;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IAccionArticuloGestor {

	/**
	 * Env&iacute;a los datos de una colecci&oacute;n de art&iacute;culos al SIC
	 * @param articulos
	 * @throws SICException
	 */
	void transferirDatosArticuloSIC(Collection<ArticuloVO> articulos, Boolean esAsincrona, Object servicioIntegracion) throws SICException;

	/**
	 * Env&iacute;a los datos de un art&iacute;culo al SIC
	 * @param articulo
	 * @throws SICException
	 */
	void transferirDatosArticuloSIC(ArticuloVO articulo, Boolean esAsincrona, Object servicioIntegracion) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @throws Exception
	 */
	String integrarDatosRecepcionArticuloSIC(Integer codigoCompania, String codigoBarras) throws Exception;
	
	/**
	 * metodo que migra la informacion de articulo portal
	 * @param codigoCompania
	 * @throws SICException
	 */
	void migrarArticulosInformacionPortal(Integer codigoCompania)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException;
	
	/**
	 * @param codigoCompania
	 */
	void enviarErroresIntegracionSIC(Integer codigoCompania);
	
	/**
	 * Metodo que cosulta si un listado
	 * de articulos esta integrado en el SIC
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Boolean consultarExistenciaArticulosIntegrados(Integer codigoCompania, String[] codigoArticulo)throws SICException;
	
	Collection<ArticuloPendienteIntegracionDTO> obtenerArticuloPendientesIntegracion(Integer codigoCompania, String valorTipoProceso) throws SICException;
	
	void transferirDatosArticuloSICAsincrona(Integer codigoCompania, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol)throws SICException;

	void transferirArticuloSICAsincrona(Integer codigoCompania, ArticuloDTO articuloPlantilla, Collection<ArticuloPendienteIntegracionDTO> artPenIntCol, ArticuloPendienteIntegracionDTO articuloPendienteIntegracionDTO, MultiKeyMap multiKey, IntegrationServiceI integrationServiceI, ArticuloVO vo, ArticuloLocalDTO al, ArticuloProveedorDTO apFiltro, RelacionArticuloRegistroSanitarioDTO ars) throws SICException;

	void transferirDatosArticuloProveedorSIC(Integer codigoCompania, Collection<ArticuloPendienteIntegracionDTO> articulosPendientesDeIntegracion)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @param codigosProveedores
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedor(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException;
	
	void transferirDatosArticuloProveedorSIC(Integer codigoCompania, IntegrationServiceI servicioIntegracion, ArticuloPendienteIntegracionDTO dto, Collection<ArticuloPendienteIntegracionDTO> articulos, Collection<ArticuloProveedorDTO> proveedores) throws SICException;

}