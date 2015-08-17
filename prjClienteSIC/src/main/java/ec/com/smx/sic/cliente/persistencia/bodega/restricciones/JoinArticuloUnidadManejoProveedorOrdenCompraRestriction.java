package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.JoinCriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;

@SuppressWarnings("serial")
public class JoinArticuloUnidadManejoProveedorOrdenCompraRestriction implements JoinCriteriaRestriction {
	
	private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO = null;
	
	public JoinArticuloUnidadManejoProveedorOrdenCompraRestriction(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO) {
		this.articuloUnidadManejoProveedorDTO = articuloUnidadManejoProveedorDTO;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		if (StringUtils.isNotEmpty(articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()) && articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo() != null) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
					Restrictions.and(
							Restrictions.eq("id.codigoProveedor", this.articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()), 
							Restrictions.eq("id.codigoUnidadManejo", this.articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo()))
			);
		}  else if (StringUtils.isNotEmpty(articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()) && (StringUtils.isNotEmpty(articuloUnidadManejoProveedorDTO.getCodigoArticulo()))) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
					Restrictions.and(		
							Restrictions.eq("id.codigoProveedor", this.articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()),
							Restrictions.eq("codigoArticulo", this.articuloUnidadManejoProveedorDTO.getCodigoArticulo()))
			);
		} else if (StringUtils.isNotEmpty(articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()) ) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
							Restrictions.eq("id.codigoProveedor", this.articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()) 
			);
		} else if (articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo() != null) {
			criterion = Restrictions.and(
					Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO), 
					Restrictions.eq("id.codigoUnidadManejo", this.articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo()) 
			);
		}
		return criterion;
	}	
}
