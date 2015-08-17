package ec.com.smx.sic.articulo.servicio;

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
import ec.com.smx.sic.cliente.gestor.articulo.impresionEtiquetas.IArticuloSolicitudImpresionEtiquetasGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloSolicitudImpresionEtiquetasServicio;

public class ArticuloSolicitudImpresionEtiquetasServicio implements IArticuloSolicitudImpresionEtiquetasServicio {
	IArticuloSolicitudImpresionEtiquetasGestor articuloSolicitudImpresionEtiquetasGestor;
	
	@Override
	public PrintRequestDTO buscarSolicitud(PrintRequestID printRequestID) throws SICException{
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarSolicitud(printRequestID);
	}
	
	public SearchResultDTO<PrintRequestDTO> buscarSolicitudImpresionPaginados(PrintRequestDTO printRequestDTOPlantilla) throws SICException{
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarSolicitudImpresionPaginados(printRequestDTOPlantilla);
	}
	
	@Override
	public Collection<String> buscarArticulosPorCodigoRefencia(String codigoReferenciaExterna,Integer codigoCompania){
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarArticulosPorCodigoRefencia(codigoReferenciaExterna, codigoCompania);
	}
	
	@Override
	public Collection<String> buscarArticulosPorCodigoBarras(String codigoBarras,Integer codigoCompania){
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarArticulosPorCodigoBarras(codigoBarras, codigoCompania);
	}
	
	@Override
	public SearchResultDTO<EstructuraArticuloSolImpresion> buscarArticulosporFiltros(ArticuloDTO articuloPlantillaBusqueda)throws SICException{
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarArticulosporFiltros(articuloPlantillaBusqueda);
	}
	
	@SuppressWarnings("rawtypes")
	public void generarRestricicionesBusquedaArticulos(ArticuloDTO articuloPlantilla,HashMap<String, CriteriaSearchParameter> mapCriteriaSearchParameter,HashMap<String, BaseCriteriaRestriction> mapaBaseCriteriaRestriction,Integer codigoCompoania)throws SICException{
		this.articuloSolicitudImpresionEtiquetasGestor.generarRestricicionesBusquedaArticulos(articuloPlantilla,mapCriteriaSearchParameter, mapaBaseCriteriaRestriction, codigoCompoania);
	}
	
	public IArticuloSolicitudImpresionEtiquetasGestor getArticuloSolicitudImpresionEtiquetasGestor() {
		return articuloSolicitudImpresionEtiquetasGestor;
	}

	public void setArticuloSolicitudImpresionEtiquetasGestor(IArticuloSolicitudImpresionEtiquetasGestor articuloSolicitudImpresionEtiquetasGestor) {
		this.articuloSolicitudImpresionEtiquetasGestor = articuloSolicitudImpresionEtiquetasGestor;
	}
	
	@Override
	public Collection<EstructuraArticuloProveedorSolImpresion> buscarArticuloProveedorPorIdArticulo(ArticuloID articulioID)throws SICException{
		return this.articuloSolicitudImpresionEtiquetasGestor.buscarArticuloProveedorPorIdArticulo(articulioID);
	}
}
