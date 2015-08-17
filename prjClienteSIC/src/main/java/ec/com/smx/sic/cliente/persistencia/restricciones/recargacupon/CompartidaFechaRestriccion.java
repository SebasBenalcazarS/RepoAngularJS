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
public class CompartidaFechaRestriccion implements CriteriaRestriction {

	/**
	 * Fecha especifica para obtener cupones
	 */
	private Date valorFechaProceso;
	
	/**
	 * Usado para crear la restriccion en base a un valor de fecha especifico
	 * OR con fecha es creacion y ultima actualizacion
	 * @param valorFechaReferencia
	 */
	public CompartidaFechaRestriccion(Date valorFechaProceso) {
		this.valorFechaProceso = valorFechaProceso;
	}

	
	@Override
	public Criterion getCriteriaRestriction() {
		return Restrictions.or(
				Restrictions.ge("fechaModificacion", valorFechaProceso),
				Restrictions.or(
						Restrictions.ge("listaClientePedidoDtoCol.fechaRegistro", valorFechaProceso),
						Restrictions.ge("listaClientePedidoDtoCol.fechaModificacion", valorFechaProceso)));
	}	

}
