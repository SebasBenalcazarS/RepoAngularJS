/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.JoinCriteriaRestriction;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class JoinCaracteristicaDetalleSeccionRestriction implements JoinCriteriaRestriction{
	
	private String estado = null;
	private Integer codigoTipoCaracteristica = null;
	private String [] valorTipoCaracteristica = null;
	
	public JoinCaracteristicaDetalleSeccionRestriction (String estado, Integer codigoTipoCaracteristica, String ... valorTipoCaracteristica) {
		this.estado = estado;
		this.codigoTipoCaracteristica = codigoTipoCaracteristica;
		this.valorTipoCaracteristica = valorTipoCaracteristica;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		
		Criterion criterion = null;
		if (StringUtils.isNotEmpty(estado) && codigoTipoCaracteristica != null && this.valorTipoCaracteristica != null && this.valorTipoCaracteristica.length > 0) {
			criterion = Restrictions.and(Restrictions.eq("estado", this.estado) , 
					Restrictions.and(Restrictions.eq("codigoTipoCaracteristica", this.codigoTipoCaracteristica) , 
					Restrictions.in("valorTipoCaracteristica", this.valorTipoCaracteristica))
					);
			
		} else if (StringUtils.isNotEmpty(estado) && this.valorTipoCaracteristica == null) {
			criterion = Restrictions.eq("estado", this.estado);
		}
		return criterion;
		
	}

}
