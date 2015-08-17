package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class CodigosEntidadesRestriction implements CriteriaRestriction {

	private String parameterPatternPersona;
	private String parameterPatternLocalizacion;
	private Map<String, Set<Long>> codigosEntidades;

	public CodigosEntidadesRestriction(Map<String, Set<Long>> codigosEntidades, 
			String parameterPatternPersona, String parameterPatternLocalizacion) {
		this.parameterPatternPersona = parameterPatternPersona;
		this.parameterPatternLocalizacion = parameterPatternLocalizacion;
		this.codigosEntidades = codigosEntidades;

	}

	@Override
	public Criterion getCriteriaRestriction() {

		Criterion criterionPersona;
		Criterion criterionLocalizacion;

		// Existe codigos de entidades
		if (MapUtils.isNotEmpty(this.codigosEntidades)) {

			criterionPersona = null;
			criterionLocalizacion = null;

			// Armar criterio con los codigos de Persona			
			if (this.codigosEntidades.containsKey(TipoPersonaEntidad.PERSONA_NATURAL.getValorTipoPersonaEntidad())) {
				// Si existe un codigo de Persona arma una restricciopn (IGUAL) caso contrario (IN)
				criterionPersona = this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_NATURAL.getValorTipoPersonaEntidad()).size() == 1 ?
						Restrictions.eq(this.parameterPatternPersona, this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_NATURAL.getValorTipoPersonaEntidad()).iterator().next()) 
						: Restrictions.in(this.parameterPatternPersona, this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_NATURAL.getValorTipoPersonaEntidad()));
			}

			// Armar criterio con los codigos de Localizacion			
			if (this.codigosEntidades.containsKey(TipoPersonaEntidad.PERSONA_JURIDICA.getValorTipoPersonaEntidad())) {
				// Si existe un codigo de Localizacion arma una restricciopn (IGUAL) caso contrario (IN)
				criterionLocalizacion = this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_JURIDICA.getValorTipoPersonaEntidad()).size() == 1 ?
						Restrictions.eq(this.parameterPatternLocalizacion, this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_JURIDICA.getValorTipoPersonaEntidad()).iterator().next()) 
						: Restrictions.in(this.parameterPatternLocalizacion, this.codigosEntidades.get(TipoPersonaEntidad.PERSONA_JURIDICA.getValorTipoPersonaEntidad()));
			}

			// Retornar filtro OR con los codigos de Persona y Localizacion
			if (criterionPersona != null && criterionLocalizacion != null) {

				Disjunction orCodigosEntidades = Restrictions.disjunction();				
				orCodigosEntidades.add(criterionPersona);
				orCodigosEntidades.add(criterionLocalizacion);

				return orCodigosEntidades;
			}

			// Retornar filtro con los codigos de Persona
			if (criterionPersona != null) {
				return criterionPersona;
			}

			// Retornar filtro con los codigos de Localizacion
			if (criterionLocalizacion != null) {
				return criterionLocalizacion;
			}
		}

		return null;
	}

}
