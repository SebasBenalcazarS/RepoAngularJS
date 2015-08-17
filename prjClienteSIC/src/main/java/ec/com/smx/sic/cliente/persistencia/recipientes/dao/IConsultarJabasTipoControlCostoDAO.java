/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.ProcesoCatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecipienteTaraDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.BusquedaRecipienteArticuloTrasient;

/**
 * @author jdvasquez
 *
 */
public interface IConsultarJabasTipoControlCostoDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTipoControlCostosList
	 * @param codigoCatalogoValorTipoPadre
	 * @param codigoValorTipoRelacionado
	 * @return
	 * @throws SICException
	 */
	CatalogoValorRelacionadoDTO obtenerCatalogoValorRelacionado(Integer codigoCompania, String codigoTipoControlCosto, Integer codigoCatalogoValorTipoPadre, Integer codigoValorTipoRelacionado) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTipoControlCostos
	 * @param codigoCatalogoValorTipo
	 * @return
	 * @throws SICException
	 */
	ProcesoCatalogoValorDTO obtenerCatalogoValorProceso(Integer codigoCompania, String codigoTipoControlCostos, Integer codigoCatalogoValorTipo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesosList
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerCodigoArticulosProcesoControlCosto(Integer codigoCompania, Long codigoProceso) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<RecipienteTaraDTO> obtenerJabasConTaraControlCosto(Integer codigoCompania, Collection<String> codigoArticulos) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<BusquedaRecipienteArticuloTrasient> obtenerArticulosJabaRecipiente(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerJabasSinTaraControlCosto(Integer codigoCompania, Collection<String> codigoArticulos) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasRecepcion(Integer codigoCompania, Collection<Long> codigosProcesoLogistico) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerArticulosPorProceso(Integer codigoCompania, Long codigoProceso) throws SICException;

}
