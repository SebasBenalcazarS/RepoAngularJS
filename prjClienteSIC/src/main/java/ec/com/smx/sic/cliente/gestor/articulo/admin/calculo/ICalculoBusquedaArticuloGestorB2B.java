package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.common.articulo.filtros.PlantillaFiltrosBusquedaB2B;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface ICalculoBusquedaArticuloGestorB2B {

	public abstract SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException;
	public abstract void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro, PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;
	public abstract Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO, PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;
}