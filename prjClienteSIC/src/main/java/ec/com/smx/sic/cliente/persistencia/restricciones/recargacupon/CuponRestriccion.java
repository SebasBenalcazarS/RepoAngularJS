/*
 * Creado el 2013-04-12
 */
package ec.com.smx.sic.cliente.persistencia.restricciones.recargacupon;

import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * Agrega restricciones genericas.
 * 
 * @author fvallejo
 * 
 */

@SuppressWarnings("serial")
public class CuponRestriccion implements CriteriaRestriction {

	/**
	 * Fecha especifica para obtener cupones
	 */
	private Date valorFechaProceso;
	/**
	 * Estado del cupon
	 */
	private String estado;
	/**
	 * Estado del cupon
	 */
	private boolean vista;
	
	/**
	 * Indica si se aplica a la vista para el web service.
	 */
	private boolean webService;

	/**
	 * Usado para crear la restriccion en base a un valor de fecha especifico
	 * 
	 * @param valorFechaReferencia
	 */
	public CuponRestriccion(Date valorFechaProceso) {
		this.valorFechaProceso = valorFechaProceso;
	}
	/**
	 * Se crea la restriccion para traer los cupones VIG y NVI (dada una fecha)
	 * @param estado
	 */
	public CuponRestriccion(String estado, Date valorFechaProceso) {
		this.estado = estado;
		this.valorFechaProceso = valorFechaProceso;
	}
	/**
	 * Se crea la restriccion para traer los cupones VIG y NVI (dada una fecha)
	 * @param estado
	 */
	public CuponRestriccion(String estado, Date valorFechaProceso, boolean aplicaAVista) {
		this.estado = estado;
		this.valorFechaProceso = valorFechaProceso;
		this.vista = aplicaAVista;
	}
	/**
	 * Se crea la restriccion para traer los cupones VIG y NVI (dada una fecha, usado en los web service)
	 * @param valorFechaProceso
	 * @param aplicaAWS
	 */
	public CuponRestriccion( Date valorFechaProceso, boolean aplicaAWS) {
		this.valorFechaProceso = valorFechaProceso;
		this.webService = aplicaAWS;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		//Criterio por fecha, obtencion de cupones en cuyo rango de fechas no se encuentre la fecha enviada
		if(estado == null){
			if(this.webService){
				return Restrictions.or(
						Restrictions.ge("fechaRegistro", valorFechaProceso),
						Restrictions.ge("fechaModificacion", valorFechaProceso));
			}else{
				return Restrictions.or(
						Restrictions.gt("fechaInicioTemporada", valorFechaProceso),
						Restrictions.lt("fechaFinTemporada", valorFechaProceso));
			}
		}//Criterio para obtener los cupones vigentes y los no vigentes cuyo estado se haya procesado en una fecha
		else{
			//Aplica a las tablas
			Date fechaValorProcesoInicial = ConverterUtil.addDate(valorFechaProceso, -1);
			Criterion criterionNVI = null;
			if(!this.vista){
				criterionNVI = Restrictions.and(Restrictions.eq("codigoEstado", SICArticuloConstantes.getInstancia().ESTADOARTICULO_NOVIGENTE),
						Restrictions.and(Restrictions.ge(SearchDTO.getPropertyAlias("articuloDTO.articuloBitacoraEstadoCol")+".fechaRegistro", fechaValorProcesoInicial), 
								Restrictions.le(SearchDTO.getPropertyAlias("articuloDTO.articuloBitacoraEstadoCol")+".fechaRegistro", this.valorFechaProceso)));			
			}
			else{
				criterionNVI = Restrictions.and(Restrictions.eq("codigoEstado", SICArticuloConstantes.getInstancia().ESTADOARTICULO_NOVIGENTE),
						Restrictions.and(Restrictions.ge("fechaRegistroEstado", fechaValorProcesoInicial), 
								Restrictions.le("fechaRegistroEstado", this.valorFechaProceso)));
			}
			Criterion criterion = Restrictions.or(Restrictions.eq("codigoEstado", estado), criterionNVI);
			return criterion;
		}
	}

}
