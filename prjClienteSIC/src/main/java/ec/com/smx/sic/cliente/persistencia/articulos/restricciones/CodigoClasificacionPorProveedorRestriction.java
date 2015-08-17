/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class CodigoClasificacionPorProveedorRestriction implements CriteriaRestriction{

	private String codigoFuncionario = null;
	private String codigoProveedor = null;
	private String codigoBodega = null;
	private String codigoClasificacion = null;
	private String codigoDepartamento = null;
	private Long codigoLineaComercial = null;
	private String propertyIn = null;
	
	public CodigoClasificacionPorProveedorRestriction(String codigoFuncionario, String codigoBodega, String codigoClasificacion, String codigoDepartamento, 
			Long codigoLineaComercial, String propertyIn, String codigoProveedor) {
		
		this.codigoFuncionario = codigoFuncionario;
		this.codigoProveedor = codigoProveedor;
		this.codigoBodega = codigoBodega;
		this.codigoClasificacion = codigoClasificacion;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoLineaComercial = codigoLineaComercial;
		this.propertyIn = propertyIn;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		
		try{
			
			DetachedCriteria subSelectCodCla = DetachedCriteria.forClass(ClasificacionDTO.class, "clasif");
			
			// Si se desea consultar el departamento
			if(this.codigoDepartamento != null && this.codigoClasificacion == null)
				subSelectCodCla.setProjection(Projections.distinct(Projections.property("clasif.codigoClasificacionPadre")));
			// Si se desea consultar la clasificacion
			else if(this.codigoDepartamento == null && this.codigoClasificacion != null)
				subSelectCodCla.setProjection(Projections.distinct(Projections.property("clasif.id.codigoClasificacion")));
				
			subSelectCodCla.createAlias("clasif.proveedorClasificacionCol", "proveedorClasificacion");
			
			// Clasificacion
			subSelectCodCla.add(Restrictions.eq("clasif.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			// Restriccion de articulos por clasificaciones asignadas a las lineas comerciales del funcionario
			subSelectCodCla.add(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(codigoFuncionario, codigoBodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial, "clasif.id.codigoClasificacion").getCriteriaRestriction());

			// Clasificacion proveedor
			subSelectCodCla.add(Restrictions.eq("proveedorClasificacion.id.codigoProveedor", codigoProveedor));
			subSelectCodCla.add(Restrictions.eq("proveedorClasificacion.estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			criterion = Subqueries.propertyIn(this.propertyIn, subSelectCodCla);

		} catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restriccion");
		}
		
		return criterion;
	}
	

}
