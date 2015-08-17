package ec.com.smx.sic.cliente.persistencia.articulos.restricciones.estructuracomercial;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.search.constant.SearchManagerConstants;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

@SuppressWarnings("serial")
public class NivelEstructuraComercialRestriction implements CriteriaRestriction{

	private Integer codigoCompania;
	private Collection<ClasificacionDTO> listaClasificacion;
	private String codigoFuncionario;
	private String codigoProveedor;
	private String codigoBodega;
	
	public NivelEstructuraComercialRestriction(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, Collection<ClasificacionDTO> listaClasificaciones){
		this.codigoCompania = codigoCompania;
		this.listaClasificacion = listaClasificaciones;
		this.codigoFuncionario = codigoFuncionario;
		this.codigoProveedor = codigoProveedor;
		this.codigoBodega = codigoBodega;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Criterion getCriteriaRestriction() {
		
		Collection<String> codigosDivisiones = null;
		Collection<String> codigosDepartamentos = null;
		
		if(CollectionUtils.isNotEmpty(this.listaClasificacion)){
			
			DetachedCriteria subSelectNivEC;
			
		// Division
			
			// Se obtiene solo las divisiones sin departamentos
			Collection<ClasificacionDTO> divisiones = CollectionUtils.select(this.listaClasificacion, PredicateUtils.transformedPredicate(
					new GetInvokerTransformer("clasificacionCol"), PredicateUtils.equalPredicate(null)));
			// Obtiene los codigos de las divisiones sin departamentos
			if(CollectionUtils.isNotEmpty(divisiones))
				codigosDivisiones = CollectionUtils.collect(divisiones, new GetInvokerTransformer("id.codigoClasificacion"));

			// Se obtiene las divisiones con departamentos
			Collection<ClasificacionDTO> divisionesConDepartamentos = CollectionUtils.select(this.listaClasificacion, PredicateUtils.transformedPredicate(
					new GetInvokerTransformer("clasificacionCol"), PredicateUtils.notNullPredicate()));
			
			// Departamento 
			
			if(CollectionUtils.isNotEmpty(divisionesConDepartamentos)){
				for(ClasificacionDTO divi : divisionesConDepartamentos){
					
					// Se obtiene solo los departamentos sin clasificaciones
					Collection<ClasificacionDTO> departamentos = CollectionUtils.select(divi.getClasificacionCol(), PredicateUtils.transformedPredicate(
							new GetInvokerTransformer("clasificacionCol"), PredicateUtils.equalPredicate(null)));
					// Obtiene los codigos de los departamentos sin clasificaciones
					if(CollectionUtils.isNotEmpty(departamentos)){
						if(CollectionUtils.isEmpty(codigosDepartamentos))
							codigosDepartamentos = CollectionUtils.collect(departamentos, new GetInvokerTransformer("id.codigoClasificacion"));
						else
							codigosDepartamentos.addAll(CollectionUtils.collect(departamentos, new GetInvokerTransformer("id.codigoClasificacion")));
					}
				}
			}
			
			if(CollectionUtils.isNotEmpty(codigosDepartamentos) || CollectionUtils.isNotEmpty(codigosDivisiones)){
				
				// Subselect
				subSelectNivEC = DetachedCriteria.forClass(ProveedorClasificacionDTO.class, SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION);
				
				subSelectNivEC.createAlias(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION.concat(".clasificacion"), SearchManagerConstants.getInstance().ALIAS_CLASIFICACION);
				subSelectNivEC.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION.concat(".clasificacionPadre"), SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO);
				subSelectNivEC.createAlias(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO.concat(".clasificacionPadre"), SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DIVISION);
				
				subSelectNivEC.setProjection(Projections.property(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoClasificacion"));
				
				// Parametros 
				subSelectNivEC.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".id.codigoCompania", this.codigoCompania));
				subSelectNivEC.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION + ".estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				
				subSelectNivEC.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION + ".estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				subSelectNivEC.add(Restrictions.eq(SearchManagerConstants.getInstance().ALIAS_PROVEEDOR_CLASIFICACION + ".id.codigoProveedor", this.codigoProveedor));
				
				subSelectNivEC.add(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(this.codigoFuncionario, 
						this.codigoBodega, null, null, null, "id.codigoClasificacion").getCriteriaRestriction());
				
			}else
				return null;
			
			// Where
			if(CollectionUtils.isNotEmpty(codigosDepartamentos) && CollectionUtils.isNotEmpty(codigosDivisiones)){
				
				subSelectNivEC.add(Restrictions.or(Restrictions.in(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DIVISION.concat(".id.codigoClasificacion"), codigosDivisiones), 
						Restrictions.in(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO.concat(".id.codigoClasificacion"), codigosDepartamentos)));
				
			}else if(CollectionUtils.isNotEmpty(codigosDepartamentos)){
				
				subSelectNivEC.add(Restrictions.in(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DEPARTAMENTO.concat(".id.codigoClasificacion"), codigosDepartamentos));
				
			}else if(CollectionUtils.isNotEmpty(codigosDivisiones)){
				
				subSelectNivEC.add(Restrictions.in(SearchManagerConstants.getInstance().ALIAS_CLASIFICACION_DIVISION.concat(".id.codigoClasificacion"), codigosDivisiones));
				
			}
				
			return Subqueries.propertyIn("codigoClasificacion", subSelectNivEC);
		
		}else
			return null;
	}

}
