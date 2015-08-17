package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.pedidoAsistido.SICPedidoAsistidoConstantes;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;

@SuppressWarnings("serial")
public class ConfiguracionesDetallesPorCalendarioProceso implements CriteriaRestriction {

	private Integer codigoCompania;
	private Integer codigoAreaTrabajoCd;
	
	/**
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoAreaTrabajoCd
	 */
	public ConfiguracionesDetallesPorCalendarioProceso(Integer codigoCompania, Integer codigoAreaTrabajoCd) {
		super();
		this.codigoCompania = codigoCompania;
		this.codigoAreaTrabajoCd = codigoAreaTrabajoCd;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		
		//DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO.class, "areaTrabajoCalendarioProcesoConfiguracionDetalle");
		DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(AreaTrabajoCalendarioProcesoDTO.class, "areaTrabajoCalendarioProceso");
		subSelectClaFun.setProjection(Projections.distinct(Projections.property("areaTrabajoCalendarioProceso.id.codigoAreaTrabajoCalendarioProceso")));
		
		//subSelectClaFun.createAlias("areaTrabajoCalendarioProcesoConfiguracionDetalle.areaTrabajoCalendarioProcesoConfiguracionDTO", "areaTrabajoCalendarioProcesoConfiguracion");
		//subSelectClaFun.createAlias("areaTrabajoCalendarioProcesoConfiguracion.areaTrabajoCalendarioProcesoDTO", "areaTrabajoCalendarioProceso");
		subSelectClaFun.createAlias("areaTrabajoCalendarioProceso.areaTrabajoCalendarioProcesoDetalleDTOCol", "areaTrabajoCalendarioProcesoDetalle");
		
		/*subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoConfiguracionDetalle.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoConfiguracionDetalle.id.codigoCompania", this.codigoCompania));
		
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoConfiguracion.id.codigoCompania", this.codigoCompania));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoConfiguracion.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoConfiguracion.codigoAreaTrabajo", this.codigoAreaTrabajoSubbodega));*/
		
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProceso.id.codigoCompania", this.codigoCompania));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProceso.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProceso.codigoAreaTrabajo", this.codigoAreaTrabajoCd));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProceso.codigoProceso", SICPedidoAsistidoConstantes.CODIGO_PROCESO_PEDIDO_ASISTIDO));
		
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoDetalle.id.codigoCompania", this.codigoCompania));
		subSelectClaFun.add(Restrictions.eq("areaTrabajoCalendarioProcesoDetalle.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		
		return Subqueries.propertyIn("codigoAreaTrabajoCalendarioProceso", subSelectClaFun);
	}
}
