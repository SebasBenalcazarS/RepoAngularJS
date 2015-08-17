package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.FuncionarioRelacionadoDTO;

/**
 * @author gnolivos
 */

@SuppressWarnings("serial")

public class ProveedorFunRelRestriction implements CriteriaRestriction {

	private Integer codigoCompania;
	private String codigoFuncionario;
	
	public ProveedorFunRelRestriction(Integer codigoCompania, String codigoFuncionario){
		this.codigoCompania = codigoCompania;
		this.codigoFuncionario = codigoFuncionario;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelect;
	
	subSelect = DetachedCriteria.forClass(FuncionarioRelacionadoDTO.class,"ALIAS_FUNREL");
	
	subSelect.setProjection(Projections.property("ALIAS_FUNREL.id.codigoFuncionarioRelacionado"));
	
	subSelect.add(Restrictions.eq("ALIAS_FUNREL.id.codigoCompania", this.codigoCompania));
	subSelect.add(Restrictions.eq("ALIAS_FUNREL.id.codigoFuncionario", this.codigoFuncionario));
	subSelect.add(Restrictions.ne("ALIAS_FUNREL.id.codigoFuncionarioRelacionado", this.codigoFuncionario));			
	
	return Subqueries.propertyIn("codigoFuncionario", subSelect);
}		

	
	
	

}
