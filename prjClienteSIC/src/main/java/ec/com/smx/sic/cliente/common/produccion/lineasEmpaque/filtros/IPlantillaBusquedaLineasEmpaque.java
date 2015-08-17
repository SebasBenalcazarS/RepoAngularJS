package ec.com.smx.sic.cliente.common.produccion.lineasEmpaque.filtros;

import java.io.Serializable;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;

public interface IPlantillaBusquedaLineasEmpaque extends Serializable {

	@SuppressWarnings("rawtypes")
	public HashMap<String, CriteriaSearchParameter> getMapaCriteriaSearch();

	public HashMap<String, BaseCriteriaRestriction> getMapaBaseCriteriaRestriction();

	public String getUserId();
	
	public Integer getCompaniaId();
		
	public String getSistemaOrigen();
	
}
