package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;

@SuppressWarnings("serial")
public class SubbodegasPorClasificacionesFuncionarioCompradorRestriction implements CriteriaRestriction {

	private Integer codigoCompania;
	private String codigoProveedor;
	private String codigoFuncionario;
	private Long codigoLineaComercial;

	/**
	 * 
	 * @param codigoFuncionario
	 */
	public SubbodegasPorClasificacionesFuncionarioCompradorRestriction(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoFuncionario
	 */
	public SubbodegasPorClasificacionesFuncionarioCompradorRestriction(Integer codigoCompania, String codigoProveedor, String codigoFuncionario) {
		this.codigoCompania = codigoCompania;
		this.codigoProveedor = codigoProveedor;
		this.codigoFuncionario = codigoFuncionario;
	}
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoFuncionario
	 */
	public SubbodegasPorClasificacionesFuncionarioCompradorRestriction(Integer codigoCompania, String codigoProveedor, String codigoFuncionario, Long codigoLineaComercial) {
		this.codigoCompania = codigoCompania;
		this.codigoProveedor = codigoProveedor;
		this.codigoFuncionario = codigoFuncionario;
		this.codigoLineaComercial = codigoLineaComercial;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		
		// Select
		DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioClasificacionDTO.class, "lineaComercialFuncionarioClasificacion");
		
		// Campos
		subSelectClaFun.setProjection(Projections.distinct(Projections.property("clasificacion.codigoBodega")));
		
		// Joins
		subSelectClaFun.createAlias("lineaComercialFuncionarioClasificacion.clasificacion", "clasificacion");
		
		// Where
		subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionarioClasificacion.codigoFuncionario", this.codigoFuncionario));
		subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionarioClasificacion.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		subSelectClaFun.add(Restrictions.eq("clasificacion.codigoTipoClasificacion", SICConstantes.TIPCLA_CLASIFICACION));
		
		if(codigoProveedor != null){
			subSelectClaFun.createAlias("clasificacion.proveedorClasificacionCol", "proveedorClasificacionCol");
			subSelectClaFun.add(Restrictions.eq("proveedorClasificacionCol.id.codigoCompania", this.codigoCompania));
			subSelectClaFun.add(Restrictions.eq("proveedorClasificacionCol.id.codigoProveedor", this.codigoProveedor));
			subSelectClaFun.add(Restrictions.eq("proveedorClasificacionCol.estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		}
		
		if(codigoLineaComercial != null){
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionarioClasificacion.codigoLineaComercialFuncionario", this.codigoLineaComercial));
		}
		
		return Subqueries.propertyIn("id.codigoBodega", subSelectClaFun);
	}

}
