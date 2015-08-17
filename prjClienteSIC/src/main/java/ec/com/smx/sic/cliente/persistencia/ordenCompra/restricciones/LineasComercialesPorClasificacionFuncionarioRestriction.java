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
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class LineasComercialesPorClasificacionFuncionarioRestriction implements CriteriaRestriction{
	
	private String codigoFuncionario = null;
	private String propertyIn = null;
	private ArrayList<String> codigoClasificacionList = null;
	private String codigoProveedor;
	private Integer nivel;

	/**
	 * 
	 * @param codigoFuncionario
	 * @param codigoSubbodega
	 * @param codigoClasificacion
	 * @param codigoDepartamento
	 * @param propertyIn
	 */
	public LineasComercialesPorClasificacionFuncionarioRestriction(String codigoFuncionario, 
																   ArrayList<String> codigoClasificacionList, 
																   String propertyIn,
																   String codigoProveedor,
																   Integer nivelLinea) {
		super();
		this.codigoFuncionario = codigoFuncionario;
		this.codigoClasificacionList = codigoClasificacionList;
		this.propertyIn = propertyIn;
		this.codigoProveedor = codigoProveedor;
		this.nivel = nivelLinea;
		
	}

	@Override
	public Criterion getCriteriaRestriction() throws SICException {
		 Criterion criterion = null;
		
		try{
			DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioDTO.class, "lineaComercialFuncionario");
			subSelectClaFun.setProjection(Projections.distinct(Projections.property("lineaComercialClasificaciones.codigoLineaComercial")));
			subSelectClaFun.createAlias("lineaComercialFuncionario.lineaComercial", "lineaComercial");
			subSelectClaFun.createAlias("lineaComercial.lineaComercialClasificaciones", "lineaComercialClasificaciones");
			subSelectClaFun.createAlias("lineaComercialClasificaciones.clasificacion", "clasificacion");
			subSelectClaFun.createAlias("clasificacion.proveedorClasificacionCol", "proveedorClasificacionCol");
			if(this.nivel != null){
				subSelectClaFun.add(Restrictions.eq("lineaComercial.nivel", this.nivel));
			}
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionario.id.codigoFuncionario", this.codigoFuncionario));
			subSelectClaFun.add(Restrictions.eq("lineaComercialFuncionario.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			subSelectClaFun.add(Restrictions.eq("lineaComercialClasificaciones.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			subSelectClaFun.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectClaFun.add(Restrictions.eq("clasificacion.codigoTipoClasificacion", SICConstantes.getInstancia().TIPCLA_CLASIFICACION));

			if(!CollectionUtils.isEmpty(codigoClasificacionList)){
				subSelectClaFun.add(Restrictions.in("clasificacion.id.codigoClasificacion", codigoClasificacionList));
			}else if(this.codigoProveedor != null){
				subSelectClaFun.add(Restrictions.eq("proveedorClasificacionCol.id.codigoProveedor", this.codigoProveedor));
				subSelectClaFun.add(Restrictions.eq("proveedorClasificacionCol.estadoProveedorClasificacion", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			}
			criterion = Subqueries.propertyIn(this.propertyIn, subSelectClaFun);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci�n");
		}
		
		return criterion;
	}

}
