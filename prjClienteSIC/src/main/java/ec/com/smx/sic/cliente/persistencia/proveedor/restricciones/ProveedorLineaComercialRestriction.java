/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.proveedor.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class ProveedorLineaComercialRestriction implements CriteriaRestriction{
	
	private String codigoFuncionario = null;
	private String codigoSubbodega = null;
	private String codigoClasificacion = null;
	private String codigoDepartamento = null;
	private String propertyIn = null;
	private Long codigoLineaComercial = null;
	
	public ProveedorLineaComercialRestriction(String codigoFuncionario, String codigoSubbodega, String codigoClasificacion, String codigoDepartamento, String propertyIn){
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoSubbodega = codigoSubbodega;
		this.codigoClasificacion = codigoClasificacion;
		this.codigoDepartamento = codigoDepartamento;
		this.propertyIn = propertyIn;
	}
	
	public ProveedorLineaComercialRestriction(String codigoFuncionario, String codigoSubbodega, String codigoClasificacion, String codigoDepartamento, String propertyIn, Long codigoLineaComercial){
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoSubbodega = codigoSubbodega;
		this.codigoClasificacion = codigoClasificacion;
		this.codigoDepartamento = codigoDepartamento;
		this.propertyIn = propertyIn;
		this.codigoLineaComercial = codigoLineaComercial;
	}

	@Override
	public Criterion getCriteriaRestriction() {
		 Criterion criterion = null;
			
			try{
				DetachedCriteria subCriteriaCodProvArt;
				
				subCriteriaCodProvArt = DetachedCriteria.forClass(ProveedorClasificacionDTO.class, "proveedorClasificacion");
				subCriteriaCodProvArt.setProjection(Projections.property("proveedorClasificacion.id.codigoProveedor"));
				subCriteriaCodProvArt.add(new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(codigoFuncionario, 
						codigoSubbodega, codigoClasificacion, codigoDepartamento, codigoLineaComercial, "id.codigoClasificacion").getCriteriaRestriction());
				
				criterion = Subqueries.propertyIn(this.propertyIn, subCriteriaCodProvArt);
				
			}catch(Exception e){
				throw new SICException("Se produjo un error al momento de armar la restricci�n");
			}
			
			return criterion;
		}
	

}
