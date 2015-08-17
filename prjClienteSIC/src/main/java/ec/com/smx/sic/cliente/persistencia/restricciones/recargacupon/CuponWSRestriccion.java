/*
 * Creado el 2013-04-12
 */
package ec.com.smx.sic.cliente.persistencia.restricciones.recargacupon;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * Agrega restricciones genericas para consulta del webservice actualizarDatos.
 * 
 * @author fvallejo
 * 
 */

@SuppressWarnings("serial")
public class CuponWSRestriccion implements CriteriaRestriction {

	/**
	 * Fecha especifica para obtener cupones
	 */
	private Date valorFechaUltimaActualizacion;

	/**
	 * Indica si es una restriccion para cupones con mejor ahorro
	 */
	private Boolean isMejorAhorro;

	/**
	 * Usado para crear la restriccion en base a un valor de fecha especifico
	 * 
	 * @param valorFechaReferencia
	 */
	public CuponWSRestriccion(Date valorFechaUltimaActualizacion, Boolean isMejorAhorro) {
		this.valorFechaUltimaActualizacion = valorFechaUltimaActualizacion;
		this.isMejorAhorro = isMejorAhorro;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		if (isMejorAhorro) {
			return Restrictions.or(Restrictions.ge("fechaUltimaActualizacion", valorFechaUltimaActualizacion),Restrictions.or(Restrictions.ge("articuloAgrupadorCol.fechaRegistro", valorFechaUltimaActualizacion), Restrictions.ge("articuloAgrupadorCol.fechaModificacion", valorFechaUltimaActualizacion)));
		} else {
			return Restrictions.or(Restrictions.ge("fechaUltimaActualizacion", valorFechaUltimaActualizacion), Restrictions.or(Restrictions.or(Restrictions.ge("articuloDefinicionArchivoCol.fechaRegistro", valorFechaUltimaActualizacion), Restrictions.ge("articuloDefinicionArchivoCol.fechaModificacion", valorFechaUltimaActualizacion)), Restrictions.or(Restrictions.or(Restrictions.ge("articuloLeyendaCol.fechaRegistro", valorFechaUltimaActualizacion), Restrictions.ge("articuloLeyendaCol.fechaModificacion", valorFechaUltimaActualizacion)), Restrictions.or(Restrictions.and(Restrictions.eq("articuloAgrupadorCol.id.valorTipoAgrupador", SICArticuloConstantes.getInstancia().CATALOGOVALOR_GRUPOCLIENTE_ESPECIAL_MEJOR_AHORRO), Restrictions.ge("articuloAgrupadorCol.fechaRegistro", valorFechaUltimaActualizacion)), Restrictions.and(Restrictions.eq("articuloAgrupadorCol.id.valorTipoAgrupador", SICArticuloConstantes.getInstancia().CATALOGOVALOR_GRUPOCLIENTE_ESPECIAL_MEJOR_AHORRO), Restrictions.ge("articuloAgrupadorCol.fechaModificacion", valorFechaUltimaActualizacion))))));
		}

	}

}
