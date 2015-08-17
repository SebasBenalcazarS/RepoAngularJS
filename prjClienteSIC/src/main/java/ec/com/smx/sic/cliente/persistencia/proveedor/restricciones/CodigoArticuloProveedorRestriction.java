package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

@SuppressWarnings("serial")
public class CodigoArticuloProveedorRestriction implements CriteriaRestriction {

	private Integer codigoCompania;
	
	public CodigoArticuloProveedorRestriction(Integer codigoCompania){
		this.codigoCompania = codigoCompania;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelectArticuloProveedor = DetachedCriteria.forClass(ArticuloProveedorDTO.class, "articuloProveedor");
		subSelectArticuloProveedor.setProjection(Projections.property("articuloProveedor.id.codigoArticulo"));
		subSelectArticuloProveedor.add(Restrictions.eq("articuloProveedor.id.codigoCompania", this.codigoCompania));
		subSelectArticuloProveedor.add(Restrictions.eq("articuloProveedor.estadoArticuloProveedor", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		
		subSelectArticuloProveedor.createAlias("articuloProveedor.proveedor", "proveedor");
		subSelectArticuloProveedor.add(Restrictions.eq("proveedor.id.codigoCompania", this.codigoCompania));
		subSelectArticuloProveedor.add(Restrictions.eq("proveedor.estadoProveedor", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectArticuloProveedor.add(new ProveedorFiltroRestriction("proveedor").getCriteriaRestriction());
		
		return Subqueries.propertyIn("id.codigoArticulo", subSelectArticuloProveedor);
	}

}
