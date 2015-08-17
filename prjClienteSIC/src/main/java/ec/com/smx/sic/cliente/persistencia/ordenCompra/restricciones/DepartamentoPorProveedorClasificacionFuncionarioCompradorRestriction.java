/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class DepartamentoPorProveedorClasificacionFuncionarioCompradorRestriction implements CriteriaRestriction {

	private String codigoFuncionario = null;
	private String codigoProveedor = null;
	private String codigoSubbodega = null;
	private String codigoClasificacion = null;
	private String codigoDepartamento = null;
	
	/**
	 * 
	 * @param codigoFuncionario
	 * @param codigoProveedor
	 * @param codigoSubbodega
	 * @param codigoClasificacion
	 * @param codigoDepartamento
	 */
	public DepartamentoPorProveedorClasificacionFuncionarioCompradorRestriction(String codigoFuncionario, String codigoProveedor, String codigoSubbodega, String codigoClasificacion, String codigoDepartamento){
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoProveedor = codigoProveedor;
		this.codigoSubbodega = codigoSubbodega;
		this.codigoClasificacion = codigoClasificacion;
		this.codigoDepartamento = codigoDepartamento;
	}
	
	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		DetachedCriteria subSelectClaFun = null;
		DetachedCriteria subSelectProCla = null;
		
		try{
			//sub select de linea comercial
			subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioDTO.class, "lineaComercialFuncionario");
			subSelectClaFun.setProjection(Projections.distinct(Projections.property("clasificacion.codigoClasificacionPadre")));
			subSelectClaFun.createAlias("lineaComercialFuncionario.lineaComercial", "lineaComercial");
			subSelectClaFun.createAlias("lineaComercial.lineaComercialClasificaciones", "lineaComercialClasificaciones");
			subSelectClaFun.createAlias("lineaComercialClasificaciones.clasificacion", "clasificacion");

			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionario.id.codigoFuncionario", this.codigoFuncionario));
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionario.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			subSelectClaFun.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectClaFun.add(Restrictions.eq("clasificacion.codigoTipoClasificacion", SICConstantes.getInstancia().TIPCLA_CLASIFICACION));
			if(this.codigoSubbodega != null){
				subSelectClaFun.add(Restrictions.eq("clasificacion.codigoBodega", this.codigoSubbodega));
			}
			if(this.codigoClasificacion != null){
				subSelectClaFun.add(Restrictions.eq("clasificacion.id.codigoClasificacion", this.codigoClasificacion));
			}
			if(this.codigoDepartamento != null){ 
				subSelectClaFun.add(Restrictions.eq("clasificacion.codigoClasificacionPadre", this.codigoDepartamento));
			}
			
			//sub select de proveedorClasificacion
			subSelectProCla = DetachedCriteria.forClass(ProveedorClasificacionDTO.class, "proveedorClasificacion");
			subSelectProCla.setProjection(Projections.property("proveedorClasificacion.id.codigoClasificacion"));
			
			subSelectProCla.add(Restrictions.eq("proveedorClasificacion.id.codigoProveedor", this.codigoProveedor));
			subSelectProCla.add(Restrictions.eq("proveedorClasificacion.estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));

			subSelectClaFun.add(Subqueries.propertyIn("clasificacion.id.codigoClasificacion", subSelectProCla));
			
			criterion = Subqueries.propertyEq("id.codigoClasificacion", subSelectClaFun);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}

}
