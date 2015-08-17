package ec.com.smx.sic.cliente.persistencia.articulos.restricciones.estructuracomercial;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;

@SuppressWarnings("serial")
public class ClasificacionSubClasificacionRestriction extends BaseCriteriaRestriction{

	private Collection<ClasificacionDTO> clasificacionesSeleccionadas;	
	private String alias;

	public ClasificacionSubClasificacionRestriction(Collection<ClasificacionDTO> clasificacionesSeleccionadas, String alias){
		this.clasificacionesSeleccionadas = clasificacionesSeleccionadas;
		this.alias = alias;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Criterion getCriteriaRestriction() {
		//and
		Conjunction conjunctionIsClasificacion = Restrictions.conjunction(); 
		Disjunction disjunction = Restrictions.disjunction();
		Collection<String> codigosClasificaciones = null;
		
		if(CollectionUtils.isNotEmpty(clasificacionesSeleccionadas))
		{
			//recupero solo las clasificaciones sin subclasificaciones
			Collection<ClasificacionDTO> clasificaciones = CollectionUtils.select(this.clasificacionesSeleccionadas, PredicateUtils.transformedPredicate(
					new GetInvokerTransformer("npSubclasificacion"), PredicateUtils.equalPredicate(null)));

			//recupero las clasificaciones con subclasificaciones
			Collection<ClasificacionDTO> clasificacionesConSubClasificaciones = CollectionUtils.select(this.clasificacionesSeleccionadas, PredicateUtils.transformedPredicate(
					new GetInvokerTransformer("npSubclasificacion"), PredicateUtils.notNullPredicate()));

			if (CollectionUtils.isNotEmpty(clasificaciones)) {
				codigosClasificaciones = CollectionUtils.collect(clasificaciones, new GetInvokerTransformer("id.codigoClasificacion"));
				conjunctionIsClasificacion.add(Restrictions.in(this.alias.concat("codigoClasificacion"), codigosClasificaciones));
			}

			if(CollectionUtils.isNotEmpty(clasificacionesConSubClasificaciones)){
				Conjunction conjunctionFinal = Restrictions.conjunction(); 
				if (CollectionUtils.isNotEmpty(codigosClasificaciones)) {
					disjunction.add(conjunctionIsClasificacion);
				}
				
				for (ClasificacionDTO clasificacion : clasificacionesConSubClasificaciones) {					
					Conjunction conjunctionIsSubClasificacion = Restrictions.conjunction(); 
					conjunctionIsSubClasificacion.add(Restrictions.eq(this.alias.concat("subClasificacionDTO.id.codigoClasificacion"), clasificacion.getId().getCodigoClasificacion()));

					Collection<String> subClasificaciones = CollectionUtils.collect(clasificacion.getNpSubclasificacion(), new GetInvokerTransformer("id.codigoSubClasificacion"));
					conjunctionIsSubClasificacion.add(Restrictions.in(this.alias.concat("subClasificacionDTO.id.codigoSubClasificacion"), subClasificaciones));

					//OR
					disjunction.add(conjunctionIsSubClasificacion);
				}
				return conjunctionFinal.add(disjunction);
			}
		}
		return conjunctionIsClasificacion;
	}
}
