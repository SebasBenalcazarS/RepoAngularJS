/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO;

/**
 * Agrega restricciones genéricas sobre el objeto <code>ArticuloValorConfiguracionPlantillaDTO</code> dependiendo de las propiedades que se asignen
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class ArticuloValorConfiguracionPlantillaRestriction implements CriteriaRestriction {
	
	private String codigoArticulo;
	
	private String codigoProveedor;
	
	public ArticuloValorConfiguracionPlantillaRestriction() {
		// TODO Auto-generated constructor stub
	}
	
	public ArticuloValorConfiguracionPlantillaRestriction(String codigoArticulo, String codigoProveedor) {
		this.codigoArticulo = codigoArticulo;
		this.codigoProveedor = codigoProveedor;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArticuloValorConfiguracionPlantillaDTO.class);
		detachedCriteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
		detachedCriteria.add(Restrictions.eq("codigoProveedor", codigoProveedor));
		Projection projection = Projections.projectionList().add(Projections.max("fechaRegistro"));
		
		detachedCriteria.setProjection(projection);
		
		return Subqueries.propertyEq("fechaRegistro", detachedCriteria);
		
		//return Subqueries.propertyIn("fechaRegistro", detachedCriteria);
	}
	
}
