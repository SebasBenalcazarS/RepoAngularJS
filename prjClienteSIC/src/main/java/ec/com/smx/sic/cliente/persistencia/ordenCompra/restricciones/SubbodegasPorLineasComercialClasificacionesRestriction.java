package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.HashSet;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;

@SuppressWarnings("serial")
public class SubbodegasPorLineasComercialClasificacionesRestriction implements CriteriaRestriction {
	
	private HashSet<Long> codigosHijosLineaComercialPadre;

	/**
	 * 
	 * @param codigoFuncionario
	 */
	public SubbodegasPorLineasComercialClasificacionesRestriction(HashSet<Long> codigosHijosLineaComercialPadre) {
		super();
		this.codigosHijosLineaComercialPadre = codigosHijosLineaComercialPadre;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioDTO.class, "lineaComercialFuncionario");
		subSelectClaFun.setProjection(Projections.distinct(Projections.property("clasificacion.codigoBodega")));
		subSelectClaFun.createAlias("lineaComercialFuncionario.lineaComercial", "lineaComercial");
		subSelectClaFun.createAlias("lineaComercial.lineaComercialClasificaciones", "lineaComercialClasificaciones");
		subSelectClaFun.createAlias("lineaComercialClasificaciones.clasificacion", "clasificacion");
		subSelectClaFun.add(Restrictions.in("lineaComercialClasificaciones.codigoLineaComercial", codigosHijosLineaComercialPadre));
		subSelectClaFun.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("clasificacion.codigoTipoClasificacion", SICConstantes.getInstancia().TIPCLA_CLASIFICACION));
		
		return Subqueries.propertyIn("id.codigoBodega", subSelectClaFun);
	}

}
