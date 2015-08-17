/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class AlcanceArticuloBodegaRestriction implements CriteriaRestriction{
	private Integer codigoAreaTrabajoCD = null;
	private String pathIn;
	
	public AlcanceArticuloBodegaRestriction(Integer codigoAreaTrabajoCD, String pathIn){
		super();
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
		if(pathIn != null){
			this.pathIn=pathIn+".";
		}else{
			this.pathIn="";
		}
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Conjunction conjunction = null;
		
		try{
			conjunction = Restrictions.conjunction();
			conjunction.add(Restrictions.eq(pathIn.concat("estadoArticuloLocal"), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			Collection<Integer> areaTrabajo = new ArrayList<Integer>();
			areaTrabajo.add(codigoAreaTrabajoCD);
			conjunction.add(new BodegasEnCentroDistribucionRestriction(areaTrabajo, pathIn.concat("id.codigoLocal")).getCriteriaRestriction());
			//conjunction.add(Restrictions.le("fechaInicialAlcance", new Date()));
			//conjunction.add(Restrictions.ge("fechaFinalAlcance", new Date()));
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restriccion");
		}
		
		return conjunction;
	}

	public Integer getCodigoAreaTrabajoCD() {
		return codigoAreaTrabajoCD;
	}

	public void setCodigoAreaTrabajoCD(Integer codigoAreaTrabajoCD) {
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
	}

	public String getPathIn() {
		return pathIn;
	}

	public void setPathIn(String pathIn) {
		this.pathIn = pathIn;
	}
}
