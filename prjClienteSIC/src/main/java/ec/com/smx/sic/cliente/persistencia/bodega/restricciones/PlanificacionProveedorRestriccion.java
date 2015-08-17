/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.bodega.CalculoFechasUtil;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.persistencia.proveedor.restricciones.ProveedorCodigoNombreRestriction;

/**
 * Agrega restricciones gen�ricas sobre el objeto <code>DetalleTareaDTO</code> dependiendo de las propiedades que se asignen
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
public class PlanificacionProveedorRestriccion implements CriteriaRestriction {
	/**
	 * Fecha de planificacion
	 */
	private Date fechaPlanificacion;
	
	/**
	 * Hora de la planificacion
	 */
	private Time horaPlanificacion;
	
	/**
	 * Codigo o nombre proveedor
	 */
	private String codigoNombreProveedor;
	
	/**
	 * Codigos de proveedores a excluir
	 */
	private Collection<String> codigosProveedor;
	
	/**
	 * Constructor
	 * 
	 * @param proveedorDTO Un VistaProveedorDTO
	 */
	public PlanificacionProveedorRestriccion(Date fechaPlanificacion, Time horaPlanificacion, String codigoNombreProveedor, Collection<String> codigosProveedor) {
		this.fechaPlanificacion = fechaPlanificacion;
		this.horaPlanificacion = horaPlanificacion;
		this.codigoNombreProveedor = codigoNombreProveedor;
		this.codigosProveedor = codigosProveedor;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		
		Junction junction = Restrictions.conjunction();
		if (CollectionUtils.isNotEmpty(codigosProveedor)) {
			junction.add(Restrictions.not(Restrictions.in("id.codigoProveedor", codigosProveedor)));
		}
		
		junction.add(Subqueries.propertyIn("id.codigoProveedor", this.buscarCalendarioPlanificacionProveedores(this.fechaPlanificacion, this.horaPlanificacion)));
		
		if (StringUtils.isNotEmpty(codigoNombreProveedor)) {
			junction.add(new ProveedorCodigoNombreRestriction(codigoNombreProveedor, "").getCriteriaRestriction());
		}
		
		return junction;
	}
	
	/**
	 * Calendario del proveedor con autorizaciones
	 * 
	 * @param diaSemana Un Integer
	 * @param fecha Un Date
	 * @return Un DetachedCriteria
	 */
	public DetachedCriteria buscarCalendarioPlanificacionProveedores(Date fecha, Time hora) {
		
		//TODO Filtros con la parte de autorizaciones
		
		DetachedCriteria select = DetachedCriteria.forClass(HoraCalendarioDTO.class,"H");
		select.createAlias("H.calendarioDTO", "C");
		//select_.createAlias("H.autorizacionHoraCalendarioDTOCol", "AHC");
		//select_.createAlias("AHC.autorizacionDTO", "A");
		
		//Date fechaInicio = CalculoFechasUtil.getInstancia().obtenerFechaTrunk(fecha);
		//Date fechaFin = CalculoFechasUtil.getInstancia().incrementarDiasFecha(fechaInicio, 1);
		
		Integer diaSemana = CalculoFechasUtil.getInstancia().obtenerDiaSemanaCalendario(fecha);
		if (diaSemana != null) {
			select.add(Restrictions.eq("C.diaSemana", diaSemana));
		}
		if (hora != null) {
			select.add(Restrictions.eq("H.horaInicio", hora));
		}
		//if (fecha != null) {
			//select_.add(Restrictions.between("C.fechaCalendario", fechaInicio, fechaFin));
		//}
		//select_.add(Restrictions.eq("A.estado", "1"));
		//select_.add(Restrictions.isNotNull("A.numeroAutorizacion"));
		
		select.setProjection(Projections.property("C.codigoProveedor"));
		
		return select;
	}
	
}
