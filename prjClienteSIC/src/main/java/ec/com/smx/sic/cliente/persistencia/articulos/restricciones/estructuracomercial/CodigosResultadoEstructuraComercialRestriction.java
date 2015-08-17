/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.restricciones.estructuracomercial;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class CodigosResultadoEstructuraComercialRestriction extends BaseCriteriaRestriction{

	private Collection<ClasificacionDTO> clasificacionesSeleccionadas;	
	private String alias;
	private String codigoProveedor;
	private String codigoBodega;
	private Integer codigoCompania;
	private String codigoFuncionario;
	
	public CodigosResultadoEstructuraComercialRestriction(Integer codigoCompania, String codigoFuncionario, String codigoProveedor, String codigoBodega, Collection<ClasificacionDTO> clasificacionesSeleccionadas, String alias){
		this.codigoCompania = codigoCompania;
		this.codigoFuncionario = codigoFuncionario;
		this.clasificacionesSeleccionadas = clasificacionesSeleccionadas;
		this.alias = alias;
		this.codigoProveedor = codigoProveedor;
		this.codigoBodega = codigoBodega;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		
		Conjunction conjunctionFinal = Restrictions.conjunction(); 
		Conjunction conjunctionClasificaciones = Restrictions.conjunction(); 
		Conjunction conjunctionDivisiones = Restrictions.conjunction(); 
		Disjunction disjunction = Restrictions.disjunction();
		
		Collection<ClasificacionDTO> listaClasificacion = new ArrayList<ClasificacionDTO>();
		
		for(ClasificacionDTO division : clasificacionesSeleccionadas){
			if(CollectionUtils.isNotEmpty(division.getClasificacionCol())){
				for(ClasificacionDTO departamento : division.getClasificacionCol()){
					if(CollectionUtils.isNotEmpty(departamento.getClasificacionCol())){
						listaClasificacion.addAll(departamento.getClasificacionCol());
					}
				}
			}
		}
		
		// clasificaciones y subclasificaciones
		if(CollectionUtils.isNotEmpty(listaClasificacion)){
			conjunctionClasificaciones.add(new ClasificacionSubClasificacionRestriction(listaClasificacion, alias).getCriteriaRestriction());
			disjunction.add(conjunctionClasificaciones);
		}
		
		// divisiones y departamentos
		Criterion criterion = new NivelEstructuraComercialRestriction(codigoCompania, codigoFuncionario, codigoProveedor, codigoBodega, clasificacionesSeleccionadas).getCriteriaRestriction(); 
		if(criterion != null){
			conjunctionDivisiones.add(criterion);
			disjunction.add(conjunctionDivisiones);
		}

		if(CollectionUtils.isEmpty(listaClasificacion) && criterion == null)
			return null;
		else
			return conjunctionFinal.add(disjunction);
	}

}
