/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
public class ArticulosRelacionadosRestriccion implements CriteriaRestriction {

	private DynamicCriteriaRestriction dynamicCriteriaGestionPrecio;
	private Integer codigoCompania;
	private String parameterPattern;
	
	public ArticulosRelacionadosRestriccion(Integer codigoCompania, DynamicCriteriaRestriction dynamicCriteriaGestionPrecio, String parameterPattern) {
		this.dynamicCriteriaGestionPrecio = dynamicCriteriaGestionPrecio;
		this.codigoCompania = codigoCompania;
		this.parameterPattern = parameterPattern;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {

		// Sub select a tabla de articulos.
		DetachedCriteria subSelectGestionPrecio = DetachedCriteria.forClass(ArticuloDTO.class, "articulo");
		subSelectGestionPrecio.add(Restrictions.eq("articulo.id.codigoCompania", this.codigoCompania));
		subSelectGestionPrecio.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		
		//join con tabla ArticuloProveedor
		subSelectGestionPrecio.createAlias("articulo.articuloProveedorCol", "articuloProveedorCol", JoinType.LEFT.getIntValue());
		subSelectGestionPrecio.add(Restrictions.eq("articuloProveedorCol.id.codigoCompania", this.codigoCompania));
		subSelectGestionPrecio.add(Restrictions.eq("articuloProveedorCol.estadoArticuloProveedor", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		
		subSelectGestionPrecio.setProjection(Projections.property("articulo.id.codigoArticulo"));
		subSelectGestionPrecio.add(dynamicCriteriaGestionPrecio.getCriteriaRestriction());
		
		return Subqueries.propertyIn(parameterPattern, subSelectGestionPrecio);
	}
}