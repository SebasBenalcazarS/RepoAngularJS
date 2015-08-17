package ec.com.smx.sic.cliente.persistencia.cambioprecios.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
@SuppressWarnings("serial")
public class ArticuloOrdenCompraRestriction implements CriteriaRestriction{
	
	private Integer codigoCompania;
	
	public ArticuloOrdenCompraRestriction(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelectCodArt = DetachedCriteria.forClass(OrdenCompraEstadoDTO.class,"orden");
		
		//WHERE
		subSelectCodArt.add(Restrictions.eq("orden.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectCodArt.add(Restrictions.eq("orden.codigoEstadoCatTip", Integer.valueOf(SICOrdenCompraConstantes.getInstancia().CODIGO_TIPO_ESTADO_ORDENCOMPRA)));
		subSelectCodArt.add(Restrictions.eq("orden.id.codigoCompania", codigoCompania));
		
		//CAMPOS
		String groupBy = "orden_.codigoOrdenCompra" + " having " + "count(orden_.codigoEstadoCatVal) = " + String.valueOf(1);
		String[] alias = new String[1]; 
		alias[0] = "orden_.codigoOrdenCompra"; 
		Type[] types = new Type[1]; 
		types[0] = StandardBasicTypes.INTEGER;
		subSelectCodArt.setProjection( Projections.projectionList()
					.add( Projections.sqlGroupProjection("orden_.codigoOrdenCompra", groupBy, alias , types)));
		return Subqueries.propertyIn("ordcomest.codigoOrdenCompra", subSelectCodArt);
	}

}
