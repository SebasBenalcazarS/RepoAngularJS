/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Agrega restricciones genéricas sobre el objeto <code>ArticuloBitacoraCodigoBarrasDTO</code> dependiendo de las propiedades que se asignen
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
public class ArticuloCodigoBarrasRestriction implements CriteriaRestriction{
	
	/**
	 * Fecha de referencia específica para obtener el código de barras
	 */
	private Date valorFechaReferencia;
	/**
	 * Nombre de la propiedad de la fecha de transacción usada como referencia para obtener el código de barras, 
	 * esta propiedad deberá estar en el objeto raiz de la consulta
	 */
	private String nombrePropiedadFechaReferencia;

	/**
	 * Usado para crear la restricción en base a un valor de fecha específico
	 * @param valorFechaReferencia
	 */
	public ArticuloCodigoBarrasRestriction(Date valorFechaReferencia) {
		this.valorFechaReferencia = valorFechaReferencia;
	}
	
	/**
	 * Usado para crear la restricción en base a una propiedad que se verificará de forma dinámica por cada registro de la consulta 
	 * @param nombrePropiedadFechaReferencia
	 */
	public ArticuloCodigoBarrasRestriction(String nombrePropiedadFechaReferencia) {
		this.nombrePropiedadFechaReferencia = nombrePropiedadFechaReferencia;
	}
	
	//@Override
	public Criterion getCriteriaRestriction() {
		//segmento para agregar condición sobre el código de barras en base a una fecha
		if(nombrePropiedadFechaReferencia != null)
			//se realiza la restricción contra los campos timestamp
			return Restrictions.or(Restrictions.and(Restrictions.eq("estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO),
				Restrictions.leProperty("id.fechaInicialActivo", Criteria.ROOT_ALIAS.concat(".").concat(nombrePropiedadFechaReferencia))), Restrictions.and(Restrictions.leProperty("id.fechaInicialActivo", Criteria.ROOT_ALIAS.concat(".").concat(nombrePropiedadFechaReferencia)), Restrictions.geProperty("fechaFinalActivo", Criteria.ROOT_ALIAS.concat(".").concat(nombrePropiedadFechaReferencia))));
		else if(valorFechaReferencia != null)
			return Restrictions.or(Restrictions.and(Restrictions.eq("estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO),
					Restrictions.le("id.fechaInicialActivo", valorFechaReferencia)), Restrictions.and(Restrictions.le("id.fechaInicialActivo", valorFechaReferencia), Restrictions.ge("fechaFinalActivo", valorFechaReferencia)));
		return null;
	}
}
