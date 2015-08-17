package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.FuncionarioPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;

@SuppressWarnings("serial")

public class ProveedorFunPerLocRestriction implements CriteriaRestriction {
	private Integer codigoCompania;
	private TipoPersonaEntidad tipoEntidadProveedorSuperUsuario;
	private String codigoFuncionario;
	
	public ProveedorFunPerLocRestriction(Integer codigoCompania, String codigoFuncionario, TipoPersonaEntidad tipoEntidadProveedorSuperUsuario){
		this.codigoCompania = codigoCompania;
		this.codigoFuncionario = codigoFuncionario;
		this.tipoEntidadProveedorSuperUsuario = tipoEntidadProveedorSuperUsuario;
	}
	@Override	
		public Criterion getCriteriaRestriction() {
			DetachedCriteria subCriteriaFunPerLoc;
			
			subCriteriaFunPerLoc = DetachedCriteria.forClass(FuncionarioPersonaLocalizacionDTO.class,"ALIAS_FUNPERLOC");
			subCriteriaFunPerLoc.add(Restrictions.eq("ALIAS_FUNPERLOC.estado", CorporativoConstantes.ESTADO_ACTIVO));
			subCriteriaFunPerLoc.add(Restrictions.eq("ALIAS_FUNPERLOC.id.codigoCompania", this.codigoCompania));
			subCriteriaFunPerLoc.add(Restrictions.eq("ALIAS_FUNPERLOC.tipoRelacionFuncionario", CorporativoConstantes.TIPO_FUNCIONARIO_PROPIETARIO));
			subCriteriaFunPerLoc.add(Restrictions.eq("ALIAS_FUNPERLOC.codigoTipoRelacionFuncionario", TiposCatalogoConstantes.TIPO_FUNCIONARIO_PERSONA_LOCALIZACION));
			subCriteriaFunPerLoc.add(new ProveedorFunRelRestriction(this.codigoCompania,this.codigoFuncionario).getCriteriaRestriction());
			
			if( TipoPersonaEntidad.PERSONA_NATURAL.equals(tipoEntidadProveedorSuperUsuario)){							
				subCriteriaFunPerLoc.setProjection(Projections.property("ALIAS_FUNPERLOC.codigoPersona"));	
				return Subqueries.propertyIn("codigoPersona", subCriteriaFunPerLoc);
				
			} else if (TipoPersonaEntidad.PERSONA_JURIDICA.equals(tipoEntidadProveedorSuperUsuario)) {						
				subCriteriaFunPerLoc.setProjection(Projections.property("ALIAS_FUNPERLOC.codigoLocalizacion"));
				return Subqueries.propertyIn("codigoLocalizacionProveedor", subCriteriaFunPerLoc);			
			}
			return null;
	}
}

