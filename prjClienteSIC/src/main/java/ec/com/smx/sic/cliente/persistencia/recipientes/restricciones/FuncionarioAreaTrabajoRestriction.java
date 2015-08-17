package ec.com.smx.sic.cliente.persistencia.recipientes.restricciones;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
/**
 * Restriccion para obtener funcionario por area de trabajo
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class FuncionarioAreaTrabajoRestriction implements CriteriaRestriction{
	private Integer referenceCode;
	private String propertyIn;
	//Constructor
	public	FuncionarioAreaTrabajoRestriction (String propertyIn,
											   Integer referenceCode){
		this.referenceCode = referenceCode;
		this.propertyIn = propertyIn;
	}
	@Override
	public Criterion getCriteriaRestriction() {
		 Criterion criterion = null;
			
			try{
				DetachedCriteria subSelectTipAreTrA = DetachedCriteria.forClass(FuncionarioAreaTrabajoDTO.class, "funcionarioAreaTrabajo");
				subSelectTipAreTrA.setProjection(Projections.distinct(Projections.property("funcionarioAreaTrabajo.id.codigoFuncionario")));
				subSelectTipAreTrA.createAlias("funcionarioAreaTrabajo.areaTrabajoDTO", "areaTrabajo",CriteriaSpecification.INNER_JOIN);
				//subSelectTipAreTrA.add(Restrictions.eq("funcionarioAreaTrabajo.esPorDefecto", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				subSelectTipAreTrA.add(Restrictions.eq("areaTrabajo.codigoReferencia", referenceCode));
				
				criterion = Subqueries.propertyIn(this.propertyIn, subSelectTipAreTrA);
			}catch(Exception e){
				throw new SICException("Se produjo un error al momento de armar la restriccion");
			}
			
		return criterion;
	
	}

}
