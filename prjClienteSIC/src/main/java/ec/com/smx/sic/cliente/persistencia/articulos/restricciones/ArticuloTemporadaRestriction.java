package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import java.util.Date;

import javax.persistence.criteria.JoinType;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;

@SuppressWarnings("serial")
public class ArticuloTemporadaRestriction implements CriteriaRestriction {

	private String patternIn;
	
	public ArticuloTemporadaRestriction(String patternIn) {
		this.patternIn = patternIn;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		Date currentDate = new Date();
		try{
			DetachedCriteria subSelectTempNotVig = DetachedCriteria.forClass(ArticuloTemporadaDTO.class, "articuloTemporada");
			subSelectTempNotVig.setProjection(Projections.property("id.codigoArticulo"));
			subSelectTempNotVig.createAlias("articulo", "articulo", JoinType.INNER.ordinal());
			subSelectTempNotVig.add(Restrictions.eq("id.codigoCompania", 1));
			subSelectTempNotVig.add(Restrictions.eq("articulo.claseArticulo", SICArticuloConstantes.CODIGO_CLASE_ARTICULO_T));	
			
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.gt("fechaInicioTemporada", currentDate));
			disjunction.add(Restrictions.lt("fechaFinTemporada", currentDate));
			subSelectTempNotVig.add(disjunction);
			
//			DetachedCriteria subSelectTempNotVig = DetachedCriteria.forClass(ArticuloTemporadaDTO.class, "articuloTemporada");
//			subSelectTempNotVig.setProjection(Projections.property("id.codigoArticulo"));
//			subSelectTempNotVig.add(Restrictions.eq("id.codigoCompania", 1));
//			subSelectTempNotVig.add(Subqueries.propertyNotIn("id.codigoArticulo", subSelectTempNotVig));
			
			criterion = Subqueries.propertyNotIn(this.patternIn, subSelectTempNotVig);
		}catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n por temporada.");
		}
		return criterion;
	}

}
