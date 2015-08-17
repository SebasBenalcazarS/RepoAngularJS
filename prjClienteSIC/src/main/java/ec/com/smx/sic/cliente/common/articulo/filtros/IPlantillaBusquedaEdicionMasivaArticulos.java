package ec.com.smx.sic.cliente.common.articulo.filtros;

import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;

public interface IPlantillaBusquedaEdicionMasivaArticulos {
	@SuppressWarnings("rawtypes")
	public abstract HashMap<String, CriteriaSearchParameter> getMapaCriteriaSearch();
	
	public abstract HashMap<String, BaseCriteriaRestriction> getMapaBaseCriteriaRestriction();
	
	public abstract Integer getCompaniaId();
	
	public abstract String getSistemaOrigen();
	
	public abstract CriteriaRestriction getRestriccionPorComprador();

	public abstract void setTieneLineaComercial(Boolean tieneLineaComercial);
	
}
