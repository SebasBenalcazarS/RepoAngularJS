/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.bodega.recepcion;

import java.util.Collection;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;

/**
 * @author jvasquez
 *
 */
public interface IPlantillaBusquedaNovedadRecepcion {
	@SuppressWarnings("rawtypes")
	public abstract HashMap<String, CriteriaSearchParameter> getMapaCriteriaSearch();
	
	public Integer getCodigoCompania();
	
	public Integer getFirstResult();

	/**
	 * @param firstResult the firstResult to set
	 */
	public abstract void setFirstResult(Integer firstResult);

	/**
	 * @return the maxResults
	 */
	public abstract Integer getMaxResults();

	/**
	 * @param maxResults the maxResults to set
	 */
	public abstract void setMaxResults(Integer maxResults);

	/**
	 * @return the countAgain
	 */
	public abstract Boolean getCountAgain();

	/**
	 * @param countAgain the countAgain to set
	 */
	public abstract void setCountAgain(Boolean countAgain);
	
	/**
	 * @return the totalRegistros
	 */
	public abstract Integer getTotalRegistros() ;

	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public abstract  void setTotalRegistros(Integer totalRegistros);
	
	public abstract Collection<Long> getCodigosJustificacionesSeleccionadas() ;

//	public abstract void inicializarComponentesBusqueda();
//
//	public abstract boolean agregarFiltrosComponentes();
//
//	public abstract void setCodigosJustificacionesSeleccionadas(Collection collect);
//
//	public abstract Collection<Long> getCodigosJustificacionesSeleccionadas();
}
