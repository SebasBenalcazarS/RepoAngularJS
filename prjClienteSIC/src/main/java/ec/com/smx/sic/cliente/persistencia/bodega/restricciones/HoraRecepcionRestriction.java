/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.bodega.CalculoFechasUtil;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;

/**
 * Filtro para buscar el mismo valor sobre los campos codigoJDEProveedor, nombreProveedor, razonSocialProveedor de la entidad VistaProveedorDTO 
 * 
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class HoraRecepcionRestriction implements CriteriaRestriction {
	/**
	 * the codigoNombreProveedor filter value
	 */
	private Integer diaSemana;
	
	private Date fecha;
	
	/**
	 * 
	 * @param codigoNombreProveedor
	 */
	public HoraRecepcionRestriction(Integer diaSemana, Date fecha) {
		this.diaSemana = diaSemana;
		this.fecha = fecha;
	}

	/**
	 * @see ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction#getCriteriaRestriction()
	 */
	@Override
	public Criterion getCriteriaRestriction() {
		Junction disjuncion = Restrictions.disjunction();
		disjuncion.add(Subqueries.propertyIn("id.codigoHoraCalendario", this.buscarHoraCalendarioFacturaDigital(diaSemana, fecha)));
		disjuncion.add(Subqueries.propertyIn("id.codigoHoraCalendario", this.buscarHoraCalendarioPlanificacion(diaSemana, fecha)));
		disjuncion.add(Subqueries.propertyIn("id.codigoHoraCalendario", this.buscarHoraCalendarioAutorizaciones(diaSemana, fecha)));
		return disjuncion;
	}
	
	/**
	 * Calendario del proveedor de las entregas
	 * 
	 * @param diaSemana Un Integer
	 * @param fecha Un Date
	 * @return Un DetachedCriteria
	 */
	public DetachedCriteria buscarHoraCalendarioFacturaDigital(Integer diaSemana, Date fecha) {
		
		DetachedCriteria select = DetachedCriteria.forClass(HoraCalendarioDTO.class,"H");
		select.createAlias("H.calendarioDTO", "C");
		select.createAlias("H.detalleCalendarioDTOCol", "DC");
		select.createAlias("DC.entregaDetalleCalendarioProveedorDTOCol", "EDCP");
		select.createAlias("EDCP.entregaDTO", "E");
		
		select.add(Restrictions.eq("H.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		select.add(Restrictions.eq("C.diaSemana", diaSemana));
		select.add(Restrictions.eq("E.fechaEntrega", fecha));
		select.add(Restrictions.isNull("C.fechaCalendario"));
		
		select.setProjection(Projections.property("id.codigoHoraCalendario"));
		
		return select;
	}
	
	/**
	 * Calendario del proveedor con autorizaciones
	 * 
	 * @param diaSemana Un Integer
	 * @param fecha Un Date
	 * @return Un DetachedCriteria
	 */
	public DetachedCriteria buscarHoraCalendarioAutorizaciones(Integer diaSemana, Date fecha) {
		
		DetachedCriteria select = DetachedCriteria.forClass(HoraCalendarioDTO.class,"H");
		select.createAlias("H.calendarioDTO", "C");
		select.createAlias("H.autorizacionHoraCalendarioDTOCol", "AHC");
		select.createAlias("AHC.autorizacionDTO", "A");
		
		Date fechaInicio = CalculoFechasUtil.getInstancia().obtenerFechaTrunk(fecha);
		Date fechaFin = CalculoFechasUtil.getInstancia().incrementarDiasFecha(fechaInicio, 1);
		
		select.add(Restrictions.eq("A.estado", "1"));
		select.add(Restrictions.isNotNull("A.numeroAutorizacion"));
		select.add(Restrictions.between("C.fechaCalendario", fechaInicio, fechaFin));
		select.setProjection(Projections.property("id.codigoHoraCalendario"));
		
		return select;
	}
	
	
	public DetachedCriteria buscarHoraCalendarioPlanificacion(Integer diaSemana, Date fecha) {
		
		DetachedCriteria select = DetachedCriteria.forClass(HoraCalendarioDTO.class,"H");
		select.createAlias("H.calendarioDTO", "C");
		
		select.add(Restrictions.eq("C.estado", "1"));
		select.add(Restrictions.eq("C.diaSemana", diaSemana));
		select.setProjection(Projections.property("id.codigoHoraCalendario"));
		
		return select;
	}

}
