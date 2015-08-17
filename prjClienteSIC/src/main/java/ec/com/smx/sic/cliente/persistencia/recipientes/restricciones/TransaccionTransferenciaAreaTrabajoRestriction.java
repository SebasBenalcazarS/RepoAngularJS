package ec.com.smx.sic.cliente.persistencia.recipientes.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.dto.TipoTransaccionTipoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
/**
 * Restriccion para obtener las transacciones que un local 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class TransaccionTransferenciaAreaTrabajoRestriction implements CriteriaRestriction{
	private String tipoAreaTrabajoValor;
	private Integer tipoAreaTrabajoTIC;
	private String propertyIn;
	//Constructor
	public	TransaccionTransferenciaAreaTrabajoRestriction (String propertyIn,
															Integer tipoAreaTrabajoTIC,
															String tipoAreaTrabajoValor){
		this.tipoAreaTrabajoTIC = tipoAreaTrabajoTIC;
		this.tipoAreaTrabajoValor= tipoAreaTrabajoValor;
		this.propertyIn = propertyIn;
	}
	@Override
	public Criterion getCriteriaRestriction() {
		 Criterion criterion = null;
			
			try{
				DetachedCriteria subSelectTipAreTrA = DetachedCriteria.forClass(TipoTransaccionTipoAreaTrabajoDTO.class, "tipoTransaccionTipoAreaTrabajo");
				subSelectTipAreTrA.setProjection(Projections.distinct(Projections.property("tipoTransaccionTipoAreaTrabajo.codigoTipoTransaccion")));
				subSelectTipAreTrA.add(Restrictions.eq("tipoTransaccionTipoAreaTrabajo.estado", Boolean.TRUE));
				subSelectTipAreTrA.add(Restrictions.eq("tipoTransaccionTipoAreaTrabajo.codigoTipoAreaTrabajoOrigen",tipoAreaTrabajoTIC));
				subSelectTipAreTrA.add(Restrictions.eq("tipoTransaccionTipoAreaTrabajo.valorTipoAreaTrabajoOrigen",tipoAreaTrabajoValor));
				criterion = Subqueries.propertyIn(this.propertyIn, subSelectTipAreTrA);
			}catch(Exception e){
				throw new SICException("Se produjo un error al momento de armar la restricción");
			}
			
		return criterion;
	
	}

}
