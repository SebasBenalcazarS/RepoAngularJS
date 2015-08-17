/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class ProveedorPorProveedorClasificacionFuncionarioCompradorRestriction implements CriteriaRestriction {

	private String codigoFuncionario = null;

	/**
	 * 
	 * @param codigoFuncionario
	 */
	public ProveedorPorProveedorClasificacionFuncionarioCompradorRestriction(String codigoFuncionario) {
		super();
		this.codigoFuncionario = codigoFuncionario;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		
		try{
			DetachedCriteria subSelectProCla = DetachedCriteria.forClass(ProveedorClasificacionDTO.class, "proveedorClasificacion");
			subSelectProCla.setProjection(Projections.distinct(Projections.property("proveedorClasificacion.id.codigoProveedor")));
			
			subSelectProCla.add(Restrictions.eqProperty("proveedorClasificacion.id.codigoProveedor", CriteriaSpecification.ROOT_ALIAS.concat(".id.codigoProveedor")));
			subSelectProCla.add(Restrictions.eq("proveedorClasificacion.estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectProCla.add(
					(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(this.codigoFuncionario, null, null, null, null, "id.codigoClasificacion")).getCriteriaRestriction()
			);
			
			criterion = Subqueries.propertyEq("id.codigoProveedor", subSelectProCla);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}
}
