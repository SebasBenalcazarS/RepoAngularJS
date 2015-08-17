/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class ClasesPorProcesoClaseRestriction implements CriteriaRestriction{
	
	private String propertyIn = null;
	private Long codigoProceso = null;
	
	public ClasesPorProcesoClaseRestriction(String propertyIn, Long codigoProceso){
		this.propertyIn = propertyIn;
		this.codigoProceso = codigoProceso;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		
		try{
			DetachedCriteria subSelectProCla = DetachedCriteria.forClass(ProcesoClaseDTO.class, "procesoClase");
			subSelectProCla.setProjection(Projections.property("procesoClase.id.codigoClaseArticulo"));
			
			subSelectProCla.add(Restrictions.eq("procesoClase.id.codigoProceso", this.codigoProceso));
			
			criterion = Subqueries.propertyIn(this.propertyIn, subSelectProCla);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}
	
}
