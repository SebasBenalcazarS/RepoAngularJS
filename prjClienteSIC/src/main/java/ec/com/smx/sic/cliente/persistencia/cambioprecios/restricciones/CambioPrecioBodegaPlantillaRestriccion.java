/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaBodega;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class CambioPrecioBodegaPlantillaRestriccion extends BasePlantillaCriteriaRestriction<PlantillaBusquedaBodega>{

	String alias;
	
	public CambioPrecioBodegaPlantillaRestriccion(PlantillaBusquedaBodega plantillaBusqueda, String alias) {
		super(plantillaBusqueda);
		this.alias = alias;
	}

	@Override
	protected Criterion construirCriteriaRestriction() {
		
		DetachedCriteria subSelectBodegaCambioPrecio;
		DynamicCriteriaRestriction dynamicParametersFiltersBodega = new DynamicCriteriaRestriction();
		
		subSelectBodegaCambioPrecio = DetachedCriteria.forClass(ClasificacionDTO.class, SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);
		subSelectBodegaCambioPrecio.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoClasificacion"));
		
		//Parametros por defecto
		subSelectBodegaCambioPrecio.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoCompania", super.getPlantillaBusqueda().getCodigoCompania()));
		subSelectBodegaCambioPrecio.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		
		// Join ClasificacionDTO - BodegaDTO
		subSelectBodegaCambioPrecio.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".bodegaDTO", SearchManagerConstants.getInstance().ALIAS_SUBBODEGA);
		
		// Asignacion de criterion en codigoBodega
		if (super.getPlantillaBusqueda().getCodigoBodega() != null){
			dynamicParametersFiltersBodega.add(super.getPlantillaBusqueda().getCodigoBodega().getCriteriaRestriction(), 
					super.getPlantillaBusqueda().getCodigoBodega().getBooleanClauseEnum());
		}
		
		// Asignacion de criterion con descripcionBodega
		if(super.getPlantillaBusqueda().getDescripcionBodega() != null){
			dynamicParametersFiltersBodega.add(super.getPlantillaBusqueda().getDescripcionBodega().getCriteriaRestriction(),
					super.getPlantillaBusqueda().getDescripcionBodega().getBooleanClauseEnum());
		}
		
		if(dynamicParametersFiltersBodega.isNotEmptyCriteriaRestriction())
			subSelectBodegaCambioPrecio.add(dynamicParametersFiltersBodega.getCriteriaRestriction());
		
		return Subqueries.propertyIn(alias, subSelectBodegaCambioPrecio);
	}

}
