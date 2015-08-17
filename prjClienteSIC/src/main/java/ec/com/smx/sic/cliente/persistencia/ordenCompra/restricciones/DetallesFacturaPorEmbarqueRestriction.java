package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaDetalleEstadoImpDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class DetallesFacturaPorEmbarqueRestriction implements CriteriaRestriction{
	
	private String property = null;
	
	public DetallesFacturaPorEmbarqueRestriction(String property) {
		super();
		this.property = property;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try {
			DetachedCriteria subSelectDetalleFacturaEstado;
			subSelectDetalleFacturaEstado = DetachedCriteria.forClass(FacturaDetalleEstadoImpDTO.class, "facturaDetalleEstadoImp");
			subSelectDetalleFacturaEstado.setProjection(Projections.distinct(Projections.property("facturaDetalleEstadoImp.id.codigoFacturaEstado")));
			subSelectDetalleFacturaEstado.createAlias("facturaDetalleEstadoImp.facturaDetalle", "fd",CriteriaSpecification.INNER_JOIN, Restrictions.eq("fd.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_LITERAL));
			subSelectDetalleFacturaEstado.createAlias("facturaDetalleEstadoImp.facturaDetallesEstadoAdicional", "facDetEstAdicional", CriteriaSpecification.LEFT_JOIN,Restrictions.eq("facDetEstAdicional.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_LITERAL) );		
			criterion = Subqueries.propertyIn(this.property, subSelectDetalleFacturaEstado);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n detalles facturas importaciones por embarque");
		}
		return criterion;
	}
}
