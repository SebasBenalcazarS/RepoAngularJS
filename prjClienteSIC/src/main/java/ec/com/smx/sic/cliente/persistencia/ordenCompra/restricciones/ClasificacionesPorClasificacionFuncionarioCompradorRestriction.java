package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;

@SuppressWarnings("serial")
public class ClasificacionesPorClasificacionFuncionarioCompradorRestriction implements CriteriaRestriction{
	
	private String codigoFuncionario = null;
	private String codigoSubbodega = null;
	private String codigoClasificacion = null;
	private String codigoDepartamento = null;
	private Collection<String> codigosClasificacion = null;
	private Collection<String> codigosDepartamento = null;
	private Long codigoLineaComercial = null;
	private String propertyIn = null;
	private Boolean eslistaCodigos = null;

	/**
	 * 
	 * @param codigoFuncionario
	 * @param codigoSubbodega
	 * @param codigoClasificacion
	 * @param codigoDepartamento
	 * @param codigoLineaComercial
	 * @param propertyIn
	 */
	public ClasificacionesPorClasificacionFuncionarioCompradorRestriction(String codigoFuncionario, String codigoSubbodega, String codigoClasificacion, 
			String codigoDepartamento, Long codigoLineaComercial, String propertyIn) {
		this.codigoFuncionario = codigoFuncionario;
		this.codigoSubbodega = codigoSubbodega;
		this.codigoClasificacion = codigoClasificacion;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoLineaComercial = codigoLineaComercial;
		this.propertyIn = propertyIn;
		this.eslistaCodigos = Boolean.FALSE;
	}
	
	/**
	 * 
	 * @param codigoFuncionario
	 * @param codigoSubbodega
	 * @param codigosClasificacion
	 * @param codigosDepartamento
	 * @param codigoLineaComercial
	 * @param propertyIn Propiedad a la que hace referencia
	 * @param useListaCodigos True para usar los codigos de las colecciones clasificaciones o departamentos, False en caso contrario
	 */
	public ClasificacionesPorClasificacionFuncionarioCompradorRestriction(String codigoFuncionario, String codigoSubbodega, Collection<String> codigosClasificacion, 
			Collection<String> codigosDepartamento, Long codigoLineaComercial, String propertyIn, Boolean useListaCodigos) {
		this(codigoFuncionario, codigoSubbodega, null, null, codigoLineaComercial, propertyIn);
		if(useListaCodigos != null && useListaCodigos){
			this.codigosClasificacion = codigosClasificacion;
			this.codigosDepartamento = codigosDepartamento;
			this.eslistaCodigos = Boolean.TRUE;
		}
	}
	
	@Override
	public Criterion getCriteriaRestriction() throws SICException {
		 Criterion criterion = null;
		
		try{
			
			DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioClasificacionDTO.class, "lineaComercialFuncionarioClasificacion");
			subSelectClaFun.setProjection(Projections.property("lineaComercialFuncionarioClasificacion.codigoClasificacion"));
			subSelectClaFun.createAlias("lineaComercialFuncionarioClasificacion.clasificacion", "clasificacion");
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionarioClasificacion.codigoFuncionario", this.codigoFuncionario));
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionarioClasificacion.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSelectClaFun.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSelectClaFun.add(Restrictions.eq("clasificacion.codigoTipoClasificacion", SICConstantes.TIPCLA_CLASIFICACION));
			
			
			if(this.codigoSubbodega != null){
				subSelectClaFun.add(Restrictions.eq("clasificacion.codigoBodega", this.codigoSubbodega));
			}
			
			if(this.eslistaCodigos){			
				if(CollectionUtils.isNotEmpty(this.codigosClasificacion)){
					subSelectClaFun.add(Restrictions.in("clasificacion.id.codigoClasificacion", this.codigosClasificacion));
				}
				
				if(CollectionUtils.isNotEmpty(this.codigosDepartamento)){ 
					subSelectClaFun.add(Restrictions.in("clasificacion.codigoClasificacionPadre", this.codigosDepartamento));
				}
			}else{				
				if(this.codigoClasificacion != null){
					subSelectClaFun.add(Restrictions.eq("clasificacion.id.codigoClasificacion", this.codigoClasificacion));
				}
				
				if(this.codigoDepartamento != null){ 
					subSelectClaFun.add(Restrictions.eq("clasificacion.codigoClasificacionPadre", this.codigoDepartamento));
				}
			}
			
			if(this.codigoLineaComercial != null){
				//subSelectClaFun.add(Restrictions.eq("lineaComercial.id.codigoLineaComercial", this.codigoLineaComercial));
				DetachedCriteria subSelectLinCla = DetachedCriteria.forClass(LineaComercialClasificacionDTO.class, "lineaComercialClasificacion");
				subSelectLinCla.setProjection(Projections.distinct(Projections.property("lineaComercialClasificacion.id.codigoClasificacion")));
				subSelectLinCla.add(Restrictions.eq("lineaComercialClasificacion.codigoLineaComercial", this.codigoLineaComercial));
				subSelectLinCla.add(Restrictions.eq("lineaComercialClasificacion.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				
				subSelectClaFun.add(Subqueries.propertyIn("lineaComercialClasificacion.id.codigoClasificacion", subSelectLinCla));
			}
			
			criterion = Subqueries.propertyIn(this.propertyIn, subSelectClaFun);

		} catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n");
		}
		
		return criterion;
	}

}
