/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraHistoricoEstadoDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
public class OrdenCompraDisponibleEntregaRestriction implements CriteriaRestriction {

	private String propertyAliasOrdenCompraEstado;
	private String propertyAliasPedido;
	private String propertyAliasOrdenCompraDetalleEstado;
	private boolean comparaCantidadEntrega;
	private Boolean validarPorFechaEntrega;
	
	public OrdenCompraDisponibleEntregaRestriction(String propertyAliasOrdenCompraEstado, String propertyAliasPedido, 
			String propertyAliasOrdenCompraDetalleEstado, boolean comparaCantidadEntrega, Boolean validarPorFechaEntrega){
		super();
		this.propertyAliasOrdenCompraEstado = propertyAliasOrdenCompraEstado;
		this.propertyAliasPedido = propertyAliasPedido;
		this.propertyAliasOrdenCompraDetalleEstado = propertyAliasOrdenCompraDetalleEstado;
		this.comparaCantidadEntrega = comparaCantidadEntrega;
		this.validarPorFechaEntrega = validarPorFechaEntrega;
	}
	
	@Override
	public Criterion getCriteriaRestriction() throws SICException {
		Junction junction = null;
		
		try {
			junction = Restrictions.conjunction();
			
			//estado original
			junction.add(Restrictions.eq(propertyAliasOrdenCompraEstado.concat(".codigoEstadoCatVal"), 
					SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENVIADA));
			
			//no se encuentre cerrada o cancelada
			DetachedCriteria subSelectOrdComEst = DetachedCriteria.forClass(OrdenCompraEstadoDTO.class, "ordenCompraEstadoSS");
			subSelectOrdComEst.setProjection(Projections.distinct(Projections.property("ordenCompraEstadoSS.codigoOrdenCompra")));
			subSelectOrdComEst.add(Restrictions.eqProperty(propertyAliasOrdenCompraEstado.concat(".codigoOrdenCompra"), "ordenCompraEstadoSS.codigoOrdenCompra"));
			subSelectOrdComEst.add(Restrictions.in("ordenCompraEstadoSS.codigoEstadoCatVal", new String[]{
					SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_CERRADA,
					SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_CANCELADA,
			}));
			junction.add(Subqueries.propertyCoalesce(propertyAliasOrdenCompraEstado.concat(".codigoOrdenCompra"), ComparatorTypeEnum.NOT_EQUAL_COMPARATOR, 0L, subSelectOrdComEst));
			
			//la fecha de caducidad no sea mayor al dia actual
			 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000000");
			 Long fechaSystem= System.currentTimeMillis();
			 Date fechaActual= new Date(fechaSystem);
			 String fechaActualString= formato.format(fechaActual);
			 Date fechaFormateada = formato.parse(fechaActualString);

			 
			 junction.add(Restrictions.ge(propertyAliasOrdenCompraEstado.concat("ordenCompra.fechaCaducidad"), fechaFormateada));
			 
			//La fecha de entrega no sea menor al dia actual
			if(validarPorFechaEntrega){
				junction.add(Restrictions.le(propertyAliasOrdenCompraEstado.concat("ordenCompra.fechaEntrega") , fechaFormateada));
			}	
			
			 /**
			//Restrictions.ge(propertyName, value)
			junction.add(Restrictions.ge(!propertyAliasPedido.equals(CriteriaSpecification.ROOT_ALIAS) ? propertyAliasPedido.concat(".fechaCaducidad") : "fechaCaducidad", 
					fechaFormateada));
			**/
			
			//no exceda el numero de entregas permitidas
			DetachedCriteria subSelectOrdComHisEstEnt = DetachedCriteria.forClass(OrdenCompraHistoricoEstadoDTO.class, "ordenCompraHistoricoEstado");
			subSelectOrdComHisEstEnt.setProjection(Projections.property("ordenCompraHistoricoEstado.cantidadEstado"));
			subSelectOrdComHisEstEnt.add(Restrictions.eqProperty(propertyAliasOrdenCompraEstado.concat(".codigoOrdenCompra"), "ordenCompraHistoricoEstado.id.codigoOrdenCompra"));
			subSelectOrdComHisEstEnt.add(Restrictions.eq("ordenCompraHistoricoEstado.id.codigoEstadoCatVal", 
					SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENTREGADA));
			junction.add(
					Restrictions.disjunction()
					.add(Restrictions.isNull(!propertyAliasPedido.equals(CriteriaSpecification.ROOT_ALIAS) ? propertyAliasPedido.concat(".numeroEntregasPermitidas") : "numeroEntregasPermitidas"))
					.add(Subqueries.propertyCoalesce(
							!propertyAliasPedido.equals(CriteriaSpecification.ROOT_ALIAS) ? propertyAliasPedido.concat(".numeroEntregasPermitidas") : "numeroEntregasPermitidas", 
							ComparatorTypeEnum.GREATER_THAN_COMPARATOR, 
							0, 
							subSelectOrdComHisEstEnt)));
			
			//exista diferencia entre cantidades pedidas y cantidades entregadas
			junction.add(
					Restrictions.disjunction()
					.add(
							Restrictions.conjunction()
							.add(Restrictions.gt(propertyAliasOrdenCompraDetalleEstado.concat(".pesoPedido"), 
									BigDecimal.ZERO))
							.add(Restrictions.gtProperty(propertyAliasOrdenCompraDetalleEstado.concat(".pesoPedido"), 
									propertyAliasOrdenCompraDetalleEstado.concat(comparaCantidadEntrega ? ".pesoEntregado" : ".pesoParcial")))
					)
					.add(
							Restrictions.conjunction()
							.add(Restrictions.gt(propertyAliasOrdenCompraDetalleEstado.concat(".cantidadPedida"), 0))
							.add(Restrictions.gtProperty(propertyAliasOrdenCompraDetalleEstado.concat(".cantidadPedida"), 
									propertyAliasOrdenCompraDetalleEstado.concat(comparaCantidadEntrega ? ".cantidadEntregada" : ".cantidadParcial")))
					));
			
		}catch(Exception e){
			throw new SICException("Se produjo un error al momento de armar la restriccion ordenes de compra por pedido");
		}
		
		return junction;
	}
	
}
