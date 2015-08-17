/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaIntegracionRecepcionPalletDetalleDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaDatosLogisticosVO;

/**
 * @author jdvasquez
 *
 */
public interface IAccionIntegracionBodegaRecepcionDAO {

	String obtenerCodigoExternoCatalogoValor(Integer codigoCatalogoTipo, String codigoCatalogoValor) throws SICException;

	Boolean permitirIntegracion(Integer codigoCompania);

	Collection<ArticuloEdicionMasivaDatosLogisticosVO> obtenerDatosLogisticosArticulo(Integer codigoCompania, Collection<ArticuloPendienteIntegracionBodegaDTO> articulosAIntegrar) throws SICException;

	Collection<ArticuloRelacionDTO> obtenerDatosArticuloRelacionRecipiente(Integer codigoCompania, String tipoProcesoIntegracion) throws SICException;

	Collection<ArticuloPendienteIntegracionBodegaDTO> obtenerCodigosArticulosPendientesParaIntegracion(Integer codigoCompania, String tipoProcesoIntegracion);

	Collection<ArticuloRelacionDTO> obtenerArticulosRelacionados(Integer codigoCompania, Set<String> codigoArticulosAIntegrar) throws SICException;

	VistaIntegracionRecepcionPalletDetalleDTO obtenerPalletIntegrar(Integer codigoCompania, Long codigoDatosTarea) throws SICException;

	void eliminarArticulosPendientesIntegracion(Integer codigoCompania, String codigoBarras, Integer valorUnidadManejo, String tipoProcesoIntegracion) throws SICException;

	void actualizarObservacionArticuloPendienteIntegracion(Integer codigoCompania, String codigoBarras, Integer valorUnidadManejo, String tipoProceso, String observacion) throws SICException;

	

}
