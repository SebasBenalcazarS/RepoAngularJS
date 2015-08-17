/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;

/**
 * @author gaortiz
 *
 */
@SuppressWarnings("serial")
public class ProveedorFiltroRestriction implements CriteriaRestriction {

	/* (non-Javadoc)
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	String alias;
	
	public ProveedorFiltroRestriction()
	{
		this.alias=null;		
	}
	
	public ProveedorFiltroRestriction(String alias)
	{
		this.alias=alias;		
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		//and
		Conjunction conjunctionIsPersona = Restrictions.conjunction(); 
		Conjunction conjunctionIsLocalizacion = Restrictions.conjunction(); 
		if(alias==null)
		{
			conjunctionIsPersona.add(Restrictions.isNull("codigoPersona"));
			conjunctionIsPersona.add(Restrictions.isNotNull("codigoLocalizacionProveedor"));
			
			
			conjunctionIsLocalizacion.add(Restrictions.isNull("codigoLocalizacionProveedor"));
			conjunctionIsLocalizacion.add(Restrictions.isNotNull("codigoPersona"));
		}
		else
		{
			conjunctionIsPersona.add(Restrictions.isNull(this.alias + ".codigoPersona"));
			conjunctionIsPersona.add(Restrictions.isNotNull(this.alias + ".codigoLocalizacionProveedor"));
			
			
			conjunctionIsLocalizacion.add(Restrictions.isNull(this.alias + ".codigoLocalizacionProveedor"));
			conjunctionIsLocalizacion.add(Restrictions.isNotNull(this.alias + ".codigoPersona"));
			
		}
		
		//or
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(conjunctionIsPersona);
		disjunction.add(conjunctionIsLocalizacion);
		return disjunction;
	}

}
