/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.restricciones;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.common.bodega.CalculoFechasUtil;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaEstadoDTO;

/**
 * Agrega restricciones genéricas sobre el objeto <code>DetalleTareaDTO</code> dependiendo de las propiedades que se asignen
 * @author acaiza
 *
 */
public class AndenesOcupadosRestriccion implements CriteriaRestriction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * DTO TareaDTO
	 */
	private TareaDTO tareaDTO;
	
	/**
	 * DTO TareaEstadoDTO
	 */
	TareaEstadoDTO tareaEstadoDTO;
	
	/**
	 * Constructor
	 * 
	 * @param tareaDTO Un TareaDTO
	 */
	public AndenesOcupadosRestriccion(TareaDTO tareaDTO, TareaEstadoDTO tareaEstadoDTO) {
		this.tareaDTO = tareaDTO;
		this.tareaEstadoDTO = tareaEstadoDTO;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		DetachedCriteria subSelect = DetachedCriteria.forClass(DetalleTareaDTO.class,"DT");
		subSelect.createAlias("DT.detalleSeccionOrigen", "DS"); 
		subSelect.createAlias("DT.tareaDTO", "T");
		subSelect.createAlias("T.tareaEstadoCol", "TE");
		
		RangeValue<Date> rangeValueFecha = CalculoFechasUtil.getInstancia().obtenerRangoFecha(tareaDTO.getFechaRegistro());
		
		subSelect.add(Restrictions.between("T.fechaRegistro", rangeValueFecha.getBottomValue(), rangeValueFecha.getTopValue()));
		
		if (tareaEstadoDTO != null) {
			subSelect.add(Restrictions.ne("TE.codigoCatalogoTipoRelacionado", tareaEstadoDTO.getCodigoCatalogoTipoRelacionado()));
			subSelect.add(Restrictions.ne("TE.codigoCatalogoValorRelacionado", tareaEstadoDTO.getCodigoCatalogoValorRelacionado()));
		}
		
		Projection projection = Projections.property("codigoDetalleSeccionOrigen");
		
		subSelect.setProjection(projection);
		
		return Subqueries.propertyNotIn("id.codigoDetalleSeccion", subSelect);
	}
	
}
