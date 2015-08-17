/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public final class ClaseTemporadaRestriction implements CriteriaRestriction, Logeable{

	private List<String> codigoList = null;
	private Date fechaEntrega = null;
	private String propertyIn;
	
	public ClaseTemporadaRestriction(List<String> codigoList, Date fechaEntrega, String propertyIn){
		this.codigoList = codigoList;
		this.fechaEntrega = fechaEntrega;
		if(propertyIn != null){
			this.propertyIn=propertyIn;
		}else{
			this.propertyIn="claseArticulo";
		}
	}
	
	public Criterion getCriteriaRestriction(){
		try{
			return Restrictions.and(Restrictions.in(propertyIn, codigoList),
									Restrictions.or(Restrictions.ne(propertyIn, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_T),
												    Restrictions.and(Restrictions.eq(propertyIn, SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_T),
												    				 Subqueries.propertyCoalesce("art.id.codigoArticulo", ComparatorTypeEnum.EQUAL_COMPARATOR, "'0'", getDetachedCriteriaClaseVigente(fechaEntrega)))));
		} catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n de articulos clase T");
		}
	}
	
	private final DetachedCriteria getDetachedCriteriaClaseVigente(Date fechaEntrega) throws SICException{
		DetachedCriteria subSelectTemporada = null;
		try {
			subSelectTemporada = DetachedCriteria.forClass(ArticuloTemporadaDTO.class, "articuloTemporada");
			subSelectTemporada.setProjection(Projections.distinct(Projections.property("articuloTemporada.id.codigoArticulo")));
			subSelectTemporada.add(Restrictions.eqProperty("articuloTemporada.id.codigoArticulo","art.id.codigoArticulo"));
			subSelectTemporada.add(Restrictions.le("fechaInicioTemporada", fechaEntrega));
			subSelectTemporada.add(Restrictions.ge("fechaFinTemporada", fechaEntrega));
		} catch (Exception e) {
			LOG_SICV2.error("Error al armar la restriccion para verificar si los articulos de temporada estan vigentes.");
			throw new SICException("Error al armar restricci\u00F3n de art\u00EDculos de temporada.");
		}
		return subSelectTemporada;
	}

	/**
	 * @return the codigoList
	 */
	public List<String> getCodigoList() {
		return codigoList;
	}

	/**
	 * @param codigoList the codigoList to set
	 */
	public void setCodigoList(List<String> codigoList) {
		this.codigoList = codigoList;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getPropertyIn() {
		return propertyIn;
	}

	public void setPropertyIn(String propertyIn) {
		this.propertyIn = propertyIn;
	}
}
