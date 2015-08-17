/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.HashSet;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class ArticuloRelacionPadreRestriction implements CriteriaRestriction{

	private String codigoProveedor = null;
	private HashSet<String> valoresTipoRelacion = null;
	private String propertyIn;
	
	public ArticuloRelacionPadreRestriction(String codigoProveedor, HashSet<String> valoresTipoRelacion, String propertyIn){
		super();
		this.codigoProveedor = codigoProveedor;
		this.valoresTipoRelacion = valoresTipoRelacion;
		if(propertyIn != null){
			this.propertyIn=propertyIn;
		}else{
			propertyIn=CriteriaSpecification.ROOT_ALIAS;
		}
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		 Criterion criterion = null;
			
			try{
				DetachedCriteria subSelectArtRel = DetachedCriteria.forClass(ArticuloRelacionDTO.class, "articuloRelacion");
				subSelectArtRel.setProjection(Projections.distinct(Projections.property("articuloRelacion.id.codigoArticuloRelacionado")));
				
				subSelectArtRel.createAlias("articuloRelacion.articulo", "articulo");
				subSelectArtRel.createAlias("articulo.articuloProveedorCol", "articuloProveedorCol");
				
				subSelectArtRel.add(Restrictions.eqProperty("articuloRelacion.id.codigoArticuloRelacionado", propertyIn.concat(".codigoArticulo")));
				subSelectArtRel.add(Restrictions.in("articuloRelacion.valorTipoRelacion", this.valoresTipoRelacion));
				subSelectArtRel.add(Restrictions.eq("articuloProveedorCol.id.codigoProveedor", this.codigoProveedor));
				subSelectArtRel.add(Restrictions.eq("articuloRelacion.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				
				criterion = Subqueries.propertyNotIn(propertyIn.concat(".codigoArticulo"), subSelectArtRel);
			}catch(Exception e){
				throw new SICException("Se produjo un error al momento de armar la restricci�n");
			}
			
			return criterion;
	}

}
