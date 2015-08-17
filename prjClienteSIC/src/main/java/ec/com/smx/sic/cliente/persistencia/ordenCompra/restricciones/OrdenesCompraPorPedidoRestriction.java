package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.util.Date;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;

@SuppressWarnings("serial")
public class OrdenesCompraPorPedidoRestriction implements CriteriaRestriction{
	
	private SearchTemplateDTO<String> numeroOrdenCompra;
	private String property = null;
	private Date fechaPublicacionActual; 
	
	/**
	 * @param numeroOrdenCompra
	 * @param property
	 */
	public OrdenesCompraPorPedidoRestriction(SearchTemplateDTO<String> numeroOrdenCompra, String property, Date fechaPublicacionActual) {
		super();
		this.numeroOrdenCompra = numeroOrdenCompra;
		this.property = property;
		this.fechaPublicacionActual = fechaPublicacionActual;
	}


	@Override
	public Criterion getCriteriaRestriction() {
		Criterion criterion = null;
		try {
			DetachedCriteria subSelectOrdenCompraEstado;
			subSelectOrdenCompraEstado = DetachedCriteria.forClass(OrdenCompraEstadoDTO.class, "ordenCompraEstado");
			subSelectOrdenCompraEstado.setProjection(Projections.distinct(Projections.property("ordenCompra.codigoPedido")));
			subSelectOrdenCompraEstado.createAlias("ordenCompraEstado.ordenCompra", "ordenCompra");
									
			if (numeroOrdenCompra != null) {//fitro numero orden de compra
				subSelectOrdenCompraEstado.add(numeroOrdenCompra.addExpression());
			}
			subSelectOrdenCompraEstado.add(Restrictions.eqProperty("ordenCompra.codigoPedido", CriteriaSpecification.ROOT_ALIAS.concat(".id.codigoPedido")));
			subSelectOrdenCompraEstado.add(Restrictions.isNull("ordenCompraEstado.fechaFin"));
			subSelectOrdenCompraEstado.add(Restrictions.eq("ordenCompraEstado.estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			subSelectOrdenCompraEstado.add(Restrictions.eq("ordenCompraEstado.codigoEstadoCatVal", SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENVIADA));
			
			//Restricion de fecha de publicacion con flag NOB2B
			subSelectOrdenCompraEstado.add(Restrictions.or(Restrictions.and(Restrictions.isNull("ordenCompra.fechaPublicacion"), 
					 									   					Restrictions.and(Restrictions.isNotNull(CriteriaSpecification.ROOT_ALIAS.concat(".noB2B")), 
					 									   									 Restrictions.eq(CriteriaSpecification.ROOT_ALIAS.concat(".noB2B"), SICConstantes.ESTADO_INACTIVO_NUMERICO))), 
										    			   Restrictions.and(Restrictions.and(Restrictions.isNotNull("ordenCompra.fechaPublicacion"), 
																							 Restrictions.le("ordenCompra.fechaPublicacion", fechaPublicacionActual)),
																			Restrictions.or(Restrictions.isNull(CriteriaSpecification.ROOT_ALIAS.concat(".noB2B")), 
																						    Restrictions.eq(CriteriaSpecification.ROOT_ALIAS.concat(".noB2B"), SICConstantes.ESTADO_INACTIVO_NUMERICO)))));
						
			criterion = Subqueries.propertyIn(this.property, subSelectOrdenCompraEstado);
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n \u00F3rdenes de compra por pedido");
		}
		return criterion;
	}
}
