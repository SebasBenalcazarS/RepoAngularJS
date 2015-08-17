/*
 * Creado el 2013-06-17
 */
package ec.com.smx.sic.cliente.persistencia.restricciones.recargacupon;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;

/**
 * Agrega restricciones genericas.
 * 
 * @author mrivera
 * 
 */

@SuppressWarnings("serial")
public class FechaRestriccion implements CriteriaRestriction {

	/**
	 * Fecha especifica para obtener cupones
	 */
	private Date valorFechaProceso;
	/**
	 * Indica si se aplica a la vista para el web service.
	 */
	private Boolean valorTipoFecha;

	/**
	 * Usado para crear la restriccion en base a un valor de fecha especifico
	 * OR con fecha es creacion y ultima actualizacion
	 * @param valorFechaReferencia
	 */
	public FechaRestriccion(Date valorFechaProceso) {
		this.valorFechaProceso = valorFechaProceso;
	}
	
	/**
	 * Usado para crear la restriccion en base a un valor de fecha especifico
	 * @param valorFechaReferencia
	 * @param valorTipoFecha  si es null: OR con fecha es creacion y ultima actualizacion, si es TRUE: OR con fecha es registro y modificacion, caso contrario OR con fecha es registerDate y lastModificationDate
	 */
	public FechaRestriccion(Date valorFechaProceso, Boolean valorTipoFecha) {
		this.valorFechaProceso = valorFechaProceso;
		this.valorTipoFecha = valorTipoFecha;
	}

	
	@Override
	public Criterion getCriteriaRestriction() {
		//Si no envia tipo, la fecha es creacion y ultima actualizacion
		if(valorTipoFecha == null){			
			return Restrictions.or(
					Restrictions.ge("fechaCreacion", valorFechaProceso),
					Restrictions.ge("fechaUltimaActualizacion", valorFechaProceso));
		}
		//Si se especifica TRUE, la fecha es registro y modificacion
		else if(valorTipoFecha){
			return Restrictions.or(
					Restrictions.ge("fechaRegistro", valorFechaProceso),
					Restrictions.ge("fechaModificacion", valorFechaProceso));
		}

		//Si se especifica FALSE, la fecha es registerDate y lastModificationDate
		else{
			return Restrictions.or(
					Restrictions.ge("registerDate", valorFechaProceso),
					Restrictions.ge("lastModificationDate", valorFechaProceso));
		}
	}	

}
