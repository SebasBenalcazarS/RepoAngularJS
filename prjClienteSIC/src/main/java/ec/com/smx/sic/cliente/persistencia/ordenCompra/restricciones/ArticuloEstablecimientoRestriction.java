/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class ArticuloEstablecimientoRestriction implements CriteriaRestriction {
	
	private Integer codigoCompania;
	private ArrayList<Long> codigosLineasComerciales;
	private ArrayList<String> referenciasLineasComerciales;
	private String propertyIn;
	private String codigoArticuloPropertyEq;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosEstablecimientos
	 * @param propertyIn
	 */
	public ArticuloEstablecimientoRestriction(Integer codigoCompania, ArrayList<Long> codigosLineasComerciales, ArrayList<String> referenciasLineasComerciales,   
			String propertyIn, String codigoArticuloPropertyEq) {
		super();
		this.codigoCompania = codigoCompania;
		this.codigosLineasComerciales = codigosLineasComerciales;
		this.referenciasLineasComerciales = referenciasLineasComerciales;
		this.propertyIn = propertyIn;
		this.codigoArticuloPropertyEq = codigoArticuloPropertyEq;
	}
	
	@Override
	public Criterion getCriteriaRestriction() throws SICException {
		 Criterion criterion = null;
		
		try{
			DetachedCriteria subSelectLinCom = DetachedCriteria.forClass(LineaComercialDTO.class, "lineaComercialDTO");
			subSelectLinCom.setProjection(Projections.distinct(Projections.property("lineaComercialDTO.codigoEstablecimiento")));
			subSelectLinCom.add(Restrictions.eq("lineaComercialDTO.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			if(!CollectionUtils.isEmpty(this.codigosLineasComerciales)){
				subSelectLinCom.add(Restrictions.in("lineaComercialDTO.id.codigoLineaComercial", this.codigosLineasComerciales));
			}else{
				subSelectLinCom.add(Restrictions.in("lineaComercialDTO.codigoReferencia", this.referenciasLineasComerciales));
			}
			
			DetachedCriteria subSelectArtEst = DetachedCriteria.forClass(ArticuloEstablecimientoDTO.class, "articuloEstablecimientoDTO");
			subSelectArtEst.setProjection(Projections.distinct(Projections.property("articuloEstablecimientoDTO.id.codigoArticulo")));
			subSelectArtEst.createAlias("articuloEstablecimientoDTO.establecimientoDTO", "establecimientoDTO");
			subSelectArtEst.add(Restrictions.eqProperty("articuloEstablecimientoDTO.id.codigoArticulo", this.codigoArticuloPropertyEq));
			subSelectArtEst.add(Restrictions.eq("articuloEstablecimientoDTO.estadoArticuloEstablecimiento", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectArtEst.add(Restrictions.or(
					Subqueries.propertyIn("establecimientoDTO.id.codigoEstablecimiento", subSelectLinCom),
					Subqueries.propertyIn("establecimientoDTO.codigoEstablecimientoPadre", subSelectLinCom)));
			
			criterion = Subqueries.propertyIn(this.propertyIn, subSelectArtEst);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}

	/**
	 * @return the codigosLineasComerciales
	 */
	public ArrayList<Long> getCodigosLineasComerciales() {
		return codigosLineasComerciales;
	}

	/**
	 * @param codigosLineasComerciales the codigosLineasComerciales to set
	 */
	public void setCodigosLineasComerciales(ArrayList<Long> codigosLineasComerciales) {
		this.codigosLineasComerciales = codigosLineasComerciales;
	}

	/**
	 * @return the referenciasLineasComerciales
	 */
	public ArrayList<String> getReferenciasLineasComerciales() {
		return referenciasLineasComerciales;
	}

	/**
	 * @param referenciasLineasComerciales the referenciasLineasComerciales to set
	 */
	public void setReferenciasLineasComerciales(ArrayList<String> referenciasLineasComerciales) {
		this.referenciasLineasComerciales = referenciasLineasComerciales;
	}

	/**
	 * @return the codigoArticuloPropertyEq
	 */
	public String getCodigoArticuloPropertyEq() {
		return codigoArticuloPropertyEq;
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the propertyIn
	 */
	public String getPropertyIn() {
		return propertyIn;
	}

	/**
	 * @param propertyIn the propertyIn to set
	 */
	public void setPropertyIn(String propertyIn) {
		this.propertyIn = propertyIn;
	}

	/**
	 * @param codigoArticuloPropertyEq the codigoArticuloPropertyEq to set
	 */
	public void setCodigoArticuloPropertyEq(String codigoArticuloPropertyEq) {
		this.codigoArticuloPropertyEq = codigoArticuloPropertyEq;
	}
	
}
