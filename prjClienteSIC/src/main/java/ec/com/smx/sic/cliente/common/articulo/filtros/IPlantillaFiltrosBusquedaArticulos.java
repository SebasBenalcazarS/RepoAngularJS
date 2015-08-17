package ec.com.smx.sic.cliente.common.articulo.filtros;

import java.io.Serializable;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloRegistroSanitarioPlantillaRestriction;

/**
 * Interfaz que es utilizada para la asignacion de filtros desde la lnArticulo.
 * @author mgranda
 * @since 02/05/2013
 * @version 1.0
 *
 */
public interface IPlantillaFiltrosBusquedaArticulos extends Serializable {

	@SuppressWarnings("rawtypes")
	public abstract HashMap<String, CriteriaSearchParameter> getMapaCriteriaSearch();

	public abstract HashMap<String, BaseCriteriaRestriction> getMapaBaseCriteriaRestriction();

	public abstract CriteriaRestriction getRestriccionPorComprador();
	
	public abstract Boolean getCreadosPorUsuario();	
	
	public abstract String getUserId();
	
	public abstract Integer getCompaniaId();
		
	public abstract String getSistemaOrigen();
	
	public abstract CriteriaRestriction getRestriccionPorArticuloProveedor();
	
	public abstract ArticuloRegistroSanitarioPlantillaRestriction getArticuloRegistroSanitarioPlantillaRestriction();
	
}