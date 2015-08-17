/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;

/**
 * Filtro para buscar el mismo valor sobre los campos codigoJDEProveedor, nombreProveedor, razonSocialProveedor de la entidad VistaProveedorDTO 
 * 
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class ProveedorCodigoNombreRestriction implements CriteriaRestriction {
	/**
	 * the codigoNombreProveedor filter value
	 */
	private String codigoNombreProveedor;
	
	/**
	 * Alias VistaProveedorDTO
	 */
	private String propertyAliasVistaProveedor;
	
	/**
	 * 
	 * @param codigoNombreProveedor
	 */
	public ProveedorCodigoNombreRestriction(String codigoNombreProveedor, String propertyAliasVistaProveedor) {
		this.codigoNombreProveedor = codigoNombreProveedor;
		this.propertyAliasVistaProveedor = propertyAliasVistaProveedor;
	}

	/**
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	@Override
	public Criterion getCriteriaRestriction() {
		Disjunction disjunction = null;
		if (StringUtils.isNotEmpty(this.codigoNombreProveedor)) {
			
			codigoNombreProveedor = codigoNombreProveedor.toUpperCase();
			
			disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like(StringUtils.isNotEmpty(propertyAliasVistaProveedor) ? propertyAliasVistaProveedor.concat(".codigoJDEProveedor"): "codigoJDEProveedor", this.codigoNombreProveedor, MatchMode.ANYWHERE));
			disjunction.add(Restrictions.like(StringUtils.isNotEmpty(propertyAliasVistaProveedor) ? propertyAliasVistaProveedor.concat(".nombreProveedor"): "nombreProveedor", this.codigoNombreProveedor, MatchMode.ANYWHERE));
			disjunction.add(Restrictions.like(StringUtils.isNotEmpty(propertyAliasVistaProveedor) ? propertyAliasVistaProveedor.concat(".razonSocialProveedor"): "razonSocialProveedor", this.codigoNombreProveedor, MatchMode.ANYWHERE));
			
		}
		return disjunction;
	}

}
