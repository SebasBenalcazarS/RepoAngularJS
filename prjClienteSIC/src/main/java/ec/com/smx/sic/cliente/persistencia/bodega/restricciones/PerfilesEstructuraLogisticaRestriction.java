/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.PerfilDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
public class PerfilesEstructuraLogisticaRestriction implements CriteriaRestriction {
	
	private String referenceCode;
	
	public PerfilesEstructuraLogisticaRestriction(String referenceCode){
		this.referenceCode = referenceCode;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try{
			DetachedCriteria subSelectPerfilEstructuraLogistica = DetachedCriteria.forClass(PerfilDTO.class, "perfilEstructuraLogistica");
			subSelectPerfilEstructuraLogistica.setProjection(Projections.property("id.profileId"));
			subSelectPerfilEstructuraLogistica.add(Restrictions.eq("perfilEstructuraLogistica.referenceCode", this.referenceCode));
			criterion = Subqueries.propertyIn("profileParentId", subSelectPerfilEstructuraLogistica);
		}catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricción por perfilEstructuraLogistica");
		}
		return criterion;
	}

}
