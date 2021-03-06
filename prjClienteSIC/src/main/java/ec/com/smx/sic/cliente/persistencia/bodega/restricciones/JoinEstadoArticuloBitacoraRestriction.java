package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.JoinCriteriaRestriction;

@SuppressWarnings("serial")
public class JoinEstadoArticuloBitacoraRestriction implements JoinCriteriaRestriction {
	
	private String estado = null;
	
	public JoinEstadoArticuloBitacoraRestriction(String estado) {
		this.estado = estado;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		if (StringUtils.isNotEmpty(estado) ) {
			criterion = Restrictions.eq("estadoArticuloBitacora", estado);			
		} 
		return criterion;
	}	
}
