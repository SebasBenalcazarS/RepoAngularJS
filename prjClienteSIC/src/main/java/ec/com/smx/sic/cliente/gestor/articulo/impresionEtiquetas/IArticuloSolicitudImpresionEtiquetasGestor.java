package ec.com.smx.sic.cliente.gestor.articulo.impresionEtiquetas;

import java.util.Collection;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.corpv2.etiquetado.modelo.dto.PrintRequestDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.id.PrintRequestID;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloProveedorSolImpresion;
import ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean.EstructuraArticuloSolImpresion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;

/**
 * 
 * @author aquingaluisa
 *
 */
public interface  IArticuloSolicitudImpresionEtiquetasGestor {
	
	/**
	 * Metodo que  busca la solicitud de impresion
	 * @param printRequestID
	 */
	PrintRequestDTO buscarSolicitud(PrintRequestID printRequestID) throws SICException;
	
	/**
	 * Devuelve  las solicitudes de impresion  paginada
	 * @param printRequestDTOPlantilla
	 * @return
	 * @throws SICException
	 */
	
	SearchResultDTO<PrintRequestDTO> buscarSolicitudImpresionPaginados(PrintRequestDTO printRequestDTOPlantilla) throws SICException;
	
	/**
	 * Metodo que devuelbe los codigos de articulo filtrados con like por codigoReferenciaExterna
	 * @param codigoReferenciaExterna
	 * @return
	 */
	Collection<String> buscarArticulosPorCodigoRefencia(String codigoReferenciaExterna,Integer codigoCompania);
	
	/**
	 * Metodo que devuelbe los codigos de articulos filtrados con like por codigoBarras
	 * @param codigoReferenciaExterna
	 * @return
	 */
	Collection<String> buscarArticulosPorCodigoBarras(String codigoBarras,Integer codigoCompania);
	
	/**
	 * Metodo que retorna los articulos encontrados segun los filtros de busqueta utilizados
	 * @param mapCRiterioaSearchParameter
	 * @return
	 */
	SearchResultDTO<EstructuraArticuloSolImpresion> buscarArticulosporFiltros(ArticuloDTO articuloPlantillaBusqueda)throws SICException;;
	
	/**
	 * Metodo que genera las restricciones para la busqueda de articulos
	 * @param mapCriteriaSearchParameter
	 * @param mapaBaseCriteriaRestriction
	 * @throws SICException
	 */
	@SuppressWarnings("rawtypes")
	void generarRestricicionesBusquedaArticulos(ArticuloDTO articuloPlantilla,HashMap<String, CriteriaSearchParameter> mapCriteriaSearchParameter,HashMap<String, BaseCriteriaRestriction> mapaBaseCriteriaRestriction,Integer codigoCompoania)throws SICException;
	
	/**
	 * Metodo que devuelve   una collecion de articulo proveedor  mediante el ID
	 * @param articulioID
	 * @return
	 * @throws SICException
	 */
	public Collection<EstructuraArticuloProveedorSolImpresion> buscarArticuloProveedorPorIdArticulo(ArticuloID articulioID)throws SICException;
		
}
