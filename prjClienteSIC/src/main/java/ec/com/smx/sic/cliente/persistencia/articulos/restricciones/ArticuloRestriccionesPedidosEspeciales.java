package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.sispe.EspecialClasificacionDTO;

@SuppressWarnings("serial")
public class ArticuloRestriccionesPedidosEspeciales implements CriteriaRestriction {

	private ArticuloDTO articuloDTO;
	
	
	public ArticuloRestriccionesPedidosEspeciales(ArticuloDTO articuloDTO) {		
		this.articuloDTO = articuloDTO;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Conjunction conjunction = Restrictions.conjunction(); 
		
		//		Restricciones del articulo en la obtencion desde SISPE
		
		if(articuloDTO.getNpCodigoEspecial() != null){
			DetachedCriteria criteria = DetachedCriteria.forClass(EspecialClasificacionDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania", articuloDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.in("id.codigoEspecial", articuloDTO.getNpCodigoEspecial().trim().split(",")));			
			criteria.setProjection(Projections.property("id.codigoClasificacion"));
			conjunction.add(Subqueries.propertyIn("codigoClasificacion", criteria));			
		}
		if(articuloDTO.getTipoCalculoPrecioFiltro() != null){			
			if(StringUtils.equals(articuloDTO.getTipoCalculoPrecioFiltro(),SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOCANTIDAD)){
				conjunction.add(Restrictions.eq("articuloComercialDTO.valorTipoControlCosto", SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE));
			}else if(StringUtils.equals(articuloDTO.getTipoCalculoPrecioFiltro(),SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOCANTIDADPESO)){
				Conjunction conjunctionPCP = Restrictions.conjunction(); 
				conjunctionPCP.add(Restrictions.eq("articuloComercialDTO.valorTipoControlCosto", SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPES));
				conjunctionPCP.add(Restrictions.isNotNull("articuloComercialDTO.pesoAproximadoVenta"));
				conjunctionPCP.add(Restrictions.gt("articuloComercialDTO.pesoAproximadoVenta", 0D));
				conjunction.add(conjunctionPCP);				
			}else if(StringUtils.equals(articuloDTO.getTipoCalculoPrecioFiltro(),SICArticuloConstantes.getInstancia().TIPOCALCULOPRECIOPESO)){
				Disjunction disjunction = Restrictions.disjunction();				
				disjunction.add(Restrictions.eq("articuloComercialDTO.valorTipoControlCosto", SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES));
				disjunction.add(Restrictions.eq("articuloComercialDTO.valorTipoControlCosto", SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPESUM));
				conjunction.add(disjunction);
			}			
		}
		
		//	Restriccions para el articulo desde el B2B
		
		if(!CollectionUtils.isEmpty(articuloDTO.getNpCodigosInicialesSubclasificacionesAExcluir())){
			Conjunction conjunctionSC = Restrictions.conjunction();
			for(String codIniSubclas:articuloDTO.getNpCodigosInicialesSubclasificacionesAExcluir()){
				conjunctionSC.add(Restrictions.lt("codigoSubClasificacion",codIniSubclas));
			}
			conjunction.add(conjunctionSC);
		}
		
		if(!ArrayUtils.isEmpty(articuloDTO.getNpClasesArticulo())){
			conjunction.add(Restrictions.in("claseArticulo", articuloDTO.getNpClasesArticulo()));
		}
		
		if(!CollectionUtils.isEmpty(articuloDTO.getNpCodigosProveedores())){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ArticuloProveedorDTO.class);
			detachedCriteria.add(Restrictions.eq("id.codigoCompania", articuloDTO.getId().getCodigoCompania()));
			detachedCriteria.add(Restrictions.in("id.codigoProveedor", articuloDTO.getNpCodigosProveedores()));
			detachedCriteria.setProjection(Projections.property("id.codigoArticulo"));
			conjunction.add(Subqueries.propertyIn("id.codigoArticulo", detachedCriteria));
		}
		if(!CollectionUtils.isEmpty(articuloDTO.getNpCodigosClasificaciones())){
			conjunction.add(Restrictions.in("codigoClasificacion", articuloDTO.getNpCodigosClasificaciones()));
		}		
		return conjunction;
	}


	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}


	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}	
}


