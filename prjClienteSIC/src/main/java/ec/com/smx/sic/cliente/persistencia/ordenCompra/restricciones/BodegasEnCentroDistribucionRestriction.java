/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.Collection;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class BodegasEnCentroDistribucionRestriction implements CriteriaRestriction{
	private Collection<Integer> codigoAreaTrabajoCD = null;
	private String pattern = null;
	
	public BodegasEnCentroDistribucionRestriction(Collection<Integer> codigoAreaTrabajoCD, String pattern){
		super();
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
		this.pattern = pattern;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		
		try{
			DetachedCriteria subSelectBodegas = DetachedCriteria.forClass(AreaSublugarTrabajoDTO.class, "areaSublugarTrabajo");
			subSelectBodegas.setProjection(Projections.property("areaSublugarTrabajo.id.codigoAreaSublugarTrabajo"));
			subSelectBodegas.add(Restrictions.in("areaSublugarTrabajo.id.codigoAreaTrabajo", codigoAreaTrabajoCD));
			subSelectBodegas.add(Restrictions.eq("areaSublugarTrabajo.tipoRelacionValor", CorporativoConstantes.TIPO_RELACION_JERARQUIA_AREA_TRABAJO));
			subSelectBodegas.add(Restrictions.eq("areaSublugarTrabajo.estado", Boolean.TRUE));

			return Subqueries.propertyIn(this.pattern, subSelectBodegas);
			
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
	}
}
