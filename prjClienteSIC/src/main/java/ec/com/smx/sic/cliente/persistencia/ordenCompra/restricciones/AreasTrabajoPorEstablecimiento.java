package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author aguato
 *
 */
public class AreasTrabajoPorEstablecimiento implements CriteriaRestriction, Logeable{

	private static final long serialVersionUID = 1L;
	private String propertyEstablecimiento = null;
	
	public AreasTrabajoPorEstablecimiento(String  propertyEstablecimiento){
		super();
		this.propertyEstablecimiento = propertyEstablecimiento;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Disjunction disjunction = Restrictions.disjunction();
		try {
			//CD - SUBBODEGA
			disjunction.add(Restrictions.and(Restrictions.or(Restrictions.eq("tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION),
														     Restrictions.eq("tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_SUBBODEGA)),
										     Subqueries.propertyIn("codigoEstablecimiento", getDetachedCriteriaFacturaEstado(CorporativoConstantes.TIPO_ESTABLECIMIENTO_LOGISTICO))));
			
			//OFICINA
			disjunction.add(Restrictions.and(Restrictions.eq("tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_OFICINA),
				     Subqueries.propertyIn("codigoEstablecimiento", getDetachedCriteriaFacturaEstado(CorporativoConstantes.TIPO_ESTABLECIMIENTO_ADMINISTRATIVO))));
			
			//LOCAL
			disjunction.add(Restrictions.and(Restrictions.eq("tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL),
						     Subqueries.propertyIn("codigoEstablecimiento", getDetachedCriteriaFacturaEstado(CorporativoConstantes.TIPO_ESTABLECIMIENTO_FORMATO_NEGOCIO))));
		} catch (Exception e) {
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n");
		}
		return disjunction;
	}

	/**
	 * Valida tipo de area de trabajo 
	 * en establecimiento
	 * @param tipoEstablecimiento
	 * @return
	 * @throws SICException
	 */
	private DetachedCriteria getDetachedCriteriaFacturaEstado(String tipoEstablecimiento) throws SICException{
		DetachedCriteria subSelectAreaTrabajoEstablecimiento = null;
		try {
			subSelectAreaTrabajoEstablecimiento = DetachedCriteria.forClass(EstablecimientoCiudadDTO.class, "establecimientoCiudad");
			subSelectAreaTrabajoEstablecimiento.setProjection(Projections.distinct(Projections.property("establecimientoCiudad.id.codigoEstablecimiento")));
			subSelectAreaTrabajoEstablecimiento.createAlias("establecimientoCiudad.establecimientoDTO", "establecimiento");
			subSelectAreaTrabajoEstablecimiento.add(Restrictions.eqProperty("establecimientoCiudad.id.codigoEstablecimiento", this.propertyEstablecimiento));
			subSelectAreaTrabajoEstablecimiento.add(Restrictions.eq("establecimientoCiudad.estado", CorporativoConstantes.ESTADO_ACTIVO));
			subSelectAreaTrabajoEstablecimiento.add(Restrictions.eq("establecimiento.estado", CorporativoConstantes.ESTADO_ACTIVO));
			subSelectAreaTrabajoEstablecimiento.add(Restrictions.eq("establecimiento.tipoEstablecimiento", tipoEstablecimiento));
		} catch (Exception e) {
			LOG_SICV2.error("Error al armar la restriccion para verificar el tipo de area de trabajo.");
			throw new SICException("Error al armar restricci\u00F3n de \u00E1reas de trabajo");
		}
		return subSelectAreaTrabajoEstablecimiento;
	}
}
