package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.JoinCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;

@SuppressWarnings("serial")
public class JoinArticuloOrdenCompraRestriction implements JoinCriteriaRestriction {
	
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO = null;
	
	public JoinArticuloOrdenCompraRestriction(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		if (StringUtils.isNotEmpty(articuloUnidadManejoDTO.getId().getCodigoArticulo()) && articuloUnidadManejoDTO.getId().getCodigoUnidadManejo() != null) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
					Restrictions.and(
							Restrictions.eq("codigoArticulo", this.articuloUnidadManejoDTO.getId().getCodigoArticulo()), 
							Restrictions.eq("codigoUnidadManejo", this.articuloUnidadManejoDTO.getId().getCodigoUnidadManejo()))
			);
		} else if (StringUtils.isNotEmpty(articuloUnidadManejoDTO.getId().getCodigoArticulo()) ) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
							Restrictions.eq("codigoArticulo", this.articuloUnidadManejoDTO.getId().getCodigoArticulo()) 
			);
		} else if (articuloUnidadManejoDTO.getId().getCodigoUnidadManejo() != null) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
					Restrictions.eq("codigoUnidadManejo", this.articuloUnidadManejoDTO.getId().getCodigoUnidadManejo()) 
			);
		}
		return criterion;
	}	
}
